<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to Leave Management System</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        /* Dark theme styles specific to welcome.jsp */
        body {
            background-color: #222;
            color: #fff;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden; /* Prevents scrolling due to animation */
        }

        .container {
            text-align: center;
            max-width: 400px;
            padding: 40px;
            background-color: #333;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            z-index: 1; /* Ensures it stays on top of the GIF */
        }

        h2 {
            margin-bottom: 20px;
            color: #fff;
        }

        .button {
            display: inline-block;
            margin: 10px;
            padding: 12px 24px;
            background-color: #4CAF50;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #45a049;
        }

        .gif-container {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            display: flex;
            align-items: center;
            justify-content: flex-start;
            z-index: 0; /* Ensures it stays behind the container */
        }

        .gif {
            width: 300px; /* Adjust as needed */
            height: auto;
            animation: moveLeftToRight 5s linear infinite;
        }

        @keyframes moveLeftToRight {
            0% {
                transform: translateX(-100%); /* Start from outside the left edge */
            }
            100% {
                transform: translateX(600%); /* Move to outside the right edge */
            }
        }
    </style>
</head>
<body>
    <div class="gif-container">
        <img src="https://raw.githubusercontent.com/gist/brudnak/aba00c9a1c92d226f68e8ad8ba1e0a40/raw/e1e4a92f6072d15014f19aa8903d24a1ac0c41a4/nyan-cat.gif" alt="Moving GIF" class="gif">
    </div>
    <div class="container">
        <h2>Welcome to Leave Management System</h2>
        <a href="login.jsp" class="button">Login</a>
        <a href="register.jsp" class="button">Register</a>
    </div>
</body>
</html>
