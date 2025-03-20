package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONFIG_FRONTEND")
public class ConfigFrontendEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, name = "OID")
    private String oid;
    @Column(nullable = false, name = "NAME")
    private String name;
    @Column(nullable = false, name = "SCRIPT_NAME")
    private String scriptName;
    @Column(nullable = false, name = "EXPOSED_MODULE")
    private String exposedModule;
    @Column(nullable = false, name = "DISPLAY_NAME")
    private String displayName;
    @Column(nullable = false, name = "ROUTE_PATH")
    private String routePath;
    @Column(nullable = false, name = "NG_MODULE_NAME")
    private String ngModuleName;
    @Column(nullable = false, name = "VERSION_PRINCIPAL")
    private Integer versionPrincipal;
    @Column(nullable = false, name = "VERSION_MAJOR")
    private Integer versionMajor;
    @Column(name = "VERSION_MINOR")
    private Integer versionMinor;
    @Column(name = "CUSTOM_HOST")
    private String customHost;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getExposedModule() {
        return exposedModule;
    }

    public void setExposedModule(String exposedModule) {
        this.exposedModule = exposedModule;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRoutePath() {
        return routePath;
    }

    public void setRoutePath(String routePath) {
        this.routePath = routePath;
    }

    public String getNgModuleName() {
        return ngModuleName;
    }

    public void setNgModuleName(String ngModuleName) {
        this.ngModuleName = ngModuleName;
    }

    public Integer getVersionPrincipal() {
        return versionPrincipal;
    }

    public void setVersionPrincipal(Integer versionPrincipal) {
        this.versionPrincipal = versionPrincipal;
    }

    public Integer getVersionMajor() {
        return versionMajor;
    }

    public void setVersionMajor(Integer versionMajor) {
        this.versionMajor = versionMajor;
    }

    public Integer getVersionMinor() {
        return versionMinor;
    }

    public void setVersionMinor(Integer versionMinor) {
        this.versionMinor = versionMinor;
    }

    public String getCustomHost() {
        return customHost;
    }

    public void setCustomHost(String customHost) {
        this.customHost = customHost;
    }
}
