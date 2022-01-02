package pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Panier {

    private List<ItemPanier> items;
    private BigDecimal total;

    public Panier(){
        this.items = new ArrayList<>();
        this.total = new BigDecimal(0);
    }

    public void addItem(ItemPanier itemPanier){
        List<ItemPanier> items = this.getItems();
        for (int i = 0; i < items.size(); i++) {
            ItemPanier currElement = items.get(i);
            if (currElement.getProductId() == itemPanier.getProductId()) {
                currElement.setQuantity(currElement.getQuantity() + 1);
                items.set(i, currElement);
                this.setItems(items);
                return;
            }
        }
        items.add(itemPanier);
        this.setItems(items);
    }

    public void removeItem(ItemPanier itemPanier){
        this.items.remove(itemPanier);
    }

    public void removeItemIfIdEquals(int idToRemove)
    {
        /* Pour éviter les Concurrent Modification Exceptions */
        List<ItemPanier> items = this.getItems();
        for (int i = 0; i < this.items.size(); i++) {
            ItemPanier currElement = items.get(i);
            if (currElement.getProductId() == idToRemove) {
                items.remove(i);
                break;
            }
        }
        this.setItems(items);
    }

    public List<ItemPanier> getItems() {
        return items;
    }

    public void setItems(List<ItemPanier> items) {
        this.items = items;
    }

    public BigDecimal updateTotalPanier() {

        setTotal(new BigDecimal(0));

        for (ItemPanier item : getItems()) {
            total = total.add(item.getProduit().getPrix().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        return total;
    }

    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (ItemPanier item: items) {
            s.append(item.getProductId()+" ");
        }
        return s.toString();
    }
}