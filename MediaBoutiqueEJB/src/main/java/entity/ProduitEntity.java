package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "produit")
public class ProduitEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 45)
    private String nom;

    @Column(name = "prix", nullable = false, precision = 5, scale = 2)
    private BigDecimal prix;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "dernier_maj", nullable = false)
    private Instant dernierMaj;

    @Column(name = "categorie_id", nullable = false, length = 2)
    private String categorieId;

    public String getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(String categorieId) {
        this.categorieId = categorieId;
    }

    public Instant getDernierMaj() {
        return dernierMaj;
    }

    public void setDernierMaj(Instant dernierMaj) {
        this.dernierMaj = dernierMaj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}