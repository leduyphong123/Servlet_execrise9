package com.example.loginpage;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet" ,value = "/login")
public class LoginServlet extends HttpServlet{

    public void init (){}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (email.equals("admin") && password.equals("admin")){
            out.println("<h1> Welecom " + email + "</h1>");
        }else {
            out.println("<h1> Login error </h1>" );
        }
        out.println("</body></html>");
    }
}
