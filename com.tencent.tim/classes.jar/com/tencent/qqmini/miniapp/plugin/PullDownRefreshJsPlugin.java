package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
public class PullDownRefreshJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_DISABLE_SROLL_BOUNCE = "disableScrollBounce";
  public static final String EVENT_START_PULLDOWN_REFRESH = "startPullDownRefresh";
  public static final String EVENT_STOP_PULLDOWN_REFRESH = "stopPullDownRefresh";
  
  @JsEvent({"startPullDownRefresh", "stopPullDownRefresh", "disableScrollBounce"})
  public void doInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PullDownRefreshJsPlugin
 * JD-Core Version:    0.7.0.1
 */