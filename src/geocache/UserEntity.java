package geocache;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "geocache")
public class UserEntity {
    private int id;
    private String pseudo;
    private String description;
    private String photo;
    private List<CacheEntity> cacheList;
    private List<VisiteEntity> visiteList;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pseudo")
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @OneToMany(mappedBy = "proprietaire")
    public List<CacheEntity> getCacheList() {
        return cacheList;
    }

    public void setCacheList(List<CacheEntity> cacheList) {
        this.cacheList = cacheList;
    }

    @OneToMany(mappedBy = "visiteur")
    public List<VisiteEntity> getVisiteList() {
        return visiteList;
    }

    public void setVisiteList(List<VisiteEntity> visiteList) {
        this.visiteList = visiteList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(pseudo, that.pseudo) && Objects.equals(description, that.description) && Objects.equals(photo, that.photo);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pseudo, description, photo);
    }
}
