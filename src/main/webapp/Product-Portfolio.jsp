<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Portfolio</title>
</head>
<body>

<h1>Product Portfolio</h1>

<a href="${pageContext.request.contextPath}/home">← Back to Home</a>

<hr>

<c:if test="${empty products}">
    <p>No products found.</p>
</c:if>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Action</th>
    </tr>

    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.productID}</td>
            <td>${p.productName}</td>
            <td>${p.price}$</td>
            <td>${p.discount}%</td>
            <td>
                <a href="${pageContext.request.contextPath}/products/detail?id=${p.productID}">
                    View detail
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>