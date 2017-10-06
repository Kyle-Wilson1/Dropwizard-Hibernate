package com.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
@NamedQueries({
        @NamedQuery(name = "com.model.Person.findAll",
                query = "select e from Person e")
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String name;

    @Column
    private String age;

    @Column(name="created_at")
    private String create_at;

    @Column
    private String update_at;

    @Column
    private String email;

    @Column
    private String password;

    //此处省略get set方法
    public long getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getAge()
    {
        return this.age;
    }
    public String getCreate_at()
    {
        return this.create_at;
    }
    public String getUpdate_at()
    {
        return this.update_at;
    }
}  