<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style/style.css">
    <title>Login</title>
</head>
<body>
    
    <div class="container">
        <h1>Login</h1>

        

        <form action="${pageContext.request.contextPath}/AccountServlet" method="post">
            <input type="text" name="account" placeholder="Username" required>
            <input type="password" name="pass" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>