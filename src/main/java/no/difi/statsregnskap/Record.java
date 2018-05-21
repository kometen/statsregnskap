package no.difi.statsregnskap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statsregnskap")
public class Record {
    
	// Eks. 16
    @Id
    @Column(name = "\"Fagdepartement_id\"", unique = false)
    private String fagdep;

	// Eks. 5309
    // left(Post_id, 4)
    private String kap;

	// Eks. 530929
    @Column(name = "\"Post_id\"", unique = false)
    private String statskonto;

	// Eks. 29
    // right(Post_id, 2)
    private String post;

	// Eks. 1985
    @Column(name = "\"Artskonto_id\"", unique = false)
    private String artskonto;

	// Eks. 915429785
    @Column(name = "\"Virksomhet_id\"", unique = false)
    private String orgnr;

	// Eks. Midtre Hålogaland politidistrikt
    @Column(name = "\"Regnskapsfører\"", unique = false)
    private String regnskapsfører;

	// Eks. 04
    @Column(name = "\"Fagdepartement_Virksomhet_id\"", unique = false)
    private String dep;
    
    // Eks. 2017-12-15
    // concat(left(201712, 4), '-', right(201712, 2), '-', 15)
    private String perioddate;

    // Eks. 201712
    @Column(name = "\"Periode\"", unique = false)
    private String periodid;

    // Eks. 2017
    @Column(name = "\"År\"", unique = false)
    private String year;

    // Eks. 12
    // right(Periode, 2)
    private String period;

    // Eks. ,000 (depending on comma or dot as decimal separator)
    // numeric(19, 3)
    @Column(name = "\"Beløp\"", unique = false)
    private String periodamount;
    
    public Record() {
    	this.fagdep = "-1";
    	this.kap = "-1";
    	this.statskonto = "-1";
    	this.post = "-1";
    	this.artskonto = "-1";
    	this.orgnr = "-1";
    	this.regnskapsfører = "-1";
    	this.dep = "-1";
    	this.perioddate = "-1";
    	this.periodid = "-1";
        this.year = "-1";
        this.period = "-1";
    	this.periodamount = ".000";
    }
    
    public Record(String fagdep, String kap, String statskonto, String post, String artskonto, String orgnr,
    		String regnskapsfører, String dep, String perioddate, String periodid, String year, String period, String periodamount) {
    	this.fagdep = fagdep;
    	this.kap = kap;
    	this.statskonto = statskonto;
    	this.post = post;
    	this.artskonto = artskonto;
    	this.orgnr = orgnr;
    	this.regnskapsfører = regnskapsfører;
    	this.dep = dep;
    	this.perioddate = perioddate;
    	this.periodid = periodid;
        this.year = year;
        this.period = period;
    	this.periodamount = periodamount;
    }
    
	public Record(String record) {
	}

	public String getFagdep() {
		return fagdep;
	}

	public String getKap() {
		return kap;
	}

	public String getStatskonto() {
		return statskonto;
	}

	public String getPost() {
		return post;
	}

	public String getArtskonto() {
		return artskonto;
	}

	public String getOrgnr() {
		return orgnr;
	}

	public String getRegnskapsfører() {
		return regnskapsfører;
	}

	public String getDep() {
		return dep;
	}

	public String getPerioddate() {
		return perioddate;
	}

	public String getPeriodid() {
		return periodid;
	}

	public String getYear() {
		return year;
	}

	public String getPeriod() {
		return period;
	}

	public String getPeriodamount() {
		return periodamount;
	}
    
}
