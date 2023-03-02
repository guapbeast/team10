{% include budgeting.html %}

<script>
    function post() {
        var trip = document.getElementById('trip').value;
        var name = document.getElementById('name').value;
        var airport = document.getElementById('airport').value;
        var rental = document.getElementById('rental').value;
        var transport = document.getElementById('transport').value;
        var hotel1 = document.getElementById('hotel1').value;
        var hotel2 = document.getElementById('hotel1').value;

        const requestOptions = {
            method: 'POST',
            mode: 'cors', // no-cors, *cors, same-origin
            cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            credentials: 'include', // include, *same-origin, omit
            body: JSON.stringify(data),
            headers: {
                "content-type": "application/json",
            },
        };
        fetch("https://music.nighthawkcoders.tk/api/budget/", requestOptions).then((res) => {
            if (res.status == 200) {
                window.location.replace("/team10/budgeting");
            } else {
                document.getElementById('message').innerHTML = "Error"
            }
        });
    }
</script>

<h1>Trip Budget</h1>
<label for="trip">Trip ID:</label><br>
<input type="text" id="trip" name="trip"><br>
<label for="name">Trip Name:</label><br>
<input type="text" id="name" name="name"><br>
<label for="airport">Airport Cost:</label><br>
<input type="text" id="airport" name="airport"><br>
<label for="rental">Rental Car Cost:</label><br>
<input type="text" id="rental" name="rental"><br>
<label for="transport">Other Transport Costs:</label><br>
<input type="text" id="transport" name="transport"><br>
<label for="hotel1">Hotel Cost:</label><br>
<input type="text" id="hotel1" name="hotel2"><br>
<label for="hotel2">Other Hotel Costs:</label><br>
<input type="text" id="hotel2" name="hotel2"><br>
<input type="submit" value="Save Budget" onclick="post()">
<p id="message"></p>


<label for="budgets">Select trip budget:</label>
<select name="budgets" id="budgets">
  <option value="01">Test</option>
</select>
