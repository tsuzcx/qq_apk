package com.tencent.mobileqq.vashealth;

import acbn;
import ahbj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aqtj;
import aqtk;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import ilp;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import jqc;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import mye.b;
import org.json.JSONArray;
import org.json.JSONObject;

public class HealthBusinessPlugin
  extends WebViewPlugin
{
  static List<String> Jd = new ArrayList();
  public static HashMap<String, JSONObject> mCache = new HashMap();
  public static HashMap<String, UploadThread> pj = new HashMap();
  static HashMap<String, Double> pk = new HashMap();
  Point F = new Point();
  Point G = new Point();
  Uri N;
  a a = null;
  boolean cVS;
  boolean cVT = false;
  public FrameLayout cc;
  String cwR;
  String cwS;
  mye.b d = null;
  Handler dL = new Handler();
  Handler dM = new aqtk(this);
  public int ecy;
  RefreshView f;
  TouchWebView l;
  HashMap<String, FrameLayout> pl = new HashMap();
  HashMap<String, Object> pm = new HashMap();
  HashMap<String, Timer> pn = new HashMap();
  HashMap<String, Long> po = new HashMap();
  
  public HealthBusinessPlugin()
  {
    this.mPluginNameSpace = "healthSport";
  }
  
  SharedPreferences B()
  {
    String str2 = this.mRuntime.a().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "nologin";
    }
    return this.mRuntime.a().getApplication().getSharedPreferences(str1 + "_health", 0);
  }
  
  public void VE(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("source", "none");
      dispatchJsEvent("healthSport_uploadProgress", paramString, localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.i("HealthBusinessPlugin", 2, "UploadProgress:" + paramString.toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HealthBusinessPlugin", 2, "UploadProgress Err");
    }
  }
  
  /* Error */
  void a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, android.os.Bundle paramBundle, UploadThread paramUploadThread)
  {
    // Byte code:
    //   0: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   3: lstore 15
    //   5: aload 6
    //   7: aload_3
    //   8: aload 4
    //   10: ldc 209
    //   12: aload_0
    //   13: getfield 211	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cVS	Z
    //   16: invokestatic 216	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lapaz$a;
    //   19: astore 6
    //   21: aload 6
    //   23: ifnull +1688 -> 1711
    //   26: aload_2
    //   27: invokestatic 222	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   30: lstore 11
    //   32: lload 11
    //   34: ldc2_w 223
    //   37: lcmp
    //   38: ifle +446 -> 484
    //   41: ldc2_w 223
    //   44: lstore 9
    //   46: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +45 -> 94
    //   52: ldc 189
    //   54: iconst_2
    //   55: new 142	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   62: ldc 226
    //   64: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 6
    //   69: getfield 231	apaz$a:cnL	Ljava/lang/String;
    //   72: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 233
    //   77: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload 6
    //   82: getfield 236	apaz$a:cnK	Ljava/lang/String;
    //   85: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: ldc 240
    //   96: aload 6
    //   98: getfield 231	apaz$a:cnL	Ljava/lang/String;
    //   101: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifeq +387 -> 491
    //   107: aload 6
    //   109: getfield 249	apaz$a:vid	Ljava/lang/String;
    //   112: astore_2
    //   113: iconst_1
    //   114: istore 8
    //   116: iload 8
    //   118: ifeq +1524 -> 1642
    //   121: aconst_null
    //   122: astore 6
    //   124: aconst_null
    //   125: astore 7
    //   127: new 251	java/net/URL
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 252	java/net/URL:<init>	(Ljava/lang/String;)V
    //   135: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   138: checkcast 258	java/net/HttpURLConnection
    //   141: astore_1
    //   142: aload_1
    //   143: sipush 5000
    //   146: invokevirtual 262	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   149: aload_1
    //   150: sipush 30000
    //   153: invokevirtual 265	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   156: aload_1
    //   157: iconst_1
    //   158: invokevirtual 269	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   161: aload_1
    //   162: iconst_1
    //   163: invokevirtual 272	java/net/HttpURLConnection:setDoInput	(Z)V
    //   166: aload_1
    //   167: iconst_0
    //   168: invokevirtual 275	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   171: aload_1
    //   172: ldc_w 277
    //   175: invokevirtual 280	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   178: aload_1
    //   179: ldc_w 282
    //   182: ldc_w 284
    //   185: invokevirtual 288	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_1
    //   189: ldc_w 290
    //   192: new 142	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 292
    //   199: invokespecial 293	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: ldc_w 295
    //   205: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: getstatic 300	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   211: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 295
    //   217: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: getstatic 305	android/os/Build:DEVICE	Ljava/lang/String;
    //   223: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 295
    //   229: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: getstatic 308	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   235: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 295
    //   241: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 310
    //   247: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokevirtual 288	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_1
    //   257: ldc_w 312
    //   260: ldc_w 314
    //   263: invokevirtual 288	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_1
    //   267: ldc_w 316
    //   270: new 142	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 318
    //   280: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_3
    //   284: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 320
    //   290: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 4
    //   295: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 288	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: new 322	java/io/DataOutputStream
    //   307: dup
    //   308: aload_1
    //   309: invokevirtual 326	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   312: invokespecial 329	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   315: astore_3
    //   316: new 331	java/lang/StringBuffer
    //   319: dup
    //   320: invokespecial 332	java/lang/StringBuffer:<init>	()V
    //   323: astore 4
    //   325: aload 4
    //   327: ldc_w 334
    //   330: invokevirtual 337	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   333: pop
    //   334: aload 4
    //   336: aload_2
    //   337: invokevirtual 337	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   340: pop
    //   341: aload 4
    //   343: ldc_w 339
    //   346: invokevirtual 337	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   349: pop
    //   350: aload 4
    //   352: aload 5
    //   354: ldc_w 341
    //   357: invokeinterface 347 2 0
    //   362: checkcast 242	java/lang/String
    //   365: invokevirtual 337	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   368: pop
    //   369: aload_3
    //   370: aload 4
    //   372: invokevirtual 348	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   375: invokevirtual 352	java/lang/String:getBytes	()[B
    //   378: invokevirtual 358	java/io/OutputStream:write	([B)V
    //   381: aload_3
    //   382: invokevirtual 361	java/io/OutputStream:flush	()V
    //   385: aload_3
    //   386: invokevirtual 364	java/io/OutputStream:close	()V
    //   389: new 331	java/lang/StringBuffer
    //   392: dup
    //   393: invokespecial 332	java/lang/StringBuffer:<init>	()V
    //   396: astore 4
    //   398: new 366	java/io/BufferedReader
    //   401: dup
    //   402: new 368	java/io/InputStreamReader
    //   405: dup
    //   406: aload_1
    //   407: invokevirtual 372	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   410: invokespecial 375	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   413: invokespecial 378	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   416: astore_3
    //   417: aload_3
    //   418: invokevirtual 381	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   421: astore 6
    //   423: aload 6
    //   425: ifnull +1124 -> 1549
    //   428: aload 4
    //   430: aload 6
    //   432: invokevirtual 337	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   435: ldc_w 383
    //   438: invokevirtual 337	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   441: pop
    //   442: goto -25 -> 417
    //   445: astore_2
    //   446: aload_1
    //   447: astore 6
    //   449: ldc 189
    //   451: iconst_2
    //   452: new 142	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 385
    //   462: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_2
    //   466: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload_1
    //   476: ifnull +7 -> 483
    //   479: aload_1
    //   480: invokevirtual 391	java/net/HttpURLConnection:disconnect	()V
    //   483: return
    //   484: lload 11
    //   486: lstore 9
    //   488: goto -442 -> 46
    //   491: aload 6
    //   493: getfield 249	apaz$a:vid	Ljava/lang/String;
    //   496: ifnull +1215 -> 1711
    //   499: aload 6
    //   501: getfield 394	apaz$a:cnJ	Ljava/lang/String;
    //   504: invokestatic 400	aqhs:hexStr2Bytes	(Ljava/lang/String;)[B
    //   507: astore 18
    //   509: aload_2
    //   510: invokestatic 405	ahav:x	(Ljava/lang/String;)[B
    //   513: astore 19
    //   515: new 142	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   522: ldc_w 407
    //   525: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 6
    //   530: getfield 410	apaz$a:cnH	Ljava/lang/String;
    //   533: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: ldc_w 412
    //   539: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 6
    //   544: getfield 415	apaz$a:cnI	Ljava/lang/String;
    //   547: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 417
    //   553: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: astore 20
    //   561: aload_0
    //   562: getfield 211	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cVS	Z
    //   565: ifeq +15 -> 580
    //   568: aload 20
    //   570: ldc_w 419
    //   573: ldc_w 421
    //   576: invokevirtual 425	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   579: pop
    //   580: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +44 -> 627
    //   586: ldc 189
    //   588: iconst_2
    //   589: new 142	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 427
    //   599: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 20
    //   604: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc_w 429
    //   610: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 6
    //   615: getfield 249	apaz$a:vid	Ljava/lang/String;
    //   618: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: new 431	java/io/RandomAccessFile
    //   630: dup
    //   631: aload_2
    //   632: ldc_w 433
    //   635: invokespecial 435	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: astore 17
    //   640: lconst_0
    //   641: lstore 13
    //   643: lload 9
    //   645: lload 13
    //   647: lsub
    //   648: l2i
    //   649: istore 8
    //   651: aload 17
    //   653: astore_2
    //   654: invokestatic 441	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   657: invokestatic 447	jqc:ak	(Landroid/content/Context;)Z
    //   660: ifeq +1086 -> 1746
    //   663: aload 17
    //   665: astore_2
    //   666: aload 18
    //   668: aload 19
    //   670: aload 20
    //   672: lload 11
    //   674: aload 17
    //   676: lload 13
    //   678: iload 8
    //   680: invokestatic 452	apaz:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   683: lstore 13
    //   685: aload 17
    //   687: astore_2
    //   688: aload 7
    //   690: getfield 455	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:cVU	Z
    //   693: iconst_1
    //   694: if_icmpne +198 -> 892
    //   697: aload 17
    //   699: astore_2
    //   700: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +15 -> 718
    //   706: aload 17
    //   708: astore_2
    //   709: ldc 189
    //   711: iconst_2
    //   712: ldc_w 457
    //   715: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload 17
    //   720: astore_2
    //   721: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   724: aload 7
    //   726: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   729: invokeinterface 465 2 0
    //   734: ifeq +20 -> 754
    //   737: aload 17
    //   739: astore_2
    //   740: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   743: aload 7
    //   745: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   748: invokeinterface 468 2 0
    //   753: pop
    //   754: aload 17
    //   756: astore_2
    //   757: getstatic 71	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
    //   760: aload 7
    //   762: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   765: invokevirtual 469	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   768: ifnull +18 -> 786
    //   771: aload 17
    //   773: astore_2
    //   774: getstatic 71	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
    //   777: aload 7
    //   779: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   782: invokevirtual 471	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   785: pop
    //   786: aload 17
    //   788: astore_2
    //   789: getstatic 69	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pj	Ljava/util/HashMap;
    //   792: aload 7
    //   794: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   797: invokevirtual 469	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   800: ifnull +18 -> 818
    //   803: aload 17
    //   805: astore_2
    //   806: getstatic 69	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pj	Ljava/util/HashMap;
    //   809: aload 7
    //   811: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   814: invokevirtual 471	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   817: pop
    //   818: aload 17
    //   820: astore_2
    //   821: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   824: ifeq +39 -> 863
    //   827: aload 17
    //   829: astore_2
    //   830: ldc 189
    //   832: iconst_2
    //   833: new 142	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   840: ldc_w 473
    //   843: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   849: invokeinterface 477 1 0
    //   854: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   857: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   863: aload 17
    //   865: ifnull -382 -> 483
    //   868: aload 17
    //   870: invokevirtual 481	java/io/RandomAccessFile:close	()V
    //   873: return
    //   874: astore_1
    //   875: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq -395 -> 483
    //   881: ldc 189
    //   883: iconst_2
    //   884: aload_1
    //   885: invokestatic 485	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   888: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: return
    //   892: aload 17
    //   894: astore_2
    //   895: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   898: ifeq +76 -> 974
    //   901: aload 17
    //   903: astore_2
    //   904: ldc 189
    //   906: iconst_2
    //   907: new 142	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   914: ldc_w 487
    //   917: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: lload 13
    //   922: l2d
    //   923: lload 11
    //   925: l2d
    //   926: ddiv
    //   927: invokevirtual 490	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   930: ldc_w 492
    //   933: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   939: invokeinterface 477 1 0
    //   944: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   947: ldc_w 494
    //   950: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   956: iconst_0
    //   957: invokeinterface 497 2 0
    //   962: checkcast 242	java/lang/String
    //   965: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   974: aload 17
    //   976: astore_2
    //   977: getstatic 71	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
    //   980: aload 7
    //   982: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   985: lload 13
    //   987: l2d
    //   988: lload 11
    //   990: l2d
    //   991: ddiv
    //   992: invokestatic 503	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   995: invokevirtual 506	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   998: pop
    //   999: lload 13
    //   1001: ldc2_w 507
    //   1004: lcmp
    //   1005: ifne +74 -> 1079
    //   1008: iconst_1
    //   1009: istore 8
    //   1011: iload 8
    //   1013: ifne +403 -> 1416
    //   1016: aload 17
    //   1018: astore_2
    //   1019: ldc 189
    //   1021: iconst_1
    //   1022: new 142	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1029: ldc_w 510
    //   1032: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   1038: lload 15
    //   1040: lsub
    //   1041: invokevirtual 513	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: iconst_1
    //   1051: istore 8
    //   1053: aload 17
    //   1055: astore_2
    //   1056: aload 6
    //   1058: getfield 249	apaz$a:vid	Ljava/lang/String;
    //   1061: astore 6
    //   1063: aload 17
    //   1065: ifnull +637 -> 1702
    //   1068: aload 17
    //   1070: invokevirtual 481	java/io/RandomAccessFile:close	()V
    //   1073: aload 6
    //   1075: astore_2
    //   1076: goto -960 -> 116
    //   1079: aload 17
    //   1081: astore_2
    //   1082: new 164	org/json/JSONObject
    //   1085: dup
    //   1086: invokespecial 167	org/json/JSONObject:<init>	()V
    //   1089: astore 21
    //   1091: aload 17
    //   1093: astore_2
    //   1094: new 515	org/json/JSONArray
    //   1097: dup
    //   1098: invokespecial 516	org/json/JSONArray:<init>	()V
    //   1101: astore 22
    //   1103: iconst_0
    //   1104: istore 8
    //   1106: aload 17
    //   1108: astore_2
    //   1109: iload 8
    //   1111: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   1114: invokeinterface 477 1 0
    //   1119: if_icmpge +239 -> 1358
    //   1122: aload 17
    //   1124: astore_2
    //   1125: new 164	org/json/JSONObject
    //   1128: dup
    //   1129: invokespecial 167	org/json/JSONObject:<init>	()V
    //   1132: astore 23
    //   1134: aload 17
    //   1136: astore_2
    //   1137: aload 23
    //   1139: ldc_w 518
    //   1142: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   1145: iload 8
    //   1147: invokeinterface 497 2 0
    //   1152: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1155: pop
    //   1156: aload 17
    //   1158: astore_2
    //   1159: getstatic 71	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
    //   1162: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   1165: iload 8
    //   1167: invokeinterface 497 2 0
    //   1172: invokevirtual 469	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1175: ifnull +99 -> 1274
    //   1178: aload 17
    //   1180: astore_2
    //   1181: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1184: ifeq +42 -> 1226
    //   1187: aload 17
    //   1189: astore_2
    //   1190: ldc 189
    //   1192: iconst_2
    //   1193: new 142	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 520
    //   1203: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: getstatic 71	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
    //   1209: aload 7
    //   1211: getfield 460	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
    //   1214: invokevirtual 469	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1217: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1220: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1226: aload 17
    //   1228: astore_2
    //   1229: aload 23
    //   1231: ldc_w 522
    //   1234: getstatic 71	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
    //   1237: getstatic 67	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
    //   1240: iload 8
    //   1242: invokeinterface 497 2 0
    //   1247: invokevirtual 469	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1250: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1253: pop
    //   1254: aload 17
    //   1256: astore_2
    //   1257: aload 22
    //   1259: aload 23
    //   1261: invokevirtual 525	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1264: pop
    //   1265: iload 8
    //   1267: iconst_1
    //   1268: iadd
    //   1269: istore 8
    //   1271: goto -165 -> 1106
    //   1274: aload 17
    //   1276: astore_2
    //   1277: aload 23
    //   1279: ldc_w 522
    //   1282: iconst_0
    //   1283: invokevirtual 528	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1286: pop
    //   1287: goto -33 -> 1254
    //   1290: astore 7
    //   1292: aload 17
    //   1294: astore 6
    //   1296: aload 6
    //   1298: astore_2
    //   1299: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1302: ifeq +36 -> 1338
    //   1305: aload 6
    //   1307: astore_2
    //   1308: ldc 189
    //   1310: iconst_2
    //   1311: new 142	java/lang/StringBuilder
    //   1314: dup
    //   1315: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1318: ldc_w 530
    //   1321: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: aload 7
    //   1326: invokestatic 485	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1329: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1338: aload 6
    //   1340: ifnull +352 -> 1692
    //   1343: aload 6
    //   1345: invokevirtual 481	java/io/RandomAccessFile:close	()V
    //   1348: ldc_w 532
    //   1351: astore_2
    //   1352: iconst_0
    //   1353: istore 8
    //   1355: goto -1239 -> 116
    //   1358: aload 17
    //   1360: astore_2
    //   1361: aload 21
    //   1363: ldc_w 534
    //   1366: iconst_0
    //   1367: invokevirtual 528	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1370: pop
    //   1371: aload 17
    //   1373: astore_2
    //   1374: aload 21
    //   1376: ldc_w 536
    //   1379: aload 22
    //   1381: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1384: pop
    //   1385: aload 17
    //   1387: astore_2
    //   1388: aload_0
    //   1389: aload 21
    //   1391: invokevirtual 192	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1394: invokevirtual 538	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:VE	(Ljava/lang/String;)V
    //   1397: ldc2_w 223
    //   1400: lload 13
    //   1402: ladd
    //   1403: lload 11
    //   1405: lcmp
    //   1406: ifle +329 -> 1735
    //   1409: lload 11
    //   1411: lstore 9
    //   1413: goto +308 -> 1721
    //   1416: aload 17
    //   1418: astore_2
    //   1419: ldc 189
    //   1421: iconst_1
    //   1422: new 142	java/lang/StringBuilder
    //   1425: dup
    //   1426: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1429: ldc_w 540
    //   1432: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: aload 20
    //   1437: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: ldc_w 542
    //   1443: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: aload 6
    //   1448: getfield 249	apaz$a:vid	Ljava/lang/String;
    //   1451: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1457: invokestatic 545	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1460: iconst_0
    //   1461: istore 8
    //   1463: goto -410 -> 1053
    //   1466: astore_2
    //   1467: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1470: ifeq +13 -> 1483
    //   1473: ldc 189
    //   1475: iconst_2
    //   1476: aload_2
    //   1477: invokestatic 485	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1480: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1483: aload 6
    //   1485: astore_2
    //   1486: goto -1370 -> 116
    //   1489: astore_2
    //   1490: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1493: ifeq +13 -> 1506
    //   1496: ldc 189
    //   1498: iconst_2
    //   1499: aload_2
    //   1500: invokestatic 485	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1503: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1506: ldc_w 532
    //   1509: astore_2
    //   1510: iconst_0
    //   1511: istore 8
    //   1513: goto -1397 -> 116
    //   1516: astore_1
    //   1517: aconst_null
    //   1518: astore_2
    //   1519: aload_2
    //   1520: ifnull +7 -> 1527
    //   1523: aload_2
    //   1524: invokevirtual 481	java/io/RandomAccessFile:close	()V
    //   1527: aload_1
    //   1528: athrow
    //   1529: astore_2
    //   1530: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1533: ifeq -6 -> 1527
    //   1536: ldc 189
    //   1538: iconst_2
    //   1539: aload_2
    //   1540: invokestatic 485	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1543: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1546: goto -19 -> 1527
    //   1549: aload 4
    //   1551: invokevirtual 348	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1554: astore 4
    //   1556: ldc 189
    //   1558: iconst_1
    //   1559: new 142	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1566: ldc_w 547
    //   1569: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: aload_2
    //   1573: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: ldc_w 549
    //   1579: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: aload 5
    //   1584: ldc_w 341
    //   1587: invokeinterface 347 2 0
    //   1592: checkcast 242	java/lang/String
    //   1595: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: ldc_w 551
    //   1601: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: aload 4
    //   1606: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1615: aload_3
    //   1616: invokevirtual 552	java/io/BufferedReader:close	()V
    //   1619: aload_1
    //   1620: ifnull -1137 -> 483
    //   1623: aload_1
    //   1624: invokevirtual 391	java/net/HttpURLConnection:disconnect	()V
    //   1627: return
    //   1628: astore_2
    //   1629: aload 6
    //   1631: astore_1
    //   1632: aload_1
    //   1633: ifnull +7 -> 1640
    //   1636: aload_1
    //   1637: invokevirtual 391	java/net/HttpURLConnection:disconnect	()V
    //   1640: aload_2
    //   1641: athrow
    //   1642: ldc 189
    //   1644: iconst_1
    //   1645: new 142	java/lang/StringBuilder
    //   1648: dup
    //   1649: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1652: ldc_w 554
    //   1655: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: aload_2
    //   1659: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1665: invokestatic 545	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1668: return
    //   1669: astore_2
    //   1670: goto -38 -> 1632
    //   1673: astore_2
    //   1674: aload 7
    //   1676: astore_1
    //   1677: goto -1231 -> 446
    //   1680: astore_1
    //   1681: goto -162 -> 1519
    //   1684: astore 7
    //   1686: aconst_null
    //   1687: astore 6
    //   1689: goto -393 -> 1296
    //   1692: ldc_w 532
    //   1695: astore_2
    //   1696: iconst_0
    //   1697: istore 8
    //   1699: goto -1583 -> 116
    //   1702: aload 6
    //   1704: astore_2
    //   1705: goto -1589 -> 116
    //   1708: goto -1065 -> 643
    //   1711: ldc_w 532
    //   1714: astore_2
    //   1715: iconst_0
    //   1716: istore 8
    //   1718: goto -1602 -> 116
    //   1721: lload 13
    //   1723: lload 11
    //   1725: lcmp
    //   1726: iflt -18 -> 1708
    //   1729: iconst_0
    //   1730: istore 8
    //   1732: goto -721 -> 1011
    //   1735: ldc2_w 223
    //   1738: lload 13
    //   1740: ladd
    //   1741: lstore 9
    //   1743: goto -22 -> 1721
    //   1746: iconst_1
    //   1747: istore 8
    //   1749: goto -738 -> 1011
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1752	0	this	HealthBusinessPlugin
    //   0	1752	1	paramString1	String
    //   0	1752	2	paramString2	String
    //   0	1752	3	paramString3	String
    //   0	1752	4	paramString4	String
    //   0	1752	5	paramMap	Map<String, String>
    //   0	1752	6	paramBundle	android.os.Bundle
    //   0	1752	7	paramUploadThread	UploadThread
    //   114	1634	8	i	int
    //   44	1698	9	l1	long
    //   30	1694	11	l2	long
    //   641	1098	13	l3	long
    //   3	1036	15	l4	long
    //   638	779	17	localRandomAccessFile	java.io.RandomAccessFile
    //   507	160	18	arrayOfByte1	byte[]
    //   513	156	19	arrayOfByte2	byte[]
    //   559	877	20	str	String
    //   1089	301	21	localJSONObject1	JSONObject
    //   1101	279	22	localJSONArray	JSONArray
    //   1132	146	23	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   142	417	445	java/lang/Exception
    //   417	423	445	java/lang/Exception
    //   428	442	445	java/lang/Exception
    //   1549	1619	445	java/lang/Exception
    //   868	873	874	java/io/IOException
    //   654	663	1290	java/lang/Exception
    //   666	685	1290	java/lang/Exception
    //   688	697	1290	java/lang/Exception
    //   700	706	1290	java/lang/Exception
    //   709	718	1290	java/lang/Exception
    //   721	737	1290	java/lang/Exception
    //   740	754	1290	java/lang/Exception
    //   757	771	1290	java/lang/Exception
    //   774	786	1290	java/lang/Exception
    //   789	803	1290	java/lang/Exception
    //   806	818	1290	java/lang/Exception
    //   821	827	1290	java/lang/Exception
    //   830	863	1290	java/lang/Exception
    //   895	901	1290	java/lang/Exception
    //   904	974	1290	java/lang/Exception
    //   977	999	1290	java/lang/Exception
    //   1019	1050	1290	java/lang/Exception
    //   1056	1063	1290	java/lang/Exception
    //   1082	1091	1290	java/lang/Exception
    //   1094	1103	1290	java/lang/Exception
    //   1109	1122	1290	java/lang/Exception
    //   1125	1134	1290	java/lang/Exception
    //   1137	1156	1290	java/lang/Exception
    //   1159	1178	1290	java/lang/Exception
    //   1181	1187	1290	java/lang/Exception
    //   1190	1226	1290	java/lang/Exception
    //   1229	1254	1290	java/lang/Exception
    //   1257	1265	1290	java/lang/Exception
    //   1277	1287	1290	java/lang/Exception
    //   1361	1371	1290	java/lang/Exception
    //   1374	1385	1290	java/lang/Exception
    //   1388	1397	1290	java/lang/Exception
    //   1419	1460	1290	java/lang/Exception
    //   1068	1073	1466	java/io/IOException
    //   1343	1348	1489	java/io/IOException
    //   627	640	1516	finally
    //   1523	1527	1529	java/io/IOException
    //   127	142	1628	finally
    //   449	475	1628	finally
    //   142	417	1669	finally
    //   417	423	1669	finally
    //   428	442	1669	finally
    //   1549	1619	1669	finally
    //   127	142	1673	java/lang/Exception
    //   654	663	1680	finally
    //   666	685	1680	finally
    //   688	697	1680	finally
    //   700	706	1680	finally
    //   709	718	1680	finally
    //   721	737	1680	finally
    //   740	754	1680	finally
    //   757	771	1680	finally
    //   774	786	1680	finally
    //   789	803	1680	finally
    //   806	818	1680	finally
    //   821	827	1680	finally
    //   830	863	1680	finally
    //   895	901	1680	finally
    //   904	974	1680	finally
    //   977	999	1680	finally
    //   1019	1050	1680	finally
    //   1056	1063	1680	finally
    //   1082	1091	1680	finally
    //   1094	1103	1680	finally
    //   1109	1122	1680	finally
    //   1125	1134	1680	finally
    //   1137	1156	1680	finally
    //   1159	1178	1680	finally
    //   1181	1187	1680	finally
    //   1190	1226	1680	finally
    //   1229	1254	1680	finally
    //   1257	1265	1680	finally
    //   1277	1287	1680	finally
    //   1299	1305	1680	finally
    //   1308	1338	1680	finally
    //   1361	1371	1680	finally
    //   1374	1385	1680	finally
    //   1388	1397	1680	finally
    //   1419	1460	1680	finally
    //   627	640	1684	java/lang/Exception
  }
  
  void efu()
  {
    Intent localIntent = null;
    Object localObject = null;
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {}
    for (;;)
    {
      return;
      File localFile = new File(acbn.oM);
      boolean bool;
      if (localFile.exists()) {
        bool = true;
      }
      for (;;)
      {
        if ((bool) && (localFile.canWrite())) {
          if ((TextUtils.isEmpty(this.cwR)) || (TextUtils.isEmpty(this.cwS)))
          {
            QLog.e("HealthBusinessPlugin", 1, "temp ids lost!");
            return;
            bool = localFile.mkdirs();
          }
          else
          {
            if (this.mRuntime == null) {}
            while ((localObject != null) && (!((Activity)localObject).isFinishing()))
            {
              localIntent = new Intent();
              this.N = FileProvider7Helper.setSystemCapture((Context)localObject, new File(acbn.oM + System.currentTimeMillis() + ".jpg"), localIntent);
              startActivityForResult(localIntent, (byte)2);
              return;
              localObject = this.mRuntime.getActivity();
            }
            break;
          }
        }
      }
      if (this.mRuntime == null) {}
      for (localObject = localIntent; (localObject != null) && (!((Activity)localObject).isFinishing()); localObject = this.mRuntime.getActivity())
      {
        QQToast.a((Context)localObject, 2131698505, 1).show(((BaseActivity)localObject).getTitleBarHeight());
        return;
      }
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((!this.mRuntime.getWebView().getUrl().contains("qq.com")) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      if ((paramLong == 8L) && ((paramString.startsWith("http://qqsport/")) || (paramString.startsWith("https://qqsport/"))) && (paramString.length() > 16))
      {
        paramString = paramString.substring(15);
        try
        {
          paramString = new File(URLDecoder.decode(paramString, "utf-8"));
          if ((paramString.exists()) || (paramString.isFile()))
          {
            paramString = new WebResourceResponse("image/*", "utf-8", new FileInputStream(paramString));
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return true;
  }
  
  void nd(List<String> paramList)
  {
    SharedPreferences localSharedPreferences = B();
    Object localObject = localSharedPreferences.getString(this.cwR, null);
    if (localObject == null) {}
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          localJSONArray.put(str);
          continue;
          localObject = new JSONObject((String)localObject);
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HealthBusinessPlugin", 2, paramList, new Object[0]);
        }
        return;
      }
    }
    ((JSONObject)localObject).put("imgList", localJSONArray);
    localSharedPreferences.edit().putString(this.cwR, ((JSONObject)localObject).toString()).commit();
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 733	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +165 -> 174
    //   12: iload_3
    //   13: iconst_m1
    //   14: if_icmpne +123 -> 137
    //   17: aload_1
    //   18: ldc_w 735
    //   21: invokevirtual 739	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 578	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwR	Ljava/lang/String;
    //   34: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +13 -> 50
    //   40: aload_0
    //   41: getfield 580	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwS	Ljava/lang/String;
    //   44: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +13 -> 60
    //   50: ldc 189
    //   52: iconst_1
    //   53: ldc_w 741
    //   56: invokestatic 545	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: return
    //   60: aload_0
    //   61: getfield 117	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   64: ifnull +8 -> 72
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 743	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:nd	(Ljava/util/List;)V
    //   72: new 164	org/json/JSONObject
    //   75: dup
    //   76: invokespecial 167	org/json/JSONObject:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: ldc_w 745
    //   86: aload_0
    //   87: getfield 578	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwR	Ljava/lang/String;
    //   90: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 580	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwS	Ljava/lang/String;
    //   99: iconst_1
    //   100: anewarray 242	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload 4
    //   107: invokevirtual 192	org/json/JSONObject:toString	()Ljava/lang/String;
    //   110: aastore
    //   111: invokespecial 749	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 117	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   118: ifnull -89 -> 29
    //   121: new 751	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$3
    //   124: dup
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 754	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$3:<init>	(Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;Ljava/util/List;)V
    //   130: iconst_5
    //   131: aconst_null
    //   132: iconst_1
    //   133: invokestatic 760	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   136: return
    //   137: iload_3
    //   138: bipush 16
    //   140: if_icmpne -111 -> 29
    //   143: aload_1
    //   144: ldc_w 735
    //   147: invokevirtual 739	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull +17 -> 169
    //   155: aload_1
    //   156: invokeinterface 762 1 0
    //   161: ifne +8 -> 169
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 743	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:nd	(Ljava/util/List;)V
    //   169: aload_0
    //   170: invokevirtual 764	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:efu	()V
    //   173: return
    //   174: iload_2
    //   175: iconst_2
    //   176: if_icmpne +295 -> 471
    //   179: aload_0
    //   180: getfield 580	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwS	Ljava/lang/String;
    //   183: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +13 -> 199
    //   189: aload_0
    //   190: getfield 578	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwR	Ljava/lang/String;
    //   193: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +13 -> 209
    //   199: ldc 189
    //   201: iconst_1
    //   202: ldc_w 766
    //   205: invokestatic 545	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: return
    //   209: new 164	org/json/JSONObject
    //   212: dup
    //   213: invokespecial 167	org/json/JSONObject:<init>	()V
    //   216: astore 5
    //   218: iload_3
    //   219: iconst_m1
    //   220: if_icmpne +232 -> 452
    //   223: aload_0
    //   224: getfield 117	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   227: ifnull +162 -> 389
    //   230: aload_0
    //   231: getfield 117	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   234: invokevirtual 611	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   237: ifnull +152 -> 389
    //   240: aload_0
    //   241: getfield 117	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   244: invokevirtual 611	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   247: invokevirtual 770	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   250: astore_1
    //   251: aload_1
    //   252: aload_0
    //   253: getfield 603	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:N	Landroid/net/Uri;
    //   256: invokestatic 776	aqhu:getRealPathFromContentURI	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   259: astore 6
    //   261: aload_1
    //   262: aload 6
    //   264: invokestatic 780	aqhu:cn	(Landroid/content/Context;Ljava/lang/String;)V
    //   267: aload_0
    //   268: invokevirtual 690	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:B	()Landroid/content/SharedPreferences;
    //   271: astore 7
    //   273: aload 7
    //   275: aload_0
    //   276: getfield 578	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwR	Ljava/lang/String;
    //   279: aconst_null
    //   280: invokeinterface 695 3 0
    //   285: astore 4
    //   287: aload 4
    //   289: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifeq +135 -> 427
    //   295: new 164	org/json/JSONObject
    //   298: dup
    //   299: invokespecial 167	org/json/JSONObject:<init>	()V
    //   302: astore_1
    //   303: aload 4
    //   305: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: ifeq +132 -> 440
    //   311: new 515	org/json/JSONArray
    //   314: dup
    //   315: invokespecial 516	org/json/JSONArray:<init>	()V
    //   318: astore 4
    //   320: aload 4
    //   322: aload 6
    //   324: invokevirtual 525	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   327: pop
    //   328: aload_1
    //   329: ldc_w 715
    //   332: aload 4
    //   334: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   337: pop
    //   338: aload 7
    //   340: invokeinterface 719 1 0
    //   345: aload_0
    //   346: getfield 578	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwR	Ljava/lang/String;
    //   349: aload_1
    //   350: invokevirtual 192	org/json/JSONObject:toString	()Ljava/lang/String;
    //   353: invokeinterface 725 3 0
    //   358: invokeinterface 728 1 0
    //   363: pop
    //   364: aload 5
    //   366: ldc_w 745
    //   369: aload_0
    //   370: getfield 578	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwR	Ljava/lang/String;
    //   373: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload 5
    //   379: ldc_w 782
    //   382: ldc_w 784
    //   385: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload_0
    //   390: getfield 117	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   393: ifnull -364 -> 29
    //   396: aload_0
    //   397: getfield 117	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   400: invokevirtual 611	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   403: ifnull -374 -> 29
    //   406: aload_0
    //   407: aload_0
    //   408: getfield 580	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwS	Ljava/lang/String;
    //   411: iconst_1
    //   412: anewarray 242	java/lang/String
    //   415: dup
    //   416: iconst_0
    //   417: aload 5
    //   419: invokevirtual 192	org/json/JSONObject:toString	()Ljava/lang/String;
    //   422: aastore
    //   423: invokespecial 749	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   426: return
    //   427: new 164	org/json/JSONObject
    //   430: dup
    //   431: aload 4
    //   433: invokespecial 166	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   436: astore_1
    //   437: goto -134 -> 303
    //   440: aload_1
    //   441: ldc_w 715
    //   444: invokevirtual 788	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   447: astore 4
    //   449: goto -129 -> 320
    //   452: aload 5
    //   454: ldc_w 782
    //   457: ldc_w 790
    //   460: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   463: pop
    //   464: goto -75 -> 389
    //   467: astore_1
    //   468: goto -79 -> 389
    //   471: iload_2
    //   472: iconst_3
    //   473: if_icmpne -444 -> 29
    //   476: iload_3
    //   477: iconst_1
    //   478: if_icmpne -449 -> 29
    //   481: aload_1
    //   482: ldc_w 792
    //   485: invokevirtual 796	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   488: astore 4
    //   490: aload_1
    //   491: ldc_w 798
    //   494: invokevirtual 796	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   497: astore_1
    //   498: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   501: ldc2_w 799
    //   504: ldiv
    //   505: invokestatic 803	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   508: astore 5
    //   510: aload_0
    //   511: getfield 580	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwS	Ljava/lang/String;
    //   514: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   517: ifne -488 -> 29
    //   520: new 164	org/json/JSONObject
    //   523: dup
    //   524: invokespecial 167	org/json/JSONObject:<init>	()V
    //   527: astore 6
    //   529: aload 6
    //   531: ldc_w 745
    //   534: aload 5
    //   536: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   539: pop
    //   540: aload_0
    //   541: aload_0
    //   542: getfield 580	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cwS	Ljava/lang/String;
    //   545: iconst_1
    //   546: anewarray 242	java/lang/String
    //   549: dup
    //   550: iconst_0
    //   551: aload 6
    //   553: invokevirtual 192	org/json/JSONObject:toString	()Ljava/lang/String;
    //   556: aastore
    //   557: invokespecial 749	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   560: new 164	org/json/JSONObject
    //   563: dup
    //   564: invokespecial 167	org/json/JSONObject:<init>	()V
    //   567: astore 6
    //   569: aload 6
    //   571: ldc_w 792
    //   574: aload 4
    //   576: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   579: pop
    //   580: aload_1
    //   581: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne +41 -> 625
    //   587: aload 6
    //   589: ldc_w 798
    //   592: aload_1
    //   593: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   596: pop
    //   597: aload_0
    //   598: invokevirtual 690	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:B	()Landroid/content/SharedPreferences;
    //   601: invokeinterface 719 1 0
    //   606: aload 5
    //   608: aload 6
    //   610: invokevirtual 192	org/json/JSONObject:toString	()Ljava/lang/String;
    //   613: invokeinterface 725 3 0
    //   618: invokeinterface 728 1 0
    //   623: pop
    //   624: return
    //   625: ldc 189
    //   627: iconst_1
    //   628: ldc_w 805
    //   631: invokestatic 545	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: goto -37 -> 597
    //   637: astore_1
    //   638: goto -249 -> 389
    //   641: astore 5
    //   643: goto -549 -> 94
    //   646: astore_1
    //   647: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	HealthBusinessPlugin
    //   0	648	1	paramIntent	Intent
    //   0	648	2	paramByte	byte
    //   0	648	3	paramInt	int
    //   79	496	4	localObject1	Object
    //   216	391	5	localObject2	Object
    //   641	1	5	localException	Exception
    //   259	350	6	localObject3	Object
    //   271	68	7	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   452	464	467	java/lang/Exception
    //   287	303	637	java/lang/Exception
    //   303	320	637	java/lang/Exception
    //   320	389	637	java/lang/Exception
    //   427	437	637	java/lang/Exception
    //   440	449	637	java/lang/Exception
    //   81	94	641	java/lang/Exception
    //   520	597	646	java/lang/Exception
    //   597	624	646	java/lang/Exception
    //   625	634	646	java/lang/Exception
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "oncreated ......");
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.f.removeView(this.cc);
    AppNetConnInfo.unregisterNetInfoHandler(this.a);
    QLog.d("HealthBusinessPlugin", 1, "onDestroy");
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = new FrameLayout.LayoutParams(-1, -1);
    paramCustomWebView.topMargin = 0;
    paramCustomWebView.leftMargin = 0;
    this.f = ((RefreshView)this.mRuntime.getActivity().findViewById(2131382187));
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "videoLayout id:" + this.f.getResources());
    }
    this.cc = new FrameLayout(this.mRuntime.getActivity());
    this.f.addView(this.cc, paramCustomWebView);
    this.l = ((TouchWebView)this.mRuntime.getWebView());
    this.cc.scrollBy(0, this.l.mTotalYoffset);
    this.l.setOnScrollChangedListener(new aqtj(this));
    QLog.d("HealthBusinessPlugin", 1, "onWebViewCreated");
    this.a = new a(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mRuntime.getActivity(), this.a);
  }
  
  class UploadThread
    extends Thread
  {
    String Tag;
    public boolean cVU;
    boolean cVV;
    String cwT;
    String feedId;
    String groupId;
    WeakReference<BaseActivity> mActivity;
    List<String> paths;
    
    String a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
    {
      HashMap localHashMap1;
      HashMap localHashMap2;
      if (ahbj.isFileExists(paramString2))
      {
        localHashMap1 = new HashMap();
        localHashMap1.put("Connection", "keep-alive");
        localHashMap1.put("Referer", "c.yundong.qq.com");
        localHashMap2 = new HashMap();
        localHashMap2.put("picstream", paramString2);
        if (paramMap != null) {
          break label200;
        }
      }
      label200:
      for (paramString2 = new HashMap();; paramString2 = paramMap)
      {
        paramString1 = jqc.a(paramString1, paramString3, paramString4, paramString2, localHashMap2, localHashMap1);
        if (QLog.isColorLevel()) {
          QLog.i("HealthBusinessPlugin", 2, "upload result:" + paramString1);
        }
        if (TextUtils.isEmpty(paramString1)) {}
        for (;;)
        {
          return null;
          try
          {
            paramString1 = new JSONObject(paramString1);
            if (paramString1.getInt("code") == 0)
            {
              paramString1 = URLDecoder.decode(paramString1.getJSONObject("data").getString("picUrl"), "utf-8");
              return paramString1;
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("HealthBusinessPlugin", 2, "parse json Err:" + paramString1);
              }
              paramString1 = null;
            }
          }
        }
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 133	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:mActivity	Lmqq/util/WeakReference;
      //   4: ifnonnull +67 -> 71
      //   7: aconst_null
      //   8: astore 4
      //   10: aload 4
      //   12: ifnull +21 -> 33
      //   15: aload 4
      //   17: invokevirtual 139	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
      //   20: ifnull +13 -> 33
      //   23: aload_0
      //   24: getfield 141	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:feedId	Ljava/lang/String;
      //   27: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   30: ifeq +56 -> 86
      //   33: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   36: ifeq +34 -> 70
      //   39: ldc 68
      //   41: iconst_2
      //   42: new 70	java/lang/StringBuilder
      //   45: dup
      //   46: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   49: ldc 143
      //   51: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: aload_0
      //   55: getfield 141	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:feedId	Ljava/lang/String;
      //   58: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   61: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   64: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   67: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   70: return
      //   71: aload_0
      //   72: getfield 133	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:mActivity	Lmqq/util/WeakReference;
      //   75: invokevirtual 155	mqq/util/WeakReference:get	()Ljava/lang/Object;
      //   78: checkcast 135	com/tencent/mobileqq/app/BaseActivity
      //   81: astore 4
      //   83: goto -73 -> 10
      //   86: aload 4
      //   88: invokevirtual 139	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
      //   91: invokevirtual 160	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
      //   94: astore 8
      //   96: aload 4
      //   98: invokevirtual 139	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
      //   101: iconst_2
      //   102: invokevirtual 164	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
      //   105: checkcast 166	mqq/manager/TicketManager
      //   108: aload 8
      //   110: invokeinterface 169 2 0
      //   115: astore 9
      //   117: aload 9
      //   119: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   122: ifeq +18 -> 140
      //   125: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   128: ifeq -58 -> 70
      //   131: ldc 68
      //   133: iconst_2
      //   134: ldc 171
      //   136: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   139: return
      //   140: sipush 5381
      //   143: istore_2
      //   144: iconst_0
      //   145: istore_1
      //   146: aload 9
      //   148: invokevirtual 177	java/lang/String:length	()I
      //   151: istore_3
      //   152: iload_1
      //   153: iload_3
      //   154: if_icmpge +23 -> 177
      //   157: iload_2
      //   158: iload_2
      //   159: iconst_5
      //   160: ishl
      //   161: aload 9
      //   163: iload_1
      //   164: invokevirtual 181	java/lang/String:charAt	(I)C
      //   167: iadd
      //   168: iadd
      //   169: istore_2
      //   170: iload_1
      //   171: iconst_1
      //   172: iadd
      //   173: istore_1
      //   174: goto -22 -> 152
      //   177: iload_2
      //   178: ldc 182
      //   180: iand
      //   181: istore_3
      //   182: ldc 68
      //   184: iconst_1
      //   185: new 70	java/lang/StringBuilder
      //   188: dup
      //   189: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   192: ldc 184
      //   194: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   197: iload_3
      //   198: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   201: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   204: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   207: aload_0
      //   208: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:cVV	Z
      //   211: ifeq +367 -> 578
      //   214: new 70	java/lang/StringBuilder
      //   217: dup
      //   218: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   221: ldc 191
      //   223: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: iload_3
      //   227: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   230: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   233: astore 4
      //   235: aload 4
      //   237: ldc 193
      //   239: aload 8
      //   241: invokestatic 199	aurr:addParameter	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   244: astore 4
      //   246: aload_0
      //   247: getfield 201	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
      //   250: getfield 204	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:cVS	Z
      //   253: ifeq +13 -> 266
      //   256: aload 4
      //   258: ldc 206
      //   260: ldc 208
      //   262: invokevirtual 211	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   265: pop
      //   266: aload_0
      //   267: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:cVV	Z
      //   270: ifne +333 -> 603
      //   273: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   276: aload_0
      //   277: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   280: invokeinterface 222 2 0
      //   285: ifne +16 -> 301
      //   288: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   291: aload_0
      //   292: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   295: invokeinterface 225 2 0
      //   300: pop
      //   301: new 173	java/lang/String
      //   304: dup
      //   305: invokespecial 226	java/lang/String:<init>	()V
      //   308: pop
      //   309: aload_0
      //   310: getfield 228	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:paths	Ljava/util/List;
      //   313: iconst_0
      //   314: invokeinterface 231 2 0
      //   319: checkcast 173	java/lang/String
      //   322: astore 6
      //   324: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   327: ifeq +50 -> 377
      //   330: ldc 68
      //   332: iconst_2
      //   333: new 70	java/lang/StringBuilder
      //   336: dup
      //   337: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   340: ldc 233
      //   342: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   345: aload_0
      //   346: getfield 228	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:paths	Ljava/util/List;
      //   349: iconst_0
      //   350: invokeinterface 231 2 0
      //   355: checkcast 173	java/lang/String
      //   358: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   361: ldc 235
      //   363: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: aload 6
      //   368: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   371: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   374: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   377: aload 6
      //   379: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   382: ifne -312 -> 70
      //   385: new 35	java/util/HashMap
      //   388: dup
      //   389: invokespecial 39	java/util/HashMap:<init>	()V
      //   392: astore 7
      //   394: aload 7
      //   396: ldc 237
      //   398: aload_0
      //   399: getfield 141	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:feedId	Ljava/lang/String;
      //   402: invokevirtual 238	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   405: pop
      //   406: new 240	android/os/Bundle
      //   409: dup
      //   410: invokespecial 241	android/os/Bundle:<init>	()V
      //   413: astore 5
      //   415: aload 5
      //   417: ldc 243
      //   419: aload_0
      //   420: getfield 245	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:Tag	Ljava/lang/String;
      //   423: invokevirtual 249	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   426: aload 5
      //   428: ldc 251
      //   430: aload_0
      //   431: getfield 253	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:cwT	Ljava/lang/String;
      //   434: invokevirtual 249	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   437: aload 5
      //   439: ldc 255
      //   441: aload 6
      //   443: invokevirtual 249	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   446: aload 5
      //   448: ldc_w 257
      //   451: new 259	java/io/File
      //   454: dup
      //   455: aload 6
      //   457: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
      //   460: invokevirtual 263	java/io/File:getName	()Ljava/lang/String;
      //   463: invokevirtual 249	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   466: aload_0
      //   467: getfield 201	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
      //   470: aload 4
      //   472: aload 6
      //   474: aload 8
      //   476: aload 9
      //   478: aload 7
      //   480: aload 5
      //   482: aload_0
      //   483: invokevirtual 266	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread;)V
      //   486: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   489: aload_0
      //   490: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   493: invokeinterface 222 2 0
      //   498: ifeq +16 -> 514
      //   501: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   504: aload_0
      //   505: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   508: invokeinterface 269 2 0
      //   513: pop
      //   514: getstatic 273	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
      //   517: aload_0
      //   518: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   521: invokevirtual 276	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   524: ifnull +14 -> 538
      //   527: getstatic 273	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:pk	Ljava/util/HashMap;
      //   530: aload_0
      //   531: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   534: invokevirtual 278	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   537: pop
      //   538: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   541: ifeq -471 -> 70
      //   544: ldc 68
      //   546: iconst_2
      //   547: new 70	java/lang/StringBuilder
      //   550: dup
      //   551: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   554: ldc_w 280
      //   557: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   560: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   563: invokeinterface 283 1 0
      //   568: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   571: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   574: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   577: return
      //   578: new 70	java/lang/StringBuilder
      //   581: dup
      //   582: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   585: ldc_w 285
      //   588: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   591: iload_3
      //   592: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   595: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   598: astore 4
      //   600: goto -365 -> 235
      //   603: aload_0
      //   604: getfield 133	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:mActivity	Lmqq/util/WeakReference;
      //   607: invokevirtual 155	mqq/util/WeakReference:get	()Ljava/lang/Object;
      //   610: checkcast 135	com/tencent/mobileqq/app/BaseActivity
      //   613: new 70	java/lang/StringBuilder
      //   616: dup
      //   617: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   620: aload 8
      //   622: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   625: ldc_w 287
      //   628: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   631: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   634: iconst_0
      //   635: invokevirtual 291	com/tencent/mobileqq/app/BaseActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   638: astore 6
      //   640: aload_0
      //   641: getfield 228	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:paths	Ljava/util/List;
      //   644: invokeinterface 295 1 0
      //   649: astore 5
      //   651: iconst_0
      //   652: istore_2
      //   653: iconst_0
      //   654: istore_1
      //   655: aload 5
      //   657: invokeinterface 300 1 0
      //   662: ifeq +257 -> 919
      //   665: aload 5
      //   667: invokeinterface 303 1 0
      //   672: checkcast 173	java/lang/String
      //   675: astore 12
      //   677: aload 6
      //   679: aload_0
      //   680: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   683: aconst_null
      //   684: invokeinterface 307 3 0
      //   689: astore 7
      //   691: aload 12
      //   693: ldc_w 309
      //   696: ldc_w 311
      //   699: invokevirtual 315	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   702: astore 10
      //   704: aload 7
      //   706: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   709: ifeq +13 -> 722
      //   712: ldc 68
      //   714: iconst_1
      //   715: ldc_w 317
      //   718: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   721: return
      //   722: aload 12
      //   724: iconst_0
      //   725: invokestatic 326	com/tencent/mobileqq/jsp/MediaApiPlugin:an	(Ljava/lang/String;I)Ljava/lang/String;
      //   728: astore 11
      //   730: aload 11
      //   732: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   735: ifeq +87 -> 822
      //   738: ldc 68
      //   740: iconst_1
      //   741: new 70	java/lang/StringBuilder
      //   744: dup
      //   745: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   748: ldc_w 328
      //   751: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   754: aload 12
      //   756: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   759: ldc_w 330
      //   762: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   765: aload 12
      //   767: invokestatic 33	ahbj:isFileExists	(Ljava/lang/String;)Z
      //   770: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   773: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   776: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   779: aload 7
      //   781: aload 10
      //   783: ldc_w 332
      //   786: invokevirtual 315	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   789: astore 7
      //   791: aload 6
      //   793: invokeinterface 336 1 0
      //   798: aload_0
      //   799: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   802: aload 7
      //   804: invokeinterface 341 3 0
      //   809: invokeinterface 344 1 0
      //   814: pop
      //   815: iload_1
      //   816: iconst_1
      //   817: iadd
      //   818: istore_1
      //   819: goto -164 -> 655
      //   822: new 35	java/util/HashMap
      //   825: dup
      //   826: invokespecial 39	java/util/HashMap:<init>	()V
      //   829: astore 12
      //   831: aload 12
      //   833: ldc_w 345
      //   836: aload_0
      //   837: getfield 141	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:feedId	Ljava/lang/String;
      //   840: invokevirtual 238	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   843: pop
      //   844: aload_0
      //   845: aload 4
      //   847: aload 11
      //   849: aload 8
      //   851: aload 9
      //   853: aload 12
      //   855: invokevirtual 347	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
      //   858: astore 11
      //   860: aload 11
      //   862: ifnull +50 -> 912
      //   865: aload 7
      //   867: aload 10
      //   869: aload 11
      //   871: ldc_w 309
      //   874: ldc_w 311
      //   877: invokevirtual 315	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   880: invokevirtual 315	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   883: astore 7
      //   885: aload 6
      //   887: invokeinterface 336 1 0
      //   892: aload_0
      //   893: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   896: aload 7
      //   898: invokeinterface 341 3 0
      //   903: invokeinterface 344 1 0
      //   908: pop
      //   909: goto -254 -> 655
      //   912: iload_2
      //   913: iconst_1
      //   914: iadd
      //   915: istore_2
      //   916: goto -261 -> 655
      //   919: aconst_null
      //   920: astore 5
      //   922: aconst_null
      //   923: astore 7
      //   925: aload 5
      //   927: astore 4
      //   929: iload_1
      //   930: aload_0
      //   931: getfield 228	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:paths	Ljava/util/List;
      //   934: invokeinterface 283 1 0
      //   939: if_icmpne +129 -> 1068
      //   942: aload 5
      //   944: astore 4
      //   946: new 93	org/json/JSONObject
      //   949: dup
      //   950: aload 6
      //   952: aload_0
      //   953: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   956: ldc_w 349
      //   959: invokeinterface 307 3 0
      //   964: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   967: astore 8
      //   969: aload 5
      //   971: astore 4
      //   973: aload 8
      //   975: ldc_w 351
      //   978: iconst_1
      //   979: invokevirtual 354	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   982: pop
      //   983: aload 5
      //   985: astore 4
      //   987: aload 6
      //   989: invokeinterface 336 1 0
      //   994: aload_0
      //   995: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   998: aload 8
      //   1000: invokevirtual 355	org/json/JSONObject:toString	()Ljava/lang/String;
      //   1003: invokeinterface 341 3 0
      //   1008: invokeinterface 344 1 0
      //   1013: pop
      //   1014: aload 5
      //   1016: astore 4
      //   1018: ldc 68
      //   1020: iconst_1
      //   1021: ldc_w 357
      //   1024: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1027: iconst_0
      //   1028: ifeq +11 -> 1039
      //   1031: new 359	java/lang/NullPointerException
      //   1034: dup
      //   1035: invokespecial 360	java/lang/NullPointerException:<init>	()V
      //   1038: athrow
      //   1039: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1042: aload_0
      //   1043: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1046: invokeinterface 222 2 0
      //   1051: ifeq -981 -> 70
      //   1054: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1057: aload_0
      //   1058: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1061: invokeinterface 269 2 0
      //   1066: pop
      //   1067: return
      //   1068: iload_2
      //   1069: ifle +92 -> 1161
      //   1072: aload 5
      //   1074: astore 4
      //   1076: ldc 68
      //   1078: iconst_1
      //   1079: new 70	java/lang/StringBuilder
      //   1082: dup
      //   1083: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   1086: ldc_w 362
      //   1089: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1092: iload_2
      //   1093: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1096: ldc_w 364
      //   1099: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1102: aload_0
      //   1103: getfield 228	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:paths	Ljava/util/List;
      //   1106: invokeinterface 283 1 0
      //   1111: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1114: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1117: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1120: iconst_0
      //   1121: ifeq +11 -> 1132
      //   1124: new 359	java/lang/NullPointerException
      //   1127: dup
      //   1128: invokespecial 360	java/lang/NullPointerException:<init>	()V
      //   1131: athrow
      //   1132: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1135: aload_0
      //   1136: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1139: invokeinterface 222 2 0
      //   1144: ifeq -1074 -> 70
      //   1147: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1150: aload_0
      //   1151: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1154: invokeinterface 269 2 0
      //   1159: pop
      //   1160: return
      //   1161: aload 5
      //   1163: astore 4
      //   1165: new 366	java/net/URL
      //   1168: dup
      //   1169: new 70	java/lang/StringBuilder
      //   1172: dup
      //   1173: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   1176: ldc_w 368
      //   1179: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1182: iload_3
      //   1183: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1186: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1189: ldc 193
      //   1191: aload 8
      //   1193: invokestatic 199	aurr:addParameter	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   1196: invokespecial 369	java/net/URL:<init>	(Ljava/lang/String;)V
      //   1199: invokevirtual 373	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   1202: checkcast 375	java/net/HttpURLConnection
      //   1205: astore 5
      //   1207: aload 5
      //   1209: sipush 5000
      //   1212: invokevirtual 379	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   1215: aload 5
      //   1217: sipush 30000
      //   1220: invokevirtual 382	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   1223: aload 5
      //   1225: iconst_1
      //   1226: invokevirtual 386	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   1229: aload 5
      //   1231: iconst_1
      //   1232: invokevirtual 389	java/net/HttpURLConnection:setDoInput	(Z)V
      //   1235: aload 5
      //   1237: iconst_0
      //   1238: invokevirtual 392	java/net/HttpURLConnection:setUseCaches	(Z)V
      //   1241: aload 5
      //   1243: ldc_w 394
      //   1246: invokevirtual 397	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   1249: aload 5
      //   1251: ldc 41
      //   1253: ldc_w 399
      //   1256: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1259: aload 5
      //   1261: ldc_w 404
      //   1264: new 70	java/lang/StringBuilder
      //   1267: dup
      //   1268: ldc_w 406
      //   1271: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1274: ldc_w 409
      //   1277: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1280: getstatic 414	android/os/Build$VERSION:SDK	Ljava/lang/String;
      //   1283: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1286: ldc_w 409
      //   1289: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1292: getstatic 419	android/os/Build:DEVICE	Ljava/lang/String;
      //   1295: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1298: ldc_w 409
      //   1301: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1304: getstatic 422	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
      //   1307: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1310: ldc_w 409
      //   1313: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1316: ldc_w 424
      //   1319: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1322: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1325: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1328: aload 5
      //   1330: ldc_w 426
      //   1333: ldc_w 428
      //   1336: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1339: aload 5
      //   1341: ldc_w 430
      //   1344: new 70	java/lang/StringBuilder
      //   1347: dup
      //   1348: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   1351: ldc_w 432
      //   1354: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1357: aload 8
      //   1359: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1362: ldc_w 434
      //   1365: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1368: aload 9
      //   1370: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1373: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1376: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1379: new 436	java/io/DataOutputStream
      //   1382: dup
      //   1383: aload 5
      //   1385: invokevirtual 440	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   1388: invokespecial 443	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   1391: astore 7
      //   1393: new 445	java/lang/StringBuffer
      //   1396: dup
      //   1397: invokespecial 446	java/lang/StringBuffer:<init>	()V
      //   1400: astore 4
      //   1402: aload 4
      //   1404: ldc_w 448
      //   1407: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1410: pop
      //   1411: aload 4
      //   1413: aload_0
      //   1414: getfield 141	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:feedId	Ljava/lang/String;
      //   1417: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1420: pop
      //   1421: aload 7
      //   1423: aload 4
      //   1425: invokevirtual 452	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   1428: invokevirtual 456	java/lang/String:getBytes	()[B
      //   1431: invokevirtual 462	java/io/OutputStream:write	([B)V
      //   1434: aload 7
      //   1436: invokevirtual 465	java/io/OutputStream:flush	()V
      //   1439: aload 7
      //   1441: invokevirtual 468	java/io/OutputStream:close	()V
      //   1444: new 445	java/lang/StringBuffer
      //   1447: dup
      //   1448: invokespecial 446	java/lang/StringBuffer:<init>	()V
      //   1451: astore 8
      //   1453: new 470	java/io/BufferedReader
      //   1456: dup
      //   1457: new 472	java/io/InputStreamReader
      //   1460: dup
      //   1461: aload 5
      //   1463: invokevirtual 476	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   1466: invokespecial 479	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   1469: invokespecial 482	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   1472: astore 4
      //   1474: aload 4
      //   1476: invokevirtual 485	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   1479: astore 7
      //   1481: aload 7
      //   1483: ifnull +92 -> 1575
      //   1486: aload 8
      //   1488: aload 7
      //   1490: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1493: ldc_w 487
      //   1496: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1499: pop
      //   1500: goto -26 -> 1474
      //   1503: astore 6
      //   1505: aload 5
      //   1507: astore 4
      //   1509: ldc 68
      //   1511: iconst_2
      //   1512: new 70	java/lang/StringBuilder
      //   1515: dup
      //   1516: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   1519: ldc_w 489
      //   1522: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1525: aload 6
      //   1527: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1530: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1533: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1536: aload 5
      //   1538: ifnull +8 -> 1546
      //   1541: aload 5
      //   1543: invokevirtual 492	java/net/HttpURLConnection:disconnect	()V
      //   1546: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1549: aload_0
      //   1550: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1553: invokeinterface 222 2 0
      //   1558: ifeq -1488 -> 70
      //   1561: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1564: aload_0
      //   1565: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1568: invokeinterface 269 2 0
      //   1573: pop
      //   1574: return
      //   1575: aload 8
      //   1577: invokevirtual 452	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   1580: astore 7
      //   1582: aload 7
      //   1584: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1587: ifeq +12 -> 1599
      //   1590: ldc 68
      //   1592: iconst_1
      //   1593: ldc_w 494
      //   1596: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1599: new 93	org/json/JSONObject
      //   1602: dup
      //   1603: aload 7
      //   1605: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   1608: ldc 98
      //   1610: invokevirtual 102	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   1613: ifne +147 -> 1760
      //   1616: new 93	org/json/JSONObject
      //   1619: dup
      //   1620: aload 6
      //   1622: aload_0
      //   1623: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1626: ldc_w 349
      //   1629: invokeinterface 307 3 0
      //   1634: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   1637: astore 8
      //   1639: aload 8
      //   1641: ldc_w 351
      //   1644: iconst_0
      //   1645: invokevirtual 354	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   1648: pop
      //   1649: aload 6
      //   1651: invokeinterface 336 1 0
      //   1656: aload_0
      //   1657: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1660: aload 8
      //   1662: invokevirtual 355	org/json/JSONObject:toString	()Ljava/lang/String;
      //   1665: invokeinterface 341 3 0
      //   1670: invokeinterface 344 1 0
      //   1675: pop
      //   1676: ldc 68
      //   1678: iconst_1
      //   1679: new 70	java/lang/StringBuilder
      //   1682: dup
      //   1683: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   1686: ldc_w 496
      //   1689: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1692: aload_0
      //   1693: getfield 141	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:feedId	Ljava/lang/String;
      //   1696: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1699: ldc_w 498
      //   1702: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1705: aload 7
      //   1707: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1710: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1713: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   1716: aload 4
      //   1718: invokevirtual 499	java/io/BufferedReader:close	()V
      //   1721: aload 5
      //   1723: ifnull +8 -> 1731
      //   1726: aload 5
      //   1728: invokevirtual 492	java/net/HttpURLConnection:disconnect	()V
      //   1731: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1734: aload_0
      //   1735: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1738: invokeinterface 222 2 0
      //   1743: ifeq -1673 -> 70
      //   1746: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1749: aload_0
      //   1750: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1753: invokeinterface 269 2 0
      //   1758: pop
      //   1759: return
      //   1760: new 93	org/json/JSONObject
      //   1763: dup
      //   1764: aload 6
      //   1766: aload_0
      //   1767: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1770: ldc_w 349
      //   1773: invokeinterface 307 3 0
      //   1778: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   1781: astore 8
      //   1783: aload 8
      //   1785: ldc_w 351
      //   1788: iconst_2
      //   1789: invokevirtual 354	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   1792: pop
      //   1793: aload 6
      //   1795: invokeinterface 336 1 0
      //   1800: aload_0
      //   1801: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1804: aload 8
      //   1806: invokevirtual 355	org/json/JSONObject:toString	()Ljava/lang/String;
      //   1809: invokeinterface 341 3 0
      //   1814: invokeinterface 344 1 0
      //   1819: pop
      //   1820: ldc 68
      //   1822: iconst_1
      //   1823: new 70	java/lang/StringBuilder
      //   1826: dup
      //   1827: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   1830: ldc_w 501
      //   1833: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1836: aload_0
      //   1837: getfield 141	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:feedId	Ljava/lang/String;
      //   1840: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1843: ldc_w 498
      //   1846: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1849: aload 7
      //   1851: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1854: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1857: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1860: goto -144 -> 1716
      //   1863: astore 6
      //   1865: aload 5
      //   1867: astore 4
      //   1869: aload 6
      //   1871: astore 5
      //   1873: aload 4
      //   1875: ifnull +8 -> 1883
      //   1878: aload 4
      //   1880: invokevirtual 492	java/net/HttpURLConnection:disconnect	()V
      //   1883: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1886: aload_0
      //   1887: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1890: invokeinterface 222 2 0
      //   1895: ifeq +16 -> 1911
      //   1898: getstatic 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:Jd	Ljava/util/List;
      //   1901: aload_0
      //   1902: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:groupId	Ljava/lang/String;
      //   1905: invokeinterface 269 2 0
      //   1910: pop
      //   1911: aload 5
      //   1913: athrow
      //   1914: astore 5
      //   1916: goto -43 -> 1873
      //   1919: astore 6
      //   1921: aload 7
      //   1923: astore 5
      //   1925: goto -420 -> 1505
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1928	0	this	UploadThread
      //   145	795	1	i	int
      //   143	950	2	j	int
      //   151	1032	3	k	int
      //   8	1871	4	localObject1	Object
      //   413	1499	5	localObject2	Object
      //   1914	1	5	localObject3	Object
      //   1923	1	5	localObject4	Object
      //   322	666	6	localObject5	Object
      //   1503	291	6	localException1	Exception
      //   1863	7	6	localObject6	Object
      //   1919	1	6	localException2	Exception
      //   392	1530	7	localObject7	Object
      //   94	1711	8	localObject8	Object
      //   115	1254	9	str1	String
      //   702	166	10	str2	String
      //   728	142	11	str3	String
      //   675	179	12	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   1207	1474	1503	java/lang/Exception
      //   1474	1481	1503	java/lang/Exception
      //   1486	1500	1503	java/lang/Exception
      //   1575	1599	1503	java/lang/Exception
      //   1599	1716	1503	java/lang/Exception
      //   1716	1721	1503	java/lang/Exception
      //   1760	1860	1503	java/lang/Exception
      //   1207	1474	1863	finally
      //   1474	1481	1863	finally
      //   1486	1500	1863	finally
      //   1575	1599	1863	finally
      //   1599	1716	1863	finally
      //   1716	1721	1863	finally
      //   1760	1860	1863	finally
      //   929	942	1914	finally
      //   946	969	1914	finally
      //   973	983	1914	finally
      //   987	1014	1914	finally
      //   1018	1027	1914	finally
      //   1076	1120	1914	finally
      //   1165	1207	1914	finally
      //   1509	1536	1914	finally
      //   929	942	1919	java/lang/Exception
      //   946	969	1919	java/lang/Exception
      //   973	983	1919	java/lang/Exception
      //   987	1014	1919	java/lang/Exception
      //   1018	1027	1919	java/lang/Exception
      //   1076	1120	1919	java/lang/Exception
      //   1165	1207	1919	java/lang/Exception
    }
  }
  
  class a
    implements INetInfoHandler
  {
    WebViewPlugin c;
    
    a(HealthBusinessPlugin paramHealthBusinessPlugin)
    {
      this.c = paramHealthBusinessPlugin;
      QLog.d("HealthBusinessPlugin", 2, "plugin to do:" + this.c);
    }
    
    public void onNetMobile2None() {}
    
    public void onNetMobile2Wifi(String paramString) {}
    
    public void onNetNone2Mobile(String paramString) {}
    
    public void onNetNone2Wifi(String paramString) {}
    
    public void onNetWifi2Mobile(String paramString) {}
    
    public void onNetWifi2None() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin
 * JD-Core Version:    0.7.0.1
 */