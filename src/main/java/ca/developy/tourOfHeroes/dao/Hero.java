package ca.developy.tourOfHeroes.dao.beans;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue
    private Integer id;


    private String name;
}
