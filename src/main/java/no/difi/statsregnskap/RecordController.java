package no.difi.statsregnskap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import no.difi.statsregnskap.Pair;

@RestController
public class RecordController {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public List<HashMap<String, String>> records() {
	    List<HashMap<String, String>> l = recordRepository.getAllRecords();

	    return formatRecords(l);
	}

    @RequestMapping(value = "/record/{year}", method = RequestMethod.GET)
    public List<HashMap<String, String>> recordByYear(@PathVariable("year") String year) {
        List<HashMap<String, String>> l = recordRepository.findByYear(year);

        return formatRecords(l);
    }

    // Parse and return.
    private List<HashMap<String, String>> formatRecords(List<HashMap<String, String>> l) {
        BigDecimal ytd = new BigDecimal("0.0"); // Year To Date
        // <Unique identifier, Period (month), Pair<amount (numeric(19,3))>>, accumulate YTD
        Table<String, Integer, Pair> tAmount = TreeBasedTable.create();
        // Add records to guava sorted table.
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).get("uniqueIdentifier") != null) {
                // Uniquely identifies record
                String unique = String.valueOf(l.get(i).get("uniqueIdentifier"));
                // Period, as month like 9
                Integer period = Integer.parseInt(String.valueOf(l.get(i).get("period")));
                String periodamount = String.valueOf(l.get(i).get("periodamount")).replace(',', '.');
                //System.out.println(String.valueOf(l.get(i).get("uniqueIdentifier")) + ", "+ String.valueOf(l.get(i).get("periodamount")));
                tAmount.put(unique, period, new Pair(new BigDecimal(periodamount)));
            }
        }
        
        // Traverse guava table and accumulate YTD.
        for (String item : tAmount.rowKeySet()) {
            //System.out.println("guava rowKeySet(): " + item);
            ytd = BigDecimal.ZERO;
            for (Entry<Integer, Pair> period : tAmount.row(item).entrySet()) {
                ytd = ytd.add(period.getValue().getAmount());
                period.getValue().setYTDamount(ytd);
                //System.out.println("period: " + period.getKey() + ", amount: " + period.getValue().getAmount() + ", YTD: " + period.getValue().getYTDamount());
            }
        }

        // Add YTD from guava table.
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).get("uniqueIdentifier") != null) {
                String unique = String.valueOf(l.get(i).get("uniqueIdentifier")); // Uniquely identifies record
                Integer period = Integer.parseInt(String.valueOf(l.get(i).get("period"))); // Period, as month like 9
                Pair p = tAmount.get(unique, period);
                l.get(i).put("ytdamount", p.getYTDamount().toString().replace('.', ','));
                //System.out.println("ytd: " + p.getYTDamount());
            }
            // Remove this element from the hashmap since it is not needed in the final output.
            l.get(i).remove("uniqueIdentifier");
        }
        
        System.out.println(l.getClass());
        System.out.println(l.get(1967).get("orgnr"));

        return l;
    }
}
