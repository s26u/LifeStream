/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package rest;

import entity.Bloodstock;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

public class BloodStockClient {

    private static final String BASE_URI = "http://localhost:8080/LifeStream/webresources";
    private final Client client;

    public BloodStockClient() {
        this.client = ClientBuilder.newClient();
    }

    public List<Bloodstock> getAllBloodStock() {
        return client.target(BASE_URI)
                     .request(MediaType.APPLICATION_JSON)
                     .get(List.class);
    }

    public Bloodstock getBloodStockById(int id) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .get(Bloodstock.class);
    }

    public Response addBloodStock(Bloodstock bloodStock) {
        return client.target(BASE_URI)
                     .request(MediaType.APPLICATION_JSON)
                     .post(Entity.entity(bloodStock, MediaType.APPLICATION_JSON));
    }

    public Response updateBloodStock(int id, Bloodstock bloodStock) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .put(Entity.entity(bloodStock, MediaType.APPLICATION_JSON));
    }

    public Response deleteBloodStock(int id) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .delete();
    }

    public void close() {
        client.close();
    }
}