package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.DetectionMode;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class DetectionPolicy
{
  private static final String TAG = "DetectionPolicy";
  @DetectionMode
  private static int sCurrentMode = 0;
  private static DefaultPolicy sDefaultPolicy = new DefaultPolicy();
  private static IDetectionPolicy sDetectionImpl = sDefaultPolicy;
  
  public static void addBlacklist(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Log.i("DetectionPolicy", "addBlacklist: activity = " + paramActivity);
      if (sCurrentMode != 1) {
        Log.e("DetectionPolicy", "addBlacklist: currentMode = " + sCurrentMode + " is not BLACKLIST");
      }
    }
    BlacklistPolicyHolder.sBlacklistPolicy.addBlacklist(paramActivity);
  }
  
  public static void addWhitelist(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Log.i("DetectionPolicy", "addWhitelist: activity = " + paramActivity);
      if (sCurrentMode != 2) {
        Log.e("DetectionPolicy", "addBlacklist: currentMode = " + sCurrentMode + " is not WHITELIST");
      }
    }
    WhitelistPolicyHolder.sWhitelistPolicy.addWhitelist(paramActivity);
  }
  
  public static boolean isAbleToDetect(Activity paramActivity)
  {
    return sDetectionImpl.isAbleToDetect(paramActivity);
  }
  
  public static void setDetectionMode(@DetectionMode int paramInt)
  {
    switch (paramInt)
    {
    default: 
      sCurrentMode = 0;
      sDetectionImpl = sDefaultPolicy;
      return;
    case 1: 
      sCurrentMode = 1;
      sDetectionImpl = BlacklistPolicyHolder.sBlacklistPolicy;
      return;
    }
    sCurrentMode = 2;
    sDetectionImpl = WhitelistPolicyHolder.sWhitelistPolicy;
  }
  
  static class BlacklistPolicyHolder
  {
    private static BlacklistPolicy sBlacklistPolicy = new BlacklistPolicy();
  }
  
  static class WhitelistPolicyHolder
  {
    private static WhitelistPolicy sWhitelistPolicy = new WhitelistPolicy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.DetectionPolicy
 * JD-Core Version:    0.7.0.1
 */