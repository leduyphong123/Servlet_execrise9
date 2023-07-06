package controller;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {

    private UserService userService;

    public RegisterController() {
        userService = new UserServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/register.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String passwrod = request.getParameter("password");
        boolean messenger = false;
        try {
             messenger = userService.createUser(userName,phone,email, passwrod);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher;
        if (messenger){
            request.setAttribute("messenger",messenger);
            response.sendRedirect("/login");
        }else {
            request.setAttribute("messenger",messenger);
            dispatcher = request.getRequestDispatcher("view/user/register.jsp");
            dispatcher.forward(request,response);
        }
    }
}
