package br.com.fiap.resources;

import br.com.fiap.domain.equipamento.model.Equipamento;
import br.com.fiap.domain.equipamento.model.TipoEquipamento;
import br.com.fiap.domain.equipamento.repository.EquipamentoRepository;
import br.com.fiap.domain.equipamento.repository.TipoEquipamentoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;

@Path("/equipamento")
public class EquipamentoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() { return Response.ok(EquipamentoRepository.findAll()).build(); }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Equipamento e = EquipamentoRepository.findById(id);
        Response.ResponseBuilder res;

        if (e != null) {
            res = Response.ok();

            res.entity(e);
        } else {
            res = Response.status(404);
        }

        return res.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Equipamento e) {

        var equipamento = EquipamentoRepository.save(e);

        final URI equipamentoURI = UriBuilder
                .fromResource(EquipamentoResource.class)
                .path("/{id}")
                .build(equipamento.getId());

        return Response.created(equipamentoURI).entity(equipamento).build();
    }

}
