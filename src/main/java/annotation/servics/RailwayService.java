package annotation.servics;

import annotation.entity.RailwayReservation;
import annotation.entity.RareRailway;

public class RailwayService {


    public boolean isSeniorCitizen(int age) {
        if (age > 60) {
            return true;
        }

        return false;
    }

    public void amountPaid(RailwayReservation railwayReservation) {
        for (int i = 0; i < RareRailway.Type_OF_RESERVATION.length; i++) {
            if (RareRailway.Type_OF_RESERVATION[i].equalsIgnoreCase(railwayReservation.getTypeOfReservation())) {
                double amountPaid = RareRailway.RATE_OF_RESERVATION[i];
                railwayReservation.setAmountPaid(amountPaid);

            }
        }
    }
}





