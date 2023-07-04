<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View</title>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet"/>
</head>

<body>
<%! List<String[]> arr = new ArrayList<>();
    String[] object1 = {"Mai Văn Hòa", "1983-08-20", "Hà Nội", "https://mdbcdn.b-cdn.net/img/new/standard/city/047.webp"};
    String[] object2 = {"Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://mdbcdn.b-cdn.net/img/new/standard/city/047.webp"};
    String[] object3 = {"Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://mdbcdn.b-cdn.net/img/new/standard/city/047.webp"};
    String[] object4 = {"Trần Đăng Khoa", "1983-08-23", "Hà Tây", "https://mdbcdn.b-cdn.net/img/new/standard/city/047.webp"};
    String[] object5 = {"Nguyễn Đình Thi", "1983-08-24", "Hà Nội", "https://mdbcdn.b-cdn.net/img/new/standard/city/047.webp"};

%>
<%
    arr.add(object1);
    arr.add(object2);
    arr.add(object3);
    arr.add(object4);
    arr.add(object5);
    request.setAttribute("result",arr);
%>
<div class="container">
    <h1 class="text-center my-5">Danh sách khách hàng</h1>
    <table class="table align-middle mb-0 bg-white">
        <thead class="bg-light">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" begin="0" end="4">
            <tr>
                <td>
                        ${result.get(i)[0]}
                </td>
                <td>
                    <p>${result.get(i)[1]}</p>
                </td>
                <td>
                    <p>${result.get(i)[2]}</p>
                </td>
                <td>
                    <img src="${result.get(i)[3]}" class="img-fluid rounded "
                         style="width: 10em;" alt="Townhouses and Skyscrapers"/>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>

</html>