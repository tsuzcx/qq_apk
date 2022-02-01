package com.tencent.open.appcommon.js;

import acfp;
import affz;
import afjy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import aruo;
import arup;
import arut;
import arwt;
import arxp;
import arxq;
import aryr;
import aryv;
import aryy;
import arzk;
import arzx;
import arzx.a;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tax;
import tbb;

public class DownloadInterface
  extends BaseInterface
  implements arxp
{
  public static final String PLUGIN_NAMESPACE = "q_download";
  private static final String TAG = "DownloadInterface";
  protected String jsCallBackMethod = "";
  arut lastActionRecord = null;
  protected arzx.a listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    arwt.d("DownloadInterface", "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      aryy.a().setAppInterface(paramWebView);
      arxq.a().a(this);
      arwt.d("DownloadInterface", "init out");
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  public static boolean changeIntToBoolean(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      bool = false;
    }
    while (paramInt != 1) {
      return bool;
    }
    return true;
  }
  
  public static String getRefIdFromActivity(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
      return paramActivity;
    }
    catch (Throwable paramActivity) {}
    return "";
  }
  
  public static String getSourceInfoFromActivity(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent().getStringExtra("big_brother_source_key");
      return paramActivity;
    }
    catch (Throwable paramActivity) {}
    return "";
  }
  
  private void innerQueryDownloadInfo(JSONArray paramJSONArray, String paramString)
  {
    try
    {
      int j = paramJSONArray.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.appId = localJSONObject.optString("appid");
        localDownloadInfo.cDG = localJSONObject.optString("myAppId");
        localDownloadInfo.cCL = localJSONObject.optString("apkId");
        localDownloadInfo.packageName = localJSONObject.optString("packageName");
        localDownloadInfo.versionCode = localJSONObject.optInt("versionCode");
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      aryr.b(localArrayList, new aruo(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      arwt.e("DownloadInterface", "innerQueryDownloadInfo>>>", paramJSONArray);
    }
  }
  
  private void innerQueryDownloadInfoByVia(String paramString1, String paramString2)
  {
    try
    {
      aryr.a(paramString1, new arup(this, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      arwt.e("DownloadInterface", "innerQueryDownloadInfoByVia Exception>>>", paramString1);
    }
  }
  
  public static String parseCurrentPageId(Activity paramActivity)
  {
    String str2 = getRefIdFromActivity(paramActivity);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getSourceInfoFromActivity(paramActivity);
    }
    arwt.d("DownloadInterface", ">parseCurrentPageId " + str1);
    return str1;
  }
  
  public static String parseSourceType(Activity paramActivity, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("sourceType");
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = getSourceInfoFromActivity(paramActivity);
    }
    arwt.i("DownloadInterface", ">parseSourceType sourceType=" + paramJSONObject);
    return paramJSONObject;
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    aryr.Z(paramString1, paramString2, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    aryy.a().cancelNotification(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    arwt.d("DownloadInterface", "enter checkUpdate json=" + paramString1 + ", guid = " + paramString2);
    if (!hasRight()) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = ((JSONObject)localObject).optString("guid");
        }
        paramString2 = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("packageNames");
        if (localObject != null)
        {
          int i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramString2.add(((JSONArray)localObject).getString(i));
            i += 1;
            continue;
          }
        }
        if (this.listener == null)
        {
          this.listener = new a(paramString1);
          arzx.a().a(this.listener);
          arzx.a().checkUpdate(paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        arwt.e("DownloadInterface", "httpRequest JSONException", paramString1);
        return;
      }
      ((a)this.listener).Xi(paramString1);
    }
  }
  
  public void delDelayDownloadTasks(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i = 0;
      while (i < paramString.length())
      {
        tbb.W(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("DownloadInterface", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    aryr.aa(paramString1, paramString2, true);
  }
  
  public void destroy()
  {
    arwt.d("DownloadInterface", "destroy");
    arxq.a().b(this);
    if (arzx.PN()) {
      arzx.a().b(this.listener);
    }
  }
  
  public int doDownloadAction(String paramString)
  {
    arwt.d("TIME-STATISTIC", "DownloadInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.mActivity) >= 6) {
      localBundle.putLong("OuterCall_JS_DoDownloadAction", System.currentTimeMillis());
    }
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("delayDownload"))
      {
        i = localJSONObject.optInt("delayDownload", -1);
        if ((this.mActivity instanceof BaseActivity)) {
          localObject = (AppInterface)((BaseActivity)this.mActivity).getAppRuntime();
        }
        localObject = localJSONObject.optString("appid");
        if (1 == i)
        {
          tbb.X((String)localObject, "DELAY_LIST");
          tbb.h((String)localObject, paramString, "DELAY_APPID_DETAIL_");
          tax.registerReceiver();
          sendRemoteReq(affz.a("gamecenter_delaydownload", "callback", 0, null), false, false);
          return 0;
        }
        if (i == 0) {
          tbb.W((String)localObject, "DELAY_LIST");
        }
      }
      localBundle.putString(aryv.PARAM_SNG_APPID, localJSONObject.optString("appid"));
      localBundle.putString(aryv.PARAM_URL, localJSONObject.optString("url"));
      localBundle.putString(aryv.PARAM_TASK_PACKNAME, localJSONObject.optString("packageName"));
      localBundle.putInt(aryv.PARAM_ACTIONCODE, localJSONObject.optInt("actionCode"));
      localBundle.putString(aryv.PARAM_VIA, localJSONObject.optString("via"));
      localBundle.putString(aryv.PARAM_APPNAME, localJSONObject.optString("appName"));
      localBundle.putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(aryv.PARAM_ICON_URL, localJSONObject.optString("iconUrl"));
      localBundle.putInt(aryv.PARAM_SHOW_NOTIFICATION, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(aryv.PARAM_EXTRA_INFO, localJSONObject.optString("extraData"));
      localBundle.putString(aryv.PARAM_DOWNLOADTSTYLE, localJSONObject.optString("downloadStyle"));
      localBundle.putString(aryv.PARAM_DOWNLOADSIZE, localJSONObject.optString("downloadSize"));
      localBundle.putString(aryv.PARAM_WORDING, localJSONObject.optString("wording"));
      paramString = localJSONObject.optString(aryv.cDC);
      arwt.w("DownloadInterface", " feedChannel:" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        break label1044;
      }
      if (!paramString.startsWith("0;")) {
        break label923;
      }
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      int i;
      Object localObject;
      boolean bool;
      arwt.e("DownloadInterface", "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        arwt.e("DownloadInterface", "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    arwt.w("DownloadInterface", " finalFeedChannel:" + paramString);
    localBundle.putString(aryv.cDC, paramString);
    paramString = localJSONObject.optString("via");
    localObject = localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    if (this.lastActionRecord == null)
    {
      this.lastActionRecord = new arut((String)localObject, paramString, i);
      label539:
      if (localJSONObject.optInt("actionCode") == 12)
      {
        bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(aryv.PARAM_PATCH_UPDATE, bool);
        bool = localJSONObject.has("updateData");
        if (!bool) {}
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          localObject = localJSONObject.optString("updateData");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramString = new ApkUpdateDetail();
        }
        catch (Exception paramString)
        {
          label923:
          paramString = null;
          continue;
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
          i = localJSONObject.optInt("myAppConfig");
          localBundle.putString(aryv.PARAM_TASK_APPID, localJSONObject.optString("myAppId"));
          localBundle.putString(aryv.PARAM_TASK_APK_ID, localJSONObject.optString("apkId"));
          localBundle.putInt(aryv.PARAM_TASK_VERSION, localJSONObject.optInt("versionCode"));
          localBundle.putInt(aryv.PARAM_TO_PAGETYPE, localJSONObject.optInt("toPageType"));
          localBundle.putBoolean(aryv.PARAM_AUTO_DOWNLOAD, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
          localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
          localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, localJSONObject.optBoolean("bolckNotify"));
          localObject = parseSourceType(this.mActivity, localJSONObject);
          localBundle.putString("big_brother_ref_source_key", parseCurrentPageId(this.mActivity));
          arwt.d("DownloadInterface", "doDownloadAction object " + localJSONObject.toString());
          aryr.d(this.mActivity, localBundle, (String)localObject, paramString, i);
          return 0;
        }
        catch (Exception localException)
        {
          continue;
        }
        paramString = paramString.split(";");
        if (paramString == null)
        {
          paramString = "";
          break;
        }
        if (paramString.length <= 0)
        {
          paramString = "";
          break;
        }
        localObject = paramString[0];
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        paramString = (String)localObject;
        if (!((String)localObject).equals("0")) {
          break;
        }
        continue;
        if (!this.lastActionRecord.j((String)localObject, paramString, i)) {
          break label539;
        }
        return 0;
        arwt.d("DownloadInterface", "enter doDownloadAction updateData json");
      }
    }
  }
  
  public void doGCDownloadAction(String paramString)
  {
    doDownloadAction(paramString);
  }
  
  public int doQueryDownloadStatus(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optString("downloadUrl");
      paramString = paramString.optString("callback");
      localObject = aryy.a().b((String)localObject);
      if (localObject == null) {
        return -1;
      }
      int i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
      int j = ((TMAssistantDownloadTaskInfo)localObject).mState;
      localObject = new JSONObject();
      ((JSONObject)localObject).put("progress", i);
      ((JSONObject)localObject).put("status", j);
      if ((this.webview != null) && ((this.webview instanceof CustomWebView))) {
        ((CustomWebView)this.webview).callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      }
      return 0;
    }
    catch (JSONException paramString)
    {
      arwt.e("DownloadInterface", "JSONException", paramString);
    }
    return -1;
  }
  
  public void doWifiDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      arwt.d("DownloadInterface", "doDownloadAction object " + paramString.toString());
      paramString = paramString.optString("via");
      arzk.a().g(this.mActivity, paramString, "biz_src_yyb");
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("DownloadInterface", "doWifiDownloadAction>>>", paramString);
    }
  }
  
  public void getDelayDownloadTasks()
  {
    Object localObject = tbb.gQ("DELAY_LIST");
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      int i = 0;
      for (;;)
      {
        if (i < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[i])) {}
          try
          {
            localJSONObject.put("appid", localObject[i]);
            localJSONArray.put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              arwt.e("DownloadInterface", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public String getDownloadVersion()
  {
    return aryr.getVersionCode() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      innerQueryDownloadInfo(paramString.getJSONArray("infolist"), paramString.getString("guid"));
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("DownloadInterface", "query>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    try
    {
      innerQueryDownloadInfo(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      arwt.e("DownloadInterface", "query>>>", paramString1);
    }
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      innerQueryDownloadInfoByVia(paramString.getString("via"), paramString.getString("guid"));
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("DownloadInterface", "query>>>", paramString);
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public void installYYB()
  {
    arzk.a().cw(this.mActivity);
  }
  
  public void jsCallBack(String paramString)
  {
    this.mHandler.post(new DownloadInterface.3(this, paramString));
  }
  
  public int openDownloaderWebview(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      aryr.t(this.mActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        arwt.e("DownloadInterface", "JSONException", paramString);
      }
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    arwt.d("DownloadInterface", "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!afjy.a().ajq())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), acfp.m(2131705290), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      afjy.a().cr(paramBundle);
      return;
    }
    afjy.a().cq(paramBundle);
  }
  
  public int setDownloaderFirstOpenPage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      long l1 = paramString.optLong("starttime");
      long l2 = paramString.optLong("endtime");
      arwt.d("DownloadInterface", l1 + "|" + l2 + "|" + (System.currentTimeMillis() - l1));
      localBundle.putLong("startTime", l1);
      localBundle.putLong("endTime", l2);
      aryr.dJ(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        arwt.e("DownloadInterface", "JSONException", paramString);
      }
    }
  }
  
  public int setDownloaderFirstOpenPageByTmast(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      aryr.dK(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        arwt.e("DownloadInterface", "JSONException", paramString);
      }
    }
  }
  
  public class a
    implements arzx.a
  {
    protected String guid;
    
    public a(String paramString)
    {
      this.guid = paramString;
    }
    
    public void Ui(String paramString)
    {
      if (!DownloadInterface.this.hasRight()) {
        return;
      }
      arwt.e("DownloadInterface", "JsCheckUpdateCallback onException >>> " + paramString);
      paramString = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.guid + "\",\"r\":\"-1\"});}void(0);";
      DownloadInterface.this.jsCallBack(paramString);
    }
    
    public void Xi(String paramString)
    {
      this.guid = paramString;
    }
    
    public void onResult(ArrayList<ApkUpdateDetail> paramArrayList)
    {
      if (!DownloadInterface.this.hasRight()) {
        return;
      }
      arwt.v("DownloadInterface", "JsCheckUpdateCallback onResult >>> " + paramArrayList.size());
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      try
      {
        while (i < paramArrayList.size())
        {
          ApkUpdateDetail localApkUpdateDetail = (ApkUpdateDetail)paramArrayList.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("packageName", localApkUpdateDetail.packageName);
          localJSONObject2.put("newapksize", localApkUpdateDetail.newapksize);
          localJSONObject2.put("patchsize", localApkUpdateDetail.patchsize);
          localJSONObject2.put("updatemethod", localApkUpdateDetail.updatemethod);
          localJSONObject2.put("versioncode", localApkUpdateDetail.versioncode);
          localJSONObject2.put("versionname", localApkUpdateDetail.versionname);
          localJSONObject2.put("fileMd5", localApkUpdateDetail.fileMd5);
          localJSONObject2.put("sigMd5", localApkUpdateDetail.sigMd5);
          localJSONObject2.put("url", localApkUpdateDetail.url);
          localJSONArray.put(localJSONObject2);
          i += 1;
        }
        localJSONObject1.put("guid", this.guid);
        localJSONObject1.put("content", localJSONArray.toString());
        localJSONObject1.put("resultCode", "0");
        paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'" + this.guid + "','r':'0','data':'" + localJSONArray.toString() + "'});}void(0);";
      }
      catch (JSONException paramArrayList)
      {
        for (;;)
        {
          paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.guid + "\",\"r\":\"-1\"});}void(0);";
        }
      }
      arwt.i("DownloadInterface", ">>checkUpdate jsUrl:" + paramArrayList);
      DownloadInterface.this.jsCallBack(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface
 * JD-Core Version:    0.7.0.1
 */