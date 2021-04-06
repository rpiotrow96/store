package aitsi.store.entity;

import javax.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Product product;

    @ManyToOne
    private Order order;

    private int amount;

    public OrderProduct() {
    }

    public OrderProduct(Product product, Order order, int amount) {
        this.product = product;
        this.order = order;
        this.amount = amount;
    }

    public OrderProduct(Product product, int amount) {
        this.id = product.getId();
        this.product = product;
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProduct that = (OrderProduct) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                ", amount=" + amount +
                '}';
    }
}
