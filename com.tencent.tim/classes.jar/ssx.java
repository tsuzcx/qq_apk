import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ssx
  extends WebViewPlugin
{
  public static final String aGn = acfp.m(2131707232);
  public static final String aGo = acfp.m(2131707230);
  protected static final int[] eD = { 2131721476, 2131701256 };
  protected static final int[] eE = { 2130844520, 2130844516 };
  AtomicBoolean ac = new AtomicBoolean(false);
  protected auuw b;
  private HashMap<String, String> fY = new HashMap();
  skj mClient = null;
  private Client.b mOnRemoteResp = new stc(this);
  
  public ssx()
  {
    this.mPluginNameSpace = "hotchat";
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: ldc 90
    //   8: iconst_2
    //   9: new 92	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   16: ldc 95
    //   18: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload 4
    //   23: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 101
    //   28: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc 70
    //   46: aload_3
    //   47: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   50: ifeq +235 -> 285
    //   53: ldc 117
    //   55: aload 4
    //   57: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +159 -> 219
    //   63: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 90
    //   71: iconst_2
    //   72: new 92	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   79: ldc 117
    //   81: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 5
    //   86: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload 5
    //   97: ifnull +2334 -> 2431
    //   100: aload 5
    //   102: arraylength
    //   103: ifle +2328 -> 2431
    //   106: new 129	org/json/JSONObject
    //   109: dup
    //   110: aload 5
    //   112: iconst_0
    //   113: aaload
    //   114: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: ldc 134
    //   119: invokevirtual 138	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   127: invokevirtual 148	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +2299 -> 2431
    //   135: aload_2
    //   136: instanceof 150
    //   139: ifeq +2292 -> 2431
    //   142: aload_2
    //   143: checkcast 150	com/tencent/mobileqq/activity/NearbyActivity
    //   146: invokevirtual 153	com/tencent/mobileqq/activity/NearbyActivity:a	()Lcom/tencent/mobileqq/fragment/HotChatFragment;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +2280 -> 2431
    //   154: aload_3
    //   155: instanceof 155
    //   158: ifeq +2273 -> 2431
    //   161: aload_1
    //   162: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +14 -> 179
    //   168: aload_3
    //   169: checkcast 155	com/tencent/mobileqq/fragment/HotChatFragment
    //   172: aconst_null
    //   173: invokevirtual 165	com/tencent/mobileqq/fragment/HotChatFragment:H	(Landroid/view/View$OnClickListener;)V
    //   176: goto +2255 -> 2431
    //   179: aload_3
    //   180: checkcast 155	com/tencent/mobileqq/fragment/HotChatFragment
    //   183: new 167	ssy
    //   186: dup
    //   187: aload_0
    //   188: aload_1
    //   189: aload_2
    //   190: invokespecial 170	ssy:<init>	(Lssx;Ljava/lang/String;Landroid/app/Activity;)V
    //   193: invokevirtual 165	com/tencent/mobileqq/fragment/HotChatFragment:H	(Landroid/view/View$OnClickListener;)V
    //   196: goto +2235 -> 2431
    //   199: astore_1
    //   200: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +2228 -> 2431
    //   206: ldc 90
    //   208: iconst_2
    //   209: aload_1
    //   210: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   213: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: goto +2215 -> 2431
    //   219: ldc 175
    //   221: aload 4
    //   223: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   226: ifeq +30 -> 256
    //   229: aload 5
    //   231: ifnull +23 -> 254
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +17 -> 254
    //   240: aload_0
    //   241: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   244: invokevirtual 148	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   247: aload 5
    //   249: iconst_0
    //   250: aaload
    //   251: invokestatic 181	com/tencent/mobileqq/dating/NearbyTransitActivity:bv	(Landroid/content/Context;Ljava/lang/String;)V
    //   254: iconst_1
    //   255: ireturn
    //   256: ldc 183
    //   258: aload 4
    //   260: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +24 -> 287
    //   266: aload_0
    //   267: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   270: invokevirtual 148	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   273: new 185	android/content/Intent
    //   276: dup
    //   277: ldc 187
    //   279: invokespecial 188	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   282: invokevirtual 194	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   285: iconst_0
    //   286: ireturn
    //   287: ldc 196
    //   289: aload 4
    //   291: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +48 -> 342
    //   297: aload 5
    //   299: iconst_0
    //   300: aaload
    //   301: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne -19 -> 285
    //   307: new 185	android/content/Intent
    //   310: dup
    //   311: ldc 198
    //   313: invokespecial 188	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   316: astore_1
    //   317: aload_1
    //   318: ldc 200
    //   320: aload 5
    //   322: iconst_0
    //   323: aaload
    //   324: invokevirtual 204	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   327: pop
    //   328: aload_0
    //   329: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   332: invokevirtual 148	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   335: aload_1
    //   336: invokevirtual 194	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   339: goto -54 -> 285
    //   342: ldc 206
    //   344: aload 4
    //   346: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   349: ifeq +23 -> 372
    //   352: invokestatic 212	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   355: new 214	com/tencent/biz/webviewplugin/HotchatPlugin$2
    //   358: dup
    //   359: aload_0
    //   360: aload 5
    //   362: invokespecial 217	com/tencent/biz/webviewplugin/HotchatPlugin$2:<init>	(Lssx;[Ljava/lang/String;)V
    //   365: invokevirtual 223	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   368: pop
    //   369: goto -84 -> 285
    //   372: ldc 225
    //   374: aload 4
    //   376: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   379: ifeq +144 -> 523
    //   382: aload_0
    //   383: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   386: invokevirtual 228	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   389: invokevirtual 233	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   392: ldc 235
    //   394: iconst_0
    //   395: invokestatic 241	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: invokestatic 247	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: checkcast 237	java/lang/Boolean
    //   404: invokevirtual 250	java/lang/Boolean:booleanValue	()Z
    //   407: istore 12
    //   409: aconst_null
    //   410: astore_2
    //   411: aload_2
    //   412: astore_1
    //   413: aload 5
    //   415: ifnull +28 -> 443
    //   418: aload_2
    //   419: astore_1
    //   420: aload 5
    //   422: arraylength
    //   423: ifle +20 -> 443
    //   426: new 129	org/json/JSONObject
    //   429: dup
    //   430: aload 5
    //   432: iconst_0
    //   433: aaload
    //   434: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   437: ldc 134
    //   439: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   442: astore_1
    //   443: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +28 -> 474
    //   449: ldc 90
    //   451: iconst_2
    //   452: new 92	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   459: ldc 255
    //   461: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_1
    //   465: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: aload_1
    //   475: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   478: ifne -193 -> 285
    //   481: iload 12
    //   483: ifeq +33 -> 516
    //   486: ldc_w 257
    //   489: astore_2
    //   490: aload_0
    //   491: aload_1
    //   492: iconst_1
    //   493: anewarray 111	java/lang/String
    //   496: dup
    //   497: iconst_0
    //   498: aload_2
    //   499: aastore
    //   500: invokevirtual 261	ssx:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   503: goto -218 -> 285
    //   506: astore_1
    //   507: aload_1
    //   508: invokevirtual 264	org/json/JSONException:printStackTrace	()V
    //   511: aload_2
    //   512: astore_1
    //   513: goto -70 -> 443
    //   516: ldc_w 266
    //   519: astore_2
    //   520: goto -30 -> 490
    //   523: ldc_w 268
    //   526: aload 4
    //   528: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   531: ifeq +281 -> 812
    //   534: aconst_null
    //   535: astore 14
    //   537: aconst_null
    //   538: astore_3
    //   539: aconst_null
    //   540: astore 4
    //   542: aconst_null
    //   543: astore 15
    //   545: iconst_0
    //   546: istore 13
    //   548: iload 13
    //   550: istore 12
    //   552: aload 15
    //   554: astore_2
    //   555: aload_3
    //   556: astore_1
    //   557: aload 5
    //   559: ifnull +101 -> 660
    //   562: iload 13
    //   564: istore 12
    //   566: aload 15
    //   568: astore_2
    //   569: aload_3
    //   570: astore_1
    //   571: aload 5
    //   573: arraylength
    //   574: ifle +86 -> 660
    //   577: aload 4
    //   579: astore_2
    //   580: aload 14
    //   582: astore_3
    //   583: new 129	org/json/JSONObject
    //   586: dup
    //   587: aload 5
    //   589: iconst_0
    //   590: aaload
    //   591: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   594: astore 5
    //   596: aload 4
    //   598: astore_2
    //   599: aload 14
    //   601: astore_3
    //   602: aload 5
    //   604: ldc 134
    //   606: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   609: astore_1
    //   610: aload 4
    //   612: astore_2
    //   613: aload_1
    //   614: astore_3
    //   615: aload 5
    //   617: ldc_w 270
    //   620: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   623: astore 4
    //   625: aload 4
    //   627: invokestatic 275	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   630: astore_2
    //   631: aload_2
    //   632: astore 4
    //   634: aload 4
    //   636: astore_2
    //   637: aload_1
    //   638: astore_3
    //   639: aload 5
    //   641: ldc_w 277
    //   644: invokevirtual 281	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   647: istore 6
    //   649: iload 6
    //   651: ifne +136 -> 787
    //   654: iconst_0
    //   655: istore 12
    //   657: aload 4
    //   659: astore_2
    //   660: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +49 -> 712
    //   666: ldc 90
    //   668: iconst_2
    //   669: new 92	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   676: ldc 255
    //   678: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_1
    //   682: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc_w 283
    //   688: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload_2
    //   692: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc_w 285
    //   698: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: iload 12
    //   703: invokevirtual 288	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   706: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload_2
    //   713: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   716: ifne -431 -> 285
    //   719: aload_1
    //   720: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   723: ifne -438 -> 285
    //   726: new 290	android/os/Bundle
    //   729: dup
    //   730: invokespecial 291	android/os/Bundle:<init>	()V
    //   733: astore_3
    //   734: aload_3
    //   735: ldc_w 293
    //   738: aload_2
    //   739: invokevirtual 297	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   742: aload_3
    //   743: ldc_w 299
    //   746: ldc_w 268
    //   749: invokevirtual 297	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   752: aload_3
    //   753: ldc_w 301
    //   756: iload 12
    //   758: invokevirtual 305	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   761: ldc_w 307
    //   764: aload_1
    //   765: aload_0
    //   766: getfield 68	ssx:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   769: getfield 313	com/tencent/mobileqq/emosm/Client$b:key	I
    //   772: aload_3
    //   773: invokestatic 318	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   776: astore_1
    //   777: invokestatic 323	afjy:a	()Lafjy;
    //   780: aload_1
    //   781: invokevirtual 327	afjy:cq	(Landroid/os/Bundle;)V
    //   784: goto -499 -> 285
    //   787: iconst_1
    //   788: istore 12
    //   790: aload 4
    //   792: astore_2
    //   793: goto -133 -> 660
    //   796: astore 4
    //   798: aload_3
    //   799: astore_1
    //   800: aload 4
    //   802: invokevirtual 264	org/json/JSONException:printStackTrace	()V
    //   805: iload 13
    //   807: istore 12
    //   809: goto -149 -> 660
    //   812: ldc_w 329
    //   815: aload 4
    //   817: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   820: ifeq +281 -> 1101
    //   823: aload_0
    //   824: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   827: invokevirtual 228	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   830: astore 16
    //   832: aconst_null
    //   833: astore 14
    //   835: aconst_null
    //   836: astore_3
    //   837: aconst_null
    //   838: astore 15
    //   840: aconst_null
    //   841: astore 4
    //   843: aload 15
    //   845: astore_1
    //   846: aload 14
    //   848: astore_2
    //   849: aload 5
    //   851: ifnull +211 -> 1062
    //   854: aload 15
    //   856: astore_1
    //   857: aload 14
    //   859: astore_2
    //   860: aload 5
    //   862: arraylength
    //   863: ifle +199 -> 1062
    //   866: aload 4
    //   868: astore_1
    //   869: aload_3
    //   870: astore_2
    //   871: new 129	org/json/JSONObject
    //   874: dup
    //   875: aload 5
    //   877: iconst_0
    //   878: aaload
    //   879: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   882: astore 14
    //   884: aload 4
    //   886: astore_1
    //   887: aload_3
    //   888: astore_2
    //   889: aload 14
    //   891: ldc_w 331
    //   894: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   897: astore_3
    //   898: aload 4
    //   900: astore_1
    //   901: aload_3
    //   902: astore_2
    //   903: aload 14
    //   905: ldc_w 333
    //   908: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   911: astore 4
    //   913: aload 4
    //   915: astore_1
    //   916: aload_3
    //   917: astore_2
    //   918: aload 14
    //   920: ldc_w 335
    //   923: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   926: astore 14
    //   928: aload_3
    //   929: astore_2
    //   930: aload 4
    //   932: astore_1
    //   933: aload 14
    //   935: astore_3
    //   936: aload 16
    //   938: ifnull +56 -> 994
    //   941: aload_1
    //   942: ifnull +52 -> 994
    //   945: aload_2
    //   946: ifnull +48 -> 994
    //   949: ldc_w 337
    //   952: aload_2
    //   953: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   956: ifeq +113 -> 1069
    //   959: aload 16
    //   961: invokevirtual 340	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   964: ldc_w 342
    //   967: aload_1
    //   968: invokestatic 345	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   971: pop
    //   972: aload 16
    //   974: invokevirtual 340	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   977: ldc_w 347
    //   980: ldc_w 349
    //   983: aload_3
    //   984: invokevirtual 352	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   987: invokestatic 241	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   990: invokestatic 345	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   993: pop
    //   994: invokestatic 355	ajrk:isColorLevel	()Z
    //   997: ifeq -712 -> 285
    //   1000: aload 5
    //   1002: ifnull +9 -> 1011
    //   1005: aload 5
    //   1007: arraylength
    //   1008: ifne +84 -> 1092
    //   1011: ldc_w 357
    //   1014: astore 4
    //   1016: ldc 90
    //   1018: bipush 6
    //   1020: anewarray 359	java/lang/Object
    //   1023: dup
    //   1024: iconst_0
    //   1025: ldc_w 329
    //   1028: aastore
    //   1029: dup
    //   1030: iconst_1
    //   1031: aload 16
    //   1033: aastore
    //   1034: dup
    //   1035: iconst_2
    //   1036: aload_2
    //   1037: aastore
    //   1038: dup
    //   1039: iconst_3
    //   1040: aload_1
    //   1041: aastore
    //   1042: dup
    //   1043: iconst_4
    //   1044: aload_3
    //   1045: aastore
    //   1046: dup
    //   1047: iconst_5
    //   1048: aload 4
    //   1050: aastore
    //   1051: invokestatic 362	ajrk:m	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1054: goto -769 -> 285
    //   1057: astore_3
    //   1058: aload_3
    //   1059: invokevirtual 363	java/lang/Exception:printStackTrace	()V
    //   1062: ldc_w 349
    //   1065: astore_3
    //   1066: goto -130 -> 936
    //   1069: aload_1
    //   1070: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1073: ifne -79 -> 994
    //   1076: aload 16
    //   1078: invokevirtual 340	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1081: ldc_w 365
    //   1084: aload_1
    //   1085: invokestatic 345	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   1088: pop
    //   1089: goto -95 -> 994
    //   1092: aload 5
    //   1094: iconst_0
    //   1095: aaload
    //   1096: astore 4
    //   1098: goto -82 -> 1016
    //   1101: ldc_w 367
    //   1104: aload 4
    //   1106: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1109: ifeq +337 -> 1446
    //   1112: aload_0
    //   1113: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1116: invokevirtual 228	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   1119: astore 15
    //   1121: iconst_0
    //   1122: istore 8
    //   1124: iconst_0
    //   1125: istore 10
    //   1127: iconst_0
    //   1128: istore 9
    //   1130: iconst_0
    //   1131: istore 11
    //   1133: aconst_null
    //   1134: astore_3
    //   1135: aconst_null
    //   1136: astore 14
    //   1138: aconst_null
    //   1139: astore 4
    //   1141: iload 10
    //   1143: istore 6
    //   1145: iload 11
    //   1147: istore 7
    //   1149: aload 14
    //   1151: astore_1
    //   1152: aload 4
    //   1154: astore_2
    //   1155: aload 5
    //   1157: ifnull +128 -> 1285
    //   1160: iload 10
    //   1162: istore 6
    //   1164: iload 11
    //   1166: istore 7
    //   1168: aload 14
    //   1170: astore_1
    //   1171: aload 4
    //   1173: astore_2
    //   1174: aload 5
    //   1176: arraylength
    //   1177: ifle +108 -> 1285
    //   1180: iload 8
    //   1182: istore 6
    //   1184: iload 9
    //   1186: istore 7
    //   1188: aload_3
    //   1189: astore_1
    //   1190: new 129	org/json/JSONObject
    //   1193: dup
    //   1194: aload 5
    //   1196: iconst_0
    //   1197: aaload
    //   1198: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1201: astore_2
    //   1202: iload 8
    //   1204: istore 6
    //   1206: iload 9
    //   1208: istore 7
    //   1210: aload_3
    //   1211: astore_1
    //   1212: aload_2
    //   1213: ldc_w 369
    //   1216: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1219: astore_3
    //   1220: iload 8
    //   1222: istore 6
    //   1224: iload 9
    //   1226: istore 7
    //   1228: aload_3
    //   1229: astore_1
    //   1230: aload_2
    //   1231: ldc_w 371
    //   1234: invokevirtual 281	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1237: istore 8
    //   1239: iload 8
    //   1241: istore 6
    //   1243: iload 9
    //   1245: istore 7
    //   1247: aload_3
    //   1248: astore_1
    //   1249: aload_2
    //   1250: ldc_w 373
    //   1253: invokevirtual 281	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1256: istore 9
    //   1258: iload 8
    //   1260: istore 6
    //   1262: iload 9
    //   1264: istore 7
    //   1266: aload_3
    //   1267: astore_1
    //   1268: aload_2
    //   1269: ldc 134
    //   1271: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1274: astore_2
    //   1275: aload_3
    //   1276: astore_1
    //   1277: iload 9
    //   1279: istore 7
    //   1281: iload 8
    //   1283: istore 6
    //   1285: aload_1
    //   1286: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1289: ifeq +142 -> 1431
    //   1292: ldc_w 375
    //   1295: astore_3
    //   1296: new 129	org/json/JSONObject
    //   1299: dup
    //   1300: invokespecial 376	org/json/JSONObject:<init>	()V
    //   1303: astore 4
    //   1305: aload 4
    //   1307: ldc_w 378
    //   1310: iconst_m1
    //   1311: invokevirtual 382	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1314: pop
    //   1315: aload 4
    //   1317: ldc_w 384
    //   1320: ldc_w 375
    //   1323: invokevirtual 387	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1326: pop
    //   1327: aload 4
    //   1329: ldc_w 389
    //   1332: ldc_w 391
    //   1335: invokevirtual 387	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1338: pop
    //   1339: aload 4
    //   1341: invokevirtual 392	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1344: astore 4
    //   1346: aload 4
    //   1348: astore_3
    //   1349: aload_0
    //   1350: aload_2
    //   1351: iconst_1
    //   1352: anewarray 111	java/lang/String
    //   1355: dup
    //   1356: iconst_0
    //   1357: aload_3
    //   1358: aastore
    //   1359: invokevirtual 261	ssx:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1362: invokestatic 355	ajrk:isColorLevel	()Z
    //   1365: ifeq -1080 -> 285
    //   1368: ldc 90
    //   1370: iconst_5
    //   1371: anewarray 359	java/lang/Object
    //   1374: dup
    //   1375: iconst_0
    //   1376: ldc_w 367
    //   1379: aastore
    //   1380: dup
    //   1381: iconst_1
    //   1382: iload 6
    //   1384: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1387: aastore
    //   1388: dup
    //   1389: iconst_2
    //   1390: iload 7
    //   1392: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1395: aastore
    //   1396: dup
    //   1397: iconst_3
    //   1398: aload_1
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_4
    //   1402: aload_2
    //   1403: aastore
    //   1404: invokestatic 362	ajrk:m	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1407: goto -1122 -> 285
    //   1410: astore_2
    //   1411: aload_2
    //   1412: invokevirtual 363	java/lang/Exception:printStackTrace	()V
    //   1415: aload 4
    //   1417: astore_2
    //   1418: goto -133 -> 1285
    //   1421: astore 4
    //   1423: aload 4
    //   1425: invokevirtual 363	java/lang/Exception:printStackTrace	()V
    //   1428: goto -79 -> 1349
    //   1431: aload 15
    //   1433: iload 6
    //   1435: iload 7
    //   1437: aload_1
    //   1438: aload_0
    //   1439: aload_2
    //   1440: invokestatic 402	ajpi:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V
    //   1443: goto -81 -> 1362
    //   1446: ldc_w 404
    //   1449: aload 4
    //   1451: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1454: ifeq +127 -> 1581
    //   1457: aload 5
    //   1459: ifnull +974 -> 2433
    //   1462: aload 5
    //   1464: arraylength
    //   1465: ifle +968 -> 2433
    //   1468: new 129	org/json/JSONObject
    //   1471: dup
    //   1472: aload 5
    //   1474: iconst_0
    //   1475: aaload
    //   1476: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1479: ldc 134
    //   1481: invokevirtual 138	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1484: astore_1
    //   1485: aload_0
    //   1486: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1489: invokevirtual 148	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1492: astore_2
    //   1493: aload_2
    //   1494: ifnull +939 -> 2433
    //   1497: aload_2
    //   1498: instanceof 150
    //   1501: ifeq +932 -> 2433
    //   1504: aload_2
    //   1505: checkcast 150	com/tencent/mobileqq/activity/NearbyActivity
    //   1508: invokevirtual 153	com/tencent/mobileqq/activity/NearbyActivity:a	()Lcom/tencent/mobileqq/fragment/HotChatFragment;
    //   1511: astore_3
    //   1512: aload_3
    //   1513: ifnull +920 -> 2433
    //   1516: aload_3
    //   1517: instanceof 155
    //   1520: ifeq +913 -> 2433
    //   1523: aload_1
    //   1524: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1527: ifeq +14 -> 1541
    //   1530: aload_3
    //   1531: checkcast 155	com/tencent/mobileqq/fragment/HotChatFragment
    //   1534: aconst_null
    //   1535: invokevirtual 165	com/tencent/mobileqq/fragment/HotChatFragment:H	(Landroid/view/View$OnClickListener;)V
    //   1538: goto +895 -> 2433
    //   1541: aload_3
    //   1542: checkcast 155	com/tencent/mobileqq/fragment/HotChatFragment
    //   1545: new 406	ssz
    //   1548: dup
    //   1549: aload_0
    //   1550: aload_1
    //   1551: aload_2
    //   1552: invokespecial 407	ssz:<init>	(Lssx;Ljava/lang/String;Landroid/app/Activity;)V
    //   1555: invokevirtual 165	com/tencent/mobileqq/fragment/HotChatFragment:H	(Landroid/view/View$OnClickListener;)V
    //   1558: goto +875 -> 2433
    //   1561: astore_1
    //   1562: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1565: ifeq +868 -> 2433
    //   1568: ldc 90
    //   1570: iconst_2
    //   1571: aload_1
    //   1572: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1575: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1578: goto +855 -> 2433
    //   1581: ldc_w 409
    //   1584: aload 4
    //   1586: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1589: ifeq +169 -> 1758
    //   1592: aload 5
    //   1594: ifnull -1309 -> 285
    //   1597: aload 5
    //   1599: arraylength
    //   1600: ifle -1315 -> 285
    //   1603: new 129	org/json/JSONObject
    //   1606: dup
    //   1607: aload 5
    //   1609: iconst_0
    //   1610: aaload
    //   1611: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1614: astore_1
    //   1615: aload_1
    //   1616: ldc_w 411
    //   1619: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1622: astore_2
    //   1623: aload_1
    //   1624: ldc_w 413
    //   1627: invokevirtual 417	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1630: astore_3
    //   1631: iconst_0
    //   1632: istore 6
    //   1634: iload 6
    //   1636: aload_3
    //   1637: invokevirtual 423	org/json/JSONArray:length	()I
    //   1640: if_icmpge -1355 -> 285
    //   1643: aload_3
    //   1644: iload 6
    //   1646: invokevirtual 427	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1649: checkcast 129	org/json/JSONObject
    //   1652: astore 4
    //   1654: aload 4
    //   1656: ldc_w 429
    //   1659: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1662: astore 5
    //   1664: aload 4
    //   1666: ldc_w 431
    //   1669: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1672: astore_1
    //   1673: aload 4
    //   1675: ldc_w 433
    //   1678: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1681: astore 4
    //   1683: aload_1
    //   1684: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1687: ifeq +741 -> 2428
    //   1690: aload 5
    //   1692: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1695: ifne +733 -> 2428
    //   1698: aload_0
    //   1699: getfield 52	ssx:fY	Ljava/util/HashMap;
    //   1702: aload 5
    //   1704: invokevirtual 436	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1707: checkcast 111	java/lang/String
    //   1710: astore_1
    //   1711: aload_1
    //   1712: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1715: ifne +14 -> 1729
    //   1718: aload_0
    //   1719: getfield 54	ssx:mClient	Lskj;
    //   1722: aload_2
    //   1723: aload_1
    //   1724: aload 4
    //   1726: invokevirtual 442	skj:S	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1729: iload 6
    //   1731: iconst_1
    //   1732: iadd
    //   1733: istore 6
    //   1735: goto -101 -> 1634
    //   1738: astore_1
    //   1739: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1742: ifeq -1457 -> 285
    //   1745: ldc 90
    //   1747: iconst_2
    //   1748: aload_1
    //   1749: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1752: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1755: goto -1470 -> 285
    //   1758: ldc_w 444
    //   1761: aload 4
    //   1763: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1766: ifeq +90 -> 1856
    //   1769: aload 5
    //   1771: ifnull -1486 -> 285
    //   1774: aload 5
    //   1776: arraylength
    //   1777: ifle -1492 -> 285
    //   1780: new 129	org/json/JSONObject
    //   1783: dup
    //   1784: aload 5
    //   1786: iconst_0
    //   1787: aaload
    //   1788: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1791: astore_3
    //   1792: aload_3
    //   1793: ldc 134
    //   1795: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1798: astore_1
    //   1799: aload_3
    //   1800: ldc_w 411
    //   1803: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1806: astore_2
    //   1807: aload_3
    //   1808: ldc_w 446
    //   1811: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1814: astore_3
    //   1815: aload_0
    //   1816: getfield 54	ssx:mClient	Lskj;
    //   1819: aload_2
    //   1820: aload_3
    //   1821: new 448	sta
    //   1824: dup
    //   1825: aload_0
    //   1826: aload_1
    //   1827: invokespecial 451	sta:<init>	(Lssx;Ljava/lang/String;)V
    //   1830: invokevirtual 454	skj:d	(Ljava/lang/String;Ljava/lang/String;Lskj$a;)V
    //   1833: goto -1548 -> 285
    //   1836: astore_1
    //   1837: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1840: ifeq -1555 -> 285
    //   1843: ldc 90
    //   1845: iconst_2
    //   1846: aload_1
    //   1847: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1850: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1853: goto -1568 -> 285
    //   1856: ldc_w 456
    //   1859: aload 4
    //   1861: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1864: ifeq +128 -> 1992
    //   1867: new 458	java/util/ArrayList
    //   1870: dup
    //   1871: invokespecial 459	java/util/ArrayList:<init>	()V
    //   1874: astore_1
    //   1875: aload 5
    //   1877: ifnull -1592 -> 285
    //   1880: aload 5
    //   1882: arraylength
    //   1883: ifle -1598 -> 285
    //   1886: new 129	org/json/JSONObject
    //   1889: dup
    //   1890: aload 5
    //   1892: iconst_0
    //   1893: aaload
    //   1894: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1897: astore_2
    //   1898: aload_2
    //   1899: ldc 134
    //   1901: invokevirtual 138	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1904: pop
    //   1905: aload_2
    //   1906: ldc_w 411
    //   1909: invokevirtual 138	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1912: pop
    //   1913: aload_2
    //   1914: ldc_w 461
    //   1917: invokevirtual 417	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1920: astore_2
    //   1921: iconst_0
    //   1922: istore 6
    //   1924: iload 6
    //   1926: aload_2
    //   1927: invokevirtual 423	org/json/JSONArray:length	()I
    //   1930: if_icmpge +23 -> 1953
    //   1933: aload_1
    //   1934: aload_2
    //   1935: iload 6
    //   1937: invokevirtual 463	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1940: invokevirtual 466	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1943: pop
    //   1944: iload 6
    //   1946: iconst_1
    //   1947: iadd
    //   1948: istore 6
    //   1950: goto -26 -> 1924
    //   1953: aload_0
    //   1954: getfield 54	ssx:mClient	Lskj;
    //   1957: aload_1
    //   1958: new 468	stb
    //   1961: dup
    //   1962: aload_0
    //   1963: invokespecial 469	stb:<init>	(Lssx;)V
    //   1966: invokevirtual 472	skj:a	(Ljava/util/ArrayList;Lskj$a;)V
    //   1969: goto -1684 -> 285
    //   1972: astore_1
    //   1973: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1976: ifeq -1691 -> 285
    //   1979: ldc 90
    //   1981: iconst_2
    //   1982: aload_1
    //   1983: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1986: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1989: goto -1704 -> 285
    //   1992: ldc_w 474
    //   1995: aload 4
    //   1997: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2000: ifeq +62 -> 2062
    //   2003: aload 5
    //   2005: ifnull -1720 -> 285
    //   2008: aload 5
    //   2010: arraylength
    //   2011: ifle -1726 -> 285
    //   2014: new 129	org/json/JSONObject
    //   2017: dup
    //   2018: aload 5
    //   2020: iconst_0
    //   2021: aaload
    //   2022: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2025: ldc_w 411
    //   2028: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2031: pop
    //   2032: aload_0
    //   2033: getfield 52	ssx:fY	Ljava/util/HashMap;
    //   2036: invokevirtual 477	java/util/HashMap:clear	()V
    //   2039: goto -1754 -> 285
    //   2042: astore_1
    //   2043: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2046: ifeq -1761 -> 285
    //   2049: ldc 90
    //   2051: iconst_2
    //   2052: aload_1
    //   2053: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2056: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2059: goto -1774 -> 285
    //   2062: ldc_w 479
    //   2065: aload 4
    //   2067: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2070: ifeq +75 -> 2145
    //   2073: aload_0
    //   2074: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2077: invokevirtual 148	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   2080: astore_1
    //   2081: aload 5
    //   2083: ifnull -1798 -> 285
    //   2086: aload 5
    //   2088: arraylength
    //   2089: ifle -1804 -> 285
    //   2092: new 129	org/json/JSONObject
    //   2095: dup
    //   2096: aload 5
    //   2098: iconst_0
    //   2099: aaload
    //   2100: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2103: ldc_w 411
    //   2106: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2109: astore_2
    //   2110: aload_0
    //   2111: getfield 54	ssx:mClient	Lskj;
    //   2114: aload_2
    //   2115: invokevirtual 482	skj:tl	(Ljava/lang/String;)V
    //   2118: aload_1
    //   2119: invokevirtual 485	android/app/Activity:finish	()V
    //   2122: goto -1837 -> 285
    //   2125: astore_1
    //   2126: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2129: ifeq -1844 -> 285
    //   2132: ldc 90
    //   2134: iconst_2
    //   2135: aload_1
    //   2136: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2139: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2142: goto -1857 -> 285
    //   2145: ldc_w 487
    //   2148: aload 4
    //   2150: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2153: ifeq +235 -> 2388
    //   2156: aload 5
    //   2158: ifnull -1873 -> 285
    //   2161: aload 5
    //   2163: arraylength
    //   2164: ifle -1879 -> 285
    //   2167: new 129	org/json/JSONObject
    //   2170: dup
    //   2171: aload 5
    //   2173: iconst_0
    //   2174: aaload
    //   2175: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2178: astore_1
    //   2179: aload_0
    //   2180: getfield 142	ssx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2183: invokevirtual 148	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   2186: astore_3
    //   2187: aload_1
    //   2188: ldc_w 489
    //   2191: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2194: astore 4
    //   2196: aload_1
    //   2197: ldc_w 431
    //   2200: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2203: astore_2
    //   2204: aload_1
    //   2205: ldc_w 429
    //   2208: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2211: astore 14
    //   2213: aload_1
    //   2214: ldc_w 433
    //   2217: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2220: astore 5
    //   2222: aload_1
    //   2223: ldc_w 411
    //   2226: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2229: astore 15
    //   2231: aload_2
    //   2232: astore_1
    //   2233: aload_2
    //   2234: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2237: ifeq +26 -> 2263
    //   2240: aload_2
    //   2241: astore_1
    //   2242: aload 14
    //   2244: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2247: ifne +16 -> 2263
    //   2250: aload_0
    //   2251: getfield 52	ssx:fY	Ljava/util/HashMap;
    //   2254: aload 14
    //   2256: invokevirtual 436	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2259: checkcast 111	java/lang/String
    //   2262: astore_1
    //   2263: aload_1
    //   2264: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2267: ifeq +19 -> 2286
    //   2270: invokestatic 495	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2273: getstatic 35	ssx:aGo	Ljava/lang/String;
    //   2276: iconst_0
    //   2277: invokestatic 500	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   2280: invokevirtual 504	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   2283: pop
    //   2284: iconst_0
    //   2285: ireturn
    //   2286: aload 4
    //   2288: ldc_w 266
    //   2291: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2294: ifeq +40 -> 2334
    //   2297: aload_0
    //   2298: getfield 54	ssx:mClient	Lskj;
    //   2301: aload 15
    //   2303: aload_1
    //   2304: invokevirtual 507	skj:cI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2307: aload_3
    //   2308: invokevirtual 485	android/app/Activity:finish	()V
    //   2311: goto -2026 -> 285
    //   2314: astore_1
    //   2315: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2318: ifeq -2033 -> 285
    //   2321: ldc 90
    //   2323: iconst_2
    //   2324: aload_1
    //   2325: invokevirtual 173	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2328: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2331: goto -2046 -> 285
    //   2334: aload 4
    //   2336: ldc_w 257
    //   2339: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2342: ifeq +22 -> 2364
    //   2345: aload_0
    //   2346: getfield 54	ssx:mClient	Lskj;
    //   2349: aload 15
    //   2351: aload_1
    //   2352: aload 5
    //   2354: invokevirtual 510	skj:R	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2357: aload_3
    //   2358: invokevirtual 485	android/app/Activity:finish	()V
    //   2361: goto -2076 -> 285
    //   2364: aload 4
    //   2366: ldc_w 512
    //   2369: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2372: ifeq -2087 -> 285
    //   2375: aload_0
    //   2376: getfield 54	ssx:mClient	Lskj;
    //   2379: aload 15
    //   2381: aload_1
    //   2382: invokevirtual 515	skj:cJ	(Ljava/lang/String;Ljava/lang/String;)V
    //   2385: goto -2100 -> 285
    //   2388: ldc 90
    //   2390: iconst_1
    //   2391: new 92	java/lang/StringBuilder
    //   2394: dup
    //   2395: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   2398: ldc_w 517
    //   2401: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2404: aload 4
    //   2406: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2412: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2415: goto -2130 -> 285
    //   2418: astore_3
    //   2419: aload 4
    //   2421: astore_2
    //   2422: aload_3
    //   2423: astore 4
    //   2425: goto -1625 -> 800
    //   2428: goto -717 -> 1711
    //   2431: iconst_1
    //   2432: ireturn
    //   2433: iconst_1
    //   2434: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2435	0	this	ssx
    //   0	2435	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2435	2	paramString1	String
    //   0	2435	3	paramString2	String
    //   0	2435	4	paramString3	String
    //   0	2435	5	paramVarArgs	String[]
    //   647	1302	6	i	int
    //   1147	289	7	j	int
    //   1122	160	8	k	int
    //   1128	150	9	m	int
    //   1125	36	10	n	int
    //   1131	34	11	i1	int
    //   407	401	12	bool1	boolean
    //   546	260	13	bool2	boolean
    //   535	1720	14	localObject1	java.lang.Object
    //   543	1837	15	localObject2	java.lang.Object
    //   830	247	16	localAppInterface	com.tencent.common.app.AppInterface
    // Exception table:
    //   from	to	target	type
    //   106	131	199	org/json/JSONException
    //   135	150	199	org/json/JSONException
    //   154	176	199	org/json/JSONException
    //   179	196	199	org/json/JSONException
    //   426	443	506	org/json/JSONException
    //   583	596	796	org/json/JSONException
    //   602	610	796	org/json/JSONException
    //   615	625	796	org/json/JSONException
    //   639	649	796	org/json/JSONException
    //   871	884	1057	java/lang/Exception
    //   889	898	1057	java/lang/Exception
    //   903	913	1057	java/lang/Exception
    //   918	928	1057	java/lang/Exception
    //   1190	1202	1410	java/lang/Exception
    //   1212	1220	1410	java/lang/Exception
    //   1230	1239	1410	java/lang/Exception
    //   1249	1258	1410	java/lang/Exception
    //   1268	1275	1410	java/lang/Exception
    //   1296	1346	1421	java/lang/Exception
    //   1468	1493	1561	org/json/JSONException
    //   1497	1512	1561	org/json/JSONException
    //   1516	1538	1561	org/json/JSONException
    //   1541	1558	1561	org/json/JSONException
    //   1603	1631	1738	org/json/JSONException
    //   1634	1711	1738	org/json/JSONException
    //   1711	1729	1738	org/json/JSONException
    //   1780	1833	1836	org/json/JSONException
    //   1886	1921	1972	org/json/JSONException
    //   1924	1944	1972	org/json/JSONException
    //   1953	1969	1972	org/json/JSONException
    //   2014	2039	2042	org/json/JSONException
    //   2092	2122	2125	org/json/JSONException
    //   2167	2231	2314	org/json/JSONException
    //   2233	2240	2314	org/json/JSONException
    //   2242	2263	2314	org/json/JSONException
    //   2263	2284	2314	org/json/JSONException
    //   2286	2311	2314	org/json/JSONException
    //   2334	2361	2314	org/json/JSONException
    //   2364	2385	2314	org/json/JSONException
    //   625	631	2418	org/json/JSONException
  }
  
  public void onCreate()
  {
    afjy.a().a(this.mOnRemoteResp);
    if (this.ac.compareAndSet(false, true))
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
  }
  
  public void onDestroy()
  {
    afjy.a().b(this.mOnRemoteResp);
    if (this.ac.get()) {
      this.mClient.bzk();
    }
  }
  
  public void tG(String paramString)
  {
    Activity localActivity = this.mRuntime.getActivity();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < eD.length)
    {
      auuw.a locala = new auuw.a();
      locala.id = i;
      locala.title = localActivity.getString(eD[i]);
      locala.contentDescription = locala.title;
      locala.iconId = eE[i];
      localArrayList.add(locala);
      i += 1;
    }
    if (this.b == null) {
      this.b = auuw.a(localActivity, localArrayList, new std(this, paramString));
    }
    if (this.b.isShowing())
    {
      this.b.dismiss();
      return;
    }
    paramString = localActivity.findViewById(2131377361);
    this.b.showAsDropDown(paramString, paramString.getWidth() - localActivity.getResources().getDimensionPixelSize(2131299279) - localActivity.getResources().getDimensionPixelSize(2131299275), localActivity.getResources().getDimensionPixelSize(2131299276));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssx
 * JD-Core Version:    0.7.0.1
 */