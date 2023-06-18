<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Post New Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div id="addNewModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addnew" method="get">
                        <div class="modal-header">						
                            <h4 class="modal-title">Post New</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" href="home">&times;</button>
                        </div>

                        <div class="modal-body">					
                            <div class="form-group">
                                <input placeholder="Ttile" name="name" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <input placeholder="Image" name="image" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <input placeholder="Header" name="title" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <textarea placeholder="Content" name="content" class="form-control" required></textarea>
                            </div>

                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listC}" var="c">                                   
                                        <option value="${c.cid}"> ${c.cname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <a class="btn btn-danger" href="home">Cancel</a>
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div> 
    </body>
</html>
