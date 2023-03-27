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

    @OneToOne(cascade =CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY) //It is used to specify that one entity has a single relationship with another entity.
    @JoinColumn(name = "passport_id",referencedColumnName = "id") // "passport_id" -так буде називатись в таблиці. referencedColumnName = "id" - це посилання на клас Passport на його id
    @ToString.Exclude // щоб рекурсивно не викликалися ToString. Бо виходить що в класі User та в класі Passport визначено один і той самий метод.
    private Passport passport;
    // -  CascadeType.ALL - This means that any operation performed on User (e.g., persist, update, delete) will be cascaded to Passport.
    // In this case, if you persist User, Passport will also be persisted; if you delete User, Passport will also be deleted.
    // - CascadeType.PERSIST -(save) to propagate the persistence operation from an entity to its associated entities.
    // - CascadeType.MERGE -(update) When CascadeType.MERGE is specified for a particular relationship, it means that any changes made to the parent entity
    // (the one that owns the relationship) will be automatically propagated to the child entity (the one that is related to the parent through the relationship) when the parent entity is merged into the persistence context.
    //orphanRemoval = true - if one or more of these child entities are removed from the collection, they will no longer be referenced by the parent entity.
    //If orphanRemoval is set to true, then these child entities will also be removed from the database.
    //******************************************
    @ElementCollection(fetch = FetchType.LAZY) // is a JPA annotation that is used to specify a collection of basic types or embeddable objects in an entity class.
    private List<String> skills = new ArrayList<>();
      //By default, when a collection is mapped using @ElementCollection, the collection is loaded lazily(fetch = FetchType.LAZY), which means that the collection elements are not loaded from the database until they are actually accessed.
    //
    //However, in some cases, you may want to load the collection eagerly, i.e., load the c ollection elements from the database along with the owning entity.

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable( //you can use @JoinTable to define the name of the join table and the names of the foreign key columns.
            name = "user_car",
            joinColumns = @JoinColumn(name = "user_id_x"), // головний
            inverseJoinColumns = @JoinColumn(name = "car_id_x") // другорядний
            // The joinColumns attribute specifies the foreign key column for the current entity (user_id_x), and the inverseJoinColumns attribute specifies the foreign key column for the related entity (car_id_x).
    )
    private List<Car> cars = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_sunglass",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns  = @JoinColumn(name = "sg_id")
    )
    private List<Sunglass> sunglass = new ArrayList<>();

    public User(String name, Passport passport, Gender gender) {
        this.name = name;
        this.passport = passport;
        this.gender = gender;
    }

    public User(String name) {
        this.name = name;
    }
}
