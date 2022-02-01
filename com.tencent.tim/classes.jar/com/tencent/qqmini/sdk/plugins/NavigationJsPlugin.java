package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniTranslucentFragmentActivity;
import org.json.JSONObject;

public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NavigationJsPlugin";
  private static final int navigateBackByAPPInfo = WnsConfig.getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  private NavigationProxy navigationProxy = (NavigationProxy)ProxyManager.get(NavigationProxy.class);
  
  private static void navigateBackMiniApp(Activity paramActivity, String paramString, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mini_appid", paramString);
    if (paramLaunchParam != null)
    {
      paramLaunchParam.fromBackToMiniApp = 1;
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
    }
    localIntent.putExtra("mini_receiver", paramResultReceiver);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniTranslucentFragmentActivity.start(paramActivity, localIntent, MiniAppInfoLoadingFragment.class);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void navigateBackMiniApp(MiniAppInfo paramMiniAppInfo, String paramString, ResultReceiver paramResultReceiver)
  {
    MiniAppInfo localMiniAppInfo = MiniAppInfo.copy(paramMiniAppInfo);
    localMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
    localMiniAppInfo.launchParam.scene = 1038;
    localMiniAppInfo.launchParam.navigateExtData = paramString;
    localMiniAppInfo.launchParam.fromBackToMiniApp = 1;
    localMiniAppInfo.launchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    MiniSDK.startMiniApp(this.mMiniAppContext.getAttachedActivity(), localMiniAppInfo, new Bundle(), paramResultReceiver);
  }
  
  private boolean navigateBackMiniApp(String paramString1, String paramString2)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    navigateBackMiniApp(this.mMiniAppContext.getAttachedActivity(), paramString1, localLaunchParam, new NavigationJsPlugin.4(this, new Handler(Looper.getMainLooper())));
    return true;
  }
  
  @JsEvent({"exitMiniProgram"})
  public void exitMiniProgram(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NavigationJsPlugin.5(this, this.mMiniAppContext.getAttachedActivity()));
    paramRequestEvent.ok();
  }
  
  @JsEvent({"navigateBackMiniProgram"})
  public void navigateBackMiniProgram(RequestEvent paramRequestEvent)
  {
    new JSONObject();
    Object localObject2;
    String str;
    do
    {
      do
      {
        try
        {
          Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
          if (navigateBackByAPPInfo == 0) {
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("extraData");
              localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppId;
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (navigateBackMiniApp((String)localObject2, (String)localObject1))) {
                paramRequestEvent.ok();
              }
            }
            else
            {
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QMLog.e("NavigationJsPlugin", localThrowable.getMessage(), localThrowable);
            str = null;
          }
          paramRequestEvent.fail();
          return;
        }
      } while ((navigateBackByAPPInfo != 1) || (str == null));
      str = str.optString("extraData");
      localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppInfo;
    } while (localObject2 == null);
    navigateBackMiniApp((MiniAppInfo)localObject2, str, new NavigationJsPlugin.3(this, new Handler(Looper.getMainLooper()), paramRequestEvent));
  }
  
  /* Error */
  @JsEvent({"navigateToMiniProgram"})
  public void navigateToMiniProgram(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: sipush 2001
    //   3: istore_3
    //   4: new 185	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 189	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   12: invokespecial 192	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   21: invokevirtual 234	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:onBeforeNavigateToMiniProgram	()V
    //   24: aload 4
    //   26: ifnull +213 -> 239
    //   29: aload 4
    //   31: ldc 236
    //   33: invokevirtual 198	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 6
    //   38: aload 4
    //   40: ldc 238
    //   42: invokevirtual 242	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   45: invokestatic 246	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   48: astore 7
    //   50: aload_0
    //   51: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   54: getfield 104	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   57: getfield 250	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   60: astore 8
    //   62: aload 7
    //   64: ifnull +252 -> 316
    //   67: ldc 16
    //   69: ldc 252
    //   71: ldc 254
    //   73: invokestatic 257	com/tencent/qqmini/sdk/core/utils/WnsConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: aload_0
    //   77: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   80: getfield 107	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   83: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +172 -> 258
    //   89: sipush 2077
    //   92: istore_2
    //   93: aload 4
    //   95: ldc 194
    //   97: invokevirtual 242	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   100: astore 9
    //   102: aload 9
    //   104: ifnull +171 -> 275
    //   107: aload 9
    //   109: invokevirtual 266	org/json/JSONObject:toString	()Ljava/lang/String;
    //   112: astore 5
    //   114: new 64	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   117: dup
    //   118: invokespecial 140	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   121: astore 10
    //   123: aload 10
    //   125: iload_2
    //   126: putfield 113	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   129: aload 10
    //   131: aload_0
    //   132: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   135: getfield 104	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   138: getfield 110	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   141: putfield 123	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   144: aload 10
    //   146: aload 5
    //   148: putfield 116	com/tencent/qqmini/sdk/launcher/model/LaunchParam:navigateExtData	Ljava/lang/String;
    //   151: aload 8
    //   153: ifnull +10 -> 163
    //   156: aload 10
    //   158: aload 8
    //   160: putfield 250	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   163: aload 7
    //   165: getfield 104	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   168: aload 10
    //   170: invokevirtual 270	com/tencent/qqmini/sdk/launcher/model/LaunchParam:clone	(Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;)V
    //   173: aload_0
    //   174: getfield 46	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   177: invokeinterface 129 1 0
    //   182: aload 7
    //   184: invokestatic 273	com/tencent/qqmini/sdk/MiniSDK:startMiniApp	(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V
    //   187: aload_1
    //   188: invokevirtual 179	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   191: pop
    //   192: ldc 8
    //   194: new 275	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 278
    //   204: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 7
    //   209: invokevirtual 283	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:toString	()Ljava/lang/String;
    //   212: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 288	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 7
    //   223: getfield 291	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:verType	I
    //   226: iconst_3
    //   227: if_icmpne +12 -> 239
    //   230: aload_0
    //   231: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   234: aload 9
    //   236: invokevirtual 295	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:onAfterLaunchByAppInfo	(Lorg/json/JSONObject;)V
    //   239: return
    //   240: astore 4
    //   242: ldc 8
    //   244: ldc_w 297
    //   247: aload 4
    //   249: invokestatic 215	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: aconst_null
    //   253: astore 4
    //   255: goto -238 -> 17
    //   258: aload_0
    //   259: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   262: invokevirtual 301	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   265: ifeq +399 -> 664
    //   268: sipush 2001
    //   271: istore_2
    //   272: goto +389 -> 661
    //   275: ldc_w 297
    //   278: astore 5
    //   280: goto -166 -> 114
    //   283: astore 5
    //   285: ldc 8
    //   287: new 275	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 303
    //   297: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 5
    //   302: invokevirtual 304	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: aload 5
    //   313: invokestatic 215	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload 4
    //   318: ldc_w 306
    //   321: invokevirtual 310	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   324: istore_2
    //   325: aload 4
    //   327: ldc_w 311
    //   330: invokevirtual 198	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   333: astore 5
    //   335: iload_2
    //   336: ifne +233 -> 569
    //   339: aload 4
    //   341: ldc_w 313
    //   344: invokevirtual 198	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 7
    //   349: aload 4
    //   351: ldc_w 315
    //   354: invokevirtual 198	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   357: astore 8
    //   359: aload 4
    //   361: ldc 194
    //   363: invokevirtual 242	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   366: astore 4
    //   368: aload 4
    //   370: ifnull +184 -> 554
    //   373: aload 4
    //   375: invokevirtual 266	org/json/JSONObject:toString	()Ljava/lang/String;
    //   378: astore 4
    //   380: new 64	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   383: dup
    //   384: invokespecial 140	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   387: astore 9
    //   389: aload_0
    //   390: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   393: invokevirtual 301	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   396: ifeq +166 -> 562
    //   399: aload 9
    //   401: iload_3
    //   402: putfield 113	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   405: aload 9
    //   407: aload 7
    //   409: putfield 318	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryPath	Ljava/lang/String;
    //   412: aload 9
    //   414: aload 4
    //   416: putfield 116	com/tencent/qqmini/sdk/launcher/model/LaunchParam:navigateExtData	Ljava/lang/String;
    //   419: aload 9
    //   421: aload_0
    //   422: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   425: getfield 104	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   428: getfield 110	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   431: putfield 123	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   434: aload 9
    //   436: aload_0
    //   437: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   440: getfield 104	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   443: getfield 250	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   446: putfield 250	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   449: aload 9
    //   451: aload 8
    //   453: putfield 320	com/tencent/qqmini/sdk/launcher/model/LaunchParam:envVersion	Ljava/lang/String;
    //   456: aload_0
    //   457: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   460: invokevirtual 323	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isSpecialMiniApp	()Z
    //   463: ifne +34 -> 497
    //   466: getstatic 26	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigateBackByAPPInfo	I
    //   469: iconst_1
    //   470: if_icmpne +27 -> 497
    //   473: aload 9
    //   475: aload_0
    //   476: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   479: invokevirtual 326	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:getVerTypeStr	()Ljava/lang/String;
    //   482: putfield 329	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromEnvVersion	Ljava/lang/String;
    //   485: aload 9
    //   487: aload_0
    //   488: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   491: invokestatic 100	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:copy	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   494: putfield 221	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   497: aload 9
    //   499: aload 6
    //   501: putfield 331	com/tencent/qqmini/sdk/launcher/model/LaunchParam:reportData	Ljava/lang/String;
    //   504: aload_0
    //   505: getfield 46	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   508: invokeinterface 129 1 0
    //   513: aload 5
    //   515: aload 9
    //   517: getfield 113	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   520: aload 7
    //   522: aload 8
    //   524: aload 9
    //   526: new 333	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$1
    //   529: dup
    //   530: aload_0
    //   531: new 144	android/os/Handler
    //   534: dup
    //   535: invokestatic 150	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   538: invokespecial 153	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   541: aload_1
    //   542: invokespecial 334	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$1:<init>	(Lcom/tencent/qqmini/sdk/plugins/NavigationJsPlugin;Landroid/os/Handler;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V
    //   545: invokestatic 337	com/tencent/qqmini/sdk/MiniSDK:startMiniApp	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;Landroid/os/ResultReceiver;)V
    //   548: aload_1
    //   549: invokevirtual 179	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   552: pop
    //   553: return
    //   554: ldc_w 297
    //   557: astore 4
    //   559: goto -179 -> 380
    //   562: sipush 1037
    //   565: istore_3
    //   566: goto -167 -> 399
    //   569: new 64	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   572: dup
    //   573: invokespecial 140	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   576: astore 6
    //   578: aload_0
    //   579: getfield 120	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   582: invokevirtual 301	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   585: ifeq +63 -> 648
    //   588: aload 6
    //   590: iload_3
    //   591: putfield 113	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   594: aload_0
    //   595: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   598: iload_2
    //   599: aload_0
    //   600: getfield 46	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   603: invokeinterface 129 1 0
    //   608: aload 5
    //   610: aload 6
    //   612: getfield 113	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   615: aload 4
    //   617: new 339	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$2
    //   620: dup
    //   621: aload_0
    //   622: new 144	android/os/Handler
    //   625: dup
    //   626: invokestatic 150	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   629: invokespecial 153	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   632: aload_1
    //   633: invokespecial 340	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$2:<init>	(Lcom/tencent/qqmini/sdk/plugins/NavigationJsPlugin;Landroid/os/Handler;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V
    //   636: invokevirtual 344	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:launchByAppType	(ILandroid/app/Activity;Ljava/lang/String;ILorg/json/JSONObject;Landroid/os/ResultReceiver;)Z
    //   639: ifeq +16 -> 655
    //   642: aload_1
    //   643: invokevirtual 179	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   646: pop
    //   647: return
    //   648: sipush 1037
    //   651: istore_3
    //   652: goto -64 -> 588
    //   655: aload_1
    //   656: invokevirtual 218	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   659: pop
    //   660: return
    //   661: goto -568 -> 93
    //   664: sipush 1037
    //   667: istore_2
    //   668: goto -7 -> 661
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	NavigationJsPlugin
    //   0	671	1	paramRequestEvent	RequestEvent
    //   92	576	2	i	int
    //   3	649	3	j	int
    //   15	79	4	localJSONObject	JSONObject
    //   240	8	4	localThrowable	Throwable
    //   253	363	4	localObject1	Object
    //   112	167	5	str1	String
    //   283	29	5	localException	java.lang.Exception
    //   333	276	5	str2	String
    //   36	575	6	localObject2	Object
    //   48	473	7	localObject3	Object
    //   60	463	8	localObject4	Object
    //   100	425	9	localObject5	Object
    //   121	48	10	localLaunchParam	LaunchParam
    // Exception table:
    //   from	to	target	type
    //   4	17	240	java/lang/Throwable
    //   67	89	283	java/lang/Exception
    //   93	102	283	java/lang/Exception
    //   107	114	283	java/lang/Exception
    //   114	151	283	java/lang/Exception
    //   156	163	283	java/lang/Exception
    //   163	239	283	java/lang/Exception
    //   258	268	283	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */