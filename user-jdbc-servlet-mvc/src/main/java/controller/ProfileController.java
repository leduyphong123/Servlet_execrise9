package controller;


import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProfileController", value = "/profile")
public class ProfileController extends HttpServlet {
    private UserService userService;

    public ProfileController() {
        userService = new UserServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aution = request.getParameter("action");
        if (aution == null){
            aution = "";
        }
        switch (aution){
            case "edit":
                try {
                    editProfile(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
                requestDispatcher.forward(request, response);
                break;
        }

    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserId(id);
        request.setAttribute("users",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        Boolean messenger;
        try {
            messenger = userService.editUSer(id,userName,phone);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (messenger){
            try {
                request.setAttribute("user",userService.getUserId(id));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
            requestDispatcher.forward(request, response);
        }

    }

}
