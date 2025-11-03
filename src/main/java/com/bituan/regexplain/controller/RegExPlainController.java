package com.bituan.regexplain.controller;

import com.bituan.regexplain.model.*;
import com.bituan.regexplain.service.RegExPlainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.*;

@RestController
public class RegExPlainController {
    private final RegExPlainService regexplainService;

    @Autowired
    RegExPlainController (RegExPlainService regexplainService) {
        this.regexplainService = regexplainService;
    }

    @GetMapping("/a2a/agent/regexplain/.well-known/agent.json")
    public ResponseEntity<AgentCard> getAgentCard () {
        AgentCard agentCard = new AgentCard();
        agentCard.setName("regexplain");
        agentCard.setDescription("An agent that provides a simple explanation of the type of string a regex pattern matches");
        agentCard.setUrl("regexplain-production.up.railway.app/api");
        agentCard.setProvider("Bituan", null);
        agentCard.setVersion("1.0");
        agentCard.setCapabilities(false, false, false);
        agentCard.setDefaultInputModes(List.of("text/plain"));
        agentCard.setDefaultOutputModes(List.of("application/json", "text/plain"));
        agentCard.setSkill("skill-001", "Explain Regex", "Provides a simple explanation of the type of string a regex pattern matches",
                List.of("text/plain"), List.of("text/plain"), List.of());

        return ResponseEntity.ok(agentCard);
    }

    @PostMapping("/a2a/agent/regexplain")
    public ResponseEntity<A2AResponse> explainRegex (@RequestBody A2ARequest request) {
        String regexRequest;
        String responseText;

        // return 403 if parameter is invalid
        try {
            regexRequest = request.getParams().getMessage().getParts().get(0).getText();
        } catch (Exception e) {
            CustomError error = new CustomError(-32603, "Invalid Parameter", Map.of("details", e.getMessage()));
            A2AResponse errorResponse = new A2AResponse(null, null,  error);
            return ResponseEntity.status(HttpStatusCode.valueOf(403)).body(errorResponse);
        }

        // return error 500 if call to service fails
        try {
            responseText = regexplainService.generateResponse(regexRequest);
        } catch (Exception e) {
            CustomError error = new CustomError(-32603, "Internal Error", Map.of("details", e.getMessage()));
            A2AResponse errorResponse = new A2AResponse(null, null,  error);
            return ResponseEntity.internalServerError().body(errorResponse);
        }

        // response building
        A2AResponse response = new A2AResponse();
        response.setId(request.getId());

        // response building -> result building
        Result result = new Result();
        result.setId(UUID.randomUUID().toString());
        result.setContextId(UUID.randomUUID().toString());
        result.setKind("task");

        // response building -> result building -> status building
        TaskStatus status = new TaskStatus();
        status.setState("completed");
        status.setTimestamp(Instant.now());

        // response building -> result building -> status building -> message building
        HistoryMessage message = new HistoryMessage();
        message.setRole("agent");
        message.setParts(List.of(new MessagePart("text", responseText, null)));
        message.setKind("message");

        // response building -> result building -> status building contd
        status.setMessage(message);

        // response building -> result building -> artifact building
        List<Artifact> artifacts = new ArrayList<>();
        Artifact artifact = new Artifact();
        artifact.setArtifactId(UUID.randomUUID().toString());
        artifact.setName("regexplainerResponse");
        artifact.setParts(List.of(new MessagePart("text", responseText, null)));
        artifacts.add(artifact);


        //response building -> result building -> history building
        List<MessagePart> messageParts = request.getParams().getMessage().getParts().get(1).getData();
        List<HistoryMessage> history = new ArrayList<>();

        for (MessagePart messagePart : messageParts) {
            HistoryMessage historyMessage = new HistoryMessage(request.getParams().getMessage().getRole(), List.of(messagePart),
                    UUID.randomUUID().toString(), UUID.randomUUID().toString());

            history.add(historyMessage);
        }
        HistoryMessage historyMessage = new HistoryMessage("agent", List.of(new MessagePart("text", responseText, null)),
                UUID.randomUUID().toString(), UUID.randomUUID().toString());
        history.add(historyMessage);

        //response building -> result building contd
        result.setStatus(status);
        result.setArtifacts(artifacts);
        result.setHistory(history);

        // response building contd
        response.setResult(result);

        return ResponseEntity.ok(response);
    }
}
