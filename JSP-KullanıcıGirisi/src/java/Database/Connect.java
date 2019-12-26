
package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
    
    private static java.sql.Connection conn;
    private boolean check; 
    private boolean loggedin;
    public Connect() {
        if (isClosed()) {
        try {
            Class.forName("com.mysql.jdbc.Driver");//MySQL-Java bağlantısını sağlayan JDBC sürücüsü   
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magaza", "root", "123456");
            System.out.println("BAGLANTI BASARILI");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        loggedin = false;
    }

    public static boolean isClosed() {
        try {
            return conn.isClosed();
        } catch (Exception e) {
            return true;
        }
    }

    public ResultSet getResultSet(String query) {
        try {
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(query);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        }
    }

    public ResultSet login(String username,String password)
    {
        String sorgu="select * from uye_kayit where username='"+username+"' AND password='"+password+"'";
        ResultSet rs = getResultSet(sorgu);
        return rs;
    }
 
    public boolean checkLogin(String username,String password)
    {
        try {
        String sorgu="select * from uye_kayit where username='"+username+"' AND password='"+password+"'";
        ResultSet rs = getResultSet(sorgu);
        if (rs != null) {
            while (rs.next()) {
                //String isim = rs.getString("username");
                //System.out.println("isim="+isim);
                setLoggedin(true);
                return true;
            }
        }
        } catch (Exception exception) {
        }
        return false;
    }
 
    public boolean isLoggedin() {
        return loggedin;
    }

    private void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }
    
    public void closeConn() {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Connect connect= new Connect();
        //connect.checkLogin("ayse", "123456");
    }
}
