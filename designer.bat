@echo off
chcp 65001 > nul
color e
set JAR_PATH=%~dp0out\artifacts\DesignerAssistant_jar\DesignerAssistant.jar
java -jar "%JAR_PATH%" %*