package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import awoe;
import awol;
import awos;
import awot;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppJsPlugin
  extends BaseJsPlugin
{
  private static final String CHANNEL = "10036618";
  private static final String EVENT_DOWNLOAD_APP = "startDownloadAppTask";
  private static final String EVENT_DOWNLOAD_APP_CANCEL = "cancelDownloadAppTask";
  private static final String EVENT_INSTALL_APP = "installApp";
  private static final String EVENT_IS_MICROAPP_INSTALLED = "isMicroAppInstalled";
  private static final String EVENT_QUERY_APP_INFO = "queryAppInfo";
  private static final String EVENT_QUERY_DOWNLOAD_INFO = "queryDownloadAppTask";
  private static final String EVENT_START_APP = "startApp";
  private static final Set<String> S_EVENT_MAP = new AppJsPlugin.1();
  private static final String TAG = "AppJsPlugin";
  private static final String VIA = "SmallGame";
  private AppDownloadManager mAppDownloadManager;
  
  /* Error */
  public String handleNativeRequest(String paramString1, String paramString2, com.tencent.mobileqq.mini.webview.JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: ldc 23
    //   2: aload_1
    //   3: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +159 -> 165
    //   9: new 81	org/json/JSONObject
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: ldc 86
    //   23: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 7
    //   28: aload 6
    //   30: ldc 92
    //   32: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 8
    //   37: aload 6
    //   39: ldc 94
    //   41: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 9
    //   46: aload 6
    //   48: ldc 96
    //   50: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 10
    //   55: aload 6
    //   57: ldc 98
    //   59: invokevirtual 102	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   62: istore 5
    //   64: aload 8
    //   66: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +44 -> 113
    //   72: aload_0
    //   73: getfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   76: aload 8
    //   78: new 110	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$3
    //   81: dup
    //   82: aload_0
    //   83: aload_1
    //   84: aload_3
    //   85: iload 4
    //   87: aload 8
    //   89: iload 5
    //   91: aload 7
    //   93: aload 9
    //   95: aload 10
    //   97: invokespecial 113	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   100: invokevirtual 117	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:queryApkDownloadInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)V
    //   103: aload_0
    //   104: aload_1
    //   105: aload_2
    //   106: aload_3
    //   107: iload 4
    //   109: invokespecial 119	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin:handleNativeRequest	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   112: areturn
    //   113: aload_3
    //   114: iload 4
    //   116: aload_1
    //   117: aconst_null
    //   118: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   121: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   124: invokeinterface 135 3 0
    //   129: goto -26 -> 103
    //   132: astore 6
    //   134: ldc 47
    //   136: iconst_1
    //   137: aload 6
    //   139: iconst_0
    //   140: anewarray 137	java/lang/Object
    //   143: invokestatic 143	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   146: aload_3
    //   147: iload 4
    //   149: aload_1
    //   150: aconst_null
    //   151: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   154: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: invokeinterface 135 3 0
    //   162: goto -59 -> 103
    //   165: ldc 26
    //   167: aload_1
    //   168: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +123 -> 294
    //   174: new 81	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 144	org/json/JSONObject:<init>	()V
    //   181: astore 6
    //   183: new 81	org/json/JSONObject
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: ldc 92
    //   193: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 7
    //   198: aload 6
    //   200: ldc 92
    //   202: aload 7
    //   204: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_0
    //   209: getfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   212: aload 7
    //   214: invokevirtual 151	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:stopDownloadTask	(Ljava/lang/String;)Z
    //   217: ifeq +57 -> 274
    //   220: aload_3
    //   221: iload 4
    //   223: aload_1
    //   224: aload 6
    //   226: invokestatic 154	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   229: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   232: invokeinterface 135 3 0
    //   237: goto -134 -> 103
    //   240: astore 7
    //   242: ldc 47
    //   244: iconst_1
    //   245: aload 7
    //   247: iconst_0
    //   248: anewarray 137	java/lang/Object
    //   251: invokestatic 143	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   254: aload_3
    //   255: iload 4
    //   257: aload_1
    //   258: aload 6
    //   260: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   263: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   266: invokeinterface 135 3 0
    //   271: goto -168 -> 103
    //   274: aload_3
    //   275: iload 4
    //   277: aload_1
    //   278: aload 6
    //   280: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   283: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   286: invokeinterface 135 3 0
    //   291: goto -188 -> 103
    //   294: ldc 38
    //   296: aload_1
    //   297: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifeq +77 -> 377
    //   303: new 81	org/json/JSONObject
    //   306: dup
    //   307: aload_2
    //   308: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   311: ldc 92
    //   313: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 6
    //   318: aload_0
    //   319: getfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   322: aload 6
    //   324: new 156	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$4
    //   327: dup
    //   328: aload_0
    //   329: aload 6
    //   331: aload_1
    //   332: aload_3
    //   333: iload 4
    //   335: invokespecial 159	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   338: invokestatic 163	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)V
    //   341: goto -238 -> 103
    //   344: astore 6
    //   346: ldc 47
    //   348: iconst_1
    //   349: aload 6
    //   351: iconst_0
    //   352: anewarray 137	java/lang/Object
    //   355: invokestatic 143	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   358: aload_3
    //   359: iload 4
    //   361: aload_1
    //   362: aconst_null
    //   363: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   366: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   369: invokeinterface 135 3 0
    //   374: goto -271 -> 103
    //   377: ldc 35
    //   379: aload_1
    //   380: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: ifeq +209 -> 592
    //   386: new 81	org/json/JSONObject
    //   389: dup
    //   390: aload_2
    //   391: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   394: ldc 86
    //   396: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 7
    //   401: aload_0
    //   402: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   405: getfield 173	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   408: invokevirtual 179	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   411: astore 8
    //   413: aload_0
    //   414: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   417: getfield 173	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   420: aload 7
    //   422: invokestatic 185	ausc:getPackageInfo	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/pm/PackageInfo;
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +142 -> 571
    //   432: new 81	org/json/JSONObject
    //   435: dup
    //   436: invokespecial 144	org/json/JSONObject:<init>	()V
    //   439: astore 9
    //   441: aload 9
    //   443: ldc 86
    //   445: aload 7
    //   447: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   450: pop
    //   451: aload 9
    //   453: ldc 187
    //   455: aload 6
    //   457: getfield 193	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   460: aload 8
    //   462: invokevirtual 199	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   465: invokeinterface 202 1 0
    //   470: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   473: pop
    //   474: aload 9
    //   476: ldc 204
    //   478: aload 6
    //   480: getfield 207	android/content/pm/PackageInfo:versionCode	I
    //   483: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   486: pop
    //   487: aload 9
    //   489: ldc 212
    //   491: aload 6
    //   493: getfield 214	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   496: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload_3
    //   501: iload 4
    //   503: aload_1
    //   504: aload 9
    //   506: invokestatic 154	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   509: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   512: invokeinterface 135 3 0
    //   517: goto -414 -> 103
    //   520: astore 6
    //   522: ldc 47
    //   524: iconst_1
    //   525: aload 6
    //   527: iconst_0
    //   528: anewarray 137	java/lang/Object
    //   531: invokestatic 143	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   534: aload_3
    //   535: iload 4
    //   537: aload_1
    //   538: aconst_null
    //   539: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   542: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   545: invokeinterface 135 3 0
    //   550: goto -447 -> 103
    //   553: astore 6
    //   555: ldc 47
    //   557: iconst_1
    //   558: ldc 216
    //   560: aload 6
    //   562: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aconst_null
    //   566: astore 6
    //   568: goto -141 -> 427
    //   571: aload_3
    //   572: iload 4
    //   574: aload_1
    //   575: aconst_null
    //   576: ldc 223
    //   578: invokestatic 226	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   581: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   584: invokeinterface 135 3 0
    //   589: goto -486 -> 103
    //   592: ldc 29
    //   594: aload_1
    //   595: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +88 -> 686
    //   601: new 81	org/json/JSONObject
    //   604: dup
    //   605: aload_2
    //   606: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   609: astore 6
    //   611: aload 6
    //   613: ldc 86
    //   615: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   618: pop
    //   619: aload 6
    //   621: ldc 92
    //   623: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   626: astore 6
    //   628: aload_0
    //   629: getfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   632: aload 6
    //   634: new 228	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$5
    //   637: dup
    //   638: aload_0
    //   639: aload_1
    //   640: aload_3
    //   641: iload 4
    //   643: invokespecial 231	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   646: invokevirtual 234	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:installApp	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)Z
    //   649: pop
    //   650: goto -547 -> 103
    //   653: astore 6
    //   655: ldc 47
    //   657: iconst_1
    //   658: aload 6
    //   660: iconst_0
    //   661: anewarray 137	java/lang/Object
    //   664: invokestatic 143	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   667: aload_3
    //   668: iload 4
    //   670: aload_1
    //   671: aconst_null
    //   672: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   675: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   678: invokeinterface 135 3 0
    //   683: goto -580 -> 103
    //   686: ldc 41
    //   688: aload_1
    //   689: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   692: ifeq +315 -> 1007
    //   695: new 81	org/json/JSONObject
    //   698: dup
    //   699: aload_2
    //   700: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   703: astore 6
    //   705: aload 6
    //   707: ldc 86
    //   709: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   712: astore 7
    //   714: aload 6
    //   716: ldc 236
    //   718: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   721: astore 8
    //   723: aload_0
    //   724: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   727: getfield 173	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   730: invokevirtual 179	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   733: astore 9
    //   735: aload_0
    //   736: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   739: getfield 173	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   742: aload 7
    //   744: invokestatic 185	ausc:getPackageInfo	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/pm/PackageInfo;
    //   747: astore 6
    //   749: aload 6
    //   751: ifnull +237 -> 988
    //   754: new 81	org/json/JSONObject
    //   757: dup
    //   758: invokespecial 144	org/json/JSONObject:<init>	()V
    //   761: astore 10
    //   763: aload 8
    //   765: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   768: ifne +183 -> 951
    //   771: new 238	android/content/Intent
    //   774: dup
    //   775: invokespecial 239	android/content/Intent:<init>	()V
    //   778: astore 6
    //   780: aload 6
    //   782: ldc 241
    //   784: ldc 243
    //   786: invokevirtual 247	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   789: pop
    //   790: aload 6
    //   792: ldc 248
    //   794: invokevirtual 252	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   797: pop
    //   798: aload 6
    //   800: new 254	android/content/ComponentName
    //   803: dup
    //   804: aload 7
    //   806: aload 8
    //   808: invokespecial 257	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   811: invokevirtual 261	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   814: pop
    //   815: aload 6
    //   817: aload 9
    //   819: ldc_w 262
    //   822: invokevirtual 266	android/content/Intent:resolveActivityInfo	(Landroid/content/pm/PackageManager;I)Landroid/content/pm/ActivityInfo;
    //   825: ifnull +87 -> 912
    //   828: aload_0
    //   829: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   832: getfield 173	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   835: aload 6
    //   837: invokevirtual 270	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   840: aload_3
    //   841: iload 4
    //   843: aload_1
    //   844: aload 10
    //   846: invokestatic 154	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   849: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   852: invokeinterface 135 3 0
    //   857: goto -754 -> 103
    //   860: astore 6
    //   862: ldc 47
    //   864: iconst_1
    //   865: aload 6
    //   867: iconst_0
    //   868: anewarray 137	java/lang/Object
    //   871: invokestatic 143	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   874: aload_3
    //   875: iload 4
    //   877: aload_1
    //   878: aconst_null
    //   879: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   882: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   885: invokeinterface 135 3 0
    //   890: goto -787 -> 103
    //   893: astore 6
    //   895: ldc 47
    //   897: iconst_1
    //   898: ldc_w 272
    //   901: aload 6
    //   903: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   906: aconst_null
    //   907: astore 6
    //   909: goto -160 -> 749
    //   912: ldc 47
    //   914: iconst_1
    //   915: iconst_1
    //   916: anewarray 137	java/lang/Object
    //   919: dup
    //   920: iconst_0
    //   921: ldc_w 274
    //   924: aastore
    //   925: invokestatic 277	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   928: aload_3
    //   929: iload 4
    //   931: aload_1
    //   932: aconst_null
    //   933: ldc_w 279
    //   936: invokestatic 226	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   939: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   942: invokeinterface 135 3 0
    //   947: ldc_w 281
    //   950: areturn
    //   951: aload 9
    //   953: aload 6
    //   955: getfield 284	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   958: invokevirtual 290	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   961: astore 6
    //   963: aload 6
    //   965: ldc 241
    //   967: ldc 243
    //   969: invokevirtual 247	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   972: pop
    //   973: aload_0
    //   974: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   977: getfield 173	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   980: aload 6
    //   982: invokevirtual 270	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   985: goto -145 -> 840
    //   988: aload_3
    //   989: iload 4
    //   991: aload_1
    //   992: aconst_null
    //   993: invokestatic 125	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   996: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   999: invokeinterface 135 3 0
    //   1004: goto -901 -> 103
    //   1007: ldc 32
    //   1009: aload_1
    //   1010: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1013: ifeq -910 -> 103
    //   1016: aload_0
    //   1017: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1020: ifnull +69 -> 1089
    //   1023: aload_0
    //   1024: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1027: getfield 294	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1030: ifnull +59 -> 1089
    //   1033: aload_0
    //   1034: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1037: getfield 294	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1040: invokevirtual 300	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1043: ifnull +46 -> 1089
    //   1046: invokestatic 306	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1049: aconst_null
    //   1050: aload_0
    //   1051: getfield 167	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1054: getfield 294	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1057: invokevirtual 300	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1060: getfield 311	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   1063: ldc_w 281
    //   1066: ldc_w 281
    //   1069: bipush 100
    //   1071: new 313	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$6
    //   1074: dup
    //   1075: aload_0
    //   1076: aload_3
    //   1077: aload_1
    //   1078: iload 4
    //   1080: invokespecial 316	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1083: invokevirtual 320	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getNativeAppInfoForJump	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1086: goto -983 -> 103
    //   1089: ldc 47
    //   1091: iconst_1
    //   1092: ldc_w 322
    //   1095: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1098: goto -995 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1101	0	this	AppJsPlugin
    //   0	1101	1	paramString1	String
    //   0	1101	2	paramString2	String
    //   0	1101	3	paramJsRuntime	com.tencent.mobileqq.mini.webview.JsRuntime
    //   0	1101	4	paramInt	int
    //   62	28	5	bool	boolean
    //   17	39	6	localJSONObject	JSONObject
    //   132	6	6	localThrowable1	Throwable
    //   181	149	6	localObject1	Object
    //   344	6	6	localThrowable2	Throwable
    //   425	67	6	localPackageInfo	android.content.pm.PackageInfo
    //   520	6	6	localThrowable3	Throwable
    //   553	8	6	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   566	67	6	localObject2	Object
    //   653	6	6	localThrowable4	Throwable
    //   703	133	6	localObject3	Object
    //   860	6	6	localThrowable5	Throwable
    //   893	9	6	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   907	74	6	localIntent	Intent
    //   26	187	7	str1	String
    //   240	6	7	localThrowable6	Throwable
    //   399	406	7	str2	String
    //   35	772	8	localObject4	Object
    //   44	908	9	localObject5	Object
    //   53	792	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   9	103	132	java/lang/Throwable
    //   113	129	132	java/lang/Throwable
    //   183	237	240	java/lang/Throwable
    //   274	291	240	java/lang/Throwable
    //   303	341	344	java/lang/Throwable
    //   386	413	520	java/lang/Throwable
    //   413	427	520	java/lang/Throwable
    //   432	517	520	java/lang/Throwable
    //   555	565	520	java/lang/Throwable
    //   571	589	520	java/lang/Throwable
    //   413	427	553	android/content/pm/PackageManager$NameNotFoundException
    //   601	650	653	java/lang/Throwable
    //   695	735	860	java/lang/Throwable
    //   735	749	860	java/lang/Throwable
    //   754	840	860	java/lang/Throwable
    //   840	857	860	java/lang/Throwable
    //   895	906	860	java/lang/Throwable
    //   912	947	860	java/lang/Throwable
    //   951	985	860	java/lang/Throwable
    //   988	1004	860	java/lang/Throwable
    //   735	749	893	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mAppDownloadManager = new AppDownloadManager(paramBaseJsPluginEngine.activityContext);
  }
  
  public void onDestroy()
  {
    if (this.mAppDownloadManager != null) {
      this.mAppDownloadManager.unInit();
    }
    super.onDestroy();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public class AppDownloadManager
  {
    public static final int DOWNLOAD_ERRCODE_URL_INVALID = -1000;
    private static final int MAX_RETRY_COUNT = 3;
    private static final String TAG = "AppJsPlugin_AppDownloadManager";
    private HashMap<String, JSONObject> mAppJsonInfo = new HashMap();
    private Context mContext;
    private HashMap<String, AppJsPlugin.IDownloadListener> mDownloadListenerMap;
    private HashMap<String, AppJsPlugin.IWaldlCallback> mInstallCallbackMap = new HashMap();
    private boolean mIsInitFlag;
    private HashMap<String, Integer> mProgressMap = new HashMap();
    private HashMap<String, AppJsPlugin.IWaldlCallback> mQueryCallbackMap = new HashMap();
    private HashMap<String, List<AppJsPlugin.IWaldlCallback>> mQueryDownloadInfoListenerMap = new HashMap();
    private int mRetryCount;
    private awoe mWadlCallback = new AppJsPlugin.AppDownloadManager.1(this);
    private HashMap<String, WadlParams> mWadlParams = new HashMap();
    private awol mWadlProxyService;
    
    public AppDownloadManager(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private WadlParams createWadlParams(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return null;
      }
      try
      {
        WadlParams localWadlParams = new WadlParams();
        localWadlParams.via = "SmallGame";
        localWadlParams.apkChannel = "10036618";
        localWadlParams.from = 6;
        localWadlParams.apkUrl = paramJSONObject.optString("android_download_url");
        localWadlParams.appId = paramJSONObject.optString("appid");
        localWadlParams.versionCode = paramJSONObject.optInt("version_code");
        localWadlParams.packageName = paramJSONObject.optString("pkg_name");
        localWadlParams.appName = paramJSONObject.optString("app_name");
        localWadlParams.iconUrl = paramJSONObject.optString("app_icon");
        localWadlParams.bLE = "interrupt";
        return localWadlParams;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.i("AppJsPlugin_AppDownloadManager", 1, "createWadlParams exception happend:", paramJSONObject);
      }
      return null;
    }
    
    private void queryDownloadTask(String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
    {
      if (paramIWaldlCallback == null) {
        return;
      }
      init();
      if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString))) {
        paramIWaldlCallback.onResult(false, null);
      }
      this.mQueryCallbackMap.put(paramString, paramIWaldlCallback);
      paramIWaldlCallback = new ArrayList();
      paramIWaldlCallback.add(paramString);
      this.mWadlProxyService.fz(paramIWaldlCallback);
    }
    
    public void addDownloadListener(String paramString, AppJsPlugin.IDownloadListener paramIDownloadListener)
    {
      if (this.mDownloadListenerMap == null) {
        this.mDownloadListenerMap = new HashMap();
      }
      this.mDownloadListenerMap.put(paramString, paramIDownloadListener);
    }
    
    public void init()
    {
      if (this.mIsInitFlag) {
        return;
      }
      this.mIsInitFlag = true;
      this.mRetryCount = 0;
      this.mDownloadListenerMap = new HashMap();
      this.mWadlProxyService = new awol();
      this.mWadlProxyService.a(this.mWadlCallback);
    }
    
    public boolean installApp(String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
    {
      init();
      if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString)) || (paramIWaldlCallback == null)) {
        return false;
      }
      WadlParams localWadlParams2 = createWadlParams((JSONObject)this.mAppJsonInfo.get(paramString));
      WadlParams localWadlParams1 = localWadlParams2;
      if (localWadlParams2 == null) {
        localWadlParams1 = (WadlParams)this.mWadlParams.get(paramString);
      }
      if (localWadlParams1 == null)
      {
        paramIWaldlCallback.onResult(false, null);
        return false;
      }
      localWadlParams1.setFlags(2);
      localWadlParams1.ekZ = 5;
      this.mWadlProxyService.c(localWadlParams1);
      paramIWaldlCallback.onResult(true, null);
      return true;
    }
    
    public void queryApkDownloadInfo(String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramIWaldlCallback == null)) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      paramString = new QueryDownloadInfoListener(paramString, paramIWaldlCallback);
      awot.a().a(paramString);
      awot.a().D("10036618", localArrayList);
    }
    
    public void removeDownloadListener(String paramString)
    {
      if (this.mDownloadListenerMap != null) {
        this.mDownloadListenerMap.remove(paramString);
      }
    }
    
    public void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, AppJsPlugin.IDownloadListener paramIDownloadListener)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null))
      {
        QLog.i("AppJsPlugin_AppDownloadManager", 1, "startDownload, url is empty!");
        if (paramIDownloadListener != null) {
          paramIDownloadListener.onDownloadFailed(-1000, -1, "url is invalid");
        }
        return;
      }
      init();
      if (paramIDownloadListener != null) {
        addDownloadListener(paramString, paramIDownloadListener);
      }
      for (;;)
      {
        try
        {
          this.mAppJsonInfo.put(paramString, paramJSONObject);
          paramString = createWadlParams(paramJSONObject);
          if (paramString == null) {
            break;
          }
          if (!paramBoolean) {
            break label131;
          }
          paramString.setFlags(7);
          paramString.ekZ = 2;
          this.mWadlProxyService.h(paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.i("AppJsPlugin_AppDownloadManager", 1, "startDownload---exception happend:", paramString);
        }
        if (paramIDownloadListener == null) {
          break;
        }
        paramIDownloadListener.onDownloadFailed(-1000, -2, "url is invalid");
        return;
        label131:
        paramString.setFlags(6);
      }
    }
    
    public boolean stopDownloadTask(String paramString)
    {
      init();
      if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString))) {
        return false;
      }
      WadlParams localWadlParams = createWadlParams((JSONObject)this.mAppJsonInfo.get(paramString));
      if (localWadlParams == null) {
        return false;
      }
      localWadlParams.setFlags(2);
      localWadlParams.ekZ = 3;
      this.mWadlProxyService.eE(6, paramString);
      return true;
    }
    
    public void unInit()
    {
      if (this.mDownloadListenerMap != null)
      {
        this.mDownloadListenerMap.clear();
        this.mDownloadListenerMap = null;
      }
      this.mIsInitFlag = false;
      this.mRetryCount = 0;
      this.mContext = null;
      if (this.mWadlProxyService != null)
      {
        this.mWadlProxyService.b(this.mWadlCallback);
        this.mWadlProxyService.destroy();
        this.mWadlProxyService = null;
      }
    }
    
    class QueryDownloadInfoListener
      implements awos
    {
      private String mAppid;
      private AppJsPlugin.IWaldlCallback mCallback;
      
      public QueryDownloadInfoListener(String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
      {
        this.mAppid = paramString;
        this.mCallback = paramIWaldlCallback;
      }
      
      public HashSet<String> getFilterCmds()
      {
        HashSet localHashSet = new HashSet();
        localHashSet.add("13169");
        return localHashSet;
      }
      
      public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
      {
        paramIntent = null;
        Object localObject = null;
        QLog.i("AppJsPlugin_AppDownloadManager", 1, "onCmdRsp ret=" + paramLong + ",cmd=" + paramString + ",dataJson=" + paramJSONObject);
        AppJsPlugin.IWaldlCallback localIWaldlCallback;
        if ("13169".equals(paramString))
        {
          try
          {
            localIWaldlCallback = this.mCallback;
            if (localIWaldlCallback == null) {
              return;
            }
            this.mCallback = null;
            if (paramLong != 0L)
            {
              localIWaldlCallback.onResult(false, null);
              return;
            }
          }
          catch (Throwable paramIntent)
          {
            QLog.e("AppJsPlugin_AppDownloadManager", 1, "exception. ", paramIntent);
            return;
          }
          paramString = localObject;
        }
        for (;;)
        {
          try
          {
            paramJSONObject = paramJSONObject.getJSONArray("v_appd_down_load_info");
            if (paramJSONObject == null) {
              break label186;
            }
            paramString = localObject;
            paramIntent = paramJSONObject.getJSONObject(0);
          }
          catch (Throwable paramIntent)
          {
            QLog.e("AppJsPlugin_AppDownloadManager", 1, "exception. ", paramIntent);
            if (paramString == null) {
              break label179;
            }
          }
          paramString = paramIntent;
          localIWaldlCallback.onResult(bool, paramIntent);
          return;
          boolean bool = true;
          label162:
          localIWaldlCallback.onResult(bool, paramString);
          return;
          label179:
          label186:
          do
          {
            bool = false;
            break;
            bool = false;
            break label162;
            return;
          } while (paramIntent == null);
          bool = true;
        }
      }
    }
  }
  
  public static abstract interface IDownloadListener
  {
    public abstract void onDownloadComplete();
    
    public abstract void onDownloadFailed(int paramInt1, int paramInt2, String paramString);
    
    public abstract void onDownloadPause();
    
    public abstract void onDownloadProgress(long paramLong1, long paramLong2, int paramInt);
  }
  
  public static abstract interface IWaldlCallback
  {
    public abstract void onResult(boolean paramBoolean, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */