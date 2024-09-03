<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.project.dao.CartDao"%>
<%@page import="com.project.model.Cart"%>
<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.model.Product"%>
<%@page import="java.util.List"%>
<%@include file="c-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Cart> list = CartDao.getCartListByCusId(customer.getId());
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
								<th scope="col">Remove Product</th>
							</tr>
						</thead>
						<tbody>
						<%for(Cart c:list){ %>
						<%int pid = c.getProductId(); %>
						<%Product p = ProductDao.getProductByPid(pid); %>
							<tr>
								<td>
									<div class="media">
										<div class="d-flex">
											<img src="images/<%=p.getProduct_image() %>" height="100" width="100">
										</div>
										<div class="media-body">
											<p><%=p.getProduct_image() %>e</p>
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
									<h5><a href="CartController?pid=<%=p.getId()%>&cid=<%=customer.getId()%>&action=removeFromCart">Remove</a></h5>
								</td>
								
							</tr>
							<%} %>
						</tbody>
					</table>
					  <form action="checkout" method="post">
				        <input type="submit" value="Checkout">
				    </form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>