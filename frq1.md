<br>

<script>

function isLeapYear() {
    let year = document.getElementById("inputYear").value;

    fetch(`https://music.nighthawkcodingsociety.tk/api/calendar/isLeapYear/${year}`)
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

    fetch(`https://music.nighthawkcodingsociety.tk/api/calendar/numberOfLeapYears/${year1}-${year2}`)
    .then(data => data.json())
    .then(data => {

        console.log(data);
        document.getElementById(
          "numberOfLeapYearsResult"
        ).innerHTML = `${data.numberOfLeapYears}`;


    })
}

</script>

<input id="inputYear" placeholder="Input a Year">
<button onclick="isLeapYear()">Submit</button>
<p id="isLeapYearResult"></p>

<input id="inputYear1" placeholder="Starting Year">
    <input id="inputYear2" placeholder="Ending Year">
    <button onclick="numberOfLeapYears()">Submit</button>
<p id="numberOfLeapYearsResult"></p>