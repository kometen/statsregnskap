package no.difi.statsregnskap;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long> {
	
    // Convert result into json.
    // https://stackoverflow.com/a/48772277/319826
	@Query("select new map(fagdep as fagdep, substring(statskonto, 1, 4) as kap, statskonto as statskonto, substring(statskonto, 5, 2) as post, artskonto as artskonto, orgnr as orgnr, regnskapsfører as regnskapsfører, dep as dep, concat(substring(periodid, 1, 4), '-', substring(periodid, 5, 2), '-15') as perioddate, periodid as periodid, year as year, substring(periodid, 5, 2) as period, periodamount as periodamount, concat(fagdep, '|', statskonto, '|', artskonto, '|', orgnr, '|', regnskapsfører, '|', dep, '|', year) as uniqueIdentifier) from Record where year = ?1")
	List<HashMap<String, Record>> findByYear(String year);
	
}
