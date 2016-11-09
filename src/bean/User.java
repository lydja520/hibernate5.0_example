package bean;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ydc on 16-11-6.
 */
@Entity(name = "User")
@Table(name = "t_user")
public class User implements Serializable, Cloneable {

    private String id;
    private String name;
    private String pwd;
    private Date brithday;
    private Department dept;

    @javax.persistence.Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", length = 36, nullable = false, unique = true, updatable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "brithday")
    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @ManyToOne
    @JoinColumn(name = "dept_id",nullable = true)
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
