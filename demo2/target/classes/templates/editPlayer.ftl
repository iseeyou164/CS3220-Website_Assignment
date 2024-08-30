<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EditPlayer</title>
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
<h2><a href="/displayPlayers">${players.name}</a> Edit</h2>
<form action="/editPlayer/${id}" method="post">
    <div class="row">
        <div class="col-12">
            <label for="name" class="col-12">Name</label>
            <div class="col-12">
                <input type="text" class="form-control" name="name" id="name" value="${players.name}">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <label for="birthyear" class="col-12">Birth Year:</label>

            <select class="form-control" name="birthyear" size="list">

                <#list (thisYear-12)..(thisYear-4) as year>
                    <option value="${(year)?string['0']}" <#if players.birthYear == year>selected="selected"</#if>>${(year)?string['0']}</option>
                </#list>
            </select>
        </div>

    </div>

    <div class="row">
        <div class="col-12">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" value='M' name="gender" id="genderM" <#if players.gender == 'M'>checked</#if>>
                <label class="form-check-label" for="genderM">
                    Male
                </label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" value='F' name="gender" id="genderF" <#if players.gender == 'F'>checked</#if>>
                <label class="form-check-label" for="genderF">
                    Female
                </label>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <label for="teamid" class="col-12">Team ID:</label>

            <select class="form-control" name="teamid" size="list">
<#--                <option value="N/A" <#if players.teamID == >selected="selected"</#if>>None</option>-->
                <#if players??>
<#--                    error-->
                    <option value="0">Empty</option>
                    <#list teams as team>
                    <#--                        <option value="${team.id}" <#if players?has_content && players.teamID == team.id>selected="selected"</#if>>${team.id}</option>-->
                        <#if ((players.gender == team.gender) && (team.maxAge + 1 > players.age) && (players.age > team.minAge - 1))>
                            <#if players.team??>
                                <#if players.team.id == team.id>
                                    <option value="${team.id}" selected="selected">${team.id}</option>
                                    <#else>
                                        <option value="${team.id}">${team.id}</option>
                                </#if>
                                <#else>
                                    <option value="${team.id}">${team.id}</option>
                            </#if>
                        </#if>
                    </#list>
                <#else>
                    N/A
                </#if>
            </select>
        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <button type="button">
                <a href="/displayPlayers">Cancel</a>
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