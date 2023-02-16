<script>
    function login() {
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        var data = {email:email, password:password};
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
        fetch("http://music.nighthawkcoders.tk/authenticate", requestOptions).then((res) => {
            if (res.status == 200) {
                window.location.replace("/team10/users");
            } else {
                document.getElementById('message').innerHTML = "Invalid email or password"
            }
        });
    }
</script>
<h1>Login</h1>
<label for="email">Email:</label><br>
<input type="text" id="email" name="email"><br>
<label for="password">Password:</label><br>
<input type="text" id="password" name="password"><br><br>
<input type="submit" value="Login" onclick="login()">
<p id="message"></p>