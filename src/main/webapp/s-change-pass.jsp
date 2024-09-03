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
				<%String msg = (String)request.getAttribute("msg"); %>
				<%if(msg!=null){ %>
					<h4><%out.print(msg); %></h4>
				<%} %>
				<div class="col-lg-6">
					<div class="login_form_inner register_form_inner">
						<h3>Seller Profile</h3>
						<form class="row login_form" action="SellerController" id="register_form" method="post">
							<input type="hidden" name="id" value="<%=seller.getId()%>">
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="name" name="op"
									placeholder="Old Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="name" name="np"
									placeholder="New Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="name" name="cnp"
									placeholder="Confirm New Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
							</div>
							
							<div class="col-md-12 form-group">
								<button type="submit" value="password_update" name="action"
									class="button button-register w-100">Update Password</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>