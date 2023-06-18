<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Writer</title>
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
                            <h2><b>Writer Manager</b></h2>
                            <a href="add_writer.jsp"  class="btn btn-success">Add New Writer</a>
                            <p>
                            <form action="searchperson" method="post"  >
                                <div class="menu_box_2">
                                    <input name="txt" class="form_1" type="text" value="${txtSearch}" placeholder="Search...">
                                    <input type="submit" value="Ok">
                                </div>
                            </form>                             
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Name</th>
                            <th>Profile</th>
                            <th>View Posts</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="p">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td><a href="viewprofile?id=${p.id}">View</a></td>
                                <td><a href="viewwriternews?id=${p.id}">View</a></td>                         
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="home"><button type="button" class="btn btn-primary">Back to home</button>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>