<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>AddPlayer</title>
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
            <div class="fs-2">New Player</div>

            <form action="/addPlayer" method="post">
                <div class="row">
                    <div class="col-12">
                        <label for="name" class="col-12">Name</label>
                        <div class="col-12">
                            <input type="text" class="form-control" name="name" id="name">
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
<#--                        <div>Birth Year:<br>-->
                            <label for="BirthYear" class="col-12">Birth Year:</label>

                                <select class="form-control" name="birthyear" size="list">

                                    <#list (thisYear-12)..(thisYear-4) as year>
                                        <option value="${(year)?string['0']}">${(year)?string['0']}</option>
                                    </#list>

<#--                                    <option value="${(thisYear-12)?string['0']}">${thisYear-12}</option>-->
<#--                                    <option value="${(thisYear-11)?string['0']}">${thisYear-11}</option>-->
<#--                                    <option value="${(thisYear-10)?string['0']}">${thisYear-10}</option>-->
<#--                                    <option value="${(thisYear-9)?string['0']}">${thisYear-9}</option>-->
<#--                                    <option value="${(thisYear-8)?string['0']}">${thisYear-8}</option>-->
<#--                                    <option value="${(thisYear-7)?string['0']}">${thisYear-7}</option>-->
<#--                                    <option value="${(thisYear-6)?string['0']}">${thisYear-6}</option>-->
<#--                                    <option value="${(thisYear-5)?string['0']}">${thisYear-5}</option>-->
<#--                                    <option value="${(thisYear-4)?string['0']}">${thisYear-4}</option>-->
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


<#--                <div><p>Gender: <input type="radio" name="gender" value="M"> Male <input type="radio" name="gender" value="F"> Female</p></div><br>-->
<#--                <div>Team: <input type="text" name="team"></div>-->
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