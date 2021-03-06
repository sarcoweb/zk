/* CombboxListModelConverter.java

	Purpose:
		
	Description:
		
	History:
		2012/3/8 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zkplus.databind;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Selectbox;

/**
 * The {@link TypeConverter} implementation for converting collection to ListModel of a grid
 * @author dennis
 * @since 6.0.1
 */
public class SelectboxListModelConverter extends ListModelConverter{

	private static final long serialVersionUID = 1L;

	
	protected ListModel<?> getComponentModel(Component comp){
		return ((Selectbox)comp).getModel();
	}
}
