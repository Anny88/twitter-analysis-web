package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import javaclasses.JavaTweet;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">    \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> \r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"tree.css\"> \r\n");
      out.write("    <script src=\"javascript.js\"></script>\r\n");
      out.write("</head> \r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"header stickyhead center\">\r\n");
      out.write("    <span class = \"logo\"><i>Twitter-analysis</i></span>\r\n");
      out.write("\r\n");
      out.write("    <a href=\"index.html\" class=\"head-item\">Hot topics</a>\r\n");
      out.write("    <a href=\"hashtags.html\" class=\"head-item\" style =\"border-bottom: 2px solid crimson;\">Hashtags</a>\r\n");
      out.write("    <a href=\"sentiment.html\" class=\"head-item\">Sentiment analysis</a>\r\n");
      out.write("    <a href=\"about.html\" class=\"head-item\">About project</a>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<div class = \"center\">    \r\n");
      out.write("    <div class=\"header stickyhead center\">\r\n");
      out.write("        <span class = \"logo\"><i>Twitter-analysis</i></span>\r\n");
      out.write("    \r\n");
      out.write("        <a href=\"index.html\" class=\"head-item\">Hot topics</a>\r\n");
      out.write("        <a href=\"hashtags.html\" class=\"head-item\">Hashtags</a>\r\n");
      out.write("        <a href=\"sentiment.html\" class=\"head-item\">Sentiment analysis</a>\r\n");
      out.write("        <a href=\"about.html\" class=\"head-item\" style =\"border-bottom: 2px solid crimson;\">About project</a>\r\n");
      out.write("    </div>\t\r\n");
      out.write("    \r\n");
      out.write("    <div class = \"main\" style = \"padding: 5%;\">\r\n");
      out.write("        <h3>About project</h3>\r\n");
      out.write("        <p align=\"justify\">\r\n");
      out.write("        Unser Leben bewegt sich mit unglaublicher Geschwindigkeit: einige Ideen werden durch die andere ersetzt. Hin und wieder wird Ã¼ber spannende Erfindungen oder schockierende Neuigkeiten diskutiert. Heutzutage ist die Meinung der Masse ein wichtiger politischer und Marketing-Tool. Wie konnte man Stimmung, Ansichten, Gedanken und Weltanschauung von Tausenden von Menschen in wenigen Sekunden verfolgen? Vor 20 Jahren wurde diese Annahme komisch klingen; aber heutige moderne Technologien bieten viele verschiedene MÃ¶glichkeiten an. Sportwettbewerbe oder politische Wahlen, Massenproteste und neu erschiene Filme, Kursverfall von Bitcoin und Trend zur Katzenfotographie â alles wird schnellstmÃ¶glich in den sozialen Netzwerken reflektiert. Deswegen werden die letzte als groÃes Plattform fÃ¼r soziale Forschung betrachtet. Diesem Thema wird auch folgende Bachelorarbeit gewidmet. \r\n");
      out.write("        </p>\r\n");
      out.write("        <p align=\"justify\">\r\n");
      out.write("        AuÃerhalb von Ort der Kommunikation, Soziale Netzwerke sind auch ein Handlungsfeld fÃ¼r Unternehmen, Politikern, Ã¶ffentlichen Organisationen, Blogger usw. Die Hauptfiguren benÃ¶tigen wichtige Informationen Ã¼ber ihre Produkte und ihren Ruf im Netz, um sich stÃ¤ndig zu verbessern und an die BedÃ¼rfnisse des Markts anzupassen; gewÃ¶hnliche Nutzer wollen auch ehrliche, transparente Auskunft darÃ¼ber, was in der Welt gedacht wird. NatÃ¼rlich, offene Daten von wenigen Nutzern kann man auch selbst analysieren, aber wenn es um groÃe Datenmengen geht, helfen nur programmatische Tools. \r\n");
      out.write("        </p>\r\n");
      out.write("        <p align=\"justify\">\r\n");
      out.write("        Als Plattform fÃ¼r diese Recherche wurde soziales Netzwerk Twitter â das populÃ¤rste âmicroblogging-toolâ ausgewÃ¤hlt. Der Grund dafÃ¼r ist starke Kommunikationsorientierung von Twitter im Vergleich z.B. zu Facebook. âDas Hauptaugenmerk liegt bei Twitter also darauf, Informationen zu teilen, und nicht, Nutzerprofile zu bauenâ. [1] Kurze Nachrichten werden denn schnellstmÃ¶glich wichtige Informationen der Welt mitgeteilt. Wichtige und bekannte Figuren in Politik, Sport, Business, Media, Kunst usw. haben meistens Twitter-Accounts und kommunizieren dadurch mit der Ãffentlichkeit. \r\n");
      out.write("\r\n");
      out.write("        </p>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
