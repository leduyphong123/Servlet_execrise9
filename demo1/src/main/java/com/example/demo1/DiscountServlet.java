package com.example.demo1;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String description = request.getParameter("description");
        Long price = Long.parseLong(request.getParameter("price"));
        Integer discount = Integer.parseInt(request.getParameter("discount"));
        Double amount = (double)price*discount*(0.01);
        Double discountPrice = price - amount;
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2 class='mb-3'>Product Details</h2>");
        out.println("<div>Product Description: "+description+"</div>");
        out.println("<div>List Price: "+price+"</div>");
        out.println("<div>Discount Percent: "+discount+"</div>");
        out.println("<h2 class='my-3'>Result</h2>");
        out.println("<div>Discount Amount: "+amount+"</div>");
        out.println("<div>Discount Price: "+discountPrice+"</div>");
        out.println("</body></html>");

    }
}
