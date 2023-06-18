<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Writer</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div id="addWritterModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addperson" method="get">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Writer</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>

                        <div class="modal-body">
                            <div class="form-group">
                                <label>Name</label>
                                <input  name="name" type="text" class="form-control"  required>
                            </div>
                            <div class="form-group">
                                <label>Date of birth</label>
                                <input  name="dob" type="date" class="form-control"  required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <input  name="address" type="text" class="form-control"  required>
                            </div>
                            <div class="form-group">
                                <label>Username</label>
                                <input  name="user" type="text" class="form-control"  required>
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input  name="pass" type="text" class="form-control" required>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <a class="btn btn-danger" href="managerwriter">Cancel</a>
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>