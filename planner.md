<html>

    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/png" href="plans.png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Nunito&display=swap');

    

        button{
            padding: 8px;
            outline: none;
            cursor: pointer;
            border: 1px solid lightgray;
            border-radius: 5px;
            background: whitesmoke;
        }

        button:hover{
            background-color: rgba(0, 0, 0, 0.1);
        }

        .container{
            width: 1280px;
            margin: auto;
        }

        #header button{
            font-family: Lobster;
        }

        #create_card{
            display: none;
            width: 370px;
            margin:auto;
            padding: 20px;
            margin-top: 10px;
            background: whitesmoke;
            box-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.9);
        }

        #create_card h2{
            color: black;
            text-align: center;
        }

        #create_card textarea{
            width: 100%;
            border-radius: 5px;
            font-family: inherit;
            border: 1px solid lightgray;
            resize: none;
        }

        #create_card button{width: fit-content;}

        #plans{
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            width: 100%;
            margin: auto;
            margin-top: 10px;
            padding: 0px 10px;
        }

        .plans{
            width: 370px;
            height: 200px;
            word-wrap: break-word;
            margin: 10px;
            background:#fff;
            cursor: pointer;
            box-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.9);
            position: relative;
        }

        .plans h2{font-size: 1rem;}

        .fa-minus{
            top: 3%;
            right: 2%;
            position: absolute;
            color: #1a1a1a;
            transition: 0.3s ease-out;
        }

        .fa-minus:hover{color: red;}

        @media(max-width:1280px){
            .container{width: 100%;}
        }

        @media(max-width:768px){
            .plans{margin: auto;}

            .plans{
                margin-top: 10px;
                margin-bottom: 10px;
            }
        }

<!--> determines the width and characteristics of the planner cards -->
        @media(max-width:480px){
            #header{
                padding: 20px;
                gap: 10px;
                flex-direction: column;
                align-items: center;
            }

            #create_card{width: 95%;}

            .plans{width: 100%;}

        }
    </style>
        <title>plans</title>
    </head>
    <body>

    <main>

        <header>
            <div class="container">
                <div id="header">
                    <h1>plans</h1>
                    <div>
                        <button id="show_card_box">Add Card</button>
                        <button id="delete_cards">Delete Cards</button>
                    </div>
                </div>
            </div>
        </header>

        <section>
            <div class="container">
                <div id="create_card">
                    <h2>Create plans</h2>
                    <label for="Destination">Destination</label>
                    <textarea id="Destination" maxlength="280"></textarea>
                    <label for="Plans" maxlength="280">Plans</label>
                    <br>
                    <textarea id="Plans"></textarea>
                    <div>
                        <button id="save_card">Save</button> <button id="close_card_box">Close</button>
                    </div>
                </div>
            </div>
        </section>

        <section class="page">
            <div class="container">
            
                <div id="plans"></div>
            </div>
        </section>

    </main>

    <script>
        var contentArray = localStorage.getItem('items') ? JSON.parse(localStorage.getItem('items')) : [];

        document.getElementById("save_card").addEventListener("click", () => {
            addplans();
        });

        document.getElementById("delete_cards").addEventListener("click", () => {
            localStorage.clear();
            plans.innerHTML = '';
            contentArray = [];
        });

        document.getElementById("show_card_box").addEventListener("click", () => {
            document.getElementById("create_card").style.display = "block";
        });

        document.getElementById("close_card_box").addEventListener("click", () => {
            document.getElementById("create_card").style.display = "none";
        });

        plansMaker = (text, delThisIndex) => {
            const plans = document.createElement("div");
            const Destination = document.createElement('h2');
            const Plans = document.createElement('h2');
            const del = document.createElement('i');

            plans.className = 'plans';

            Destination.setAttribute("style", "border-top:1px solid red; padding: 15px; margin-top:30px");
            Destination.textContent = text.my_Destination;

            Plans.setAttribute("style", "text-align:center; display:none; color:red");
            Plans.textContent = text.my_Plans;

            del.className = "fas fa-minus";
            del.addEventListener("click", () => {
                contentArray.splice(delThisIndex, 1);
                localStorage.setItem('items', JSON.stringify(contentArray));
                window.location.reload();
            })

            plans.appendChild(Destination);
            plans.appendChild(Plans);
            plans.appendChild(del);

            plans.addEventListener("click", () => {
                if(Plans.style.display == "none")
                    Plans.style.display = "block";
                else
                    Plans.style.display = "none";
            })

            document.querySelector("#plans").appendChild(plans);
        }

        contentArray.forEach(plansMaker);

        addplans = () => {
            const Destination = document.querySelector("#Destination");
            const Plans = document.querySelector("#Plans");

            let plans_info = {
                'my_Destination' : Destination.value,
                'my_Plans'  : Plans.value
            }

            contentArray.push(plans_info);
            localStorage.setItem('items', JSON.stringify(contentArray));
            plansMaker(contentArray[contentArray.length - 1], contentArray.length - 1);
            Destination.value = "";
            Plans.value = "";
        }
    </script>
    </body>
    </html>
</html>