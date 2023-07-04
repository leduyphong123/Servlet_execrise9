<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet" />
    <style>
        .content{
            margin-top: 15em;
        }
    </style>
</head>

<body>
<div class="row px-5 header align-items-center bg-light fixed-top shadow-sm">
    <div class="text-center text-danger h1">Simple Caculator</div>
</div>
<div class="container content">
    <div class="row justify-content-center">
        <div class="col-5 border border-primary shadow p-3 mb-5 bg-body rounded fill-form-register p-5">
            <form action="/caculator" method="get">
                <div class="form-outline mt-4">
                    <input type="text" id="firt" name="firt" class="form-control" />
                    <label class="form-label" for="firt">Firt operand</label>
                </div>
                <div class="form-outline mt-3">
                    <input type="text" id="second" name="second" class="form-control" />
                    <label class="form-label" for="second">Second operand</label>
                </div>
                <div class="form-outline mt-3">
                    <select class="browser-default custom-select" name="operator">
                        <option selected>Operator</option>
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select>
                </div>
                <div class="button-submit text-center mt-3"><button type="submit"
                                                                    class="btn btn-primary btn-rounded mt-3 ">Caculator</button></div>
            </form>
        </div>
    </div>
</div>
<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>

</html>