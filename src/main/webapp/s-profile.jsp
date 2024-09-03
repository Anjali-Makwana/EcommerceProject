<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@include file="s-header.jsp" %>
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
						<h3>Seller Profile</h3>
						<form class="row login_form" action="SellerController" id="register_form" method="post">
							<input type="hidden" name="id" value="<%=seller.getId()%>">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="name"
									value="<%=seller.getName() %>" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="contact"
									value="<%=seller.getContact() %>" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Contact'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="address"
									value="<%=seller.getAddres() %>" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Address'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="email" name="email"
									value="<%=seller.getEmail() %>" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Email Address'">
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="update" name="action"
									class="button button-register w-100">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>