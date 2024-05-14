@echo off
chcp 65001 > nul
set JAR_PATH=%~dp0out\artifacts\DesignerAssistant_jar\DesignerAssistant.jar
java -jar "%JAR_PATH%" %*