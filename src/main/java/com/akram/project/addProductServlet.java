package com.akram.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/addProductServlet")
@MultipartConfig
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId = request.getParameter("proId");
		String proName = request.getParameter("proName");
		
		double proPrice = Double.parseDouble(request.getParameter("proPrice"));
		String proBrand = request.getParameter("proBrand");
		String proMadeIn = request.getParameter("proMadeIn");
		
		Date proMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate = Date.valueOf(request.getParameter("proExpDate"));
		
		Part part = request.getPart("proImage");
		InputStream proImage = part.getInputStream();
		
		
		Product product  =new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		product.setProImage(proImage);
		
		
		ProductDao dao = new ProductDao();
		int saveResult = dao.saveProduct(product);
		
		if(saveResult==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("listofproducts.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			PrintWriter writer = response.getWriter();
			writer.println("please check once.....");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
			dispatcher.include(request, response);
		}
		
		
		
	}

}
