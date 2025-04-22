package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import jakarta.transaction.Transactional;
import org.acme.entities.ConfigFrontendEntity;
import org.acme.repositories.ConfigFrontendRepository;

@ApplicationScoped
public class ConfigFrontendService {

    @Inject
    ConfigFrontendRepository configFrontendRepository;

    public List<ConfigFrontendEntity> getConfigs() {
        return configFrontendRepository.findAll().list();
    }

    @Transactional
    public ConfigFrontendEntity createConfig(ConfigFrontendEntity config) {
        configFrontendRepository.persist(config);
        return config;
    }

    public void deleteConfigs(List<String> oids) {
        configFrontendRepository.delete("oid in ?1", oids);
    }

    @Transactional
    public void populateDb(int start, int stop) {
        Stream<ConfigFrontendEntity> configStream =
                IntStream.range(start, stop)
                        .mapToObj(index -> {
                            ConfigFrontendEntity configFrontendEntity = new ConfigFrontendEntity();
                            configFrontendEntity.setName("name" + index);
                            configFrontendEntity.setScriptName("scriptName" + index);
                            configFrontendEntity.setExposedModule("exposedModule" + index);
                            configFrontendEntity.setDisplayName("displayName" + index);
                            configFrontendEntity.setRoutePath("routePath" + index);
                            configFrontendEntity.setNgModuleName("ngModuleName" + index);
                            configFrontendEntity.setVersionPrincipal(index);
                            configFrontendEntity.setVersionMajor(index);
                            configFrontendEntity.setVersionMinor(index);
                            return configFrontendEntity;
                        });
        configFrontendRepository.persist(configStream);
    }
}
