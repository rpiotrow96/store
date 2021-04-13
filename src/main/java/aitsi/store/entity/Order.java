package aitsi.store.entity;

import org.springframework.web.context.request.RequestContextHolder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERR")
public class Order {

    @Id
    @Size(max = 50)
    private String id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProducts;

    private Double sum;

    private Date orderDate;

    @Embedded
    private Address address;

    @OneToOne
    private User user;

    public Order() {
        this.id = RequestContextHolder.currentRequestAttributes().getSessionId();
        this.orderProducts = new LinkedHashSet<>();
        this.sum = 0.0;
        this.orderDate = new Date();
    }

    public void addProductWithAmount(Product product, int amount) {
        OrderProduct orderProduct = new OrderProduct(product, amount);

        if(this.orderProducts.contains(orderProduct)) {
            for (OrderProduct orderProductInSet : this.orderProducts) {
                if (orderProductInSet.equals(orderProduct))
                    orderProductInSet.addAmount(amount);
            }
        } else {
            orderProducts.add(orderProduct);
        }
    }

    public int getAmountOfProductInCart(Product product) {
        for (OrderProduct orderProduct : this.orderProducts) {
            if (orderProduct.getProduct().equals(product))
                return orderProduct.getAmount();
        }

        return 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (orderProducts != null ? !orderProducts.equals(order.orderProducts) : order.orderProducts != null)
            return false;
        if (sum != null ? !sum.equals(order.sum) : order.sum != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        return user != null ? user.equals(order.user) : order.user == null;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderProducts=" + orderProducts +
                ", sum=" + sum +
                ", orderDate=" + orderDate +
                ", address=" + address +
                ", user=" + user +
                '}';
    }
}
