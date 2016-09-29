package com.github.javadev;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.github.javadev.model.ResultResponse;
import com.github.javadev.model.StringsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/strings")
public class StringsEndpoint {

	private final GeneratorService stringGeneratorService;

	@Autowired
	public StringsEndpoint(GeneratorService stringGeneratorService) {
		this.stringGeneratorService = stringGeneratorService;
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public ResultResponse generateStrings(StringsParam stringsParam) {
		return stringGeneratorService.generate(stringsParam);
	}

}
