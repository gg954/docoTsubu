<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User,model.Mutter,java.util.List" %>
<%
	//セッションスコープに保存されたユーザ情報を取得
	User loginUser =(User) session.getAttribute("loginUser");
	//アプリケーションスコープに保存されたつぶやきリストを取得
	List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
	//List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	//リクエストスコープに保存されたエラーメッセージを取得
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ひとこと板</title>
<link rel="STYLESHEET" href="style.css" type="text/css">
</head>
<body>
<h1>ひとこと板</h1>
<p class="user_name">
	<%= loginUser.getName() %>さんがログイン中
	<a href="/docoTsubu/Logout">ログアウト</a>
	<a href="/docoTsubu/Main">更新</a>
</p>

<form action="/docoTsubu/Main" method="post" class="post">
	<input type="text" name="text">
	<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null){ %>
	<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList){ %>
	<p class="mutter"><%= mutter.getUserName() %> さん：　<%= mutter.getText() %></p>
<% } %>
</body>
</html>