package geocache;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "visite", schema = "geocache")
public class VisiteEntity {
    private int id;
    private Date dateVisite;
    private String photoVisite;
    private String commentaire;

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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cache")
    private CacheEntity cache;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "visiteur")
    private UserEntity visiteur;

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
}
