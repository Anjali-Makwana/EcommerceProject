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
					<div class="login_form_inner">
						<h3>Admin Login</h3>
						<form class="row login_form" action="AdminLoginServlet" id="contactForm" method="post">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="email" name="email"
									placeholder="Username" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="password" name="password"
									placeholder="Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Password'">
							</div>
							
							<div class="col-md-12 form-group">
								<button type="submit" value="adminLogin" name="action"
									class="button button-login w-100">Log In</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>