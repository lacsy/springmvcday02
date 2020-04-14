<%--
  Created by IntelliJ IDEA.
  User: 奥嚟csy
  Date: 2020/4/2
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
              //发送ajax请求
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":12}',
                    dataType:"json",
                    type:"post",
                    success:function (val) {
                        //data服务器端响应的json的数据，进行解析
                        alert(val);
                        alert(val.username);
                        alert(val.password);
                        alert(val.age);
                    }

                })
            })
        })

    </script>

</head>
<body>
<a href="user/testString">testString</a>

<a href="user/textModelAndView">testModelAndView</a>
<br/>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
<title>Title</title>

