<html>
<head>
    <meta charset=utf-8>
    <@bootstrap.cssAndJs/>
    <@slyak.css url="/css/login.css"/>
</head>
<body>
    <div class="container login">
        <div class="title">欢迎登陆</div>
        <form>
            <div class="user">
                <span>用户名</span>
                <input name="userName" type="text" autocomplete="off">
            </div>
            <div class="pwd">
                <span>密码</span>
                <input name="password" type="password" autocomplete="off">
            </div>
            <div class="errorMsg">

            </div>
            <div class="btns">
                <button class="btn btn-primary" type="button">登陆</button>
            </div>
        </form>
    </div>
    <script>
        $("input").off().on("focus",function () {
            $(".errorMsg").html("")
        });
        $("button").off().on("click",function () {
            var url = location.origin;
            var userName = $("[name=userName]").val();
            var password = $("[name=password]").val();
            $.ajax({
                url:url+"/login",
                type:"post",
                data:{
                    userName:userName,
                    password:password
                },
                success:function (data) {
                    if(data.code==0){
                        window.location = url+"/projects";
                    }else{
                        $(".errorMsg").html(data.msg)
                    }
                },
                error:function(err){

                }
            })
        });

    </script>
</body>
</html>