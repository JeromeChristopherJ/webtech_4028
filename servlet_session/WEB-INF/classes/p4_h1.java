import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class p4_h1 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{  
    try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String n=request.getParameter("userName");  
        String mg=request.getParameter("genre");  

        out.print("Welcome to the First Page "+n);
        out.println("");
        out.print("You have picked the music genre:"+mg);
        out.println("");

        out.print("<form action='hidden2' method='POST'>");  
        out.print("<input type='hidden' name='uname' value='"+n+"'>");  
        out.print("<input type='hidden' name='genre' value='"+mg+"'>");  
        out.print("<input type='submit' value='go to the second page'>");  
        out.print("</form>");  
        out.close(); 
        }
        catch(Exception e){System.out.println(e);}  
    }  
}  