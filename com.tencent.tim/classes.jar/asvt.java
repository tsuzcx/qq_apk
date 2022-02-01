import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.NavigationJsPlugin.1;
import com.tencent.qqmini.proxyimpl.NavigationJsPlugin.3;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import org.json.JSONObject;

@JsPlugin
public class asvt
  extends BaseJsPlugin
{
  private WnsConfigProxy a = (WnsConfigProxy)AppLoaderFactory.g().getProxyManager().get(WnsConfigProxy.class);
  
  private boolean navigateBackMiniApp(String paramString1, String paramString2)
    throws Exception
  {
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramString2 = this.mMiniAppContext.getAttachedActivity();
    MiniAppController.navigateBackMiniApp(paramString2, paramString1, localLaunchParam, new asvv(this, paramString2));
    return true;
  }
  
  private void savaShowInfoToDB(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationJsPlugin.3(this, paramMiniAppInfo), 32, null, true);
  }
  
  @JsEvent({"exitMiniProgram"})
  public void exitMiniProgram(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NavigationJsPlugin.1(this, this.mMiniAppContext.getAttachedActivity()));
    paramRequestEvent.ok();
  }
  
  @JsEvent({"navigateBackMiniProgram"})
  public void navigateBackMiniProgram(RequestEvent paramRequestEvent)
  {
    try
    {
      String str1 = new JSONObject(paramRequestEvent.jsonParams).optString("extraData");
      String str2 = this.mApkgInfo.mMiniAppInfo.launchParam.fromMiniAppId;
      if ((!TextUtils.isEmpty(str2)) && (navigateBackMiniApp(str2, str1)))
      {
        paramRequestEvent.ok();
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniProgram get en Error", localThrowable);
      if (paramRequestEvent != null) {
        paramRequestEvent.fail();
      }
    }
  }
  
  /* Error */
  @JsEvent({"navigateToMiniProgram"})
  public void navigateToMiniProgram(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: sipush 2106
    //   3: istore_3
    //   4: new 121	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 124	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   12: invokespecial 127	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: invokestatic 174	com/tencent/mobileqq/mini/app/MiniAppStateManager:getInstance	()Lcom/tencent/mobileqq/mini/app/MiniAppStateManager;
    //   20: ldc 176
    //   22: invokevirtual 180	com/tencent/mobileqq/mini/app/MiniAppStateManager:notifyChange	(Ljava/lang/Object;)V
    //   25: aload 4
    //   27: ifnull +253 -> 280
    //   30: aload 4
    //   32: ldc 182
    //   34: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 7
    //   39: aload 4
    //   41: invokestatic 188	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   44: astore 10
    //   46: aload_0
    //   47: getfield 66	asvt:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   50: invokeinterface 192 1 0
    //   55: astore 8
    //   57: aload 8
    //   59: getfield 143	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   62: getfield 196	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   65: astore 9
    //   67: aload 10
    //   69: ifnull +288 -> 357
    //   72: aload_0
    //   73: getfield 31	asvt:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy;
    //   76: ldc 198
    //   78: ldc 200
    //   80: invokevirtual 204	com/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 6
    //   85: aload 6
    //   87: astore 5
    //   89: aload 6
    //   91: invokestatic 209	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   94: ifeq +7 -> 101
    //   97: ldc 211
    //   99: astore 5
    //   101: aload_0
    //   102: getfield 66	asvt:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   105: invokeinterface 192 1 0
    //   110: ifnull +192 -> 302
    //   113: aload 5
    //   115: aload_0
    //   116: getfield 66	asvt:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   119: invokeinterface 192 1 0
    //   124: getfield 212	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   127: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +172 -> 302
    //   133: sipush 2077
    //   136: istore_2
    //   137: aload 4
    //   139: ldc 129
    //   141: invokevirtual 222	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   144: astore 5
    //   146: aload 5
    //   148: ifnull +169 -> 317
    //   151: aload 5
    //   153: invokevirtual 225	org/json/JSONObject:toString	()Ljava/lang/String;
    //   156: astore 5
    //   158: new 38	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   161: dup
    //   162: invokespecial 39	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   165: astore 6
    //   167: aload 6
    //   169: iload_2
    //   170: putfield 47	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   173: aload 6
    //   175: aload 8
    //   177: getfield 143	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   180: getfield 226	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   183: putfield 62	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   186: aload 6
    //   188: aload 5
    //   190: putfield 50	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   193: aload 9
    //   195: ifnull +13 -> 208
    //   198: aload 6
    //   200: aload 9
    //   202: invokestatic 231	asvo:a	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   205: putfield 234	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   208: aload 4
    //   210: invokestatic 188	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   213: astore 5
    //   215: aload_0
    //   216: getfield 66	asvt:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   219: invokeinterface 72 1 0
    //   224: aload 5
    //   226: aload 6
    //   228: invokestatic 238	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;)V
    //   231: aload_1
    //   232: invokevirtual 115	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   235: pop
    //   236: ldc 159
    //   238: iconst_1
    //   239: new 240	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   246: ldc 243
    //   248: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 10
    //   253: invokevirtual 248	com/tencent/mobileqq/mini/apkg/MiniAppInfo:toString	()Ljava/lang/String;
    //   256: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload 10
    //   267: getfield 256	com/tencent/mobileqq/mini/apkg/MiniAppInfo:verType	I
    //   270: iconst_3
    //   271: if_icmpne +9 -> 280
    //   274: aload_0
    //   275: aload 5
    //   277: invokespecial 258	asvt:savaShowInfoToDB	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   280: return
    //   281: astore 4
    //   283: ldc 159
    //   285: iconst_1
    //   286: aload 4
    //   288: invokevirtual 261	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   291: aload 4
    //   293: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: aconst_null
    //   297: astore 4
    //   299: goto -282 -> 17
    //   302: aload 8
    //   304: invokevirtual 265	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   307: ifeq +315 -> 622
    //   310: sipush 2106
    //   313: istore_2
    //   314: goto +305 -> 619
    //   317: ldc_w 267
    //   320: astore 5
    //   322: goto -164 -> 158
    //   325: astore 5
    //   327: ldc 159
    //   329: iconst_1
    //   330: new 240	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 269
    //   340: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 5
    //   345: invokestatic 275	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   348: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 4
    //   359: ldc_w 279
    //   362: invokevirtual 283	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   365: istore_2
    //   366: aload 4
    //   368: ldc_w 284
    //   371: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore 10
    //   376: iload_2
    //   377: ifne +206 -> 583
    //   380: aload 4
    //   382: ldc_w 286
    //   385: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: astore 11
    //   390: aload 4
    //   392: ldc_w 288
    //   395: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 6
    //   400: aload 4
    //   402: ldc 129
    //   404: invokevirtual 222	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   407: astore 4
    //   409: aload 4
    //   411: ifnull +157 -> 568
    //   414: aload 4
    //   416: invokevirtual 225	org/json/JSONObject:toString	()Ljava/lang/String;
    //   419: astore 4
    //   421: aload 6
    //   423: astore 5
    //   425: aload_0
    //   426: getfield 289	asvt:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   429: ifnull +28 -> 457
    //   432: aload 6
    //   434: astore 5
    //   436: ldc_w 291
    //   439: aload_0
    //   440: getfield 289	asvt:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   443: invokevirtual 294	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:getVerTypeStr	()Ljava/lang/String;
    //   446: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   449: ifeq +8 -> 457
    //   452: ldc_w 291
    //   455: astore 5
    //   457: new 38	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   460: dup
    //   461: invokespecial 39	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   464: astore 6
    //   466: aload 8
    //   468: invokevirtual 265	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   471: ifeq +105 -> 576
    //   474: iload_3
    //   475: istore_2
    //   476: aload 6
    //   478: iload_2
    //   479: putfield 47	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   482: aload 6
    //   484: aload 11
    //   486: putfield 297	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   489: aload 6
    //   491: aload 4
    //   493: putfield 50	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   496: aload 6
    //   498: aload 8
    //   500: getfield 143	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   503: getfield 226	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   506: putfield 62	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   509: aload 6
    //   511: aload 9
    //   513: invokestatic 300	asvo:b	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   516: putfield 234	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   519: aload 6
    //   521: aload 5
    //   523: putfield 302	com/tencent/mobileqq/mini/sdk/LaunchParam:envVersion	Ljava/lang/String;
    //   526: aload 6
    //   528: aload 7
    //   530: putfield 304	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/lang/String;
    //   533: aload_0
    //   534: getfield 66	asvt:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   537: invokeinterface 72 1 0
    //   542: aload 10
    //   544: aload 11
    //   546: aload 5
    //   548: aload 6
    //   550: new 306	asvu
    //   553: dup
    //   554: aload_0
    //   555: aload_1
    //   556: invokespecial 309	asvu:<init>	(Lasvt;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V
    //   559: invokestatic 313	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   562: aload_1
    //   563: invokevirtual 115	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   566: pop
    //   567: return
    //   568: ldc_w 267
    //   571: astore 4
    //   573: goto -152 -> 421
    //   576: sipush 1037
    //   579: istore_2
    //   580: goto -104 -> 476
    //   583: iload_2
    //   584: iconst_1
    //   585: if_icmpne -305 -> 280
    //   588: aload_0
    //   589: getfield 66	asvt:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   592: invokeinterface 72 1 0
    //   597: aload 10
    //   599: aload 4
    //   601: invokestatic 319	com/tencent/mobileqq/microapp/ext/GameProxy:startGameByMiniApp	(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;)Z
    //   604: ifeq +9 -> 613
    //   607: aload_1
    //   608: invokevirtual 115	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   611: pop
    //   612: return
    //   613: aload_1
    //   614: invokevirtual 157	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   617: pop
    //   618: return
    //   619: goto -482 -> 137
    //   622: sipush 1037
    //   625: istore_2
    //   626: goto -7 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	asvt
    //   0	629	1	paramRequestEvent	RequestEvent
    //   136	490	2	i	int
    //   3	472	3	j	int
    //   15	194	4	localJSONObject	JSONObject
    //   281	11	4	localThrowable	Throwable
    //   297	303	4	localObject1	java.lang.Object
    //   87	234	5	localObject2	java.lang.Object
    //   325	19	5	localException	Exception
    //   423	124	5	localObject3	java.lang.Object
    //   83	466	6	localObject4	java.lang.Object
    //   37	492	7	str1	String
    //   55	444	8	localMiniAppInfo	com.tencent.qqmini.sdk.launcher.model.MiniAppInfo
    //   65	447	9	localEntryModel	com.tencent.qqmini.sdk.launcher.model.EntryModel
    //   44	554	10	localObject5	java.lang.Object
    //   388	157	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	17	281	java/lang/Throwable
    //   72	85	325	java/lang/Exception
    //   89	97	325	java/lang/Exception
    //   101	133	325	java/lang/Exception
    //   137	146	325	java/lang/Exception
    //   151	158	325	java/lang/Exception
    //   158	193	325	java/lang/Exception
    //   198	208	325	java/lang/Exception
    //   208	280	325	java/lang/Exception
    //   302	310	325	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvt
 * JD-Core Version:    0.7.0.1
 */