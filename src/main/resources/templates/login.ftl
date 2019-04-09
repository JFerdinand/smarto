<html>
<head>
    <meta charset=utf-8>
    <@bootstrap.cssAndJs/>
    <@slyak.css url="/css/login.css"/>
</head>
<body>
    <div class="container login">
        <div class="title">欢迎登陆</div>
        <form action="/login" method="post">
            <div class="user">
                <span>用户名</span>
                <input name="userName" type="text">
            </div>
            <div class="pwd">
                <span>密码</span>
                <input name="password" type="password">
            </div>
            <div class="btns">
                <button class="btn btn-primary" type="submit">登陆</button>
            </div>
        </form>
    </div>
</body>
</html>