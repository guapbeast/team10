<!--- This section is Cascading Style Sheet (CSS) and applies to HTML -->
<style>
/* "row style" is flexible size and aligns pictures in center */
.body { 
  background-color: #1DE1FC; 
}

/* "column style" is one-third of the width with padding */
.column {
  flex: 33.33%;
  padding: 5px;
}
</style>


<button onclick="getUserInfo()">User info</button>

<button onclick="createUser()">Create user</button>

<p>User info:</p>
<p id="userInfoName"></p>
<p id="userInfoEmail"></p>

<p id="userInfoPassword"></p>
<p id="userInfoDob"></p>
<p id="userInfoHeight"></p>
<p id="userInfoWeight"></p>
<p id="userInfoGoalStep"></p>
<p id="userInfoStats"></p>




<script>
  
  function getUserInfo() {
    let idInput = prompt("User ID:");

    const urlStart = "https://music.nighthawkcoders.tk/api/person/";
    const url = urlStart + idInput;

    console.log(url); 

    fetch(url)
      .then(res => res.json())
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
  
        document.getElementById("userInfoGoalStep").innerHTML = 
        "Step Goal: " + data.goalStep;
      
      })
  }


  function createUser() {
    let createUserInput = prompt("User Info:");

    const urlStart = "https://music.nighthawkcoders.tk/api/person/post";
    const url = urlStart;

    console.log(url); 

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify ({
            email: 'test@gmail.com'
        })
    })
      .then(res => {
        return res.json()
    })
      .then(data => {
        console.log(data);
      
      })
  }
  
</script>
