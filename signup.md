<script>
    function signup() {
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        var name = document.getElementById('name').value;
        const url = "https://music.nighthawkcoders.tk/api/person/post?email=" + email + '&' + "password=" + password + '&' + "name=" + name + '&' + "dob=00-00-0000&height=1&weight=1";
        const requestOptions = {
            method: 'POST',
            mode: 'cors', // no-cors, *cors, same-origin
            cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            credentials: 'include', // include, *same-origin, omit
            // headers: {
            //     "content-type": "application/json",
            // },
        };
        fetch(url, requestOptions).then((res) => {
            if (res.status == 201) {
                window.location.replace("/team10/login");
            } else {
                document.getElementById('message').innerHTML = "Error: " + res.status;
            }
        });
    }
</script>
<h1>Signup</h1>
<label for="email">Email:</label><br>
<input type="text" id="email" name="email"><br>
<label for="password">Password:</label><br>
<input type="text" id="password" name="password"><br><br>
<label for="name">Full name:</label><br>
<input type="text" id="name" name="name"><br><br>
<input type="submit" value="Signup" onclick="signup()">
<p id="message"></p>