package com.tencent.pluginmanager.channel;

import android.content.Context;
import android.os.Bundle;
import com.tencent.pluginmanager.channel.log.Logger;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.CustomFlagInterface;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import java.util.concurrent.Future;

public class BaseAbilityHelper
{
  public static final String CUSTOM_FLAG_INTTERFACE = "com.tencent.mobileqq.intervideo.now.dynamic.CustomFlagInterfaceImpl";
  public static final String QQ_INTERFACE_PATH = "com.tencent.mobileqq.intervideo.now.dynamic.QQBaseAbilityInterfaceImpl";
  public static final String TAG = "QQBaseAbility";
  private static CustomFlagInterface sCustomFlagInterface;
  private static QQBaseAbilityInterface sQQBaseAbilityInterface;
  
  static
  {
    try
    {
      sQQBaseAbilityInterface = (QQBaseAbilityInterface)Class.forName("com.tencent.mobileqq.intervideo.now.dynamic.QQBaseAbilityInterfaceImpl").newInstance();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          sCustomFlagInterface = (CustomFlagInterface)Class.forName("com.tencent.mobileqq.intervideo.now.dynamic.CustomFlagInterfaceImpl").newInstance();
          return;
        }
        catch (Exception localException2)
        {
          Logger.e("QQBaseAbility", "Class.forName(CUSTOM_FLAG_INTTERFACE) exception, e=" + localException2.toString());
        }
        localException1 = localException1;
        Logger.e("QQBaseAbility", "Class.forName(QQ_INTERFACE_PATH) exception, e=" + localException1.toString());
      }
    }
  }
  
  public static void beaconReportData(Bundle paramBundle, int paramInt)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.beaconReportData(paramBundle, paramInt);
    }
  }
  
  public static void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.doCgiReq(paramBundle, paramCommonCallback);
    }
  }
  
  public static void download(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.download(paramBundle, new DownloadCallback()
      {
        public void onProgress(Bundle paramAnonymousBundle)
        {
          this.val$callback.onProgress(paramAnonymousBundle);
        }
        
        public void onResult(Bundle paramAnonymousBundle)
        {
          this.val$callback.onResult(paramAnonymousBundle);
        }
        
        public void onStart()
        {
          this.val$callback.onStart();
        }
      });
    }
  }
  
  public static Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (sQQBaseAbilityInterface != null) {
      return sQQBaseAbilityInterface.getA1(paramString1, paramString2, paramString3, paramString4);
    }
    return null;
  }
  
  public static Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    if (sQQBaseAbilityInterface != null) {
      return sQQBaseAbilityInterface.getAccessToken(paramString1, paramString2);
    }
    return null;
  }
  
  public static String getSelfUid()
  {
    if (sQQBaseAbilityInterface != null) {
      return sQQBaseAbilityInterface.getSelfUin();
    }
    return "";
  }
  
  public static Bundle getTicket()
  {
    if (sQQBaseAbilityInterface != null) {
      return sQQBaseAbilityInterface.getTickets();
    }
    return null;
  }
  
  public static boolean isCustomBeaconReport()
  {
    if (sCustomFlagInterface != null) {
      return sCustomFlagInterface.isCustomBeaconReport();
    }
    return false;
  }
  
  public static boolean isCustomCGIReq()
  {
    if (sCustomFlagInterface != null) {
      return sCustomFlagInterface.isCustomCGIReq();
    }
    return false;
  }
  
  public static boolean isCustomCS()
  {
    if (sCustomFlagInterface != null) {
      return sCustomFlagInterface.isCustomCS();
    }
    return false;
  }
  
  public static boolean isCustomDownload()
  {
    if (sCustomFlagInterface != null) {
      return sCustomFlagInterface.isCustomDownload();
    }
    return false;
  }
  
  public static boolean isCustomLog()
  {
    if (sCustomFlagInterface != null) {
      return sCustomFlagInterface.isCustomLog();
    }
    return false;
  }
  
  public static boolean isCustomReport()
  {
    if (sCustomFlagInterface != null) {
      return sCustomFlagInterface.isCustomReport();
    }
    return false;
  }
  
  public static boolean isCustomWebView()
  {
    if (sCustomFlagInterface != null) {
      return sCustomFlagInterface.isCustomWebview();
    }
    return false;
  }
  
  public static boolean isMobileNet()
  {
    if (sQQBaseAbilityInterface != null) {
      return sQQBaseAbilityInterface.isMobileNet();
    }
    return false;
  }
  
  public static void jumpAction(String paramString)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.jumpAction(paramString);
    }
  }
  
  public static void openWebView(Bundle paramBundle)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.openWebView(paramBundle);
    }
  }
  
  public static void printLog(Bundle paramBundle)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.printQLog(paramBundle);
    }
  }
  
  public static void reportData(Bundle paramBundle)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.reportData(paramBundle);
    }
  }
  
  public static String reqDns(String paramString)
  {
    if (sQQBaseAbilityInterface != null) {
      return sQQBaseAbilityInterface.reqDns(paramString);
    }
    return "";
  }
  
  public static void sendCsTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.sendSSOTask(paramBundle, new CommonCallback()
      {
        public void onResult(Bundle paramAnonymousBundle)
        {
          this.val$callback.onResult(paramAnonymousBundle);
        }
      });
    }
  }
  
  public static void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if (sQQBaseAbilityInterface != null) {
      sQQBaseAbilityInterface.showToast(paramContext, paramCharSequence, paramInt);
    }
  }
  
  public static boolean useIpDirectConnect()
  {
    if (sQQBaseAbilityInterface != null) {
      return sQQBaseAbilityInterface.useIpDirectConnect();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.pluginmanager.channel.BaseAbilityHelper
 * JD-Core Version:    0.7.0.1
 */