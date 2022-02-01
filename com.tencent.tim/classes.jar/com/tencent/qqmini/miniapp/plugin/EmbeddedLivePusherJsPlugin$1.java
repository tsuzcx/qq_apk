package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

class EmbeddedLivePusherJsPlugin$1
  implements Action<IJsService>
{
  EmbeddedLivePusherJsPlugin$1(EmbeddedLivePusherJsPlugin paramEmbeddedLivePusherJsPlugin) {}
  
  public IJsService perform(BaseRuntime paramBaseRuntime)
  {
    return paramBaseRuntime.getJsService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */