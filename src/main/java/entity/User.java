package entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity //this annotation is used to define a class as an entity that can be mapped to a database table
@Table(name = "user_table") //is used to specify the name of the database table that the entity will be mapped to.

@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    @Id //is used to mark the id field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // is used to specify how the primary key values are generated
    private long id;
    @Column(name = "user_name") //is used to map the entity's fields to columns in the database table.
    private String name;

    @ElementCollection(fetch = FetchType.LAZY) // is a JPA annotation that is used to specify a collection of basic types or embeddable objects in an entity class.
    private List<String> skills = new ArrayList<>();
      //By default, when a collection is mapped using @ElementCollection, the collection is loaded lazily(fetch = FetchType.LAZY), which means that the collection elements are not loaded from the database until they are actually accessed.
    //
    //However, in some cases, you may want to load the collection eagerly, i.e., load the collection elements from the database along with the owning entity.

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    //The @Enumerated annotation is used in JPA (Java Persistence API) to map an enum type to a database column. By default, JPA maps the enum type to an ordinal value (i.e., the order in which the values are declared in the enum).
    // However, you can use the @Enumerated annotation to specify that the enum type should be mapped to a string value instead.
    //
    //The @Enumerated annotation takes one argument, which is an EnumType value. The possible values are:
    //
    //EnumType.ORDINAL: The default value. The enum type is mapped to an integer column, representing the ordinal value of the enum constant.
    //EnumType.STRING: The enum type is mapped to a string column, representing the name of the enum constant.

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date timestamp; // the "timestamp" field will be mapped to a database timestamp type with temporal precision up to milliseconds.

    public User(String name, List<String> skills, Gender gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
    }
}
