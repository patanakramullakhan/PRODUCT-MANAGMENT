package com.akram.project;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId = request.getParameter("proId");
		String proName = request.getParameter("proName");
		
		double proPrice = Double.parseDouble(request.getParameter("proPrice"));
		String proBrand = request.getParameter("proBrand");
		String proMadeIn = request.getParameter("proMadeIn");
		
		Date proMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate = Date.valueOf(request.getParameter("proExpDate"));
		
		//Part part = request.getPart("proImage");
		//InputStream proImage = part.getInputStream();
			
		
		Product product  =new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		//product.setProImage(proImage);
		
		
	      	ProductDao dao = new ProductDao();
	     	
	 	    
		     Part newImagePart = request.getPart("proImage");
		     
		     if (newImagePart != null && newImagePart.getSize() > 0) {
		            product.setProImage(newImagePart.getInputStream());
		       }
		     else {
		        	 Product existingProduct = dao.getProductById(proId);
		        	
		            product.setProImage(existingProduct.getProImage());
		        }
		     
		     
		     
		    int uproduct = dao.update(product);
	
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listofproducts.jsp");
			dispatcher.forward(request, response);
			
		
		
		
	}

}
