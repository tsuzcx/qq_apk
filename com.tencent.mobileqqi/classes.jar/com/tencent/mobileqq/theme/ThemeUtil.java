package com.tencent.mobileqq.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeUtil
{
  public static final String DEFAULT_THEME_ID = "1000";
  public static final String PKG_SUFFIX = ".zip";
  public static final String TAG = "Theme.ThemeUtil";
  public static final String THEME_BASE_DIR_NAME = "mobileqq_theme";
  public static final String THEME_ID_NIGHTMODE = "1103";
  public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_20140616";
  public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
  public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
  public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
  public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
  public static final String THEME_SHARED_PREFERENCES = "userThemeSharedPreferences";
  public static final String THEME_STATUS_COMPLETE = "5";
  public static final String THEME_STATUS_DOWNLOAD_END = "3";
  public static final String THEME_STATUS_DOWNLOAD_NONE = "1";
  public static final String THEME_STATUS_DOWNLOAD_PAUSE = "4";
  public static final String THEME_STATUS_DOWNLOAD_PROGRESS = "2";
  public static final String THEME_VOICE_BASE_HOME = "voice";
  public static final String THEME_VOICE_SETTING = "theme_voice_setting_";
  
  public static Bundle getCurrentThemeInfo()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("themeId", "1000");
    localBundle.putString("version", "0");
    String str = SkinEngine.getInstances().getSkinRootPath();
    localBundle.putString("themePath", str);
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "getCurrentThemeInfo,currentThemeResPath=" + str);
    }
    if ((str != null) && (str.length() > 0))
    {
      Object localObject = str;
      if (str.endsWith("/")) {
        localObject = str.substring(0, str.length() - 1);
      }
      str = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "getCurrentThemeInfo,currentThemeResPath=" + (String)localObject + ",themeIdVersion=" + str);
      }
      if (str != null)
      {
        localObject = str.split("_");
        if (localObject.length == 2)
        {
          localBundle.putString("themeId", localObject[0]);
          localBundle.putString("version", localObject[1]);
        }
      }
    }
    return localBundle;
  }
  
  public static String getThemeDensity(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext.densityDpi <= 160) {
      return "m";
    }
    if ((paramContext.densityDpi > 160) && (paramContext.densityDpi < 320)) {
      return "h";
    }
    return "xh";
  }
  
  public static String getThemeDownloadFilePath(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = AppConstants.bf;
    return paramContext + paramString1 + "_" + paramString2 + ".zip";
  }
  
  public static int getThemeDownloadNum(Context paramContext)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    paramContext = paramContext.getSharedPreferences("userThemeSharedPreferences", 0).getString("userDownloadTheme", "");
    k = n;
    if (paramContext != null)
    {
      int j = m;
      k = n;
      try
      {
        if (paramContext.length() > 0)
        {
          j = m;
          paramContext = new JSONObject(paramContext);
          j = m;
          Iterator localIterator = paramContext.keys();
          for (;;)
          {
            j = i;
            k = i;
            if (!localIterator.hasNext()) {
              break;
            }
            j = i;
            String str = paramContext.getJSONObject(String.valueOf(localIterator.next())).getString("status");
            j = i;
            if (!str.equals("5"))
            {
              j = i;
              boolean bool = str.equals("3");
              if (!bool) {}
            }
            else
            {
              i += 1;
            }
          }
        }
        return k;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        k = j;
      }
    }
  }
  
  public static ThemeUtil.ThemeInfo getThemeInfo(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("userThemeSharedPreferences", 0).getString("userDownloadTheme", "");
    if (paramContext != null)
    {
      try
      {
        if (paramContext.length() <= 0) {
          break label141;
        }
        paramContext = new JSONObject(paramContext);
        if (!paramContext.has(paramString)) {
          break label141;
        }
        JSONObject localJSONObject = paramContext.getJSONObject(paramString);
        paramContext = new ThemeUtil.ThemeInfo();
        paramString.printStackTrace();
      }
      catch (JSONException paramString)
      {
        try
        {
          paramContext.themeId = paramString;
          paramContext.version = localJSONObject.getString("version");
          paramContext.size = localJSONObject.getLong("size");
          paramContext.status = localJSONObject.getString("status");
          paramContext.downsize = localJSONObject.getLong("downsize");
          if (localJSONObject.has("sound")) {
            paramContext.isVoiceTheme = localJSONObject.getBoolean("sound");
          }
          return paramContext;
        }
        catch (JSONException paramString)
        {
          break label131;
        }
        paramString = paramString;
        paramContext = null;
      }
      label131:
      return paramContext;
    }
    label141:
    return null;
  }
  
  public static String getThemeResourcePath(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      localObject1 = localObject2;
      if (paramString2 != null)
      {
        localObject1 = localObject2;
        if (paramString1 != "1000") {
          if (!Utils.f()) {
            break label91;
          }
        }
      }
    }
    label91:
    for (paramContext = AppConstants.aY + "using_theme_res";; paramContext = paramContext.getDir("mobileqq_theme", 0).getAbsolutePath())
    {
      localObject1 = paramContext + File.separator + paramString1 + "_" + paramString2;
      return localObject1;
    }
  }
  
  public static int getThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    int i = paramQQAppInterface.getPreferences().getInt("user_switch_theme_times", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "getThemeSwitchTimes userSwitchThemeTimes=" + i);
    }
    return i;
  }
  
  public static String getThemeVoiceRootPath()
  {
    Object localObject = SkinEngine.getInstances().getSkinRootPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject + File.separatorChar + "voice");
      if (((File)localObject).exists()) {
        return ((File)localObject).getAbsolutePath();
      }
    }
    return null;
  }
  
  public static String getUserCurrentThemeId(AppInterface paramAppInterface)
  {
    return paramAppInterface.getPreferences().getString("currentThemeId_20140616", "1000");
  }
  
  public static String getUserCurrentThemeId(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    localObject = ((SharedPreferences)localObject).getString("currentThemeId_20140616", "1000");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + paramQQAppInterface + ",currentThemeId=" + (String)localObject);
    }
    return localObject;
  }
  
  public static String getUserCurrentThemeVersion(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    localObject = ((SharedPreferences)localObject).getString("currentThemeVersion", "0");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + paramQQAppInterface + ",currentThemeVersion=" + (String)localObject);
    }
    return localObject;
  }
  
  public static void initTheme(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl localBaseApplicationImpl;
    String str1;
    Object localObject;
    String str2;
    if (paramQQAppInterface.isLogin())
    {
      localBaseApplicationImpl = BaseApplicationImpl.a;
      str1 = getCurrentThemeInfo().getString("themeId");
      localObject = getUserCurrentThemeId(paramQQAppInterface);
      str2 = getUserCurrentThemeVersion(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme,userThemeId=" + (String)localObject + ",currentThemeId=" + str1);
      }
      if (str1.equals(localObject)) {
        break label213;
      }
      if (!((String)localObject).equals("1000")) {
        break label115;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme reset user to default theme");
      }
      SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
    }
    label115:
    do
    {
      return;
      str1 = getThemeResourcePath(localBaseApplicationImpl, (String)localObject, str2);
      localObject = new File(str1);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme reset user theme resourcePath=" + str1 + ",dir exists=" + ((File)localObject).exists());
      }
      if (((File)localObject).exists())
      {
        SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, str1);
        return;
      }
      SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
      setCurrentThemeIdVersion(paramQQAppInterface, "1000", "0");
      return;
      paramQQAppInterface = SkinEngine.getInstances().getSkinRootPath();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 0) || (!str1.equals("1000")));
    label213:
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "initTheme reset user to default theme for old version,currentThemeResPath=" + paramQQAppInterface);
    }
    SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
  }
  
  public static boolean isInNightMode(AppInterface paramAppInterface)
  {
    return "1103".equals(getUserCurrentThemeId(paramAppInterface));
  }
  
  public static void resetThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("user_switch_theme_times", 0);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "resetThemeSwitchTimes");
    }
  }
  
  public static Boolean setCurrentThemeIdVersion(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    Object localObject = paramAppRuntime.getPreferences();
    paramAppRuntime = paramAppRuntime.getAccount();
    String str = ((SharedPreferences)localObject).getString("currentThemeId_20140616", "1000");
    int i = ((SharedPreferences)localObject).getInt("user_switch_theme_times", 0) + 1;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("currentThemeId_20140616", paramString1);
    ((SharedPreferences.Editor)localObject).putString("currentThemeVersion", paramString2);
    ((SharedPreferences.Editor)localObject).putInt("user_switch_theme_times", i);
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + paramAppRuntime + ",currentThemeId=" + str + ",set new themeId=" + paramString1 + ",userSwitchThemeTimes=" + i);
    }
    return Boolean.valueOf(((SharedPreferences.Editor)localObject).commit());
  }
  
  public static Boolean setThemeInfo(Context paramContext, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    paramContext = paramContext.getSharedPreferences("userThemeSharedPreferences", 0);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("userDownloadTheme", "");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo themeInfo=" + paramThemeInfo.toString() + ",userTheme=" + paramContext);
    }
    String str = paramThemeInfo.themeId;
    if (str != null)
    {
      if (paramContext != null) {}
      try
      {
        if (paramContext.length() > 0)
        {
          paramContext = new JSONObject(paramContext);
          if (!paramContext.has(str)) {
            break label215;
          }
        }
        label215:
        for (JSONObject localJSONObject = paramContext.getJSONObject(str);; localJSONObject = new JSONObject())
        {
          localJSONObject.put("downsize", paramThemeInfo.downsize);
          localJSONObject.put("size", paramThemeInfo.size);
          localJSONObject.put("version", paramThemeInfo.version);
          localJSONObject.put("status", paramThemeInfo.status);
          paramContext.put(str, localJSONObject);
          localJSONObject.put("sound", paramThemeInfo.isVoiceTheme);
          return Boolean.valueOf(localEditor.putString("userDownloadTheme", paramContext.toString()).commit());
          paramContext = new JSONObject();
          break;
        }
        if (!QLog.isColorLevel()) {
          break label286;
        }
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo error:" + paramContext.getMessage());
        }
        paramContext.printStackTrace();
        return Boolean.valueOf(false);
      }
    }
    else
    {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo error themeId is null");
    }
    label286:
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil
 * JD-Core Version:    0.7.0.1
 */