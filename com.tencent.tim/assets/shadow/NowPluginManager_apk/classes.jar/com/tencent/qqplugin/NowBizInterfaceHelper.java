package com.tencent.qqplugin;

import android.os.Bundle;
import android.util.Log;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.IHostCallback;
import com.tencent.qqinterface.NowBizInterface;
import com.tencent.util.e.a;

public class NowBizInterfaceHelper
{
  public static final String NOW_BIZ_INTERFACE_PATH = "com.tencent.mobileqq.intervideo.now.dynamic.NowBizInterfaceImpl";
  public static final String TAG = "NowBizHelper";
  private static NowBizInterface mNowBizInterface;
  
  static
  {
    try
    {
      mNowBizInterface = (NowBizInterface)Class.forName("com.tencent.mobileqq.intervideo.now.dynamic.NowBizInterfaceImpl").newInstance();
      return;
    }
    catch (Exception localException)
    {
      Log.i("NowBizHelper", "Class.forName(NOW_BIZ_INTERFACE_PATH) exception, e=" + localException.toString());
    }
  }
  
  public static void getRecordInfo(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    if (mNowBizInterface != null) {
      mNowBizInterface.getRecordInfo(paramBundle, paramCommonCallback);
    }
  }
  
  public static void onEnterRoom(Bundle paramBundle)
  {
    if (mNowBizInterface != null) {
      mNowBizInterface.onEnterRoom(paramBundle);
    }
  }
  
  public static void onFirstFrameShow(Bundle paramBundle)
  {
    if (mNowBizInterface != null) {
      mNowBizInterface.onFirstFrameShow(paramBundle);
    }
  }
  
  public static void onRoomActivityOnCreate(Bundle paramBundle)
  {
    if (mNowBizInterface != null) {
      mNowBizInterface.onRoomActivityOnCreate(paramBundle);
    }
  }
  
  public static void reportData(Bundle paramBundle)
  {
    if (mNowBizInterface != null) {}
    try
    {
      mNowBizInterface.reportData(paramBundle);
      return;
    }
    catch (NoSuchMethodError paramBundle)
    {
      a.a("NowBizHelper", "reportData, e=" + paramBundle.toString());
    }
  }
  
  public static void setHostCallback(IHostCallback paramIHostCallback)
  {
    if (mNowBizInterface != null) {
      mNowBizInterface.setHostCallback(paramIHostCallback);
    }
  }
  
  public static void shareToQQ(Bundle paramBundle)
  {
    if (mNowBizInterface != null) {
      mNowBizInterface.shareToQQ(paramBundle);
    }
  }
  
  public static void showBiuComponent(Bundle paramBundle)
  {
    if (mNowBizInterface != null) {
      mNowBizInterface.showBiuComponent(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.qqplugin.NowBizInterfaceHelper
 * JD-Core Version:    0.7.0.1
 */