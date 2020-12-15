# Semiconductor Cleaning Process

## Project Synopsis
4차 산업혁명과 Digital Transformation이 가속화됨에 따라 산업 현장에서 발생하는 방대하고 다양한 데이터의 관리를 위해 다양한 측정 장비가 도입되는 추세입니다. 이번 프로젝트에서는 데이터를 효과적으로 관리하기 위해 IoT 및 smartfactory 환경을 가정하여 반도체 8대 공정 중 Wet Cleaning 공정 솔루션을 개발했습니다. 구체적으로 Process1을 `Clean1-Clean2-Rinse1`으로, Process2를 `Clean3-Rinse2`로 가정하고 데이터는 각 공정을 완료하는 데 걸리는 시간으로 가정했습니다.
### Background Knowledge
반도체 8대 공정 중 Si wafer cutting 후 표면을 매끄럽게 polishing 하는 과정에서 다양한 유&#183;무기 불순물이 잔존하게 됩니다. 이 불순물들을 씼어내 주는 과정이 Cleaning 과정입니다. 주로 Cleaning은 한 번만에 끝내지 않고 여러 차례에 나뉘어 다양한 화학 약품을 사용하여 유&#183;무기물, 금속 불순물을 제거합니다. 이번 프로젝트에서는 Wet Cleaning 과정 중 RCA Cleaning에 대한 솔루션을 개발하였는데 RCA Cleaning 과정에서 제거되는 불순물은 다음과 같습니다.<br>
<table border="1">
	<th>약품</th>
	<th>불순물</th>
	<tr>
	    <td>HF</td>
	    <td>Native Oxide</td>
	</tr>
	<tr>
	    <td>NH<sub>4</sub>OH/H<sub>2</sub>O<sub>2</sub></td>
	    <td>Organics, Metals</td>
	</tr>
  <tr>
	    <td>HCI/H<sub>2</sub>O<sub>2</sub></td>
	    <td>Akali Ions, Metals</td>
	</tr>
</table>
각각의 약품을 통해 불순물을 제거한 후 다음 과정을 위해 말려주는 Rinse 과정을 거치게 됩니다.

### purpose
불순물 제거 및 건조 과정에서 중요한 parameter로써 여길 수 있는 것은 각 과정 진행 시간 및 온도, 습도 등이 있습니다. 이번 프로젝트에서는 이 중 시간에 집중하여 적정 공정 시간을 13분 이상 20분 미만으로 가정하여 기준에 미달한 wafer는 불량품, 기준에 통과한 wafer는 정상, 아직 공정이 시작하지 않은 wafer는 실행전으로 표시되는 Totalprocess라는 table 및 각 wafer 별 현재 진행 상태 및 불량 발생 여부를 판단할 수 있는 UI table을 통해 Node-RED Dashboard로 표현하는 것을 목표로 했습니다.
### Programming Tools

Java<br>
OracleDB<br>
Node-RED<br>
## Oracle DB

* Process1
<table border="1">
	<th>WaferId</th>
	<th>Clean1</th>
	<th>Clean2</th>
	<th>Rinse1</th>
	<th>Time</th>
	<tr>
	    <td>1</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
  <tr>
	    <td>3</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>...</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
</table>

* Process2
<table border="1">
	<th>WaferId</th>
	<th>Clean3</th>
	<th>Rinse2</th>
	<th>Time</th>
	<tr>
	    <td>1</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>2</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
  <tr>
	    <td>3</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>...</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
</table>

* Totalprocess
<table border="1">
	<th>WaferId</th>
	<th>Clean1</th>
	<th>Clean2</th>
	<th>Rinse1</th>
	<th>Clean3</th>
	<th>Rinse2</th>
	<th>Time</th>
	<tr>
	    <td>1</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
  <tr>
	    <td>3</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>...</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
</table>

* UI
<table border="1">
	<th>WaferId</th>
	<th>Result</th>
	<th>ErrPoint</th>
	<th>Time</th>
	<tr>
	    <td>1</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>2</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
  <tr>
	    <td>3</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
	<tr>
	    <td>...</td>
			<td></td>
			<td></td>
			<td></td>
	</tr>
</table>

## Java Tree
* MVC Pattern<br>
### Controller
ProcessController.java
### Exception
NotExistException.java
### Model
Process1DAO.java<br>
Process2DAO.java<br>
TotalprocessDAO.java<br>
UiDAO.java
### Model.util
DBUtil.java
### Model.dto
Process1DTO.java<br>
Process2DTO.java<br>
TotalprocessDTO.java<br>
UiDTO.java
### Service
ProcessService.java
### View
RunningEndView.java<br>
RunningStartView.java

## Node-Red
* flow<br>
![function](https://i.imgur.com/7lQlkPW.png)
```
[{"id":"a251cec2.9317d","type":"tab","label":"플로우 1","disabled":false,"info":""},{"id":"7aa22138.0ce08","type":"ui_button","z":"a251cec2.9317d","name":"","group":"8ae29b1e.cb8af8","order":6,"width":4,"height":1,"passthru":false,"label":"totalproccess","tooltip":"","color":"","bgcolor":"","icon":"","payload":"1","payloadType":"str","topic":"button","x":170,"y":240,"wires":[["9f358e82.1fc78"]]},{"id":"b26f278.89769d8","type":"oracledb","z":"a251cec2.9317d","name":"","usequery":false,"query":"","usemappings":false,"mappings":"","server":"ebc8a121.d3cd6","resultaction":"single","resultlimit":100,"x":500,"y":220,"wires":[["7f30af84.60289"]]},{"id":"7f30af84.60289","type":"function","z":"a251cec2.9317d","name":"rows to columns","func":"var column = [];\nfor(var key in msg.payload[0]){\n\tcolumn.push(key);\n}\nvar val = [];\nfor(var i = 0; i<msg.payload.length;i++){\n\tval.push(Object.values(msg.payload[i]));\n}\n\nmsg.payload = [column, val];\nreturn msg;","outputs":1,"noerr":0,"initialize":"","finalize":"","x":660,"y":220,"wires":[["c4be1d21.1b1fd","44787c00.a8b0d4","e4dcf8c8.50dfc8","757bd1ac.488a1","bcc44a34.65ea18","953dd407.48f4a8","651bfa46.d15ce4"]]},{"id":"c4be1d21.1b1fd","type":"function","z":"a251cec2.9317d","name":"col1","func":"var col = msg.payload[0][0];\nvar val = msg.payload[1];\nvar result = col+'<br></br><br>'\nfor(var i =0; i<val.length;i++){\n    result+=val[i][0]+'</br><br>';\n}\nmsg.payload = result;\nreturn msg;","outputs":1,"noerr":0,"initialize":"","finalize":"","x":830,"y":100,"wires":[["b8042c53.8e97c"]]},{"id":"44787c00.a8b0d4","type":"function","z":"a251cec2.9317d","name":"col2","func":"var col = msg.payload[0][1];\nvar val = msg.payload[1];\nvar len = msg.payload[0].length;\nvar result = col+'<br></br><br>'\nfor(var i =0; i<val.length;i++){\n    result+=val[i][1]+'</br><br>';\n}\nmsg.payload = result;\nif(len>=2){\n\treturn msg;\n} else{\n    return {payload : \"\"}\n}","outputs":1,"noerr":0,"initialize":"","finalize":"","x":830,"y":140,"wires":[["1ed84ba8.30c944"]]},{"id":"e4dcf8c8.50dfc8","type":"function","z":"a251cec2.9317d","name":"col3","func":"var col = msg.payload[0][2];\nvar val = msg.payload[1];\nvar len = msg.payload[0].length;\nvar result = col+'<br></br><br>'\nfor(var i =0; i<val.length;i++){\n    result+=val[i][2]+'</br><br>';\n}\nmsg.payload = result;\nif(len>=3){\n\treturn msg;\n} else{\n    return {payload : \"\"}\n}","outputs":1,"noerr":0,"initialize":"","finalize":"","x":830,"y":180,"wires":[["7efac7b0.ceeb88"]]},{"id":"757bd1ac.488a1","type":"function","z":"a251cec2.9317d","name":"col4","func":"var col = msg.payload[0][3];\nvar val = msg.payload[1];\nvar len = msg.payload[0].length;\nfunction dts(format){\n    var year = format.getFullYear();\n    var month = format.getMonth() + 1;\n    if(month<10) month = '0' + month;\n    var date = format.getDate();\n    if(date<10) date = '0' + date;\n    var hour = format.getHours();\n    if(hour<10) hour = '0' + hour;\n    var min = format.getMinutes();\n    if(min<10) min = '0' + min;\n    var sec = format.getSeconds();\n    if(sec<10) sec = '0' + sec;\n    return year + \"-\" + month + \"-\" + date + \" \" + hour + \":\" + min + \":\" + sec;\n}\nvar result = col+'<br></br><br>'\nfor(var i =0; i<val.length;i++){\n    if(col=='TIME'){\n        result+=dts(val[i][3])+'</br><br>';\n    } else{\n        result+=val[i][3]+'</br><br>';\n    }\n    \n}\nmsg.payload = result;\nif(len>=4){\n\treturn msg;\n} else{\n    return {payload : \"\"}\n}","outputs":1,"noerr":0,"initialize":"","finalize":"","x":830,"y":220,"wires":[["da41c174.ecb91"]]},{"id":"b8042c53.8e97c","type":"ui_text","z":"a251cec2.9317d","group":"8ae29b1e.cb8af8","order":10,"width":4,"height":11,"name":"1","label":"","format":"{{msg.payload}}","layout":"col-center","x":950,"y":100,"wires":[]},{"id":"1ed84ba8.30c944","type":"ui_text","z":"a251cec2.9317d","group":"8ae29b1e.cb8af8","order":11,"width":4,"height":11,"name":"2","label":"","format":"{{msg.payload}}","layout":"col-center","x":950,"y":140,"wires":[]},{"id":"7efac7b0.ceeb88","type":"ui_text","z":"a251cec2.9317d","group":"8ae29b1e.cb8af8","order":12,"width":4,"height":11,"name":"3","label":"","format":"{{msg.payload}}","layout":"col-center","x":950,"y":180,"wires":[]},{"id":"da41c174.ecb91","type":"ui_text","z":"a251cec2.9317d","group":"8ae29b1e.cb8af8","order":13,"width":4,"height":11,"name":"4","label":"","format":"{{msg.payload}}","layout":"col-center","x":950,"y":220,"wires":[]},{"id":"bcc44a34.65ea18","type":"function","z":"a251cec2.9317d","name":"col5","func":"var col = msg.payload[0][4];\nvar val = msg.payload[1];\nvar len = msg.payload[0].length;\nfunction dts(format){\n    var year = format.getFullYear();\n    var month = format.getMonth() + 1;\n    if(month<10) month = '0' + month;\n    var date = format.getDate();\n    if(date<10) date = '0' + date;\n    var hour = format.getHours();\n    if(hour<10) hour = '0' + hour;\n    var min = format.getMinutes();\n    if(min<10) min = '0' + min;\n    var sec = format.getSeconds();\n    if(sec<10) sec = '0' + sec;\n    return year + \"-\" + month + \"-\" + date + \" \" + hour + \":\" + min + \":\" + sec;\n}\nvar result = col+'<br></br><br>'\nfor(var i =0; i<val.length;i++){\n    if(col=='TIME'){\n        result+=dts(val[i][4])+'</br><br>';\n    } else{\n        result+=val[i][4]+'</br><br>';\n    }\n    \n}\nmsg.payload = result;\nif(len>=5){\n\treturn msg;\n} else{\n    return {payload : \"\"}\n}","outputs":1,"noerr":0,"initialize":"","finalize":"","x":830,"y":260,"wires":[["2a96cc57.977894"]]},{"id":"2a96cc57.977894","type":"ui_text","z":"a251cec2.9317d","group":"8ae29b1e.cb8af8","order":14,"width":4,"height":11,"name":"5","label":"","format":"{{msg.payload}}","layout":"col-center","x":950,"y":260,"wires":[]},{"id":"953dd407.48f4a8","type":"function","z":"a251cec2.9317d","name":"col6","func":"var col = msg.payload[0][5];\nvar val = msg.payload[1];\nvar len = msg.payload[0].length;\nfunction dts(format){\n    var year = format.getFullYear();\n    var month = format.getMonth() + 1;\n    if(month<10) month = '0' + month;\n    var date = format.getDate();\n    if(date<10) date = '0' + date;\n    var hour = format.getHours();\n    if(hour<10) hour = '0' + hour;\n    var min = format.getMinutes();\n    if(min<10) min = '0' + min;\n    var sec = format.getSeconds();\n    if(sec<10) sec = '0' + sec;\n    return year + \"-\" + month + \"-\" + date + \" \" + hour + \":\" + min + \":\" + sec;\n}\nvar result = col+'<br></br><br>'\nfor(var i =0; i<val.length;i++){\n    if(col=='TIME'){\n        result+=dts(val[i][5])+'</br><br>';\n    } else{\n        result+=val[i][5]+'</br><br>';\n    }\n    \n}\nmsg.payload = result;\nif(len>=6){\n\treturn msg;\n} else{\n    return {payload : \"\"}\n}","outputs":1,"noerr":0,"initialize":"","finalize":"","x":830,"y":300,"wires":[["4ad74beb.ad4144"]]},{"id":"4ad74beb.ad4144","type":"ui_text","z":"a251cec2.9317d","group":"8ae29b1e.cb8af8","order":15,"width":4,"height":11,"name":"6","label":"","format":"{{msg.payload}}","layout":"col-center","x":950,"y":300,"wires":[]},{"id":"9f358e82.1fc78","type":"function","z":"a251cec2.9317d","name":"query build","func":"\nvar query = 'select '+ '*' + ' from ' + 'totalprocess' +' order by waferId';\n\n\nvar newMsg = {\n    \"query\": query,\n    \"payload\":[]\n}\nreturn newMsg;","outputs":1,"noerr":0,"initialize":"","finalize":"","x":330,"y":240,"wires":[["b26f278.89769d8"]]},{"id":"745eb9a8.3f6fa8","type":"ui_button","z":"a251cec2.9317d","name":"","group":"8ae29b1e.cb8af8","order":8,"width":4,"height":1,"passthru":false,"label":"ui","tooltip":"","color":"","bgcolor":"","icon":"","payload":"1","payloadType":"str","topic":"button","x":150,"y":280,"wires":[["928fe8a2.c5da28"]]},{"id":"928fe8a2.c5da28","type":"function","z":"a251cec2.9317d","name":"query build","func":"\nvar query = 'select '+ '*' + ' from ' + 'ui'+' order by waferId';\n\n\nvar newMsg = {\n    \"query\": query,\n    \"payload\":[]\n}\nreturn newMsg;","outputs":1,"noerr":0,"initialize":"","finalize":"","x":330,"y":280,"wires":[["b26f278.89769d8"]]},{"id":"2ee7056a.89920a","type":"ui_button","z":"a251cec2.9317d","name":"","group":"8ae29b1e.cb8af8","order":2,"width":4,"height":1,"passthru":false,"label":"proccess1","tooltip":"","color":"","bgcolor":"","icon":"","payload":"1","payloadType":"str","topic":"button","x":170,"y":160,"wires":[["291c7bf2.9b3354"]]},{"id":"291c7bf2.9b3354","type":"function","z":"a251cec2.9317d","name":"query build","func":"var query = 'select '+ '*' + ' from ' + 'process1' +' order by waferId';\nvar newMsg = {\n    \"query\": query,\n    \"payload\":[]\n}\nreturn newMsg;","outputs":1,"noerr":0,"initialize":"","finalize":"","x":330,"y":160,"wires":[["b26f278.89769d8"]]},{"id":"ba4c1416.ae63a8","type":"ui_button","z":"a251cec2.9317d","name":"","group":"8ae29b1e.cb8af8","order":4,"width":4,"height":1,"passthru":false,"label":"process2","tooltip":"","color":"","bgcolor":"","icon":"","payload":"1","payloadType":"str","topic":"button","x":160,"y":200,"wires":[["250f807d.da7a7"]]},{"id":"250f807d.da7a7","type":"function","z":"a251cec2.9317d","name":"query build","func":"\nvar query = 'select '+ '*' + ' from ' + 'process2'+' order by waferId';\n\n\nvar newMsg = {\n    \"query\": query,\n    \"payload\":[]\n}\nreturn newMsg;","outputs":1,"noerr":0,"initialize":"","finalize":"","x":330,"y":200,"wires":[["b26f278.89769d8"]]},{"id":"651bfa46.d15ce4","type":"function","z":"a251cec2.9317d","name":"col7","func":"var col = msg.payload[0][6];\nvar val = msg.payload[1];\nvar len = msg.payload[0].length;\nfunction dts(format){\n    var year = format.getFullYear();\n    var month = format.getMonth() + 1;\n    if(month<10) month = '0' + month;\n    var date = format.getDate();\n    if(date<10) date = '0' + date;\n    var hour = format.getHours();\n    if(hour<10) hour = '0' + hour;\n    var min = format.getMinutes();\n    if(min<10) min = '0' + min;\n    var sec = format.getSeconds();\n    if(sec<10) sec = '0' + sec;\n    return year + \"-\" + month + \"-\" + date + \" \" + hour + \":\" + min + \":\" + sec;\n}\nvar result = col+'<br></br><br>'\nfor(var i =0; i<val.length;i++){\n    if(col=='TIME'){\n        result+=dts(val[i][6])+'</br><br>';\n    } else{\n        result+=val[i][6]+'</br><br>';\n    }\n    \n}\nmsg.payload = result;\nif(len>=7){\n\treturn msg;\n} else{\n    return {payload : \"\"}\n}","outputs":1,"noerr":0,"initialize":"","finalize":"","x":830,"y":340,"wires":[["c06a28e4.6e1938"]]},{"id":"c06a28e4.6e1938","type":"ui_text","z":"a251cec2.9317d","group":"8ae29b1e.cb8af8","order":16,"width":4,"height":11,"name":"7","label":"","format":"{{msg.payload}}","layout":"col-center","x":950,"y":340,"wires":[]},{"id":"8ae29b1e.cb8af8","type":"ui_group","name":"select","tab":"60c448b6.923c28","order":1,"disp":true,"width":28,"collapse":false},{"id":"ebc8a121.d3cd6","type":"oracle-server","host":"localhost","port":"1521","reconnect":true,"reconnecttimeout":"5000","db":"xe"},{"id":"60c448b6.923c28","type":"ui_tab","name":"Home","icon":"dashboard","disabled":false,"hidden":false}]
```
* query build : 해당 table에 해당하는 select sql query문을 작성합니다.<br>
* rows to columns : oracledb node로부터 return된 payload는 데이터 set의 row로 이루어진 array이므로 이를 column으로 이루어진 array로 변환합니다.<br>
* col* : 해단 순서의 column이 존재한다면 그 array의 값들을 column의 format으로 변환합니다.
## Examples
* process1
![process1](https://i.imgur.com/KJBVcWT.jpg)
* process2
![process2](https://i.imgur.com/05gKxs1.jpg)
* totalprocess
![totalprocess](https://i.imgur.com/X3jCTo5.jpg)
* ui
![ui](https://i.imgur.com/3uAsusZ.jpg)

## Co-Worker
 <a href="https://github.com/alsrjs2441"><img src="https://avatars0.githubusercontent.com/u/58159833?s=460&v=4" alt="Avatar" width="40" /></a>   
<a href="https://github.com/seongho726"><img src="https://avatars0.githubusercontent.com/u/74291607?s=460&v=4" alt="Avatar" width="40"/></a><br>
<a href="https://github.com/alsrjs2441">alsrjs2441</a> <a href="https://github.com/seongho726">seongho726</a>
