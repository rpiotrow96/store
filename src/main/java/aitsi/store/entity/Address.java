package aitsi.store.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Embeddable
public class Address {
    @Length(min = 2, max = 50, message = "* Proszę podaj nazwę ulicy zawierającą od 2 do 50 znaków")
    @NotEmpty(message = "* Proszę podaj nazwę ulicy")
    private String street;

    @Pattern(regexp = "[1-9][0-9a-zA-Z]*", message = "* Proszę podaj poprawny numer domu")
    @NotEmpty(message = "* Proszę podaj numer domu")
    private String numberOfHouse;

    @Pattern(regexp = "[0-9][0-9a-zA-Z]*", message = "* Proszę podaj poprawny numer mieszkania")
    private String numberOfFlat;

    @Length(min = 2, max = 50, message = "* Proszę podaj nazwę miasta zawierającą od 2 do 50 znaków")
    @NotEmpty(message = "* Proszę podaj nazwę miasta")
    private String city;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "* Proszę podaj poprawny kod pocztowy")
    @NotEmpty(message = "* Proszę podaj kod pocztowy")
    private String postCode;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public String getNumberOfFlat() {
        return numberOfFlat;
    }

    public void setNumberOfFlat(String numberOfFlat) {
        this.numberOfFlat = numberOfFlat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", numberOfHouse='" + numberOfHouse + '\'' +
                ", numberOfFlat='" + numberOfFlat + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
