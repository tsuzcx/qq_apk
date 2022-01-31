package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import hja;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeUiPlugin
  extends VasWebviewUiPlugin
{
  public static final String REPORT_COPYCAT_THEME_DOWNLOAD_TAG = "report_copycat_theme_file_download";
  public static final int REPORT_THEME_DOWNLOAD_CONTENT_RANGE_IILEGAL = 89065;
  public static final int REPORT_THEME_DOWNLOAD_DATA_WRONG = 89068;
  public static final int REPORT_THEME_DOWNLOAD_MKDIR_FAILED = 89069;
  public static final int REPORT_THEME_DOWNLOAD_NOT_EQUAL = 89066;
  public static final int REPORT_THEME_DOWNLOAD_RENAME_FAILED = 89067;
  public static final String REPORT_THEME_DOWNLOAD_TAG = "report_theme_file_download";
  static final int REPORT_THEME_INFO = 1;
  private static final String TAG = "ThemeUiPlugin";
  public static String initCurrThemeNameForReport;
  public static int initDownloadedThemeNumForReport = 0;
  public static Handler reportHandler;
  public static int reportTimes = 0;
  
  static
  {
    reportHandler = null;
  }
  
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
    String str2 = SkinEngine.getInstances().getSkinRootPath();
    if ((str2 == null) || (str2.trim().length() == 0)) {
      return "default_theme";
    }
    String str1 = str2;
    if (str2.charAt(str2.length() - 1) == File.separatorChar) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    return str1.substring(str1.lastIndexOf(File.separatorChar), str1.length());
  }
  
  public static void reportThemeNumAndCurrThemeName(QQAppInterface paramQQAppInterface, String paramString)
  {
    reportTimes = 0;
    if (reportHandler == null) {
      reportHandler = new hja(BaseApplication.getContext().getMainLooper());
    }
    reportHandler.removeMessages(1);
    initDownloadedThemeNumForReport = 0;
    initCurrThemeNameForReport = null;
    paramQQAppInterface.a(new ThemeUiPlugin.1(paramQQAppInterface, paramString));
  }
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.setTitle(2131563063);
    this.activity.I = decodeUrl(this.activity.I);
    String str = getInfoIntent().getStringExtra("pageUrl");
    if ((str != null) && (str.length() > 0)) {
      this.mRuntime.a().loadUrl(str);
    }
  }
  
  void OnActivityResume()
  {
    for (;;)
    {
      try
      {
        Object localObject2 = ThemeUtil.getCurrentThemeInfo().getString("themeId");
        if (!"1103".equals(localObject2)) {
          return;
        }
        Object localObject1 = ThemeUtil.getThemeInfo(this.activity, "1103");
        if (localObject1 == null) {
          break;
        }
        if (((ThemeUtil.ThemeInfo)localObject1).status.equals("5")) {
          ((ThemeUtil.ThemeInfo)localObject1).status = "3";
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("currentId", localObject2);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("status", ((ThemeUtil.ThemeInfo)localObject1).status);
        if (((ThemeUtil.ThemeInfo)localObject1).size > 0L)
        {
          i = (int)Math.floor(((ThemeUtil.ThemeInfo)localObject1).downsize * 1.0D / ((ThemeUtil.ThemeInfo)localObject1).size * 100.0D);
          ((JSONObject)localObject2).put("progress", Math.min(i, 100));
          ((JSONObject)localObject2).put("version", ((ThemeUtil.ThemeInfo)localObject1).version);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("1103", localObject2);
          localJSONObject.put("localInfo", localObject1);
          callJs("store.theme.controller.reloadStatus('" + localJSONObject.toString() + "');");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      int i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeUiPlugin", 2, "getThemeInfo return null");
    }
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin
 * JD-Core Version:    0.7.0.1
 */