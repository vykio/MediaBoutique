package servlets;

import ejb.MaBootiqueEJBLocal;
import ejb.MaBootiqueEJBRemote;
import entity.ClientEntity;
import utils.Connection;
import utils.JndiConnection;
import utils.Url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "connexionServlet", value = {"/login", "/register", "/logout"})
public class ConnexionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (Url.getRoute(request).equals("logout")) {
            session.removeAttribute("client");
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        if (Connection.isLoggedIn(session)) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        switch (Url.getRoute(request)) {
            case "register":
                request.getRequestDispatcher("enregistrement.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("connexion.jsp").forward(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MaBootiqueEJBRemote jndi = JndiConnection.Remote.connect("MaBootique");
        HttpSession session = request.getSession();

        if (Connection.isLoggedIn(session)) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        switch (Url.getRoute(request)) {
            case "register":
                String name = request.getParameter("inputName");
                String email = request.getParameter("inputEmail");
                String password = request.getParameter("inputPassword");
                String passwordVerif = request.getParameter("inputPassword-verify");
                String address = request.getParameter("inputAddress");
                String phone = request.getParameter("inputPhone");

                assert jndi != null;
                if(jndi.emailAlreadyExist(email) || !password.equals(passwordVerif)){
                    request.setAttribute("error-msg", "L'email est d??j?? utilis??e ou les deux mots de passes ne correspondent pas");
                    request.getRequestDispatcher("enregistrement.jsp").forward(request,response);
                    return;
                }

                ClientEntity newClient = jndi.createClient(name,email,password,address,phone);
                response.getWriter().println("ID du nouveau client :"+newClient.getId());
                response.sendRedirect("login");
                break;
            default:
                String emailLogin = request.getParameter("inputEmail-login");
                String passwordLogin = request.getParameter("inputPassword-login");

                assert jndi != null;
                ClientEntity client = jndi.login(emailLogin,passwordLogin);

                if(client == null) {
                    request.setAttribute("error-msg", "L'adresse mail ou le mot de passe est incorrect");
                    request.getRequestDispatcher("connexion.jsp").forward(request,response);
                    return;
                }

                session.setAttribute("client", client);

                response.getWriter().println("Informations du client connect?? : "+client.getId()+", "+ client.getNom()+", "+client.getEmail());
                response.sendRedirect("index");
                break;
        }

    }
}
