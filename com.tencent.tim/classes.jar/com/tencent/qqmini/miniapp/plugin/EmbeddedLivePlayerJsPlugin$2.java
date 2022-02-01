package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class EmbeddedLivePlayerJsPlugin$2
  implements Action<EmbeddedWidgetClientFactory>
{
  EmbeddedLivePlayerJsPlugin$2(EmbeddedLivePlayerJsPlugin paramEmbeddedLivePlayerJsPlugin) {}
  
  public EmbeddedWidgetClientFactory perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    return ((AppBrandPageContainer)paramBaseRuntime).getCurrentX5EmbeddedWidgetClientFactory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePlayerJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */