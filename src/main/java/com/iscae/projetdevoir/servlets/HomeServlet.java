package com.iscae.projetdevoir.servlets;

import com.iscae.projetdevoir.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("user");

    if (user == null) {
      response.sendRedirect("/");
      return;
    }

    request.setAttribute("username", user.getUsername());
    request
      .getRequestDispatcher("home.jsp")
      .forward(request, response);
  }
}
