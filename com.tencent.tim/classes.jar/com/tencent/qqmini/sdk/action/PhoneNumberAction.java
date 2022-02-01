package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

public class PhoneNumberAction
  implements Action<Boolean>
{
  private PhoneNumberActionCallback callback;
  private RequestEvent req;
  
  public static PhoneNumberAction obtain(RequestEvent paramRequestEvent, PhoneNumberActionCallback paramPhoneNumberActionCallback)
  {
    PhoneNumberAction localPhoneNumberAction = new PhoneNumberAction();
    localPhoneNumberAction.callback = paramPhoneNumberActionCallback;
    localPhoneNumberAction.req = paramRequestEvent;
    return localPhoneNumberAction;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getJsPluginEngine();
    if ((paramBaseRuntime instanceof JsPluginEngine))
    {
      ((JsPluginEngine)paramBaseRuntime).showRequestPermissionDialog(this.req, this.callback);
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public static abstract interface PhoneNumberActionCallback
  {
    public abstract void onGetAuthDialogRet(boolean paramBoolean, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.PhoneNumberAction
 * JD-Core Version:    0.7.0.1
 */