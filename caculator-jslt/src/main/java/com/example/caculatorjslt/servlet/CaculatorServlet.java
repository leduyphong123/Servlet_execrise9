package com.example.caculatorjslt.servlet;

import com.example.caculatorjslt.model.Caculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CaculatorServlet" , value = "/caculator")
public class CaculatorServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Float firt = Float.parseFloat(request.getParameter("firt"));
        Float second = Float.parseFloat(request.getParameter("second"));
        String operator = request.getParameter("operator");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        try {
            float result = Caculator.caculator(firt,second,operator);
            out.println(firt.toString()+" "+operator +" "+ second + " = " + result);
        }catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
        out.println("</body></html>");
    }
}
