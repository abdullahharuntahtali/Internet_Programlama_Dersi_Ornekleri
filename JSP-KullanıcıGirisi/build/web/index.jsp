<jsp:useBean id="bean1" class="Database.Connect" scope="session" />
<%@page import="Database.*, java.util.*, java.text.DecimalFormat, java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            String login = request.getParameter("login");
            System.out.println("login="+login);
            String message = "";
            if (login != null) {
                String username = request.getParameter("isim");
                String password = request.getParameter("sifre");
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
                            if (logged){
%>
<jsp:forward page="index2.jsp">    
    <jsp:param name="sayfa" value="index"></jsp:param>
</jsp:forward>
<%
                            } }}
                            if (!logged){
                                message = "Kullanıcı Adı veya Şifre Hatalı !!!";
                                System.out.println(message);
                            }
}}
                    
                
            
%> 
<html>
    <head>
        <meta charset="UTF-8">
        <title>KULLANICI GİRİŞİ</title>
    </head>
    <body leftmargin="160" rightmargin="100" topmargin="10">
        <form method="post" action="">
            <table border="3" style="border-collapse: collapse" height="151">
                <tr>
                    <td colspan="2" height="30" align="center">
                        <p align="center">KULLANICI GİRİŞİ</p>
                    </td>
                </tr>
                <tr>
                    <td width="50%" align="center">Kullanıcı Adı</td>
                    <td align="center">
                    <input type="text" name="isim" size="15"></td>
                </tr>
                <tr>
                    <td width="50%" align="center">Şifre</td>
                    <td align="center">
                    <input type="password" name="sifre" size="15"></td>
                 </tr>
                 <tr>
                     <td colspan="2" height="30" align="center" style="color: #FF0000"><%=message%></td>
                 </tr>
                 <tr>
                     <td colspan="2">
                     <p align="center">
                        <input type="submit" value="GİRİŞ YAP" name="login">
                     </p>
                     </td>
                 </tr>       
            </table>
        </form>
    </body>
</html>
