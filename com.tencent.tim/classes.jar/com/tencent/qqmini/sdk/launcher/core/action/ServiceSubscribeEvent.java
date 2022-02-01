package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class ServiceSubscribeEvent
  implements Action<String>
{
  private String event;
  private String jsonParams;
  private int sourceId;
  
  public static ServiceSubscribeEvent obtain(String paramString1, String paramString2, int paramInt)
  {
    ServiceSubscribeEvent localServiceSubscribeEvent = new ServiceSubscribeEvent();
    localServiceSubscribeEvent.event = paramString1;
    localServiceSubscribeEvent.jsonParams = paramString2;
    localServiceSubscribeEvent.sourceId = paramInt;
    return localServiceSubscribeEvent;
  }
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    QMLog.d("Action", "SubscribeEvent " + "eventName = " + this.event + "sourceWebViewId = " + this.sourceId);
    paramBaseRuntime = paramBaseRuntime.getJsService();
    if (paramBaseRuntime != null) {
      paramBaseRuntime.evaluateSubscribeJS(this.event, this.jsonParams, this.sourceId);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent
 * JD-Core Version:    0.7.0.1
 */