<!DOCTYPE html>
<html>
<head>
    <title>Fashion is my profession</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="description" content="Site about last fashion events">
    <link rel="dress icon" href="resources/images/icon_dress.ico"/>
    <%@ include file="/WEB-INF/jspf/meta.jspf" %>
</head>
<body>

<%@ include file="/WEB-INF/jspf/header.jspf" %>
<div id="main">

    <div id="imgbar">
        <div class="shell">
            <div class="imgbar-left">
                <h2>Head of the main article</h2>

                <p>Main article, or some interesting note</p>
                <a href="registrationPageServlet" class="order-now">Register</a>
            </div>
            <div class="imgbar-right">
                <div class="slider">
                    <ul>
                        <li><img src="resources/images/slider-image.jpg" alt=""></li>
                        <li><img src="resources/images/slider-image1-a.jpg" alt=""></li>
                        <li><img src="resources/images/slider-image2-a.jpg" alt=""></li>
                        <li><img src="resources/images/slider-image3-a.jpg" alt=""></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="shell">
        <div id="sidebar">
            <div class="text-container"> <!--id="box" -->
                <h2><a href="http://stylemeetings.tumblr.com/">The New of the day</a></h2>

                <p>Fashion article of the day. France may be the global center of couture, but today Valentino reminded
                    us that it doesn't have a monopoly on all things haute. The brand, which
                    usually presents its collections in Paris, has taken its couture show on
                    the road for the past couple of seasons. In December, they showed the collection
                    in New York.</p>
            </div>
            <div class="post">
                <h2>Latest Fashion Show</h2>
                <img src="resources/images/post-image1.gif" alt=""/>

                <p>NY Fashion week 2015. France may be the global center of couture, but today Valentino reminded
                    us that it doesn't have a monopoly on all things haute. </p>
                <a href="http://fashionbombdaily.com/tag/fashion-show/" class="more">&#9654; more</a>
            </div>
        </div>
        <div id="content">
            <div class="col">
                <div class="post">
                    <h2>What is the most fashionable place?</h2>
                    <img src="resources/images/post-image2.gif" alt="" class="right"/>

                    <p>The most popular fashion place - article. France may be the global center of couture, but today
                        Valentino reminded
                        us that it doesn't have a monopoly on all things haute. The brand, which
                        usually presents its collections in Paris, has taken its couture show on
                        the road for the past couple of seasons. In December, they showed the collection
                        in New York.</p>

                    <div class="cl">&nbsp;</div>
                    <!-- -->
                    <a href="http://www.triphobo.com/blog/fashion-cities" class="more">&#9654; more</a>
                </div>
            </div>
            <div class="col cols-2">
                <div class="post">
                    <h2>Who is the most fashionable?</h2>
                    <img src="resources/images/post-image3.gif" alt="" class="right"/>

                    <p>Article about fashion trends, looks and people. France may be the global center of couture, but
                        today Valentino reminded
                        us that it doesn't have a monopoly on all things haute. The brand, which
                        usually presents its collections in Paris, has taken its couture show on
                        the road for the past couple of seasons. </p>

                    <div class="cl">&nbsp;</div>
                    <a href="http://blogandthecity.net/" class="more">&#9654; more</a>
                </div>
            </div>
            <div class="col cols-2 last">
                <div class="post">
                    <h2>What designers do?</h2>

                    <p>About fashion designers. France may be the global center of couture, but today Valentino reminded
                        us that it doesn't have a monopoly on all things haute. The brand, which
                        usually presents its collections in Paris, has taken its couture show on
                        the road for the past couple of seasons.</p>
                    <a href="#" class="more left">&#9654; more</a>
                    <img src="resources/images/post-image4.gif" alt="" class="right"/>

                    <div class="cl">&nbsp;</div>
                </div>
            </div>
        </div>
        <div class="cl">&nbsp;</div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
<!-- End Footer -->
</body>
<c:remove var="errorMessage" scope="session"/>
<c:remove var="message" scope="session"/>
</html>