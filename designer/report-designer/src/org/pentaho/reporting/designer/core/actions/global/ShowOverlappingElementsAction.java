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
 * Copyright (c) 2009 Pentaho Corporation.  All rights reserved.
 */

package org.pentaho.reporting.designer.core.actions.global;

import java.awt.event.ActionEvent;
import javax.swing.Action;

import org.pentaho.reporting.designer.core.actions.AbstractDesignerContextAction;
import org.pentaho.reporting.designer.core.actions.ActionMessages;
import org.pentaho.reporting.designer.core.actions.ToggleStateAction;
import org.pentaho.reporting.designer.core.settings.SettingsListener;
import org.pentaho.reporting.designer.core.settings.WorkspaceSettings;

/**
 * Todo: Document Me
 *
 * @author Thomas Morgner
 */
public final class ShowOverlappingElementsAction extends AbstractDesignerContextAction
    implements ToggleStateAction, SettingsListener
{
  public ShowOverlappingElementsAction()
  {
    putValue(Action.NAME, ActionMessages.getString("ShowOverlappingElementsAction.Text"));
    putValue(Action.SHORT_DESCRIPTION, ActionMessages.getString("ShowOverlappingElementsAction.Description"));
    putValue(Action.MNEMONIC_KEY, ActionMessages.getOptionalMnemonic("ShowOverlappingElementsAction.Mnemonic"));
    putValue(Action.ACCELERATOR_KEY, ActionMessages.getOptionalKeyStroke("ShowOverlappingElementsAction.Accelerator"));

    WorkspaceSettings.getInstance().addSettingsListener(this);
    settingsChanged();
  }

  public boolean isSelected()
  {
    return Boolean.TRUE.equals(getValue(Action.SELECTED_KEY));
  }

  public void setSelected(final boolean selected)
  {
    putValue(Action.SELECTED_KEY, selected);
  }

  public void settingsChanged()
  {
    putValue(Action.SELECTED_KEY, WorkspaceSettings.getInstance().isShowOverlappingElements());
  }

  /**
   * Invoked when an action occurs.
   */
  public void actionPerformed(final ActionEvent e)
  {
    final WorkspaceSettings applicationSettings = WorkspaceSettings.getInstance();
    applicationSettings.setShowOverlappingElements(!applicationSettings.isShowOverlappingElements());
  }
}