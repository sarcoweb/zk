/* HtmlMacroComponent.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Apr 14 13:54:13     2006, Created by tomyeh@potix.com
}}IS_NOTE

Copyright (C) 2006 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package com.potix.zk.ui;

import java.util.Map;
import java.util.HashMap;

import com.potix.zk.ui.ext.PostCreate;
import com.potix.zk.ui.ext.DynamicPropertied;

/**
 * The implemetation of a macro component upon HTML.
 *
 * <p>Generally, a macro component is created automatically by ZK loader.
 * If a developer wants to create it manually, it has to instantiate from
 * the correct class, and then invoke {@link #postCreate}.
 *
 * @author <a href="mailto:tomyeh@potix.com">tomyeh@potix.com</a>
 */
public class HtmlMacroComponent extends HtmlBasedComponent
implements PostCreate, IdSpace, DynamicPropertied {
	private Map _props = new HashMap(7);

	public HtmlMacroComponent() {
		_props.put("includer", this);
	}

	//-- PostCreate --//
	/** Creates the child components after apply dynamic properties
	 * {@link #setDynamicProperty}.
	 *
	 * <p>If a macro component is created by ZK loader, this method is invoked
	 * automatically. Developers need to invoke this method only if they create
	 * a macro component manually.
	 */
	public void postCreate() {
		final Execution exec = Executions.getCurrent();
		if (exec == null)
			throw new IllegalStateException("No execution available.");
		exec.createComponents(getMillieu().getMacroURI(this), this, _props);
	}
	/** Detaches all child components and then recreate them by use of 
	 * {@link #postCreate}.
	 *
	 * <p>It is used if you have assigned new values to dynamical properties
	 * and want to re-create child components to reflect the new values.
	 * Note: it is convenient but the performance is better if you can manipulate
	 * only the child components that need to be changed.
	 * Refer to the Developer's Guide for details.
	 */
	public void recreate() {
		getChildren().clear();
		postCreate();
	}

	//Cloneable//
	public Object clone() {
		final HtmlMacroComponent clone = (HtmlMacroComponent)super.clone();
		clone._props = new HashMap(clone._props);
		return clone;
	}

	//-- DynamicPropertied --//
	public boolean hasDynamicProperty(String name) {
		return _props.containsKey(name);
	}
	public Object getDynamicProperty(String name) {
		return _props.get(name);
	}
	public void setDynamicProperty(String name, Object value)
	throws WrongValueException {
		_props.put(name, value);
	}
}
