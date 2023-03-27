import com.mysql.cj.Query;
import entity.Gender;
import entity.Passport;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //StandardServiceRegistry class in Hibernate, which is a central class that provides access to all Hibernate services and configuration settings.
        //StandardServiceRegistry, which is a lightweight object that holds configuration settings and provides access to various services like connection pooling, transaction management, and naming services.
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

//        User user = new User("Katya",new Passport("528628"),Gender.FEMALE);
//        session.save(user);
        //поєднати 2 окремі елементи
//        Passport passport1 = new Passport("123456");
//        session.save(passport1);
//
//        User user1 = new User("Vasiliy");
//        session.save(user1);

//        User user2 = session.find(User.class,8L);
//        Passport passport2=session.find(Passport.class,3);
//        user2.setPassport(passport2);

//        session.createQuery("from User u", User.class)
//                        .getResultList().forEach(user -> System.out.println(user));


        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
