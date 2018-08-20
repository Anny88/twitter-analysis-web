<%-- 
    Document   : display
    Created on : 20.05.2018, 10:39:01
    Author     : Anna
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javaclasses.JavaTweet"%>
<%@page import = "javaclasses.TreeNode"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Twitter tags-tree</title>
    </head>
    <body>
        <%
            String tag = request.getParameter("tag");   
            int id = 44418;
        %>
        <h1>Tags, used with the <b> <%=tag %> </b></h1>
        
    </body>
    <table>
    <%  List list = JavaTweet.getHotTopics(id);
        
        
       //for (int i = 0; i < tree.size(); i++){ 
    %>
    <%! public void print (TreeNode t){
            String s = t.getTag();
            
       }
    %>
        <tr>
            <td>boo</td>
            <td><%=(tree.getTag()) %></td>
            <td><%=(tree.getValue()) %></td>
        </tr>
        <tr>
    <%for (int i = 0; i < tree.getChildren().size(); i++){
        TreeNode tn = tree.getChildren().get(i);
      
    %>
        <td><%=(tn.getTag()) %></td>
        <td><%=(tn.getValue()) %></td>
        <td></td>
    <%  
        }
    %>
    </table>
</html>
