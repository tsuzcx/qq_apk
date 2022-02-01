package com.tencent.mobileqq.vaswebviewplugin;

import acfp;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import org.json.JSONObject;

public class ThemeUiPlugin
  extends VasWebviewUiPlugin
{
  public static final String EXTRA_THEME_ID = "extra_theme_id";
  public static final String REPORT_COPYCAT_THEME_DOWNLOAD_TAG = "report_copycat_theme_file_download";
  public static final int REPORT_THEME_DOWNLOAD_CONTENT_RANGE_IILEGAL = 89065;
  public static final int REPORT_THEME_DOWNLOAD_DATA_WRONG = 89068;
  public static final int REPORT_THEME_DOWNLOAD_MKDIR_FAILED = 89069;
  public static final int REPORT_THEME_DOWNLOAD_NOT_EQUAL = 89066;
  public static final int REPORT_THEME_DOWNLOAD_RENAME_FAILED = 89067;
  public static final String REPORT_THEME_DOWNLOAD_TAG = "report_theme_file_download";
  static final int REPORT_THEME_INFO = 1;
  private static final String TAG = "ThemeUiPlugin";
  static String initCurrThemeNameForReport;
  static int initDownloadedThemeNumForReport;
  static Handler reportHandler;
  static int reportTimes;
  
  public static void destroy(QQAppInterface paramQQAppInterface)
  {
    initDownloadedThemeNumForReport = 0;
    initCurrThemeNameForReport = null;
    reportTimes = 0;
    if (reportHandler != null) {
      reportHandler.removeMessages(1);
    }
  }
  
  public static String getReportCurrThemeName()
  {
    String str = SkinEngine.getInstances().getSkinRootPath();
    if ((str == null) || (str.trim().length() == 0)) {
      return "default_theme";
    }
    return ThemeUtil.getCurrentThemeId();
  }
  
  public static void reportThemeNumAndCurrThemeName(QQAppInterface paramQQAppInterface, String paramString)
  {
    reportTimes = 0;
    if (reportHandler == null) {
      reportHandler = new a(BaseApplication.getContext().getMainLooper());
    }
    reportHandler.removeMessages(1);
    initDownloadedThemeNumForReport = 0;
    initCurrThemeNameForReport = null;
    paramQQAppInterface.execute(new ThemeUiPlugin.1(paramQQAppInterface, paramString));
  }
  
  void OnActivityResume()
  {
    this.activity.setTitle(acfp.m(2131715319));
  }
  
  protected long getPluginBusiness()
  {
    return 32L;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeUiPlugin", 2, "BaseWebActivity onActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return false;
    }
    try
    {
      String str = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("responseId", str);
      localJSONObject.put("responseData", new JSONObject(paramIntent));
      if (QLog.isColorLevel()) {
        QLog.i("ThemeUiPlugin", 2, "BaseWebActivity loadUrl setMessage =" + localJSONObject.toString());
      }
      this.mRuntime.getWebView().loadUrl("javascript:window.qqJSBridge&&qqJSBridge.setMessage('" + localJSONObject.toString() + "');");
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    return true;
  }
  
  static class a
    extends Handler
  {
    public a() {}
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (ThemeUiPlugin.reportHandler == null) {
        ThemeUiPlugin.reportHandler = new a(BaseApplication.getContext().getMainLooper());
      }
      int i = paramMessage.what;
      Object localObject = (Object[])paramMessage.obj;
      if (i == 1)
      {
        if (ThemeUiPlugin.reportTimes < 3)
        {
          paramMessage = (String)localObject[0];
          localObject = (QQAppInterface)localObject[1];
          if (QLog.isColorLevel()) {
            QLog.i("ThemeUiPlugin", 2, ThemeUiPlugin.initDownloadedThemeNumForReport + "," + ThemeUiPlugin.initCurrThemeNameForReport);
          }
          VasWebviewUtil.reportVasStatus("ThemeMall", "ThemeCount", "0", 0, 0, ThemeUiPlugin.initDownloadedThemeNumForReport, 0, "", "");
          VasWebviewUtil.reportVasStatus("ThemeMall", "ThemeOn", "0", 0, 0, 0, 0, "theme_" + ThemeUiPlugin.initCurrThemeNameForReport, "");
          ThemeUiPlugin.reportTimes += 1;
          if (QLog.isColorLevel()) {
            QLog.d("ThemeUiPlugin", 2, "reportTimes is:" + ThemeUiPlugin.reportTimes);
          }
          Message localMessage = ThemeUiPlugin.reportHandler.obtainMessage();
          localMessage.what = 1;
          localMessage.obj = new Object[] { paramMessage, localObject };
          ThemeUiPlugin.reportHandler.sendMessageDelayed(localMessage, 120000L);
        }
      }
      else {
        return;
      }
      ThemeUiPlugin.reportTimes = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin
 * JD-Core Version:    0.7.0.1
 */