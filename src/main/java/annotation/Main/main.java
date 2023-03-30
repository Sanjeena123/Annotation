package annotation.Main;

import annotation.datasource.DatasourceRailway;
import annotation.entity.RailwayReservation;
import annotation.servics.RailwayService;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        RailwayReservation railwayReservation = new RailwayReservation();
        DatasourceRailway datasourceRailway = new DatasourceRailway();
        RailwayService railwayService=new RailwayService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter passenger name ");
        String passengerName = scanner.next();
        railwayReservation.setPassengerName(passengerName);

        System.out.println("Please enter passenger age: ");
        int passengerAge = scanner.nextInt();
        railwayReservation.setAge(passengerAge);
        boolean isSeniorCitizen =railwayService.isSeniorCitizen(passengerAge);
        if(isSeniorCitizen==true) {
            System.out.println("you are eligible for economic seat");
        }else {
            System.out.println("you are not eligible for economic seat: ");
        }




        System.out.println("please choose Set");
        String choosenSeat = scanner.next();
        railwayReservation.setChosenSet(choosenSeat);

        System.out.println("please choose type of reservation [AC/NonAC");
        String typeOfReservasion = scanner.next();
        railwayReservation.setTypeOfReservation(typeOfReservasion);

        railwayService.amountPaid(railwayReservation);
        System.out.println("your total amount is:: "+railwayReservation.getAmountPaid());
        //Double a = scanner.nextDouble();

datasourceRailway.storeDataEntry(railwayReservation);
    }

}
