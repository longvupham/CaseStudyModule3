<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trang Quản Lý Nhà Thuốc</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      text-align: center;
      margin-top: 50px;
    }
    .button {
      display: inline-block;
      padding: 10px 20px;
      margin: 10px;
      background-color: #4CAF50;
      color: white;
      text-decoration: none;
      border-radius: 5px;
      font-size: 16px;
    }
    .button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

<h1>Chào mừng bạn đến với Quản Lý Nhà Thuốc</h1>
<p>Hãy chọn chức năng bạn muốn sử dụng:</p>

<a href="medicines/list" class="button">Xem Danh Sách Thuốc</a>
<a href="medicines/medicine-form" class="button">Thêm Mới Thuốc</a>

</body>
</html>