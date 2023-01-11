<div style="text-align: center">
  <input id="numCols" type="text" placeholder="Columns" />
  <input id="numRows" type="text" placeholder="Rows" />
</div>
<div class="button-container-div">
  <button class="button" id="refresh-button">New</button>
 </div>

<div id="table-container"></div>

<script>


const tableContainer = document.getElementById("table-container");

// Generate a button
const generateButton = document.getElementById('refresh-button');

// Create a brand new table every time clicked
function newTable() {
  let numCols = document.getElementById("numCols").value;
  let numRows = document.getElementById("numRows").value;


  fetch(`https://music.nighthawkcoders.tk/api/lightboard/${numRows}/${numCols}`)
    .then(data => data.json())
    .then(data => {
      // Clear the table container
        const table = document.createElement('table');
        table.style.width = '50%';
        table.style.margin = '0 auto';


        let currentRow;
        for (const { row, column, light } of data) {
        if (row !== currentRow) {
            currentRow = row;
            const tr = document.createElement('tr');
            table.appendChild(tr);
        }

        // Make a cell with RGB color input
        const td = document.createElement('td');
        td.style.backgroundColor = `rgb(${light.red}, ${light.green}, ${light.blue})`;

        // brightness level text color
        const brightness = (light.red * 299 + light.green * 587 + light.blue * 114) / 1000;
        if (brightness < 128) {
          td.style.color = 'white';
        } else {
          td.style.color = 'black';
        }

        // Box text style
        td.innerText = `#${light.red.toString(16).padStart(2, '0')}${light.green.toString(16).padStart(2, '0')}${light.blue.toString(16).padStart(2, '0')}`;
        table.lastElementChild.appendChild(td);
      }

    tableContainer.appendChild(table);

    });
}

generateButton.addEventListener('click', newTable);


</script>