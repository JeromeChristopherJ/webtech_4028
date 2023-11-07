import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class update extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        String username = request.getParameter("uname");
        String new_pass = request.getParameter("new_pass");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root", "");
            stmt = conn.createStatement();
            String sql = "UPDATE login_check SET password = ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, new_pass);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
              out.println("<html><head><style>");
              out.println("body { text-align: center; }");
              out.println("h3 { font-size: 35px; }");
              out.println("p { font-size: 25px; }"); 
              out.println("</style></head><body>");
              out.print("<h3>HELLO " + username + "</h3>");
              out.println("<br /> <p>Update Successful!</p>");
        
        out.println("</body></html>");
          } else {
              out.println("<html><body>");
              out.println("<h1>Update Failed</h1>");
              out.println("</body></html>");
          }
          rs.close();
          pstmt.close();
          conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}