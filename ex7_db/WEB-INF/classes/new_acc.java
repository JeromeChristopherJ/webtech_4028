import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class new_acc extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String password = request.getParameter("password");
        String cpass = request.getParameter("con_pass");

        out.println("<html><head><style>");
        out.println("body { text-align: center; }");
        out.println("h3 { font-size: 35px; }");
        out.println("p { font-size: 25px; }"); 
        out.println("</style></head><body>");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root", "");
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO new_account (uname, email, mobile, dob, password, cpassword) VALUES (?, ?, ?, ?, ?, ?)"); 
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, mobile);
            pstmt.setString(4, dob);
            pstmt.setString(5, password);
            pstmt.setString(6, cpass);

            pstmt.executeUpdate();
            out.println("<br /> <h3>New Account is created successfully !!</h3>");
            String sql = "SELECT * FROM new_account WHERE uname = ? AND password = ? AND mobile = ? AND email = ? AND dob = ? AND cpassword = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, mobile);
            pstmt.setString(4, email);
            pstmt.setString(5, dob);
            pstmt.setString(6, cpass);
            ResultSet rs = pstmt.executeQuery();
            out.println("<html><body><p>Your data has been Inserted:</p>");
            while(rs.next())
            {
            String uname = rs.getString("uname");
            String mail = rs.getString("email");
            int no = rs.getInt("mobile");;
            out.println("<p> username: " + uname + "<br>");
            out.println("Email: " + mail + "<br>");
            out.println("Mobile number: " + no + "<br></p>");            
            }
            out.println("</body></html>");
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}