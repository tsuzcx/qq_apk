package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@JsPlugin
public class AppBoxPlugin
  extends BaseJsPlugin
{
  public static final String API_OPERATE_APP_BOX = "operateAppBox";
  public static final String API_OPERATE_DESTROY = "destroy";
  public static final String API_OPERATE_LOAD = "load";
  public static final String API_OPERATE_SHOW = "show";
  private static final String ERRCODE = "errCode";
  private static final String ERRMSG = "errMsg";
  public static final String EVENT_APP_BOX_CLOSE = "onAppBoxClose";
  public static final String KEY_REF_ID = "biz_src_miniapp";
  public static final HashMap<Integer, String> S_CodeMsg_Map = MiniSDKConst.AdConst.CodeMsgMap;
  private static final String TAG = "AppBoxPlugin";
  private Map<Integer, MiniAppBox> mAppBoxMap = new HashMap();
  
  static boolean isAdUnitIdValid(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  MiniAppBox getMiniAppBox(int paramInt, String paramString, RequestEvent paramRequestEvent)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.mAppBoxMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramString = (MiniAppBox)this.mAppBoxMap.get(Integer.valueOf(paramInt));
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (this.mMiniAppContext != null) {
          localObject1 = this.mMiniAppContext.getAttachedActivity();
        }
        paramString.setJsService(paramRequestEvent.jsService);
        paramString.setActivity((Activity)localObject1);
      }
      return paramString;
    }
    if ((this.mMiniAppContext != null) && (this.mApkgInfo != null))
    {
      localObject1 = this.mApkgInfo.appId;
      label101:
      if (this.mMiniAppContext == null) {
        break label163;
      }
    }
    label163:
    for (Activity localActivity = this.mMiniAppContext.getAttachedActivity();; localActivity = null)
    {
      paramString = new MiniAppBox(localActivity, paramInt, paramString, (String)localObject1, paramRequestEvent.jsService);
      this.mAppBoxMap.put(Integer.valueOf(paramInt), paramString);
      break;
      localObject1 = "";
      break label101;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mAppBoxMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      MiniAppBox localMiniAppBox = (MiniAppBox)((Map.Entry)localIterator.next()).getValue();
      if (localMiniAppBox != null) {
        localMiniAppBox.destroy();
      }
    }
  }
  
  @JsEvent({"operateAppBox"})
  public String operateAppBox(RequestEvent paramRequestEvent)
  {
    try
    {
      QMLog.e("AppBoxPlugin", "operateAppBox, jsonParams = " + paramRequestEvent.jsonParams);
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("id", -1);
      Object localObject = localJSONObject1.optString("adUnitId", null);
      if (!isAdUnitIdValid((String)localObject))
      {
        localJSONObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject1);
        localJSONObject1.put("errCode", 1002);
        localObject = localJSONObject1.toString();
        paramRequestEvent.fail(localJSONObject1, "广告单元无效");
        return localObject;
      }
      localObject = getMiniAppBox(i, (String)localObject, paramRequestEvent);
      String str = localJSONObject1.optString("type");
      int j = localJSONObject1.optInt("compId", -1);
      if ("load".equals(str)) {
        if (!((MiniAppBox)localObject).load(j, paramRequestEvent.callbackId))
        {
          localJSONObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          paramRequestEvent.fail(localJSONObject1, "内部错误");
        }
      }
      for (;;)
      {
        return "";
        if ("show".equals(str))
        {
          if (((MiniAppBox)localObject).show(j, paramRequestEvent.callbackId)) {
            continue;
          }
          localJSONObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          paramRequestEvent.fail(localJSONObject1, "内部错误");
          continue;
        }
        try
        {
          localJSONObject2.put("errCode", 1003);
          paramRequestEvent.fail(localJSONObject2, "内部错误");
          return localJSONObject2.toString();
          if (!"destroy".equals(str)) {
            continue;
          }
          if (((MiniAppBox)localObject).destroy()) {}
          for (JSONObject localJSONObject2 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject2);; localJSONObject2 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject2, "内部错误").put("errCode", 1003).put("errMsg", "内部错误"))
          {
            paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject2.toString());
            this.mAppBoxMap.remove(Integer.valueOf(i));
            break;
          }
        }
        catch (Throwable paramRequestEvent)
        {
          break label292;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBoxPlugin", "operateAppBoxfailed e:", localThrowable);
      localJSONObject2 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
    }
  }
  
  class MiniAppBox
  {
    private static final String ADUNIT_ID = "adUnitId";
    private static final String APP_BOX_ID = "id";
    private static final String COMP_ID = "compId";
    private static final String OPERATION_TYPE = "type";
    private static final String TAG = "SDK_MiniAppBox";
    private AdProxy.AbsBoxAdView adBox;
    private String adUnitId;
    private int appBoxId;
    private String appId;
    private WeakReference<Activity> mActivity;
    private volatile boolean mIsRequestingAd = false;
    private IJsService mJsService;
    
    MiniAppBox(Activity paramActivity, int paramInt, String paramString1, String paramString2, IJsService paramIJsService)
    {
      this.mActivity = new WeakReference(paramActivity);
      this.appBoxId = paramInt;
      this.adUnitId = paramString1;
      this.appId = paramString2;
      this.mJsService = paramIJsService;
    }
    
    private void callbackJs(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.mJsService != null) {
        if (!paramBoolean) {
          break label75;
        }
      }
      label75:
      for (paramString = ApiUtil.wrapCallbackOk(paramString, getResultObj(paramInt1, paramInt2));; paramString = ApiUtil.wrapCallbackFail(paramString, getResultObj(paramInt1, paramInt2), (String)AppBoxPlugin.S_CodeMsg_Map.get(Integer.valueOf(paramInt2))))
      {
        paramString = paramString.toString();
        QMLog.i("SDK_MiniAppBox", "evaluateCallbackJs callbackId: " + paramInt3 + " content:" + paramString);
        this.mJsService.evaluateCallbackJs(paramInt3, paramString);
        return;
      }
    }
    
    private JSONObject getResultObj(int paramInt1, int paramInt2)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("id", this.appBoxId);
        localJSONObject.put("compId", paramInt1);
        localJSONObject.put("adUnitId", this.adUnitId);
        localJSONObject.put("errCode", paramInt2);
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        QMLog.e("SDK_MiniAppBox", "getResultObj e:", localThrowable);
        return localJSONObject;
      }
      finally {}
      return localJSONObject;
    }
    
    private boolean initAdParam(int paramInt1, int paramInt2)
    {
      String str3 = LoginManager.getInstance().getAccount();
      if (TextUtils.isEmpty(this.appId))
      {
        QMLog.e("SDK_MiniAppBox", "TextUtils.isEmpty(appid)");
        return false;
      }
      int i;
      label60:
      int j;
      label122:
      Object localObject3;
      label131:
      Object localObject1;
      label174:
      String str1;
      label192:
      String str2;
      Object localObject2;
      if (AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation == 2)
      {
        i = 1;
        if (i == 0) {
          break label291;
        }
        i = 90;
        QMLog.i("SDK_MiniAppBox", "handle initAdParam appId = " + this.appId + "， deviceOrient = " + i);
        if ((AppBoxPlugin.this.mMiniAppInfo == null) || (!AppBoxPlugin.this.mMiniAppInfo.isEngineTypeMiniApp())) {
          break label296;
        }
        j = 0;
        if (j != 0) {
          break label302;
        }
        j = 7;
        localObject3 = AppBoxPlugin.this.mMiniAppInfo;
        if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
          break label488;
        }
        if (((MiniAppInfo)localObject3).launchParam.entryPath == null) {
          break label309;
        }
        localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
        if (((MiniAppInfo)localObject3).launchParam == null) {
          break label317;
        }
        str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
        str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.scene);
        localObject2 = localObject1;
        localObject1 = str2;
      }
      for (;;)
      {
        label233:
        String str4;
        if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null))
        {
          str2 = ((MiniAppInfo)localObject3).via;
          str4 = AdUtil.getSpAdGdtCookie(j);
          WnsConfig.getConfig("QZoneSetting", "MiniGameShareRate", 53);
          if (this.mActivity == null) {
            break label333;
          }
        }
        label291:
        label296:
        label302:
        label309:
        label317:
        label333:
        for (localObject3 = (Activity)this.mActivity.get();; localObject3 = null)
        {
          if (localObject3 != null) {
            break label339;
          }
          QMLog.e("SDK_MiniAppBox", "activity is null");
          return false;
          i = 0;
          break;
          i = 0;
          break label60;
          j = 1;
          break label122;
          j = 8;
          break label131;
          localObject1 = "";
          break label174;
          str1 = "";
          break label192;
          str2 = "";
          break label233;
        }
        label339:
        Bundle localBundle = new Bundle();
        localBundle.putString(AdProxy.KEY_ACCOUNT, str3);
        localBundle.putInt(AdProxy.KEY_AD_TYPE, j);
        localBundle.putInt(AdProxy.KEY_ORIENTATION, i);
        localBundle.putString(AdProxy.KEY_GDT_COOKIE, str4);
        localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject2);
        localBundle.putString(AdProxy.KEY_REPORT_DATA, str1);
        localBundle.putString(AdProxy.KEY_REFER, (String)localObject1);
        localBundle.putString(AdProxy.KEY_VIA, str2);
        this.adBox = ((AdProxy)ProxyManager.get(AdProxy.class)).createBoxAdView((Activity)localObject3, this.appId, this.adUnitId, new AppBoxPlugin.MiniAppBox.2(this, paramInt1, paramInt2), localBundle);
        if (this.adBox != null)
        {
          this.adBox.loadAD();
          return true;
        }
        this.mIsRequestingAd = false;
        return false;
        label488:
        localObject1 = "";
        str1 = "";
        localObject2 = "";
      }
    }
    
    boolean destroy()
    {
      if (this.adBox != null)
      {
        this.adBox.destroy();
        this.adBox = null;
      }
      return true;
    }
    
    boolean load(int paramInt1, int paramInt2)
    {
      boolean bool = true;
      if (!this.mIsRequestingAd)
      {
        this.mIsRequestingAd = true;
        bool = initAdParam(paramInt1, paramInt2);
      }
      return bool;
    }
    
    void setActivity(Activity paramActivity)
    {
      this.mActivity = new WeakReference(paramActivity);
    }
    
    void setJsService(IJsService paramIJsService)
    {
      this.mJsService = paramIJsService;
    }
    
    boolean show(int paramInt1, int paramInt2)
    {
      if (this.adBox == null) {
        return false;
      }
      AppBrandTask.runTaskOnUiThread(new AppBoxPlugin.MiniAppBox.1(this, paramInt1, paramInt2));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppBoxPlugin
 * JD-Core Version:    0.7.0.1
 */