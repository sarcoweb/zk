/* StringItemFactory.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		May 15, 2007 3:25:44 PM, Created by henrichen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkmob.factory;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

import org.xml.sax.Attributes;
import org.zkoss.zkmob.ZkComponent;
import org.zkoss.zkmob.UiManager;
import org.zkoss.zkmob.ui.ZkDesktop;
import org.zkoss.zkmob.ui.ZkStringItem;

/**
 * @author henrichen
 *
 */
public class StringItemFactory extends AbstractUiFactory {

	public StringItemFactory(String name) {
		super(name);
	}
	
	public ZkComponent create(ZkComponent parent, String tag, Attributes attrs, String hostURL, String pathURL) {
		final String id = attrs.getValue("id"); //id
		final String label = attrs.getValue("lb"); //label
		final String text = attrs.getValue("tx"); //text
		final ZkDesktop zk = ((ZkComponent)parent).getZkDesktop();
		
		final ZkStringItem component = new ZkStringItem(zk, id, label, text);

		UiManager.applyItemProperties(parent, component, attrs);
		
		return component;
	}
}
