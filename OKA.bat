@echo off

REM Definir valores predeterminados
set URL=

REM Asignar parámetros si se proporcionan
if not "%1"=="" set URL="-Dwebdriver.base.url=%1"

REM Ejecutar el comando con los parámetros
mvn clean verify %URL%
