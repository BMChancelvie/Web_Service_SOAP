package com.SOAP.DemoSoap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClientEndpoint {

    @PayloadRoot(namespace = "http://esmt.banque", localPart = "getClientInfoRequest")
    @ResponsePayload
    public String getClientInfo() {
        return "<clientInfo xmlns=\"http://esmt.banque\">" +
               "    <numeroTel>777777777</numeroTel>" +
               "    <solde>333333333</solde>" +
               "</clientInfo>";
    }
}