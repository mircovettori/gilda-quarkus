package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.ConfigFrontendEntity;

@ApplicationScoped
public class ConfigFrontendRepository implements PanacheRepository<ConfigFrontendEntity> {

}
