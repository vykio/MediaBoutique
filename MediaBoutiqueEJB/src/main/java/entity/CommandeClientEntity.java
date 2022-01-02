package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "commande_client")
public class CommandeClientEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "montant", nullable = false, precision = 6, scale = 2)
    private BigDecimal montant;

    @Column(name = "date_creation", nullable = false)
    private Instant dateCreation;

    @Column(name = "no_confirmation", nullable = false)
    private Integer noConfirmation;

    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getNoConfirmation() {
        return noConfirmation;
    }

    public void setNoConfirmation(Integer noConfirmation) {
        this.noConfirmation = noConfirmation;
    }

    public Instant getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}