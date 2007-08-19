/* ChoiceGroupFactory.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		May 15, 2007 3:29:57 PM, Created by henrichen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkmob.factory;

import javax.microedition.lcdui.Form;

import org.xml.sax.Attributes;
import org.zkoss.zkmob.ZkComponent;
import org.zkoss.zkmob.UiManager;
import org.zkoss.zkmob.ui.ZkDesktop;
import org.zkoss.zkmob.ui.ZkChoiceGroup;

/**
 * An UiFactory that create a ChoiceGroupFactory Ui component.
 * @author henrichen
 *
 */
public class ChoiceGroupFactory extends AbstractUiFactory {

	public ChoiceGroupFactory(String name) {
		super(name);
	}
	
	public ZkComponent create(ZkComponent parent, String tag, Attributes attrs, String hostURL, String pathURL) {
		final String id = attrs.getValue("id"); //id
		final String label = attrs.getValue("lb"); //label
		final String choiceTypeStr = attrs.getValue("tp"); //choiceType
		final String onSelectStr = attrs.getValue("os"); //onSelect
		final int choiceType = Integer.parseInt(choiceTypeStr);
		final ZkDesktop zk = ((ZkComponent)parent).getZkDesktop();
		final ZkChoiceGroup component = new ZkChoiceGroup(zk, id, label, choiceType,
				onSelectStr == null ? null : new Boolean("t".equals(onSelectStr)));

		UiManager.applyItemProperties(parent, component, attrs);
		
		return component;
	}
}
