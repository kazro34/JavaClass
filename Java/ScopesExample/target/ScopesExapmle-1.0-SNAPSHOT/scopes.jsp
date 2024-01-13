<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Scopes Example</title>
</head>
<body>
<%
    if (request.getParameter("requestAttr")!=null){
        request.setAttribute("requestAttrName","Bill");
    }
    if (request.getParameter("sessionAttr")!=null){
        session.setAttribute("sessionName","Igor");
    }
    if (request.getParameter("appAttr")!=null){
        request.getServletContext().setAttribute("appName","John");
    }
%>
<p>Request parameter:
    <%= request.getParameter("requestParamName")!=null ? request.getParameter("requestParamName"):"-" %>
</p>
<p>Request attribute:
    <%= request.getAttribute("requestAttrName")!=null ? request.getAttribute("requestAttrName"):"-" %>
</p>
<p>Session attribute:
    <%= session.getAttribute("sessionName")!=null ? session.getAttribute("sessionName"):"-" %>
</p>
<p>Application (context) attribute:
    <%= request.getServletContext().getAttribute("appName")!=null ? request.getServletContext().getAttribute("appName"):"-" %>
</p>
<hr/>
<form method="post">
    Request parameter: <input type="text" name="requestParamName"/><br/>
    <input type="checkbox" name="requestAttr"/> Set Request attribute<br/>
    <input type="checkbox" name="sessionAttr"/> Set Session attribute<br/>
    <input type="checkbox" name="appAttr"/> Set App context attribute<br/>
    <input type="submit" value="Apply"/>
</form>
</body>
</html>