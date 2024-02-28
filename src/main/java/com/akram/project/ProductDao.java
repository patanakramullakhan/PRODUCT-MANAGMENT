package com.akram.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	public int saveProduct(Product product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int saveResult=0;
		
		try {
			connection = DatabaseUtils.createConnection();
			preparedStatement = connection.prepareStatement("insert into productsir values (?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement.setBinaryStream(8, product.getProImage() );
			saveResult=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(connection!=null) {
					connection.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return saveResult;
		
	}
	
	//list of data
	
	public List<Product> listOfData(){
		
		Connection connection = null;
		Statement statement = null;
		
		List<Product> products = new ArrayList<Product>();
		try {
			connection= DatabaseUtils.createConnection();
			statement = connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select*from productsir");
			while(resultSet.next()) {
				Product product  =new Product();
				product.setProId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProMfgDate(resultSet.getDate(6));
				product.setProExpDate(resultSet.getDate(7));
				product.setProImage(resultSet.getBinaryStream(8));
				
				products.add(product);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			
			try {
				
				if(statement!=null) {
					statement.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return products;
		
		
	}
	
	
	//delete
	
	public int deletebyProId(Product product) {
	
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		int deleteResult=0;
		try {
			connection=DatabaseUtils.createConnection();
			preparedStatement=connection.prepareStatement("delete from productsir where proId=?");
			preparedStatement.setString(1, product.getProId());
			deleteResult=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(connection!=null) {
					connection.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return deleteResult;
		
	}
	
	
	//edit
	public Product getProductById(String proId) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Product product = null;
		
		try {
			connection=DatabaseUtils.createConnection();
			preparedStatement= connection.prepareStatement("select * from productsir where proId=?");
			preparedStatement.setString(1, proId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				product=new Product();
				product.setProId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProMfgDate(resultSet.getDate(6));
				product.setProExpDate(resultSet.getDate(7));
				product.setProImage(resultSet.getBinaryStream(8));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
			
		return product;
		
	}
	
	
	
	
	
	
	//update
	public int update(Product uproduct) {
		
		
		System.out.println("sai is deceloper");
		
		Connection connection = DatabaseUtils.createConnection();
		int updateResult = 0;
		try{
			PreparedStatement preparedStatement  = connection.prepareStatement("update productsir set proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpDate=?,proImage=? where proId=?");
			
			preparedStatement.setString(1, uproduct.getProName());
			preparedStatement.setDouble(2, uproduct.getProPrice());
			preparedStatement.setString(3, uproduct.getProBrand());
			preparedStatement.setString(4, uproduct.getProMadeIn());
			preparedStatement.setDate(5, uproduct.getProMfgDate());
			preparedStatement.setDate(6, uproduct.getProExpDate());
			preparedStatement.setBinaryStream(7, uproduct.getProImage() );
			
			preparedStatement.setString(8, uproduct.getProId());
			updateResult=preparedStatement.executeUpdate();
		
		
		
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(uproduct);
		return updateResult;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
