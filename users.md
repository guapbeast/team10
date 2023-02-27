<h2 id="sql-database">SQL Database</h2>
<!-- HTML table fragment for page -->
<table>
  <thead>
  <tr>
    <th>Name</th>
    <th>Email</th>
    <th>Age</th>
    <th>Delete</th>
  </tr>
  </thead>
  <tbody id="result">
    <!-- javascript generated data -->
  </tbody>
</table>

<script>
// prepare HTML result container for new output
  const resultContainer = document.getElementById("result");

  // prepare URL
  var url = "https://music.nighthawkcoders.tk/api/person/";
  // Uncomment next line for localhost testing
  // url = "http://localhost:8032/api/person/";

  // set options for cross origin header request
  const options = {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    mode: 'cors', // no-cors, *cors, same-origin
    cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'include', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const requestOptions = {
    method: 'DELETE', // *GET, POST, PUT, DELETE, etc.
    mode: 'cors', // no-cors, *cors, same-origin
    cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'include', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json',
    },
  };

  function deleteUser(email) {
    fetch("https://music.nighthawkcoders.tk/api/person/del/" + email, requestOptions).then((res) => {
            if (res.status == 200 || res.status == 204) {
                location.reload();
            } else {
                document.getElementById('message').innerHTML = "Error: " + res.status;
            }
        });
  }
  // fetch the API
  fetch(url, options)
    // response is a RESTful "promise" on any successful fetch
    .then(response => {
      // check for response errors and display
      if (response.status !== 200) {
          const errorMsg = 'Database response error: ' + response.status;
          console.log(errorMsg);
          const tr = document.createElement("tr");
          const td = document.createElement("td");
          td.innerHTML = errorMsg;
          tr.appendChild(td);
          resultContainer.appendChild(tr);
          return;
      }
      // valid response will contain json data
      response.json().then(data => {
          console.log(data);
          for (const row of data) {
            // tr and td build out for each row
            const tr = document.createElement("tr");
            const name = document.createElement("td");
            const id = document.createElement("td");
            const age = document.createElement("td");
            const remove = document.createElement("td");
              const delete_but = document.createElement('button');
              delete_but.id = row.id;
              delete_but.innerHTML = "Delete";
              delete_but.onclick = function () {
                deleteUser(row.email)
              }
              remove.appendChild(delete_but);
            // data is specific to the API
            name.innerHTML = row.name; 
            id.innerHTML = row.email; 
            age.innerHTML = row.age; 
            
            // this build td's into tr
            tr.appendChild(name);
            tr.appendChild(id);
            tr.appendChild(age);
            tr.appendChild(remove);
            // add HTML to container
            resultContainer.appendChild(tr);
          }
      })
  })
  // catch fetch errors (ie ACCESS to server blocked)
  .catch(err => {
    console.error(err);
    const tr = document.createElement("tr");
    const td = document.createElement("td");
    td.innerHTML = err + ": " + url;
    tr.appendChild(td);
    resultContainer.appendChild(tr);
  });
</script>