<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <meta charset="utf-8"/>
    <meta name="description" content="About page">
    <link rel="dress icon" href="resources/images/icon_dress.ico"/>
    <%@ include file="/WEB-INF/jspf/meta.jspf" %>
</head>
<body>

<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div id="main">
    <div id="container">
        <div class="vertical-sidebar">
            <div id="navigation">
                <ul class="vertical-list">
                    <li><a href="index.html" class="item"> Home </a></li>
                    <li><a href="about" class="item"> About </a></li>
                    <c:if test="${not empty loggedUser.idUserData}">
                        <li><a href="products" class="item"> Service </a></li>
                    </c:if>
                    <li><a href="projects" class="item"> Project </a></li>
                </ul>
            </div>
        </div>
        <div class="content">
            <div class="post">
                </br><p class="niceletter">France may be the global center of couture, but today Valentino reminded
                us that it doesn't have a monopoly on all things haute. The brand, which
                usually presents its collections in Paris, has taken its couture show on
                the road for the past couple of seasons. In December, they showed the collection
                in New York. This time around, it was Rome, the birthplace of the house
                and a meaningful spot for house founder Valentino Garavani and designers
                Maria Grazia Chiuri and Pierpaolo Piccioli, who are based there. The pair
                recently announced that they're establishing their own couture craftsmanship
                school in the city, with 19 students set for the incoming class.</p>

                </br><p class="niceletter">The title of this collection was Mirabilia Romae, which translates from the
                Latin as "marvels of Rome." And so, in keeping with the Eternal City setting,
                today's show drew on tropes like gladiator sandals and Julius Caesar–style
                gold-leaf crowns. (The models even joked around in full Coliseum-ready regalia
                before the show.) As Gwyneth Paltrow and Tilda Swinton took in the spectacle,
                Chiuri and Piccioli presented a collection that began with lots of subdued black —
                a departure for the color-loving duo — and then morphed into the house's signature
                red. Statuesque capes and one-shouldered gowns were standouts, as were '70s-style
                patchwork detailing and intricate lace. They evoked different periods of the city's,
                and the brand's, history, from ancient days to Anita Ekberg in the '50s (via those
                glamazon gowns) to the mod era (glimpsed in swingy caped dresses).</p>

                </br><p class="niceletter">When the two came to New York this spring to accept their CFDA award,
                Piccioli
                compared their vision of the brand and Garavani's to the same landscape, seen
                from a different vantage point. They're clearly invested in making the traditional
                feel modern, and this collection marked an appropriate melding of the house's
                history and its future.</p>
            </div>
        </div>
    </div>
</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>