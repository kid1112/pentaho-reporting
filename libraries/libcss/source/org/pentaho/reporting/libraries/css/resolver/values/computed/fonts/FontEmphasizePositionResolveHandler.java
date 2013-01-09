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
 * Copyright (c) 2006 - 2009 Pentaho Corporation and Contributors.  All rights reserved.
 */

package org.pentaho.reporting.libraries.css.resolver.values.computed.fonts;

import org.pentaho.reporting.libraries.css.keys.font.FontEmphasizePosition;
import org.pentaho.reporting.libraries.css.resolver.values.computed.ConstantsResolveHandler;

/**
 * Creation-Date: 18.12.2005, 16:31:08
 *
 * @author Thomas Morgner
 */
public class FontEmphasizePositionResolveHandler extends ConstantsResolveHandler
{
  public FontEmphasizePositionResolveHandler()
  {
    addNormalizeValue(FontEmphasizePosition.AFTER);
    addNormalizeValue(FontEmphasizePosition.BEFORE);
    addValue(FontEmphasizePosition.ABOVE, FontEmphasizePosition.BEFORE);
    addValue(FontEmphasizePosition.BELOW, FontEmphasizePosition.AFTER);
    setFallback(FontEmphasizePosition.BEFORE);
  }
}
