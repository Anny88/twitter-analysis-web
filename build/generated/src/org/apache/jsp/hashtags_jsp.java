package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import javaclasses.ConnectDB;
import javaclasses.TreeNode;
import javaclasses.JavaTweet;
import javaclasses.FindTweets;

public final class hashtags_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">    \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"tree.css\"> \r\n");
      out.write("    <script src=\"javascript.js\"></script>\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function hide(){\r\n");
      out.write("        //hide all the nodes of the tree for new search\r\n");
      out.write("        $('#level1').hide();\r\n");
      out.write("        $('.box').css('visibility', 'hidden');\r\n");
      out.write("        $('svg').css('visibility', 'hidden');\r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write(" $(document).ready(function(){\r\n");
      out.write("      $(\"#root\").click(function(e){\r\n");
      out.write("                  \r\n");
      out.write("          $('#line1').attr({'x1':'44%', 'y1':'0', 'x2':'15.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line2').attr({'x1':'48%', 'y1':'3%', 'x2':'38.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line3').attr({'x1':'52%', 'y1':'3%', 'x2':'61.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line4').attr({'x1':'56%', 'y1':'0', 'x2':'84.5%', 'y2': '100%'});\r\n");
      out.write("          \r\n");
      out.write("          //show nodes and lines for level1\r\n");
      out.write("          $('#level1').slideDown(1500);\r\n");
      out.write("          $('svg').css('visibility', 'visible');\r\n");
      out.write("      });\r\n");
      out.write("     \r\n");
      out.write("      $(\"#tag1\").click(function(e){\r\n");
      out.write("          //draw lines from level1 node tag1 to all its children \r\n");
      out.write("          $('#line11').attr({'x1':'44%', 'y1':'0', 'x2':'15.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line12').attr({'x1':'48%', 'y1':'1%', 'x2':'38.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line13').attr({'x1':'52%', 'y1':'1%', 'x2':'61.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line14').attr({'x1':'56%', 'y1':'0', 'x2':'84.5%', 'y2': '100%'});\r\n");
      out.write("          \r\n");
      out.write("          //show children of tag1\r\n");
      out.write("          $('#box1').css('visibility', 'visible');\r\n");
      out.write("         \r\n");
      out.write("          $('#line111').attr({'x1':'15.5%', 'y1':'0', 'x2':'50%', 'y2': '100%'}).delay(1200);\r\n");
      out.write("          $('#box1-2').css('visibility', 'visible');\r\n");
      out.write("                   \r\n");
      out.write("      });\r\n");
      out.write("     \r\n");
      out.write("     $(\"#tag2\").click(function(e){ \r\n");
      out.write("          //draw lines from level1 node tag2 to all its children \r\n");
      out.write("          $('#line21').attr({'x1':'50%', 'y1':'0', 'x2':'50%', 'y2': '100%'});\r\n");
      out.write("         \r\n");
      out.write("          //show children of tag2\r\n");
      out.write("          $('#box2').css('visibility', 'visible');\r\n");
      out.write("          $('#box2-2').css('visibility', 'visible');\r\n");
      out.write("                   \r\n");
      out.write("      });\r\n");
      out.write("     \r\n");
      out.write("     $(\"#tag3\").click(function(e){\r\n");
      out.write("          //draw lines from level1 node tag3 to all its children        \r\n");
      out.write("          $('#line31').attr({'x1':'44%', 'y1':'0', 'x2':'15.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line32').attr({'x1':'48%', 'y1':'1%', 'x2':'38.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line33').attr({'x1':'52%', 'y1':'1%', 'x2':'61.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line34').attr({'x1':'56%', 'y1':'0', 'x2':'84.5%', 'y2': '100%'});\r\n");
      out.write("        \r\n");
      out.write("          \r\n");
      out.write("          //show children of tag3\r\n");
      out.write("          $('#box3').css('visibility', 'visible');\r\n");
      out.write("          $('#box3-2').css('visibility', 'visible');\r\n");
      out.write("         \r\n");
      out.write("          $('#line321').attr({'x1':'38.5%', 'y1':'0', 'x2':'38.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line331').attr({'x1':'61.5%', 'y1':'0', 'x2':'61.5%', 'y2': '100%'});\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("      });\r\n");
      out.write("     \r\n");
      out.write("      $(\"#tag4\").click(function(e){\r\n");
      out.write("          //draw lines from level1 node tag4 to all its children       \r\n");
      out.write("          $('#line41').attr({'x1':'48%', 'y1':'0', 'x2':'38.5%', 'y2': '100%'});\r\n");
      out.write("          $('#line42').attr({'x1':'52%', 'y1':'0', 'x2':'61.5%', 'y2': '100%'});\r\n");
      out.write("          \r\n");
      out.write("          $('#line411').attr({'x1':'38.5%', 'y1':'0', 'x2':'50%', 'y2': '100%'});\r\n");
      out.write("          \r\n");
      out.write("           //show children of tag4\r\n");
      out.write("          $('#box4').css('visibility', 'visible');\r\n");
      out.write("          $('#box4-2').css('visibility', 'visible');\r\n");
      out.write("                    \r\n");
      out.write("      });\r\n");
      out.write("     \r\n");
      out.write("    \r\n");
      out.write(" });\r\n");
      out.write("</script>    \r\n");
      out.write("</head>    \r\n");
      out.write("    \r\n");
      out.write("            \r\n");
      out.write("  \r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"header stickyhead center\">\r\n");
      out.write("        <span class = \"logo\"><i>Twitter-analysis</i></span>\r\n");
      out.write("    \r\n");
      out.write("        <a href=\"index.jsp\" class=\"head-item\">Hot topics</a>\r\n");
      out.write("        <a href=\"hashtags.jsp\" class=\"head-item\" style =\"border-bottom: 2px solid crimson;\">Hashtags</a>\r\n");
      out.write("        <a href=\"sentiment.jsp\" class=\"head-item\">Sentiment analysis</a>\r\n");
      out.write("        <a href=\"about.jsp\" class=\"head-item\">About project</a>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("<div id = \"changeH\" class = \"row center\">\r\n");
      out.write("  \r\n");
      out.write("    <div class = \"main\">\r\n");
      out.write("        \r\n");
      out.write("        <div>\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <h3>Creating Hashtags-tree for the topic or #hashtag</h3>\r\n");
      out.write("            <h4 id = \"boo\"><i>Search for Hashtag gives better results</i></h4>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            ");
  int submitted = 0;
                request.setCharacterEncoding("UTF-8");
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
            
      out.write("\r\n");
      out.write("            <form method=\"POST\" action =\"hashtags.jsp\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Topic:</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"topicH\" size=\"30\" class=\"input\" id = \"topicH\" value= \"");
      out.print(passedText );
      out.write("\"> </td>\r\n");
      out.write("                </tr><br>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Location:</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"placeH\" size=\"30\" class=\"input\" value = \"");
      out.print(passedPlace );
      out.write("\" id = \"placeH\" placeholder=\"the World\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                 <tr>\r\n");
      out.write("                    <td><i>Latitude</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"latH\" id = \"latH\" size=\"30\" class=\"input\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Longitude</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"longH\" id = \"longH\" size=\"30\" class=\"input\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Radius (miles)</i> </td>\r\n");
      out.write("                    <td><input type = \"number\" name = \"radH\" id = \"radH\" size=\"30\" class=\"input\" placeholder = \"100\" ></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            \r\n");
      out.write("            <br>\r\n");
      out.write("            Include Sentiment Analysis <input type=\"checkbox\" name=\"sentim\" id = \"senton\" value=\"on\">\r\n");
      out.write("            <br><br>\r\n");
      out.write("            \r\n");
      out.write("            <input type = \"submit\" name = \"submit\" value=\"analyse\" class = \"button\" > <!--search div will be hidden, output div shown and text field filled with user input-->\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>      \r\n");
      out.write("            \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <!--Google maps view made with Google Maps API-->    \r\n");
      out.write("    \r\n");
      out.write("    <div class = \"mapView center\">\r\n");
      out.write("        <h3 id = \"onmap\">...or pick a place on a Google Map</h3>\r\n");
      out.write("        <div id =\"map\" class = \"center\" >My map will go here</div>\r\n");
      out.write("        <script>\r\n");
      out.write("            function myMap() {\r\n");
      out.write("                var mapOptions = {\r\n");
      out.write("                    center: new google.maps.LatLng(51.5, -0.12),\r\n");
      out.write("                    zoom: 10,\r\n");
      out.write("                    mapTypeId: google.maps.MapTypeId.HYBRID\r\n");
      out.write("                }\r\n");
      out.write("                var map = new google.maps.Map(document.getElementById(\"map\"), mapOptions);\r\n");
      out.write("                var infoWindow = new google.maps.InfoWindow;\r\n");
      out.write("                var latit =  document.getElementById(\"latH\");    \r\n");
      out.write("                var long =  document.getElementById(\"longH\"); \r\n");
      out.write("                \r\n");
      out.write("                if (navigator.geolocation) {\r\n");
      out.write("                    navigator.geolocation.getCurrentPosition(function(position) {\r\n");
      out.write("                        var pos = {\r\n");
      out.write("                            lat: position.coords.latitude,\r\n");
      out.write("                            lng: position.coords.longitude\r\n");
      out.write("                        };\r\n");
      out.write("\r\n");
      out.write("                        infoWindow.setPosition(pos);\r\n");
      out.write("                        infoWindow.setContent('Location found.');\r\n");
      out.write("                        //place.innerHTML = \"lat: \" + lat + \" lng: \" + lng;\r\n");
      out.write("                        infoWindow.open(map);\r\n");
      out.write("                        map.setCenter(pos);\r\n");
      out.write("                        latit.value = pos.lat;\r\n");
      out.write("                        long.value = pos.lng;\r\n");
      out.write("                    }, function() {\r\n");
      out.write("                        handleLocationError(true, infoWindow, map.getCenter());\r\n");
      out.write("                       });\r\n");
      out.write("                } else {\r\n");
      out.write("                // Browser doesn't support Geolocation\r\n");
      out.write("                handleLocationError(false, infoWindow, map.getCenter());\r\n");
      out.write("                } \r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyABCNA1YxzuoOpjxGPGAOT9FRsjVcTCKqo&callback=myMap\"></script>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>     \r\n");
      out.write("\r\n");
              double latitude = 0;
                double longitude = 0;
                String keyword = "";
                String selected;
                double radius = 500;
                int sents[]= {0};
                
                String kw = request.getParameter("topicH"); 
                String l1 = request.getParameter("latH"); 
                String l2 = request.getParameter("longH"); 
                String rad = request.getParameter("radH");
                //selected = request.getParameterValues("sentim");
                
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
                if (request.getParameterValues("sentim") != null){
                    selected = "including sentiment analysis";
                }
                else selected = "";
               
      out.write("\r\n");
      out.write("                \r\n");
      out.write("<div  id = \"tree\">\r\n");
      out.write("    ");
    
       //if (submitted > 0){  
            ConnectDB con = new ConnectDB();
            TreeNode tn = new TreeNode (keyword.toLowerCase(), 100, null); 
            TreeNode tree;
            int scores[];
            double average;
            boolean searchSents = false;
            String color = "black";
            if (selected == "") {
                searchSents = false;
                FindTweets.findByLoc (keyword, 1, 100, latitude, longitude, radius, "h");
                
            }
            if (selected == null){
                //System.out.println("uuuuuuuu");
            }
            
            else {
                searchSents = true;
            }
            tree = JavaTweet.createHashtagsTree(tn, 15, keyword, searchSents, 0, con);
            if (searchSents){
                FindTweets.findByLoc (keyword, 1, 100, latitude, longitude, radius, "hs");
                
                scores = tree.getScores();
                average = scores[6]/scores[5];
                if (average >=0 && average <=0.8){
                    color = "dred";
                }
                if (average >0.8 && average <1.5){
                    color = "red";
                }
                if (average >=1.5 && average <2.5){
                    color = "grey";
                }
                if (average >=2.5 && average <3.2){
                    color = "blue";
                }
                if (average >=3.2 && average <=4){
                    color = "dblue";
                }
                     
            } 
             
            //tree.recursivePrint();
            String tag = tree.getTag();
            String v = tree.getValue();
            List <TreeNode> children = tree.getChildren(); 
            String child = "";
            for (int j = 0; j< children.size(); j++){
                child += children.get(j).getTag() + " " + children.get(j).getValue() + "    ";
            }
            
            
        
      out.write("   \r\n");
      out.write("        \r\n");
      out.write("    <br>\r\n");
      out.write("    <span id = \"headhash\">Hashtags-Tree for the Topic <i><b>\"");
      out.print(keyword );
      out.write("\"</b> ");
      out.print(selected );
      out.write(" </i></span> \r\n");
      out.write("    <input id = \"new\" type = \"submit\" name = \"newhash\" value=\"New Hashtags Analysis\" class = \"button\" onclick=\"newSearch('changeH', 'tree', 'onmap'), hide()\">\r\n");
      out.write("    <br> \r\n");
      out.write("    <h4 class =\"center\"><i>Click on the node to see its children</i></h4>\r\n");
      out.write("    \r\n");
      out.write("    <div id = \"tree-structure\">\r\n");
      out.write("        <br>\r\n");
      out.write("       \r\n");
      out.write("        <div  id =\"root\" class = \"root center ");
      out.print(color );
      out.write("\" >\r\n");
      out.write("            <br>\r\n");
      out.write("            <span><b>");
      out.print(keyword );
      out.write("</b></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!--lines root -> level1-->\r\n");
      out.write("        \r\n");
      out.write("        <svg id = \"svg-root\">\r\n");
      out.write("            <line class = \"line\" id=\"line1\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line2\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line3\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line4\"/>        \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!-- level 1: -->\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <div id = \"level1\" class=\"center\">\r\n");
      out.write("            \r\n");
      out.write("         ");
 
            double width = 100/(children.size());
            
            if (children.size() > 8) {
                width = 8;
            }
            for (int k = 0; k < children.size(); k++){
                String id = "tag" + k;
                
            
            
         
      out.write("   \r\n");
      out.write("                <div id=\"");
      out.print(id );
      out.write("\" class = \"level1 grey \">\r\n");
      out.write("                    <span>");
      out.print(id );
      out.write("</span><br>\r\n");
      out.write("                    <span><b>");
      out.print(children.get(k).getTag() );
      out.write("</b></span><br>\r\n");
      out.write("                    <span>Value: ");
      out.print(children.get(k).getValue() );
      out.write("% </span>\r\n");
      out.write("                </div> \r\n");
      out.write("                <script>\r\n");
      out.write("                    document.getElementById('");
      out.print(id );
      out.write("').style.width =  \"");
      out.print(width );
      out.write("%\";\r\n");
      out.write("                </script>\r\n");
      out.write("         ");
      
            } 
        
      out.write("\r\n");
      out.write("        <br>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <!--lines level1 -> level2-->\r\n");
      out.write("        \r\n");
      out.write("        <svg id = \"svg1\" class = \"box\">\r\n");
      out.write("            <line class = \"line\" id=\"line11\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line12\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line13\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line14\"/>        \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        <svg id = \"svg2\" class = \"box\">\r\n");
      out.write("            <line class = \"line\" id=\"line21\"/>\r\n");
      out.write("                    \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        <svg id = \"svg3\" class = \"box\">\r\n");
      out.write("            <line class = \"line\" id=\"line31\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line32\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line33\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line34\"/>        \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        <svg id = \"svg4\" class = \"box\">\r\n");
      out.write("            <line class = \"line\" id=\"line41\"/>\r\n");
      out.write("            <line class = \"line\" id=\"line42\"/>                   \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!-- level 2: -->\r\n");
      out.write("        <div class = \" center\">\r\n");
      out.write("        \r\n");
      out.write("        ");
 for (int k = 0; k < children.size(); k ++){  
              
             
         
      out.write("\r\n");
      out.write("                  <div style =\"width: ");
      out.print(width );
      out.write("%; display: inline-block; vertical-align: top;\" class = \"blue\">\r\n");
      out.write("         ");
       
                  if (children.get(k).getChildren().size()!= 0){
                  List <TreeNode> children2 = children.get(k).getChildren();
                  double width2 = 100/children2.size();
                  if (width2 < 35) {
                      width2 = 35;
                  }
                  for (int m = 0; m < children2.size(); m++) {      
                        String id2 = "tag" + k + "-" + m;
         
      out.write("             \r\n");
      out.write("                            <div id=\"");
      out.print(id2 );
      out.write("\" class = \"level1 grey\">\r\n");
      out.write("                               <span>");
      out.print(id2 );
      out.write("</span><br>\r\n");
      out.write("                               <span><b>");
      out.print(children2.get(m).getTag() );
      out.write("</b></span><br>\r\n");
      out.write("                               <span>Value: ");
      out.print(children2.get(m).getValue() );
      out.write("% </span>\r\n");
      out.write("                            </div> \r\n");
      out.write("                        \r\n");
      out.write("                        <script>\r\n");
      out.write("                            document.getElementById('");
      out.print(id2 );
      out.write("').style.width =  \"");
      out.print(width2 );
      out.write("%\";\r\n");
      out.write("                        </script>\r\n");
      out.write("        ");
        }
                  
        
      out.write("        \r\n");
      out.write("                \r\n");
      out.write("                  <script> \r\n");
      out.write("                      //document.getElementById('idbox");
      out.print(k );
      out.write("').style.width =  \"");
      out.print(width );
      out.write("%\"; \r\n");
      out.write("                  </script>\r\n");
      out.write("        ");
       }
         
      out.write("        </div>\r\n");
      out.write("         ");
   }
            
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("      <!--  <div>\r\n");
      out.write("            <div class = \"level2 red \">\r\n");
      out.write("                <span>#tag11</span><br>\r\n");
      out.write("                <span>35% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"level2 red \">\r\n");
      out.write("                <span>#tag12</span><br>\r\n");
      out.write("                <span>25% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"level2 red \">\r\n");
      out.write("                <span>#tag13</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"level2 blue\">\r\n");
      out.write("                <span>#tag14</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("                      \r\n");
      out.write("        <div id= \"box2\" class = \"box center\">\r\n");
      out.write("            <div class = \"level2 red \">\r\n");
      out.write("                <span>#tag21</span><br>\r\n");
      out.write("                <span>35% </span>\r\n");
      out.write("            </div>            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("         <div id= \"box3\" class = \"box center\">\r\n");
      out.write("            <div class = \"level2 grey\">\r\n");
      out.write("                <span>#tag31</span><br>\r\n");
      out.write("                <span>35% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"level2 red \">\r\n");
      out.write("                <span>#tag32</span><br>\r\n");
      out.write("                <span>25% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"level2 grey \">\r\n");
      out.write("                <span>#tag33</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"level2 blue\">\r\n");
      out.write("                <span>#tag34</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("         <div id= \"box4\" class = \"box center\">\r\n");
      out.write("           \r\n");
      out.write("            <div class = \"level2 blue \">\r\n");
      out.write("                <span>#tag41</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"level2 blue\">\r\n");
      out.write("                <span>#tag42</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <br>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!-- lines level 2 to level3 -->\r\n");
      out.write("        \r\n");
      out.write("        <svg id = \"svg-level3\" class = \"box\">\r\n");
      out.write("            <line class = \"line\" id=\"line111\"/>\r\n");
      out.write("            \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        <svg class = \"box\">\r\n");
      out.write("            \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        <svg  class = \"box\">\r\n");
      out.write("            \r\n");
      out.write("            <line class = \"line\" id=\"line321\"/>  \r\n");
      out.write("            <line class = \"line\" id=\"line331\"/>  \r\n");
      out.write("            \r\n");
      out.write("        </svg>\r\n");
      out.write("        \r\n");
      out.write("        <svg  class = \"box\">\r\n");
      out.write("            \r\n");
      out.write("            <line class = \"line\" id=\"line411\"/>  \r\n");
      out.write("        </svg>\r\n");
      out.write("        <!-- level 3: -->\r\n");
      out.write("        <!-- level 3: -->\r\n");
      out.write("        <!-- level 3: -->\r\n");
      out.write("        \r\n");
      out.write("        <!--\r\n");
      out.write("        <div id = \"box1-2\" class = \"box center\">\r\n");
      out.write("            <div class = \"level2 red \">\r\n");
      out.write("                <span>#tag111</span><br>\r\n");
      out.write("                <span>35% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div id = \"box2-2\" class = \"box center\">\r\n");
      out.write("           <div>\r\n");
      out.write("                <span></span><br>\r\n");
      out.write("                <span></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>       \r\n");
      out.write("        \r\n");
      out.write("         <div id = \"box3-2\" class = \"box center\">\r\n");
      out.write("           \r\n");
      out.write("            <div class = \"level2 red\">\r\n");
      out.write("                <span>#tag321</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("             <div class = \"level2 grey\">\r\n");
      out.write("                <span>#tag331</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("            \r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("         <div id = \"box4-2\" class = \"box center\">\r\n");
      out.write("           \r\n");
      out.write("            <div class = \"level2 blue \">\r\n");
      out.write("                <span>#tag411</span><br>\r\n");
      out.write("                <span>20% </span>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div> \r\n");
      out.write("        \r\n");
      out.write("    </div> -->\r\n");
      out.write("    <br>\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("        ");
//&& "POST".equalsIgnoreCase(request.getMethod())
        
        if (keyword != ""  && request.getParameter("submit") != null) {
            //submitted = 1;
        
      out.write("\r\n");
      out.write("            <script>\r\n");
      out.write("                showDiv('changeH', 'tree', 'onmap');\r\n");
      out.write("                //onclick=\"showTextHash('headhash', 'topicH', 'placeH', 'senton')\"\r\n");
      out.write("            </script>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("  </div>\r\n");
      out.write("</body>\r\n");
      out.write("<html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
