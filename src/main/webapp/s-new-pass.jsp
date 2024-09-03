<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<%String msg = (String)request.getAttribute("msg"); %>
				<%if(msg!=null){ %>
					<h3><%out.print(msg); %></h3>
				<%} %>
				<div class="col-lg-6">
					<div class="login_form_inner">
						<h3>New Password</h3>
						<form class="row login_form" action="SellerController" id="contactForm" method="post">
							<div class="col-md-12 form-group">
								<%String email = (String)request.getAttribute("email"); %>
								<input type="hidden" name="email" value="<%=email%>">
								<input type="text" class="form-control" id="name" name="np"
									placeholder="New Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
								<input type="text" class="form-control" id="name" name="cnp"
									placeholder="Confirm New Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'">
							</div>
							
							<div class="col-md-12 form-group">
								<button type="submit" value="np" name="action"
									class="button button-login w-100">Verify</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>