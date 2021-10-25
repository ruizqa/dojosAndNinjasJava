<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
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
              <a href="/ninjas/new" class="nav-link">New Ninja</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

<section class="py-5"></section>


<section>
	<div class="container">
		<div class="col-lg-6 offset-lg-3">
			<h1 class="text-center">New Dojo</h1>
			<form:form action="/dojos" method="post" modelAttribute="dojo" class="col">
			    <div class="form-group my-2">
			        <form:label path="name" class="form-label">Location</form:label>
			    </div>
			    <div class="form-group my-2">    
			        <form:errors path="name"/>
			        <form:input path="name" class="form-control"/>
			    </div>
			    
			    <div class="text-center">    
			    	<input class="btn btn-primary text-center my-2" type="submit" value="Submit"/>
			    </div>
			</form:form>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="col-lg-6 offset-lg-3">
		<h1 class="text-center my-3">All Dojos</h1>
		<table class="table table-hover table-striped text-center">
			<thead class="table-dark">
				<tr>
					<td>Location</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojos}" var="dojo">
					<tr>
						<td><c:out value="${dojo.name}"/></td>
				        <td><a href="/dojos/${dojo.id}">See Students</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</section>
</body>
</html>