package com.bituan.regexplain.controller;

import com.bituan.regexplain.model.*;
import com.bituan.regexplain.service.RegExPlainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/explain")
    public ResponseEntity<A2AResponse> explainRegex (@RequestBody A2ARequest request) {
        String regexRequest = request.getParams().getMessage().getParts().get(0).getText();
        String responseText = regexplainService.generateResponse(regexRequest);

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
        result.setArtifacts(new ArrayList<>());
        result.setHistory(history);

        // response building contd
        response.setResult(result);


        return ResponseEntity.ok(response);
    }
}
