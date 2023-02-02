package ca.gc.aafc.reportlabel.api.service;

import ca.gc.aafc.reportlabel.api.BaseIntegrationTest;
import ca.gc.aafc.reportlabel.api.ReportLabelModuleApiLauncher;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {BaseIntegrationTest.TestConfig.class, ReportLabelModuleApiLauncher.class })
public class FreemarkerReportGeneratorTest {

  @Inject
  private FreemarkerReportGenerator freemarkerReportGenerator;

  @Test
  public void testCsvGeneration() throws IOException {
    Writer writer = new StringWriter();
    freemarkerReportGenerator.generateReport("testCsv.flth",
            Map.of("headers", List.of("h1", "h2", "h3"), "data", List.of(List.of("1", "2", "3"),List.of("11", "22", "33"))),
            writer);
    assertEquals("h1,h2,h31,2,311,22,33", StringUtils.deleteWhitespace(writer.toString()));
  }

}
