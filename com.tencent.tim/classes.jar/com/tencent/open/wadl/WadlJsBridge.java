package com.tencent.open.wadl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import aqft;
import arxp;
import arxq;
import arzx;
import arzx.a;
import asbt;
import asbv;
import asbw;
import asbx;
import asby;
import awok;
import awol;
import awot;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbb;

public class WadlJsBridge
  extends BaseInterface
  implements arxp
{
  private static WadlJsBridge jdField_a_of_type_ComTencentOpenWadlWadlJsBridge;
  private asbx jdField_a_of_type_Asbx;
  private asby jdField_a_of_type_Asby;
  private Context context = getAppRuntime().getApplication().getBaseContext();
  private boolean ddN;
  private String jsCallBackMethod = "";
  private arzx.a listener;
  private Activity mActivity;
  private Handler mHandler;
  private WebView webview;
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView)
  {
    this(paramActivity, paramWebView, null);
  }
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView, asby paramasby)
  {
    asbt.i("WadlJsBridge", "wadlJsBridge init");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.ddN = false;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Asbx = new asbx();
    awok.eEF();
    if ((paramActivity != null) && (paramWebView != null))
    {
      arxq.a().a(this);
      this.ddN = true;
    }
    asbt.i("WadlJsBridge", "wadlJsBridge init needJSCallBack=" + this.ddN);
    paramActivity = paramasby;
    if (paramasby == null) {
      paramActivity = new asby(this.ddN, this);
    }
    this.jdField_a_of_type_Asby = paramActivity;
    awok.a(this.jdField_a_of_type_Asby);
    awok.a().eEG();
    awot.a().a(this.jdField_a_of_type_Asby);
  }
  
  private AppRuntime getAppRuntime()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static void startDownload(String paramString, boolean paramBoolean, int paramInt)
  {
    asbt.i("WadlJsBridge", "##@startDownload(Delay Task):" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (jdField_a_of_type_ComTencentOpenWadlWadlJsBridge == null) {
      jdField_a_of_type_ComTencentOpenWadlWadlJsBridge = new WadlJsBridge(null, null);
    }
    jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.jdField_a_of_type_Asbx.startDownload(paramString, paramBoolean, paramInt);
  }
  
  public asbx a()
  {
    return this.jdField_a_of_type_Asbx;
  }
  
  public void checkUpdate(String paramString)
  {
    asbt.i("WadlJsBridge", "checkUpdate params=" + paramString);
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    asbt.i("WadlJsBridge", "checkUpdate params=" + paramString1 + ",guid=" + paramString2);
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
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      if (this.listener == null)
      {
        this.listener = new a(paramString1);
        arzx.a().a(this.listener);
      }
      arzx.a().checkUpdate(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      asbt.e("WadlJsBridge", "##@httpRequest JSONException", paramString1);
    }
  }
  
  public void clearFirstRimeEntryFlag()
  {
    if (this.context != null)
    {
      SharedPreferences.Editor localEditor = this.context.getSharedPreferences("wadl_jstask_file", 0).edit();
      localEditor.putBoolean("firstTime", false);
      localEditor.commit();
    }
  }
  
  public void delDelayDownloadTasks(String paramString)
  {
    asbt.i("WadlJsBridge", "enter delDelayDownloadTasks()");
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
      asbt.e("WadlJsBridge", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    asbt.i("WadlJsBridge", "deleteDownload appid=" + paramString1 + ", sendTime=" + paramString2);
    this.jdField_a_of_type_Asbx.Z(0, paramString1, paramString2);
  }
  
  public void destroy()
  {
    asbt.i("WadlJsBridge", "##@doOnDestroy()");
    super.doOnDestroy();
    this.ddN = false;
    if (this.mActivity != null) {
      arxq.a().b(this);
    }
    awok.b(this.jdField_a_of_type_Asby);
    if (this.listener != null)
    {
      arzx.a().b(this.listener);
      this.listener = null;
    }
    awot.a().b(this.jdField_a_of_type_Asby);
  }
  
  public int doDownloadAction(String paramString)
  {
    asbt.ai("WadlJsBridge", 1, "receive webview js call=" + paramString);
    String str = "";
    if (this.webview != null) {
      str = this.webview.getUrl();
    }
    int i = this.jdField_a_of_type_Asbx.a(paramString, true, 0, str);
    asbt.i("WadlJsBridge", "doDownloadAction result=" + i);
    return i;
  }
  
  public void doGCDownloadAction(String paramString)
  {
    asbt.i("WadlJsBridge", "enter doGCDownloadAction(String pParamsJson)");
    doDownloadAction(paramString);
  }
  
  public String getAppVersionCode(String paramString)
  {
    asbt.i("WadlJsBridge", "##@getAppVersionCode:" + paramString);
    if ((TextUtils.isEmpty(paramString)) || (this.context == null)) {
      return "";
    }
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null)
      {
        paramString = paramString.versionCode + "";
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String getAppVersionName(String paramString)
  {
    asbt.i("WadlJsBridge", "##@getAppVersionName:" + paramString);
    if ((TextUtils.isEmpty(paramString)) || (this.context == null)) {
      return "";
    }
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null)
      {
        paramString = paramString.versionName + "";
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public long getAvailableBytes()
  {
    try
    {
      long l = aqft.hE();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void getDelayDownloadTasks()
  {
    asbt.i("WadlJsBridge", "##@getDelayDownloadTasks() BEGIN");
    Object localObject = tbb.gQ("DELAY_LIST");
    JSONArray localJSONArray = new JSONArray();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      int i = 0;
      for (;;)
      {
        if (i < localObject.length)
        {
          JSONObject localJSONObject = new JSONObject();
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
              asbt.e("WadlJsBridge", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
    asbt.i("WadlJsBridge", "##@getDelayDownloadTasks() END");
  }
  
  public String getDownloadVersion()
  {
    asbt.i("WadlJsBridge", "enter getDownloadVersion");
    String str = String.valueOf(4);
    getDownloadVersionJsCallBack(str);
    return str;
  }
  
  public void getDownloadVersionJsCallBack(String paramString)
  {
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDownloadVersion',{\"version\":\"" + paramString + "\",\"r\":\"-1\"});}void(0);");
  }
  
  public void getInstalledAppVersionCode(String paramString1, String paramString2)
  {
    asbt.i("WadlJsBridge", "##@enter getInstalledAppVersionCode(BEGIN)" + paramString1 + " : " + paramString2);
    if (!hasRight()) {
      return;
    }
    str1 = paramString2;
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      str1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        str1 = paramString2;
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      str1 = paramString1;
      paramString2 = ((JSONObject)localObject).optJSONArray("packageNames");
      str1 = paramString1;
      localObject = new JSONArray();
      if (paramString2 != null)
      {
        int i = 0;
        for (;;)
        {
          str1 = paramString1;
          if (i >= paramString2.length()) {
            break;
          }
          str1 = paramString1;
          String str2 = paramString2.getString(i);
          str1 = paramString1;
          String str3 = getAppVersionCode(str2);
          str1 = paramString1;
          String str4 = getAppVersionName(str2);
          str1 = paramString1;
          JSONObject localJSONObject = new JSONObject();
          str1 = paramString1;
          localJSONObject.put("packageName", str2);
          str1 = paramString1;
          localJSONObject.put("versionCode", str3);
          str1 = paramString1;
          localJSONObject.put("versionName", str4);
          str1 = paramString1;
          ((JSONArray)localObject).put(localJSONObject);
          i += 1;
        }
      }
      str1 = paramString1;
      paramString1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{'guid':'" + paramString1 + "','r':'0','data':'" + ((JSONArray)localObject).toString() + "'});}void(0);";
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{\"guid\":\"" + str1 + "\",\"r\":\"-1\"});}void(0);";
      }
    }
    jsCallBack(paramString1);
  }
  
  public String getInterfaceName()
  {
    return "wadl_download";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    this.jdField_a_of_type_Asbx.getQueryDownloadAction(paramString);
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Asbx.getQueryDownloadAction(paramString1, paramString2);
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    if ("ALL_TASK_QUERY_IDENTITY".equals(paramString))
    {
      this.jdField_a_of_type_Asbx.XE(paramString);
      return;
    }
    this.jdField_a_of_type_Asbx.getQueryDownloadActionByVia(paramString);
  }
  
  public String getValidWebSsoCmds(String paramString)
  {
    paramString = (asbv)asbw.a().w("comminfo");
    JSONArray localJSONArray;
    if (paramString != null)
    {
      paramString = paramString.i();
      if (paramString != null) {
        try
        {
          localJSONArray = new JSONArray();
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localJSONArray.put(paramString.next());
            continue;
            paramString = "";
          }
        }
        catch (Throwable paramString)
        {
          asbt.e("WadlJsBridge", "getValidWebSsoCmds>>>", paramString);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        asbt.i("WadlJsBridge", "getValidWebSsoCmds...cmdsJsonStr=" + paramString);
      }
      return paramString;
      paramString = null;
      break;
      paramString = localJSONArray.toString();
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public boolean hasRight()
  {
    return super.hasRight();
  }
  
  public boolean isFirstTimeEntry()
  {
    if (this.context == null) {
      return false;
    }
    boolean bool = this.context.getSharedPreferences("wadl_jstask_file", 0).getBoolean("firstTime", true);
    asbt.i("WadlJsBridge", "##@firstTime entry:" + bool);
    return bool;
  }
  
  public boolean isNeedJSCallBack()
  {
    return this.ddN;
  }
  
  public void jsCallBack(String paramString)
  {
    if (this.ddN) {
      this.mHandler.post(new WadlJsBridge.1(this, paramString));
    }
  }
  
  public void queryAllDownloadTask()
  {
    this.jdField_a_of_type_Asbx.emB();
  }
  
  public boolean queryInterrupt(String paramString)
  {
    return false;
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    asbt.i("WadlJsBridge", "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
  }
  
  public void requestWebSso(String paramString)
  {
    if (QLog.isColorLevel()) {
      asbt.i("WadlJsBridge", "requestWebSso...jsonParams=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("webssoCmdId");
      JSONObject localJSONObject = paramString.getJSONObject("webssoReq");
      paramString = (asbv)asbw.a().w("comminfo");
      if (paramString != null) {}
      for (paramString = paramString.i(); (TextUtils.isEmpty(str)) || (paramString == null) || (!paramString.contains(str)); paramString = awot.bU)
      {
        jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + str + ", \"webssoReq\":" + localJSONObject.toString() + ", \"ret\":-2});}void(0);");
        return;
      }
      paramString = new Bundle();
      paramString.putString("webssoReqJson", localJSONObject.toString());
      awot.a().a(str, localJSONObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      asbt.e("WadlJsBridge", "requestWebSso>>>", paramString);
    }
  }
  
  public int showPadFace(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1;
      try
      {
        paramString = new PadFaceAd(new JSONObject(paramString));
        if (paramString.isValid())
        {
          QQGamePadFaceFragment.a(this.mActivity, paramString);
          return 0;
        }
      }
      catch (JSONException paramString) {}
    }
    return -1;
  }
  
  class a
    implements arzx.a
  {
    protected String guid;
    
    public a(String paramString)
    {
      this.guid = paramString;
    }
    
    public void Ui(String paramString)
    {
      if (!WadlJsBridge.this.hasRight()) {
        return;
      }
      asbt.e("WadlJsBridge", "##@!JsCheckUpdateCallback onException >>> " + paramString);
      paramString = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.guid + "\",\"r\":\"-1\"});}void(0);";
      WadlJsBridge.this.jsCallBack(paramString);
    }
    
    public void onResult(ArrayList<ApkUpdateDetail> paramArrayList)
    {
      asbt.i("WadlJsBridge", "##@checkUpdate(End) onResult()");
      if (!WadlJsBridge.this.hasRight()) {
        return;
      }
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
      WadlJsBridge.this.jsCallBack(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridge
 * JD-Core Version:    0.7.0.1
 */