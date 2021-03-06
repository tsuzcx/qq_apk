package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aeay;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.AuthorizeCenter.AuthorizeInfo;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OtherJsPlugin
  extends BaseJsPlugin
{
  private static final String ACTION_RETURN_ADDRESS_TO_MINIAPP = "action_return_address_to_miniapp";
  public static final String EVENT_ADD_SHORTCUR = "saveAppToDesktop";
  private static final String KEY_MINIAPP_ADDRESS_INFO = "key_miniapp_address_info";
  public static final String MA_PERMISSION_BROADCAST = "com.tencent.tim.msg.permission.pushnotify";
  public static final String MINI_APP_SCAN_DATA_RESULT = "com.tencent.mobileqq.mini.out.plugins.scanResultData";
  public static final String MINI_APP_SCAN_RESULT = "com.tencent.mobileqq.mini.out.plugins.scanResultAction";
  public static final String MINI_APP_SCAN_RESULT_TYPE = "com.tencent.mobileqq.mini.out.plugins.scanResultType";
  private static final Set<String> S_EVENT_MAP = new OtherJsPlugin.1();
  private static final String TAG = OtherJsPlugin.class.getSimpleName();
  private BroadcastReceiver addressReceiver = new OtherJsPlugin.2(this);
  private int mCallBackId = -1;
  private JsRuntime mJsRunTime;
  private boolean receiverRegistered;
  private BroadcastReceiver scanResultReceiver;
  
  private void addColorSign(boolean paramBoolean, JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    if ((this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.isLimitedAccessApp()))
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
      return;
    }
    aeay localaeay;
    if (isMiniGameRuntime())
    {
      if ((this.jsPluginEngine.appBrandRuntime.activity == null) || (!(this.jsPluginEngine.appBrandRuntime.activity instanceof GameActivity))) {
        break label297;
      }
      localaeay = ((GameActivity)this.jsPluginEngine.appBrandRuntime.activity).getColorNoteController();
    }
    for (;;)
    {
      if (localaeay != null)
      {
        if (!localaeay.isColorNoteExist())
        {
          if (localaeay.canAddColorNote())
          {
            if (paramBoolean)
            {
              AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.6(this, localaeay, paramJsRuntime, paramString, paramInt));
              return;
              if ((this.jsPluginEngine.appBrandRuntime != null) && ((this.jsPluginEngine.appBrandRuntime.activity instanceof AppBrandUI))) {
                localaeay = ((AppBrandUI)this.jsPluginEngine.appBrandRuntime.activity).getColorNoteController();
              }
            }
            else
            {
              AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.7(this, localaeay));
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, null, paramInt);
            }
          }
          else
          {
            AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.8(this, localaeay));
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
          }
        }
        else
        {
          AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.9(this));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, null, paramInt);
        }
      }
      else
      {
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
        return;
      }
      label297:
      localaeay = null;
    }
  }
  
  private void callbackChooseAddress(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "openAddress", paramString, paramInt);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(TAG, 1, "openAddress" + " error.", paramString);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "openAddress", null, paramInt);
    }
  }
  
  private void callbackSettingEvent(AuthorizeCenter paramAuthorizeCenter, String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    if (paramAuthorizeCenter == null) {
      return;
    }
    Object localObject = paramAuthorizeCenter.getAuthorizeList(6);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        paramAuthorizeCenter = new JSONObject();
        localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        AuthorizeCenter.AuthorizeInfo localAuthorizeInfo = (AuthorizeCenter.AuthorizeInfo)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scope", localAuthorizeInfo.scopeName);
        int i;
        if (localAuthorizeInfo.authFlag == 2)
        {
          i = 1;
          localJSONObject.put("state", i);
          localJSONArray.put(localJSONObject);
        }
        else
        {
          i = 0;
        }
      }
      catch (JSONException paramAuthorizeCenter)
      {
        QLog.e(TAG, 1, paramString + " error.", paramAuthorizeCenter);
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
        return;
      }
    }
    paramAuthorizeCenter.put("authSetting", localJSONArray);
    this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, paramAuthorizeCenter, paramInt);
  }
  
  private void callbackSettingEvent(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    callbackSettingEvent(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getAuthorizeCenter(this.jsPluginEngine.appBrandRuntime.appId), paramString, paramJsRuntime, paramInt);
  }
  
  /* Error */
  private void enterQRCode(BaseActivity paramBaseActivity, String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: invokestatic 293	aakj:a	(Lcom/tencent/mobileqq/app/BaseActivity;)Z
    //   7: ifne +21 -> 28
    //   10: aload_0
    //   11: getfield 110	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   14: aload_3
    //   15: ldc_w 295
    //   18: aconst_null
    //   19: ldc_w 297
    //   22: iload 4
    //   24: invokevirtual 300	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   27: return
    //   28: new 302	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 303	java/util/ArrayList:<init>	()V
    //   35: pop
    //   36: aload_2
    //   37: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +204 -> 244
    //   43: new 190	org/json/JSONObject
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 193	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +13 -> 66
    //   56: aload_2
    //   57: ldc_w 311
    //   60: iconst_0
    //   61: invokevirtual 315	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   64: istore 5
    //   66: new 317	android/content/Intent
    //   69: dup
    //   70: aload_1
    //   71: ldc_w 319
    //   74: invokespecial 322	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   77: astore_2
    //   78: aload_2
    //   79: ldc_w 324
    //   82: aload_1
    //   83: ldc_w 325
    //   86: invokevirtual 331	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   89: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   92: pop
    //   93: aload_2
    //   94: ldc_w 337
    //   97: aload_1
    //   98: ldc_w 325
    //   101: invokevirtual 331	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   104: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   107: pop
    //   108: aload_2
    //   109: ldc_w 339
    //   112: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   115: invokevirtual 348	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   118: pop
    //   119: aload_2
    //   120: ldc_w 350
    //   123: ldc_w 352
    //   126: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   129: pop
    //   130: iload 5
    //   132: ifeq +12 -> 144
    //   135: aload_2
    //   136: ldc_w 354
    //   139: iconst_1
    //   140: invokevirtual 357	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   143: pop
    //   144: aload_2
    //   145: ldc_w 358
    //   148: invokevirtual 362	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   151: pop
    //   152: aload_0
    //   153: getfield 102	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   156: ifnull +16 -> 172
    //   159: aload_1
    //   160: aload_0
    //   161: getfield 102	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   164: invokevirtual 366	com/tencent/mobileqq/app/BaseActivity:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 102	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   172: aload_0
    //   173: new 368	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin$10
    //   176: dup
    //   177: aload_0
    //   178: aload_3
    //   179: iload 4
    //   181: invokespecial 371	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   184: putfield 102	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   187: new 373	android/content/IntentFilter
    //   190: dup
    //   191: ldc 26
    //   193: invokespecial 374	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   196: astore_3
    //   197: aload_1
    //   198: aload_0
    //   199: getfield 102	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   202: aload_3
    //   203: ldc 20
    //   205: aconst_null
    //   206: invokevirtual 378	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   209: pop
    //   210: aload_1
    //   211: aload_2
    //   212: invokevirtual 382	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   215: return
    //   216: astore_2
    //   217: getstatic 52	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:TAG	Ljava/lang/String;
    //   220: iconst_1
    //   221: new 197	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 384
    //   231: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_2
    //   235: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aconst_null
    //   245: astore_2
    //   246: goto -194 -> 52
    //   249: astore 6
    //   251: getstatic 52	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:TAG	Ljava/lang/String;
    //   254: iconst_1
    //   255: new 197	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 392
    //   265: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 6
    //   270: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: goto -112 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	OtherJsPlugin
    //   0	282	1	paramBaseActivity	BaseActivity
    //   0	282	2	paramString	String
    //   0	282	3	paramJsRuntime	JsRuntime
    //   0	282	4	paramInt	int
    //   1	130	5	bool	boolean
    //   249	20	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	52	216	java/lang/Exception
    //   159	167	249	java/lang/Exception
  }
  
  private void insertColorNote(aeay paramaeay)
  {
    if (isMiniGameRuntime()) {
      if ((this.jsPluginEngine.appBrandRuntime.activity != null) && ((this.jsPluginEngine.appBrandRuntime.activity instanceof GameActivity))) {
        ((GameActivity)this.jsPluginEngine.appBrandRuntime.activity).setColorNoteWithOutMoveTaskToBackThisTime();
      }
    }
    for (;;)
    {
      paramaeay.insertColorNote();
      return;
      if ((this.jsPluginEngine.appBrandRuntime != null) && ((this.jsPluginEngine.appBrandRuntime.activity instanceof AppBrandUI))) {
        ((AppBrandUI)this.jsPluginEngine.appBrandRuntime.activity).setColorNoteWithOutMoveTaskToBackThisTime();
      }
    }
  }
  
  private void launchChooseAddressH5(String paramString)
  {
    Intent localIntent = new Intent(this.jsPluginEngine.getActivityContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jsPluginEngine.getActivityContext().startActivity(localIntent);
  }
  
  private void openSettingActivity(Activity paramActivity, ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null)
    {
      QLog.e(TAG, 1, "openSettingActivity, appInfo:" + paramApkgInfo);
      return;
    }
    PermissionSettingFragment.launchForResult(paramActivity, paramApkgInfo.appId, paramApkgInfo.apkgName, 5);
  }
  
  private void registerChooseAddressReceiver()
  {
    if (this.receiverRegistered) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_return_address_to_miniapp");
    AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().registerReceiver(this.addressReceiver, localIntentFilter);
    this.receiverRegistered = true;
  }
  
  private void unregisterChooseAddressReceiver()
  {
    if ((!this.receiverRegistered) || (this.addressReceiver == null)) {
      return;
    }
    AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().unregisterReceiver(this.addressReceiver);
    this.receiverRegistered = false;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d(TAG, 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    this.mJsRunTime = paramJsRuntime;
    this.mCallBackId = paramInt;
    if ("saveAppToDesktop".equals(paramString1)) {}
    do
    {
      for (;;)
      {
        try
        {
          if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.isLimitedAccessApp())
          {
            QLog.e(TAG, 1, "app is limited access");
            paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
            return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
          }
          ShortcutUtils.addShortcut(this.jsPluginEngine.getActivityContext(), this.jsPluginEngine.appBrandRuntime.getApkgInfo(), new OtherJsPlugin.3(this, paramString1, paramJsRuntime, paramInt));
          continue;
        }
        catch (Throwable localThrowable)
        {
          QLog.e(TAG, 1, localThrowable, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
          continue;
        }
        if ("openSetting".equals(paramString1))
        {
          MiniAppController.getInstance().setActivityResultListener(new OtherJsPlugin.4(this, paramString1, paramJsRuntime, paramInt));
          openSettingActivity(this.jsPluginEngine.getActivityContext(), this.jsPluginEngine.appBrandRuntime.getApkgInfo());
        }
        else
        {
          Object localObject;
          if ("getSetting".equals(paramString1))
          {
            localObject = AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getAuthorizeCenter(this.jsPluginEngine.appBrandRuntime.appId);
            if (localObject == null)
            {
              QLog.e(TAG, 1, "getSetting, but authorizeCenter is null?!");
              return "";
            }
            if (((AuthorizeCenter)localObject).isAuthorizeSynchronized()) {
              callbackSettingEvent((AuthorizeCenter)localObject, paramString1, paramJsRuntime, paramInt);
            } else {
              MiniAppCmdUtil.getInstance().getAuthList(null, getAppId(), new OtherJsPlugin.5(this, (AuthorizeCenter)localObject, paramString1, paramJsRuntime, paramInt));
            }
          }
          else if ("scanCode".equals(paramString1))
          {
            enterQRCode(this.jsPluginEngine.getActivityContext(), paramString2, paramJsRuntime, paramInt);
          }
          else if ("addColorSign".equals(paramString1))
          {
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            addColorSign(false, paramJsRuntime, paramString1, paramInt);
          }
          else if ("addColorSignDirectly".equals(paramString1))
          {
            addColorSign(true, paramJsRuntime, paramString1, paramInt);
          }
          else
          {
            if (!"openAddress".equals(paramString1)) {
              break;
            }
            localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappChooseAddressUrl", "https://i.qianbao.qq.com/profile/address/choose.html");
            registerChooseAddressReceiver();
            launchChooseAddressH5((String)localObject);
          }
        }
      }
    } while (!"isColorSignExistSync".equals(paramString1));
    new JSONObject();
    if (isMiniGameRuntime())
    {
      if ((this.jsPluginEngine.appBrandRuntime.activity == null) || (!(this.jsPluginEngine.appBrandRuntime.activity instanceof GameActivity))) {
        break label627;
      }
      paramString2 = ((GameActivity)this.jsPluginEngine.appBrandRuntime.activity).getColorNoteController();
    }
    for (;;)
    {
      if ((paramString2 != null) && (paramString2.isColorNoteExist()))
      {
        return ApiUtil.wrapCallbackOk(paramString1, null).toString();
        if ((this.jsPluginEngine.appBrandRuntime != null) && ((this.jsPluginEngine.appBrandRuntime.activity instanceof AppBrandUI))) {
          paramString2 = ((AppBrandUI)this.jsPluginEngine.appBrandRuntime.activity).getColorNoteController();
        }
      }
      else
      {
        return ApiUtil.wrapCallbackFail(paramString1, null).toString();
      }
      label627:
      paramString2 = null;
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    unregisterChooseAddressReceiver();
    super.onDestroy();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public static abstract interface AddColorSignListener
  {
    public abstract void onAddColorSign(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin
 * JD-Core Version:    0.7.0.1
 */