package geocache;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lieu", schema = "geocache")
public class LieuEntity {
    private int id;
    private String nom;
    private String ville;
    private String codep;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "codep")
    public String getCodep() {
        return codep;
    }

    public void setCodep(String codep) {
        this.codep = codep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LieuEntity that = (LieuEntity) o;
        return id == that.id && Objects.equals(nom, that.nom) && Objects.equals(ville, that.ville) && Objects.equals(codep, that.codep);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, nom, ville, codep);
    }

    @Override
    public String toString() {
        return "LieuEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", codep='" + codep + '\'' +
                '}';
    }
}
