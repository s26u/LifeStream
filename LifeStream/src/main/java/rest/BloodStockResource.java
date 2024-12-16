/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.BloodStockSessionLocal;
import entity.Bloodstock;
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

/**
 * REST Web Service
 *
 * @author SUJAL
 */
@Path("generic")
@RequestScoped
public class BloodStockResource {

    @EJB
    private BloodStockSessionLocal bloodStockSession;

    @GET
    public List<Bloodstock> getAllBloodStock() {
        return bloodStockSession.findAll();
    }

    @GET
    @Path("/{id}")
    public Bloodstock getBloodStockById(@PathParam("id") int id) {
        return bloodStockSession.find(id);
    }

    @POST
    public Response addBloodStock(Bloodstock bloodStock) {
        bloodStockSession.create(bloodStock);
        return Response.status(Response.Status.CREATED).entity(bloodStock).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBloodStock(@PathParam("id") int id, Bloodstock bloodStock) {
        Bloodstock existingStock = bloodStockSession.find(id);
        if (existingStock == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        bloodStock.setBloodID(id);
        bloodStockSession.edit(bloodStock);
        return Response.ok(bloodStock).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBloodStock(@PathParam("id") int id) {
        Bloodstock stock = bloodStockSession.find(id);
        if (stock == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        bloodStockSession.remove(stock);
        return Response.noContent().build();
    }
}