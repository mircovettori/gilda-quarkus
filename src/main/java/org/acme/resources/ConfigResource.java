package org.acme.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.acme.entities.ConfigFrontendEntity;
import org.acme.services.ConfigFrontendService;

@Path("/quarkus/versions")
public class ConfigResource {

    @Inject
    ConfigFrontendService configFrontendService;

    @GET
    public List<ConfigFrontendEntity> hello() {
        return configFrontendService.getConfigs();
    }
}
