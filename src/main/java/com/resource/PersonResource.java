package com.resource;

import com.codahale.metrics.annotation.Timed;
import com.dao.PersonDAO;
import com.model.Person;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Path(value = "person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    private PersonDAO dao;

    public PersonResource(PersonDAO dao){
        this.dao = dao;
    }

    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    public Person sayHello(@QueryParam("id") Long id) {
        Person person = dao.findById(id);
        return person;
    }

    @GET
    @Timed
    @UnitOfWork
    public List<Person> sayHello1(@QueryParam("all") Long id) {
        return dao.findAll();
    }


//    @GET
//    @Timed
//    @UnitOfWork
//    public List<Person> sayHello1(@QueryParam("all") String t) {
//        Session s=HibernateUtil.currentSession();
//
//        //from后面是对象，不是表名
//        String hql="from Person as person";//使用命名参数，推荐使用，易读。
//        Query query=s.createQuery(hql);
//        //return dao.list(query);
//        List<Person> ret=query.list();
//
//        return ret;
//    }
}