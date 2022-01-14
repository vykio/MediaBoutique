package servlets;

import ejb.GestionCommandeEJBRemote;
import entity.ClientEntity;
import entity.CommandeClientEntity;
import pojo.ItemPanier;
import pojo.Panier;
import utils.Connection;
import utils.JndiConnection;
import utils.Utils;

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

        if (!Utils.sessionAttributeExists(request.getSession(), "panier")) {
            response.setStatus(403);
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }

        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionCommandeEJBRemote jndi = JndiConnection.Remote.connect("GestionCommande");

        HttpSession session = request.getSession();
        ClientEntity client = (ClientEntity) session.getAttribute("client");
        Panier panier = (Panier) session.getAttribute("panier");

        CommandeClientEntity commandeClientEntity = jndi.createCommande(panier.getTotal(),client.getId());

        List<ItemPanier> items = panier.getItems();
        for (ItemPanier item : items ) {
            jndi.setLignesCommandes(commandeClientEntity.getId(), item.getProductId(), item.getQuantity());
        }

        // Supprimer le panier
        session.removeAttribute("panier");
        // Rediriger vers la page d'accueil en donnant un paramètre (hors session) de type String message
        // et qui sera utilisé par le front si il existe

        request.setAttribute("command", commandeClientEntity);
        request.setAttribute("confirmation", "Merci pour votre commande !");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
