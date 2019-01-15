package it.akademija.vaisiai.servisas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.vaisiai.db.VaisiuRepozitorija;
import it.akademija.vaisiai.db.VaisiusDb;

@Service
public class VaisiuServisas {

	@Autowired
	private VaisiuRepozitorija vaisiuRepozitorija;
	
	@Transactional(readOnly = true)
	public List<VaisiusOfService> getVaisiai() {
		return vaisiuRepozitorija.findAll().stream().map((vaisiusDb) ->
				new VaisiusOfService(vaisiusDb.getPictureId(),
						vaisiusDb.getTitleVal(),
						vaisiusDb.getDescVal(),
						vaisiusDb.getLinkVal()
    			)).collect(Collectors.toList());
    }

	@Transactional
	public void createVaisius(VaisiusOfService vaisius) {
		VaisiusDb naujasVaisius = new VaisiusDb();
		
		naujasVaisius.setPictureId(vaisius.getPicture());
		naujasVaisius.setDescVal(vaisius.getDescription());
		naujasVaisius.setTitleVal(vaisius.getTitle());
		naujasVaisius.setLinkVal(vaisius.getLink());
		
		vaisiuRepozitorija.save(naujasVaisius);
	}
	
	public VaisiuRepozitorija getVaisiuRepozitorija() {
		return vaisiuRepozitorija;
	}

	public void setVaisiuRepozitorija(VaisiuRepozitorija vaisiuRepozitorija) {
		this.vaisiuRepozitorija = vaisiuRepozitorija;
	}
	
}
