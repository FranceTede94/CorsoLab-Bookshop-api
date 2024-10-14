package it.corso.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ResponseManager {

 private ObjectMapper mapper; // è un oggetto che ci consente di leggere e scrivere un json  ObjectMapper mapper => mappa il json
 private int code;
 private String message;
 
 public ResponseManager(int code, String message) { // costruzione cotruttore classe
	 mapper = new ObjectMapper();
	 this.code = code;
	 this.message = message;
 }
	
 public ObjectNode getResponse() {  // ObjectNode si usa per strutturare un nodo json che popola il codice
	ObjectNode response = mapper.createObjectNode(); 
	response.put("code", this.code);
	response.put("message", this.message);
	return response;
 }
 

	
}
