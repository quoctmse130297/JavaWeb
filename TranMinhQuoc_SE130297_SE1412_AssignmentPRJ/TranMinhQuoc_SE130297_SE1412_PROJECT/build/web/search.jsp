<%-- 
    Document   : search
    Created on : Jun 28, 2020, 2:05:41 PM
    Author     : SE130297
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <c:set var ="error" value="${requestScope.ERROR_UPDATE}" />
        <c:set var ="errors" value="${requestScope.DELETE_ERROR}" />
        <c:set var = "us" value="${sessionScope.USER.lastname}" />
        <c:if test ="${not empty us}">
            <h1>Search Page</h1>
            <font color="red">
            Welcome, ${sessionScope.USER.lastname} <br/>
            </font>
            <form action = "logout">
                <input type="submit" value="Logout" /><br/>
            </form><br/>
            <form action = "search_servlet">
                Search Last Name <input type="text" name="txtSearchLastName" value="${param.txtSearchLastName}" />
                <input type="submit" value="Search" /><br/>
            </form><br/>
            <c:set var ="searchValue" value = "${param.txtSearchLastName}" />
            <c:if test="${not empty searchValue}">
                <c:set var="result" value="${requestScope.SEARCHRESULT}" />
                <c:if test = "${not empty result}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Last name</th>
                                <th>Admin</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var = "dto" items ="${result}" varStatus="counter">
                            <form action = "updateAccount">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.username}
                                        <input type="hidden" name="txtUsername" value="${dto.username}" />
                                    </td>
                                    <td>
                                        <!--${dto.password}-->
                                        <input type="text" name="txtPassword" value="${dto.password}" />

                                    </td>
                                    <td>
                                        ${dto.lastname}
                                        <input type="hidden" name="txtLastname" value="${dto.lastname}" />
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkAdmin" value="ON"
                                               <c:if test="${dto.isAdmin}">
                                                   checked = "checked"
                                               </c:if>
                                               />
                                    </td>
                                    <td>
                                        <c:url var = "urlRewriting" value ="deleteAccount">
                                            <c:param name ="btAction" value="Delete"/>
                                            <c:param name ="pk" value="${dto.username}"/>
                                            <c:param name = "lastSearchValue" value = "${searchValue}" />
                                            <c:param name = "nameLogin" value = "${sessionScope.USER.username}"/>
                                        </c:url>
                                        <a href="${urlRewriting}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update"/>
                                        <input type="hidden" value="${searchValue}" name="lastSearchValue" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        <c:if test="${not empty error.passwordLengthErr}">
                            <font color ="red">
                            ${error.passwordLengthErr}<br />
                            </font>
                        </c:if>
                        <c:if test="${not empty errors.UsernameNotDelete}">
                            <font color ="red">
                            ${error.UsernameNotDelete}<br />
                            </font>
                        </c:if>
                    </tbody>
                </table>   

            </c:if>
            <c:if test = "${empty result}">
                <h2>Not found</h2>
            </c:if>
        </c:if>
    </c:if>
    <c:if test="${empty us}">
        <c:redirect url="login.html" />
    </c:if>
</body>
</html>
