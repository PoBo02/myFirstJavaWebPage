<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    
    <h1>Hello User</h1>

    <div class="container">
        <form action="account/login" method="post">
         <input type="text" name="account" placeholder="Username" required>
         <input type="text" name="pass" placeholder="Password" required>
         <button type="submit">Login</button>
        </form>
    </div>
    
</body>
</html>