package ejb;

import entity.CategorieEntity;
import entity.CommandeClientEntity;

import java.math.BigDecimal;
import java.util.List;

public interface GestionCommandeEJBRemote {

    public CommandeClientEntity createCommande(BigDecimal total, int clientId);
    public List<CategorieEntity> gererCommande();
    public void validerCommande(CommandeClientEntity commandeClientEntity);
    public void setLignesCommandes(int commandeClientId, int produitId, int quantity);
}
