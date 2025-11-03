package com.bituan.regexplain.model;

import java.util.List;
import java.util.Map;

public class Artifact {
    private String artifactId;
    private String name;
    private List<Map<String, Object>> parts; // come back to review that type

    public Artifact(String artifactId, String name, List<Map<String, Object>> parts) {
        this.artifactId = artifactId;
        this.name = name;
        this.parts = parts;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getParts() {
        return parts;
    }

    public void setParts(List<Map<String, Object>> parts) {
        this.parts = parts;
    }
}
