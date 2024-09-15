package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Security {
     @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID securityId;

     @ManyToOne
     @JoinColumn(name="portfolio_id", nullable=false)
     private Portfolio portfolio;

     @Column(nullable = false)
    private String name;

     @Column(nullable = false)
    private String category;

     @Column(nullable = false)
    private java.time.LocalDateTime purchaseDate;

     @Column(nullable = false)
    private BigDecimal purchasePrice;

     @Column(nullable = false)
    private int quantity;

     protected Security(){}

    public Security(Portfolio portfolio, String name, String category, java.time.LocalDateTime purchaseDate,
                    BigDecimal purchasePrice,
                    int quantity){
         this.portfolio = portfolio;
         this.name = name;
         this.category = category;
         this.purchaseDate= purchaseDate;
         this.purchasePrice = purchasePrice;
         this.quantity = quantity;
    }

    //Setters and Getters
    public  UUID getSecurityId(){
         return securityId;
    }

    public void setPortfolio(Portfolio portfolio){
         this.portfolio = portfolio;
    }

    public Portfolio getPortfolio(){
         return portfolio;
    }

    public void setName(String name){
         this.name =  name;
    }

    public String getName(){
         return name;
    }

    public void setCategory(String category){
         this.category = category;
    }

    public String getCategory(){
         return category;
    }

    public void setPurchaseDate(java.time.LocalDateTime purchaseDate){
         this.purchaseDate = purchaseDate;
    }

    public java.time.LocalDateTime getPurchaseDate(){
         return purchaseDate;
    }

    public void setPurchasePrice(BigDecimal purchasePrice){
         this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchasePrice(){
         return purchasePrice;
    }

    public void setQuantity(int quantity){
         this.quantity = quantity;
    }

    public int getQuantity(){
         return quantity;
    }

    @Override
    public String toString() {
        return "Security{" +
                "securityId=" + securityId +
                ", portfolio=" + (portfolio != null ? portfolio.getPortfolioId() : "null") +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", purchasePrice=" + purchasePrice +
                ", quantity=" + quantity +
                '}';
    }
}
