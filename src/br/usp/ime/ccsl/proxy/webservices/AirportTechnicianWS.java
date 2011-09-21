package br.usp.ime.ccsl.proxy.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.usp.ime.ccsl.proxy.roles.AirportTechnician;

@WebService
public class AirportTechnicianWS {
	
	private AirportTechnician technician;
	
	public AirportTechnicianWS(int newTechnicianId) {
		technician = new AirportTechnician(newTechnicianId);
	}

	@WebMethod
	public void inspectAirplane(@WebParam int airplaneId){
		technician.inspectAirplane(airplaneId);
	}
	
	@WebMethod
	public boolean isInjured(){
		return technician.isInjured();
	}
	
	
}
