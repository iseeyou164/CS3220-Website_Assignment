<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AddTeam</title>
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
<#--help-->
<div class="fs-2">New Team</div>

<form action="/addTeam" method="post">
    <div class="row">
        <div class="col-12">
            <#--                        <div>Birth Year:<br>-->
            <label for="minage maxage" class="col-12">Age Range (Min/Max):</label>

            <select class="col-6" name="minage" size="list">
                <#list 4..12 as age>
                    <option value="${(age)?string['0']}">${(age)?string['0']}</option>
                </#list>
            </select>
            <select class="col-6" name="maxage" size="list">
                <#list 12..4 as age>
                    <option value="${(age)?string['0']}">${(age)?string['0']}</option>
                </#list>
            </select>
        </div>

    </div>

    <div class="row">
        <div class="col-12">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" value='M' name="gender" id="genderM">
                <label class="form-check-label" for="genderM">
                    Male
                </label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" value='F' name="gender" id="genderF">
                <label class="form-check-label" for="genderF">
                    Female
                </label>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <label for="uniformcolor" class="col-12">Uniform Color:</label>
            <select class="col-6" name="uniformcolor" size="list">
                <option value="Red">Red</option>
                <option value="Green">Green</option>
                <option value="Blue">Blue</option>
                <option value="Yellow">Yellow</option>
                <option value="Teal">Teal</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <button type="button">
                <a href="/displayTeams">Cancel</a>
            </button>
            <input type="submit" value="Add"/>
        </div>
    </div>
</form>

<div class="row">
    <div class="col-12">
        <div class="position-absolute start-50 translate-middle">
            <blockquote>Hurricanes Soccer Academy - Serving Claremont and Surrounding Areas</blockquote>
        </div>
    </div>
</div>
</body>
</html>