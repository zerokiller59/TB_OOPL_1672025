package com.tb.entity;
// Generated Jan 10, 2020 9:34:01 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BalanceHistory generated by hbm2java
 */
@Entity
@Table(name="balance_history"
    ,catalog="db_tboopl_20191"
)
public class BalanceHistory  implements java.io.Serializable {


     private Integer id;
     private User user;
     private boolean isTopup;
     private double value;
     private String description;

    public BalanceHistory() {
    }

	
    public BalanceHistory(User user, boolean isTopup, double value) {
        this.user = user;
        this.isTopup = isTopup;
        this.value = value;
    }
    public BalanceHistory(User user, boolean isTopup, double value, String description) {
       this.user = user;
       this.isTopup = isTopup;
       this.value = value;
       this.description = description;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="is_topup", nullable=false)
    public boolean isIsTopup() {
        return this.isTopup;
    }
    
    public void setIsTopup(boolean isTopup) {
        this.isTopup = isTopup;
    }

    
    @Column(name="value", nullable=false, precision=22, scale=0)
    public double getValue() {
        return this.value;
    }
    
    public void setValue(double value) {
        this.value = value;
    }

    
    @Column(name="description", length=45)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


