package com.automation.feel.evaluator;
import org.camunda.feel.FeelEngine;
import org.camunda.feel.impl.SpiServiceLoader;
import org.camunda.feel.impl.interpreter.ObjectContext;
import org.springframework.stereotype.Service;
import scala.util.Either;

import java.util.Map;

@Service
public class FeelEvaluatorService {

    private final FeelEngine feelEngine;

    public FeelEvaluatorService() {
        // Ensure correct configuration
        this.feelEngine = new FeelEngine.Builder()
                .valueMapper(SpiServiceLoader.loadValueMapper())
                .functionProvider(SpiServiceLoader.loadFunctionProvider())
                .enableExternalFunctions(true)
                .build();
    }

    public Object evaluateFeelExpression(String expression, Map<String, Object> variables) throws Exception {
        ObjectContext context = new ObjectContext(variables);

        Either<FeelEngine.Failure, Object> result = feelEngine.evalExpression(expression, context);

        if (result.isRight()) {
            return result.right().get();
        } else {
            throw new RuntimeException(result.left().get().message());
        }
    }
}
