import com.mysql.cj.Query;
import entity.Gender;
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
                .getMetadataBuilder()
                .build();
        //. addAnnotatedClass method is called to add the User class as a persistent class to the configuration.Can be used to add multiple persistent classes to the configuration.
        //.new MetadataSources(serviceRegistry) creates a new MetadataSources object with the given ServiceRegistry.
        // The ServiceRegistry holds all the Hibernate services and configuration settings that are required to build metadata for a SessionFactory.
        //
        //.getMetadataBuilder() obtains a MetadataBuilder from the MetadataSources object.
        // The MetadataBuilder is used to build a Metadata object that represents the consolidated metadata for a SessionFactory.
        //
        //.build() builds the Metadata object using the MetadataBuilder. This creates a Metadata object that contains information
        // about all the entity classes, mapping files, and other sources of mapping information that are relevant for building a SessionFactory.

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        //Here, metadata.getSessionFactoryBuilder() obtains a SessionFactoryBuilder from the Metadata object,
        // which is used to build a SessionFactory using the build() method.
        Session session = sessionFactory.openSession(); //The Session is a lightweight object that represents a single unit of work with the database.

//       User user = session.find(User.class,1L); // to find user with ID =1
//        System.out.println(user);
     //   session.remove(user);
      session.beginTransaction(); //Transactions are used to group a set of database operations into a single atomic unit of work that either succeeds or fails as a whole.

//        User user = session.find(User.class,1L);
//        user.setName("vania");
//        session.update(user);

        // session.createNativeQuery("select * from user_table where id>0");
//        List<User> users = session
//        .createQuery("select u from User u where u.id>0", User.class)
//                .getResultList();
//        System.out.println(users);

//        User user = new User("tanya"); //0
//        session.save(user); //1
//        System.out.println(user); //2

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        User user = new User("Anya",skills, Gender.FEMALE);
        session.save(user);
//
        session.getTransaction().commit(); //This persists all changes made within the transaction to the database.

       session
                .createQuery("select u from User u where u.id>0", User.class)
                .getResultList()
                        .forEach(user1 -> System.out.println(user1));



        session.close();
        sessionFactory.close();
    }
}
