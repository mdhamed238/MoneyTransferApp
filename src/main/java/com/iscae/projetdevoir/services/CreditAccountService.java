package com.iscae.projetdevoir.services;

import com.iscae.projetdevoir.controllers.NormalUserController;
import com.iscae.projetdevoir.models.Account;
import com.iscae.projetdevoir.models.NormalUser;
import com.iscae.projetdevoir.models.TransferService;
import com.iscae.projetdevoir.utils.DataStorage;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("account")
public class CreditAccountService {

    private DataStorage dataStorage = DataStorage.getInstance();
    NormalUserController userController = new NormalUserController();

    @POST
    @Path("credit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response creditAccount(
            @QueryParam("amount") String amount,
            @QueryParam("account") String accountNumber
            ) {

        // Validate the information
        if ((amount == null || amount.isEmpty()) || (accountNumber == null || accountNumber.isEmpty())) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Ib")
                    .build();
        }


        Account account = dataStorage.getAccount(accountNumber);
        userController.creditAccount(account, Double.parseDouble(amount));

        // Return success status
        return Response.ok().entity("Account credited successfully").build();
    }
}

