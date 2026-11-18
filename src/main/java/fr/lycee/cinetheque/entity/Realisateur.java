package fr.lycee.cinetheque.entity;
import jakarta.persistence.*;

@Entity
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String prenom;
    private String nationalite;

    public Realisateur() {
    }
    // --- Getters & Setters (generez-les : Alt+Inser -> Getter and Setter ---

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getNationalite() {return nationalite;}
    public void setNationalite(String n) {this.nationalite = n;}
}
