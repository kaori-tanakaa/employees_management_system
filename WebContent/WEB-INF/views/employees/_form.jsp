<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="code">社員番号</label><br />
<input type="text" name="code" value="${employee.code}" />
<br /><br />

<label for="name_kanzi">氏名</label><br />
<input type="text" name="name_kanzi" value="${employee.name_kanzi}" />
<br /><br />

<label for="name_kana">ふりがな</label><br />
<input type="text" name="name_kana" value="${employee.name_kana}" />
<br /><br />

<label for="password">パスワード</label><br />
<input type="password" name="password" value="${password.password}" />
<br /><br />

<label for="belongs_num">所属</label><br />
<select name = "belongs_num">
<option value = "0"<c:if test="${employee.belongs_num == 0}"> selected</c:if>>大阪第1</option>
<option value = "1"<c:if test="${employee.belongs_num == 1}"> selected</c:if>>大阪第2</option>
<option value = "2"<c:if test="${employee.belongs_num == 2}"> selected</c:if>>大阪第3</option></select>
<br /><br />

<label for="birthday_at">生年月日</label><br />
<input type="date" name="birthday_at" value="${employee.birthday_at}" />
<br /><br />

<label for="join_at">入社日</label><br />
<input type="date" name="join_at" value="${employee.join_at}" />
<br /><br />

<label for="leave_at">退社日</label><br />
<input type="date" name="leave_at" value="${employee.leave_at}" />
<br /><br />

<label for="admin_flg">権限</label><br />
<select name="admin_flg">
    <option value="0"<c:if test="${employee.admin_flg == 0}"> selected</c:if>>一般</option>
    <option value="1"<c:if test="${employee.admin_flg == 1}"> selected</c:if>>管理者</option>
</select>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>

