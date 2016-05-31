<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
    <title>Service</title>
    <meta charset="utf-8"/>
    <meta name="description" content="Sign In page">
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
        	<h3 id="blink">${informMessage}</h3>
        	<div class="messages">
        		<ul>
        			<li class="messageList">${discountAmountMessage}</li>
        			<li class="messageList">${discountAmount} %</li>
        			<li class="messageList">${uniqHashMessage}</li>
        			<li class="messageList">${uniqCode}</li>
        		</ul>
        	</div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
<c:remove var="errorMessage" scope="session"/>
<c:remove var="message" scope="session"/>

</html>