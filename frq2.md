

<div style="margin: 0 auto; text-align: center">
  <h5 style="text-align: center; font-size: 30px">
    Create New User
  </h5>
  <form method="POST" id="newUserForm">
    <p>
      <input
        type="email"
        name="email"
        id="email"
        placeholder="email"
        class="text"
      />
    </p>
    <p>
      <input 
        type="password" 
        name="password" 
        id="password" 
        placeholder="password"
        class="text"
      />
    </p>
    <p>
      <input
        type="text"
        name="name"
        id="name"
        placeholder="name"
      />
    </p>
    <p>
      <input
        type="text"
        name="dob"
        id="dob"
        placeholder="dob"
      />
    <p>
      <input
        type="text"
        name="height"
        id="height"
        placeholder="height"
      />
    </p>
    <p>
      <input 
        type="text" 
        name="weight" 
        id="weight" 
        placeholder="weight"
      />
    </p>
    <input value="Submit" type="submit" class="button"/>
  <form>

  <p></p>
  <table id = "users">
    <thead>
      <tr>
        <th>id</th>
        <th>email</th>
        <th>password</th>
        <th>name</th>
        <th>height</th>
        <th>weight</th>
        <th>goalstep</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>

  <h5 style="text-align: center; font-size: 30px">
    Create New Log
  </h5>
  <form method="POST" id="newStepLogForm">
    <p>
      <input
        type="text"
        name="id"
        id="id"
        placeholder="id"
      />
    <p>
      <input
        type="text"
        name="date"
        id="date"
        placeholder="date"
      />
    <p>
      <input
        type="text"
        name="steps"
        id="steps"
        placeholder="steps"
      />
    <p>
      <input
        type="text"
        name="calories"
        id="calories"
        placeholder="calories"
      />
    </p>
    <input value="Submit" type="submit" class="button"/>
  <form>

  <h5 style="text-align: center; font-size: 30px">
    Get Stats
  </h5>
  <form method="POST" id="getStepLogForm">
      <input
        type="text"
        name="id"
        id="idInput"
        placeholder="id"
      />
    <input value="Submit" type="submit" class="button"/>
  <form>

  <p></p>
  <table id = "stepLogReport">
    <thead>
      <tr>
        <th>id</th>
        <th>goalstep</th>
        <th>totalSteps</th>
        <th>daysRecorded</th>
        <th>activeDays</th>
        <th>caloriesConsumed</th>
        <th>caloriesBurnt</th>
        <th>netCalories</th>
        <th>netWeightReport</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>

  <p></p>
  <table id = "stepLogStats">
    <thead>
      <tr>
        <th>id</th>
        <th>date</th>
        <th>steps</th>
        <th>calories</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>
<div>

<script>
      function submitform(event) {
        event.preventDefault();

        const data = new FormData(event.target);

        const queryString = new URLSearchParams(data).toString();
        
        fetch("https://music.nighthawkcoders.tk/api/person/post/?" + queryString, {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          }
        })
        
        const form = document.getElementById("newUserForm");
        form.reset();
      }

      const form = document.getElementById("newUserForm");
      form.addEventListener("submit", submitform);

  const userContainer = document.getElementById("users");
  const stepTrackerContainer = document.getElementById("steptracker");

  const url = "https://music.nighthawkcoders.tk/api/person/";

  const options = {
      method: 'GET',
      headers: {
      'Content-Type': 'application/json'
      },
  };

  const putOptions = {
      method: 'PUT', 
      headers: {
      'Content-Type': 'application/json'
      },
  };

  function getStats() {
    fetch(url, options)
      .then(response => {
        if (response.status !== 200) {
            const errorMsg = 'Database response error: ' + response.status;
            console.log(errorMsg);
            const tr = document.createElement("tr");
            const td = document.createElement("td");
            td.innerHTML = errorMsg;
            tr.appendChild(td);
            userContainer.appendChild(tr);
            return;
        }
        response.json().then(data => {
            for (const row of data) {

              const tr = document.createElement("tr");

              const id = document.createElement("td");
              const email = document.createElement("td");
              const password = document.createElement("td");
              const name = document.createElement("td");
              const height = document.createElement("td");
              const weight = document.createElement("td");
              const gender = document.createElement("td");
              const age = document.createElement("td");
              const goalstep = document.createElement("td");

              id.innerHTML = row.id;
              email.innerHTML = row.email;
              password.innerHTML = row.password;
              name.innerHTML = row.name;
              height.innerHTML = row.height;
              weight.innerHTML = row.weight;
              goalstep.innerHTML = row.goalstep;

              tr.appendChild(id);
              tr.appendChild(email);
              tr.appendChild(password);
              tr.appendChild(name)
              tr.appendChild(height);
              tr.appendChild(weight);
              tr.appendChild(gender);
              tr.appendChild(age);
              tr.appendChild(goalstep);

              userContainer.appendChild(tr);
            }
        })
    })
  }

  getStats();
</script>