import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class p1 extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
     try{
        response.setContentType("text/html");

        PrintWriter pwriter = response.getWriter();

        String in_data = request.getParameter("userin");
        
        Cookie c = new Cookie("Ucookie",in_data);      

        response.addCookie(c);

        pwriter.print("<h3>Your favourite music artist is:</h3>"+in_data);

        pwriter.println("<br /> This is how cookie is SET");

        //pwriter.print("<a href='Sessions2'>view details</a>");
      
        pwriter.close();
    }
     catch(Exception exp){
       System.out.println(exp);
     }
  }
}