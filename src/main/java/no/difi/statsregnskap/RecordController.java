package no.difi.statsregnskap;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@RequestMapping(value = "/record/{year}", method = RequestMethod.GET)
	public List<HashMap<String, Record>> recordByYear(@PathVariable("year") String year) {
	    List<HashMap<String, Record>> l = recordRepository.findByYear(year);
	    
        System.out.println(l.getClass());
	    System.out.println(l.get(1967).get("orgnr"));

	    return l;
	}

}
