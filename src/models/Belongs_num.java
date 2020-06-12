package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "belongsNum")
@NamedQueries({

    @NamedQuery(
            name = "getAllBelongsNum",
            query = "SELECT e FROM Employee AS e ORDER BY e.id DESC"
            )})
@Entity
public class Belongs_num {


    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "belongs_name", nullable = false)
    private String belongs_name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBelongs_name() {
        return belongs_name;
    }

    public void setBelongs_name(String belongs_name) {
        this.belongs_name = belongs_name;


}
}