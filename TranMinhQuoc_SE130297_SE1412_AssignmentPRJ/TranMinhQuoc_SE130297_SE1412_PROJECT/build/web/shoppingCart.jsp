<%-- 
    Document   : shoppingCart
    Created on : Jun 28, 2020, 2:05:28 PM
    Author     : SE130297
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping cart</title>
    </head>
    <body>
        <h1>Shopping market</h1>
        <form action="add_to_cart">
            <c:set var="listbook" value="${requestScope.BOOKSTORE}"/>
            <c:if test="${not empty listbook}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Book ID</th>
                            <th>Book Name</th>
                            <th>Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${listbook}">
                        <form action="add_to_cart">
                            <tr>
                                <tr>
                                <td>
                                    ${dto.bookID}          
                                </td>
                                <td>
                                    ${dto.bookName}  
                                    <input type="hidden" name="cboBook" value="${dto.bookName}" />
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    <input type="submit" value="Add book to Your Cart"/>                                       
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty listbook}">
                <h2>No Data</h2>
            </c:if>
            <!--            <input type="submit" value="View your cart" />-->
            <form action="view_cart_page">
                <input type="submit" value="View your cart" />
            </form>
        </form>
    </body>
</html>
