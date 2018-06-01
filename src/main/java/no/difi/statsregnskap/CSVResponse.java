// http://zetcode.com/articles/springbootcsv/

package no.difi.statsregnskap;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

public class CSVResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVResponse.class);

    public static void writeRecords(PrintWriter writer, List<Record> records) {

        try {
            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();

            mappingStrategy.setType(Record.class);
            mappingStrategy.generateHeader();

            String[] columns = new String[]{"FagDep", "Kap", "Statskonto", "Post", "Artskonto", "Orgnr", "Regnskabsfører", "Dep", "PeriodDate", "PeriodId", "Year", "Period", "PeriodAmount", "YTDAmount"};
            mappingStrategy.setColumnMapping(columns);

            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mappingStrategy)
                    .withSeparator(';')
                    .build();

            beanToCsv.write(records);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }
}
