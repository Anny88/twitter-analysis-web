<%@page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<%@page import = "javaclasses.JavaTweet"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="styles.css"> 
   
</head>    


<body>
<script type ="text/javascript" src="javascript.js"></script>

<div class="header stickyhead center">
        <span class = "logo"><i>Twitter-analysis</i></span>
    
        <a href="index.jsp" class="head-item" style ="border-bottom: 2px solid crimson;">Hot topics</a>
        <a href="hashtags.jsp" class="head-item">Hashtags</a>
        <a href="sentiment.jsp" class="head-item">Sentiment analysis</a>
        <a href="about.jsp" class="head-item">About project</a>
</div>	

<div class = "row center">
  
    <div class = "main">
        
        <div id = "search">
            <br><br>
            <h3>Type a country, city, zipcode or simply choose 
                <a href = "#" onclick="inTheWorld()">the world</a>
            </h3>
            <br>
            <div id = "form" >
                <form method="POST" action ="index.jsp">
                <input type = "text" size="50" class="input" id = "place" name="woeid" value="1">
                <input type = "submit" value="search" class = "button">  
             </form>
            </div>
            <%  int woeid = 0;
                String place = request.getParameter("woeid");                
                
                if (place != null) { 
                  if (place.length() == 0) {
                    place = "1";
                  }  
                  woeid = Integer.parseInt(place); 
              
                }      
             %>
            
        </div>
        
        
        <div class = "row center">
        <div class ="center" id = "list">
            <div id = "listItself">
                <h3 id = "topList">List of hot topics </h3> <br> 
                <table> <!--table shows list of trending topics, position left-->
                    <% if (woeid != 0) {
                       List trends = JavaTweet.getHotTopics(woeid);
                       for (int i = 1; i<=10; i++){
                     %>
                        <tr>
                            <td> <%=i%> </td>
                            <td> <a class = "link" onclick="chosenTrend(this)"> <%=trends.get(i-1)%></a></td>
                        </tr>                    
                    <% } 

                 %>
                  <script>                    
                    showDiv('search', 'list', 'onmap');                    
                    showText('topList', 'place');
                  </script>
             <% 
                     }
                    %>
                </table>
                <br>
                
                <br>
                <input type = "button" value="New Search" class="button" onclick="newSearch('search', 'list', 'onmap')">
            
            
            <!--div for choosing topic to analyse, position right--> 
            
            </div>
            <div id = "forChoose">
            <h3>Click on any topic for more details</h3> 
            <p><i>Chosen topic: </i></p>   
            <p id = "chosen" >...</p>
            
            
            <!--go to the next page-->
            <form method ="POST" action = "hashtags.jsp">
                
                <input type = "submit" value="Hashtags" class="button"  onclick = "window.location.href = 'hashtags.jsp'" > <br>
                <!-- hidden input for passing value to hashtags page-->
                <input type ="hidden" id="hidHash" name ="hidHash">                
            </form>
            <br>
            <form method ="POST" action = "sentiment.jsp">
                <input type ="hidden" id="hidSent" name ="hidSent">
                <input type = "submit"  value="Sentiments" class="button">
            </form> 
            
            <%  
                session.setAttribute("woeid", woeid);              
            %>  
            
            </div>
        </div>
        </div> 
    </div>
    
    
    <!--Google maps view made with Google Maps API, location identification included-->
    
    
    <div class = "mapView center">
        <h3 id = "onmap">...or pick a place on a Google Map</h3>
        <div id ="map" class = "center" >My map will go here</div>
        <script>
            function myMap() {
                var mapOptions = {
                    center: new google.maps.LatLng(51.5, -0.12),
                    zoom: 10,
                    mapTypeId: google.maps.MapTypeId.HYBRID
                }
                var map = new google.maps.Map(document.getElementById("map"), mapOptions);
                var infoWindow = new google.maps.InfoWindow;
                var place =  document.getElementById("place");    
                
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function(position) {
                        var pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };

                        infoWindow.setPosition(pos);
                        infoWindow.setContent('Location found.');
                        //place.innerHTML = "lat: " + lat + " lng: " + lng;
                        infoWindow.open(map);
                        map.setCenter(pos);
                        place.value = "lat: " + pos.lat + " lng: " + pos.lng;
                    }, function() {
                        handleLocationError(true, infoWindow, map.getCenter());
                       });
                } else {
                // Browser doesn't support Geolocation
                handleLocationError(false, infoWindow, map.getCenter());
                }
            }

              function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                infoWindow.setPosition(pos);
                infoWindow.setContent(browserHasGeolocation ?
                                      'Error: The Geolocation service failed.' :
                                      'Error: Your browser doesn\'t support geolocation.');
                infoWindow.open(map);
              }

            
        </script>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABCNA1YxzuoOpjxGPGAOT9FRsjVcTCKqo&callback=myMap"></script>
    </div>
</div>     

  
</body>
</html>