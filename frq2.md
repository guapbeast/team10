<button onclick="getUserInfo()">User info</button>

<button onclick="createUser()">Create user</button>

<p>User info:</p>
<p id="userInfoName"></p>
<p id="userInfoEmail"></p>

<p id="userInfoPassword"></p>
<p id="userInfoDob"></p>
<p id="userInfoHeight"></p>
<p id="userInfoWeight"></p>
<p id="userInfoIncome"></p>
<p id="userInfoStats"></p>




<script>
  
  function getUserInfo() {
    let idInput = prompt("ID?");

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
  
          document.getElementById("userInfoIncome").innerHTML = 
        "income: " + data.income;
      
      })
  }


  function createUser() {
    let createUserInput = prompt("Create user info?");

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
