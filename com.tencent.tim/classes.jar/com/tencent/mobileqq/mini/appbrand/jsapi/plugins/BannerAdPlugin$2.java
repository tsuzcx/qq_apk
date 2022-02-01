package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BannerAdPosInfo;

class BannerAdPlugin$2
  implements MiniAppCmdInterface
{
  BannerAdPlugin$2(BannerAdPlugin paramBannerAdPlugin, JsRuntime paramJsRuntime, BannerAdPosInfo paramBannerAdPosInfo) {}
  
  /* Error */
  public void onCmdListener(boolean paramBoolean, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_2
    //   3: ifnonnull +33 -> 36
    //   6: aload_0
    //   7: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   10: aload_0
    //   11: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   14: sipush 1000
    //   17: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   20: sipush 1000
    //   23: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 52	java/lang/String
    //   32: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   35: return
    //   36: iload_1
    //   37: ifeq +682 -> 719
    //   40: ldc 58
    //   42: iconst_1
    //   43: ldc 60
    //   45: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_2
    //   49: ldc 68
    //   51: invokevirtual 74	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   54: istore 4
    //   56: aload_2
    //   57: ldc 76
    //   59: invokevirtual 80	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 82	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   65: astore_2
    //   66: aload_2
    //   67: getfield 86	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   70: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   73: astore 5
    //   75: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +39 -> 117
    //   81: ldc 58
    //   83: iconst_2
    //   84: new 97	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   91: ldc 100
    //   93: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload 4
    //   98: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc 109
    //   103: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 5
    //   108: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: iload 4
    //   119: sipush 1000
    //   122: if_icmpne +11 -> 133
    //   125: aload 5
    //   127: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifeq +64 -> 194
    //   133: aload_0
    //   134: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   137: aload_0
    //   138: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   141: sipush 1000
    //   144: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   147: sipush 1000
    //   150: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 52	java/lang/String
    //   159: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   162: return
    //   163: astore_2
    //   164: aload_0
    //   165: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   168: aload_0
    //   169: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   172: sipush 1003
    //   175: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   178: sipush 1003
    //   181: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 52	java/lang/String
    //   190: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   193: return
    //   194: aload_0
    //   195: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   198: aload_0
    //   199: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   202: aload 5
    //   204: invokestatic 122	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$200	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   207: astore 6
    //   209: aload 6
    //   211: ifnull +465 -> 676
    //   214: aload_0
    //   215: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   218: getfield 126	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   221: getfield 132	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   224: instanceof 134
    //   227: ifeq +287 -> 514
    //   230: new 136	com/tencent/gdtad/aditem/GdtAd
    //   233: dup
    //   234: aload 6
    //   236: invokespecial 139	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   239: astore 7
    //   241: invokestatic 145	tgh:a	()Ltgh;
    //   244: aload 7
    //   246: invokevirtual 148	tgh:a	(Lcom/tencent/gdtad/aditem/GdtAd;)V
    //   249: aload_0
    //   250: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   253: getfield 126	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   256: getfield 132	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   259: checkcast 134	com/tencent/mobileqq/minigame/ui/GameActivity
    //   262: aload_0
    //   263: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   266: aload 6
    //   268: invokevirtual 152	com/tencent/mobileqq/minigame/ui/GameActivity:createBannerAd	(Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)Z
    //   271: istore_1
    //   272: iload_1
    //   273: ifeq +344 -> 617
    //   276: new 70	org/json/JSONObject
    //   279: dup
    //   280: invokespecial 153	org/json/JSONObject:<init>	()V
    //   283: astore 7
    //   285: aload 7
    //   287: ldc 155
    //   289: ldc 157
    //   291: invokevirtual 161	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload 7
    //   297: ldc 163
    //   299: aload_0
    //   300: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   303: getfield 169	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdUnitId	Ljava/lang/String;
    //   306: invokevirtual 161	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload 7
    //   312: ldc 171
    //   314: aload_0
    //   315: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   318: getfield 175	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdLeft	I
    //   321: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload 7
    //   327: ldc 180
    //   329: aload_0
    //   330: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   333: getfield 183	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdTop	I
    //   336: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   339: pop
    //   340: aload 7
    //   342: ldc 185
    //   344: aload_0
    //   345: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   348: getfield 188	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdWidth	I
    //   351: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   354: pop
    //   355: aload 7
    //   357: ldc 190
    //   359: aload_0
    //   360: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   363: getfield 193	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdHeight	I
    //   366: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   369: pop
    //   370: aload 7
    //   372: ldc 195
    //   374: aload_0
    //   375: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   378: getfield 198	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealWidth	I
    //   381: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   384: pop
    //   385: aload 7
    //   387: ldc 200
    //   389: aload_0
    //   390: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   393: getfield 203	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealHeight	I
    //   396: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   399: pop
    //   400: aload_0
    //   401: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   404: aload_0
    //   405: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   408: aload 7
    //   410: ldc 205
    //   412: invokestatic 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$300	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   415: new 70	org/json/JSONObject
    //   418: dup
    //   419: invokespecial 153	org/json/JSONObject:<init>	()V
    //   422: astore 7
    //   424: aload 7
    //   426: ldc 155
    //   428: ldc 211
    //   430: invokevirtual 161	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload 7
    //   436: ldc 185
    //   438: aload_0
    //   439: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   442: getfield 198	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealWidth	I
    //   445: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload 7
    //   451: ldc 190
    //   453: aload_0
    //   454: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   457: getfield 203	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealHeight	I
    //   460: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   463: pop
    //   464: aload_0
    //   465: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   468: aload_0
    //   469: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   472: aload 7
    //   474: ldc 205
    //   476: invokestatic 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$300	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   479: aload 6
    //   481: getfield 217	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   484: ifnull +30 -> 514
    //   487: aload_0
    //   488: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   491: getfield 126	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   494: getfield 221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   497: getfield 227	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   500: aload 6
    //   502: getfield 217	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   505: getfield 232	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   508: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   511: invokestatic 238	asts:de	(Landroid/content/Context;Ljava/lang/String;)V
    //   514: aload_0
    //   515: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   518: aload 5
    //   520: iconst_0
    //   521: invokestatic 242	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$400	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Ljava/lang/String;I)V
    //   524: aload_2
    //   525: ifnull -490 -> 35
    //   528: aload_2
    //   529: getfield 246	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   532: ifnull -497 -> 35
    //   535: aload_2
    //   536: getfield 246	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   539: invokevirtual 252	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   542: ifle -507 -> 35
    //   545: aload_2
    //   546: getfield 256	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   549: invokevirtual 261	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   552: ldc2_w 262
    //   555: lcmp
    //   556: ifne -521 -> 35
    //   559: iload_3
    //   560: aload_2
    //   561: getfield 246	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   564: invokevirtual 252	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   567: if_icmpge -532 -> 35
    //   570: new 265	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   573: dup
    //   574: aload_2
    //   575: getfield 246	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   578: iload_3
    //   579: invokevirtual 268	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   582: checkcast 270	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   585: invokestatic 276	com/tencent/mobileqq/mini/apkg/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   588: invokespecial 279	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   591: invokestatic 285	com/tencent/mobileqq/minigame/gpkg/GpkgManager:preloadGpkgByConfig	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)V
    //   594: iload_3
    //   595: iconst_1
    //   596: iadd
    //   597: istore_3
    //   598: goto -39 -> 559
    //   601: astore 6
    //   603: ldc 58
    //   605: iconst_1
    //   606: ldc_w 287
    //   609: aload 6
    //   611: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: goto -100 -> 514
    //   617: aload_0
    //   618: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   621: aload_0
    //   622: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   625: sipush 1003
    //   628: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   631: sipush 1003
    //   634: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   637: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   640: checkcast 52	java/lang/String
    //   643: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   646: ldc 58
    //   648: iconst_1
    //   649: new 97	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   656: ldc_w 293
    //   659: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload 5
    //   664: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: goto -159 -> 514
    //   676: ldc 58
    //   678: iconst_1
    //   679: ldc_w 295
    //   682: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: goto -171 -> 514
    //   688: astore_2
    //   689: ldc 58
    //   691: iconst_1
    //   692: new 97	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   699: ldc_w 299
    //   702: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload_2
    //   706: invokevirtual 302	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   709: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: return
    //   719: aload_2
    //   720: ifnull +38 -> 758
    //   723: aload_2
    //   724: ldc 68
    //   726: invokevirtual 74	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   729: istore_3
    //   730: aload_0
    //   731: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   734: aload_0
    //   735: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   738: iload_3
    //   739: ldc_w 303
    //   742: invokestatic 309	acfp:m	(I)Ljava/lang/String;
    //   745: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   748: ldc 58
    //   750: iconst_1
    //   751: ldc_w 311
    //   754: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: return
    //   758: aload_0
    //   759: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   762: aload_0
    //   763: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   766: sipush 1003
    //   769: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   772: sipush 1003
    //   775: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   778: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   781: checkcast 52	java/lang/String
    //   784: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   787: goto -39 -> 748
    //   790: astore_2
    //   791: aload_0
    //   792: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   795: aload_0
    //   796: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   799: sipush 1003
    //   802: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   805: sipush 1003
    //   808: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   811: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   814: checkcast 52	java/lang/String
    //   817: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   820: goto -72 -> 748
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	this	2
    //   0	823	1	paramBoolean	boolean
    //   0	823	2	paramJSONObject	org.json.JSONObject
    //   1	738	3	i	int
    //   54	69	4	j	int
    //   73	590	5	str	java.lang.String
    //   207	294	6	localAdInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo
    //   601	9	6	localJSONException	org.json.JSONException
    //   239	234	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	117	163	org/json/JSONException
    //   125	133	163	org/json/JSONException
    //   133	162	163	org/json/JSONException
    //   194	209	163	org/json/JSONException
    //   214	272	163	org/json/JSONException
    //   514	524	163	org/json/JSONException
    //   528	559	163	org/json/JSONException
    //   559	594	163	org/json/JSONException
    //   603	614	163	org/json/JSONException
    //   617	673	163	org/json/JSONException
    //   676	685	163	org/json/JSONException
    //   689	718	163	org/json/JSONException
    //   276	514	601	org/json/JSONException
    //   528	559	688	java/lang/Throwable
    //   559	594	688	java/lang/Throwable
    //   723	748	790	java/lang/Exception
    //   758	787	790	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */