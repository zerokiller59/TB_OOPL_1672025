package com.tb.entity;
// Generated Jan 10, 2020 9:34:01 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Genre generated by hbm2java
 */
@Entity
@Table(name="genre"
    ,catalog="db_tboopl_20191"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Genre  implements java.io.Serializable {


     private int id;
     private String name;
     private Set<Film> films = new HashSet<Film>(0);

    public Genre() {
    }

	
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Genre(int id, String name, Set<Film> films) {
       this.id = id;
       this.name = name;
       this.films = films;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", unique=true, nullable=false, length=25)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tags", catalog="db_tboopl_20191", joinColumns = { 
        @JoinColumn(name="genre_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="film_id", nullable=false, updatable=false) })
    public Set<Film> getFilms() {
        return this.films;
    }
    
    public void setFilms(Set<Film> films) {
        this.films = films;
    }




}

