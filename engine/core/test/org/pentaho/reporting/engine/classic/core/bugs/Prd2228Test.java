package org.pentaho.reporting.engine.classic.core.bugs;

import java.net.URL;

import junit.framework.TestCase;
import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.function.EventMonitorFunction;
import org.pentaho.reporting.engine.classic.core.testsupport.DebugReportRunner;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;

public class Prd2228Test extends TestCase
{
  public Prd2228Test()
  {
  }

  public Prd2228Test(final String s)
  {
    super(s);
  }

  protected void setUp() throws Exception
  {
    ClassicEngineBoot.getInstance().start();
  }

  public void testRunSample() throws ResourceException
  {
    final URL url = getClass().getResource("Prd-2228.prpt");
    assertNotNull(url);
    final ResourceManager resourceManager = new ResourceManager();
    resourceManager.registerDefaults();
    final Resource directly = resourceManager.createDirectly(url, MasterReport.class);
    final MasterReport report = (MasterReport) directly.getResource();
    report.addExpression(new EventMonitorFunction());

    DebugReportRunner.execGraphics2D(report);
  }
}