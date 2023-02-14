package com.iscae.projetdevoir.servlets;

import com.iscae.projetdevoir.models.User;
import com.iscae.projetdevoir.controllers.AdminController;
import com.iscae.projetdevoir.controllers.NormalUserController;
import com.iscae.projetdevoir.controllers.ResponsibleController;
import com.iscae.projetdevoir.utils.DataStorage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class LoginServlet extends HttpServlet  {

  private static final long  serialVersionUID = 1L;
  private DataStorage dataStorage = DataStorage.getInstance();
  AdminController adminService;
  ResponsibleController responsibleService;
  NormalUserController normalUserService;

  public LoginServlet() {
    adminService = new AdminController();
    responsibleService = new ResponsibleController();
    normalUserService = new NormalUserController();
  }

  protected void doGet(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws ServletException, IOException {
    request
            .getRequestDispatcher("index.jsp")
            .forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    User user;
    user = adminService.login(username, password);

    if (user != null) {
      HttpSession session = request.getSession();
      session.setAttribute("user", user);

      response.sendRedirect("home");
    } else {
      request.setAttribute("errorMessage", "Invalid username or password");
      request
              .getRequestDispatcher("index.jsp")
              .forward(request, response);
    }
  }
}