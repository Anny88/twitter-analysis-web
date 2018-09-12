
<%@page import="javaclasses.ConnectDB"%>
<%@page import="javaclasses.TreeNode"%>
<%@page import="javaclasses.JavaTweet"%>
<%@page import="javaclasses.FindTweets"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    <link rel="stylesheet" type="text/css" href="tree.css"> 
    <script src="javascript.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
    function hide(){
        //hide all the nodes of the tree for new search
        $('#level1').hide();
        $('.box').css('visibility', 'hidden');
        $('svg').css('visibility', 'hidden');
        
    }
 $(document).ready(function(){
      $("#root").click(function(e){
                  
          $('#line1').attr({'x1':'44%', 'y1':'0', 'x2':'15.5%', 'y2': '100%'});
          $('#line2').attr({'x1':'48%', 'y1':'3%', 'x2':'38.5%', 'y2': '100%'});
          $('#line3').attr({'x1':'52%', 'y1':'3%', 'x2':'61.5%', 'y2': '100%'});
          $('#line4').attr({'x1':'56%', 'y1':'0', 'x2':'84.5%', 'y2': '100%'});
          
          //show nodes and lines for level1
          $('#level1').slideDown(1500);
          $('svg').css('visibility', 'visible');
      });
     
      $("#tag1").click(function(e){
          //draw lines from level1 node tag1 to all its children 
          $('#line11').attr({'x1':'44%', 'y1':'0', 'x2':'15.5%', 'y2': '100%'});
          $('#line12').attr({'x1':'48%', 'y1':'1%', 'x2':'38.5%', 'y2': '100%'});
          $('#line13').attr({'x1':'52%', 'y1':'1%', 'x2':'61.5%', 'y2': '100%'});
          $('#line14').attr({'x1':'56%', 'y1':'0', 'x2':'84.5%', 'y2': '100%'});
          
          //show children of tag1
          $('#box1').css('visibility', 'visible');
         
          $('#line111').attr({'x1':'15.5%', 'y1':'0', 'x2':'50%', 'y2': '100%'}).delay(1200);
          $('#box1-2').css('visibility', 'visible');
                   
      });
     
     $("#tag2").click(function(e){ 
          //draw lines from level1 node tag2 to all its children 
          $('#line21').attr({'x1':'50%', 'y1':'0', 'x2':'50%', 'y2': '100%'});
         
          //show children of tag2
          $('#box2').css('visibility', 'visible');
          $('#box2-2').css('visibility', 'visible');
                   
      });
     
     $("#tag3").click(function(e){
          //draw lines from level1 node tag3 to all its children        
          $('#line31').attr({'x1':'44%', 'y1':'0', 'x2':'15.5%', 'y2': '100%'});
          $('#line32').attr({'x1':'48%', 'y1':'1%', 'x2':'38.5%', 'y2': '100%'});
          $('#line33').attr({'x1':'52%', 'y1':'1%', 'x2':'61.5%', 'y2': '100%'});
          $('#line34').attr({'x1':'56%', 'y1':'0', 'x2':'84.5%', 'y2': '100%'});
        
          
          //show children of tag3
          $('#box3').css('visibility', 'visible');
          $('#box3-2').css('visibility', 'visible');
         
          $('#line321').attr({'x1':'38.5%', 'y1':'0', 'x2':'38.5%', 'y2': '100%'});
          $('#line331').attr({'x1':'61.5%', 'y1':'0', 'x2':'61.5%', 'y2': '100%'});
          
          
      });
     
      $("#tag4").click(function(e){
          //draw lines from level1 node tag4 to all its children       
          $('#line41').attr({'x1':'48%', 'y1':'0', 'x2':'38.5%', 'y2': '100%'});
          $('#line42').attr({'x1':'52%', 'y1':'0', 'x2':'61.5%', 'y2': '100%'});
          
          $('#line411').attr({'x1':'38.5%', 'y1':'0', 'x2':'50%', 'y2': '100%'});
          
           //show children of tag4
          $('#box4').css('visibility', 'visible');
          $('#box4-2').css('visibility', 'visible');
                    
      });
     
    
 });
</script>    
</head>    
    
            
  
<body>

<div class="header stickyhead center">
        <span class = "logo"><i>Twitter-analysis</i></span>
    
        <a href="index.jsp" class="head-item">Hot topics</a>
        <a href="hashtags.jsp" class="head-item" style ="border-bottom: 2px solid crimson;">Hashtags</a>
        <a href="sentiment.jsp" class="head-item">Sentiment analysis</a>
        <a href="about.jsp" class="head-item">About project</a>
</div>	

<div id = "changeH" class = "row center">
  
    <div class = "main">
        
        <div>
            <br><br>
            <h3>Creating Hashtags-tree for the topic or #hashtag</h3>
            <h4 id = "boo"><i>Search for Hashtag gives better results</i></h4>
            
            
            <%  request.setCharacterEncoding("UTF-8");
                String  passedText = request.getParameter("hidHash");
                String  passedPlace = session.getAttribute("woeid").toString(); 
                if (session.getAttribute("woeid") != null){
                    passedPlace = session.getAttribute("woeid").toString();
                }
                if (passedText == null){
                    passedText="#news";
                }
                if (passedPlace == null){
                    passedPlace="1";
                }
            %>
            <form method="POST" action ="hashtags.jsp">
            <table>
                <tr>
                    <td><i>Topic:</i> </td>
                    <td><input type = "text" name = "topicH" size="30" class="input" id = "topicH" value= "<%=passedText %>"> </td>
                </tr><br>
                <tr>
                    <td><i>Location:</i> </td>
                    <td><input type = "text" name = "placeH" size="30" class="input" value = "<%=passedPlace %>" id = "placeH" placeholder="the World"></td>
                </tr>
                 <tr>
                    <td><i>Latitude</i> </td>
                    <td><input type = "text" name = "latH" id = "latH" size="30" class="input"></td>
                </tr>
                <tr>
                    <td><i>Longitude</i> </td>
                    <td><input type = "text" name = "longH" id = "longH" size="30" class="input"></td>
                </tr>
                <tr>
                    <td><i>Radius (miles)</i> </td>
                    <td><input type = "number" name = "radH" id = "radH" size="30" class="input" placeholder = "100" ></td>
                </tr>
            </table>
            
            <br>
            Include Sentiment Analysis <input type="checkbox" name="sentim" id = "senton" value="on">
            <br><br>
            
            <input type = "submit" name = "submit" value="analyse" class = "button" > <!--search div will be hidden, output div shown and text field filled with user input-->
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
                }
                var map = new google.maps.Map(document.getElementById("map"), mapOptions);
                var infoWindow = new google.maps.InfoWindow;
                var latit =  document.getElementById("latH");    
                var long =  document.getElementById("longH"); 
                
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

<%              double latitude = 0;
                double longitude = 0;
                String keyword = "";
                double radius = 500;
                int sents[]= {0};
                
                String kw = request.getParameter("topicH"); 
                String l1 = request.getParameter("latH"); 
                String l2 = request.getParameter("longH"); 
                String rad = request.getParameter("radH");
                
                if (kw != null){
                  if (kw.length() == 0){
                      kw = "#news";
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
               %>               
                
                
                
<div  id = "tree">
    
    <br>
    <span id = "headhash">Hashtags-Tree for the Topic <i><b>"<%=keyword %>"</b></i> </span> 
    <input id = "new" type = "submit" name = "newhash" value="New Hashtags Analysis" class = "button" onclick="newSearch('changeH', 'tree', 'onmap'), hide()">
    <br> 
    <h4 class ="center"><i>Click on the node to see its children</i></h4>
    
    <div id = "tree-structure">
        <br>
       
        <div  id ="root" class = "root center" >
            <br>
            <span><b><%=keyword %></b></span>
        </div>
        
        <!--lines root -> level1-->
        
        <svg id = "svg-root">
            <line class = "line" id="line1"/>
            <line class = "line" id="line2"/>
            <line class = "line" id="line3"/>
            <line class = "line" id="line4"/>        
        </svg>
        
        
        <!-- level 1: -->
        
        
        <div id = "level1" class = "center">
        
            <div id = "tag1" class = "level1 red">
                <span>#tag1</span><br>
                <span>Value: 20% </span>
            </div>
            <div id = "tag2" class = "level1 red ">
                <span>#tag2</span><br>
                <span>Value: 20% </span>
            </div>
            <div id = "tag3" class = "level1 grey">
                <span>#tag3</span><br>
                <span>Value: 20% </span>
            </div>
            <div id = "tag4" class = "level1 blue">
                <span>#tag4</span><br>
                <span>Value: 20% </span>
            </div>
        </div>
        
        
        <!--lines level1 -> level2-->
        
        <svg id = "svg1" class = "box">
            <line class = "line" id="line11"/>
            <line class = "line" id="line12"/>
            <line class = "line" id="line13"/>
            <line class = "line" id="line14"/>        
        </svg>
        
        <svg id = "svg2" class = "box">
            <line class = "line" id="line21"/>
                    
        </svg>
        
        <svg id = "svg3" class = "box">
            <line class = "line" id="line31"/>
            <line class = "line" id="line32"/>
            <line class = "line" id="line33"/>
            <line class = "line" id="line34"/>        
        </svg>
        
        <svg id = "svg4" class = "box">
            <line class = "line" id="line41"/>
            <line class = "line" id="line42"/>                   
        </svg>
        
        
        <!-- level 2: -->
        
        
            
        
        <div id= "box1" class = "box center">
            <div class = "level2 red ">
                <span>#tag11</span><br>
                <span>35% </span>
            </div>
            <div class = "level2 red ">
                <span>#tag12</span><br>
                <span>25% </span>
            </div>
            <div class = "level2 red ">
                <span>#tag13</span><br>
                <span>20% </span>
            </div>
            <div class = "level2 blue">
                <span>#tag14</span><br>
                <span>20% </span>
            </div>
        </div>
                      
        <div id= "box2" class = "box center">
            <div class = "level2 red ">
                <span>#tag21</span><br>
                <span>35% </span>
            </div>            
        </div>
        
        
         <div id= "box3" class = "box center">
            <div class = "level2 grey">
                <span>#tag31</span><br>
                <span>35% </span>
            </div>
            <div class = "level2 red ">
                <span>#tag32</span><br>
                <span>25% </span>
            </div>
            <div class = "level2 grey ">
                <span>#tag33</span><br>
                <span>20% </span>
            </div>
            <div class = "level2 blue">
                <span>#tag34</span><br>
                <span>20% </span>
            </div>
        </div>
        
        
         <div id= "box4" class = "box center">
           
            <div class = "level2 blue ">
                <span>#tag41</span><br>
                <span>20% </span>
            </div>
            <div class = "level2 blue">
                <span>#tag42</span><br>
                <span>20% </span>
            </div>
        </div>
        
        <br>
        
        
        <!-- lines level 2 to level3 -->
        
        <svg id = "svg-level3" class = "box">
            <line class = "line" id="line111"/>
            
        </svg>
        
        <svg class = "box">
            
        </svg>
        
        <svg  class = "box">
            
            <line class = "line" id="line321"/>  
            <line class = "line" id="line331"/>  
            
        </svg>
        
        <svg  class = "box">
            
            <line class = "line" id="line411"/>  
        </svg>
        <!-- level 3: -->
        
        
        <div id = "box1-2" class = "box center">
            <div class = "level2 red ">
                <span>#tag111</span><br>
                <span>35% </span>
            </div>
            
        </div>
        
        <div id = "box2-2" class = "box center">
           <div>
                <span></span><br>
                <span></span>
            </div>
            
        </div>       
        
         <div id = "box3-2" class = "box center">
           
            <div class = "level2 red">
                <span>#tag321</span><br>
                <span>20% </span>
            </div>
             <div class = "level2 grey">
                <span>#tag331</span><br>
                <span>20% </span>
            </div>
        </div>
            
       
        
        
         <div id = "box4-2" class = "box center">
           
            <div class = "level2 blue ">
                <span>#tag411</span><br>
                <span>20% </span>
            </div>
            
        </div>
        
    </div>
    <br>
   
</div>
        <%//&& "POST".equalsIgnoreCase(request.getMethod())
        if (keyword != ""  && request.getParameter("submit") != null) {
        %>
            <script>
                showDiv('changeH', 'tree', 'onmap');
                //onclick="showTextHash('headhash', 'topicH', 'placeH', 'senton')"
            </script>
        <%    
            FindTweets.findByLoc (keyword, 1, 100, latitude, longitude, radius, "h");
            ConnectDB con = new ConnectDB();
            TreeNode tn = new TreeNode (keyword.toLowerCase(), 100, null); 
            TreeNode tree =  JavaTweet.createHashtagsTree(tn, 15, keyword, false, 0, con);  
            
        }

        %>    
</body>
<html>