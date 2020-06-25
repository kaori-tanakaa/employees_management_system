package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name = "password")
@NamedQueries({

    @NamedQuery(
            name = "getAllPassword",
            query = "SELECT e FROM Employee AS e ORDER BY e.id DESC"
            ),


    @NamedQuery(
            name = "checkLoginCodeAndPassword",
            query ="SELECT e FROM Password AS e WHERE e.code = :code AND e.password = :pass"
            )
})
@Entity
public class Password {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "password", length = 64, nullable = false)
    private String password;





    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
