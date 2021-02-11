package geocache;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "cache", schema = "geocache")

@NamedQuery(name="listVisiteFiltre", query="SELECT c FROM CacheEntity c WHERE c.proprietaire = :proprietaire")

public class CacheEntity {

    private int id;
    private String description;
    private String typeCache;
    private String natureCache;
    private String etat;
    private String coordGps;
    private LieuEntity lieu;
    private UserEntity proprietaire;
    private List<VisiteEntity> visiteList;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "typeCache")
    public String getTypeCache() {
        return typeCache;
    }

    public void setTypeCache(String typeCache) {
        this.typeCache = typeCache;
    }

    @Column(name = "natureCache")
    public String getNatureCache() {
        return natureCache;
    }

    public void setNatureCache(String natureCache) {
        this.natureCache = natureCache;
    }

    @Column(name = "etat")
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Column(name = "coordGPS")
    public String getCoordGps() {
        return coordGps;
    }

    public void setCoordGps(String coordGps) {
        this.coordGps = coordGps;
    }

    @JoinColumn(name = "lieu")
    @ManyToOne(cascade = CascadeType.DETACH)
    public LieuEntity getLieu() {
        return lieu;
    }

    public void setLieu(LieuEntity lieu) {
        System.out.println(lieu);
        this.lieu = lieu;
    }

    @JoinColumn(name = "proprietaire")
    @ManyToOne(cascade = CascadeType.DETACH)
    public UserEntity getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(UserEntity proprietaire) {
        this.proprietaire = proprietaire;
    }

    @OneToMany(mappedBy = "cache", cascade = CascadeType.ALL)
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
        CacheEntity that = (CacheEntity) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(typeCache, that.typeCache) && Objects.equals(natureCache, that.natureCache) && Objects.equals(etat, that.etat) && Objects.equals(coordGps, that.coordGps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, typeCache, natureCache, etat, coordGps);
    }

    @Override
    public String toString() {
        return "CacheEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", typeCache='" + typeCache + '\'' +
                ", natureCache='" + natureCache + '\'' +
                ", etat='" + etat + '\'' +
                ", coordGps='" + coordGps + '\'' +
                ", lieu=" + lieu.toString() +
                ", proprietaire=" + proprietaire.toString() +
                '}';
    }
}
