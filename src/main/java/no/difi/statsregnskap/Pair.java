package no.difi.statsregnskap;

import java.math.BigDecimal;

public class Pair {
    
    private BigDecimal amount;
    private BigDecimal YTDAmount;


    public Pair(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getYTDamount() {
        return YTDAmount;
    }

    public void setYTDamount(BigDecimal YTDamount) {
        this.YTDAmount = YTDamount;
    }
    public BigDecimal getAmount() {
        return amount;
    }

}
