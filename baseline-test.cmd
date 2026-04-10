@echo off
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot"
set "PATH=C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot\bin;%PATH%"
"C:\Users\Administrator\.maven\maven-3.9.14\bin\mvn.cmd" -q test
exit /b %ERRORLEVEL%
