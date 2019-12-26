package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Database.*;
import java.util.*;
import java.text.DecimalFormat;
import java.sql.*;

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

      Database.Connect bean1 = null;
      synchronized (session) {
        bean1 = (Database.Connect) _jspx_page_context.getAttribute("bean1", PageContext.SESSION_SCOPE);
        if (bean1 == null){
          bean1 = new Database.Connect();
          _jspx_page_context.setAttribute("bean1", bean1, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

            String login = request.getParameter("login");
            String message = "";
            if (login != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println("username=" + username + " password=" + password);
                boolean logged = bean1.checkLogin(username, password);
                ResultSet rs = bean1.login(username, password);
                if (rs != null) {
                    while (rs.next()) {
                        String isim = rs.getString("username");
                        String soyisim = rs.getString("surname");
                        System.out.println("isim=" + isim +" "+ "soyisim=" +soyisim);
                        if (isim != null) {
                            session.setAttribute("ad", isim);
                            session.setAttribute("soyad", soyisim);
                            if (logged) {

      out.write('\n');
      if (true) {
        _jspx_page_context.forward("index2.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("sayfa", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("index", request.getCharacterEncoding()));
        return;
      }
      out.write('\n');

                            } else {
                                message = "Kullanıcı Adı veya Şifre Hatalı !!!";
                                System.out.println(message);
                            }
                        }
                    }
                }
            }

      out.write(" \n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <<meta charset=\"UTF-8\">\n");
      out.write("        <title>KULLANICI GİRİŞİ</title>\n");
      out.write("    </head>\n");
      out.write("    <body leftmargin=\"160\" rightmargin=\"100\" topmargin=\"10\">\n");
      out.write("        <form method=\"post\" action=\"\">\n");
      out.write("            <table border=\"3\" style=\"border-collapse: collapse\" height=\"151\">\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" height=\"30\" align=\"center\">\n");
      out.write("                        <p align=\"center\">KULLANICI GİRİŞİ</p>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td width=\"50%\" align=\"center\">Kullanıcı Adı</td>\n");
      out.write("                    <td align=\"center\">\n");
      out.write("                    <input type=\"text\" name=\"username\" size=\"15\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td width=\"50%\" align=\"center\">Şifre</td>\n");
      out.write("                    <td align=\"center\">\n");
      out.write("                    <input type=\"password\" name=\"password\" size=\"15\"></td>\n");
      out.write("                 </tr>\n");
      out.write("                 <tr>\n");
      out.write("                     <td colspan=\"2\" height=\"30\" align=\"center\" style=\"color: #FF0000\">");
      out.print(message);
      out.write("</td>\n");
      out.write("                 </tr>\n");
      out.write("                 <tr>\n");
      out.write("                     <td colspan=\"2\">\n");
      out.write("                     <p align=\"center\">\n");
      out.write("                        <input type=\"submit\" value=\"GİRİŞ YAP\" name=\"login\">\n");
      out.write("                     </p>\n");
      out.write("                     </td>\n");
      out.write("                 </tr>       \n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
