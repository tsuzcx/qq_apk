package com.tencent.open.appstore.js;

import acfp;
import affz;
import afjy;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import arut;
import arvv;
import arvz;
import arwg;
import arwt;
import arxp;
import arxq;
import aryv;
import arzk;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
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

public class DownloadInterfaceNew
  extends BaseInterface
  implements arxp
{
  private arut a;
  private String cCG = "";
  private Activity mActivity;
  private Handler mHandler;
  private WebView mWebView;
  
  public DownloadInterfaceNew(Activity paramActivity, WebView paramWebView)
  {
    arwt.i("DownloadInterfaceNew", "<DownloadInterfaceNew>");
    this.mActivity = paramActivity;
    this.mWebView = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      arvv.a().setAppInterface(paramWebView);
      arxq.a().a(this);
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  private void c(JSONArray paramJSONArray, String paramString)
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
        localDownloadInfo.urlStr = localJSONObject.optString("url");
        localDownloadInfo.packageName = localJSONObject.optString("packageName");
        localDownloadInfo.versionCode = localJSONObject.optInt("versionCode");
        localDownloadInfo.appId = localJSONObject.optString("appid");
        localDownloadInfo.emb();
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      arvz.a().a(localArrayList, new arwg(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      arwt.e("DownloadInterfaceNew", "[innerQuery] e=", paramJSONArray);
    }
  }
  
  private static boolean changeIntToBoolean(int paramInt)
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
  
  private void iJ(String paramString1, String paramString2)
  {
    paramString1 = arvz.a().gV();
    arwt.d("DownloadInterfaceNew", "[getAllSDKDownloadInfos] infos size = " + paramString1.size());
    JSONArray localJSONArray = new JSONArray();
    int j = paramString1.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        DownloadInfo localDownloadInfo = (DownloadInfo)paramString1.get(i);
        try
        {
          localJSONObject.put("appid", localDownloadInfo.appId);
          localJSONObject.put("apkid", localDownloadInfo.cCL);
          localJSONObject.put("packagename", localDownloadInfo.packageName);
          localJSONObject.put("versioncode", localDownloadInfo.versionCode);
          localJSONObject.put("url", localDownloadInfo.urlStr);
          localJSONObject.put("pro", localDownloadInfo.progress);
          localJSONObject.put("state", localDownloadInfo.getState());
          localJSONObject.put("downloadType ", localDownloadInfo.downloadType);
          localJSONObject.put("download_from", localDownloadInfo.from);
          localJSONObject.put("via", localDownloadInfo.via);
          localJSONObject.put("totalDataLength", localDownloadInfo.awN);
          localJSONObject.put("writecodestate", localDownloadInfo.elm);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramString1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getAllSDKDownloadInfos',{\"guid\": " + paramString2 + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);";
    arwt.d("DownloadInterfaceNew", "[getAllSDKDownloadInfos]:" + paramString1);
    jsCallBack(paramString1);
  }
  
  private void jsCallBack(String paramString)
  {
    this.mHandler.post(new DownloadInterfaceNew.2(this, paramString));
  }
  
  private void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!afjy.a().ajq())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), acfp.m(2131705281), 0).show();
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
  
  public int batchDownloadByYYB(String paramString)
  {
    arwt.i("DownloadInterfaceNew", ">batchDownloadByYYB" + paramString);
    if (!hasRight()) {
      return -1;
    }
    Object localObject6 = null;
    Object localObject1 = "";
    localObject5 = "";
    Object localObject2 = localObject6;
    localObject4 = localObject1;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject2 = localObject6;
        localObject4 = localObject1;
        paramString = localJSONObject.optJSONArray("appInfo");
        localObject2 = paramString;
        localObject4 = localObject1;
        localObject1 = localJSONObject.optString(aryv.PARAM_VIA);
        localObject2 = paramString;
        localObject4 = localObject1;
        i = localJSONObject.optInt(aryv.PARAM_ACTIONCODE);
        arwt.e("DownloadInterfaceNew", ">batchDownloadByYYB JSONException", (Throwable)localObject2);
      }
      catch (JSONException localJSONException3)
      {
        try
        {
          localObject2 = localJSONObject.optString("sourceType");
          localObject4 = localObject2;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            int i;
            localObject4 = paramString;
            paramString = (String)localObject5;
          }
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject4 = DownloadInterface.getSourceInfoFromActivity(this.mActivity);
          }
          localObject2 = localObject4;
          localObject4 = paramString;
          arwt.i("DownloadInterfaceNew", ">batchDownloadByYYB appInfo:" + localObject4 + "||via:" + (String)localObject1);
          if ((localObject4 != null) && (((JSONArray)localObject4).length() != 0)) {
            break;
          }
          return -1;
        }
        catch (JSONException localJSONException2)
        {
          localObject5 = localJSONException1;
          Object localObject3 = localJSONException2;
          String str = paramString;
          paramString = (String)localObject5;
          break label214;
        }
        localJSONException3 = localJSONException3;
        i = 0;
        paramString = (String)localObject5;
        localObject1 = localObject4;
        localObject4 = localObject2;
        localObject2 = localJSONException3;
      }
      label214:
      localObject2 = paramString;
    }
    arzk.a().a(this.mActivity, (JSONArray)localObject4, i, (String)localObject1, (String)localObject2);
    return 0;
  }
  
  public void cancelDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    arvz.a().dy(paramString, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    arvv.a().cancelNotification(paramString);
  }
  
  public void deleteDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    arvz.a().dz(paramString, true);
  }
  
  public void destroy()
  {
    arwt.i("DownloadInterfaceNew", "destroy");
    arxq.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    localObject3 = null;
    arwt.i("DownloadInterfaceNew", "[doDownloadAction]");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.mActivity) >= 6) {
      localBundle.putLong("OuterCall_JS_DoDownloadAction", System.currentTimeMillis());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = localJSONObject.optString("appId");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = localJSONObject.optString("appid");
        if (localJSONObject.has("delayDownload"))
        {
          i = localJSONObject.optInt("delayDownload", -1);
          if ((this.mActivity instanceof BaseActivity)) {
            localObject2 = (AppInterface)((BaseActivity)this.mActivity).getAppRuntime();
          }
          if (1 == i)
          {
            tbb.X((String)localObject1, "DELAY_LIST");
            tbb.h((String)localObject1, paramString, "DELAY_APPID_DETAIL_");
            tax.registerReceiver();
            sendRemoteReq(affz.a("gamecenter_delaydownload", "callback", 0, null), false, false);
            return 0;
          }
          if (i == 0) {
            tbb.W((String)localObject1, "DELAY_LIST");
          }
        }
        localBundle.putString(aryv.PARAM_SNG_APPID, (String)localObject1);
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
        localBundle.putLong(aryv.PARAM_DOWNLOADSIZE, localJSONObject.optLong("downloadSize"));
        localBundle.putString(aryv.PARAM_WORDING, localJSONObject.optString("wording"));
        paramString = localJSONObject.optString(aryv.cDC);
        arwt.i("DownloadInterfaceNew", "[doDownloadAction] feedChannel:" + paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label1359;
        }
        String str;
        if (paramString.startsWith("0;"))
        {
          break label1359;
          str = localJSONObject.optString(aryv.cDE);
          arwt.i("DownloadInterfaceNew", "[doDownloadAction] finalFeedChannel:" + paramString);
          if (!TextUtils.isEmpty(paramString)) {
            break label1248;
          }
          localBundle.putString(aryv.cDC, str);
        }
        for (;;)
        {
          paramString = localJSONObject.optString("via");
          i = localJSONObject.optInt("actionCode");
          if (this.a != null) {
            break label1272;
          }
          this.a = new arut((String)localObject1, paramString, i);
          if (localJSONObject.optInt("actionCode") != 12) {
            break label1351;
          }
          boolean bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
          localBundle.putBoolean(aryv.PARAM_PATCH_UPDATE, bool);
          bool = localJSONObject.has("updateData");
          if (!bool) {
            break label1351;
          }
          for (;;)
          {
            try
            {
              localObject2 = localJSONObject.optString("updateData");
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                continue;
              }
              paramString = new ApkUpdateDetail();
            }
            catch (Exception localException2)
            {
              label1248:
              paramString = localObject3;
              continue;
            }
            try
            {
              localObject2 = new JSONObject((String)localObject2);
              paramString.packageName = ((JSONObject)localObject2).optString("packageName");
              paramString.newapksize = ((JSONObject)localObject2).optInt("newapksize");
              paramString.patchsize = ((JSONObject)localObject2).optInt("patchsize");
              paramString.updatemethod = ((JSONObject)localObject2).optInt("updatemethod");
              paramString.versioncode = ((JSONObject)localObject2).optInt("versioncode");
              paramString.versionname = ((JSONObject)localObject2).optString("versionname");
              paramString.fileMd5 = ((JSONObject)localObject2).optString("fileMd5");
              paramString.sigMd5 = ((JSONObject)localObject2).optString("sigMd5");
              paramString.url = ((JSONObject)localObject2).optString("url");
              i = localJSONObject.optInt("myAppConfig");
              localBundle.putString(aryv.PARAM_TASK_APPID, (String)localObject1);
              localBundle.putString(aryv.PARAM_TASK_APK_ID, localJSONObject.optString("apkId"));
              localBundle.putInt(aryv.PARAM_TASK_VERSION, localJSONObject.optInt("versionCode"));
              localBundle.putInt(aryv.PARAM_TO_PAGETYPE, localJSONObject.optInt("toPageType"));
              localBundle.putBoolean(aryv.PARAM_AUTO_DOWNLOAD, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
              localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
              localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, localJSONObject.optBoolean("bolckNotify"));
              localBundle.putString("recommendId", localJSONObject.optString("recommendId"));
              localBundle.putString("sourceFromServer", "" + localJSONObject.optInt("sourceFromServer"));
              localBundle.putString(aryv.cDE, str);
              localBundle.putString("pageId", "" + localJSONObject.optInt("pageId"));
              localBundle.putString("moduleId", "" + localJSONObject.optInt("moduleId"));
              localBundle.putString("positionId", "" + localJSONObject.optInt("positionId"));
              localBundle.putString("apkId", localJSONObject.optString("apkId"));
              localBundle.putString("appId", (String)localObject1);
              localBundle.putInt("auto_start_yyb_download", localJSONObject.optInt("auto_start_yyb_download"));
              localObject2 = DownloadInterface.parseSourceType(this.mActivity, localJSONObject);
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = "biz_src_yyb";
              }
              localBundle.putString("big_brother_ref_source_key", DownloadInterface.parseCurrentPageId(this.mActivity));
              arwt.i("DownloadInterfaceNew", "[doDownloadAction] sourceType=" + (String)localObject1);
              arwt.i("DownloadInterfaceNew", "[doDownloadAction] object " + localJSONObject.toString());
              arvz.a().d(this.mActivity, localBundle, (String)localObject1, paramString, i);
              return 0;
            }
            catch (Exception localException1) {}
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
          localObject2 = paramString[0];
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1365;
          }
          paramString = (String)localObject2;
          if (!((String)localObject2).equals("0")) {
            break;
          }
          break label1365;
          localBundle.putString(aryv.cDC, paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        Object localObject2;
        arwt.e("DownloadInterfaceNew", "[doDownloadAction] JSONException", paramString);
        return -1;
        if (this.a.j((String)localObject1, paramString, i))
        {
          arwt.i("DownloadInterfaceNew", "[doDownloadAction] repeat action,return");
          return 0;
          arwt.d("DownloadInterfaceNew", "[doDownloadAction]  updateData e=" + ((Exception)localObject2).getMessage());
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        label1272:
        arwt.e("DownloadInterfaceNew", "[doDownloadAction] Exception", paramString);
        continue;
        paramString = null;
        continue;
        label1351:
        paramString = null;
        continue;
        continue;
        label1359:
        paramString = "";
        continue;
        label1365:
        paramString = "";
      }
    }
  }
  
  public void getAllSDKDownloadInfos(String paramString)
  {
    iJ("", paramString);
  }
  
  public void getAllSDKDownloadInfos(String paramString1, String paramString2)
  {
    iJ(paramString1, paramString2);
  }
  
  public String getInterfaceName()
  {
    return "q_download_v2";
  }
  
  public String getJsCallbackMethod()
  {
    return this.cCG;
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    arwt.i("DownloadInterfaceNew", "[queryDownloadAction] guid=" + paramString2 + ",paramJson=" + paramString1);
    try
    {
      c(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      arwt.e("DownloadInterfaceNew", "[queryDownloadAction] e=" + paramString1.getMessage());
    }
  }
  
  public WebView getWebview()
  {
    return this.mWebView;
  }
  
  /* Error */
  public void innerQueryInstalledAppInfo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: invokestatic 727	aroi:a	()Laroi;
    //   7: invokevirtual 731	aroi:getContext	()Landroid/content/Context;
    //   10: invokevirtual 737	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: pop
    //   14: new 115	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 116	java/util/ArrayList:<init>	()V
    //   21: astore 5
    //   23: new 109	org/json/JSONArray
    //   26: dup
    //   27: invokespecial 209	org/json/JSONArray:<init>	()V
    //   30: astore_1
    //   31: aload 5
    //   33: invokeinterface 741 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 746 1 0
    //   47: ifeq +172 -> 219
    //   50: aload 5
    //   52: invokeinterface 750 1 0
    //   57: checkcast 752	android/content/pm/PackageInfo
    //   60: astore 7
    //   62: aload 7
    //   64: getfield 756	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   67: getfield 761	android/content/pm/ApplicationInfo:flags	I
    //   70: iconst_1
    //   71: iand
    //   72: ifne -32 -> 40
    //   75: getstatic 765	java/lang/System:out	Ljava/io/PrintStream;
    //   78: new 188	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 767
    //   88: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 7
    //   93: getfield 768	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   96: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 773	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   105: new 127	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 210	org/json/JSONObject:<init>	()V
    //   112: astore 6
    //   114: aload 6
    //   116: ldc 225
    //   118: aload 7
    //   120: getfield 768	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   123: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: aload 6
    //   129: ldc 227
    //   131: aload 7
    //   133: getfield 774	android/content/pm/PackageInfo:versionCode	I
    //   136: invokevirtual 230	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 6
    //   142: ldc_w 776
    //   145: aload 7
    //   147: getfield 780	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   150: aload 7
    //   152: getfield 780	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   155: arraylength
    //   156: iconst_1
    //   157: isub
    //   158: aaload
    //   159: invokevirtual 785	android/content/pm/Signature:toCharsString	()Ljava/lang/String;
    //   162: invokestatic 790	arwu:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload_1
    //   170: aload 6
    //   172: invokevirtual 271	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   175: pop
    //   176: goto -136 -> 40
    //   179: astore_1
    //   180: ldc 27
    //   182: new 188	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 792
    //   192: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 697	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 719	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: return
    //   209: astore 7
    //   211: aload 7
    //   213: invokevirtual 274	org/json/JSONException:printStackTrace	()V
    //   216: goto -47 -> 169
    //   219: new 188	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 794
    //   229: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_2
    //   233: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 278
    //   239: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: invokevirtual 279	org/json/JSONArray:toString	()Ljava/lang/String;
    //   246: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 281
    //   252: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_1
    //   259: ldc 27
    //   261: new 188	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 796
    //   271: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   277: lload_3
    //   278: lsub
    //   279: invokevirtual 799	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: ldc_w 801
    //   285: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_1
    //   289: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 208	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_0
    //   299: aload_1
    //   300: invokespecial 103	com/tencent/open/appstore/js/DownloadInterfaceNew:jsCallBack	(Ljava/lang/String;)V
    //   303: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	DownloadInterfaceNew
    //   0	304	1	paramString1	String
    //   0	304	2	paramString2	String
    //   3	275	3	l	long
    //   21	30	5	localObject	Object
    //   112	59	6	localJSONObject	JSONObject
    //   60	91	7	localPackageInfo	android.content.pm.PackageInfo
    //   209	3	7	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   0	40	179	java/lang/Exception
    //   40	114	179	java/lang/Exception
    //   114	169	179	java/lang/Exception
    //   169	176	179	java/lang/Exception
    //   211	216	179	java/lang/Exception
    //   219	303	179	java/lang/Exception
    //   114	169	209	org/json/JSONException
  }
  
  public void installYYB()
  {
    arzk.a().cw(this.mActivity);
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    arwt.i("DownloadInterfaceNew", ">isYYBSupportBatchDownload " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = arzk.Nl();
      arwt.i("DownloadInterfaceNew", ">isYYBSupportBatchDownload yybApiLevel=" + i);
      paramString = new StringBuilder().append("javascript:").append(paramString).append("(");
      if (i >= 9) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = bool + ")";
        arwt.d("DownloadInterfaceNew", ">isYYBSupportBatchDownload:" + paramString);
        jsCallBack(paramString);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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
      arvz.t(this.mActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        arwt.e("DownloadInterfaceNew", "JSONException", paramString);
      }
    }
  }
  
  public void queryInstalledAppInfo(String paramString)
  {
    innerQueryInstalledAppInfo("", paramString);
  }
  
  public void queryInstalledAppInfo(String paramString1, String paramString2)
  {
    innerQueryInstalledAppInfo(paramString1, paramString2);
  }
  
  public void queryYYBApiLevel(String paramString)
  {
    arwt.i("DownloadInterfaceNew", ">queryYYBApiLevel " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = arzk.Nl();
      arwt.i("DownloadInterfaceNew", ">queryYYBApiLevel yybApiLevel=" + i);
      paramString = "javascript:" + paramString + "(" + i + ")";
      arwt.d("DownloadInterfaceNew", ">queryYYBApiLevel:" + paramString);
      jsCallBack(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    arwt.i("DownloadInterfaceNew", "[registerDownloadCallBackListener] callbackMethod=" + paramString);
    this.cCG = paramString;
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
      arvz.dJ(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        arwt.e("DownloadInterfaceNew", "JSONException", paramString);
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
      arvz.dK(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        arwt.e("DownloadInterfaceNew", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.js.DownloadInterfaceNew
 * JD-Core Version:    0.7.0.1
 */