package com.iscae.projetdevoir.servlets;

import com.iscae.projetdevoir.models.User;
import com.iscae.projetdevoir.services.AdminService;
import com.iscae.projetdevoir.services.NormalUserService;
import com.iscae.projetdevoir.services.ResponsibleService;
import com.iscae.projetdevoir.utils.DataStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

  private DataStorage dataStorage = DataStorage.getInstance();
  AdminService adminService;
  ResponsibleService responsibleService;
  NormalUserService normalUserService;

  public LoginServlet() {
    adminService = new AdminService();
    responsibleService = new ResponsibleService();
    normalUserService = new NormalUserService();
  }

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    request
            .getRequestDispatcher("home.jsp")
            .forward(request, response);
  }

  @Override
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    User user;
    user = adminService.login(username, password);

    if (user != null) {
      HttpSession session = request.getSession();
      session.setAttribute("user", user);
      response.sendRedirect("/home");
    } else {
      request.setAttribute("errorMessage", "Invalid username or password");
      request
        .getRequestDispatcher("index.jsp")
        .forward(request, response);
    }
  }
}