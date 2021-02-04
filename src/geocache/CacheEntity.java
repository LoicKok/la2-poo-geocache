package geocache;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cache", schema = "geocache", catalog = "")
public class CacheEntity {
    private int id;
    private String description;
    private String typeCache;
    private String natureCache;
    private String etat;
    private String coordGps;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "typeCache")
    public String getTypeCache() {
        return typeCache;
    }

    public void setTypeCache(String typeCache) {
        this.typeCache = typeCache;
    }

    @Basic
    @Column(name = "natureCache")
    public String getNatureCache() {
        return natureCache;
    }

    public void setNatureCache(String natureCache) {
        this.natureCache = natureCache;
    }

    @Basic
    @Column(name = "etat")
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Basic
    @Column(name = "coordGPS")
    public String getCoordGps() {
        return coordGps;
    }


    @OneToOne
    @JoinColumn(name="lieu")
    private LieuEntity lieu;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "proprietaire")
    private UserEntity proprietaire;

    @OneToMany(mappedBy = "cache")
    private List<VisiteEntity> visiteList;


    public void setCoordGps(String coordGps) {
        this.coordGps = coordGps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheEntity that = (CacheEntity) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(typeCache, that.typeCache) && Objects.equals(natureCache, that.natureCache) && Objects.equals(etat, that.etat) && Objects.equals(coordGps, that.coordGps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, typeCache, natureCache, etat, coordGps);
    }
}
