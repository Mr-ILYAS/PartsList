<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Parts-list by Ильяс</title>
        <style type="text/css">
            body {
                text-align: center;
            }

            A:link {
                text-decoration: none;
                font-weight: bold;
                color: #00e;
            }
            A:visited {
                text-decoration: none;
                font-weight: bold;
                color: #00e;
            }
            A:active {
                text-decoration: none;
                font-weight: bold;
                color: #00e;
            }
            A:hover {
                text-decoration: underline overline;
                font-weight: bold;
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Parts</h1>
        <br/>
        <a href="<c:url value="/parts"/>">Открыть таблицу</a>
        <br/>
    </body>
</html>