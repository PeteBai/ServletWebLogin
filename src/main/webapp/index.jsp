<html>
<style>
    #string{
    margin:0px auto;
    width:300px;
    text-align:center; /* 文字居中 */
    font-size:32px; /* 文字大小 */
}
</style>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<body>
<div style="width:100%;text-align:center">
<form action="MyServlet" method="POST">
    <div id="string">用户名</div>
    <input type="text" name="username">
    <br>
    <br>
    <div id="string">密码</div>
    <input type="password" name="pw">
    <br>
    <br>
    <img id="imgx" src="<%= request.getContextPath() %>/LCServlet" οnclick="reloadImg()" alt="欲更换验证码请刷新页面。">
    <br>
    <br>
    <input type="text" name="capacha" value="请输入验证码">
    <br>
    <br>
    <input type="submit" οnclick="reloadImg()" value="提交">
</form></div>
</body>

<script type="text/javascript">
    function reloadImg(){
        document.getElementById("imgx").src="<%= request.getContextPath()%>/LCServlet";
    }
</script>
</html>
