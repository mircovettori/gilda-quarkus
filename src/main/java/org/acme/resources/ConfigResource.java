package org.acme.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

    // consiglio di usare una batch size massima di 20.000
    @Path("/populate")
    @GET
    public void populateDb(@QueryParam("length") Integer length, @QueryParam("batchSize") Integer batchSize) {
        CompletableFuture.runAsync(() -> {
            int times = (int) Math.ceil(length.doubleValue() / batchSize);
            for (int i = 0; i < times; i++) {
                int start = i * batchSize;
                int stop = (i + 1) * batchSize;
                if(stop > length) {
                    stop = length;
                }
                System.out.println("Populating DB with " + start + " to " + stop);
                configFrontendService.populateDb(start, stop);
            }
            System.out.println("Populating DB end");
        });
    }

}
