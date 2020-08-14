<%-- 
    Document   : creatNewAccount
    Created on : Jul 6, 2020, 12:52:19 PM
    Author     : SE130297
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account Page</title>
    </head>
    <body>
        <h1>Create new Account</h1>
        <form action="sign_up_account" method="POST">
            <c:set var="error" value="${requestScope.CREATE_ERROR}" />
            Username :<input type="text" name="txtUsername" value="" /> (6 - 20 characters) <br />
            <c:if test="${not empty error.usernameLengthErr}">
                <font color = "red">
                ${error.usernameLengthErr}<br />
                </font>
            </c:if>
            Password :<input type="password" name="txtPassword" value="" /> (6 - 20 characters)<br />
            <c:if test="${not empty error.passwordLengthErr}">
                <font color = "red">
                ${error.passwordLengthErr}<br />
                </font>
            </c:if>
            Confirm Password :  <input type="password" name="txtConfirmPassword" value="" /> (6 - 20 characters)<br />
            <c:if test="${not empty error.confirmPasswordNoMatch}">
                <font color = "red">
                ${error.confirmPasswordNoMatch}<br />
                </font>
            </c:if>
            Full name :         <input type="text" name="txtLastname" value="" /> (6 - 30 characters)<br />
            <c:if test="${not empty error.lastnameLengthErr}">
                <font color = "red">
                ${error.lastnameLengthErr}<br />
                </font>
            </c:if>
            <input type="submit" value="OK" />
            <input type="reset" value="Reset" />
            <c:if test="${not empty error.usernameIsExisted}">
                <font color = "red">
                <br />${error.usernameIsExisted}
                </font>
            </c:if>
        </form>
    </body>
</html>
