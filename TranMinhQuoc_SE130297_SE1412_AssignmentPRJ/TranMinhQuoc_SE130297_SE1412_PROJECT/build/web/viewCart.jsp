<%-- 
    Document   : viewCart
    Created on : Jul 11, 2020, 11:19:36 PM
    Author     : SE130297
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <h1>View your cart</h1>
        <form action="remove_book">
            <c:set var="items" value="${sessionScope.CART.items}" />
            <c:if test="${not empty items}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Book Name</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="result" items="${items}" varStatus="counter">   
                        <form action="remove_book">
                            <tr>
                                <td>
                                    ${counter.count}
                                    .</td>
                                <td>
                                    ${result.key}        
                                </td>
                                <td>
                                    ${result.value}
                                </td>
                                <td>
                                    <input type="checkbox" name="chkItem" value="${result.key}"/>
                                </td>
                            </tr>
                    </c:forEach>
                                                    
                    <td colspan="3">
                        <a href="book_market">Add more Books to Your Cart</a>
                    </td>
                    <td>
                        <input type="submit" value="Remove Selected Books" />
                    </td>
                    </form>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty items}">
                <h2> 
                    No Cart is existed!!!
                </h2>
            </c:if> 
        </form>
        <a href="book_market">Go back to shopping</a>
    </body>
</html>
