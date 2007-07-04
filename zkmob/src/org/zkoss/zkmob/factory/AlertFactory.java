/* FormFactory.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue May 15 14:58:13     2007, Created by henrichen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkmob.factory;

import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Gauge;

import org.xml.sax.Attributes;
import org.zkoss.zkmob.UiManager;
import org.zkoss.zkmob.ZkComponent;
import org.zkoss.zkmob.ui.ZkAlert;

/**
 * A UiFactory that create an Alert Ui component.
 *
 * @author henrichen
 */
public class AlertFactory extends AbstractUiFactory {
	public AlertFactory(String name) {
		super(name);
	}
	
	public ZkComponent create(ZkComponent parent, String tag, Attributes attrs, String hostURL) {
		final String id = attrs.getValue("id"); //id
		final String title = attrs.getValue("tt"); //title
		final String text = attrs.getValue("tx"); //text
		final String typeStr = attrs.getValue("tp"); //type
		final String src = attrs.getValue("im");
		final ZkAlert alert = new ZkAlert(((ZkComponent)parent).getZkDesktop(), id, title, src, text, getAlertType(typeStr));
		
		final String timeoutStr = attrs.getValue("to"); //timeout
		if (timeoutStr != null) {
			int timeout = Integer.parseInt(timeoutStr);
			alert.setTimeout(timeout);
		}

		if ("t".equalsIgnoreCase(attrs.getValue("ic"))) { //indicator
			alert.setIndicator(new Gauge(null /*label*/, false/*interactive*/, 10/*maxValue*/, 0/*initialValue*/)); 
		}
		
		return alert;
	}

	private AlertType getAlertType(String type) {
		if ("al".equalsIgnoreCase(type)) return AlertType.ALARM;
		if ("cf".equalsIgnoreCase(type)) return AlertType.CONFIRMATION;
		if ("er".equalsIgnoreCase(type)) return AlertType.ERROR;
		if ("if".equalsIgnoreCase(type)) return AlertType.INFO;
		if ("wn".equalsIgnoreCase(type)) return AlertType.WARNING;
		
		return AlertType.INFO;
	}
}
