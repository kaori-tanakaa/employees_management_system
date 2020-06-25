package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "employees")
@NamedQueries({
    @NamedQuery(
    name = "getAllEmployees",
    query = "SELECT e FROM Employee AS e ORDER BY e.id DESC"
    ),
@NamedQuery(
    name = "getEmployeesCount",
    query = "SELECT COUNT(e) FROM Employee AS e"
    ),
@NamedQuery(
        name = "loginuser",
        query = "SELECT e FROM Employee AS e WHERE e.code = :code AND e.delete_flg = 0"
        ),

@NamedQuery(
    name = "checkRegisteredCode",
    query = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :code"
    ),

@NamedQuery(
        name = "searchEmployees",
        query = "SELECT e FROM Employee AS e WHERE (e.code =:code OR :code IS NULL) "
               + "AND ((e.name_kanzi LIKE :name OR :name IS NULL) OR (e.name_kana LIKE :name OR :name IS NULL)) "
                + "AND (e.belongs.code=:belongs_num OR :belongs_num IS NULL) ORDER BY e.id DESC"
),

    @NamedQuery(
            name = "searchCount",
            query = "SELECT COUNT (e) FROM Employee AS e WHERE (e.code =:code OR :code IS NULL) "
                   + "AND ((e.name_kanzi LIKE :name OR :name IS NULL) OR (e.name_kana LIKE :name OR :name IS NULL)) "
                    + "AND (e.belongs.code=:belongs_num OR :belongs_num IS NULL) "
    )

})

@Entity
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name_kanzi", nullable = false)
    private String name_kanzi;

    @Column(name = "name_kana", nullable = false)
    private String name_kana;

    @Column(name = "admin_flg", nullable = false)
    private Integer admin_flg;

    @Column(name = "join_at", nullable = false)
    private Date join_at;

    @Column(name = "leave_at", nullable = true)
    private Date leave_at;

    @Column(name = "delete_flg", nullable = false)
    private Integer delete_flg;

    @Column(name = "birthday_at", nullable = false)
    private Date birthday_at;
    @ManyToOne
    @JoinColumn(name = "belongs_num", nullable = false)
    private Belongs_num belongs;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName_kanzi() {
        return name_kanzi;
    }

    public void setName_kanzi(String name_kanzi) {
        this.name_kanzi = name_kanzi;
    }

    public String getName_kana() {
        return name_kana;
    }

    public void setName_kana(String name_kana) {
        this.name_kana = name_kana;
    }

    public Integer getAdmin_flg() {
        return admin_flg;
    }

    public void setAdmin_flg(Integer admin_flg) {
        this.admin_flg = admin_flg;
    }

    public Date getjoin_at() {
        return join_at;
    }

    public void setjoin_at(Date join_at) {
        this.join_at = join_at;
    }

    public Date getleave_at() {
        return leave_at;
    }

    public void setleave_at(Date leave_at) {
        this.leave_at = leave_at;
    }

    public Integer getDelete_flg() {
        return delete_flg;
    }

    public void setDelete_flg(Integer delete_flg) {
        this.delete_flg = delete_flg;
    }

    public Date getbirthday_at() {
        return birthday_at;
    }

    public void setbirthday_at(Date birthday_at) {
        this.birthday_at = birthday_at;
    }

    public Belongs_num getbelongs() {
        return belongs;
    }

    public void setbelongs(Belongs_num belongs) {
        this.belongs = belongs;
    }





}

