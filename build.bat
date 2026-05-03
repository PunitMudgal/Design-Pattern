@echo off
echo Compiling Java files...
javac -d out (Get-ChildItem -Recurse -Filter *.java).FullName
echo Done!
pause