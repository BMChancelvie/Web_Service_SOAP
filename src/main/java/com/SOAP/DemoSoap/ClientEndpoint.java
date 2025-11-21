package com.SOAP.DemoSoap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.esmt.banque.ClientInfo;

@Endpoint
public class ClientEndpoint {

    @PayloadRoot(namespace = "http://esmt.banque", localPart = "getClientInfoRequest")
    @ResponsePayload
    public ClientInfo getClientInfo() {
        ClientInfo client = new ClientInfo();
        client.setNumeroTel(777777777L);
        client.setSolde(333333333L);
        return client;
    }
}