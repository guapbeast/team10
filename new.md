<style>
.parent {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-template-rows: repeat(6, 1fr);
    grid-column-gap: 25%;
    grid-row-gap: 100px;
    }
    
    .div1 { grid-area: 1 / 1 / 2 / 2; }
    .div2 { grid-area: 1 / 2 / 2 / 4; }
    .div3 { grid-area: 2 / 1 / 3 / 2; }
    .div4 { grid-area: 2 / 2 / 3 / 4; }
    .div5 { grid-area: 3 / 1 / 4 / 2; }
    .div6 { grid-area: 3 / 2 / 4 / 4; }
    .div7 { grid-area: 4 / 1 / 5 / 2; }
    .div8 { grid-area: 4 / 2 / 5 / 4; }
    .div9 { grid-area: 5 / 1 / 6 / 2; }
    .div10 { grid-area: 5 / 2 / 6 / 4; }
    .div11 { grid-area: 6 / 1 / 7 / 2; }
    .div12 { grid-area: 6 / 2 / 7 / 4; }

    textarea{
    resize:none;
    color: #333;
    width: 440px;
    height: 200px;
    /* padding-left: 25%;
    padding-right: 25%; */

    transition: box-shadow 320ms;

    box-shadow: 25% 25% 8px 25% red;
    
    border-radius: 3px;
    font-size: 18px;
    border: 25%;
}

textarea:focus {

    outline: 25%;
    outline-offset: 25%;
    box-shadow: 25% 25% 1px 5px rgba(219, 14, 14, 0.12);
}

textarea:-moz-placeholder {
    color: #000000;
}
.new {
        top:5%;
        background-color:#eeeeee;
        color: #c30000;
        border-color: #c30000;
        font-size: 25px;
        font-weight: 700;
        border-radius:25%; 
        padding:0%;
        min-height:30px; 
        min-width: 660px;
    }
    .new:hover {
        cursor: pointer;
        background-color: #c30000;
        color: #fff;
        transition: 0.5s;
    }
      </style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="module" src="new.js"></script>

<body style="background:white">
          <!-- Start of body content specific to page -->
          <center>
            <br>
          <h1>Itinerary Planning</h1>
          <b><hr style="height:2px;color:black;width:25%;background-color:black"></b>
          <br><br>
          </center>
          <div class="parent">
            <div class="div1"><img style="margin-top: 95%; margin-left: 0%; width: 100px; height: 100px;" src="https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/suitcase.png"></div>
            <div class="div2" style="margin-left:25%"> <h2 style="margin-left:50%">Packing</h2> <br> 
                  <textarea id='packing-input' placeholder='Enter all of your packing needs'></textarea> <br><br> <div style="padding-left: 10%"><input id="expenses1" type="number" placeholder='Enter possible expenses'></div> </div>
            <div class="div3"><img style="margin-top: 95%; margin-left: 0%; width: 100px; height: 100px;" src="https://cdn-icons-png.flaticon.com/512/0/614.png"></div>
            <div class="div4" style="margin-left:25%"> <h2 style="margin-left:50%">Travel</h2> <br> 
                  <textarea id='travel-input' placeholder='Enter all planned modes of travel'></textarea> <br><br> <div style="padding-left: 10%"><input id="expenses2" type="number" placeholder='Enter possible expenses'></div> </div>
            <div class="div5"><img style="margin-top: 95%; margin-left: 0%; width: 100px; height: 100px;" src="https://uxwing.com/wp-content/themes/uxwing/download/food-and-drinks/meal-food-icon.png"></div>
            <div class="div6" style="margin-left:25%"><h2 style="margin-left:50%">Food</h2> <br> 
                  <textarea id='travel-input' placeholder='Enter all planned modes of travel'></textarea> <br><br> <div style="padding-left: 10%"><input id="expenses3" type="number" placeholder='Enter possible expenses'></div> </div>
            <div class="div7"><img style="margin-top: 95%; margin-left: 0%; width: 100px; height: 100px;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAb1BMVEX///8AAAC7u7tqamqjo6MnJyfb29uqqqrl5eXx8fF5eXn39/f5+fnr6+vf398wMDAdHR1BQUG0tLRHR0eMjIxiYmLDw8OdnZ3MzMxvb29OTk5GRkYWFhY7OzuEhITGxsZbW1uTk5NWVlY2NjZ+fn5hetxnAAAD50lEQVR4nO3d6XaiQBCGYdoFBQwuUVxjYuL9X+NoJiYB6bK6JVYX53v+Dki/h4hIgxNFAAAAAAAAAAAAAAAAAAAAAAAALZMv027JsTeUHlOTko2psZAeVnOSur6T8Uh6ZE0ZWwrNRnpkDenYAo1ZSY+tGW/2wrX02JphDzQv0mNrBlHYlx5bM1CoHwr1Q6F+KNQPhfqhUD8U2mTxYL/ebDdv3XRZPD1qtD68CofLbXnRybp44JjdeBQW09rF94HuSefC2cS6Qpo9ePAsjoV5/f67GDx8/Le5FR7IvpP38K6yOhXWXh0v2yUCESSHwuHtvrPaKY+k6DSsWA15b3t+ITPQmOtjatLlrutmt01nN+eQiPXLhTl/w9U/1PjuFFJKX5wn1iwV2iZw6lQuJT/dm3DbntiTxGqlwheXDR5LmyAmDprzHt9ZOHfb3qvn3r/He35PofM76dcWiNmthtWfUxEr/Cq0TjLazH/WHdwxZld15//E4j+FHrshESk0qWeh8y78fbB5aKEZX51TEQt/F658NpXJFBpTPagSi34Xpj4bGkgVVmfniSX7jGXsXsQKzcy10POkKxErLCcSy10Ke36b6cgVlv5QicUuhZ5fDPaChSZ3Kvzw28izZKEZORSOPLexEy3cOBRmvhvJJAvNkl/o/fUuES38vppCLPJV6PDlvnYTUoXbvy+MZQsvn4rEEl+F7CtQVdKFhlvo/R39Sbpw2e5j6Rn3E98+FUMbiRcOmIXPfi//IfqJ/6nPLNz7vfxavvDzDJz450uh58WyXgCFR16h56EmDqDQ8Ao934hRCIUrXqHXGPdBFM55hV7fn+IgCqfM66WOsxZnz1EQhacPZeIffwo9jjWvgRTmzHmLg+sLT6NACjvc2TXXM7c8lMIlt9Dxwv4hCqXwyJ4DdjrYlB7sky1c8O9UcPjY32XhFE75hSP+W7F8u4lsYd/hfhr2d/3K/TSyhTuXe6J4lxU/qpPpsoXG6b62jDEXfP3gqabCKFrfer3Z9Tq6CqOCfLW3uhsTlRVSJ3Dj19oV1BVGo8OubumF7f45fYUn8bxfXnQxs9/rqbLwJIk7598LWafzXkHf4lksupLwzEwLoFA/FOpHFE6afkTisYr8ZqF6k1nbC///npf0GP5Y2vpCE7e+kLxe2grktbZ2QKF+KNQPhfqhUD8U6odC/VCoHwr1Q6F+KNSPLJz3dCDvmyQLLT/4EhzyCUmy0PqzPYEhfxIBhSqgEIXhQyEKw4dCFIYPhSgMHwpRGD4UojB8KERh+FDY9kLiubaFlv+ce0g9/yc9OAAAAAAAAAAAAAAAAAAAAAAAgCb9AzqPYiBuj4AyAAAAAElFTkSuQmCC"></div>
            <div class="div8" style="margin-left:25%"><h2 style="margin-left:50%">Places to Stay</h2> <br> 
                  <textarea id='places-input' placeholder='Enter all planned places to stay'></textarea> <br><br> <div style="padding-left: 10%"><input id="expenses4" type="number" placeholder='Enter possible expenses'></div> </div>
            <div class="div9"><img style="margin-top: 95%; margin-left: 0%; width: 100px; height: 100px;" src="https://static.thenounproject.com/png/453090-200.png"></div>
            <div class="div10" style="margin-left:25%"><h2 style="margin-left:50%">Activities</h2> <br> 
                  <textarea id='activities-input' placeholder='Enter all planned activities'></textarea> <br><br> <div style="padding-left: 10%"><input id="expenses5" type="number" placeholder='Enter possible expenses'></div> </div>
            <div class="div11"><img style="margin-top: 95%; margin-left: 0%; width: 100px; height: 100px;" src="https://cdn-icons-png.flaticon.com/512/78/78686.png"></div>
            <div class="div12" style="margin-left:25%"><h2 style="margin-left:50%">Important Notes</h2> <br> 
                  <textarea id='notes-input' placeholder='Enter any important notes to remember'></textarea> <br><br> <div style="padding-left: 10%"><input id="expenses6" type="number" placeholder='Enter possible expenses'></div> </div>
            </div>
            <br><br><br><br><br>
            
            <center>
            <button>Calculate Total expenses</button>
            </center>

            <br><br><br>
            <center>
            <button class="new">Create</button>
            </center>
            <br><br>
          <!-- End of body content specific to page -->
</body>
