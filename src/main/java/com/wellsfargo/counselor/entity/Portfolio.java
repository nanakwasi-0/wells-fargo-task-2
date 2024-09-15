package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    @Column(nullable = false)
    private java.time.LocalDateTime createdOn;

    //default constructor
    protected Portfolio(){}

    //instance of Portfolio
    public Portfolio(Client client, java.time.LocalDateTime createdOn){
        this.client = client;
        this.createdOn = createdOn;
    }

    public long getPortfolioId(){
        return portfolioId;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Client getClient(){
        return client;
    }

    public void setCreatedOn(java.time.LocalDateTime createdOn){
        this.createdOn = createdOn;
    }

    public java.time.LocalDateTime getCreatedOn(){
        return createdOn;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolioId=" + portfolioId +
                ", clientId=" + (client !=null  ? client.getClientId() : "null") +
                ", createdOn=" + createdOn +
                '}';
    }
}
