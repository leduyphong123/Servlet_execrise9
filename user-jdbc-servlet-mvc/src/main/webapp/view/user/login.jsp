<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="index.css">

    <style>
        .header {
            height: 6em;
        }

        .content {
            margin-top: 8em;
        }

        body {
            margin: 0;
            padding: 0;
        }

        img {
            height: 21.9em;
        }

        .fill-form-register {
            height: 26em;
            border-radius: 20px;

        }

        .button-submit {

        }
    </style>
</head>

<body>

<div class="row px-5 header align-items-center bg-light fixed-top shadow-sm">
    <div class="text-center text-danger h1">Login Page</div>
</div>
<div class="container content">
    <div class="row justify-content-center">
        <div class="col-5 border border-primary shadow p-3 mb-5 bg-body rounded fill-form-register p-5">

            <c:if test="${messenger==false}">
                <div class="alert" role="alert" data-mdb-color="primary">
                    login error;
                </div>
            </c:if>
            <form action="/login" method="post">
                <div class="form-outline mt-3">
                    <input type="email" id="email" name="email" class="form-control"/>
                    <label class="form-label" for="email">Email</label>
                </div>
                <div class="form-outline mt-3">
                    <input type="password" id="password" name="password" class="form-control"/>
                    <label class="form-label" for="password">Password</label>
                </div>
                <div class="button-submit text-center mt-3">
                    <button type="submit" class="btn btn-primary btn-rounded mt-3 ">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>

</html>