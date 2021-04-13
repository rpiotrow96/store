package aitsi.store.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 2, max = 50, message = "Proszę podaj nazwę leku zawierającą od 2 do 50 znaków")
    @NotEmpty(message = "Proszę podaj nazwę leku")
    private String name;

    @Length(min = 2, max = 50, message = "Proszę podaj nazwę producenta zawierającą od 2 do 50 znaków")
    @NotEmpty(message = "Proszę podaj nazwę producenta")
    private String producer;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    @Length(max = 1000, message = "Opis nie może być dłuższy niż 1000 znaków")
    private String description;

    @Digits(integer = 10, fraction = 2,
            message = "Proszę wprowadź cenę do 2 miejsc po przecinku i o 10 przed przecinkiem")
    @DecimalMin(value = "0.01", message = "* Proszę wprowadź cenę produktu")
    @NotNull(message = "Proszę podaj cenę")
    private Double prize;

    @Valid
    @ManyToOne
    private ProductType productType;

    @NotNull(message = "Proszę podaj dostępną ilość produktu")
    @Min(value = 0, message = "Proszę wprowadź liczbę nieujemną dostępnej ilości produktu")
    private long unitsInStock;

    private long availableAmount;

    public Product() {
    }

    public Product(String producer, String name, String description, Double prize, ProductType productType, long unitsInStock) {
        this.producer = producer;
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.productType = productType;
        this.unitsInStock = unitsInStock;
        this.availableAmount = unitsInStock;
    }

    public void subtractAmountOfProduct(int amountToSubtract) {
        availableAmount -= amountToSubtract;
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

    public long getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(long availableAmount) {
        this.availableAmount = availableAmount;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(id, product.id);
    }


    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", prize=" + prize +
                ", productType=" + productType +
                ", availableAmount=" + availableAmount +
                ", unitsInStock=" + unitsInStock +
                '}';
    }
}
