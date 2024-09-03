package com.project.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.project.dao.ProductDao;
import com.project.model.Product;

@WebServlet("/ProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024 * 512)
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    System.out.println(cd);
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("upload")) {
			String savePath = "C:\\Users\\Anjali Makwana\\eclipse-workspace\\EcommerceProject\\src\\main\\webapp\\images";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
			String savePath2 = "C:\\Users\\Anjali Makwana\\eclipse-workspace\\EcommerceProject\\src\\main\\webapp\\images";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        Product p = new Product();
	        p.setSellerId(Integer.parseInt(request.getParameter("sid")));
	        p.setProduct_image(fileName);
	        p.setProduct_name(request.getParameter("pname"));
	        p.setProductPrice(Integer.parseInt(request.getParameter("pprice")));
	        p.setProduct_category(request.getParameter("pcategory"));
	        p.setProduct_description(request.getParameter("pdesc"));
	        
	        ProductDao.uploadProduct(p);
	        response.sendRedirect("s-home.jsp");
		}
		else if(action.equalsIgnoreCase("update")) {
			String savePath = "C:\\Users\\Anjali Makwana\\eclipse-workspace\\EcommerceProject\\src\\main\\webapp\\images";
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName;
		    
			String savePath2 = "C:\\Users\\Anjali Makwana\\eclipse-workspace\\EcommerceProject\\src\\main\\webapp\\images";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        Product p = new Product();
	       	p.setId(Integer.parseInt(request.getParameter("pid")));
	        p.setSellerId(Integer.parseInt(request.getParameter("sid")));
	        p.setProduct_image(fileName);
	        p.setProduct_name(request.getParameter("pname"));
	        p.setProductPrice(Integer.parseInt(request.getParameter("pprice")));
	        p.setProduct_category(request.getParameter("pcategory"));
	        p.setProduct_description(request.getParameter("pdesc"));
	        ProductDao.updateProduct(p);
	        response.sendRedirect("s-manage-product.jsp");
		}
		
	}
}