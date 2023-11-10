package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.flyway.DatabaseMigration;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DatabaseMigration databaseMigration = new DatabaseMigration();
        databaseMigration.fwMigration();

        ClientCrudService clientCrudService = new ClientCrudService();
        Client newClient = new Client();
        newClient.setName("Alisa");
        clientCrudService.create(newClient);

        PlanetCrudService planetCrudService = new PlanetCrudService();
        Planet planetMoon = new Planet();
        planetMoon.setId("MOON");
        planetMoon.setName("Moon");

        Planet planetSun = new Planet();
        planetSun.setId("SUN");
        planetSun.setName("Sun");
        planetCrudService.create(planetSun);

        TicketCrudService ticketCrudService = new TicketCrudService();
        Ticket newTicket = new Ticket();
        Date currentDate = new Date();
        newTicket.setCreatedAt(currentDate);
        newTicket.setClient(newClient);
        newTicket.setFromPlanet(planetMoon);
        newTicket.setToPlanet(planetSun);
        ticketCrudService.create(newTicket);



    }
}