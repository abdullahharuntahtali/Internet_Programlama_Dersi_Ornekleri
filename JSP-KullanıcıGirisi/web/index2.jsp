<jsp:useBean id="bean1" class="Database.Connect" scope="session" />
<%@page import="Database.*, java.util.*, java.text.DecimalFormat, java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String sayfa = (String) request.getParameter("sayfa");
boolean logged = bean1.isLoggedin();
//out.println(sayfa + " - " +  logged);
boolean devam = false;
if(sayfa.equalsIgnoreCase("index"))
    devam =true;
if(!logged || !devam){
%>
    <jsp:forward page="index.jsp">
        <jsp:param name="aa" value="aa"/>
    </jsp:forward>
    <%
}
else 
{
    String isim=(String)session.getAttribute("ad");
    String soyisim=(String)session.getAttribute("soyad");
%>

<html>
    <head>
    <meta charset="UTF-8">
    <title>KULLANICI GİRİŞİ</title>
    </head>
    <body leftmargin="160" rightmargin="100" topmargin="10">
        <h1>Sitemize Hoşgeldiniz</h1>
        <form method="post" action="">
            <table border="3" style="border-collapse: collapse" height="100">
                <tr>
                    <td colspan="2" height="30" align="center">
                        <p align="center">KULLANICI BİLGİSİ</p>
                    </td>
                </tr>
                <tr>
                    <td align="center" style="width:100">İsim </td> 
                    <td align="center" style="text-transform:uppercase; width:100"><%=isim%></td>       
                </tr>
                <tr>
                    <td align="center" style="width:100" >Soyisim </td> 
                    <td align="center" style="text-transform:uppercase; width:100"><%=soyisim%></td>       
                </tr>
    </body>
</html>
<%
}
%>
