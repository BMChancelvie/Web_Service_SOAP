package com.SOAP.DemoSoap;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.esmt.banque.ClientInfo;

@Component
public class ClientRepository {

	private static final Map<Long, ClientInfo> Clients = new HashMap<>();

	@PostConstruct
	public void initData() {
		ClientInfo Client1 = new ClientInfo();
		Client1.setNumeroTel(777777777);
		Client1.setSolde(333333333);

		Clients.put(Client1.getNumeroTel(), Client1);
		
		ClientInfo Client2 = new ClientInfo();
		Client2.setNumeroTel(333333333);
		Client2.setSolde(777777777);

		Clients.put(Client2.getNumeroTel(), Client2);
		
		ClientInfo Client3 = new ClientInfo();
		Client3.setNumeroTel(111111111);
		Client3.setSolde(222222222);

		Clients.put(Client3.getNumeroTel(), Client3);

	}

	//@SuppressWarnings("unlikely-arg-type")
	public ClientInfo findClient(long numeroTel) {
		Assert.notNull(numeroTel, "The numeroTel's name must not be null");
		return Clients.get(numeroTel);
	}
}
