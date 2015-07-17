
var ws = new WebSocket("ws://localhost:8080/websocket/hello");

ws.onopen = function() {
    alert("Opened!");
    ws.send("Hello Server");
};

ws.onmessage = function (evt) {
    //alert("Message: " + evt.data);
    var d = new Date();
    document.write(d + ":" + evt.data);
};

ws.onclose = function() {
    alert("Closed!");
};

ws.onerror = function(err) {
    alert("Error: " + err);
};

document.getElementById("sendBt").onclick = function onSendBtClick(){
    var msgInput = document.getElementById("msgId");
    var msg = msgInput.value;
    alert(msg);
    ws.send(msg);
}