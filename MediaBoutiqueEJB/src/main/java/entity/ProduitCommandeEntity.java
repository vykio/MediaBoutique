package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "produit_commande")
public class ProduitCommandeEntity implements Serializable {
    @Id
    @Column(name = "commande_client_id", nullable = false)
    private Integer id;

    @Column(name = "produit_id", nullable = false)
    private Integer produitId;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}