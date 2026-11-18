package fr.lycee.cinetheque.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    private Integer annee;
    private Integer duree;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    private LocalDate dateSortie;
    private boolean disponible;

    @Column(length = 13, unique = true)
    private String ean;

    @Transient
    private Integer ageDuFilm;

    public Film(){
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitre() {return titre;}
    public void setTitre(String titre) {this.titre = titre;}

    public Integer getAnnee() {return annee;}
    public void setAnnee(Integer annee) {this.annee = annee;}

    public Integer getDuree() {return duree;}
    public void setDuree(Integer duree) {this.duree = duree;}

    public Genre getGenre() {return genre;}
    public void setGenre(Genre genre) {this.genre = genre;}

    public Realisateur getRealisateur() {return realisateur;}
    public void setRealisateur(Realisateur realisateur) {this.realisateur = realisateur;}

    public LocalDate getDateSortie() {return dateSortie;}
    public void setDateSortie(LocalDate dateSortie) {this.dateSortie = dateSortie;}

    public boolean isDisponible() {return disponible;}
    public void setDisponible(boolean disponible) {this.disponible = disponible;}

    public String getEan() {return ean;}
    public void setEan(String ean) {this.ean = ean;}

    public Integer getAgeDuFilm() {return ageDuFilm;}
    public void setAgeDuFilm(Integer ageDuFilm) {this.ageDuFilm = ageDuFilm;}
}
