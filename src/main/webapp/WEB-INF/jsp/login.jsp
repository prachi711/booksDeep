<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
        </head>
        <body>
            <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="Username">Username: </form:label>
                        </td>
                        <td>
                            <form:input path="Username" name="Username" id="Username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="Password">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="Password" name="Password" id="Password" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                             <input type="submit" value="Submit" /> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="index.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
        </body>
        </html>