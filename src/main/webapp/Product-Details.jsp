<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/products">← Back to Products</a>

<hr>

<c:if test="${product == null}">
    <h2>Product not found</h2>
</c:if>

<c:if test="${product != null}">
    <h1>${product.productName}</h1>

    <p><b>ID:</b> ${product.productID}</p>
    <p><b>Price:</b> ${product.price}$</p>
    <p><b>Discount:</b> ${product.discount}%</p>
    <p><b>Unit:</b> ${product.unit}</p>
    <p><b>Description:</b></p>
    <p>${product.brief}</p>
</c:if>

</body>
</html>