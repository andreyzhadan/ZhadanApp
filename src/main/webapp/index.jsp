<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World Endpoints</title>
    <script src="js/hello.js"></script>
    <!--  Load the Google APIs Javascript client library -->
    <!--  Then call the init function, which is defined in hello.js -->
    <script src="https://apis.google.com/js/client.js?onload=init"></script>
</head>

<body>
<h1>My First Endpoints App</h1>

<p><input id="input_greet_generically" type="button" value="please wait"></p>

<p>What is your name?<input value="Zebra" id="name_field"></p>

<p><input id="input_greet_by_name" type="button" value="please wait"></p>
</body>
</html>