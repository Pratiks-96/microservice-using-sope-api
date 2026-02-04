package com.example.soapservice.endpoint;

import com.example.soapservice.model.AddRequest;
import com.example.soapservice.model.AddResponse;
import com.example.soapservice.service.CalculatorService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soapservice";

    private final CalculatorService calculatorService;

    public CalculatorEndpoint(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddRequest")
    @ResponsePayload
    public AddResponse add(@RequestPayload AddRequest request) {
        AddResponse response = new AddResponse();
        response.setResult(calculatorService.add(request.getA(), request.getB()));
        return response;
    }
}
