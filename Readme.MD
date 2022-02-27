# Word Frequency

Aplikacja REST, której celem jest zliczanie powtarzających się słów w wybranym pliku.txt <br>
Domyślny limit rozmiar plików - 500MB [app.properties](https://github.com/pkowalecki/wordFrequency/blob/master/src/main/resources/application.properties) <br>
[wordFrequencyStartApp.cmd](https://github.com/pkowalecki/wordFrequency/blob/master/wordFrequencyStartApp.cmd) - skrypt włączający aplikację <br>
[wordFrequencyStartApp.cmd](https://github.com/pkowalecki/wordFrequency/blob/master/wordFrequencyExampleCall.cmd) - skrypt wywołujący przykładowy call z plikiem .txt

## Działanie aplikacji

Za pomocą programu do sprawdzania połączeń z API (POSTMAN) wykonujemy połączenie POST do aplikacji: <br><br>

<img src = "/images/post.png" width="1000"> <br><br>

W odpowiedzi otrzymujemy zasumowaną liczbę podzielonych i posortowanych według występowania listę słów <br> <br>

<img src = "/images/respo.png" width="1000"> <br><br>
