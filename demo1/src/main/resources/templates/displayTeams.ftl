<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Players</title>
    <link
            href="https://cdn.jsdelivr.net/npm/https://bootswatch.com/5/sketchy/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://bootswatch.com/5/sketchy/bootstrap.min.css">
</head>

<body class="container">
<div class="row p-2">
    <!-- <span class="border border-black"></span> -->
    <div class="col-12">
        <nav class="navbar navbar-expand-lg navbar-primary">
            <div class="container-fluid">
                <i class="bi bi-globe fs-4"></i>
                <a class="navbar-brand" href="#"></a>
                <button
                        class="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <!-- <li class="nav-item">
                            <i class="bi bi-globe" style="font-size: 1.5em;"></i>
                        </li> -->
                        <li class="nav-item">
                            <a class="nav-link fw-bolder fs-5" href="#">Hurricanes Soccer Academy</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/displayPlayers">Players</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/displayTeams">Teams</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="row">
    <div class="col-12">
        <p><a href="/addTeam">Add Team</a></p>
        <p>Size: ${teams?size}</p>
        <#--<#list players>-->
        <table class="table table-sm">
            <tbody>
            <tr>
                <th><b>ID</b></th>
                <th><b>Gender</b></th>
                <th><b>Age Range</b></th>
                <th><b>Uniform Color</b></th>
                <th><b>Players</b></th>
                <th><b>Action</b></th>
            </tr>
            <#list teams as team>
                <tr>
                    <td>${team.id}</td>
                    <td>${team.gender}</td>
                    <td>${team.minAge}-${team.maxAge}</td>
                    <td>${team.uniformColor}</td>
                    <td>${team.playerCount}</td>
                    <td><a href="viewRoster2/${team.id}">View Roster</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<#--change this later-->
<#--</#list>-->
<div class="row">
    <div class="col-12">
        <div class="position-absolute start-50 translate-middle">
            <blockquote>Hurricanes Soccer Academy - Serving Claremont and Surrounding Areas</blockquote>
        </div>
    </div>
</div>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"

></script>

</body>
</html>