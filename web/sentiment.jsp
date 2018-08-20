<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    <script src="https://cdn.anychart.com/js/8.0.1/anychart-core.min.js"></script>
    <script src="https://cdn.anychart.com/js/8.0.1/anychart-pie.min.js"></script>
    <script src="javascript.js"></script>
    
<script>
        
</script>
    
</head>    

    
<body>

<div class="header stickyhead center">
        <span align = "left" class = "logo"><i>Twitter-analysis</i></span>
    
        <a href="index.html" class="head-item">Hot topics</a>
        <a href="hashtags.html" class="head-item">Hashtags</a>
        <a href="sentiment.html" class="head-item" style ="border-bottom: 2px solid crimson;">Sentiment analysis</a>
        <a href="about.html" class="head-item">About project</a>
</div>	

<div id = "change" class = "row center">
  
    <div class = "main">
        
        <div id = "searchS">
            <br><br>
            <h3>Sentiment analysis of the topic or #hashtag</h3>
            <h4><i>Available only in English</i></h4>
            
            <table>
                <tr>
                    <td><i>Topic:</i> </td>
                    <td><input type = "text" name = "topic" size="30" class="input" value = "" id = "topicS" placeholder="#football"></td>
                </tr><br>
                <tr>
                    <td><i>Location:</i> </td>
                    <td><input type = "text" name = "place" size="30" class="input" value = "" id = "placeS" placeholder="the World"></td>
                </tr>
            </table>
            <br>
            
            <input type = "submit" name = "sentiment" value="analyse" class = "button" onclick="showDiv('change', 'diagramm', 'onmap'),showTextSent('headsent', 'topicS', 'placeS'), drawChart()"> <!--search div will be hidden, output div shown, text field filled with user input and chart created-->

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
    
    <!-- table to show lists of negative, positive and neutral tweets with sample data-->
    
    <table>
        <thead class = "center">
            <th class = "borderedTable neg">negative tweets</th>
            <th class = "borderedTable">neutral tweets</th>
            <th class = "borderedTable pos">positive tweets</th>
        </thead>
        <tbody>
            <tr>
                <td class = "borderedTable neg">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable pos">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
            </tr>
            <tr>
                <td class = "borderedTable neg">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable pos">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
            </tr>
            <tr>
                <td class = "borderedTable neg">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable pos">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
            </tr>
            <tr>
                <td class = "borderedTable neg">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable pos">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
            </tr>
            <tr>
                <td class = "borderedTable neg">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
                <td class = "borderedTable pos">99.9% Of US Politicians Are Actual Psychopaths, New Study Reveals </td>
            </tr>
        </tbody>
    </table> <br>
    <input type = "submit" name = "newsent" value="New Sentiment Analysis" class = "button" onclick="newSearch('change', 'diagramm', 'onmap'), deleteChart()">
    <br> <br>

</div>
  
</body>
<html>