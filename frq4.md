<br>
<input type="text" id="row" placeholder="rows">
<p></p>
<input type="text" id="column" placeholder="columns">
<br>
<button onclick="displayLights()">Generate</button>
<div id="lightDisplay"></div>

<script>
   function displayLights() {
    document.getElementById("lightDisplay").innerHTML = ""; 

    var row = document.getElementById("row").value;
    var col = document.getElementById("column").value;
    var tempRed;
    var tempBlue;
    var tempGreen;

    fetch(`https://music.nighthawkcoders.tk/api/light/${row}/${col}`)
    .then(data => data.json())
    .then(data => {
      console.log(data);

      let p = document.createElement("p");
      for (let i = 0; i < row * col; i++) {
        tempRed = data[i].light.red;
        tempGreen = data[i].light.green; 
        tempBlue = data[i].light.blue;
        
        var div = document.createElement("div");
        div.style.width = "50px";
        div.style.height = "50px"; 
        div.style.text = tempRed + ',' + tempGreen + ',' + tempBlue;
        div.style.backgroundColor = 'rgb(' + tempRed + ',' + tempGreen + ',' + tempBlue + ')';
        div.style.display = "inline-block";
        div.style.padding = "5px 5px";
        document.getElementById("lightDisplay").appendChild(div); 

        if ((i+1)%row == 0) {
          document.getElementById("lightDisplay").appendChild(p.cloneNode());
        }
      }
      
    }) 

   }
</script>