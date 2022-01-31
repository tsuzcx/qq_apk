package com.tencent.open.export.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.JavaScriptInterface;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.smtt.sdk.WebView;
import fga;
import fgb;
import fgc;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipDownloadInterface
  extends BaseInterface
  implements JavaScriptInterface, IJsCallBack
{
  protected final Activity a;
  protected Handler a;
  protected UpdateManager.OnCheckUpdateListener a;
  public final WebView a;
  public final String a;
  protected String b = "";
  
  public VipDownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    this.jdField_a_of_type_JavaLangString = VipDownloadInterface.class.getSimpleName();
    LogUtility.c(this.jdField_a_of_type_JavaLangString, "init in");
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramActivity = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      paramActivity = (AppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    }
    DownloadManager.a().a(paramActivity);
    DownloadManager.a();
    LogUtility.c(this.jdField_a_of_type_JavaLangString, "init out");
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new fgc(this, paramString));
  }
  
  public boolean cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return false;
    }
    DownloadApi.a(paramString1, paramString2, true);
    return true;
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    DownloadManager.a().a(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    LogUtility.c(this.jdField_a_of_type_JavaLangString, "enter checkUpdate json=" + paramString1);
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      paramString2 = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("packageNames");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener == null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener = new VipDownloadInterface.JsCheckUpdateCallback(this, paramString1);
        UpdateManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
      }
      UpdateManager.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c(this.jdField_a_of_type_JavaLangString, "httpRequest JSONException", paramString1);
    }
  }
  
  public void destroy()
  {
    LogUtility.c(this.jdField_a_of_type_JavaLangString, "destroy");
    JsCallbackManager.a().b(this);
    if (UpdateManager.a()) {
      UpdateManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
    }
  }
  
  public void doDownloadAction(String paramString)
  {
    LogUtility.a(this.jdField_a_of_type_JavaLangString, "enter doDownloadAction json=" + paramString);
    if (!hasRight()) {
      return;
    }
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        int i = localJSONObject.optInt("myAppConfig");
        Object localObject = localJSONObject.optString(DownloadConstants.A);
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("0"))) {
          break label881;
        }
        LogUtility.a(this.jdField_a_of_type_JavaLangString, "finalChannel :" + (String)localObject);
        int j;
        if (i == 0) {
          try
          {
            localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, localJSONObject.optString("appid"));
            localBundle.putString(DownloadConstants.i, localJSONObject.optString("url"));
            localBundle.putString(DownloadConstants.e, localJSONObject.optString("packageName"));
            localBundle.putInt(DownloadConstants.j, localJSONObject.optInt("actionCode"));
            localBundle.putString(DownloadConstants.h, localJSONObject.optString("via"));
            localBundle.putString(DownloadConstants.k, localJSONObject.optString("appName"));
            localBundle.putString(DownloadConstants.A, (String)localObject);
            j = localJSONObject.optInt("sourceType");
            i = j;
            if (j != 4) {
              i = 3;
            }
            LogUtility.a(this.jdField_a_of_type_JavaLangString, "doDownloadAction object " + localJSONObject.toString());
            DownloadApi.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, i, null, 0);
            return;
          }
          catch (NumberFormatException paramString)
          {
            LogUtility.c(this.jdField_a_of_type_JavaLangString, "Exception", paramString);
            return;
          }
        }
        try
        {
          localJSONObject = new JSONObject(paramString);
          localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, localJSONObject.optString("appid"));
          localBundle.putString(DownloadConstants.i, localJSONObject.optString("url"));
          localBundle.putString(DownloadConstants.e, localJSONObject.optString("packageName"));
          localBundle.putInt(DownloadConstants.j, localJSONObject.optInt("actionCode"));
          localBundle.putString(DownloadConstants.h, localJSONObject.optString("via"));
          localBundle.putString(DownloadConstants.k, localJSONObject.optString("appName"));
          localBundle.putBoolean(DownloadConstants.q, DownloadInterface.changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
          localBundle.putString(DownloadConstants.o, localJSONObject.optString("wording"));
          localBundle.putString(DownloadConstants.A, (String)localObject);
          localJSONObject.optString("via");
          localJSONObject.optString("appid");
          localJSONObject.optInt("actionCode");
          if (localJSONObject.optInt("actionCode") == 12)
          {
            boolean bool = DownloadInterface.changeIntToBoolean(localJSONObject.optInt("updateType"));
            localBundle.putBoolean(DownloadConstants.n, bool);
            bool = localJSONObject.has("updateData");
            if (!bool) {}
          }
          paramString = null;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            try
            {
              localObject = localJSONObject.optString("updateData");
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label876;
              }
              paramString = new ApkUpdateDetail();
            }
            catch (Exception paramString)
            {
              paramString = null;
            }
            try
            {
              localObject = new JSONObject((String)localObject);
              paramString.packageName = ((JSONObject)localObject).optString("packageName");
              paramString.newapksize = ((JSONObject)localObject).optInt("newapksize");
              paramString.patchsize = ((JSONObject)localObject).optInt("patchsize");
              paramString.updatemethod = ((JSONObject)localObject).optInt("updatemethod");
              paramString.versioncode = ((JSONObject)localObject).optInt("versioncode");
              paramString.versionname = ((JSONObject)localObject).optString("versionname");
              paramString.fileMd5 = ((JSONObject)localObject).optString("fileMd5");
              paramString.sigMd5 = ((JSONObject)localObject).optString("sigMd5");
              paramString.url = ((JSONObject)localObject).optString("url");
              localBundle.putString(DownloadConstants.b, localJSONObject.optString("myAppId"));
              localBundle.putString(DownloadConstants.c, localJSONObject.optString("apkId"));
              localBundle.putInt(DownloadConstants.d, localJSONObject.optInt("versionCode", -10));
              localBundle.putInt(DownloadConstants.m, localJSONObject.optInt("toPageType"));
              localBundle.putBoolean(DownloadConstants.f, DownloadInterface.changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
              localBundle.putBoolean(DownloadConstants.g, DownloadInterface.changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
              j = localJSONObject.optInt("sourceType");
              LogUtility.c(this.jdField_a_of_type_JavaLangString, "doDownloadAction object " + localJSONObject.toString());
              DownloadApi.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, j, paramString, i);
              return;
            }
            catch (Exception localException)
            {
              break label845;
            }
            paramString = paramString;
            LogUtility.c(this.jdField_a_of_type_JavaLangString, "JSONException", paramString);
            return;
            LogUtility.c(this.jdField_a_of_type_JavaLangString, "enter doDownloadAction updateData json");
          }
        }
        catch (NumberFormatException paramString)
        {
          LogUtility.c(this.jdField_a_of_type_JavaLangString, "Exception", paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        LogUtility.c(this.jdField_a_of_type_JavaLangString, "JSONException", paramString);
        return;
      }
      label845:
      label876:
      for (;;) {}
      label881:
      String str = "";
    }
  }
  
  public String getDownloadVersion()
  {
    return DownloadApi.a() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download";
  }
  
  public String getJsCallbackMethod()
  {
    return this.b;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    LogUtility.b(this.jdField_a_of_type_JavaLangString, "enter getQueryDownloadAction = " + paramString);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("infolist");
      localObject = ((JSONObject)localObject).getString("guid");
      int j = paramString.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.b = localJSONObject.optString("appid");
        localDownloadInfo.i = localJSONObject.optString("myAppId");
        localDownloadInfo.j = localJSONObject.optString("apkId");
        localDownloadInfo.d = localJSONObject.optString("packageName");
        localDownloadInfo.g = localJSONObject.optInt("versionCode");
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      DownloadApi.a(localArrayList, new fga(this, (String)localObject));
      return;
    }
    catch (JSONException paramString)
    {
      LogUtility.c(this.jdField_a_of_type_JavaLangString, "getQueryDownloadAction>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    LogUtility.a(this.jdField_a_of_type_JavaLangString, "enter getQueryDownloadAction = " + paramString1);
    if (!hasRight()) {
      return;
    }
    try
    {
      paramString1 = new JSONArray(paramString1);
      int j = paramString1.length();
      paramString2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.b = paramString1.getString(i);
        paramString2.add(localDownloadInfo);
        i += 1;
      }
      DownloadApi.a(paramString2, new fgb(this));
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c(this.jdField_a_of_type_JavaLangString, "getQueryDownloadAction>>>", paramString1);
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkWebView;
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    JsCallbackManager.a().a(this);
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface
 * JD-Core Version:    0.7.0.1
 */