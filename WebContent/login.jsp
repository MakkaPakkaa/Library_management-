<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>图书馆管理系统</title>
	   
</head>

<body class="bootstrap-admin-without-padding">
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="alert alert-info">
               
                欢迎登录图书馆管理系统
            </div>
            
            <form class="bootstrap-admin-login-form" method="post" action="/books/LoginServlet">
                 <% 
					String state = (String)session.getAttribute("state");
					session.removeAttribute("state");
					if(state!=null){
					%>
                 <label class="control-label" for="username">密码错误</label>
                 
                 <%}%>
                <div class="form-group">
                    <label class="control-label" for="username">账&nbsp;号</label>
                    <input type="text" class="form-control" id="username" name="username" required="required" placeholder="学号"/>
<!--                     <label class="control-label" for="username" style="display:none;"></label> -->
                </div>
                <div class="form-group">
                    <label class="control-label" for="password">密&nbsp;码</label>
                    <input type="password" class="form-control" id="password" name="password" required="required" placeholder="密码"/>
<!--                     <label class="control-label" for="username" style="display:none;"></label> -->
                </div>
                
                    <label class="control-label" for="password">没有账号请<a href="/books/register.jsp" style="color:blue;">注册</a></label>
                <br>
                <input type="submit" class="btn btn-lg btn-primary"  value="登&nbsp;&nbsp;&nbsp;&nbsp;录"/>
                
            </form>
        </div>
    </div>
</div>

</body>
</html>