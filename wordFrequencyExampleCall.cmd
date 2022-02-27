@ECHO OFF

curl -F file=@"exampleText/test.txt" http://localhost:8080/uploadFile

PAUSE