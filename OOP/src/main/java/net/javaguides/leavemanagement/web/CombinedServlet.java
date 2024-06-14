package net.javaguides.leavemanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.leavemanagement.dao.CombinedDAO;
import net.javaguides.leavemanagement.model.Leave;
import net.javaguides.leavemanagement.model.User;

@WebServlet("/")
public class CombinedServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CombinedDAO combinedDAO;

    public void init() {
        combinedDAO = new CombinedDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertLeave(request, response);
                    break;
                case "/delete":
                    deleteLeave(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateLeave(request, response);
                    break;
                default:
                    listLeave(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Leave> listLeave = combinedDAO.selectAllLeaves();
        request.setAttribute("leaveList", listLeave);
        RequestDispatcher dispatcher = request.getRequestDispatcher("leave-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("leave-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Leave existingLeave = combinedDAO.selectLeave(id);
        request.setAttribute("leave", existingLeave);
        RequestDispatcher dispatcher = request.getRequestDispatcher("leave-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        String type = request.getParameter("type");
        Leave newLeave = new Leave(name, status, type);
        combinedDAO.insertLeave(newLeave);
        response.sendRedirect("list");
    }

    private void updateLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String status = request.getParameter("status");
    String type = request.getParameter("type");
    Leave leaveToUpdate = new Leave(id, name, status, type);
    combinedDAO.updateLeave(leaveToUpdate);
    response.sendRedirect("list"); // Redirect to leave-list.jsp after updating
}

    private void deleteLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        combinedDAO.deleteLeave(id);
        response.sendRedirect("list");
    }
}
