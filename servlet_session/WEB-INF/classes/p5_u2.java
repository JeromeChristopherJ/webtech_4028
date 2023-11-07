import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class p5_u2 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();             
        String n=request.getParameter("uname");
        String mg=request.getParameter("genre");  
  
        out.print("Hello! Welcome back "+n+"and your favourite genre is"+mg);  
        out.close();  
        }catch(Exception e){System.out.println(e);}  
    } 
}