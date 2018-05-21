package no.difi.statsregnskap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<Team> team() {
        return teamRepository.findAll();
    }

    @RequestMapping(value = "/teams/{firstname}", method = RequestMethod.GET)
    public List<Team> teamByFirstname(@PathVariable("firstname") String firstname) {
        return teamRepository.findByFirstname(firstname);
    }
}
