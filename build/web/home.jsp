<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>

<html>
    <head>
        <title>urNewspaper</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
        <link href="css/element.css" rel="stylesheet">
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <section id="header" class="clearfix">
            <nav class="navbar navbar-default navbar-fixed-top">
                <!-- /.container-fluid -->
                <section id="menu_box">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12 menu_box">
                                <div class="col-sm-3">
                                    <div class="menu_box_1">
                                        <h1><a href="home">urNewspaper</a></h1>
                                    </div>
                                    <p style="color: yellow">${mess}</p>
                                </div>
                                <div class="col-sm-6">
                                    <form action="search" method="post"  >
                                        <div class="menu_box_2">
                                            <input name="txt" class="form_1" type="text" value="${txtSearch}" placeholder="Search...">
                                            <input type="submit" value="Ok">
                                        </div>
                                    </form>                             
                                </div>
                                <div class="col-sm-3">
                                    <div class="menu_box_3 text-right">
                                        <c:if test="${sessionScope.acc == null}">
                                            <span class="tag_1"><a href="login">Log in</a></span>
                                        </c:if>

                                        <c:if test="${sessionScope.acc != null}">
                                            <span class="tag_1"><a href="logout">Log out</a></span>
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <div class="container">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="hidden">
                                <a href="#page-top"></a>
                            </li>
                            <li class="active_1">
                                <a class="li_1" href="home"><i class="fa fa-home"></i>Home</a>
                            </li>

                            <c:if test="${sessionScope.acc.isWriter == 1}">
                                <li>
                                    <a class="li_1" href="getcategory">Post News</a>
                                </li>
                            </c:if>

                            <c:if test="${sessionScope.acc.isAdmin == 1}">
                                <li>
                                    <a class="li_1" href="managerwriter">Writer Manager</a>
                                </li> 
                            </c:if>

                            <c:if test="${sessionScope.acc.isWriter == 1 }">
                                <li>
                                    <a class="li_1" href="managernew">News Manager</a>
                                </li>
                            </c:if>


                            <c:if test="${sessionScope.acc.isWriter == 1}">
                                <li>
                                    <a class="li_1" href="viewprofile">Profile</a>
                                </li>
                            </c:if>

                        </ul>
                    </div>
                </div>
            </nav>
        </section>

        <section id="center">
            <div class="container">
                <div class="row">
                    <h3>${c.cname} News</h3>
                    <div class="col-sm-12 center_main">
                        <div class="col-sm-2">
                            <div class="center_1">
                                <ul>
                                    <c:forEach items="${listC}" var="o">                                   
                                        <li><a href="home?cid=${o.cid}">${o.cname}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <c:forEach items="${listN}" var="o">
                                <div class="col-sm-12 center_2_inner_main_1">
                                    <div class="col-sm-4">
                                        <div class="center_2_inner_1">
                                            <a href="#"><img src="${o.image}" width="100%"></a>
                                        </div>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="center_2_inner_2">
                                            <h4>
                                                <a href="detail?id=${o.id}">
                                                    ${o.name}                                              
                                                </a>
                                            </h4>
                                            <p><a href="#">
                                                    ${o.title}
                                                </a></p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col-sm-3">
                            <div class="center_3">
                                <div id="ww_0d24078d45dd2" v='1.3' loc='id' a='{"t":"horizontal","lang":"en","sl_lpl":1,"ids":["wl1810"],"font":"Arial","sl_ics":"one_a","sl_sot":"celsius","cl_bkg":"image","cl_font":"#FFFFFF","cl_cloud":"#FFFFFF","cl_persp":"#81D4FA","cl_sun":"#FFC107","cl_moon":"#FFC107","cl_thund":"#FF5722"}'>Weather Data Source: <a href="https://cuacalab.id/cuaca_hanoi/hari_ini/" id="ww_0d24078d45dd2_u" target="_blank">cuaca Hanoi hari ini</a></div><script async src="https://app1.weatherwidget.org/js/?id=ww_0d24078d45dd2"></script>
                                <h5><a href="#">Lastest News</a></h5>
                                <c:forEach items="${last}" var="o">
                                    <div class="col-sm-12 center_3_link">
                                        <a href="detail?id=${o.id}"><img class="media-object dp" src="${o.image}" width="100%"></a>
                                        <h4><a href="detail?id=${o.id}"> ${o.name} </a></h4>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="col-sm-3">
                            <div class="footer_1">
                                <h3>ABOUT US</h3>
                                <hr> 
                                <p>We are your reliable source for breaking news, in-depth analysis, and captivating stories. </p>
                                <p>Stay connected and informed with us, your trusted destination for all things newsworthy.</p>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="footer_2">
                                <h3>CONTACT INFO</h3>
                                <hr>
                                <p><i class="glyphicon glyphicon-map-marker"></i>FPT University</p>
                                <p><i class="glyphicon glyphicon-envelope"></i>nguyenlghe176558@fpt.edu.vn</p>
                                <p><i class="glyphicon glyphicon-earphone"></i>+84111222333</p>
                            </div> 
                        </div>


                    </div>
                </div>
            </div>
        </section>

        <!-- //for header -->	
        <script src="js/classie.js"></script>
        <script src="js/cbpAnimatedHeader.js"></script>
        <!-- //for header_end -->	

        <!-- //for slider -->
        <script type="text/javascript">
            jQuery(document).ready(function ($) {

                $('#myCarousel').carousel({
                    interval: 5000
                });

                $('#carousel-text').html($('#slide-content-0').html());

                //Handles the carousel thumbnails
                $('[id^=carousel-selector-]').click(function () {
                    var id = this.id.substr(this.id.lastIndexOf("-") + 1);
                    var id = parseInt(id);
                    $('#myCarousel').carousel(id);
                });


                // When the carousel slides, auto update the text
                $('#myCarousel').on('slid.bs.carousel', function (e) {
                    var id = $('.item.active').data('slide-number');
                    $('#carousel-text').html($('#slide-content-' + id).html());
                });
            });
        </script>
        <!-- //for slider_end -->
    </body>

</html>
