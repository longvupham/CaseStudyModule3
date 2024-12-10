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
    <title>Danh sách thuốc</title>
</head>
<body>
<h1>Danh sách thuốc</h1>
<a href="medicines/medicine-form" class="button">Thêm thuốc mới</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Nhà sản xuất</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="medicine" items="${medicines}">
        <tr>
            <td>${medicine.id}</td>
            <td>${medicine.name}</td>
            <td>${medicine.manufacturer}</td>
            <td>${medicine.price}</td>
            <td>${medicine.stock}</td>
            <td>
                <a href="medicines/medicine-form?id=${medicine.id}" class="button">Sửa</a>
                <a href="medicines/delete?id=${medicine.id}" class="button">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
