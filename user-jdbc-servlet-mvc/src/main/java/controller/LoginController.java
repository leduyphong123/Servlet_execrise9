package controller;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private UserService userService;

    public LoginController() {
        userService = new UserServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/login.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String passwrod = request.getParameter("password");
        User user;
        try {
            user = userService.getUser(email, passwrod);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher;
        if (user!=null){
            if (passwrod.equals(user.getPassword())){
                request.setAttribute("user",user);
//                response.sendRedirect("/profile");
                dispatcher = request.getRequestDispatcher("view/home.jsp");
                dispatcher.forward(request,response);
            }else {
                request.setAttribute("messenger",false);
                dispatcher = request.getRequestDispatcher("view/user/login.jsp");
                dispatcher.forward(request,response);
            }

        }else {
            request.setAttribute("messenger",false);
            dispatcher = request.getRequestDispatcher("view/user/login.jsp");
            dispatcher.forward(request,response);
        }
    }
}
