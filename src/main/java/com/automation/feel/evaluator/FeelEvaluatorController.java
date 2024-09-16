package com.automation.feel.evaluator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/feel")
public class FeelEvaluatorController {

    private final FeelEvaluatorService feelEvaluatorService;

    public FeelEvaluatorController(FeelEvaluatorService feelEvaluatorService) {
        this.feelEvaluatorService = feelEvaluatorService;
    }

    @PostMapping("/evaluate")
    public ResponseEntity<Map<String, Object>> evaluateFeel(@RequestBody FeelExpressionRequest request) {
        try {
            Map<String, Object> variables = request.getVariables();
            Object result = feelEvaluatorService.evaluateFeelExpression(request.getExpression(), variables);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("result", result);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

}
