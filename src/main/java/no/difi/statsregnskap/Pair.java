package no.difi.statsregnskap;

import java.math.BigDecimal;

public class Pair {
    
    private BigDecimal periodamount;
    private BigDecimal YTDAmount;


    public Pair(BigDecimal periodamount) {
        this.periodamount = periodamount;
    }

    public BigDecimal getYTDamount() {
        return YTDAmount;
    }

    public void setYTDamount(BigDecimal YTDamount) {
        this.YTDAmount = YTDamount;
    }
    public BigDecimal getPeriodamount() {
        return periodamount;
    }

}
