package br.com.gcamargo.resource;

import br.com.gcamargo.model.Player;
import br.com.gcamargo.model.dto.PlayerDto;
import br.com.gcamargo.service.PlayerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/player")
public class PlayerResource {
    @Inject
    private PlayerService playerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(PlayerDto playerDto){
        Player player = playerService.addPlayer(playerDto);
        return Response.created(URI.create("/player/"+player.id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response.ok(playerService.findAll()).build();
    }
}
