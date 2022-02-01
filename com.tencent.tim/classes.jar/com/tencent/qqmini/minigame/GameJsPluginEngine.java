package com.tencent.qqmini.minigame;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;

public class GameJsPluginEngine
  implements IJSEngine
{
  private JsPluginEngine mJsPluginEngine;
  private GameRuntime mRuntime;
  
  public boolean canHandleEvent(String paramString)
  {
    return true;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    if (this.mRuntime.getGameJsService(paramInt) != null) {
      return this.mRuntime.getGameJsService(paramInt).realJsRuntime;
    }
    return null;
  }
  
  public BaseRuntime getRuntime()
  {
    return this.mRuntime;
  }
  
  public void onCreate(Context paramContext, ITTEngine paramITTEngine)
  {
    this.mJsPluginEngine = new JsPluginEngine(paramContext);
    this.mJsPluginEngine.onCreate(this.mRuntime);
  }
  
  public void onDestroy()
  {
    if (this.mJsPluginEngine != null) {
      this.mJsPluginEngine.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.mJsPluginEngine != null) {
      this.mJsPluginEngine.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mJsPluginEngine != null) {
      this.mJsPluginEngine.onResume();
    }
  }
  
  public String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mJsPluginEngine != null)
    {
      GameJsService localGameJsService = this.mRuntime.getGameJsService(paramInt2);
      localObject1 = localObject2;
      if (localGameJsService != null) {
        localObject1 = this.mJsPluginEngine.handleNativeRequest(paramString1, paramString2, localGameJsService, paramInt1);
      }
    }
    paramString1 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString1 = "{}";
    }
    return paramString1;
  }
  
  public void setGameRuntime(GameRuntime paramGameRuntime)
  {
    this.mRuntime = paramGameRuntime;
  }
  
  public JsPluginEngine unwrap()
  {
    return this.mJsPluginEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */