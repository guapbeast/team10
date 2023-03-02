<script>
    const requestOptions = {
        method: 'POST',
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'include', // include, *same-origin, omit
        headers: {
            "content-type": "application/json",
        },
    };
    fetch("https://music.nighthawkcoders.tk/blacklist/logout", requestOptions).then((res) => {
        if (res.status == 200) {
            window.location.replace("/team10/login");
        } else {
            document.getElementById('message').innerHTML = "Not signed in";
        }
    });
</script>
<p id="message"></p>