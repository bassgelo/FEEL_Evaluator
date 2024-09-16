package com.automation.feel.evaluator;

import java.util.Map;

public class FeelExpressionRequest {
    private String expression;
    private Map<String, Object> variables;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}

