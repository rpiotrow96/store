package aitsi.store.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String producer;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private Double prize;
    @ManyToOne
    private ProductType productType;

    public Product() {
    }

    public Product(String producer, String name, String description, Double prize, ProductType productType) {
        this.producer = producer;
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id != null ? id.equals(product.id) : product.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prize=" + prize +
                ", productType=" + productType +
                '}';
    }
}
