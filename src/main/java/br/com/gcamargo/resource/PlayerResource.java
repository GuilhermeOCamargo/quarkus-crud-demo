package br.com.gcamargo.resource;

import br.com.gcamargo.model.Player;
import br.com.gcamargo.model.dto.PlayerDto;
import br.com.gcamargo.service.PlayerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerResource {
    @Inject
    private PlayerService playerService;

    @POST
    public Response insert(PlayerDto playerDto){
        return Response.ok(playerDto).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(Arrays.asList(new Player())).build();
    }
}
