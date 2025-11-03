package com.bituan.regexplain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentCard {
    private String name;
    private String description;
    private String url;
    private Map<String, String> provider;
    private String version;
    private Map<String, Boolean> capabilities;
    private List<String> defaultInputModes;
    private List<String> defaultOutputModes;
    private List<Map<String, Object>> skills;

    public AgentCard() {
        this.provider = new HashMap<>();
        this.capabilities = new HashMap<>();
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getProvider() {
        return provider;
    }

    public void setProvider(String organization, String url) {
        this.provider.put("organization", organization);
        this.provider.put("url", url);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Boolean> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(boolean streaming, boolean pushNotifications, boolean stateTransitionHistory) {
        this.capabilities.put("streaming", streaming);
        this.capabilities.put("pushNotifications", pushNotifications);
        this.capabilities.put("stateTransitionHistory", stateTransitionHistory);
    }

    public List<String> getDefaultInputModes() {
        return defaultInputModes;
    }

    public void setDefaultInputModes(List<String> defaultInputModes) {
        this.defaultInputModes = defaultInputModes;
    }

    public List<String> getDefaultOutputModes() {
        return defaultOutputModes;
    }

    public void setDefaultOutputModes(List<String> defaultOutputModes) {
        this.defaultOutputModes = defaultOutputModes;
    }

    public List<Map<String, Object>> getSkills() {
        return skills;
    }

    public void setSkill(String id, String name, String description, List<String> inputModes, List<String> outputModes, List<String> examples) {
        Map<String, Object> skill = new HashMap<>();
        skill.put("id", id);
        skill.put("name", name);
        skill.put("description", description);
        skill.put("inputModes", inputModes);
        skill.put("outputModes", outputModes);
        skill.put("examples", examples);
        this.skills.add(skill);
    }
}
