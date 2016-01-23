<%--
    Document   : home
    Created on : 27 déc. 2015, 23:38:14
    Author     : olga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
--%><!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>IDGAF Application - Home</title>

        <!-- Bootstrap Core CSS -->
        <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="metisMenu/dist/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="stylesheet" href="countrySelect/css/countrySelect.min.css">
        <link rel="stylesheet" href="countrySelect/css/demo.css">
        <link rel="stylesheet" href="jquery-ui/jquery-ui.css">

    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="home.html">IDGAF</a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">
                    <li>Hi Toto</li>
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <!--                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                                                    </li>-->
                            <li class="divider"></li>
                            <li><a href="studentLoginPage.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <%--<c:url var="post_url"  value="/AccueilEtudServlet" />--%>
                    <%--<sf:form commandName="accueilEtud" method="post" action="${post_url}">--%>
                        <div class="sidebar-nav navbar-collapse">
                            <ul class="nav" id="side-menu">

                                <li class="sidebar-search">
                                    <form role="form">
                                        <div class="form-group">
                                            <p class="help-block">De</p>
                                            <input class="form-control datepicker" id="from">

                                        </div>
                                        <div class="form-group">
                                            <p class="help-block">A</p>
                                            <input class="form-control datepicker" id="to">

                                        </div>
                                        <div class="form-group">
                                            <p class="form-control-static">Domaine</p>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                        <div class="form-group">
                                            <p class="form-control-static">Pays</p>
                                            <input id="country_selector" class="form-control" type="text">
                                        </div>
                                        <div class="form-group">
                                            <p class="form-control-static">Ville</p>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>

                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                    </form>
                                </li>

                            </ul>
                        </div>
                        <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Liste des stages</h1>
                            <table class="table table-responsive table-stripped">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Title</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%--<tr>
                                        <td>1</td>
                                        <td>Internship 1</td>
                                        <td>Available</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Internship 2</td>
                                        <td>Unavailable</td>
                                    </tr>--%>

                                <c:forEach items="${ListeStages}" var="Stages">
                                    <tr>
                                        <td>${ListeStages.No}</td>
                                        <td>${ListeStages.Title}</td>
                                        <td>${ListeStages.Status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>

                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="jquery/dist/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="bootstrap/dist/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="metisMenu/dist/metisMenu.min.js"></script>

        <script src="countrySelect/js/countrySelect.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="js/sb-admin-2.js"></script>
        <script>
            $("#country_selector").countrySelect({
                //defaultCountry: "jp",
                //onlyCountries: ['us', 'gb', 'ch', 'ca', 'do'],
                preferredCountries: ['fr', 'gb', 'us']
            });
        </script>
        <script src="jquery-ui/jquery-ui.js"></script>
        <script>
            $(function() {
                $( ".datepicker" ).datepicker();
            });
        </script>
    </body>

</html>
