package com.tencent.biz.pubaccount.util;

import adxc;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kbp;
import org.json.JSONObject;

public class AchillesFragmentUtils
{
  private static InstallBroadcastReceiver a;
  private static WeakReference<WebViewPlugin.a> cF;
  private static String mCallback;
  
  public static void a(String paramString1, String paramString2, String paramString3, AchillesParams paramAchillesParams)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAchillesParams != null) {}
    try
    {
      localJSONObject.put(paramAchillesParams.getPackageName(), paramAchillesParams.toString());
      label27:
      kbp.a(null, "", "0X8009ECD", "0X8009ECD", 0, 0, paramString1, paramString2, paramString3, localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramAchillesParams)
    {
      break label27;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, WebViewPlugin.a parama)
  {
    boolean bool3 = false;
    bool1 = false;
    bool2 = bool3;
    try
    {
      mCallback = paramString1;
      bool2 = bool3;
      paramString1 = Achilles.a(paramString2);
      bool2 = bool3;
      QLog.d("AchillesFragmentUtils", 1, "[installIfDownloaded] downloadInfo: " + paramString1);
      if (paramString1 != null)
      {
        bool2 = bool3;
        bool1 = adxc.c(paramString1);
      }
      bool2 = bool1;
      if (a == null)
      {
        bool2 = bool1;
        paramString1 = new IntentFilter();
        bool2 = bool1;
        paramString1.addAction("android.intent.action.PACKAGE_ADDED");
        bool2 = bool1;
        paramString1.addAction("android.intent.action.PACKAGE_INSTALL");
        bool2 = bool1;
        paramString1.addAction("android.intent.action.UNINSTALL_PACKAGE");
        bool2 = bool1;
        paramString1.addDataScheme("package");
        bool2 = bool1;
        a = new InstallBroadcastReceiver();
        bool2 = bool1;
        BaseApplication.getContext().registerReceiver(a, paramString1);
      }
      bool2 = bool1;
      cF = new WeakReference(parama);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    QLog.i("AchillesFragmentUtils", 1, "installFile:" + paramString2 + " installSuccess:" + bool1);
    if (bool1) {}
    for (paramString1 = "1";; paramString1 = "0")
    {
      a("install", paramString1, paramString2, null);
      return bool1;
    }
  }
  
  public static class InstallBroadcastReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      try
      {
        String str = paramIntent.getAction();
        paramContext = (WebViewPlugin.a)AchillesFragmentUtils.cF.get();
        paramIntent = paramIntent.getData().getEncodedSchemeSpecificPart();
        if ((paramContext != null) && (!TextUtils.isEmpty(paramIntent))) {
          if (paramContext == null) {
            break label111;
          }
        }
        label111:
        for (paramContext = paramContext.getWebView();; paramContext = null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("code", 1);
          localJSONObject.put("packageName", paramIntent);
          if ((paramContext != null) && (!TextUtils.isEmpty(AchillesFragmentUtils.mCallback))) {
            paramContext.callJs(AchillesFragmentUtils.mCallback, new String[] { localJSONObject.toString() });
          }
          AchillesFragmentUtils.a("appinstall", str, paramIntent, null);
          return;
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.AchillesFragmentUtils
 * JD-Core Version:    0.7.0.1
 */