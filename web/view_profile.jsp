<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Profile</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>

    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2> <b> Profile</b></h2>
                            <a class = "btn btn-primary" href="home"> Back to home</a>                  
                        </div>

                        <div class="col-sm-6">
                            <a href="#"   > </a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>birth day</th>
                            <th>address</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.name}</td>
                            <td>${p.dob}</td>
                            <td>${p.address}</td>                   
                        </tr>
                    </tbody>
                </table>
                <c:if test="${sessionScope.acc.id == p.id}">
                    <a href="loadprofile?id=${p.id}"><button class = "btn btn-success">Update Profile</button></a>                   
                </c:if>

            </div>

        </div>
        <!-- Edit Modal HTML -->



        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>