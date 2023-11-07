import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class p4_h2 extends HttpServlet {  
        public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{  
                try
                {  
                        response.setContentType("text/html");  
                        PrintWriter out = response.getWriter();   
                        String n=request.getParameter("uname"); 
                        String mg=request.getParameter("genre");  
 
                        out.print("Hello "+n+". Good to be back.");
                        out.println("");
                        out.print("Hello "+n+". You have picked the genre."+mg);
                        out.println(""); 
  
                        out.close();  
                }
                catch(Exception e){System.out.println(e);}    
        }
}