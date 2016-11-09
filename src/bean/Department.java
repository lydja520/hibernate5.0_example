package bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ydc on 16-11-8.
 */
@Entity
@Table(name = "t_dept")
public class Department implements Serializable,Cloneable{

    private String id;
    private String name;

    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id",length = 36,nullable = false,unique = true,updatable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name",length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
