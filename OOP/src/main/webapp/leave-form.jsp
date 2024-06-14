<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Leave Form</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        /* Dark theme styles specific to leave-form.jsp */
        body {
            background-color: #222;
            color: #fff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #333;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            color: #fff;
            margin-bottom: 20px;
        }

        form {
            max-width: 600px;
            margin: 20px auto;
            background: #333;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #ddd;
        }

        input[type="text"], select {
            width: calc(100% - 10px);
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #444;
            border-radius: 4px;
            background-color: #444;
            color: #fff;
        }

        .button-container {
            display: flex;
            justify-content: space-between;
        }

        button {
            background-color: #7747ff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #5e3ce9;
        }

        .back-button {
            background-color: #555;
        }

        .back-button:hover {
            background-color: #444;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Leave Form</h2>
        
        <form action="update" method="post">
            <input type="hidden" name="id" value="${leave.id}">
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${leave.name}" required>
            
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="Pending" ${leave.status == 'Pending' ? 'selected' : ''}>Pending</option>
                <option value="Approved" ${leave.status == 'Approved' ? 'selected' : ''}>Approved</option>
                <option value="Rejected" ${leave.status == 'Rejected' ? 'selected' : ''}>Rejected</option>
            </select>
            
            <label for="type">Type:</label>
            <select id="type" name="type" required>
                <option value="Vacation" ${leave.type == 'Vacation' ? 'selected' : ''}>Vacation</option>
                <option value="Sick Leave" ${leave.type == 'Sick Leave' ? 'selected' : ''}>Sick Leave</option>
                <option value="Maternity" ${leave.type == 'Maternity' ? 'selected' : ''}>Maternity</option>
            </select>
            
            <div class="button-container">
                <button type="submit">Save</button>
                <button type="button" class="back-button" onclick="history.back()">Back</button>
            </div>
        </form>
    </div>
</body>
</html>
