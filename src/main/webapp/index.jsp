<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h1>Welcome to Product Website</h1>

<nav>
    <a href="${pageContext.request.contextPath}/home">Home</a> |
    <a href="${pageContext.request.contextPath}/products">Products</a> |
    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
</nav>

<hr>

<h2>Featured Products</h2>

<c:if test="${empty featuredProducts}">
    <p>No products available.</p>
</c:if>

<ul>
    <c:forEach var="p" items="${featuredProducts}">
        <li>
            <a href="${pageContext.request.contextPath}/products/detail?id=${p.productID}">
                ${p.productName}
            </a>
            - ${p.price}$
        </li>
    </c:forEach>
</ul>

</body>
</html>