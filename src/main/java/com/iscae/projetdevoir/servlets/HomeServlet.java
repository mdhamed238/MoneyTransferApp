package com.iscae.projetdevoir.servlets;

import com.iscae.projetdevoir.models.Admin;
import com.iscae.projetdevoir.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/home")
public class HomeServlet extends HttpServlet {
  private static final long  serialVersionUID = 1L;

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    User user = (Admin) request.getSession().getAttribute("user");

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
