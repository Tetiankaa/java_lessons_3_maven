package entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String number;

        @ManyToOne(cascade = CascadeType.ALL) // It is used to map the association between two entities
        private User user;

}
