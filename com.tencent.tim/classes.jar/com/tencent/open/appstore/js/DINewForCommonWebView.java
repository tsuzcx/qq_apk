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
import arwe;
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

public class DINewForCommonWebView
  extends BaseInterface
  implements arxp
{
  private arut a;
  private String cCG = "";
  private Activity mActivity;
  private Handler mHandler;
  private WebView mWebView;
  
  public DINewForCommonWebView(Activity paramActivity, WebView paramWebView)
  {
    arwt.i("DINewForCommonWebView", "<DINewForCommonWebView>");
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
      arvz.a().a(localArrayList, new arwe(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      arwt.e("DINewForCommonWebView", "[innerQuery] e=", paramJSONArray);
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
  
  private void jsCallBack(String paramString)
  {
    this.mHandler.post(new DINewForCommonWebView.2(this, paramString));
  }
  
  private void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!afjy.a().ajq())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), acfp.m(2131705118), 0).show();
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
    arwt.i("DINewForCommonWebView", ">batchDownloadByYYB" + paramString);
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
        arwt.e("DINewForCommonWebView", ">batchDownloadByYYB JSONException", (Throwable)localObject2);
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
          arwt.i("DINewForCommonWebView", ">batchDownloadByYYB appInfo:" + localObject4 + "||via:" + (String)localObject1);
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
          break label212;
        }
        localJSONException3 = localJSONException3;
        i = 0;
        paramString = (String)localObject5;
        localObject1 = localObject4;
        localObject4 = localObject2;
        localObject2 = localJSONException3;
      }
      label212:
      localObject2 = paramString;
    }
    arzk.a().a(this.mActivity, (JSONArray)localObject4, i, (String)localObject1, (String)localObject2);
    return 0;
  }
  
  public void destroy()
  {
    arwt.i("DINewForCommonWebView", "destroy");
    arxq.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    localObject2 = null;
    arwt.i("DINewForCommonWebView", "[doDownloadAction]" + paramString);
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
      str1 = localJSONObject.optString("appId");
      if (TextUtils.isEmpty(str1))
      {
        str1 = localJSONObject.optString("appid");
        if (localJSONObject.has("delayDownload"))
        {
          i = localJSONObject.optInt("delayDownload", -1);
          if ((this.mActivity instanceof BaseActivity)) {
            localObject1 = (AppInterface)((BaseActivity)this.mActivity).getAppRuntime();
          }
          if (1 == i)
          {
            tbb.X(str1, "DELAY_LIST");
            tbb.h(str1, paramString, "DELAY_APPID_DETAIL_");
            tax.registerReceiver();
            sendRemoteReq(affz.a("gamecenter_delaydownload", "callback", 0, null), false, false);
            return 0;
          }
          if (i == 0) {
            tbb.W(str1, "DELAY_LIST");
          }
        }
        localBundle.putString(aryv.PARAM_SNG_APPID, str1);
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
        arwt.i("DINewForCommonWebView", "[doDownloadAction] feedChannel:" + paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label1336;
        }
        String str2;
        if (paramString.startsWith("0;"))
        {
          break label1336;
          str2 = localJSONObject.optString(aryv.cDE);
          arwt.i("DINewForCommonWebView", "[doDownloadAction] finalFeedChannel:" + paramString);
          if (!TextUtils.isEmpty(paramString)) {
            break label1225;
          }
          localBundle.putString(aryv.cDC, str2);
        }
        for (;;)
        {
          paramString = localJSONObject.optString("via");
          i = localJSONObject.optInt("actionCode");
          if (this.a != null) {
            break label1249;
          }
          this.a = new arut(str1, paramString, i);
          if (localJSONObject.optInt("actionCode") != 12) {
            break label1328;
          }
          boolean bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
          localBundle.putBoolean(aryv.PARAM_PATCH_UPDATE, bool);
          bool = localJSONObject.has("updateData");
          if (!bool) {
            break label1328;
          }
          for (;;)
          {
            try
            {
              localObject1 = localJSONObject.optString("updateData");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              paramString = new ApkUpdateDetail();
            }
            catch (Exception localException2)
            {
              label1225:
              paramString = localObject2;
              continue;
            }
            try
            {
              localObject1 = new JSONObject((String)localObject1);
              paramString.packageName = ((JSONObject)localObject1).optString("packageName");
              paramString.newapksize = ((JSONObject)localObject1).optInt("newapksize");
              paramString.patchsize = ((JSONObject)localObject1).optInt("patchsize");
              paramString.updatemethod = ((JSONObject)localObject1).optInt("updatemethod");
              paramString.versioncode = ((JSONObject)localObject1).optInt("versioncode");
              paramString.versionname = ((JSONObject)localObject1).optString("versionname");
              paramString.fileMd5 = ((JSONObject)localObject1).optString("fileMd5");
              paramString.sigMd5 = ((JSONObject)localObject1).optString("sigMd5");
              paramString.url = ((JSONObject)localObject1).optString("url");
              i = localJSONObject.optInt("myAppConfig");
              localBundle.putString(aryv.PARAM_TASK_APPID, str1);
              localBundle.putString(aryv.PARAM_TASK_APK_ID, localJSONObject.optString("apkId"));
              localBundle.putInt(aryv.PARAM_TASK_VERSION, localJSONObject.optInt("versionCode"));
              localBundle.putInt(aryv.PARAM_TO_PAGETYPE, localJSONObject.optInt("toPageType"));
              localBundle.putBoolean(aryv.PARAM_AUTO_DOWNLOAD, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
              localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
              localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, localJSONObject.optBoolean("bolckNotify"));
              localBundle.putString("recommendId", localJSONObject.optString("recommendId"));
              localBundle.putString("sourceFromServer", "" + localJSONObject.optInt("sourceFromServer"));
              localBundle.putString(aryv.cDE, str2);
              localBundle.putString("pageId", "" + localJSONObject.optInt("pageId"));
              localBundle.putString("moduleId", "" + localJSONObject.optInt("moduleId"));
              localBundle.putString("positionId", "" + localJSONObject.optInt("positionId"));
              localBundle.putString("apkId", localJSONObject.optString("apkId"));
              localBundle.putString("appId", str1);
              localBundle.putInt("auto_start_yyb_download", localJSONObject.optInt("auto_start_yyb_download"));
              str1 = DownloadInterface.parseSourceType(this.mActivity, localJSONObject);
              localBundle.putString("big_brother_ref_source_key", DownloadInterface.parseCurrentPageId(this.mActivity));
              arwt.i("DINewForCommonWebView", "[doDownloadAction] object " + localJSONObject.toString());
              arvz.a().d(this.mActivity, localBundle, str1, paramString, i);
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
          localObject1 = paramString[0];
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1342;
          }
          paramString = (String)localObject1;
          if (!((String)localObject1).equals("0")) {
            break;
          }
          break label1342;
          localBundle.putString(aryv.cDC, paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        String str1;
        int i;
        Object localObject1;
        arwt.e("DINewForCommonWebView", "[doDownloadAction] JSONException", paramString);
        return -1;
        if (this.a.j(str1, paramString, i))
        {
          arwt.i("DINewForCommonWebView", "[doDownloadAction] repeat action,return");
          return 0;
          arwt.d("DINewForCommonWebView", "[doDownloadAction]  updateData e=" + ((Exception)localObject1).getMessage());
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        label1249:
        arwt.e("DINewForCommonWebView", "[doDownloadAction] Exception", paramString);
        continue;
        paramString = null;
        continue;
        label1328:
        paramString = null;
        continue;
        continue;
        label1336:
        paramString = "";
        continue;
        label1342:
        paramString = "";
      }
    }
  }
  
  public String getInterfaceName()
  {
    return "q_download_v2";
  }
  
  public String getJsCallbackMethod()
  {
    return this.cCG;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    arwt.i("DINewForCommonWebView", "<getQueryDownloadAction> paramJson=" + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      c(new JSONArray(paramString.optString("queryParams")), paramString.optString("callback"));
      return;
    }
    catch (JSONException paramString)
    {
      arwt.e("DINewForCommonWebView", "[queryDownloadAction] e=" + paramString.getMessage());
    }
  }
  
  public WebView getWebview()
  {
    return this.mWebView;
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    arwt.i("DINewForCommonWebView", ">isYYBSupportBatchDownload " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = arzk.Nl();
      arwt.i("DINewForCommonWebView", ">isYYBSupportBatchDownload yybApiLevel=" + i);
      paramString = new StringBuilder().append("javascript:").append(paramString).append("(");
      if (i >= 9) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = bool + ")";
        arwt.d("DINewForCommonWebView", ">isYYBSupportBatchDownload:" + paramString);
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
        arwt.e("DINewForCommonWebView", "JSONException", paramString);
      }
    }
  }
  
  public void queryYYBApiLevel(String paramString)
  {
    arwt.i("DINewForCommonWebView", ">queryYYBApiLevel " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = arzk.Nl();
      arwt.i("DINewForCommonWebView", ">queryYYBApiLevel yybApiLevel=" + i);
      paramString = "javascript:" + paramString + "(" + i + ")";
      arwt.d("DINewForCommonWebView", ">queryYYBApiLevel:" + paramString);
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
    arwt.i("DINewForCommonWebView", "<registerDownloadCallBackListener> paramJsonStr=" + paramString);
    try
    {
      this.cCG = new JSONObject(paramString).optString("callback");
      arwt.i("DINewForCommonWebView", "<registerDownloadCallBackListener>" + this.cCG);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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
        arwt.e("DINewForCommonWebView", "JSONException", paramString);
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
        arwt.e("DINewForCommonWebView", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView
 * JD-Core Version:    0.7.0.1
 */