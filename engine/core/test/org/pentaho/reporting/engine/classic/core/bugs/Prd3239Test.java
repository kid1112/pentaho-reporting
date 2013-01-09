package org.pentaho.reporting.engine.classic.core.bugs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;
import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.ReportHeader;
import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.pentaho.reporting.engine.classic.core.modules.output.table.xml.XmlTableReportUtil;
import org.pentaho.reporting.engine.classic.core.testsupport.DebugReportRunner;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;

public class Prd3239Test extends TestCase
{
  public Prd3239Test()
  {
  }

  public Prd3239Test(final String name)
  {
    super(name);
  }

  protected void setUp() throws Exception
  {
    ClassicEngineBoot.getInstance().start();
  }

  public void testReport() throws ResourceException
  {
    final URL url = getClass().getResource("Prd-3239.prpt");
    assertNotNull(url);
    final ResourceManager resourceManager = new ResourceManager();
    resourceManager.registerDefaults();
    final Resource directly = resourceManager.createDirectly(url, MasterReport.class);
    final MasterReport report = (MasterReport) directly.getResource();
    final ReportHeader rh = report.getReportHeader();
//    rh.removeSubreport(rh.getSubReport(1));
    rh.removeSubreport(rh.getSubReport(1));
    rh.removeSubreport(rh.getSubReport(1));
    rh.removeSubreport(rh.getSubReport(1));
    rh.removeSubreport(rh.getSubReport(1));
    DebugReportRunner.execGraphics2D(report);

  }

  public void testFullReport() throws ResourceException
  {
    final URL url = getClass().getResource("Prd-3239.prpt");
    assertNotNull(url);
    final ResourceManager resourceManager = new ResourceManager();
    resourceManager.registerDefaults();
    final Resource directly = resourceManager.createDirectly(url, MasterReport.class);
    final MasterReport report = (MasterReport) directly.getResource();

    DebugReportRunner.execGraphics2D(report);
  }

  public void testFlowPageReport() throws ResourceException, IOException, ReportProcessingException
  {
    final URL url = getClass().getResource("Prd-3239.prpt");
    assertNotNull(url);
    final ResourceManager resourceManager = new ResourceManager();
    resourceManager.registerDefaults();
    final Resource directly = resourceManager.createDirectly(url, MasterReport.class);
    final MasterReport report = (MasterReport) directly.getResource();

    final ByteArrayOutputStream bout = new ByteArrayOutputStream();
    XmlTableReportUtil.createFlowXML(report, bout);
  }
}
