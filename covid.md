const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': '9d1b75d842msh20486d8bf8d5c19p1904abjsneb2943a9124c',
		'X-RapidAPI-Host': 'covid-193.p.rapidapi.com'
	}
};

fetch('https://covid-193.p.rapidapi.com/countries', options)
	.then(response => response.json())
	.then(response => console.log(response))
	.catch(err => console.error(err));
