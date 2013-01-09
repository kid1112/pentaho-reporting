/*
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2001 - 2009 Object Refinery Ltd, Pentaho Corporation and Contributors.  All rights reserved.
 */

package org.pentaho.reporting.classic.extensions.datasources.xquery;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.extensions.datasources.xquery.XQueryModule;
import org.pentaho.reporting.libraries.base.boot.PackageManager;
import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA. User: mimil Date: 21 déc. 2008 Time: 22:30:26 To change this template use File | Settings |
 * File Templates.
 */
public class XQueryModuleTest extends TestCase
{

  public void testModuleLoading()
  {
    final PackageManager manager = ClassicEngineBoot.getInstance().getPackageManager();
    manager.addModule(XQueryModule.class.getName());
    ClassicEngineBoot.getInstance().start();

    assertTrue("XQueryModule not loaded", manager.isModuleAvailable(XQueryModule.class.getName()));
  }
}
