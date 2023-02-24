package Infrastructure;

import Service.LocalDateDeserializer;
import Service.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private String lastname;
    private String firstname;
    private String street;
    private String postalCode;
    private String city;
    private String phonePrivate;
    private String phoneMobile;
    private String email;

    //Definiert den Gebrauch des Serializer und Deserializer für das Geburtsdatum
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    //Konstruktor zur Erstellung eines Kunden
    public Client(String lastname, String firstname, String street, String postalCode, String city, String phonePrivate, String phoneMobile, String email, String dateOfBirth) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.phonePrivate = phonePrivate;
        this.phoneMobile = phoneMobile;
        this.email = email;
        setDateOfBirthAsString(dateOfBirth);
    }

    public Client() {

    }

    //Getter und Setter
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getPhonePrivate() {
        return phonePrivate;
    }
    public void setPhonePrivate(String phonePrivate){
        this.phonePrivate = phonePrivate;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }
    public void setPhoneMobile(String phoneMobile){
        this.phoneMobile = phoneMobile;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //ersetzt durch DateOfBirthAsString
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirthAsString() {
        return this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public void setDateOfBirthAsString(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
