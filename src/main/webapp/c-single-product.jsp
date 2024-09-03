<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.model.Product"%>
<%@include file="c-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int pid = Integer.parseInt(request.getParameter("pid"));
	%>
	<%
	Product p = ProductDao.getProductByPid(pid);
	%>

	<section class="blog-banner-area" id="blog">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>Shop Single</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Shop
								Single</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>


	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<img class="img-fluid" src="images/<%=p.getProduct_image() %>">
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3><%=p.getProduct_name() %></h3>
						<h2>Rs. <%=p.getProductPrice() %></h2>
						<ul class="list">
							<li><a class="active" href="#"><span>Category</span> :
									<%=p.getProduct_category() %></a></li>
							<li><a href="#"><span>Availibility</span> : In Stock</a></li>
						</ul>
						<p><%=p.getProduct_description() %></p>
						<div class="product_count">
							<a class="button primary-btn" href="WishListController?action=addToWishList&pid=<%=p.getId()%>&cid=<%=customer.getId()%>">Add to wishlist</a>
						</div>
						<div class="product_count">
							<a class="button primary-btn" href="CartController?action=addToCartlist&pid=<%=p.getId()%>&cid=<%=customer.getId()%>">Add to Cart</a>
						</div>
						<div class="card_area d-flex align-items-center">
							<a class="icon_btn" href="#"><i class="lnr lnr lnr-diamond"></i></a>
							<a class="icon_btn" href="#"><i class="lnr lnr lnr-heart"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>