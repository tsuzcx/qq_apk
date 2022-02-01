package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.sdk.ITTEngine.OnGetTraceRecordCallback;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import com.tencent.mobileqq.triton.sdk.debug.JankTraceLevel;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import java.util.Map;

public class GameEngineWrapper
  implements ITTEngine
{
  private ITTEngine baseEngine;
  
  public void addFPSCallback(FPSCallback paramFPSCallback)
  {
    if (this.baseEngine != null) {
      this.baseEngine.addFPSCallback(paramFPSCallback);
    }
  }
  
  public void addGameLifeCycle(GameLifecycle paramGameLifecycle)
  {
    if (this.baseEngine != null) {
      this.baseEngine.addGameLifeCycle(paramGameLifecycle);
    }
  }
  
  public View createGameView(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (this.baseEngine != null) {
      return this.baseEngine.createGameView(paramActivity, paramInt1, paramInt2);
    }
    return null;
  }
  
  public IAudioNativeManager getAudioNativeManager()
  {
    if (this.baseEngine == null) {
      return null;
    }
    return this.baseEngine.getAudioNativeManager();
  }
  
  public long getCurrentDrawCount()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getCurrentDrawCount();
    }
    return 0L;
  }
  
  public IGameLauncher getGameLauncher()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getGameLauncher();
    }
    return null;
  }
  
  public IJSEngine getJsEngine()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getJsEngine();
    }
    return null;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getJsRuntime(paramInt);
    }
    return null;
  }
  
  public long getLastBlackTime()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getLastBlackTime();
    }
    return -1L;
  }
  
  public String getLastClicks()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getLastClicks();
    }
    return null;
  }
  
  public ITNativeBufferPool getNativeBufferPool()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getNativeBufferPool();
    }
    return null;
  }
  
  public boolean getOptionalSoLoadStatus(String paramString)
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getOptionalSoLoadStatus(paramString);
    }
    return false;
  }
  
  public Map<String, String> getResPathCache()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getResPathCache();
    }
    return null;
  }
  
  public void getScreenShot(ScreenShotCallback paramScreenShotCallback)
  {
    if (this.baseEngine != null) {
      this.baseEngine.getScreenShot(paramScreenShotCallback);
    }
  }
  
  public int getTargetFPS()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getTargetFPS();
    }
    return 0;
  }
  
  public void getTraceRecord(@NonNull ITTEngine.OnGetTraceRecordCallback paramOnGetTraceRecordCallback)
  {
    if (this.baseEngine != null) {
      this.baseEngine.getTraceRecord(paramOnGetTraceRecordCallback);
    }
  }
  
  public void handleFocusGain()
  {
    if (this.baseEngine != null) {
      this.baseEngine.handleFocusGain();
    }
  }
  
  public void handleFocusLoss()
  {
    if (this.baseEngine != null) {
      this.baseEngine.handleFocusLoss();
    }
  }
  
  public void onCreate(Activity paramActivity)
  {
    if (this.baseEngine != null) {
      this.baseEngine.onCreate(paramActivity);
    }
  }
  
  public void onDestroy()
  {
    if (this.baseEngine != null) {
      this.baseEngine.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.baseEngine != null) {
      this.baseEngine.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.baseEngine != null) {
      this.baseEngine.onResume();
    }
  }
  
  public void removeFPSCallback(FPSCallback paramFPSCallback)
  {
    if (this.baseEngine != null) {
      this.baseEngine.removeFPSCallback(paramFPSCallback);
    }
  }
  
  public void setBaseEngine(ITTEngine paramITTEngine)
  {
    this.baseEngine = paramITTEngine;
  }
  
  public void setEnableCodeCache(boolean paramBoolean)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setEnableCodeCache(paramBoolean);
    }
  }
  
  public void setEngineListener(ITTEngine.IListener paramIListener)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setEngineListener(paramIListener);
    }
  }
  
  public void setJankTraceLevel(JankTraceLevel paramJankTraceLevel)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setJankTraceLevel(paramJankTraceLevel);
    }
  }
  
  public void setTargetFPS(int paramInt)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setTargetFPS(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameEngineWrapper
 * JD-Core Version:    0.7.0.1
 */