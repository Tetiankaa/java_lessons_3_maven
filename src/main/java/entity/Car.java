package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_car",
            joinColumns = @JoinColumn(name = "car_id_x"),//головний
    inverseJoinColumns = @JoinColumn(name = "user_id_x") //другорядний
    )
    private User user;
}
