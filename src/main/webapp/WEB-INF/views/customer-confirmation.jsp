<%-- 
    Document   : customer-confirmation
    Created on : 08-Aug-2020, 7:51:29 AM
    Author     : Surajit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer Confirmation</title>
    </head>
    <body>
        The customer is confirmed: ${customer.firstName} ${customer.lastName}
        <br><br> Free passes: ${customer.freePasses}
        <br><br> Email: ${customer.email}
        <br><br> Postal Code: ${customer.postalCode}
    </body>
</html>