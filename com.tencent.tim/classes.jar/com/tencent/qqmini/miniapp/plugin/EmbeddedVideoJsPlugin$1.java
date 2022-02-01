package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

class EmbeddedVideoJsPlugin$1
  implements Action<IJsService>
{
  EmbeddedVideoJsPlugin$1(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin) {}
  
  public IJsService perform(BaseRuntime paramBaseRuntime)
  {
    return paramBaseRuntime.getJsService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */