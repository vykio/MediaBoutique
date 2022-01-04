package servlets;

import ejb.MaBootiqueEJBLocal;
import ejb.MaBootiqueEJBRemote;
import pojo.ItemPanier;
import pojo.Panier;
import utils.JndiConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "panierServlet", value = "/panier")
public class panierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaBootiqueEJBRemote remote = JndiConnection.Remote.connect();

        Panier panier;

        HttpSession session = request.getSession();
        panier = (Panier) session.getAttribute("panier");

        if(panier == null){
            session.setAttribute("panier_items", new ArrayList<>());
        } else {
            System.out.println(panier);
            for(ItemPanier itemPanier : panier.getItems()){
                itemPanier.setProduit(remote.getProduitById(itemPanier.getProductId()));
            }
            panier.updateTotalPanier();
            session.setAttribute("panier_items", panier.getItems());
        }

        request.getRequestDispatcher("panier.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Panier panier;

        String idToAdd = request.getParameter("product_id_to_add");
        String idToRemove = request.getParameter("product_id_to_remove");

        if(session.getAttribute("panier") == null) {
            panier = new Panier();
        } else {
            panier = (Panier) session.getAttribute("panier");
        }

        if(idToRemove == null && idToAdd == null) {
            response.setStatus(500);
            return;
        }

        if (idToAdd != null) {
            panier.addItem(new ItemPanier(Integer.parseInt(idToAdd), 1));
        } else {
            panier.removeItemIfIdEquals(Integer.parseInt(idToRemove));
            panier.updateTotalPanier();
        }

        session.setAttribute("panier", panier);
        response.getWriter().println(panier.getTotal());
    }
}