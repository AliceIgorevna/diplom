<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8"/>
    <meta name="description" content="Register page">
    <link rel="dress icon" href="resources/images/icon_dress.ico"/>
    <%@ include file="/WEB-INF/jspf/meta.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div id="main">
    <div id="container">
        <div class="vertical-sidebar">
            <div id="navigation">
                <ul class="vertical-list">
                    <li><a href="index.html" class="item"> Home </a></li>
                    <li><a href="about" class="item"> About </a></li>
                    <c:if test="${not empty loggedUser.idUserData}">
                        <li><a href="products" class="item"> Service </a></li>
                    </c:if>
                    <li><a href="projects" class="item"> Project </a></li>
                </ul>
            </div>
        </div>
        <div class="content">
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-dismissible alert-danger">
                    ${errorMessage}
                </div>

            </c:if>
            <form action="RegistrationServlet" name="registerForm" class="forms" method="post">
                <div>
                    <div class="label-left">
                        <label>Enter email:</label>
                        <label>Enter password:</label>
                        <label>Confirm password:</label>
                        <label>Birth date:</label>
                    </div>
                    <div class="input-right">
                        <input name="email" type="email" autofocus="autofocus" placeholder="Example@mail.com"/>
                        <input type="password" name="password" placeholder="Type your password"/>
                        <input type="password" name="confirmPassword" placeholder="Confirm your password"/>
                        <input type="date" name="birthDate"/>
                    </div>
                </div>

                <p><input type="submit" value="Submit"></p>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
<c:remove var="errorMessage" scope="session"/>
<c:remove var="message" scope="session"/>
</html>
