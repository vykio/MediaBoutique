package ejb;

import entity.CategorieEntity;
import entity.ClientEntity;
import entity.ProduitEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless(name = "MaBootiqueJNDI")
public class MaBootiqueEJB implements MaBootiqueEJBRemote, MaBootiqueEJBLocal {

    @PersistenceContext(unitName = "managerMaBootique")
    EntityManager em;

    public MaBootiqueEJB() {

    }

    public List<CategorieEntity> getCategories()
    {
        TypedQuery<CategorieEntity> q = em.createQuery("select h from CategorieEntity h", CategorieEntity.class);
        return q.getResultList();
    }

    public List<ProduitEntity> getProduits(String categoryId)
    {
        TypedQuery<ProduitEntity> q = em.createQuery("select h from ProduitEntity h where h.categorieId=:categoryId", ProduitEntity.class);
        return q.setParameter("categoryId", categoryId).getResultList();
    }

    public ProduitEntity getProduitById(int productId)
    {
        TypedQuery q = em.createQuery("select h from ProduitEntity h where h.id=:productId", ProduitEntity.class);
        return (ProduitEntity) q.setParameter("productId", productId).getSingleResult();
    }

    public Boolean emailAlreadyExist(String email)
    {
        try{
            TypedQuery<ClientEntity> q = em.createQuery("select h from ClientEntity h where h.email=:email", ClientEntity.class);
            ClientEntity res = q.setParameter("email", email).getSingleResult();
        }
        catch (NoResultException e){
            return false;
        }
        return true;
    }

    public ClientEntity getUserByEmail(String email)
    {
        ClientEntity res;
        try{
            TypedQuery<ClientEntity> q = em.createQuery("select h from ClientEntity h where h.email=:email", ClientEntity.class);
            res = q.setParameter("email", email).getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }

        return res;
    }

    public ClientEntity createClient(String name, String email, String password, String address, String phone){
        ClientEntity newClient = new ClientEntity();

        newClient.setNom(name);
        newClient.setEmail(email);
        newClient.setTelephone(phone);
        newClient.setAdresse(address);
        newClient.setPassword(password);

        // Crée une instance de Client Entity persistente
        em.persist(newClient);

        // Sync persistence contexte avec la database
        em.flush();

        return newClient;
    }

    public ClientEntity login(String email, String password) {
        ClientEntity client;
        try {
            client = (ClientEntity) em.createQuery("SELECT h FROM ClientEntity h WHERE h.email=:email AND h.password=:password").setParameter("email", email).setParameter("password", password).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return client;
    }

}
