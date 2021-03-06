package geocache;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@NamedQuery(name="listVisiteByUser", query="SELECT v FROM VisiteEntity v WHERE v.visiteur = :user")

@Entity
@Table(name = "visite", schema = "geocache")
public class VisiteEntity {
    private int id;
    private Date dateVisite;
    private String photoVisite;
    private String commentaire;
    private CacheEntity cache;
    private UserEntity visiteur;

    public VisiteEntity() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dateVisite")
    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    @Basic
    @Column(name = "photoVisite")
    public String getPhotoVisite() {
        return photoVisite;
    }

    public void setPhotoVisite(String photoVisite) {
        this.photoVisite = photoVisite;
    }

    @Basic
    @Column(name = "commentaire")
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @ManyToOne
    @JoinColumn(name = "cache")
    public CacheEntity getCache() {
        return cache;
    }

    public void setCache(CacheEntity cache) {
        this.cache = cache;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "visiteur")
    public UserEntity getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(UserEntity visiteur) {
        this.visiteur = visiteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisiteEntity that = (VisiteEntity) o;
        return id == that.id && Objects.equals(dateVisite, that.dateVisite) && Objects.equals(photoVisite, that.photoVisite) && Objects.equals(commentaire, that.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateVisite, photoVisite, commentaire);
    }

    @Override
    public String toString() {
        return "VisiteEntity{" +
                "id=" + id +
                ", dateVisite=" + dateVisite +
                ", photoVisite='" + photoVisite + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
