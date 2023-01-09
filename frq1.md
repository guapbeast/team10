<p id="test"></p>

<script>

function numberOfLeapYears(year1, year2) {

    result = document.getElementById("numberOfLeapYearsResult");

    fetch('https://music.nighthawkcodingsociety.tk/api/calendar/numberOfLeapYears/' + year1 + "-" + year2)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Leap Years between " + year1 + "and " + year2 + ": " + data.numberOfLeapYears;

    })
}

function getYear1(){
    let inputYear1 = document.getElementById("inputYear1").value;
    return inputYear1;
}

function getYear2(){
    let inputYear2 = document.getElementById("inputYear2").value;
    return inputYear2;
}

function getYear(){
    let inputYear = document.getElementById("inputYear").value;
    return inputYear;
}


function isLeapYear(year) {

    result = document.getElementById("isLeapYearResult");

    fetch('https://music.nighthawkcodingsociety.tk/api/calendar/isLeapYear/' + year)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Is " + year + " a leap year: " + data.isLeapYear;

    })
}

</script>

### Check if Leap Year
<input id="inputYear" placeholder="Input a Year">
<button onclick="isLeapYear(getYear())">Submit</button>
<p id="isLeapYearResult"></p>

### Check Number of Leap Years in a Range
<input id="inputYear1" placeholder="Starting Year">
    <input id="inputYear2" placeholder="Ending Year">
    <button onclick="numberOfLeapYears(getYear1(), getYear2())">Submit</button>
<p id="numberOfLeapYearsResult"></p>
