package com.cw.Util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PrivilegeCheck implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3889980026381691715L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String username = (String) ActionContext.getContext().getSession().get("username");
		if(username==null||username.equals("")){
			((ActionSupport)invocation.getAction()).addActionMessage("ÇëÏÈµÇÂ¼");
			return "LOGIN_FAILED";
		}else{
		String result = invocation.invoke();
		
		return result;
		}
	}

}
