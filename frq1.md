<style>
    .button {
    align-items: center;
    appearance: button;
    background-color: #0276FF;
    border-radius: 8px;
    border-style: none;
    box-shadow: rgba(255, 255, 255, 0.26) 0 1px 2px inset;
    box-sizing: border-box;
    color: #fff;
    cursor: pointer;
    display: flex;
    flex-direction: row;
    flex-shrink: 0;
    font-family: "RM Neue",sans-serif;
    font-size: 100%;
    line-height: 1.15;
    margin: 0;
    padding: 10px 21px;
    text-align: center;
    text-transform: none;
    transition: color .13s ease-in-out,background .13s ease-in-out,opacity .13s ease-in-out,box-shadow .13s ease-in-out;
    user-select: none;
    touch-action: manipulation;
}

.button:active {
    background-color: #006AE8;
}

.button:hover {
    background-color: #1C84FF;
}
<style>    

<br>

<script>

function isLeapYear() {
    let year = document.getElementById("inputYear").value;

    fetch(`https://music.nighthawkcoders.tk/api/calendar/isLeapYear/${year}`)
    .then(data => data.json())
    .then(data => {

        console.log(data);
        document.getElementById(
          "isLeapYearResult"
        ).innerHTML = `${data.isLeapYear}`;
    

    })
}

function numberOfLeapYears() {
    let year1 = document.getElementById("inputYear1").value;
    let year2 = document.getElementById("inputYear2").value;
    console.log(year1);

    fetch(`https://music.nighthawkcoders.tk/api/calendar/numberOfLeapYears/${year1}-${year2}`)
    .then(data => data.json())
    .then(data => {

        console.log(data);
        document.getElementById(
          "numberOfLeapYearsResult"
        ).innerHTML = `${data.numberOfLeapYears}`;


    })
}

</script>

<input id="inputYear" placeholder="Year">
<button onclick="isLeapYear()">Submit</button>
<p id="isLeapYearResult"></p>

<input id="inputYear1" placeholder="Starting Year">
    <input id="inputYear2" placeholder="Ending Year">
    <button onclick="numberOfLeapYears()">Submit</button>
<p id="numberOfLeapYearsResult"></p>
