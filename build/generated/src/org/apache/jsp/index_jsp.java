package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import javaclasses.JavaTweet;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; ;charset=UTF-8");
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
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> \r\n");
      out.write("   \r\n");
      out.write("</head>    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<script type =\"text/javascript\" src=\"javascript.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"header stickyhead center\">\r\n");
      out.write("        <span class = \"logo\"><i>Twitter-analysis</i></span>\r\n");
      out.write("    \r\n");
      out.write("        <a href=\"index.jsp\" class=\"head-item\" style =\"border-bottom: 2px solid crimson;\">Hot topics</a>\r\n");
      out.write("        <a href=\"hashtags.jsp\" class=\"head-item\">Hashtags</a>\r\n");
      out.write("        <a href=\"sentiment.jsp\" class=\"head-item\">Sentiment analysis</a>\r\n");
      out.write("        <a href=\"about.jsp\" class=\"head-item\">About project</a>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("<div class = \"row center\">\r\n");
      out.write("  \r\n");
      out.write("    <div class = \"main\">\r\n");
      out.write("        \r\n");
      out.write("        <div id = \"search\">\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <h3>Type a country, city, zipcode or simply choose \r\n");
      out.write("                <a href = \"#\" onclick=\"inTheWorld()\">the world</a>\r\n");
      out.write("            </h3>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div id = \"form\" >\r\n");
      out.write("                <form method=\"POST\" action =\"index.jsp\">\r\n");
      out.write("                <input type = \"text\" size=\"50\" class=\"input\" id = \"place\" name=\"woeid\" value=\"1\">\r\n");
      out.write("                <input type = \"submit\" value=\"search\" class = \"button\">  \r\n");
      out.write("             </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
  int woeid = 0;
                String place = request.getParameter("woeid");                
                
                if (place != null) { 
                  if (place.length() == 0) {
                    place = "1";
                  }  
                  woeid = Integer.parseInt(place); 
              
                }      
             
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <div class = \"row center\">\r\n");
      out.write("        <div class =\"center\" id = \"list\">\r\n");
      out.write("            <div id = \"listItself\">\r\n");
      out.write("                <h3 id = \"topList\">List of hot topics </h3> <br> \r\n");
      out.write("                <table> <!--table shows list of trending topics, position left-->\r\n");
      out.write("                    ");
 if (woeid != 0) {
                       List trends = JavaTweet.getHotTopics(woeid);
                       for (int i = 1; i<=10; i++){
                     
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td> ");
      out.print(i);
      out.write(" </td>\r\n");
      out.write("                            <td> <a class = \"link\" onclick=\"chosenTrend(this)\"> ");
      out.print(trends.get(i-1));
      out.write("</a></td>\r\n");
      out.write("                        </tr>                    \r\n");
      out.write("                    ");
 } 

                 
      out.write("\r\n");
      out.write("                  <script>                    \r\n");
      out.write("                    showDiv('search', 'list', 'onmap');                    \r\n");
      out.write("                    showText('topList', 'place');\r\n");
      out.write("                  </script>\r\n");
      out.write("             ");
 
                     }
                    
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("                <br>\r\n");
      out.write("                \r\n");
      out.write("                <br>\r\n");
      out.write("                <input type = \"button\" value=\"New Search\" class=\"button\" onclick=\"newSearch('search', 'list', 'onmap')\">\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <!--div for choosing topic to analyse, position right--> \r\n");
      out.write("            \r\n");
      out.write("            </div>\r\n");
      out.write("            <div id = \"forChoose\">\r\n");
      out.write("            <h3>Click on any topic for more details</h3> \r\n");
      out.write("            <p><i>Chosen topic: </i></p>   \r\n");
      out.write("            <p id = \"chosen\" >...</p>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <!--go to the next page-->\r\n");
      out.write("            <form method =\"POST\" action = \"index.jsp\">\r\n");
      out.write("                \r\n");
      out.write("            <input type = \"button\" value=\"Hashtags\" class=\"button\"  onclick = \"window.location.href = 'hashtags.jsp'\" > <br>\r\n");
      out.write("            <input type =\"text\" id=\"hid\" name =\"hid\">\r\n");
      out.write("            <a href=\"hashtags.jsp?tA= ");
request.getParameter("hid"); 
      out.write(" \" > Hashtags</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type = \"button\" value=\"Sentiments\" class=\"button\" onclick = \"window.location.href = 'sentiment.jsp'\">\r\n");
      out.write("             ");
   
                String toAnalyze = request.getParameter("hid");  
                if (toAnalyze!= null){
                    session.setAttribute("chosenToAnalyze", "hh ");
                } 
                else session.setAttribute("chosenToAnalyze", "blaa");
                
            
      out.write("  \r\n");
      out.write("            </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div> \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <!--Google maps view made with Google Maps API, location identification included-->\r\n");
      out.write("    \r\n");
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
      out.write("                var place =  document.getElementById(\"place\");    \r\n");
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
      out.write("                        place.value = \"lat: \" + pos.lat + \" lng: \" + pos.lng;\r\n");
      out.write("                    }, function() {\r\n");
      out.write("                        handleLocationError(true, infoWindow, map.getCenter());\r\n");
      out.write("                       });\r\n");
      out.write("                } else {\r\n");
      out.write("                // Browser doesn't support Geolocation\r\n");
      out.write("                handleLocationError(false, infoWindow, map.getCenter());\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("              function handleLocationError(browserHasGeolocation, infoWindow, pos) {\r\n");
      out.write("                infoWindow.setPosition(pos);\r\n");
      out.write("                infoWindow.setContent(browserHasGeolocation ?\r\n");
      out.write("                                      'Error: The Geolocation service failed.' :\r\n");
      out.write("                                      'Error: Your browser doesn\\'t support geolocation.');\r\n");
      out.write("                infoWindow.open(map);\r\n");
      out.write("              }\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyABCNA1YxzuoOpjxGPGAOT9FRsjVcTCKqo&callback=myMap\"></script>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>     \r\n");
      out.write("\r\n");
      out.write("  \r\n");
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
