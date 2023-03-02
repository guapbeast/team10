<style>
    .new {
        top:5%;
        background-color:#eeeeee;
        color: #c30000;
        border-color: #c30000;
        font-size: 25px;
        font-weight: 700;
        border-radius:10px; 
        padding:15px;
        min-height:30px; 
        min-width: 120px;
    }
    .new:hover {
        cursor: pointer;
        background-color: #c30000;
        color: #fff;
        transition: 0.5s;
    }
    .card {
  box-shadow: 0 4px 8px 0 #c30000;
  transition: 0.3s;
  border-radius: 5px; /* 5px rounded corners */
  width:30%
}
</style>

<button onclick="window.location.href='/team10/new';" class="new">Add New</button>

<center>
<h1 id="itinerarylist">Your Itineraries</h1>
</center>
<div class="card">
<br>
  <h3>Itinerary #1</h3>
  <div class="container">
    <h4><b>Trip to Hawaii</b></h4>
    <button>Edit</button>
    <button>Delete</button>
    <br><br><br><br><br><br>
  </div>
</div>

<br>
<br>
<script>
  const itineraryList = document.querySelector("itinerarylist");
  const response await fetch("https://music.nighthawkcoders.tk/itinerary/", {
    method: "POST",
    credentials: 'include',
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify{{name, packing, travel, food, hotel, activities, notes}};
    if(!response.ok) {
      alert("Failed to add itinerary. Please try again later");
      return;
    }
    //
  })
  const endpoint = `https://music.nighthawkcoders.tk/itinerary/${name}`;
  fetch(endpoint, {
    method: "DELETE",
    credentials: 'include'
  })
    .then(response => {
      if (!response.ok) {
        throw new Error("Failed to delete itinerary. Please try again later");
      }
      return response.json();
    })
    .then(data => {
      console.log(data);
      alert("Itinerary deleted");
    })
    .catch(error => {
      console.error(error);
      alert("Failed to delete itinerary. Please try again later");
    });
</script>

          <!-- <script>
            function getItineraries() {
                  fetch("https://music.nighthawkcoders.tk/itinerary/",options)
                  .then(response => { 
                        if (response.status !== 200) {
                              const.errorMsg = 'Database response error: ' + response.status;
                              console.log(errorMsg);
                              const tr = document.createElement("tr");
                              const td = document.createElement("td");
                              td.innerHTML = errorMsg;
                              tr.appendChild(td);
                              itinerarylist.appendChild(tr);
                              return;
                        }
                  //if valid
                  while(itinerarylist.firstChild) {
                        itinerarylist.removeChild(itinerarylist.firstChild);
                  }
            for (const row of data) {
                    const card = document.createElement("div");
                    card.classList.add("objectcard");
                    itinerarylist.appendChild(card);
                    const h3 = document.createElement("h3");
                    h3.innerHTML = "Object #" + row.id;
                    const mass = document.createElement("p");
                    mass.innerHTML = "Mass: " + row.mass + "kg";
                    const recKE = document.createElement("p");
                    recKE.innerHTML = "Recent KE Calc: " + row.recentKE;
                    const recPE = document.createElement("p");
                    recPE.innerHTML = "Recent PE Calc: " + row.recentPE;
                    card.appendChild(h3);
                    card.appendChild(mass);
                    card.appendChild(recKE);
                    card.appendChild(recPE); 
                    const buttonholder = document.createElement("div");
                    buttonholder.style.whiteSpace = "nowrap";
                    // create button and give classlist, add to card
                    const button = document.createElement("button");
                    button.classList.add("objectcardbutton");
                    button.style.width = "40%";
                    button.style.display = "inline-block";
                    button.innerHTML = "Select";
                    button.id = "objbutton" + row.id;
                    button.addEventListener("click", function() {
                        selectObj(row.id);
                    });
                    card.appendChild(button);
                    // add deletebutton and give classlist
                    const deletebutton = document.createElement("button");
                    deletebutton.classList.add("objectcardbutton");
                    deletebutton.innerHTML = "Delete";
                    deletebutton.style.backgroundColor = "red";
                    deletebutton.style.border = "1px solid red";
                    deletebutton.style.width = "40%";
                    deletebutton.style.display = "inline-block";
                    deletebutton.addEventListener("click", function() {
                        deleteObj(row.id);
                    });
                    card.appendChild(deletebutton);
                }
                storedinfo = data; 
                });
                  }
            getItineraries();
            </script>
 -->
