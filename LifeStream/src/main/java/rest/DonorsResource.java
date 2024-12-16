/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.DonorsSessionLocal;
import entity.Donors;
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
public class DonorsResource {

    @EJB
    private DonorsSessionLocal donorsSession;

    @GET
    public List<Donors> getAllDonors() {
        return donorsSession.findAll();
    }

    @GET
    @Path("/{id}")
    public Donors getDonorById(@PathParam("id") int id) {
        return donorsSession.find(id);
    }

    @POST
    public Response addDonor(Donors donor) {
        donorsSession.create(donor);
        return Response.status(Response.Status.CREATED).entity(donor).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDonor(@PathParam("id") int id, Donors donor) {
        Donors existingDonor = donorsSession.find(id);
        if (existingDonor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        donor.setDonorID(id);
        donorsSession.edit(donor);
        return Response.ok(donor).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDonor(@PathParam("id") int id) {
        Donors donor = donorsSession.find(id);
        if (donor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        donorsSession.remove(donor);
        return Response.noContent().build();
    }
}