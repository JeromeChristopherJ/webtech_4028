import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class p5_u1 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{  
        try{  
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  
            String n=request.getParameter("userName");
            String mg=request.getParameter("genre");  
  
            out.print("Welcome "+n);  
            out.println("");
            out.print("<a href='url2?uname="+n+"genre="+mg+"'>visit the next page</a>");  
            out.close();  
        }
        catch(Exception e){System.out.println(e);}  
    } 
}  