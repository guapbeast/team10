{% include frq.html %}
<h3>Users and Info</h3>
<center>
<table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Age</th>
      <th>Date of Birth</th>
      <th>Weight</th>
      <th>Height</th>
      <th>Goal Step</th>
    </tr>
    </thead>
    <tbody id="result">
      <!-- javascript generated data -->
    </tbody>
  </table>
</center>
<script>
  const resultContainer = document.getElementById("result");
  const url = "https://music.nighthawkcoders.tk/api/person/";
  // const options = {
  //     method: 'GET', // *GET, POST, PUT, DELETE, etc.
  //     mode: 'no-cors', // no-cors, *cors, same-origin
  //     cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
  //     credentials: 'same-origin', // include, same-origin, omit
  //     headers: {
  //         'Content-Type': 'application/json'
  //         // 'Content-Type': 'application/x-www-form-urlencoded',
  //     },
  //     };
  fetch("https://music.nighthawkcoders.tk/api/person/")
  // response is a RESTful "promise" on any successful fetch
  .then(response => {
    console.log(response)
    // check for response errors
    if (response.status !== 200) {
        const errorMsg = 'API response error: ' + response.status;
        console.log(errorMsg);
        const tr = document.createElement("tr");
        const td = document.createElement("td");
        td.innerHTML = errorMsg;
        tr.appendChild(td);
        resultContainer.appendChild(tr);
        return;
    }
    // valid response will have json data
    response.json().then(data => {
        console.log(data);
        // Country data
        for (const row of data) {
          console.log(row)
          // tr for each row
            const tr = document.createElement("tr");
            // td for each column
            const id = document.createElement("td");
            const name = document.createElement("td");
            const email = document.createElement("td");
            const age = document.createElement("td");
            const dob = document.createElement("td");
            const weight = document.createElement("td");
            const height = document.createElement("td");
            const goalstep = document.createElement("td");
            // data is specific to the API
            id.innerHTML = row.id;
            name.innerHTML = row.name;
            email.innerHTML = row.email;
            age.innerHTML = row.age;
            dob.innerHTML = row.dob.substring(0,10); 
            weight.innerHTML = row.weight; 
            height.innerHTML = row.height;
            goalstep.innerHTML = row.goalStep;
            // this build td's into tr
            tr.appendChild(id);
            tr.appendChild(name);
            tr.appendChild(email);
            tr.appendChild(age);
            tr.appendChild(dob);
            tr.appendChild(weight);
            tr.appendChild(height);
            tr.appendChild(goalstep);
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
    td.innerHTML = err;
    tr.appendChild(td);
    resultContainer.appendChild(tr);
  });
  // function getAllUsers() {
  //   fetch("https://music.nighthawkcoders.tk/api/person/")
  //     .then(data => data.json())
  //     .then(data => {
  //       console.log(data)
  //       return data
  //     })
  // }
  function getUserById(n) {
    const urlStart = "https://music.nighthawkcoders.tk/api/person/";
    const url = urlStart + n;
    console.log(url); 
    fetch(url)
      .then(res => {res.json()
      .then(data => {
        console.log(data);
        document.getElementById("userInfoName").innerHTML = 
        "name: " + data.name;
        document.getElementById("userInfoEmail").innerHTML = 
        "email: " + data.email;
        document.getElementById("userInfoPassword").innerHTML = 
        "password: " + data.password;
        document.getElementById("userInfoDob").innerHTML = 
        "dob: " + data.dob;
        document.getElementById("userInfoHeight").innerHTML = 
        "height: " + data.height;
         document.getElementById("userInfoWeight").innerHTML = 
        "weight: " + data.weight;
      })})
  }
  function createUser() {
    const urlStar = "https://music.nighthawkcoders.tk/api/person/post?";
    const url = urlStar;
    console.log(url); 
    const email = document.getElementById("inputEmail").value
    const password = document.getElementById("inputPassword").value
    const name = document.getElementById("inputName").value
    const dob = document.getElementById("inputDob").value
    const height = document.getElementById("inputHeight").value
    const weight = document.getElementById("inputWeight").value
    options = {
        method: 'POST',
        mode: 'no-cors', // no-cors, *cors, same-origin
        // cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
        // credentials: 'same-origin', // include, same-origin, omit
        headers: {
            'Content-Type': 'application/json'
        },
        // body: JSON.stringify ({
        //     email: email,
        //     password:  password,
        //     name: name,
        //     dob: dob,
        //     height: height,
        //     weight: weight
        // })
    };
    const final = url +'email=' + email + '&password=' + password + '&name=' + name + '&dob=' + dob + '&height=' + height + '&weight=' + weight;
    console.log(final)
    console.log(options)
    fetch(final, options)
    location.reload()
  }
  function deleteUserById() {
    const id = document.getElementById("deleteId").value
    fetch("https://music.nighthawkcoders.tk/api/person/delete/" + id, {
        method: 'DELETE',
        mode: 'cors', // no-cors, *cors, same-origin
        // cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
        // credentials: 'same-origin', // include, same-origin, omit
        headers: {
            'Content-Type': 'application/json'
        }
    })
    // .then(res => res.json())
      // .then(res => {console.log(res); console.log(res.json); res.json().then(data => {
      //   console.log(data);
      // })})
    // location.reload()
  }
  function deleteUserByEmail() {
    const email = document.getElementById("deleteEmail").value
    fetch("https://music.nighthawkcoders.tk/api/person/del/" + email, {
        method: 'DELETE',
        mode: 'cors', // no-cors, *cors, same-origin
        // cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
        // credentials: 'same-origin', // include, same-origin, omit
        headers: {
            'Content-Type': 'application/json'
        }
    })
    // .then(res => res.json())
    //   .then(res => {console.log(res); console.log(res.json); res.json().then(data => {
    //     console.log(data);
    //   })})
    // location.reload()
  }
  
</script>

<input id="inputEmail" placeholder="Email">
<input id="inputPassword" placeholder="Password">
<input id="inputName" placeholder="Name">
<input id="inputDob" placeholder="Date of Birth">
<input id="inputHeight" placeholder="Height">
<input id="inputWeight" placeholder="Weight">
<button onclick="createUser()">Create user</button>
<br><br><br><br><br><br><br><br><br><br>
<p hidden></p>
<input id="deleteId" placeholder="Id" hidden>
<button onclick="deleteUserById()" hidden>Delete user</button>

<input id="deleteEmail" placeholder="Email" hidden>
<button onclick="deleteUserByEmail()" hidden>Delete user</button>
