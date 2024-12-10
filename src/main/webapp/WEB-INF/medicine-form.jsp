<%--
  Created by IntelliJ IDEA.
  User: pplvu
  Date: 12/7/2024
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm/Sửa thuốc</title>
</head>
<body>
<h1>${medicine == null ? "Thêm thuốc mới" : "Sửa thông tin thuốc"}</h1>
<form action="${medicine == null ? 'add' : 'update'}" method="post">
    <input type="hidden" name="id" value="${medicine != null ? medicine.id : ''}">
    <label>Tên:</label>
    <input type="text" name="name" value="${medicine != null ? medicine.name : ''}"><br>
    <label>Nhà sản xuất:</label>
    <input type="text" name="manufacturer" value="${medicine != null ? medicine.manufacturer : ''}"><br>
    <label>Giá:</label>
    <input type="text" name="price" value="${medicine != null ? medicine.price : ''}"><br>
    <label>Số lượng:</label>
    <input type="text" name="stock" value="${medicine != null ? medicine.stock : ''}"><br>
    <button type="submit">${medicine == null ? "Thêm" : "Cập nhật"}</button>
</form>
</body>
</html>