

<center>


    <div class="powr-weather" id="be801033_1638823897"></div><script src="https://www.powr.io/powr.js?platform=html"></script>
    <p>To Convert the Fahrenheit temperature to Celsius, inupt below.</p>

    <p>
        <label>Fahrenheit</label>
        <input id="inputFahrenheit" type="number" placeholder="Fahrenheit" oninput="temperatureConvert(this.value)" onchange="temperatureConvert(this.value)">
    </p>
    <p>Celsius: <span id="outputCelsius"></span></p>

    <script>
        function temperatureConvert(valNum) {
            valNum = parseFloat(valNum);
            document.getElementById("outputCelsius").innerHTML=(valNum-32)/1.8;
        }
    </script>


     
    <p>To Convert the Celsius temperature to Fahrenheit, inupt below.</p>

    <p>
        <label>Celsius</label>
        <input id="inputCelsius" type="number" placeholder="Celsius" oninput="temperatureConvert(this.value)" onchange="temperatureConvert(this.value)">
    </p>
    <p>Fahrenheit: <span id="outputFahrenheit"></span></p>

    <script>
        function temperatureConvert(valNum) {
            valNum = parseFloat(valNum);
            document.getElementById("outputFahrenheit").innerHTML=(valNum*1.8)+32;
        }
    </script>
    
    
    <html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>



    </body>
    </html>

</center>

