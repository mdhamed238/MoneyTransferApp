package com.iscae.projetdevoir.services;

import com.iscae.projetdevoir.models.TransferService;
import com.iscae.projetdevoir.utils.DataStorage;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("transferService")
public class CreateTransferServiceService {

    private DataStorage dataStorage = DataStorage.getInstance();

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTransferService(
            @QueryParam("name") String name) {

        // Validate the information
        if (name == null || name.isEmpty()) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Name is required")
                    .build();
        }

        TransferService transferService = new TransferService(name);
        dataStorage.addTransferService(transferService);

        // Return success status
        return Response.ok().entity("Transfer created successfully").build();
    }
}

