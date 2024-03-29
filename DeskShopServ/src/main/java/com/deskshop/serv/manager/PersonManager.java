package com.deskshop.serv.manager;

import com.deskshop.common.metier.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PersonManager extends HibernateFactory<Person> {
    public PersonManager() {
        super(Person.class);
    }

    public int Connect(String mail, String psw){
        Session session = getSession();
        Query query = session.createQuery("from Person as user where mel = :mail and psw = :mdp");
        query.setParameter("mail", mail);
        query.setParameter("mdp", psw);
        List users = query.list();
        for (int i = 0; i < users.size(); i++) {
            try {
                Person user = (Person)users.get(i);
                int id = user.getId();
                return id;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public boolean isBanker(Person person) {
        Session session = getSession();
        Query query = session.createQuery("from Administre as admin where admin.getionar=:person");
        query.setParameter("person", person);
        return !query.list().isEmpty();
    }

    public List<Person> findAllUsers(){
        Session session = getSession();
        Query query = session.createQuery("from Person as person");
        return query.list();
    }
}
