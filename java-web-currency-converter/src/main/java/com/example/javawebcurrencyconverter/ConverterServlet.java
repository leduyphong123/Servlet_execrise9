package com.example.javawebcurrencyconverter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet", value ="/covert")
public class ConverterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Float rate = Float.parseFloat(request.getParameter("rate"));
        Float usd = Float.parseFloat(request.getParameter("usd"));

        Float result = rate * usd;

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2> result = " + result + "</h2>");
        out.println("</body></html>");
    }
}
