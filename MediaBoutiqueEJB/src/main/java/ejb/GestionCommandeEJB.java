package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.CategorieEntity;
import entity.CommandeClientEntity;
import entity.ProduitCommandeEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class GestionCommandeEJB {

    @PersistenceContext(unitName = "managerMaBootique")
    EntityManager em;

    public GestionCommandeEJB(){

    }

    public CommandeClientEntity createCommande(BigDecimal total, int clientId){
        CommandeClientEntity commandeClient = new CommandeClientEntity();

        commandeClient.setMontant(total);
        commandeClient.setClientId(clientId);
        commandeClient.setDateCreation(Instant.now());
        commandeClient.setNoConfirmation(commandeClient.getId());

        em.persist(commandeClient);

        em.flush();

        return commandeClient;
    }

    public List<CategorieEntity> gererCommande(){
        return null;
    }

    public void validerCommande(CommandeClientEntity commandeClientEntity){

    }

    public void setLignesCommandes(int commandeClientId, int produitId, int quantity){
        ProduitCommandeEntity produitCommandeEntity = new ProduitCommandeEntity();

        produitCommandeEntity.setId(commandeClientId);
        produitCommandeEntity.setProduitId(produitId);
        produitCommandeEntity.setQuantite(quantity);

        em.persist(produitCommandeEntity);
        em.flush();
        System.out.println("Item Commande ajouté : "+ produitCommandeEntity.getId()+", "+produitCommandeEntity.getProduitId()+", "+produitCommandeEntity.getQuantite());
    }

}
