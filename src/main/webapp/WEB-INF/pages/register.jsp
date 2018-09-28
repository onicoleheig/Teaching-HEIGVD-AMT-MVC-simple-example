<%--
  Created by IntelliJ IDEA.
  User: olivier
  Date: 28.09.18
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col col-lg-4">
                    <form method="POST" action="register">
                        <div class="form-group">
                            <label for="firstname">First name:</label>
                            <input type="text" class="form-control" name="firstname" id="firstname" placeholder="First name">
                        </div>
                        <c:if test="${not empty error_firstname}">
                            ${error_firstname}
                        </c:if>
                        <div class="form-group">
                            <label for="lastname">Last name:</label>
                            <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Last name">
                        </div>
                        <c:if test="${not empty error_lastname}">
                            ${error_lastname}
                        </c:if>
                        <div class="form-group">
                            <label for="email">E-mail:</label>
                            <input type="text" class="form-control" name="email" id="email" placeholder="E-mail">
                        </div>
                        <c:if test="${not empty error_email}">
                            ${error_email}<br/>
                        </c:if>
                        <button class="btn btn-primary" type="submit">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
