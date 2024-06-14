<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Leaves</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        /* Dark theme styles specific to leave-list.jsp */
        body {
            background-color: #222;
            color: #fff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #333;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            position: relative; /* Add relative positioning */
        }

        h2 {
            color: #fff;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            color: #fff;
        }

        table, th, td {
            border: 1px solid #555;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #444;
        }

        a {
            color: #7747ff;
            text-decoration: none;
            margin-right: 10px;
        }

        a:hover {
            text-decoration: underline;
        }

        .add-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #7747ff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .add-button:hover {
            background-color: #5e3ce9;
        }

        /* Search box styles */
        .search-box {
            float: right;
            margin-top: 20px; /* Adjusted margin-top */
            margin-bottom: 10px;
        }

        .search-box input[type="text"] {
            padding: 8px;
            border: 1px solid #666;
            border-radius: 4px;
            font-size: 14px;
            background-color: #444; /* Dark background color */
            color: #fff; /* Text color */
        }

        .search-box input[type="text"]::placeholder {
            color: #ccc; /* Placeholder text color */
        }

        /* Back button styles */
        .back-button {
            position: absolute;
            right: 20px;
            bottom: 10px;
            padding: 10px 20px;
            background-color: #7747ff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #5e3ce9;
        }

        /* Additional padding to the bottom of the container to ensure space for the back button */
        .container {
            padding-bottom: 60px; /* Adjust as needed to ensure space */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>List of Leaves</h2>
        
        <!-- Search box -->
        <div class="search-box">
            <input type="text" id="searchInput" placeholder="Search..." onkeyup="filterTable()">
        </div>
        
        <a href="leave-form.jsp" class="add-button">Add New Leave</a>
        
        <table id="leaveTable">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Status</th>
                <th>Type</th>
                <th>Action</th>
            </tr>
            
            <!-- Iterate over the list of leaves -->
            <c:forEach var="leave" items="${leaveList}">
                <tr>
                    <td>${leave.id}</td>
                    <td>${leave.name}</td>
                    <td>${leave.status}</td>
                    <td>${leave.type}</td>
                    <td>
                        <a href="edit?id=${leave.id}">Edit</a>
                        <a href="delete?id=${leave.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            
        </table>

        <!-- Back button -->
        <a href="javascript:history.back()" class="back-button">Log Out</a>
    </div>

    <script>
        function filterTable() {
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("searchInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("leaveTable");
            tr = table.getElementsByTagName("tr");

            // Loop through all table rows, and hide those who don't match the search query
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[1]; // Assuming search is based on the second column (Name)
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</body>
</html>
