/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package rest;

import entity.Donors;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

public class DonorsClient {

    private static final String BASE_URI = "http://localhost:8080/LifeStream/webresources";
    private final Client client;

    public DonorsClient() {
        this.client = ClientBuilder.newClient();
    }

    public List<Donors> getAllDonors() {
        return client.target(BASE_URI)
                     .request(MediaType.APPLICATION_JSON)
                     .get(List.class);
    }

    public Donors getDonorById(int id) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .get(Donors.class);
    }

    public Response addDonor(Donors donor) {
        return client.target(BASE_URI)
                     .request(MediaType.APPLICATION_JSON)
                     .post(Entity.entity(donor, MediaType.APPLICATION_JSON));
    }

    public Response updateDonor(int id, Donors donor) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .put(Entity.entity(donor, MediaType.APPLICATION_JSON));
    }

    public Response deleteDonor(int id) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .delete();
    }

    public void close() {
        client.close();
    }
}