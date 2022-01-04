package servlets;

import ejb.GestionCommandeEJBRemote;
import entity.ClientEntity;
import entity.CommandeClientEntity;
import pojo.ItemPanier;
import pojo.Panier;
import utils.Connection;
import utils.JndiConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ConfirmationServlet", value = "/validation")
public class ConfirmationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Connection.isLoggedIn(request.getSession())) {
            response.setStatus(403);
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionCommandeEJBRemote remote = JndiConnection.Remote.connect();


        HttpSession session = request.getSession();
        ClientEntity client = (ClientEntity) session.getAttribute("client");
        Panier panier = (Panier) session.getAttribute("panier");

        /*
        CommandeClientEntity commandeClientEntity = remote.createCommande(panier.getTotal(),client.getId());

        List<ItemPanier> items = panier.getItems();
        for (ItemPanier item : items ) {
            remote.setLignesCommandes(commandeClientEntity.getId(), item.getProductId(), item.getQuantity());
        }

         */
    }
}
