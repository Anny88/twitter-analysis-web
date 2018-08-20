<%-- 
    Document   : index
    Created on : 19.05.2018, 20:33:24
    Author     : Anna
--%>
<%@page import ="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Twitter tags</title>
    </head>
    <% Date date = new Date(); %>
    <body>
        <h1>Let's find out something!</h1>
        <p> Today's date is <%= date %></p>
        <form name="myForm" action="display.jsp" method="POST">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td>Enter a tag or keyword to search : </td>
                        <td><input type="text" name="tag" value="" size="50" /></td>
                    </tr>
                    
                    <tr>    
                        <td>Amount of tweets : </td>
                        <td><select name="amount">
                                <option>100</option>
                                <option>200</option>
                                <option>300</option>
                                <option>400</option>
                                <option>500</option>
                                <option>600</option>
                            </select></td>
                    </tr>
                    
                </tbody>
            </table>
            <input type="reset" value="Reset" name="reset" />
            <input type="submit" value="Search" name="submit" />
        </form>
    </body>
</html>
