package edu.narxoz.galactic;

import java.util.Scanner;

import edu.narxoz.galactic.edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.edu.narxoz.galactic.task.DeliveryTask;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cargo weight: ");
        int weight = sc.nextInt();
        System.out.println("Enter cargo type: ");
        String cargo1 = sc.next();

        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation iss = new SpaceStation("ISS", 100, 0, 10);

        Cargo cargo = new Cargo(weight, cargo1);

        LightDrone light = new LightDrone("LD-1", 20);
        HeavyDrone heavy = new HeavyDrone("HD-1", 100);

        DeliveryTask task = new DeliveryTask(earth, iss, cargo);
        Dispatcher dispatcher = new Dispatcher();

        Result r1 = dispatcher.assignTask(task, light);
        System.out.println("LightDrone assign: " + r1.ok());

        Result r2 = dispatcher.assignTask(task, heavy);
        System.out.println("HeavyDrone assign: " + r2.ok());

        System.out.println("Estimated time: " + task.estimateTime());

        Result r3 = dispatcher.completeTask(task);
        System.out.println("Complete: " + r3.ok());

        System.out.println("Drone status: " + heavy.getStatus());
        System.out.println("Task state: " + task.getState());
    }
}
