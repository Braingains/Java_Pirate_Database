package com.codeclan.example.pirateservice.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //the following class will be used for our database modelling
@Table(name="pirates")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id") //Creates columns and gives them a name
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "age")
    private int age;

    //points back to the Ship class, which has many Pirates
    @ManyToOne
    //generates column "ship_id" foreign key in pirates table, pointing to id of ships table (primary key)
    @JoinColumn(name = "ship_id", nullable = false) //nullable = false ensures each pirate must have ship
    private Ship ship;

    @ManyToMany
    //in many-to-many, a join table is required
    @JoinTable(
        name = "pirates_raids",
        joinColumns = { @JoinColumn(
                //pirate_id is the column with the foreign key of this class (Pirate)
                name = "pirate_id",
                nullable = false,
                updatable = false)
        },
        inverseJoinColumns = { @JoinColumn(
                //Raid_id is the foreign key of the other class (Raid)
                name = "raid_id",
                nullable = false,
                updatable = false)
        }
    )

    private List<Raid> raids;

    //CONSTRUCTOR
    public Pirate(String firstName, String lastName, int age, Ship ship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<>();
    }

    //POJO - default constructor that takes no arguments, uses setters to make this one for the database
    public Pirate(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void addRaid(Raid raid) {
        this.raids.add(raid);
    }
}
