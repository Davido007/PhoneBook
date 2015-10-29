<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>PhoneBook</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="./css/main.css">


</head>

<body ng-app="PhoneBook" ng-controller="ContactsController">
    <header>
        <div class="left">
            <span class="inline">PhoneBook</span>
        </div>
        <div class="radioDiv" ng-init="searchType=searchTypeAll">
            <label>
                <input type="radio" name="searchBy" ng-model="searchType" ng-value="searchTypeAll" id="all" ng-click='getAll()' checked="checked">
                <span class="radioButton">See all</span>
            </label>
            <label>
                <input type="radio" name="searchBy" ng-model="searchType" ng-value="searchTypePrefix" id="prefix">
                <span class="radioButton">Prefix</span>
            </label>
            <label>
                <input type="radio" name="searchBy" ng-model="searchType" ng-value="searchTypeSurname" id="surname">
                <span class="radioButton">Surname</span>
            </label>
        </div>

        <div class="right"></div>
    </header>
    <div class="mid">
        <section class="left">
            &nbsp;
        </section>
        <main>
            <form class="form-search" name="searchForm">
                <div ng-show="searchType.searchbox">
                    <input class="input-search" type="text" name="searchInput" ng-model="searchedPhrase" required ng-pattern="searchType.searchPattern">
                    <button ng-disabled="searchForm.$invalid" class="submit-button btn btn-primary btn-lg" ng-click="searchClick(searchedPhrase)">Search</button>
                    <div class="alert alert-danger" role="alert" ng-show="searchForm.$invalid && !searchForm.searchInput.$error.required">
                        {{searchType.errorText}}
                    </div>
                </div>
            </form>



            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Prefix</th>
                        <th>Number</th>
                        <th>First Name</th>
                        <th>Surname</th>
                        <th>City</th>
                        <th>Street</th>
                        <th>House number</th>
                    </tr>
                </thead>
                <tbody ng-repeat="contact in contacts">
                    <tr>
                        <td>{{contact.phoneNumber.prefix}}</td>
                        <td>{{contact.phoneNumber.number}}</td>
                        <td>{{contact.firstName}}</td>
                        <td>{{contact.surname}}</td>
                        <td>{{contact.address.city}}</td>
                        <td>{{contact.address.street}}</td>
                        <td>{{contact.address.houseNumber}}</td>
                    </tr>
                </tbody>
            </table>

        </main>
        <section class="right">
            &nbsp;
        </section>
    </div>
    <footer class="footer">
        <div class="ubber-footer">
            <div class="footer-mid-left">
                Follow us
                <br/>
                <img class="img-follow" src="./img/face.jpg" />
                <img class="img-follow" src="./img/twit.png" style="margin-left: 3%;" />
            </div>
            <div class="footer-mid-mid">
                <img class="img" src="./img/logo_gft.png" style="margin-top: 3%" />
            </div>
            <div class="footer-mid-right">
                <p>Creators:
                    <br/>Wachowicz Mateusz
                    <br/>Siejkowski Igor
                    <br/>Plichta Dawid</p>
            </div>
        </div>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js "></script>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="./js/contactsController.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</body>

</html>
