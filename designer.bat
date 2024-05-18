@echo off
chcp 65001 > nul
color e
set GEMINI_API=myAPI
set JAR_PATH=%~dp0target\DesignerAssistant-1.0-SNAPSHOT-jar-with-dependencies.jar
java -jar "%JAR_PATH%" %*