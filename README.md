# Semiconductor Cleaning Process

## Project Synopsis
4차 산업혁명과 Digital Transformation이 가속화됨에 따라 산업 현장에서 발생하는 방대하고 다양한 데이터의 관리를 위해 다양한 측정 장비가 도입되는 추세입니다. 이번 프로젝트에서는 데이터를 효과적으로 관리하기 위해 IoT 및 smartfactory 환경을 가정하여 반도체 8대 공정 중 Cleaning 공정 솔루션을 개발했습니다. 구체적으로 Process1을 Clean1-Clean2-Rinse1으로, Process2를 Clean3-Rinse2로 가정하고 데이터는 각 공정을 완료하는 데 걸리는 시간으로 가정했습니다.
### Background Knowledge

### purpose

### Programming Tools

## Oracle DB

## Java Tree

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
