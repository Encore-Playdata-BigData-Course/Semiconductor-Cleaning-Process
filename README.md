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

## Examples
