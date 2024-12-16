/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package rest;

import entity.Patients;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

public class PatientsClient {

    private static final String BASE_URI = "http://localhost:8080/LifeStream/webresources";
    private final Client client;

    public PatientsClient() {
        this.client = ClientBuilder.newClient();
    }

    public List<Patients> getAllPatients() {
        return client.target(BASE_URI)
                     .request(MediaType.APPLICATION_JSON)
                     .get(List.class);
    }

    public Patients getPatientById(int id) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .get(Patients.class);
    }

    public Response addPatient(Patients patient) {
        return client.target(BASE_URI)
                     .request(MediaType.APPLICATION_JSON)
                     .post(Entity.entity(patient, MediaType.APPLICATION_JSON));
    }

    public Response updatePatient(int id, Patients patient) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .put(Entity.entity(patient, MediaType.APPLICATION_JSON));
    }

    public Response deletePatient(int id) {
        return client.target(BASE_URI)
                     .path(String.valueOf(id))
                     .request(MediaType.APPLICATION_JSON)
                     .delete();
    }

    public void close() {
        client.close();
    }
}