package com.iscae.projetdevoir.services;

import com.iscae.projetdevoir.models.User;
import com.iscae.projetdevoir.utils.DataStorage;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("password")
public class ChangePasswordService {
    DataStorage dataStorage = DataStorage.getInstance();
    @POST
    @Path("change")
    @Produces(MediaType.APPLICATION_JSON)
    public Response changePassword(
            @QueryParam("username") String username,
            @QueryParam("oldPassword") String oldPassword,
            @QueryParam("newPassword") String newPassword
    ) {

        User user = dataStorage.getUser(username);

        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        if (
                (newPassword == null || newPassword.isEmpty()) ||
                        (oldPassword == null || oldPassword.isEmpty())
        ) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Please set both old and new password")
                    .build();
        } else {
            dataStorage.changePassword(user.getUsername(), newPassword);
            return Response.ok().entity("Password was updated successfully :)").build();
        }
    }
}
