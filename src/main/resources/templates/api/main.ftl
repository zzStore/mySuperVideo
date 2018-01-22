<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <link th:href="@{css/bootstrap.css}" rel="stylesheet" />
    <link th:href="@{css/bootstrap-theme.css}" rel="stylesheet" />
    <script src="js/jquery.js"></script>
    <script src="/js/jquery-1.11.2.min.js"></script>
    <script src="/js/vue.min.js"></script>
</head>
<body>
    <h1>网络视频爬虫系统主页面</h1>
    <a href="/queryAllUsers">查询所有用户</a>
    <a href="/adminLogin">管理员主界面</a><br/>

    用户实时讨论窗口
    <div id="ws">
        <input id="text" type="text"/><br/>
        <button onclick="sendMsg();">发送</button>
        <button onclick="closeWS()" :disabled="!opened">下线</button>
        <button onclick="openWS()"  :disabled="opened">上线</button>
        <div v-html="msg"></div>
    </div>



    <div class="container">
        <table class="table-bordered">
            <tr >
                <td>视频名称</td><td>更新时间</td><td>点击量</td><td>图片</td>
            </tr>
            <tr th:each="li:${list}">
                <td><a th:href="${li.videoURL}" ><span th:text="${li.videoName}"></span></a></td>
                <td><span th:text="${li.videoTime}"></span></td>
                <td><span th:text="${li.videoSum}"></span></td>
                <td><img th:src="${li.videoMsg}" /></td>
            </tr>
        </table>
    </div>




    <script type="text/javascript">
        var websocket = null;

        var wsVue = new Vue({
            el: '#ws',
            data: {
                msg: "可以开始讨论了<br/>",
                opened: false
            },
            mounted: function(){
                initWs();
            }
        });

        function initWs() {
            //check if your browser supports WebSocket
            if ('WebSocket' in window) {
                websocket = new WebSocket("ws://localhost:8080/my-websocket");
            }
            else {
                alert('Sorry, websocket not supported by your browser.')
            }

            //Error callback
            websocket.onerror = function () {
                setMessageContent("error!");
                wsVue.opened = false;
            };

            //socket opened callback
            websocket.onopen = function (event) {
                setMessageContent("开启讨论模式");
                wsVue.opened = true;
            }

            //message received callback
            websocket.onmessage = function (event) {
                setMessageContent(event.data);
            }

            //socket closed callback
            websocket.onclose = function () {
                setMessageContent("关闭讨论模式");
                wsVue.opened = false;
            }

            //when browser window closed, close the socket, to prevent server exception
            window.onbeforeunload = function () {
                websocket.close();
            }
        }

        //update message to vue and then in div
        function setMessageContent(content) {
            wsVue.msg += content  + '<br/>';
        }

        //click to close the websocket
        function closeWS() {
            websocket.close();
            wsVue.opened = false;
        }

        //click to open the websocket
        function openWS() {
            initWs();
        }

        //click to send message
        function sendMsg() {
            var message = document.getElementById('text').value;
            websocket.send(message);
            document.getElementById('text').value="";
        }
    </script>
</body>
</html>