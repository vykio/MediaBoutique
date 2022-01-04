package servlets;

import ejb.MaBootiqueEJBLocal;
import ejb.MaBootiqueEJBRemote;
import entity.CategorieEntity;
import entity.ProduitEntity;
import utils.JndiConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "categorieServlet", value = "/categories")
public class categorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaBootiqueEJBRemote remote = JndiConnection.Remote.connect();

        List<CategorieEntity> categoriesFound = new ArrayList<>();
        List<ProduitEntity> produitsFound = new ArrayList<>();

        if(request.getParameterMap().containsKey("id") && !request.getParameter("id").isEmpty())
        {
            produitsFound = remote.getProduits(request.getParameter("id"));
        }
        categoriesFound = remote.getCategories();

        HttpSession session = request.getSession();
        session.setAttribute("categories", categoriesFound);
        session.setAttribute("produits", produitsFound);

        request.getRequestDispatcher("categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
