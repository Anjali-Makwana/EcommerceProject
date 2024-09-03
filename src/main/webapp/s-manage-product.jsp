<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.model.Product"%>
<%@page import="java.util.List"%>
<%@include file="s-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Product> list = ProductDao.getAllProductBySid(seller.getId());
	%>

	<section class="cart_area">
		<div class="container">
			<div class="cart_inner">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Product</th>
								<th scope="col">Price</th>
								<th scope="col">Product Category</th>
								<th scope="col">Product Description</th>
								<th scope="col">Edit Product</th>
								<th scope="col">Delete Product</th>
							</tr>
						</thead>
						<tbody>
						<%for(Product p:list){ %>
							<tr>
								<td>
									<div class="media">
										<div class="d-flex">
											<img src="images/<%=p.getProduct_image() %>" height="100" width="100">
										</div>
										<div class="media-body">
											<p><%=p.getProduct_name() %>e</p>
										</div>
									</div>
								</td>
								<td>
									<h5>Rs. <%=p.getProductPrice() %></h5>
								</td>
								<td>
									<h5><%=p.getProduct_category() %></h5>
								</td>
								<td>
									<h5><%=p.getProduct_description() %></h5>
								</td>
								<td>
									<h5><a href="s-single-product.jsp?pid=<%=p.getId()%>">Edit</a></h5>
								</td>
								<td>
									<h5><a href="s-delete-product.jsp?pid=<%=p.getId()%>">Delete</a></h5>
								</td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

</body>
</html>