package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID clientId;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolio = new ArrayList<>();

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contactInfo;

    protected  Client() {}

    public Client(Advisor advisor, String firstName, String lastName, String address, String contactInfo) {
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public UUID getClientId(){
        return clientId;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Advisor getAdvisor(){
        return advisor;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public  void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", advisor=" + (advisor != null ? (advisor.getFirstName() + advisor.getLastName()) : "null") +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }

}
