<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<main class="site-main">

		<section class="hero-banner">
			<div class="container">
				<div class="row no-gutters align-items-center pt-60px">
					<div class="col-5 d-none d-sm-block">
						<div class="hero-banner__img">
							<img class="img-fluid" src="img/home/hero-banner.png" alt>
						</div>
					</div>
					<div class="col-sm-7 col-lg-6 offset-lg-1 pl-4 pl-md-5 pl-lg-0">
						<div class="hero-banner__content">
							<h4>Shop is fun</h4>
							<h1>Browse Our Premium Product</h1>
							<p>Us which over of signs divide dominion deep fill bring
								they're meat beho upon own earth without morning over third.
								Their male dry. They are great appear whose land fly grass.</p>
							<a class="button button-hero" href="#">Browse Now</a>
						</div>
					</div>
				</div>
			</div>
		</section>


		<section class="section-margin mt-0">
			<div class="owl-carousel owl-theme hero-carousel">
				<div class="hero-carousel__slide">
					<img src="img/home/hero-slide1.png" alt class="img-fluid"> <a
						href="#" class="hero-carousel__slideOverlay">
						<h3>Wireless Headphone</h3>
						<p>Accessories Item</p>
					</a>
				</div>
				<div class="hero-carousel__slide">
					<img src="img/home/hero-slide2.png" alt class="img-fluid"> <a
						href="#" class="hero-carousel__slideOverlay">
						<h3>Wireless Headphone</h3>
						<p>Accessories Item</p>
					</a>
				</div>
				<div class="hero-carousel__slide">
					<img src="img/home/hero-slide3.png" alt class="img-fluid"> <a
						href="#" class="hero-carousel__slideOverlay">
						<h3>Wireless Headphone</h3>
						<p>Accessories Item</p>
					</a>
				</div>
			</div>
		</section>


		<section class="section-margin calc-60px">
			<div class="container">
				<div class="section-intro pb-60px">
					<p>Popular Item in the market</p>
					<h2>
						Trending <span class="section-intro__style">Product</span>
					</h2>
				</div>
				<div class="row">
				<%List<Product> list = ProductDao.getAllProdcuts();	%>
				<%for(Product p:list){ %>
					<div class="col-md-6 col-lg-4 col-xl-3">
						<div class="card text-center card-product">
							<div class="card-product__img">
								<img class="card-img" src="images/<%=p.getProduct_image() %>" height="200" width="100">
								<ul class="card-product__imgOverlay">
									<li><button>
											<i class="ti-search"></i>
										</button></li>
									<li><button>
											<i class="ti-shopping-cart"></i>
										</button></li>
									<li><button>
											<i class="ti-heart"></i>
										</button></li>
								</ul>
							</div>
							<div class="card-body">
								<p><%=p.getProduct_category() %></p>
								<h4 class="card-product__title">
									<a href="c-single-product.jsp?pid=<%=p.getId()%>"><%=p.getProduct_name() %></a>
								</h4>
								<p class="card-product__price">Rs. <%=p.getProductPrice() %></p>
							</div>
						</div>
					</div>
					<%} %>
			
				</div>
			</div>
		</section>


	</main>
</body>
</html>