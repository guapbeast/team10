<br>

<script>

function isLeapYear() {
    let year = document.getElementById("inputYear").value;
    // result = document.getElementById("isLeapYearResult");

    fetch(`https://music.nighthawkcodingsociety.tk/api/calendar/isLeapYear/${year}`)
    .then((data) => response.json())
    .then((data) => {

        console.log(data);
        document.getElementById(
          "isLeapYearResult"
        ).innerHTML = `${data.isLeapYear}`;
    
        // result.innerHTML = "Is " + year + " a leap year: " + data.isLeapYear;

    })
}

function numberOfLeapYears() {
    let year1 = document.getElementById("inputYear1").value;
    let year2 = document.getElementById("inputYear2").value;
    result = document.getElementById("numberOfLeapYearsResult");

    fetch('https://music.nighthawkcodingsociety.tk/api/calendar/numberOfLeapYears/' + year1 + "-" + year2)
    .then((data) => response.json())
    .then((data) => {

        console.log(data);
        document.getElementById(
          "numberOfLeapYearsResult"
        ).innerHTML = `${data.numberOfLeapYears}`;

        result.innerHTML = "Leap Years between " + year1 + "and " + year2 + ": " + data.numberOfLeapYears;

    })
}

</script>

### Check if Leap Year
<input id="inputYear" placeholder="Input a Year">
<button onclick="isLeapYear()">Submit</button>
<p id="isLeapYearResult"></p>

### Check Number of Leap Years in a Range
<input id="inputYear1" placeholder="Starting Year">
    <input id="inputYear2" placeholder="Ending Year">
    <button onclick="numberOfLeapYears()">Submit</button>
<p id="numberOfLeapYearsResult"></p>