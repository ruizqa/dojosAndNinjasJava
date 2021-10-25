<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand">Dojos and Ninjas Core Assignment</a>

        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navmenu"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navmenu">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <a href="/dojos/new" class="nav-link">Dashboard</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

<section class="py-5"></section>
<section>
	<div class="container">
		<div class="col-lg-6 offset-lg-3">
			<h1 class="text-center text-primary">New Ninja</h1>
			<form:form action="/ninjas" method="post" modelAttribute="ninja" class="col">
			    
			    <div class="form-group my-2">
			        <form:label path="dojo" class="form-label">Dojo</form:label>
			    </div>
			
				<div class="form-group my-2">
			        <form:select path="dojo_id" class="form-select">
					    <c:forEach var="dojo" items="${dojos}" >
					        <form:option value="${dojo.id}" label="${dojo.name}"/>
					    </c:forEach>
					</form:select>
			    </div>

			
			    <div class="form-group my-2">
			        <form:label path="firstName" class="form-label">First Name</form:label>
			    </div>
			    <div class="form-group my-2">    
			        <form:errors path="firstName"/>
			        <form:input path="firstName" class="form-control"/>
			    </div>
			    
			    <div class="form-group my-2">
			        <form:label path="lastName" class="form-label">Last Name</form:label>
			    </div>
			    <div class="form-group my-2">    
			        <form:errors path="lastName"/>
			        <form:input path="lastName" class="form-control"/>
			    </div>
			    
			    <div class="form-group my-2">
			        <form:label path="age" class="form-label">Age</form:label>
			    </div>
			    
			    <div class="form-group my-2">
			        <form:errors  path="age"/>
			        <form:input path="age" class="form-control"/>
			    </div>
			    
			    <div class="text-center">    
			    	<input class="btn btn-primary text-center my-2" type="submit" value="Create"/>
			    </div>
			</form:form>
		</div>
	</div>
</section>
</body>
</html>