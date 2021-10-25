<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo</title>
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
			<h1 class="text-center">Dojo <c:out value="${dojo.name}"/> Ninjas </h1>
			<table class="table table-hover table-striped text-center">
				<thead class="table-dark">
					<tr>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Age</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dojo.ninjas}" var="ninja">
						<tr>
							<td><c:out value="${ninja.firstName}"/></td>
					        <td><c:out value="${ninja.lastName}"/></td>
					        <td><c:out value="${ninja.age}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>
</body>
</html>