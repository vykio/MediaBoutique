package pojo;

import entity.ProduitEntity;

public class ItemPanier {

    private int productId;
    private int quantity;
    private ProduitEntity produit;

    public ItemPanier(int id, int quantity){
        this.productId = id;
        this.quantity = quantity;
        this.produit = null;
    }

    public ProduitEntity getProduit() {
        return produit;
    }

    public void setProduit(ProduitEntity produit) {
        this.produit = produit;
    }

    public int getProductId() { return productId; }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}