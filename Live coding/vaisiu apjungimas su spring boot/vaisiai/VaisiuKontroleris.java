package it.akademija.vaisiai;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.vaisiai.servisas.VaisiuServisas;
import it.akademija.vaisiai.servisas.VaisiusOfService;

@RestController
public class VaisiuKontroleris {
    
	@Autowired
	private VaisiuServisas vaisiuServisas;
	
    @RequestMapping(path = "/vaisiai", method = RequestMethod.GET)
    public List<Vaisius> getVaisiai() {
        return vaisiuServisas.getVaisiai().stream().map(
        		(vaisiusOfService) -> 
        		  new Vaisius(vaisiusOfService.getPicture(),
        				  vaisiusOfService.getTitle(),
        				  vaisiusOfService.getDescription(),
        				  vaisiusOfService.getLink())
        		).collect(Collectors.toList());
    }
    
    @RequestMapping(path = "/vaisius", method = RequestMethod.PUT)
    public String idetiNaujaVaisiu(@RequestBody Vaisius vaisius) {
    	vaisiuServisas.createVaisius(new VaisiusOfService(
    			vaisius.getPaveiksliukas(),
    			vaisius.getPavadinimas(),
    			vaisius.getAprasymas(),
    			vaisius.getNuoroda()
    			));
    	return "Naujas vaisius idetas";
    }

	public VaisiuServisas getVaisiuServisas() {
		return vaisiuServisas;
	}

	public void setVaisiuServisas(VaisiuServisas vaisiuServisas) {
		this.vaisiuServisas = vaisiuServisas;
	}

}
