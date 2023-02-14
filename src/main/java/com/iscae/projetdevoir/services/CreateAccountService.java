package com.iscae.projetdevoir.services;

import com.iscae.projetdevoir.models.Account;
import com.iscae.projetdevoir.models.TransferService;
import com.iscae.projetdevoir.utils.DataStorage;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("account")
public class CreateAccountService {

    private DataStorage dataStorage = DataStorage.getInstance();

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(
            @QueryParam("transferService") String transferServiceName) {

        // Validate the information
        if (transferServiceName == null || transferServiceName.isEmpty()) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Transfer service is required")
                    .build();
        }

        TransferService transferService = dataStorage.getTransferService(transferServiceName);
        Account account  = new Account(transferService);
        dataStorage.addAccount(account);

        // Return success status
        return Response.ok().entity("Account created successfully, " + account.getAccountNumber()).build();
    }
}

