import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class p2 extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
     try{
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        Cookie[] ck=request.getCookies();
        int len=ck.length;
        String name, value;
        pwriter.println("<h3>Hello - The obtained cookie is:</h3>");

        for(int i=0;i<len;i++)
        {
            name=ck[i].getName();
            value=ck[i].getValue();

            pwriter.println("Cookie name: "+name);
            pwriter.println("<br> Your favourite music artist: "+value);
        }
        pwriter.close();
    }
     catch(Exception exp){
       System.out.println(exp);
     }
  }
}
