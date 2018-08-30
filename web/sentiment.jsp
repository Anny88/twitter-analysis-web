<%@page import="javaclasses.ConnectDB"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@page import = "javaclasses.JavaTweet"%>
<%@page import = "javaclasses.FindTweets"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sentiment analysis</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    <script src="https://cdn.anychart.com/js/8.0.1/anychart-core.min.js"></script>
    <script src="https://cdn.anychart.com/js/8.0.1/anychart-pie.min.js"></script>
    
</head>        
<body>
<script type ="text/javascript" src="javascript.js"></script>   
<div class="header stickyhead center">
        <span  class = "logo"><i>Twitter-analysis</i></span>
    
        <a href="index.jsp" class="head-item">Hot topics</a>
        <a href="hashtags.jsp" class="head-item">Hashtags</a>
        <a href="sentiment.jsp" class="head-item" style ="border-bottom: 2px solid crimson;">Sentiment analysis</a>
        <a href="about.jsp" class="head-item">About project</a>
</div>	

<div id = "change" class = "row center">
  
    <div class = "main">
        
        <div id = "searchS">
            <br><br>
            <h3>Sentiment analysis of the topic or #hashtag</h3>
            <h4><i>Available only in English</i></h4>
            
            <%  request.setCharacterEncoding("UTF-8");
                String  passedText = request.getParameter("hidSent");  
                String  passedPlace = "";
                if (session.getAttribute("woeid") != null){
                    passedPlace = session.getAttribute("woeid").toString();
                }
                if (passedText == null){
                    passedText="#news";
                }
                if (passedPlace.length() == 0){
                    passedPlace="1";
                }
            %>
            <form method="POST" action ="sentiment.jsp">
            <table>

                <tr>
                    <td><i>Topic:</i> </td>
                    <td><input type = "text" name = "topicS" id = "topicS" size="30" class="input" value= "<%=passedText %>"  placeholder="#football"></td>
                </tr>
                <tr>
                    <td><i>Location:</i> </td>
                    <td><input type = "text" name = "place" size="30" class="input" value= "<%=passedPlace %>" id = "placeS" placeholder="the World"></td>
                </tr>
                <tr>
                    <td><i>Latitude</i> </td>
                    <td><input type = "text" name = "lat" id = "lat" size="30" class="input"></td>
                </tr>
                <tr>
                    <td><i>Longitude</i> </td>
                    <td><input type = "text" name = "long" id = "long" size="30" class="input"></td>
                </tr>
                <tr>
                    <td><i>Radius (miles)</i> </td>
                    <td><input type = "number" name = "rad" id = "rad" size="30" class="input"></td>
                </tr>
            </table>
                <br>
           
            <input type = "submit" name = "sentiment" value="analyse" class = "button" > <!--search div will be hidden, output div shown, text field filled with user input and chart created-->

            </form> 
                              
            
        </div>      
            
    </div>
    
    <!--Google maps view made with Google Maps API-->
    
    <div class = "mapView center">
        <h3 id = "onmap">...or pick a place on a Google Map</h3>
        <div id ="map" class = "center" >My map will go here</div>
        <script>
            function myMap() {
                var mapOptions = {
                    center: new google.maps.LatLng(51.5, -0.12),
                    zoom: 10,
                    mapTypeId: google.maps.MapTypeId.HYBRID
                };
            var map = new google.maps.Map(document.getElementById("map"), mapOptions);  var infoWindow = new google.maps.InfoWindow;
                var latit =  document.getElementById("lat");    
                var long =  document.getElementById("long"); 
                
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
                        latit.value = pos.lat;
                        long.value = pos.lng;
                    }, function() {
                        handleLocationError(true, infoWindow, map.getCenter());
                       });
                } else {
                // Browser doesn't support Geolocation
                handleLocationError(false, infoWindow, map.getCenter());
                }
            }
        </script>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABCNA1YxzuoOpjxGPGAOT9FRsjVcTCKqo&callback=myMap"></script>
    </div>
</div>     

<div class ="center" id = "diagramm">
    <br> 
    
    <h3 id = "headsent">Sentiment </h3> <br> 

    <div id = "chart">
    </div>
    <br>
     
<% double latitude = 0;
                double longitude = 0;
                String keyword = "";
                double radius = 500;
                int sents[]= {0};
                
                String kw = request.getParameter("topicS"); 
                String l1 = request.getParameter("lat"); 
                String l2 = request.getParameter("long"); 
                String rad = request.getParameter("rad");
                
                if (kw != null){
                  if (kw.length() == 0){
                      kw = "new";
                  }  
                  keyword = kw.toString();
                }
                
                if (l1 != null) { 
                  latitude = Double.parseDouble(l1);
                }  
                if (l2 != null) { 
                  longitude = Double.parseDouble(l2);
                }
                if ((rad != null) && (rad.length()!= 0)) { 
                  radius = Double.parseDouble(rad);
                }
                
                if (keyword != "" ){
                   
                %>
                <script>   
                   showDiv('change', 'diagramm', 'onmap');
                  
                   
                </script>
                <%
                   FindTweets.findByLoc (keyword, 1, 500, latitude, longitude, radius, "s");
                   sents = JavaTweet.getSents(); 
                }                
             %>  
                
             <%!
                public String getArrayString(int[] items){
                    String result = "";
                    for(int i = 0; i < items.length; i++) {
                        result +=  items[i] ;
                        if(i < items.length - 1) {
                            result += "|";
                        }
                    }
                    return result;
                }
             %>
                <script>
                    function getData(){ 
                        <% String str = "";
                        if (sents != null) {                            
                        str= getArrayString(sents);
                        } %>
                        var s="<%=str%>"; 
                        var rawData = s.split('|');
                        var data = [];
                        var i;
                        for ( i = 0; i<rawData.length;i++){
                            data.push(parseInt(rawData[i]));
                            //alert(data[i]);
                        }
                        return data; 
                     } 
                     showTextSent('headsent', 'topicS', 'placeS');
                    drawChart (getData());
                </script>
                <% 
                    String[][] s = new String[5][5];
                    for (int k = 0; k < 5; k++){
                        String text[] =  ConnectDB.selectTweetsBySents(k);
                        //{"0","1","2","3","4"};
                        for (int m = 0; m < 5; m++){
                            if ((text[m] == "-") || (text[m] == null) || (text[m] == "")){
                                s[k][m] = "^-^";
                            }
                            else {
                                s[k][m] =  text[m]; 
                            }
                            //System.out.print(k + ":    " + s[k][m]);
                        }
                        //System.out.println();
                    }
                    
                %>
    <!-- table to show lists of negative, positive and neutral tweets with sample data-->
    
    <table>
           



<% if (s[0][0]!= "^-^") { %>
            
            <th class = "borderedTable neg">very negative tweets</th>
            <% } 
               if (s[1][0]!= "^-^") { %>
           <th class = "borderedTable neg"> negative tweets</th>
            <% } 
               if (s[2][0]!= "^-^") { %>
            <th class = "borderedTable">neutral tweets</th>
            <% } 
               if (s[3][0]!= "^-^") { %>
            <th class = "borderedTable pos">positive tweets</th>
            <% } 
               if (s[4][0]!= "^-^") { %>
            <th class = "borderedTable pos">very positive tweets</th>
            







 
            <% } 


            for (int p = 0; p < 5; p++) {%>

            <tr>
                <% for (int j=0; j<5; j++){
                        if (s[j][0]!= "^-^"){
                %>            
                
                <td class = "borderedTable"> <%=s[j][p]%> </td>
                
                <%      }
                    } %>
            </tr>
            
            <% } %>
            
        
    </table> 
    <br>
    <input type = "submit" name = "newsent" value="New Sentiment Analysis" class = "button" onclick="newSearch('change', 'diagramm', 'onmap'), deleteChart()">
    <br> <br>
    </div>

</body>
</html>