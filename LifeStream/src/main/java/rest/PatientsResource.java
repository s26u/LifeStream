/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PatientsSessionLocal;
import entity.Patients;
import jakarta.ejb.EJB;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;

@Path("generic")
@RequestScoped
public class PatientsResource {

 @EJB
    private PatientsSessionLocal patientsSession;

    @GET
    public List<Patients> getAllPatients() {
        return patientsSession.findAll();
    }

    @GET
    @Path("/{id}")
    public Patients getPatientById(@PathParam("id") int id) {
        return patientsSession.find(id);
    }

    @POST
    public Response addPatient(Patients patient) {
        patientsSession.create(patient);
        return Response.status(Response.Status.CREATED).entity(patient).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") int id, Patients patient) {
        Patients existingPatient = patientsSession.find(id);
        if (existingPatient == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        patient.setPatientID(id);
        patientsSession.edit(patient);
        return Response.ok(patient).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id) {
        Patients patient = patientsSession.find(id);
        if (patient == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        patientsSession.remove(patient);
        return Response.noContent().build();
    }
}