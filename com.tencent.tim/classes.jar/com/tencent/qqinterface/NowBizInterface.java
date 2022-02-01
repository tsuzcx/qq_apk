package com.tencent.qqinterface;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import java.util.concurrent.ExecutorService;

public abstract interface NowBizInterface
{
  public abstract void doActionResult(long paramLong, String paramString);
  
  public abstract Bitmap getCoverImg(String paramString);
  
  public abstract ExecutorService getFixedThreadPool(int paramInt);
  
  public abstract void getRecordInfo(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback);
  
  public abstract boolean isNowLivePushEnable();
  
  public abstract void notifyCoreAction(Bundle paramBundle);
  
  public abstract void onEnterRoom(Bundle paramBundle);
  
  public abstract void onFirstFrameShow(Bundle paramBundle);
  
  public abstract void onLiveOverIsInstalled(boolean paramBoolean);
  
  public abstract void onLoginExpired(int paramInt);
  
  public abstract void onNoLogin();
  
  public abstract void onPluginActivityLifecycleEvent(Bundle paramBundle);
  
  public abstract void onRoomActivityOnCreate(Bundle paramBundle);
  
  public abstract void openLiveHall();
  
  public abstract void openNowLivePushSetting(CommonCallback<Bundle> paramCommonCallback);
  
  public abstract void openPayPage(Bundle paramBundle, CommonCallback paramCommonCallback);
  
  public abstract void openPhoneAuthPage();
  
  public abstract void openWxMiniProgram(String paramString);
  
  public abstract void queryPhoneAuthState();
  
  public abstract void reportData(Bundle paramBundle);
  
  public abstract void reportWelfareTask(String paramString1, String paramString2);
  
  public abstract void setBizIntent(Intent paramIntent);
  
  public abstract void setHostCallback(IHostCallback paramIHostCallback);
  
  public abstract void share(Bundle paramBundle);
  
  public abstract void shareToQQ(Bundle paramBundle);
  
  public abstract void showBiuComponent(Bundle paramBundle);
  
  public static abstract interface Constants
  {
    public static final String PATH = "path";
    public static final String URL = "url";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqinterface.NowBizInterface
 * JD-Core Version:    0.7.0.1
 */