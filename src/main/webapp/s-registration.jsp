<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<section class="login_box_area section-margin">
		<div class="container">
			<div class="row">
			
				<div class="col-lg-6">
					<div class="login_form_inner register_form_inner">
						<h3>Create an account As Seller</h3>
						<form class="row login_form" action="SellerController" id="register_form" method="post">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="name"
									placeholder="Username" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="contact"
									placeholder="Contact" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Contact'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="address"
									placeholder="Address" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Address'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="email" name="email"
									placeholder="Email Address" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Email Address'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="password"
									name="password" placeholder="Password"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Password'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="confirmPassword"
									name="confirmPassword" placeholder="Confirm Password"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Confirm Password'">
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="register" name="action"
									class="button button-register w-100">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>