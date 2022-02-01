package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

class EmbeddedLivePlayerJsPlugin$1
  implements Action<IJsService>
{
  EmbeddedLivePlayerJsPlugin$1(EmbeddedLivePlayerJsPlugin paramEmbeddedLivePlayerJsPlugin) {}
  
  public IJsService perform(BaseRuntime paramBaseRuntime)
  {
    return paramBaseRuntime.getJsService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePlayerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */