How to run this program ?
=========================

1. compile

* install maven first;
* cd websocket && mvn clean package

2. install

* install jetty, nginx
* copy websocket.war to /path/to/jetty_home/webapps
* start jetty

	java -jar start.jar

* config nginx
	
	mkdir -p /tmp/websocket
	
	cp index.html /tmp/websocket

	change root dir of ws.conf.
	
	include ws.conf using 'include'.

	restart nginx.

* visit http://localhost:81
