<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Product Saved Successfully</title>
</head>
<body>
<h3>
	Product Saved Successfully.
</h3>

<strong>Product ID:${product.id}</strong><br>
<strong>Product Name:${product.name}</strong><br>
<strong>Product Role:${product.type}</strong><br>

</body>
</html>
