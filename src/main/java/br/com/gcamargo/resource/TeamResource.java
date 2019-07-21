package br.com.gcamargo.resource;

import br.com.gcamargo.model.Team;
import br.com.gcamargo.model.dto.TeamDto;
import br.com.gcamargo.service.TeamService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/teams")
public class TeamResource {

    @Inject
    private TeamService teamService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TeamDto dto){
        teamService.save(Team.of(dto.getName()));
        return Response.created(URI.create("/teams")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response.ok(teamService.findAll()).build();
    }
}
