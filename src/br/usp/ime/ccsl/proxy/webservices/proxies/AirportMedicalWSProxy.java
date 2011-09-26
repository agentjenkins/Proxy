package br.usp.ime.ccsl.proxy.webservices.proxies;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.usp.ime.ccsl.proxy.roles.AirportMedical;
import br.usp.ime.ccsl.proxy.utils.clients.SyncInvocationHandler;
import br.usp.ime.ccsl.proxy.webservices.logs.Logger4j;

@WebService
public class AirportMedicalWSProxy {

	
	private String currentWS;
	
	@WebMethod
	public void firstAid(int airplaneId, int injuredPersonnel){
		try {
			SyncInvocationHandler.invoke(new URL(currentWS), "firstAid", new String[] {""+airplaneId, ""+injuredPersonnel});
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void useService(String url){
		try {
			new URL(url);
			currentWS = url;
			Logger4j.log("PROXY: Changed current  Maintenance WS to "+url);
		} catch (MalformedURLException e) {
			Logger4j.log("ERROR: Tried to include a service using a malformed URL " + url);
			e.printStackTrace();
		}
	}

}