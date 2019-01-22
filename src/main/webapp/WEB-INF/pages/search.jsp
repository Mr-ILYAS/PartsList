<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
    <head>
        <title>Parts Page</title>

        <style type="text/css">
            body {
                text-align: center;
            }

            table {
                margin: auto;
            }

            A:link {
                text-decoration: none;
                font-weight: bold;
                color: #e86;
            }
            A:visited {
                text-decoration: none;
                font-weight: bold;
                color: #e86;
            }
            A:active {
                text-decoration: none;
                font-weight: bold;
                color: #e86;
            }
            A:hover {
                text-decoration: underline overline;
                font-weight: bold;
                color: red;
            }

            .parts_table {
                border-collapse: collapse;
                border-spacing: 0;
                border-color: #ccc;
                text-align: center;
            }

            .parts_table td {
                font-family: Arial, sans-serif;
                font-size: 14px;
                padding: 10px 5px;
                border-style: solid;
                border-width: 1px;
                overflow: hidden;
                word-break: normal;
                border-color: #888;
                color: #333;
                background-color: #fff;
            }

            .parts_table th {
                font-family: Arial, sans-serif;
                font-size: 14px;
                font-weight: normal;
                padding: 10px 5px;
                border-style: solid;
                border-width: 1px;
                overflow: hidden;
                word-break: normal;
                border-color: #ccc;
                color: #333;
                background-color: #f0f0f0;
            }

            #hide_column {
                border: none;
                background-color: #fff;
            }
            #hide_column A:link {
                text-decoration: none;
                color: #00e;
            }
            #hide_column A:visited {
                text-decoration: none;
                color: #00e;
            }
            #hide_column A:active {
                text-decoration: none;
                color: #00e;
            }
            #hide_column A:hover {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Результат поиска детали</h1>

        <table class="parts_table">
            <tr>
                <th width="80">Название</th>
                <th width="120">Обязательна ли для сборки</th>
                <th width="120">Количество</th>
                <th width="60" id="hide_column"></th>
            </tr>

            <tr>
                <td>${part.name}</td>
                <td><c:choose>
                    <c:when test="${part.needed !=1}">Нет</c:when>
                    <c:otherwise>Да</c:otherwise>
                </c:choose>
                </td>
                <td>${part.quantity}</td>
                <td id="hide_column"><a href="<c:url value='/remove/${part.id}'/>">delete</a></td>
            </tr>
        </table>

        <br/>
        <br/>

        <c:url var="addAction" value="/parts/update"/>
        <form:form action="${addAction}" commandName="part">
            <table>
                <c:if test="${!empty part.name}">
                    <tr>
                        <td>
                            <form:label path="id">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" size="8" disabled="true"/>
                            <form:hidden path="id"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="name">
                            <spring:message text="Название"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="needed">
                            <spring:message text="Необходимость для сборки"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="needed"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="quantity">
                            <spring:message text="Количество"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="quantity"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="<spring:message text="Изменить"/>"/>
                    </td>
                </tr>
            </table>
        </form:form>
        <a href="<c:url value='/redirect'/>"> -> Вернуться в каталог <- </a>
    </body>
</html>