<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
	<title>Sign In</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link href="/resources/css/styles.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
	<div class="header-panel text-center"><h1>Differences Generator</h1></div>
	<div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2">
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">
				Invalid Username and Password.
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="alert alert-info">
				You have been logged out.
			</div>
		</c:if>
	</div>

	<div class="row">
		<div class="col-lg-7 col-lg-offset-5 col-md-10
	col-sm-12 col-sm-offset-4 col-xs-6 col-xs-offset-2">

			<div class="row">
				<div class="col-md-2 col-md-offset-8 col-sm-2 col-sm-offset-6 col-xs-1 col-xs-offset-11">
					<button class="btn btn-success" data-toggle="modal" data-target="#regModal">Sign Up</button>
				</div>
			</div>

			<form:form id="loginForm" method="post" action="/login" modelAttribute="user"
					   class="form-horizontal" role="form">
				<h3 class="col-lg-offset-1 col-md-offset-1
			col-sm-offset-1 col-xs-12">Sign In</h3>
				<div class="form-group">
					<div class="col-sm-4">
						<input type="text" id="username" name="username" class="form-control" placeholder="Email" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-4 col-xs-12">
						<input type="password" id="password" name="password" class="form-control" placeholder="Password" required/>
					</div>
				</div>
				<div class="form-group btn-block">
					<div class="col-sm-4 col-xs-10">
						<button type="submit" class="btn btn-primary">Sign In</button>
					</div>
				</div>
			</form:form>

			<div class="modal fade" id="regModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<%--Modal Header--%>
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times</button>
							<h2 class="text-center">Sign Up</h2>
						</div>
						<%--Modal Body--%>
						<div class="modal-body">
							<form:form id="regForm" class="form col-md-12 center-block" modelAttribute="user"
									   role="form">
								<div class="form-group">
									<input id="remail" type="text" class="form-control input-md reg" placeholder="Enter your email" required/>
								</div>
								<div class="form-group">
									<input id="rusername" type="text" class="form-control input-md reg" placeholder="Enter your name"/>
								</div>
								<div class="form-group">
									<input id="rpassword" type="password" class="form-control input-md reg" placeholder="Enter your password" required/>
								</div>
								<div class="form-group">
									<input id="rpassword2" type="password" class="form-control input-md reg" placeholder="Confirm your password" required/>
								</div>
								<div class="form-group">
									<button id="signUp" type="submit" class="btn btn-success" onclick="registration()">Sign Up</button>
									<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
								</div>
							</form:form>
						</div>
						<div class="modal-footer"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="/resources/jquery/jquery-1.10.2.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/resources/js/app.js"></script>
</body>
</html>