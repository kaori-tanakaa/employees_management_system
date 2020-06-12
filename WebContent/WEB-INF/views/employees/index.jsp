<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>従業員　一覧</h2>
        <table id="employee_list">
            <tbody>

            <form action="EmployeeSearchServlet" method="post" >
            社員番号：
<input type="text" name="admin_id">

氏名：
<input type="text" name="admin_id">
所属：
<select name="category_01">
<option value="default">未選択
<option value="song_01">大阪第1
<option value="filetype_01">大阪第2
<option value="artist_01">大阪第3

</select>

<input type="submit" name="chk_login" value="検索">
</form>
                <tr>
                    <th>社員番号</th>
                    <th>氏名</th>
                    <th>所属</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="employee" items="${employees}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${employee.code}" /></td>
                        <td><c:out value="${employee.name_kanzi}" /></td>
                        <td>
                            <c:choose>
                                <c:when test="${employee.delete_flg == 1}">
                                    （削除済み）
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value='/employees/show?id=${employee.id}' />">詳細を表示</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${employees_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((employees_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/employees/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/' />">戻る</a></p>

    </c:param>
</c:import>