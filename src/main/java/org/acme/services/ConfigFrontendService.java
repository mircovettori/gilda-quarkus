package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.acme.entities.ConfigFrontendEntity;
import org.acme.repositories.ConfigFrontendRepository;

@ApplicationScoped
public class ConfigFrontendService {

    @Inject
    ConfigFrontendRepository configFrontendRepository;

    public List<ConfigFrontendEntity> getConfigs() {
        return configFrontendRepository.findAll().list();
    }

}
