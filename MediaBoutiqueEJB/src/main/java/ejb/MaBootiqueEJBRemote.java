package ejb;

import entity.CategorieEntity;
import entity.ClientEntity;
import entity.ProduitEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface MaBootiqueEJBRemote {
    List<CategorieEntity> getCategories();
    List<ProduitEntity> getProduits(String id);
    ProduitEntity getProduitById(int product_id);
    public Boolean emailAlreadyExist(String email);
    public ClientEntity getUserByEmail(String email);
    public ClientEntity createClient(String name, String email, String password, String address, String phone);
    public ClientEntity login(String email, String password);

}
