package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadManager;
import fey;
import fez;
import ffa;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseJsCallBack
  extends BaseInterface
{
  public static final String LOG_TAG = "BaseJsCallBack";
  public static boolean isUpdateAssets = false;
  protected Activity activity;
  LastDownloadAction lastActionRecord = null;
  protected Handler mHandler;
  public String timePointParams = "";
  protected String urlParams = "";
  
  public BaseJsCallBack(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean appIsExists(String paramString)
  {
    return AppUtil.a(paramString);
  }
  
  public String appIsExistsBatch(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return "";
    }
    Object localObject = paramString1.split(paramString2);
    if (localObject.length == 0) {
      return "";
    }
    paramString1 = new LinkedHashMap();
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      if ((str != null) && (str.length() > 0))
      {
        if (!AppUtil.a(str)) {
          break label98;
        }
        paramString1.put(str, Integer.valueOf(1));
      }
      for (;;)
      {
        i += 1;
        break;
        label98:
        paramString1.put(str, Integer.valueOf(0));
      }
    }
    localObject = new StringBuilder();
    paramString1 = paramString1.entrySet().iterator();
    while (paramString1.hasNext()) {
      ((StringBuilder)localObject).append(((Map.Entry)paramString1.next()).getValue()).append(paramString2);
    }
    if (((StringBuilder)localObject).length() == 0) {
      return "";
    }
    LogUtility.c("BaseJsCallBack", "appIsExistsBatch >>>" + ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1));
    return ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
  }
  
  public void back()
  {
    this.activity.finish();
  }
  
  public void cgiReport(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      int i = Integer.parseInt(paramString3);
      ReportManager.a().a(paramString1, SystemClock.elapsedRealtime() - l, 0L, 0L, i, CommonDataAdapter.a().a(), "1000002", null);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void changeLoadingTip(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHandler.post(new ffa(this, paramString));
  }
  
  public void checkUpdateRes()
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--checkUpdateRes");
  }
  
  public void clearJS()
  {
    LogUtility.e("BaseJsCallBack", "clearJS");
  }
  
  public int getAPNType()
  {
    int k = -1;
    Object localObject = (ConnectivityManager)this.activity.getSystemService("connectivity");
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } while (localObject == null);
    i = k;
    for (;;)
    {
      try
      {
        j = ((NetworkInfo)localObject).getType();
        if (j != 0) {
          continue;
        }
        j = k;
        i = k;
        if (((NetworkInfo)localObject).getExtraInfo() == null) {
          j = 2;
        }
        i = j;
        boolean bool = ((NetworkInfo)localObject).getExtraInfo().toLowerCase(Locale.ENGLISH).equals("cmnet");
        if (!bool) {
          continue;
        }
        i = 3;
      }
      catch (Exception localException)
      {
        int j;
        LogUtility.c("BaseJsCallBack", "getAPNType EX >>> ", localException);
        continue;
        i = -1;
        continue;
      }
      return i;
      i = 2;
      continue;
      if (j != 1) {
        continue;
      }
      i = 1;
    }
  }
  
  public String getAgentVersion()
  {
    return CommonDataAdapter.a().d();
  }
  
  public String getAppVersionCode(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("packageName");
      localObject = ((JSONObject)localObject).optString("appid");
      int i = 0;
      if (AppUtil.a(paramString)) {
        i = AppUtil.a(paramString);
      }
      paramString = new JSONObject();
      paramString.put("installedVersionCode", i);
      paramString.put("downloadedVersionCode ", AppUtil.b(DownloadManager.a().a((String)localObject)));
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String getAppVersionCodeBatch(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          if (localObject2 == null) {
            break label150;
          }
          Object localObject1 = ((JSONObject)localObject2).getString("packageName");
          localObject2 = ((JSONObject)localObject2).getString("appid");
          if (!AppUtil.a((String)localObject1)) {
            break label145;
          }
          j = AppUtil.a((String)localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("installedVersionCode", j);
          ((JSONObject)localObject1).put("downloadedVersionCode ", AppUtil.b(DownloadManager.a().a((String)localObject2)));
          localJSONObject.put((String)localObject2, localObject1);
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("BaseJsCallBack", "getAppVersionCode ", paramString);
      }
      return localJSONObject.toString();
      label145:
      int j = 0;
      continue;
      label150:
      i += 1;
    }
  }
  
  public String getCurrentVersion()
  {
    return CommonDataAdapter.a().b();
  }
  
  public String getDisplay()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.activity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    return i + "x" + j;
  }
  
  public String getInterfaceName()
  {
    return "qqZoneAppList";
  }
  
  public String getMobileInfo()
  {
    return MobileInfoUtil.i();
  }
  
  public String getParams()
  {
    return this.urlParams;
  }
  
  public String getPlatform()
  {
    return CommonDataAdapter.a().g();
  }
  
  public String getSid()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return CommonDataAdapter.a().a();
  }
  
  public String getUin()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return String.valueOf(CommonDataAdapter.a().a());
  }
  
  public void goOldDetail(String paramString) {}
  
  public void goToDetailPage(String paramString1, String paramString2)
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--goToDetailPage");
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = new Bundle();
      paramString2.putString(DownloadConstants.a, paramString1.optString("appid"));
      paramString2.putString(DownloadConstants.e, paramString1.optString("packageName"));
      paramString2.putString(DownloadConstants.h, paramString1.optString("via"));
      paramString2.putString(DownloadConstants.b, paramString1.optString("myAppId"));
      paramString2.putString(DownloadConstants.c, paramString1.optString("apkId"));
      paramString2.putInt(DownloadConstants.d, paramString1.optInt("versionCode"));
      paramString2 = paramString1.optString("via");
      String str = paramString1.optString("appid");
      int i = paramString1.optInt("actionCode");
      if (this.lastActionRecord == null) {
        this.lastActionRecord = new LastDownloadAction(str, paramString2, i);
      }
      boolean bool;
      do
      {
        DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoDownload"));
        DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoInstall"));
        DownloadManager.a().a(paramString1.optString("appid"));
        return;
        bool = this.lastActionRecord.a(str, paramString2, i);
      } while (!bool);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c("BaseJsCallBack", "goToDetailPage>>>", paramString1);
    }
  }
  
  public void onJsAlert(String paramString)
  {
    new AlertDialog.Builder(this.activity).setTitle("javaScript dialog").setMessage(paramString).setPositiveButton(17039370, new fey(this)).setCancelable(false).create().show();
  }
  
  public void onLoadResult(String paramString) {}
  
  public void reportForVia(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("actionType");
      String str1 = ((JSONObject)localObject).optString("via");
      String str2 = ((JSONObject)localObject).optString("appid");
      localObject = ((JSONObject)localObject).optString("jsversion");
      Bundle localBundle = new Bundle();
      localBundle.putString("jsversion", (String)localObject);
      StaticAnalyz.a(paramString, str1, str2, localBundle);
      LogUtility.c("BaseJsCallBack", "reportForvia " + paramString + " | " + str1 + " | " + str2);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void reportForViaBatch(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i >= paramString.length()) {
          break;
        }
        Object localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("actionType");
          String str2 = ((JSONObject)localObject).optString("via");
          String str3 = ((JSONObject)localObject).optString("appid");
          localObject = ((JSONObject)localObject).optString("jsversion");
          Bundle localBundle = new Bundle();
          localBundle.putString("jsversion", (String)localObject);
          StaticAnalyz.a(str1, str2, str3, localBundle);
          LogUtility.c("BaseJsCallBack", "reportForvia " + str1 + " | " + str2 + " | " + str3);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public void reportPV(String paramString1, String paramString2)
  {
    if (isUpdateAssets == true)
    {
      isUpdateAssets = false;
      return;
    }
    if (AppUtil.a(paramString1))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.INSTALLED.APPDETAIL", paramString2);
      return;
    }
    if (DownloadManager.a().a(paramString2))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.UNINSTALL.APPDETAIL", paramString2);
      return;
    }
    StaticAnalyz.a("100", "ANDROIDQQ.UNDOWNLOAD.APPDETAIL", paramString2);
  }
  
  public void setActionButton(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--changeButtonStyle");
    this.mHandler.post(new fez(this, paramString));
  }
  
  public void setAllowCallBackEvent(String paramString)
  {
    try
    {
      Integer.parseInt(paramString);
      if (!hasRight()) {}
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public boolean setCommonReportData(String paramString)
  {
    LogUtility.c("BaseJsCallBack", "JsCallBack--setCommonReportData");
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        CommonDataAdapter.a().b(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        LogUtility.c("BaseJsCallBack", "JsCallBack--setCommonReportData Exception", paramString);
      }
    }
    return false;
  }
  
  public void setParams(String paramString)
  {
    this.urlParams = paramString;
  }
  
  public void showToast(String paramString)
  {
    if (!hasRight()) {}
    while ((this.activity == null) || (this.activity.isFinishing())) {
      return;
    }
    ToastUtil.a().a(paramString, 1);
  }
  
  public void startApp(String paramString1, String paramString2)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          AppUtil.a(this.activity, paramString1);
          return;
        }
      }
      catch (Exception paramString2)
      {
        LogUtility.e("startApp", "apk not exist packName = " + paramString1);
      }
    }
  }
  
  public void startApp(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (appIsExists(paramString1))
      {
        paramString3 = this.activity.getPackageManager().getLaunchIntentForPackage(paramString1);
        paramString2 = paramString3;
        if (paramString3 == null)
        {
          paramString2 = new Intent(paramString1);
          paramString2.addCategory("android.intent.category.DEFAULT");
        }
        paramString2.putExtra("platformId", "qzone_m");
        LogUtility.c("add", ">>has add platformid=qzone_m");
      }
      try
      {
        this.activity.startActivity(paramString2);
        return;
      }
      catch (Exception paramString2)
      {
        Toast.makeText(this.activity, "启动失败", 0).show();
        return;
      }
      return;
    }
    catch (Exception paramString2)
    {
      LogUtility.e("startApp", "apk not exist packName = " + paramString1);
    }
  }
  
  public void startAppWithData(String paramString1, String paramString2)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          AppUtil.a(this.activity, paramString1);
          return;
        }
      }
      catch (Exception paramString2)
      {
        LogUtility.e("startApp", "apk not exist packName = " + paramString1);
      }
    }
  }
  
  public void startOpenApp(String paramString1, String paramString2, String paramString3)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          AppUtil.a(this.activity, paramString1);
          return;
        }
      }
      catch (Exception paramString1) {}
    }
  }
  
  /* Error */
  public void startOpenApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 586
    //   12: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 588
    //   22: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_3
    //   26: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 588
    //   32: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 4
    //   37: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 590	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 532	com/tencent/open/appcommon/js/BaseJsCallBack:appIsExists	(Ljava/lang/String;)Z
    //   51: istore 6
    //   53: iload 6
    //   55: ifeq +22 -> 77
    //   58: aload 5
    //   60: ldc_w 592
    //   63: invokestatic 597	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload_0
    //   68: getfield 37	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   71: aload_3
    //   72: aload_1
    //   73: aload_2
    //   74: invokestatic 600	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: astore_1
    //   79: ldc 8
    //   81: new 86	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 602
    //   91: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 605	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 209	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: return
    //   108: astore_2
    //   109: aload 5
    //   111: astore_2
    //   112: goto -45 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	BaseJsCallBack
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   0	115	3	paramString3	String
    //   0	115	4	paramString4	String
    //   0	115	5	paramString5	String
    //   51	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	53	78	java/lang/Exception
    //   67	77	78	java/lang/Exception
    //   58	67	108	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseJsCallBack
 * JD-Core Version:    0.7.0.1
 */