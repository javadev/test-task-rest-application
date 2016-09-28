package com.github.javadev.rest;

import java.util.List;

import com.github.javadev.model.StringsParam;
import com.github.javadev.model.ResultResponse;
import com.github.javadev.service.StringGeneratorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/strings")
public class StringRestService {

    private StringGeneratorService service = new StringGeneratorService();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ResultResponse generateStrings(StringsParam stringsParam) {
        return service.generate(stringsParam);
    }    
}
