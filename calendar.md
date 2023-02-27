

<html>
    <style>
        .center {
            width: 1200px;
            height: 700px;
            padding: 10px;
            margin: 60px auto;
        }
        html {
            height:250%
        }
    </style>

    <meta name="viewport" content="width=device-width, initial-scale=3">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


    <html>
        <body style="background-color:#96eede;">
        <div class="centerb">
            <center>

                <div class="centerb">
    <br>
    <br>

        <marquee behavior="alternate" direction="left" scrollamount = "12">
            <h1 style="font-family: 'Comic Sans MS'", >{{ date["currentDateTime"] }}</h1>
        </marquee>
    <br>
    <br>
    <br>
                    <h1 class="w3-text-blue" style="text-shadow:1px 1px 0 #444">
                        <b>AP US History Calendar</b></h1>
                </div>
    <br>

                <table id="calendar" style="padding-bottom: 20px; margin-left:20px;margin-right:20px;">
                    {% block links %}
                    <tr>
                    {% for num in range(1, 32, 1) %}
                        <td class="days" id="calendar{{ num }}" style="border: 2px solid black; height: 200px; width: 200px"><div>{{ num }}
                        {% for row in table %}
                            {% if row.day == num %}
                                <br>{{ row['information'] }}
                            {% endif %}
                        {% endfor %}
                        </div></td>
                    {% if num % 7 == 0 %}
                    </tr>
                    <tr>
                    {% endif %}
                    {% endfor %}
                    {% endblock %}
                        </tr>


                            </table>

                            </center>

                            </div>
        </body>
    </html>



{#                    <div class="container bg-secondary py-4">#}
{#                        <div class="p-5 mb-4 bg-light text-dark rounded-3">#}
{#                            <h2>Add Information to the Calendar</h2>#}
{#                            <form method="POST" ID="create" action={{url_for('crud.createCoolendar')}} >#}
{#                                <table class="table">#}
{#                                    <thead>#}
{#                                    <tr>#}
{#                                        <th><label for="day">Day</label></th>#}
{#                                        <th><label for="information">Information</label></th>#}
{#                                    </tr>#}
{#                                    </thead>#}
{#                                    <tbody>#}
{#                                    <tr>#}
{#                                        <td><input type="text" name="day" id="day" required></td>#}
{#                                        <td><input type="text" name="information" id="information" required></td>#}
{#                                        <td><input type="submit" value="Create"></td>#}
{#                                    </tr>#}
{#                                    </tbody>#}
{#                                </table>#}
{#                                <p id="pswError"></p>#}
{#                            </form>#}
{#                        </div>#}
{#                    </div>#}
{##}
{#                    <div class="container bg-secondary py-4">#}
{#                        <div class="p-5 mb-4 bg-light text-dark rounded-3">#}
{#                            <h2>Delete</h2>#}
{#                            <form method="POST" ID="delete" action={{url_for('crud.deleteCoolendar')}} >#}
{#                                <table id="read_table">#}
{#                                    <tr><th><label for="day">Delete Information from the Calendar</label></th></tr>#}
{#                                    <tr>#}
{#                                        <td>#}
{#                                            <select class="form-select" name="day" id="delete_day">#}
{#                                                <optgroup label="day">#}
{#                                                    {% for row in table %}#}
{#                                                        <option label="{{ row['day'] }}">{{ row['day'] }}</option>#}
{#                                                    {% endfor %}#}
{#                                                </optgroup>#}
{#                                            </select>#}
{#                                        </td>#}
{#                                        <td><input class="btn btn-primary" type="submit" value="Delete"></td>#}
{#                                    </tr>#}
{#                                </table>#}
{#                            </form>#}
{#                        </div>#}
{#                    </div>#}
{##}
{##}
{#                    {% block meta %}#}
{#                        <title>CRUD page</title>#}
{#                        <script src={{  url_for("crud.static", filename="javascript/validation.js", version='101') }}></script>#}
{#                        <script src={{  url_for("crud.static", filename="javascript/reload_page.js", version='101') }}></script>#}
{#                    {% endblock %}#}
{##}
{#                    <!-- CONTENT (in <body>), content for this page -->#}
{#                        <div class="container py-4">#}
{#                            <header class="pb-3 mb-4 border-bottom border-primary text-dark">#}
{#                                <span class="fs-4">Information</span>#}
{#                            </header>#}
{#                        </div>#}
{#                        <div class="container py-4 text-light bg-success">#}
{##}
{#                            <div class="container bg-secondary py-4">#}
{#                                <div class="p-5 mb-4 bg-light text-dark rounded-3">#}
{#                                    <h2>Table Viewer</h2>#}
{#                                    <div class="row align-items-md-stretch">#}
{#                                        <div class="container-fluid py-5">#}
{#                                            <table class="table">#}
{#                                                <thead>#}
{#                                                <tr>#}
{#                                                    <th>Day</th>#}
{#                                                    <th>Information</th>#}
{#                                                </tr>#}
{#                                                </thead>#}
{#                                                <tbody>#}
{#                                                <!-- Loop through rows in table -->#}
{#                                                {% for row in table %}#}
{#                                                    <tr>#}
{#                                                        <td>{{ row['day'] }}</td>#}
{#                                                        <td>{{ row['information'] }}</td>#}
{#                                                    </tr>#}
{#                                                {% endfor %}#}
{#                                                </tbody>#}
{#                                            </table>#}
{#                                        </div>#}
{#                                    </div>#}
{#                                </div>#}
{##}
{#                            </div>#}
{##}
{#                        </div>#}
{##}
{#                        </body>#}
{##}
{#                    {% endblock %}#}
{#</html>#}
{##}
{#    <div class="align-center pt-5" style="padding-left: 10px">#}
{#        <input type="text" id="numero" placeholder="Which day would you like to add information?" size="50">#}
{#    </div>#}
{#    <div class="align-center pt-5" style="padding-left: 10px">#}
{#        <input type="text" id="info" placeholder="What would you like to say?" size="50">#}
{#    </div>#}
{#    <div class="align-center" style="padding-left: 10px">#}
{#        <button id="submit_text" onclick="inputdays();">Submit</button>#}
{#    </div>#}
{#    <div class="row align-center p-3">#}
{#        <div class="container text-white" id="output"> </div>#}
{#    </div>#}
{##}
{##}
{#    <div class="align-center pt-5" style="padding-left: 10px":>#}
{#        <input type="text" id="burger" placeholder="What day would you like to delete information?" size="50">#}
{#    </div>#}
{#    <div class="align-center" style="padding-left: 10px">#}
{#        <button id="submit_text" onclick="deleteinfo();">Submit</button>#}
{#    </div>#}
{#    <div class="row align-center p-3">#}
{#        <div class="container text-white" id="output2"> </div>#}
{#    </div>#}
{##}
{##}
{#    <script>#}
{#        function inputdays() {#}
{#            let input=document.getElementById('info').value;#}
{#            let inpot=document.getElementById('numero').value;#}
{##}
{#            if (document.getElementById('numero').value.toLowerCase() == document.getElementById('numero').value.toLowerCase()) {#}
{#                document.getElementById('calendar' + inpot).insertAdjacentHTML('beforeend', input);#}
{#            } else {#}
{#                document.getElementById('calendar').insertAdjacentHTML('beforeend', 'ERROR ERROR');#}
{#            }#}
{#            }#}
{##}
{#        function deleteinfo() {#}
{#            let deli=document.getElementById('burger').value;#}
{##}
{#            if (document.getElementById('delete').value.toLowerCase() == document.getElementById('delete').value.toLowerCase()) {#}
{#                document.getElementById('calendar' + deli).innerHTML;#}
{#            } else {#}
{#                displayDate();#}
{#            }#}
{#            }#}
{#    </script>#}

</html>