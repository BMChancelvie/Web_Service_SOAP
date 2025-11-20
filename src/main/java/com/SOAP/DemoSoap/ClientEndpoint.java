package com.SOAP.DemoSoap;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.esmt.banque.ClientResponse;
import com.esmt.banque.GetSoldeRequest;

@Endpoint
public class ClientEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ClientRepository clientRepository;

//	@Autowired
	public ClientEndpoint(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSoldeRequest")
	@ResponsePayload
	public ClientResponse getClient(@RequestPayload GetSoldeRequest request) {
		ClientResponse response = new ClientResponse();
		response.setClient(clientRepository.findClient(request.getTel()));

		return response;
	}

}
