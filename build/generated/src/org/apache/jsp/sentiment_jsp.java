package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javaclasses.ConnectDB;
import javaclasses.JavaTweet;
import javaclasses.FindTweets;

public final class sentiment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Sentiment analysis</title>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">    \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> \r\n");
      out.write("    <script src=\"https://cdn.anychart.com/js/8.0.1/anychart-core.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.anychart.com/js/8.0.1/anychart-pie.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("</head>        \r\n");
      out.write("<body>\r\n");
      out.write("<script type =\"text/javascript\" src=\"javascript.js\"></script>   \r\n");
      out.write("<div class=\"header stickyhead center\">\r\n");
      out.write("        <span  class = \"logo\"><i>Twitter-analysis</i></span>\r\n");
      out.write("    \r\n");
      out.write("        <a href=\"index.jsp\" class=\"head-item\">Hot topics</a>\r\n");
      out.write("        <a href=\"hashtags.jsp\" class=\"head-item\">Hashtags</a>\r\n");
      out.write("        <a href=\"sentiment.jsp\" class=\"head-item\" style =\"border-bottom: 2px solid crimson;\">Sentiment analysis</a>\r\n");
      out.write("        <a href=\"about.jsp\" class=\"head-item\">About project</a>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("<div id = \"change\" class = \"row center\">\r\n");
      out.write("  \r\n");
      out.write("    <div class = \"main\">\r\n");
      out.write("        \r\n");
      out.write("        <div id = \"searchS\">\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <h3>Sentiment analysis of the topic or #hashtag</h3>\r\n");
      out.write("            <h4><i>Available only in English</i></h4>\r\n");
      out.write("            \r\n");
      out.write("            ");
  request.setCharacterEncoding("UTF-8");
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
            
      out.write("\r\n");
      out.write("            <form method=\"POST\" action =\"sentiment.jsp\">\r\n");
      out.write("            <table>\r\n");
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Topic:</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"topicS\" id = \"topicS\" size=\"30\" class=\"input\" value= \"");
      out.print(passedText );
      out.write("\"  placeholder=\"#football\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Location:</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"place\" size=\"30\" class=\"input\" value= \"");
      out.print(passedPlace );
      out.write("\" id = \"placeS\" placeholder=\"the World\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Latitude</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"lat\" id = \"lat\" size=\"30\" class=\"input\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Longitude</i> </td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"long\" id = \"long\" size=\"30\" class=\"input\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><i>Radius (miles)</i> </td>\r\n");
      out.write("                    <td><input type = \"number\" name = \"rad\" size=\"30\" class=\"input\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("                <br>\r\n");
      out.write("           \r\n");
      out.write("            <input type = \"submit\" name = \"sentiment\" value=\"analyse\" class = \"button\" > <!--search div will be hidden, output div shown, text field filled with user input and chart created-->\r\n");
      out.write("\r\n");
      out.write("            </form> \r\n");
      out.write("                              \r\n");
      out.write("            \r\n");
      out.write("        </div>      \r\n");
      out.write("            \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <!--Google maps view made with Google Maps API-->\r\n");
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
      out.write("                };\r\n");
      out.write("            var map = new google.maps.Map(document.getElementById(\"map\"), mapOptions);  var infoWindow = new google.maps.InfoWindow;\r\n");
      out.write("                var latit =  document.getElementById(\"lat\");    \r\n");
      out.write("                var long =  document.getElementById(\"long\"); \r\n");
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
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyABCNA1YxzuoOpjxGPGAOT9FRsjVcTCKqo&callback=myMap\"></script>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>     \r\n");
      out.write("\r\n");
      out.write("<div class =\"center\" id = \"diagramm\">\r\n");
      out.write("    <br> \r\n");
      out.write("    \r\n");
      out.write("    <h3 id = \"headsent\">Sentiment </h3> <br> \r\n");
      out.write("\r\n");
      out.write("    <div id = \"chart\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <br>\r\n");
      out.write("     \r\n");
 double latitude = 0;
                double longitude = 0;
                String keyword = "";
                int sents[]= {0};
                
                String kw = request.getParameter("topicS"); 
                String l1 = request.getParameter("lat"); 
                String l2 = request.getParameter("long"); 
                
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
                
                if (keyword != "" ){
                   
                
      out.write("\r\n");
      out.write("                <script>   \r\n");
      out.write("                   showDiv('change', 'diagramm', 'onmap');\r\n");
      out.write("                  \r\n");
      out.write("                   \r\n");
      out.write("                </script>\r\n");
      out.write("                ");

                   FindTweets.findByLoc (keyword, 1, 500, latitude, longitude, "s");
                   sents = JavaTweet.getSents(); 
                }                
             
      out.write("  \r\n");
      out.write("                \r\n");
      out.write("             ");
      out.write("\r\n");
      out.write("                <script>\r\n");
      out.write("                    function getData(){ \r\n");
      out.write("                        ");
 String str = "";
                        if (sents != null) {                            
                        str= getArrayString(sents);
                        } 
      out.write("\r\n");
      out.write("                        var s=\"");
      out.print(str);
      out.write("\"; \r\n");
      out.write("                        var rawData = s.split('|');\r\n");
      out.write("                        var data = [];\r\n");
      out.write("                        var i;\r\n");
      out.write("                        for ( i = 0; i<rawData.length;i++){\r\n");
      out.write("                            data.push(parseInt(rawData[i]));\r\n");
      out.write("                            //alert(data[i]);\r\n");
      out.write("                        }\r\n");
      out.write("                        return data; \r\n");
      out.write("                     } \r\n");
      out.write("                     showTextSent('headsent', 'topicS', 'placeS');\r\n");
      out.write("                    drawChart (getData());\r\n");
      out.write("                </script>\r\n");
      out.write("                ");
 
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
                            System.out.print(k + ":    " + s[k][m]);
                        }
                        System.out.println();
                    }
                    
                
      out.write("\r\n");
      out.write("    <!-- table to show lists of negative, positive and neutral tweets with sample data-->\r\n");
      out.write("    \r\n");
      out.write("    <table>\r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 if (s[0][0]!= "^-^") { 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <th class = \"borderedTable neg\">very negative tweets</th>\r\n");
      out.write("            ");
 } 
               if (s[1][0]!= "^-^") { 
      out.write("\r\n");
      out.write("           <th class = \"borderedTable neg\"> negative tweets</th>\r\n");
      out.write("            ");
 } 
               if (s[2][0]!= "^-^") { 
      out.write("\r\n");
      out.write("            <th class = \"borderedTable\">neutral tweets</th>\r\n");
      out.write("            ");
 } 
               if (s[3][0]!= "^-^") { 
      out.write("\r\n");
      out.write("            <th class = \"borderedTable pos\">positive tweets</th>\r\n");
      out.write("            ");
 } 
               if (s[4][0]!= "^-^") { 
      out.write("\r\n");
      out.write("            <th class = \"borderedTable pos\">very positive tweets</th>\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("            ");
 } 


            for (int p = 0; p < 5; p++) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                ");
 for (int j=0; j<5; j++){
                        if (s[j][0]!= "^-^"){
                
      out.write("            \r\n");
      out.write("                \r\n");
      out.write("                <td class = \"borderedTable\"> ");
      out.print(s[j][p]);
      out.write(" </td>\r\n");
      out.write("                \r\n");
      out.write("                ");
      }
                    } 
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            \r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        \r\n");
      out.write("    </table> \r\n");
      out.write("    <br>\r\n");
      out.write("    <input type = \"submit\" name = \"newsent\" value=\"New Sentiment Analysis\" class = \"button\" onclick=\"newSearch('change', 'diagramm', 'onmap'), deleteChart()\">\r\n");
      out.write("    <br> <br>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
