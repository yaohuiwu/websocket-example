<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test WebSocket</title>
</head>
<body>

<h2>Message Board</h2>
<label>消息:</label>
<input id="msgId"/>

<button id="sendBt">发送</button>
<fieldset style="margin-top: 20px;">
    <div id="msgBoard" style="margin-top: 10px ; width: 500px; height: 40px; overflow: auto"></div>
</fieldset>

<%--<script type="text/javascript" src="receiver.js" />--%>

<script type="text/javascript">
    var ws = new WebSocket("ws://localhost:8080/websocket/hello");

    ws.onopen = function() {
        console.log("Opened!");
        ws.send("Hello Server");
    };

    ws.onmessage = function (evt) {
        var d = new Date();
        document.getElementById("msgBoard").innerHTML = "echo:" + evt.data + "(" + d + ")";
    };

    ws.onclose = function() {
        alert("Closed!");
    };

    ws.onerror = function(err) {
        alert("Error: " + err);
    };

    document.getElementById("sendBt").onclick = function onSendBtClick(){
        var msgInput = document.getElementById("msgId");
        ws.send(msgInput.value);
    }

</script>
</body>
</html>
