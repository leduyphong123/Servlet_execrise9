package com.example.simple_dictionary;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet" , value = "/translate")
public class TranslationServlet extends HttpServlet {
    private Map<String,String> dictionary;
    @Override
    public void init(){
        dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String trans = request.getParameter("txtSearch");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String result = dictionary.get(trans);
        if (result !=null){
            out.println("<h2> result : " + result + "</h2>");
        }else {
            out.println("<h2> not translation " + trans + "</h2>");
        }

        out.println("</body></html>");

    }
}
