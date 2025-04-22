package org.acme.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.List;
import org.acme.entities.ConfigFrontendEntity;
import org.acme.services.ConfigFrontendService;

@Path("/quarkus/versions")
public class ConfigResource {

    @Inject
    ConfigFrontendService configFrontendService;

    @GET
    public List<ConfigFrontendEntity> getConfigs() {
        return configFrontendService.getConfigs();
    }

    @POST
    public ConfigFrontendEntity createConfig(ConfigFrontendEntity config) {
        return configFrontendService.createConfig(config);
    }

    @DELETE
    public void deleteConfigs(List<String> oids) {
        configFrontendService.deleteConfigs(oids);
    }

}
