/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.kubernetes.internal.resources;

import dev.galasa.kubernetes.IConfigMap;
import dev.galasa.kubernetes.KubernetesManagerException;
import dev.galasa.kubernetes.internal.KubernetesNamespaceImpl;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.util.Yaml;

/**
 * ConfigMap implementation
 * 
 * @author Michael Baylis
 *
 */
public class ConfigMapImpl implements IConfigMap {
    
    private final V1ConfigMap configMap;

    public ConfigMapImpl(KubernetesNamespaceImpl namespace, V1ConfigMap configMap) {
        this.configMap = configMap;
    }

    @Override
    public String getName() {
        return configMap.getMetadata().getName();
    }

    @Override
    public TYPE getType() {
        return TYPE.ConfigMap;
    }

    @Override
    public String getYaml() {
        return Yaml.dump(this.configMap);
    }

    @Override
    public void refresh() throws KubernetesManagerException {
       throw new UnsupportedOperationException("Not developed yet"); //TODO
    }

}
