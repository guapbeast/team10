<input id="inputRow" placeholder="# Rows">
<input id="inputCol" placeholder="# Columns">
<button onclick="lights(getRow(), getCol())">Submit</button>
<!-- <table>
    <thead>
      <tr>
        <th>Row</th>
        <th>Column</th>
        <th>On</th>
        <th>Red</th>
        <th>Green</th>
        <th>Blue</th>
        <th>Effect</th>
      </tr>
    </thead>
    <tbody id="lights">
    </tbody>
  </table> -->

<script>
function lights(row, col) {
    result = document.getElementById("lights");

    fetch(`https://music.nighthawkcoders.tk/api/lights/create/{row}/{col}`)
        .then(function(response) {
            response.json()
            .then((data) => {
              console.log(data);
              if (data.length > 0) {
                var temp = "";
                data.forEach((itemData) => {
                    temp += "<tr>";
                    temp += "<td>" + itemData.row + "</td>";
                    temp += "<td>" + itemData.column + "</td>";
                    temp += "<td>" + itemData.light.on + "</td>";
                    temp += "<td>" + itemData.light.red + "</td>";
                    temp += "<td>" + itemData.light.green + "</td>";
                    temp += "<td>" + itemData.light.blue + "</td>";
                    temp += "<td>" + itemData.light.effect + "</td></tr>";
                });
                document.getElementById('lights').innerHTML = temp;
                }
            });
          })
}

function getRow(){
    let inputRow = document.getElementById("inputRow").value;
    return inputRow;
}

function getCol(){
    let inputCol = document.getElementById("inputCol").value;
    return inputCol;
}
</script>