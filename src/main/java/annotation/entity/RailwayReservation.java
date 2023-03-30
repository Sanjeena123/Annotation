package annotation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "rail_reservation")
public class RailwayReservation {
    @Id
    @Column(name = "passenger_name")
    private String passengerName;
    @Column(name = "passenger_age")
    private int age;


    @Column(name = "chosen_set")
    private String chosenSet;
    @Column(name = "reservation_type")
    private String typeOfReservation;

    @Column(name = "Amount")
    private double amountPaid;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getChosenSet() {
        return chosenSet;
    }

    public void setChosenSet(String chosenSet) {
        this.chosenSet = chosenSet;
    }

    public String getTypeOfReservation() {
        return typeOfReservation;
    }

    public void setTypeOfReservation(String typeOfReservation) {
        this.typeOfReservation = typeOfReservation;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public RailwayReservation(String passengerName, int age, String chosenSet, String typeOfReservation, double amountPaid) {
        this.passengerName = passengerName;
        this.age = age;
        this.chosenSet = chosenSet;
        this.typeOfReservation = typeOfReservation;
        this.amountPaid = amountPaid;
    }

    public RailwayReservation() {
    }
}