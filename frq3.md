<style> @import url('https://fonts.googleapis.com/css2?family=Oswald:wght@700&family=Source+Sans+Pro:wght@200;700&display=swap'); </style>
<style>
  input[type=button], input[type=submit]{
    display: inline-block;
    outline: none;
    cursor: pointer;
    font-size: 16px;
    line-height: 20px;
    font-weight: 600;
    border-radius: 8px;
    /* padding: 14px 24px; */
    border: none;
    transition: box-shadow 0.2s ease 0s, -ms-transform 0.1s ease 0s, -webkit-transform 0.1s ease 0s, transform 0.1s ease 0s;
    background: linear-gradient(to right, rgb(230, 30, 77) 0%, rgb(227, 28, 95) 50%, rgb(215, 4, 102) 100%);
    color: #fff;
  }
</style>
<form method="GET" id="calcForm">
    <table style="height:50%" id="calcu" class="container">
        <tr>
            <td colspan='4'><input style="width: 80%" type="text" class="result" name="input" id="calcFormInput" th:value="${output}" /><input style="width: 20% ; height: 50px" type="button" value="c" onclick="clr()" /> </td>
        </tr>
        <tr class="first-row">
            <!-- create button and assign value to each button -->
            <!-- dis("1") will call function dis to display value -->
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="1" onclick="dis('1')" class="box" name="" onkeydown="myFunction(event)" /></td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="2" onclick="dis('2')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="3" onclick="dis('3')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="/" onclick="dis('/')" class="box" name="" onkeydown="myFunction(event)" /> </td>
        </tr>
        <tr class="second-row">
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="4" onclick="dis('4')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="5" onclick="dis('5')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="6" onclick="dis('6')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="*" onclick="dis('*')" class="box" name="" onkeydown="myFunction(event)" /> </td>
        </tr>
        <tr class="third-row">
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="7" onclick="dis('7')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="8" onclick="dis('8')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="9" onclick="dis('9')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="-" onclick="dis('-')" class="box" name="" onkeydown="myFunction(event)" /> </td>
        </tr>
        <tr class="conflict">
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="." onclick="dis('.')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="0" onclick="dis('0')" class="box" name="" onkeydown="myFunction(event)" /> </td>
            <!-- solve function call function solve to evaluate value -->
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="submit" name="" value="Submit" class=" green white-text big" /> </td>
            <td style="padding: 1px"><input style="width: 125px; height:125px" type="button" value="+" onclick="dis('+')" class="box" name="" onkeydown="myFunction(event)" /> </td>
        </tr>
    </table>
</form>
<script>
    // Function that display value
    function dis(val) {
        document.getElementById("calcFormInput").value += val;
        varvar = document.getElementById("calcFormInput").value;
        console.log("varvar");
    }
    function myFunction(event) {
        if (event.key == '0' || event.key == '1' 
            || event.key == '2' || event.key == '3'
            || event.key == '4' || event.key == '5' 
            || event.key == '6' || event.key == '7'
            || event.key == '8' || event.key == '9' 
            || event.key == '+' || event.key == '-'
            || event.key == '*' || event.key == '/')
            document.getElementById("calcFormInput").value += event.key;
    }
var cal = document.getElementById("calcu");
    cal.onkeyup = function (event) {
        if (event.keyCode === 13) {
            console.log("Enter");
            let x = document.getElementById("calcFormInput").value
            console.log(x);
        }
    }
// Function that clear the display
    function clr() {
        document.getElementById("calcFormInput").value = ""
    }
    function submitform(event) {
      event.preventDefault();
      const inputElement = document.getElementById("calcFormInput")   ;                                 
      const expression = String(inputElement.value);      
      console.log(expression)
      console.log(typeof expression)
      // expression = String(expression)
      const url = "https://music.nighthawkcoders.tk/api/calculator/"
      // const options = {
      //   method: 'POST', // *GET, POST, PUT, DELETE, etc.
      //   mode: 'no-cors', // no-cors, *cors, same-origin
      //   cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
      //   credentials: 'same-origin', // include, same-origin, omit
      //   headers: {
      //     'Content-Type': 'text/plain',
      //     //'Content-Type': 'application/x-www-form-urlencoded',
      //   },
      //   body: expression
      // };
      console.log(url + expression);
      fetch(url + expression)
        .then(res => res.json())
        .then(data => {
          console.log(data);
          console.log(data['results']);
          console.log(inputElement.value);
          inputElement.value = data['results'];
          console.log(inputElement.value);
        })
      // fetch(url + expression)
      // .then((response) => {
      //   console.log(response)
      // // check for response errors
      //   if (response.status == 200) {
      //     return response.json().then((data) => {
      //       inputElement.value = data.result;
      //     });
      //   } else if (response.status == 400){
      //     return response.json().then((data) => {
      //       inputElement.value = data.error;
      //     }); 
      //   } else {
      //     return response.text().then((text) => {
      //       console.log(text);
      //     });
      //   }
      // })
      // .catch(e => {
      //   console.error(e);
      //   inputElement.value = "invalid expression";
      // })
    }
    const form = document.getElementById("calcForm");
    form.addEventListener("submit", submitform);
</script>