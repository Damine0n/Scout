package com.scout.project.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manh.scope.services.security.SecurityWebServiceSoap11BindingStub;


@SpringBootApplication
public class ScoutApplication {
	
	public ScoutApplication(){
		super();
		//setRegisterErrorPageFilter(false);
	}

	public static void main(String[] args) {
		SpringApplication.run(ScoutApplication.class, args);
		try {
			
//			SecurityWebServiceLocator myService_ServiceLocator = new SecurityWebServiceLocator();
//			SecurityWebServicePortType webservice = myService_ServiceLocator.getMyService_PortType();
//			http://fd-dcwmos16-qa.floordecor.com:6500/ws/services/SecurityWebService?wsdl
//			SecurityWebServiceSoap11BindingStub stub =  new SecurityWebServiceSoap11BindingStub(new java.net.URL("http://fd-dcwmos16-qa.floordecor.com:6500/ws/services/SecurityWebService.SecurityWebServiceHttpSoap11Endpoint/"), null);
			SecurityWebServiceSoap11BindingStub stub =  new SecurityWebServiceSoap11BindingStub(new java.net.URL("http://fd-dcwmos16-qa.floordecor.com:6500/ws/services/SecurityWebService?wsdl"), null);			
			//SecurityWebServiceSoap11BindingStub stub =  new SecurityWebServiceSoap11BindingStub(null);
			String authToken = stub.getAuthToken("WMCONFIG", "config");
			System.out.println("Token: "+authToken);
			System.out.println(stub.signIn(""+"WMCONFIG", "config", null, null, null));
			stub.signOut(authToken);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
