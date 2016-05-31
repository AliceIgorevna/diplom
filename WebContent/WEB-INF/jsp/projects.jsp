<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <meta charset="utf-8"/>
    <meta name="description" content="Projects">
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
				<h2 id="headproj">Info about projects</h2>
                    <h3>The most popular fashion place - article</h3>
					</br><p class="niceletter">France may be the global center of couture, but today Valentino reminded 
					us that it doesn't have a monopoly on all things haute. The brand, which 
					usually presents its collections in Paris, has taken its couture show on 
					the road for the past couple of seasons. In December, they showed the collection 
					in New York. This time around, it was Rome, the birthplace of the house 
					and a meaningful spot for house founder Valentino Garavani and designers 
					Maria Grazia Chiuri and Pierpaolo Piccioli, who are based there. The pair 
					recently announced that they're establishing their own couture craftsmanship 
					school in the city, with 19 students set for the incoming class.</p>
					</br><p class="niceletter">The brand, which 
					usually presents its collections in Paris, has taken its couture show on 
					the road for the past couple of seasons. In December, they showed the collection 
					in New York. This time around, it was Rome, the birthplace of the house 
					and a meaningful spot for house founder Valentino Garavani and designers 
					Maria Grazia Chiuri and Pierpaolo Piccioli, who are based there. The pair 
					recently announced that they're establishing their own couture craftsmanship 
					school in the city, with 19 students set for the incoming class.</p>
					</br><p class="niceletter">In December, they showed the collection 
					in New York. This time around, it was Rome, the birthplace of the house 
					and a meaningful spot for house founder Valentino Garavani and designers 
					Maria Grazia Chiuri and Pierpaolo Piccioli, who are based there. The pair 
					recently announced that they're establishing their own couture craftsmanship 
					school in the city, with 19 students set for the incoming class.</p>
					</br><p class="niceletter">A monopoly on all things haute. The brand, which 
					usually presents its collections in Paris, has taken its couture show on 
					the road for the past couple of seasons. In December, they showed the collection 
					in New York. This time around, it was Rome, the birthplace of the house 
					and a meaningful spot for house founder Valentino Garavani and designers 
					Maria Grazia Chiuri and Pierpaolo Piccioli, who are based there. The pair 
					recently announced that they're establishing their own couture craftsmanship 
					school in the city, with 19 students set for the incoming class.</p>
			</div>
        </div>
    </div>
</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>