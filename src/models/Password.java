package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "password")
@NamedQueries({
    @NamedQuery(
            name = "checkLoginCodeAndPassword",
            query = "SELECT p FROM Employee AS p WHERE p.delete_flg = 0 AND p.code = :code AND p.password = :pass"
            )
})
@Entity
public class Password {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "password", length = 64, nullable = false)
    private String password;





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
