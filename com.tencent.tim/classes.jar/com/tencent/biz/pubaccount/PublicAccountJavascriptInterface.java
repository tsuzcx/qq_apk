package com.tencent.biz.pubaccount;

import acbn;
import acja;
import ahbj;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ProgressBar;
import anot;
import aqgo;
import aqha;
import aqhs;
import aqhv;
import aqik;
import aqiw;
import aqju;
import aqqj;
import aqul;
import aqzd;
import aqzv;
import arbo;
import arbt;
import arcd;
import ardm.i;
import ardm.j;
import ardm.o;
import ardm.q;
import auro;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.plugin.PluginBaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jpp;
import jqo;
import kam;
import kan;
import kao;
import kap;
import kaq;
import kar;
import kas;
import kat;
import kau;
import kav;
import mqq.app.AppActivity;
import oav;
import ocp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountJavascriptInterface
  extends aqzd
{
  public static final String Vz = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "pubaccount/");
  protected static HashMap<String, String> cX = new HashMap();
  private static long rh;
  private ardm.o jdField_a_of_type_Ardm$o;
  private ardm.q jdField_a_of_type_Ardm$q;
  public boolean adj = false;
  boolean adk = false;
  public Activity context;
  protected List<b> fT;
  private BroadcastReceiver mBroadcastReceiver = new kao(this);
  aqju mDialog;
  
  private void F(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (paramString1 != null) {
      ((EntityManager)localObject).remove(paramString1);
    }
    ((EntityManager)localObject).close();
  }
  
  private static boolean G(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  private String M(String paramString1, String paramString2)
  {
    return auro.decode(paramString1, paramString2);
  }
  
  /* Error */
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   4: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 88	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   15: invokevirtual 93	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   18: astore 7
    //   20: aload 7
    //   22: ifnull +844 -> 866
    //   25: aload 7
    //   27: invokevirtual 98	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   30: ifnull +836 -> 866
    //   33: new 183	org/json/JSONObject
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aload 9
    //   45: ldc 188
    //   47: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 6
    //   52: aload 6
    //   54: astore 5
    //   56: aload 6
    //   58: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +21 -> 82
    //   64: aload 6
    //   66: ldc 199
    //   68: ldc 201
    //   70: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   73: ldc 207
    //   75: ldc 209
    //   77: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   80: astore 5
    //   82: aload 4
    //   84: ldc 188
    //   86: aload 5
    //   88: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: getstatic 215	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:rh	J
    //   95: ldc2_w 216
    //   98: lcmp
    //   99: ifle +61 -> 160
    //   102: new 219	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface$16
    //   105: dup
    //   106: aload_0
    //   107: aload_3
    //   108: aload 4
    //   110: aload_2
    //   111: invokespecial 222	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface$16:<init>	(Lcom/tencent/biz/pubaccount/PublicAccountJavascriptInterface;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   114: invokestatic 228	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   117: return
    //   118: astore_1
    //   119: aload_0
    //   120: aload_3
    //   121: iconst_1
    //   122: anewarray 114	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: new 38	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   134: ldc 230
    //   136: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 4
    //   141: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   144: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 233
    //   149: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: aastore
    //   156: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   159: return
    //   160: aload 9
    //   162: ldc 239
    //   164: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   167: astore 6
    //   169: aload 6
    //   171: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifeq +44 -> 218
    //   177: aload_0
    //   178: aload_3
    //   179: iconst_1
    //   180: anewarray 114	java/lang/String
    //   183: dup
    //   184: iconst_0
    //   185: new 38	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   192: ldc 241
    //   194: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 4
    //   199: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   202: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 233
    //   207: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: aastore
    //   214: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   217: return
    //   218: aload 9
    //   220: ldc 243
    //   222: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 5
    //   227: aload 5
    //   229: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   232: ifeq +44 -> 276
    //   235: aload_0
    //   236: aload_3
    //   237: iconst_1
    //   238: anewarray 114	java/lang/String
    //   241: dup
    //   242: iconst_0
    //   243: new 38	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   250: ldc 245
    //   252: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 4
    //   257: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   260: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 233
    //   265: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: aastore
    //   272: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   275: return
    //   276: aload 9
    //   278: ldc 247
    //   280: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   283: astore 8
    //   285: aload 8
    //   287: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   290: ifeq +44 -> 334
    //   293: aload_0
    //   294: aload_3
    //   295: iconst_1
    //   296: anewarray 114	java/lang/String
    //   299: dup
    //   300: iconst_0
    //   301: new 38	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   308: ldc 249
    //   310: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 4
    //   315: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   318: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc 233
    //   323: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: aastore
    //   330: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   333: return
    //   334: aload_1
    //   335: invokevirtual 254	java/net/URL:getHost	()Ljava/lang/String;
    //   338: astore_1
    //   339: aload 9
    //   341: ldc_w 256
    //   344: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore_2
    //   348: aload_2
    //   349: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifne +511 -> 863
    //   355: aload_2
    //   356: aload_1
    //   357: invokestatic 258	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:G	(Ljava/lang/String;Ljava/lang/String;)Z
    //   360: ifeq +278 -> 638
    //   363: aload_2
    //   364: astore_1
    //   365: aload_1
    //   366: astore_2
    //   367: aload_1
    //   368: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifeq +7 -> 378
    //   374: ldc_w 260
    //   377: astore_2
    //   378: aload_0
    //   379: aload 8
    //   381: invokespecial 263	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:hash	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore_1
    //   385: aload_0
    //   386: aload_2
    //   387: aload 6
    //   389: aload 5
    //   391: aload_1
    //   392: invokespecial 267	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:h	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: aload 8
    //   398: aload_1
    //   399: invokespecial 270	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:encrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   402: astore 8
    //   404: new 272	java/io/File
    //   407: dup
    //   408: new 38	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   415: getstatic 64	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:Vz	Ljava/lang/String;
    //   418: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 274
    //   424: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 7
    //   429: invokevirtual 98	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   432: invokestatic 279	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   435: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokespecial 280	java/io/File:<init>	(Ljava/lang/String;)V
    //   444: astore_1
    //   445: aload_1
    //   446: invokevirtual 284	java/io/File:exists	()Z
    //   449: ifne +231 -> 680
    //   452: aload_1
    //   453: invokevirtual 287	java/io/File:mkdirs	()Z
    //   456: pop
    //   457: new 272	java/io/File
    //   460: dup
    //   461: aload_1
    //   462: aload_2
    //   463: invokespecial 290	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   466: astore_1
    //   467: aload_1
    //   468: invokevirtual 284	java/io/File:exists	()Z
    //   471: ifne +229 -> 700
    //   474: aload_1
    //   475: invokevirtual 287	java/io/File:mkdirs	()Z
    //   478: pop
    //   479: new 272	java/io/File
    //   482: dup
    //   483: aload_1
    //   484: aload 6
    //   486: invokestatic 279	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   489: invokespecial 290	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   492: astore 6
    //   494: aload 6
    //   496: invokevirtual 284	java/io/File:exists	()Z
    //   499: ifne +221 -> 720
    //   502: aload 6
    //   504: invokevirtual 287	java/io/File:mkdirs	()Z
    //   507: pop
    //   508: aconst_null
    //   509: astore_1
    //   510: aload_0
    //   511: monitorenter
    //   512: aload_1
    //   513: astore_2
    //   514: new 272	java/io/File
    //   517: dup
    //   518: aload 6
    //   520: aload 5
    //   522: invokestatic 279	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: invokespecial 290	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   528: astore 5
    //   530: aload_1
    //   531: astore_2
    //   532: aload 5
    //   534: invokevirtual 284	java/io/File:exists	()Z
    //   537: ifeq +11 -> 548
    //   540: aload_1
    //   541: astore_2
    //   542: aload 5
    //   544: invokevirtual 293	java/io/File:delete	()Z
    //   547: pop
    //   548: aload_1
    //   549: astore_2
    //   550: new 295	java/io/FileWriter
    //   553: dup
    //   554: aload 5
    //   556: invokespecial 298	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   559: astore_1
    //   560: aload_1
    //   561: aload 8
    //   563: invokevirtual 301	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   566: getstatic 215	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:rh	J
    //   569: aload 5
    //   571: invokevirtual 305	java/io/File:length	()J
    //   574: ladd
    //   575: putstatic 215	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:rh	J
    //   578: aload_0
    //   579: monitorexit
    //   580: aload_1
    //   581: astore_2
    //   582: aload_0
    //   583: aload_3
    //   584: iconst_1
    //   585: anewarray 114	java/lang/String
    //   588: dup
    //   589: iconst_0
    //   590: new 38	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   597: ldc_w 307
    //   600: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload 4
    //   605: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   608: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: ldc 233
    //   613: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: aastore
    //   620: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   623: aload_1
    //   624: ifnull +242 -> 866
    //   627: aload_1
    //   628: invokevirtual 308	java/io/FileWriter:close	()V
    //   631: return
    //   632: astore_1
    //   633: aload_1
    //   634: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   637: return
    //   638: aload_0
    //   639: aload_3
    //   640: iconst_1
    //   641: anewarray 114	java/lang/String
    //   644: dup
    //   645: iconst_0
    //   646: new 38	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 313
    //   656: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 4
    //   661: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   664: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc 233
    //   669: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: aastore
    //   676: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   679: return
    //   680: aload_1
    //   681: invokevirtual 316	java/io/File:isFile	()Z
    //   684: ifeq -227 -> 457
    //   687: aload_1
    //   688: invokevirtual 293	java/io/File:delete	()Z
    //   691: pop
    //   692: aload_1
    //   693: invokevirtual 287	java/io/File:mkdirs	()Z
    //   696: pop
    //   697: goto -240 -> 457
    //   700: aload_1
    //   701: invokevirtual 316	java/io/File:isFile	()Z
    //   704: ifeq -225 -> 479
    //   707: aload_1
    //   708: invokevirtual 293	java/io/File:delete	()Z
    //   711: pop
    //   712: aload_1
    //   713: invokevirtual 287	java/io/File:mkdirs	()Z
    //   716: pop
    //   717: goto -238 -> 479
    //   720: aload 6
    //   722: invokevirtual 316	java/io/File:isFile	()Z
    //   725: ifeq -217 -> 508
    //   728: aload 6
    //   730: invokevirtual 293	java/io/File:delete	()Z
    //   733: pop
    //   734: aload 6
    //   736: invokevirtual 287	java/io/File:mkdirs	()Z
    //   739: pop
    //   740: goto -232 -> 508
    //   743: astore 5
    //   745: aload_2
    //   746: astore_1
    //   747: aload_1
    //   748: astore_2
    //   749: aload_0
    //   750: monitorexit
    //   751: aload 5
    //   753: athrow
    //   754: astore_2
    //   755: aload_1
    //   756: astore_2
    //   757: aload_0
    //   758: aload_3
    //   759: iconst_1
    //   760: anewarray 114	java/lang/String
    //   763: dup
    //   764: iconst_0
    //   765: new 38	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   772: ldc_w 318
    //   775: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload 4
    //   780: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   783: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: ldc 233
    //   788: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: aastore
    //   795: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   798: aload_1
    //   799: ifnull +67 -> 866
    //   802: aload_1
    //   803: invokevirtual 308	java/io/FileWriter:close	()V
    //   806: return
    //   807: astore_1
    //   808: aload_1
    //   809: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   812: return
    //   813: astore_1
    //   814: aconst_null
    //   815: astore_2
    //   816: aload_2
    //   817: ifnull +7 -> 824
    //   820: aload_2
    //   821: invokevirtual 308	java/io/FileWriter:close	()V
    //   824: aload_1
    //   825: athrow
    //   826: astore_2
    //   827: aload_2
    //   828: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   831: goto -7 -> 824
    //   834: astore 5
    //   836: aload_1
    //   837: astore_2
    //   838: aload 5
    //   840: astore_1
    //   841: goto -25 -> 816
    //   844: astore_1
    //   845: goto -29 -> 816
    //   848: astore_1
    //   849: aconst_null
    //   850: astore_1
    //   851: goto -96 -> 755
    //   854: astore_2
    //   855: goto -100 -> 755
    //   858: astore 5
    //   860: goto -113 -> 747
    //   863: goto -498 -> 365
    //   866: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	867	0	this	PublicAccountJavascriptInterface
    //   0	867	1	paramURL	URL
    //   0	867	2	paramString1	String
    //   0	867	3	paramString2	String
    //   0	867	4	paramJSONObject	JSONObject
    //   54	516	5	localObject1	Object
    //   743	9	5	localObject2	Object
    //   834	5	5	localObject3	Object
    //   858	1	5	localObject4	Object
    //   50	685	6	localObject5	Object
    //   18	410	7	localAppInterface	AppInterface
    //   283	279	8	str	String
    //   41	299	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	10	118	org/json/JSONException
    //   11	20	118	org/json/JSONException
    //   25	52	118	org/json/JSONException
    //   56	82	118	org/json/JSONException
    //   82	117	118	org/json/JSONException
    //   160	217	118	org/json/JSONException
    //   218	275	118	org/json/JSONException
    //   276	333	118	org/json/JSONException
    //   334	363	118	org/json/JSONException
    //   367	374	118	org/json/JSONException
    //   378	457	118	org/json/JSONException
    //   457	479	118	org/json/JSONException
    //   479	508	118	org/json/JSONException
    //   627	631	118	org/json/JSONException
    //   633	637	118	org/json/JSONException
    //   638	679	118	org/json/JSONException
    //   680	697	118	org/json/JSONException
    //   700	717	118	org/json/JSONException
    //   720	740	118	org/json/JSONException
    //   802	806	118	org/json/JSONException
    //   808	812	118	org/json/JSONException
    //   820	824	118	org/json/JSONException
    //   824	826	118	org/json/JSONException
    //   827	831	118	org/json/JSONException
    //   627	631	632	java/io/IOException
    //   514	530	743	finally
    //   532	540	743	finally
    //   542	548	743	finally
    //   550	560	743	finally
    //   749	751	743	finally
    //   751	754	754	java/io/IOException
    //   802	806	807	java/io/IOException
    //   510	512	813	finally
    //   820	824	826	java/io/IOException
    //   751	754	834	finally
    //   582	623	844	finally
    //   757	798	844	finally
    //   510	512	848	java/io/IOException
    //   582	623	854	java/io/IOException
    //   560	580	858	finally
  }
  
  private void b(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    CustomWebView localCustomWebView = this.mRuntime.getWebView();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      ThreadManager.post(new PublicAccountJavascriptInterface.15(this, new URL(localCustomWebView.getUrl()), paramString1, paramString2, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  private static long bZ()
  {
    Object localObject = new File(Vz);
    if (!((File)localObject).exists()) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    long l = 0L;
    while (!localArrayList.isEmpty())
    {
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l = ((File)localObject).length() + l;
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(localObject[i]);
            i += 1;
          }
        }
      }
    }
    return l;
  }
  
  private void bo(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = ((EntityManager)localObject).query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[] { paramString1, paramString2 }, null, null, null, null);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        ((EntityManager)localObject).remove((CouponH5Data)paramString1.next());
      }
    }
    ((EntityManager)localObject).close();
  }
  
  public static void deleteAllH5Data(AppInterface paramAppInterface)
  {
    EntityManager localEntityManager = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    Object localObject1 = localEntityManager.query(CouponH5Data.class);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CouponH5Data)((Iterator)localObject1).next();
        localObject2 = new File(Vz + "/" + aqhs.String2HexString(paramAppInterface.getAccount()) + "/" + ((CouponH5Data)localObject2).mHost);
        if (((File)localObject2).exists()) {
          ahbj.deleteFile((File)localObject2);
        }
      }
    }
    localEntityManager.drop(CouponH5Data.class);
    localEntityManager.close();
  }
  
  private void e(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.mRuntime.getWebView() == null) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.context == null) || (this.context.isFinishing()));
        if (!(this.context instanceof AppActivity)) {
          break label292;
        }
        if ((this.mDialog != null) && (this.mDialog.isShowing())) {
          this.mDialog.dismiss();
        }
        str = "";
        localObject = this.mRuntime.a();
        if (localObject != null) {
          str = ((AppInterface)localObject).getAccount();
        }
        localObject = "";
        if (this.mRuntime.getWebView() != null) {
          localObject = jqo.dV(this.mRuntime.getWebView().getUrl());
        }
        if (!getLocationPermissionGrant(str, (String)localObject)) {
          break;
        }
        f(paramBoolean, paramString1, paramString2);
      } while (!QLog.isColorLevel());
      QLog.d("PAjs", 2, "already grant");
      return;
      if (!this.adj) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PAjs", 2, "already ask");
    return;
    this.mDialog = aqha.a(this.context, 0);
    this.mDialog.setMessage(this.context.getString(2131721838, new Object[] { localObject }));
    this.mDialog.setPositiveButton(2131721896, new kat(this, paramBoolean, paramString1, paramString2, str, (String)localObject));
    this.mDialog.setNegativeButton(this.context.getString(2131721908), new kau(this, paramString2));
    this.mDialog.setOnCancelListener(new kav(this, paramString2));
    this.mDialog.show();
    return;
    label292:
    callJs(paramString2, new String[] { "-4", "{}" });
  }
  
  private static String ee(String paramString)
  {
    Object localObject = new ByteArrayOutputStream(1024);
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        paramString = (HttpURLConnection)new URL(paramString).openConnection();
        paramString.setDoInput(true);
        paramString.connect();
        paramString = paramString.getInputStream();
        arrayOfByte = new byte[1024];
        int i = paramString.read(arrayOfByte);
        if (i == -1)
        {
          paramString.close();
          arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          if (BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length) == null) {
            return null;
          }
        }
        else
        {
          ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
          continue;
        }
        if ((arrayOfByte[0] & 0xFF) != 66) {
          break label225;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
        localObject = "data:image;base64,";
        if (((arrayOfByte[0] & 0xFF) == 255) && ((arrayOfByte[1] & 0xFF) == 216))
        {
          paramString = "data:image/jpeg;base64,";
          return paramString + aqgo.encodeToString(arrayOfByte, 2);
          paramString = (String)localObject;
          if ((arrayOfByte[0] & 0xFF) != 71) {
            continue;
          }
          paramString = (String)localObject;
          if ((arrayOfByte[1] & 0xFF) != 73) {
            continue;
          }
          paramString = "data:image/gif;base64,";
          continue;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if ((arrayOfByte[1] & 0xFF) == 77) {
        paramString = "data:image/bmp;base64,";
      } else {
        label225:
        if (((arrayOfByte[0] & 0xFF) == 137) && ((arrayOfByte[1] & 0xFF) == 80)) {
          paramString = "data:image/png;base64,";
        }
      }
    }
  }
  
  private String encrypt(String paramString1, String paramString2)
  {
    return auro.encode(paramString1, paramString2);
  }
  
  private void f(boolean paramBoolean, String paramString1, String paramString2)
  {
    int j = 0;
    boolean bool2 = false;
    long l1 = 0L;
    int i = j;
    boolean bool1 = bool2;
    try
    {
      paramString1 = new JSONObject(paramString1);
      i = j;
      bool1 = bool2;
      bool2 = paramString1.optBoolean("fallback", false);
      i = j;
      bool1 = bool2;
      j = paramString1.optInt("decrypt_padding", 0);
      i = j;
      bool1 = bool2;
      long l2 = paramString1.optLong("allowCacheTime", 0L);
      l1 = 1000L * l2;
      bool1 = bool2;
      i = j;
    }
    catch (JSONException paramString1)
    {
      label96:
      break label96;
    }
    ((AppActivity)this.context).requestPermissions(new kam(this, paramBoolean, i, bool1, paramString2, l1), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  public static boolean getLocationPermissionGrant(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PAjs", 1, new Object[] { "uin:", paramString1, " host:", paramString2 });
      bool = false;
    }
    do
    {
      return bool;
      if (paramString2.contains("qq.com"))
      {
        QLog.d("PAjs", 1, "qq.com can grant");
        return true;
      }
    } while (BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "LocationPermissionPref", 0).getInt(paramString2 + "-location", 0) == 1);
    return false;
  }
  
  private void h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((EntityManager)localObject).persist(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      return;
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).update(localCouponH5Data);
    }
  }
  
  private String hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = aqhs.bytes2HexStr(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "wronghash";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label33:
      break label33;
    }
  }
  
  private void lM(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString = ((EntityManager)localObject).query(CouponH5Data.class, false, "mHost = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((EntityManager)localObject).remove((CouponH5Data)paramString.next());
      }
    }
    ((EntityManager)localObject).close();
  }
  
  /* Error */
  private String m(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 183	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 678	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: new 114	java/lang/String
    //   12: dup
    //   13: aload_1
    //   14: ldc_w 656
    //   17: invokespecial 681	java/lang/String:<init>	([BLjava/lang/String;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_1
    //   23: new 183	org/json/JSONObject
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore 6
    //   35: new 183	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 678	org/json/JSONObject:<init>	()V
    //   42: astore 8
    //   44: new 683	org/json/JSONArray
    //   47: dup
    //   48: invokespecial 684	org/json/JSONArray:<init>	()V
    //   51: astore 9
    //   53: new 683	org/json/JSONArray
    //   56: dup
    //   57: invokespecial 684	org/json/JSONArray:<init>	()V
    //   60: astore 10
    //   62: new 183	org/json/JSONObject
    //   65: dup
    //   66: invokespecial 678	org/json/JSONObject:<init>	()V
    //   69: astore 11
    //   71: new 183	org/json/JSONObject
    //   74: dup
    //   75: invokespecial 678	org/json/JSONObject:<init>	()V
    //   78: astore 12
    //   80: new 683	org/json/JSONArray
    //   83: dup
    //   84: invokespecial 684	org/json/JSONArray:<init>	()V
    //   87: astore_3
    //   88: new 683	org/json/JSONArray
    //   91: dup
    //   92: invokespecial 684	org/json/JSONArray:<init>	()V
    //   95: astore 5
    //   97: new 183	org/json/JSONObject
    //   100: dup
    //   101: invokespecial 678	org/json/JSONObject:<init>	()V
    //   104: astore 7
    //   106: new 183	org/json/JSONObject
    //   109: dup
    //   110: invokespecial 678	org/json/JSONObject:<init>	()V
    //   113: astore_1
    //   114: aload 6
    //   116: ldc_w 686
    //   119: invokevirtual 690	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   122: astore 4
    //   124: aload 4
    //   126: astore_1
    //   127: aload 6
    //   129: ldc_w 692
    //   132: invokevirtual 696	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   135: astore 4
    //   137: aload 6
    //   139: ldc_w 698
    //   142: invokevirtual 696	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   145: astore 5
    //   147: aload 6
    //   149: ldc_w 700
    //   152: invokevirtual 690	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   155: astore 6
    //   157: aload 4
    //   159: astore_3
    //   160: aload 5
    //   162: astore 4
    //   164: aload_3
    //   165: astore 5
    //   167: aload 6
    //   169: astore_3
    //   170: aload 12
    //   172: ldc_w 702
    //   175: aload_1
    //   176: ldc_w 704
    //   179: invokevirtual 706	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload 12
    //   188: ldc_w 708
    //   191: aload_1
    //   192: ldc_w 710
    //   195: invokevirtual 706	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload 12
    //   204: ldc_w 712
    //   207: aload_1
    //   208: ldc_w 714
    //   211: invokevirtual 706	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: iconst_0
    //   219: istore_2
    //   220: iload_2
    //   221: aload 5
    //   223: invokevirtual 717	org/json/JSONArray:length	()I
    //   226: if_icmpge +166 -> 392
    //   229: new 183	org/json/JSONObject
    //   232: dup
    //   233: invokespecial 678	org/json/JSONObject:<init>	()V
    //   236: astore_1
    //   237: aload 5
    //   239: iload_2
    //   240: invokevirtual 720	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   243: checkcast 183	org/json/JSONObject
    //   246: astore 6
    //   248: aload_1
    //   249: ldc_w 722
    //   252: aload 6
    //   254: ldc_w 724
    //   257: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   260: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   263: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload_1
    //   268: ldc_w 731
    //   271: aload 6
    //   273: ldc_w 733
    //   276: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   279: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   282: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload_1
    //   287: ldc_w 735
    //   290: aload 6
    //   292: ldc_w 737
    //   295: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   298: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   301: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   304: pop
    //   305: aload_1
    //   306: ldc_w 739
    //   309: aload 6
    //   311: ldc_w 741
    //   314: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   317: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   320: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   323: pop
    //   324: aload_1
    //   325: ldc_w 743
    //   328: aload 6
    //   330: ldc_w 745
    //   333: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   336: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   339: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload 10
    //   345: aload_1
    //   346: invokevirtual 748	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   349: pop
    //   350: iload_2
    //   351: iconst_1
    //   352: iadd
    //   353: istore_2
    //   354: goto -134 -> 220
    //   357: astore_3
    //   358: new 114	java/lang/String
    //   361: dup
    //   362: aload_1
    //   363: invokespecial 750	java/lang/String:<init>	([B)V
    //   366: astore_1
    //   367: goto -344 -> 23
    //   370: astore_1
    //   371: goto -336 -> 35
    //   374: astore 4
    //   376: aload_3
    //   377: astore 4
    //   379: aload 5
    //   381: astore_3
    //   382: aload_3
    //   383: astore 5
    //   385: aload 7
    //   387: astore_3
    //   388: goto -218 -> 170
    //   391: astore_1
    //   392: iconst_0
    //   393: istore_2
    //   394: iload_2
    //   395: aload 4
    //   397: invokevirtual 717	org/json/JSONArray:length	()I
    //   400: if_icmpge +72 -> 472
    //   403: new 183	org/json/JSONObject
    //   406: dup
    //   407: invokespecial 678	org/json/JSONObject:<init>	()V
    //   410: astore_1
    //   411: aload 4
    //   413: iload_2
    //   414: invokevirtual 720	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   417: checkcast 183	org/json/JSONObject
    //   420: astore 5
    //   422: aload_1
    //   423: ldc_w 752
    //   426: aload 5
    //   428: ldc_w 754
    //   431: invokevirtual 706	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload_1
    //   439: ldc_w 743
    //   442: aload 5
    //   444: ldc_w 756
    //   447: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   450: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   453: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 9
    //   459: aload_1
    //   460: invokevirtual 748	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   463: pop
    //   464: iload_2
    //   465: iconst_1
    //   466: iadd
    //   467: istore_2
    //   468: goto -74 -> 394
    //   471: astore_1
    //   472: aload 11
    //   474: ldc_w 758
    //   477: aload_3
    //   478: ldc_w 760
    //   481: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   484: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   490: pop
    //   491: aload 11
    //   493: ldc_w 762
    //   496: aload_3
    //   497: ldc_w 764
    //   500: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   503: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   506: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   509: pop
    //   510: aload 11
    //   512: ldc_w 766
    //   515: aload_3
    //   516: ldc_w 768
    //   519: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   522: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   525: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   528: pop
    //   529: aload 11
    //   531: ldc_w 770
    //   534: aload_3
    //   535: ldc_w 772
    //   538: invokevirtual 726	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   541: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   544: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   547: pop
    //   548: aload 8
    //   550: ldc_w 774
    //   553: aload 12
    //   555: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   558: pop
    //   559: aload 8
    //   561: ldc_w 776
    //   564: aload 11
    //   566: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   569: pop
    //   570: aload 8
    //   572: ldc_w 778
    //   575: aload 10
    //   577: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   580: pop
    //   581: aload 8
    //   583: ldc_w 780
    //   586: aload 9
    //   588: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   591: pop
    //   592: aload 8
    //   594: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   597: areturn
    //   598: astore_1
    //   599: goto -7 -> 592
    //   602: astore_1
    //   603: goto -22 -> 581
    //   606: astore_1
    //   607: goto -37 -> 570
    //   610: astore_1
    //   611: goto -52 -> 559
    //   614: astore_1
    //   615: goto -67 -> 548
    //   618: astore_1
    //   619: goto -401 -> 218
    //   622: astore 4
    //   624: aload_3
    //   625: astore 4
    //   627: aload 5
    //   629: astore_3
    //   630: goto -248 -> 382
    //   633: astore 5
    //   635: aload_3
    //   636: astore 5
    //   638: aload 4
    //   640: astore_3
    //   641: aload 5
    //   643: astore 4
    //   645: goto -263 -> 382
    //   648: astore_3
    //   649: aload 4
    //   651: astore_3
    //   652: aload 5
    //   654: astore 4
    //   656: goto -274 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	PublicAccountJavascriptInterface
    //   0	659	1	paramArrayOfByte	byte[]
    //   219	249	2	i	int
    //   20	150	3	localObject1	Object
    //   357	20	3	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   381	260	3	localObject2	Object
    //   648	1	3	localJSONException1	JSONException
    //   651	1	3	localObject3	Object
    //   122	41	4	localObject4	Object
    //   374	1	4	localJSONException2	JSONException
    //   377	35	4	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   622	1	4	localJSONException3	JSONException
    //   625	30	4	localObject5	Object
    //   95	533	5	localObject6	Object
    //   633	1	5	localJSONException4	JSONException
    //   636	17	5	localObject7	Object
    //   7	322	6	localObject8	Object
    //   104	282	7	localJSONObject1	JSONObject
    //   42	551	8	localJSONObject2	JSONObject
    //   51	536	9	localJSONArray1	JSONArray
    //   60	516	10	localJSONArray2	JSONArray
    //   69	496	11	localJSONObject3	JSONObject
    //   78	476	12	localJSONObject4	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	21	357	java/io/UnsupportedEncodingException
    //   23	32	370	org/json/JSONException
    //   114	124	374	org/json/JSONException
    //   220	350	391	org/json/JSONException
    //   394	464	471	org/json/JSONException
    //   581	592	598	org/json/JSONException
    //   570	581	602	org/json/JSONException
    //   559	570	606	org/json/JSONException
    //   548	559	610	org/json/JSONException
    //   472	548	614	org/json/JSONException
    //   170	218	618	org/json/JSONException
    //   127	137	622	org/json/JSONException
    //   137	147	633	org/json/JSONException
    //   147	157	648	org/json/JSONException
  }
  
  private String n(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return null;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject).close();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.mData;; paramString1 = null) {
      return paramString1;
    }
  }
  
  public static void setLocationPermissionGrant(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PAjs", 1, new Object[] { "uin:", paramString1, " host:", paramString2 });
      return;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "LocationPermissionPref", 0).edit().putInt(paramString2 + "-location", paramInt).commit();
  }
  
  private void w(String paramString, long paramLong)
  {
    ((AppActivity)this.context).requestPermissions(new kas(this, paramString, paramLong), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  /* Error */
  protected String L(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   4: invokevirtual 93	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +7 -> 18
    //   14: ldc_w 423
    //   17: areturn
    //   18: ldc_w 806
    //   21: astore 4
    //   23: new 183	org/json/JSONObject
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: astore_3
    //   36: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +33 -> 72
    //   42: ldc_w 441
    //   45: iconst_2
    //   46: new 38	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 808
    //   56: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_2
    //   60: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 811	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload 5
    //   71: astore_3
    //   72: new 813	android/os/Bundle
    //   75: dup
    //   76: invokespecial 814	android/os/Bundle:<init>	()V
    //   79: astore 5
    //   81: aload 5
    //   83: ldc_w 816
    //   86: ldc_w 818
    //   89: invokevirtual 821	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload 4
    //   94: astore_2
    //   95: aload_3
    //   96: ifnull +33 -> 129
    //   99: aload 4
    //   101: astore_2
    //   102: aload_3
    //   103: ldc_w 823
    //   106: invokevirtual 826	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   109: ifeq +20 -> 129
    //   112: aload_3
    //   113: ldc_w 823
    //   116: invokevirtual 706	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 829	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   124: astore 4
    //   126: aload 4
    //   128: astore_2
    //   129: aload_3
    //   130: ifnull +70 -> 200
    //   133: aload_3
    //   134: ldc_w 831
    //   137: invokevirtual 826	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +60 -> 200
    //   143: aload_3
    //   144: ldc_w 831
    //   147: invokevirtual 690	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 834	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   155: astore 4
    //   157: aload 4
    //   159: invokeinterface 379 1 0
    //   164: ifeq +36 -> 200
    //   167: aload 4
    //   169: invokeinterface 383 1 0
    //   174: invokevirtual 835	java/lang/Object:toString	()Ljava/lang/String;
    //   177: astore 7
    //   179: aload 5
    //   181: aload 7
    //   183: aload_3
    //   184: aload 7
    //   186: invokevirtual 706	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 821	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -35 -> 157
    //   195: astore_3
    //   196: aload_3
    //   197: invokevirtual 836	org/json/JSONException:printStackTrace	()V
    //   200: aload 6
    //   202: invokevirtual 98	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   205: astore_3
    //   206: new 38	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 838
    //   216: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_3
    //   220: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: astore_3
    //   227: new 813	android/os/Bundle
    //   230: dup
    //   231: invokespecial 814	android/os/Bundle:<init>	()V
    //   234: astore 4
    //   236: aload 4
    //   238: ldc_w 840
    //   241: aload_3
    //   242: invokevirtual 821	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 404	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:context	Landroid/app/Activity;
    //   249: invokevirtual 844	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   252: aload_1
    //   253: aload_2
    //   254: aload 5
    //   256: aload 4
    //   258: invokestatic 849	jqc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   261: astore_1
    //   262: aload_1
    //   263: areturn
    //   264: astore 4
    //   266: ldc_w 806
    //   269: astore_2
    //   270: aload 4
    //   272: invokevirtual 836	org/json/JSONException:printStackTrace	()V
    //   275: goto -146 -> 129
    //   278: astore_1
    //   279: aload_1
    //   280: invokevirtual 850	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   283: ldc_w 852
    //   286: areturn
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   292: ldc_w 854
    //   295: areturn
    //   296: astore 4
    //   298: goto -28 -> 270
    //   301: astore_2
    //   302: aconst_null
    //   303: astore_3
    //   304: goto -232 -> 72
    //   307: astore_2
    //   308: aload 5
    //   310: astore_3
    //   311: goto -239 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	PublicAccountJavascriptInterface
    //   0	314	1	paramString1	String
    //   0	314	2	paramString2	String
    //   35	149	3	localObject1	Object
    //   195	2	3	localJSONException1	JSONException
    //   205	106	3	localObject2	Object
    //   21	236	4	localObject3	Object
    //   264	7	4	localJSONException2	JSONException
    //   296	1	4	localJSONException3	JSONException
    //   31	278	5	localObject4	Object
    //   7	194	6	localAppInterface	AppInterface
    //   177	8	7	str	String
    // Exception table:
    //   from	to	target	type
    //   133	157	195	org/json/JSONException
    //   157	192	195	org/json/JSONException
    //   102	120	264	org/json/JSONException
    //   245	262	278	org/apache/http/client/ClientProtocolException
    //   245	262	287	java/io/IOException
    //   120	126	296	org/json/JSONException
    //   23	33	301	org/json/JSONException
    //   36	69	307	org/json/JSONException
  }
  
  protected void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new PublicAccountJavascriptInterface.14(this, paramString1, paramString2, paramJSONObject));
      return;
    }
    b(paramString1, paramString2, paramJSONObject);
  }
  
  /* Error */
  protected void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   4: invokevirtual 93	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: new 183	org/json/JSONObject
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc 188
    //   29: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: astore_1
    //   37: aload 5
    //   39: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +20 -> 62
    //   45: aload 5
    //   47: ldc 199
    //   49: ldc 201
    //   51: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   54: ldc 207
    //   56: ldc 209
    //   58: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   61: astore_1
    //   62: aload_3
    //   63: ldc 188
    //   65: aload_1
    //   66: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload 7
    //   72: ldc 239
    //   74: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 5
    //   79: aload 5
    //   81: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifeq +84 -> 168
    //   87: aload_0
    //   88: aload_2
    //   89: iconst_1
    //   90: anewarray 114	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: new 38	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   102: ldc 241
    //   104: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   111: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 233
    //   116: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: aastore
    //   123: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   126: return
    //   127: astore_1
    //   128: aload_0
    //   129: aload_2
    //   130: iconst_1
    //   131: anewarray 114	java/lang/String
    //   134: dup
    //   135: iconst_0
    //   136: new 38	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   143: ldc 230
    //   145: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_3
    //   149: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 233
    //   157: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: aastore
    //   164: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   167: return
    //   168: new 251	java/net/URL
    //   171: dup
    //   172: aload 4
    //   174: invokespecial 339	java/net/URL:<init>	(Ljava/lang/String;)V
    //   177: invokevirtual 254	java/net/URL:getHost	()Ljava/lang/String;
    //   180: astore_1
    //   181: aload 7
    //   183: ldc_w 256
    //   186: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 4
    //   191: aload 4
    //   193: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +661 -> 857
    //   199: aload 4
    //   201: aload_1
    //   202: invokestatic 258	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:G	(Ljava/lang/String;Ljava/lang/String;)Z
    //   205: ifeq +78 -> 283
    //   208: aload 4
    //   210: astore_1
    //   211: aload_1
    //   212: astore 4
    //   214: aload_1
    //   215: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifeq +8 -> 226
    //   221: ldc_w 260
    //   224: astore 4
    //   226: aload 7
    //   228: ldc 243
    //   230: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 7
    //   235: aload 7
    //   237: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifeq +84 -> 324
    //   243: aload_0
    //   244: aload_2
    //   245: iconst_1
    //   246: anewarray 114	java/lang/String
    //   249: dup
    //   250: iconst_0
    //   251: new 38	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   258: ldc 245
    //   260: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   267: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 233
    //   272: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: aastore
    //   279: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   282: return
    //   283: aload_0
    //   284: aload_2
    //   285: iconst_1
    //   286: anewarray 114	java/lang/String
    //   289: dup
    //   290: iconst_0
    //   291: new 38	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 313
    //   301: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_3
    //   305: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   308: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 233
    //   313: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: aastore
    //   320: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   323: return
    //   324: aload_0
    //   325: aload 4
    //   327: aload 5
    //   329: aload 7
    //   331: invokespecial 884	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:n	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   334: astore_1
    //   335: aload_1
    //   336: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   339: ifeq +44 -> 383
    //   342: aload_0
    //   343: aload_2
    //   344: iconst_1
    //   345: anewarray 114	java/lang/String
    //   348: dup
    //   349: iconst_0
    //   350: new 38	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   357: ldc_w 886
    //   360: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_3
    //   364: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   367: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc 233
    //   372: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: aastore
    //   379: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   382: return
    //   383: new 272	java/io/File
    //   386: dup
    //   387: new 38	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   394: getstatic 64	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:Vz	Ljava/lang/String;
    //   397: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc_w 274
    //   403: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 6
    //   408: invokevirtual 98	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   411: invokestatic 279	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc_w 274
    //   420: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 4
    //   425: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc_w 274
    //   431: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 5
    //   436: invokestatic 279	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 274
    //   445: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 7
    //   450: invokestatic 279	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   453: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokespecial 280	java/io/File:<init>	(Ljava/lang/String;)V
    //   462: astore 6
    //   464: aload 6
    //   466: invokevirtual 284	java/io/File:exists	()Z
    //   469: ifne +44 -> 513
    //   472: aload_0
    //   473: aload_2
    //   474: iconst_1
    //   475: anewarray 114	java/lang/String
    //   478: dup
    //   479: iconst_0
    //   480: new 38	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 886
    //   490: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload_3
    //   494: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   497: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: ldc 233
    //   502: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: aastore
    //   509: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   512: return
    //   513: aload_0
    //   514: monitorenter
    //   515: new 888	java/io/FileInputStream
    //   518: dup
    //   519: aload 6
    //   521: invokespecial 889	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   524: astore 4
    //   526: aload 4
    //   528: astore 5
    //   530: aload 6
    //   532: invokevirtual 305	java/io/File:length	()J
    //   535: l2i
    //   536: newarray byte
    //   538: astore 6
    //   540: aload 4
    //   542: astore 5
    //   544: aload 4
    //   546: aload 6
    //   548: invokevirtual 532	java/io/InputStream:read	([B)I
    //   551: pop
    //   552: aload 4
    //   554: astore 5
    //   556: aload_0
    //   557: new 114	java/lang/String
    //   560: dup
    //   561: aload 6
    //   563: invokespecial 750	java/lang/String:<init>	([B)V
    //   566: aload_1
    //   567: invokespecial 891	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:M	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   570: astore_1
    //   571: aload_1
    //   572: ifnonnull +70 -> 642
    //   575: aload 4
    //   577: astore 5
    //   579: aload_0
    //   580: aload_2
    //   581: iconst_1
    //   582: anewarray 114	java/lang/String
    //   585: dup
    //   586: iconst_0
    //   587: new 38	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   594: ldc_w 886
    //   597: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_3
    //   601: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   604: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc 233
    //   609: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: aastore
    //   616: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   619: aload 4
    //   621: astore 5
    //   623: aload_0
    //   624: monitorexit
    //   625: aload 4
    //   627: ifnull +233 -> 860
    //   630: aload 4
    //   632: invokevirtual 533	java/io/InputStream:close	()V
    //   635: return
    //   636: astore_1
    //   637: aload_1
    //   638: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   641: return
    //   642: aload 4
    //   644: astore 5
    //   646: aload_3
    //   647: ldc 247
    //   649: aload_1
    //   650: ldc 199
    //   652: ldc 201
    //   654: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   657: ldc 207
    //   659: ldc 209
    //   661: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   664: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   667: pop
    //   668: aload 4
    //   670: astore 5
    //   672: aload_0
    //   673: monitorexit
    //   674: aload 4
    //   676: astore 5
    //   678: aload 4
    //   680: astore_1
    //   681: aload_0
    //   682: aload_2
    //   683: iconst_1
    //   684: anewarray 114	java/lang/String
    //   687: dup
    //   688: iconst_0
    //   689: new 38	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 307
    //   699: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_3
    //   703: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc 233
    //   711: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: aastore
    //   718: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   721: aload 4
    //   723: ifnull +137 -> 860
    //   726: aload 4
    //   728: invokevirtual 533	java/io/InputStream:close	()V
    //   731: return
    //   732: astore_1
    //   733: aload_1
    //   734: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   737: return
    //   738: astore 4
    //   740: aconst_null
    //   741: astore_1
    //   742: aload_1
    //   743: astore 5
    //   745: aload_0
    //   746: monitorexit
    //   747: aload_1
    //   748: astore 5
    //   750: aload 4
    //   752: athrow
    //   753: astore_1
    //   754: aload 5
    //   756: astore_1
    //   757: aload_0
    //   758: aload_2
    //   759: iconst_1
    //   760: anewarray 114	java/lang/String
    //   763: dup
    //   764: iconst_0
    //   765: new 38	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   772: ldc_w 318
    //   775: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_3
    //   779: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   782: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: ldc 233
    //   787: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: aastore
    //   794: invokevirtual 237	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   797: aload 5
    //   799: ifnull +61 -> 860
    //   802: aload 5
    //   804: invokevirtual 533	java/io/InputStream:close	()V
    //   807: return
    //   808: astore_1
    //   809: aload_1
    //   810: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   813: return
    //   814: astore 4
    //   816: aconst_null
    //   817: astore_1
    //   818: aload_1
    //   819: ifnull +7 -> 826
    //   822: aload_1
    //   823: invokevirtual 533	java/io/InputStream:close	()V
    //   826: aload 4
    //   828: athrow
    //   829: astore_1
    //   830: aload_1
    //   831: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   834: goto -8 -> 826
    //   837: astore 4
    //   839: goto -21 -> 818
    //   842: astore_1
    //   843: aconst_null
    //   844: astore 5
    //   846: goto -92 -> 754
    //   849: astore 4
    //   851: aload 5
    //   853: astore_1
    //   854: goto -112 -> 742
    //   857: goto -646 -> 211
    //   860: return
    //   861: astore_1
    //   862: aconst_null
    //   863: astore_1
    //   864: goto -683 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	867	0	this	PublicAccountJavascriptInterface
    //   0	867	1	paramString1	String
    //   0	867	2	paramString2	String
    //   0	867	3	paramJSONObject	JSONObject
    //   0	867	4	paramString3	String
    //   32	820	5	str	String
    //   7	555	6	localObject1	Object
    //   23	426	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	127	org/json/JSONException
    //   15	34	127	org/json/JSONException
    //   37	62	127	org/json/JSONException
    //   62	126	127	org/json/JSONException
    //   168	181	127	org/json/JSONException
    //   181	208	127	org/json/JSONException
    //   214	221	127	org/json/JSONException
    //   226	282	127	org/json/JSONException
    //   283	323	127	org/json/JSONException
    //   324	382	127	org/json/JSONException
    //   383	512	127	org/json/JSONException
    //   630	635	127	org/json/JSONException
    //   637	641	127	org/json/JSONException
    //   726	731	127	org/json/JSONException
    //   733	737	127	org/json/JSONException
    //   802	807	127	org/json/JSONException
    //   809	813	127	org/json/JSONException
    //   822	826	127	org/json/JSONException
    //   826	829	127	org/json/JSONException
    //   830	834	127	org/json/JSONException
    //   630	635	636	java/io/IOException
    //   726	731	732	java/io/IOException
    //   515	526	738	finally
    //   681	721	753	java/io/IOException
    //   750	753	753	java/io/IOException
    //   802	807	808	java/io/IOException
    //   513	515	814	finally
    //   822	826	829	java/io/IOException
    //   681	721	837	finally
    //   750	753	837	finally
    //   757	797	837	finally
    //   513	515	842	java/io/IOException
    //   530	540	849	finally
    //   544	552	849	finally
    //   556	571	849	finally
    //   579	619	849	finally
    //   623	625	849	finally
    //   646	668	849	finally
    //   672	674	849	finally
    //   745	747	849	finally
    //   168	181	861	java/net/MalformedURLException
  }
  
  public void actionSheetAdditionalItems(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "actionSheetAdditionalItems->paramStr:" + paramString);
    }
    try
    {
      Object localObject = ocp.e(paramString);
      if (localObject != null)
      {
        paramString = (arbt)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("pageType"))
        {
          int j = ((JSONObject)localObject).getInt("pageType");
          localObject = ((JSONObject)localObject).getJSONArray("itemList");
          ArrayList localArrayList = new ArrayList();
          if (localObject != null)
          {
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              a locala = new a();
              locala.itemType = localJSONObject.optInt("itemType");
              locala.itemName = localJSONObject.optString("itemName");
              locala.VH = localJSONObject.optString("itemActionData");
              localArrayList.add(locala);
              i += 1;
            }
          }
          if (paramString != null)
          {
            if (j == 1) {
              paramString.bfD = true;
            }
            for (;;)
            {
              paramString.qp = localArrayList;
              return;
              paramString.bfE = true;
            }
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs", 2, "actionSheetAdditionalItems->error:" + paramString);
      }
    }
  }
  
  public void close()
  {
    this.context.finish();
  }
  
  public void deleteH5Data(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.getWebView();
    if (localCustomWebView == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    JSONObject localJSONObject2;
    String str2;
    try
    {
      localJSONObject2 = new JSONObject(paramString1);
      str1 = localJSONObject2.optString("callid");
      paramString1 = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString1 = str1.replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject1.put("callid", paramString1);
      str2 = localJSONObject2.optString("path");
      if (TextUtils.isEmpty(str2))
      {
        callJs(paramString2, new String[] { "{ret:-6, response:" + localJSONObject1.toString() + "}" });
        return;
      }
    }
    catch (JSONException paramString1)
    {
      callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    String str3 = localJSONObject2.optString("key");
    paramString1 = null;
    try
    {
      str1 = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = str1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;) {}
    }
    String str1 = localJSONObject2.optString("host");
    if (!TextUtils.isEmpty(str1))
    {
      if (G(str1, paramString1))
      {
        paramString1 = str1;
        str1 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str1 = "defaulthost";
        }
        if (!TextUtils.isEmpty(str3)) {
          break label474;
        }
        bo(str1, str2);
        ahbj.deleteFile(new File(Vz + "/" + aqhs.String2HexString(localAppInterface.getAccount()) + "/" + str1 + "/" + aqhs.String2HexString(str2)));
      }
      for (;;)
      {
        callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject1.toString() + "}" });
        return;
        callJs(paramString2, new String[] { "{ret:-5, response:" + localJSONObject1.toString() + "}" });
        return;
        label474:
        F(str1, str2, str3);
        ahbj.deleteFile(new File(Vz + "/" + aqhs.String2HexString(localAppInterface.getAccount()) + "/" + str1 + "/" + aqhs.String2HexString(str2) + "/" + aqhs.String2HexString(str3)));
      }
    }
  }
  
  public void deleteH5DataByHost(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.getWebView();
    if (localCustomWebView == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    try
    {
      localJSONObject2 = new JSONObject(paramString1);
      str = localJSONObject2.optString("callid");
      paramString1 = str;
      if (!TextUtils.isEmpty(str)) {
        paramString1 = str.replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject1.put("callid", paramString1);
      paramString1 = null;
    }
    catch (JSONException paramString1)
    {
      JSONObject localJSONObject2;
      String str;
      label159:
      label185:
      callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    try
    {
      str = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label159;
      break label185;
    }
    str = localJSONObject2.optString("host");
    if (!TextUtils.isEmpty(str))
    {
      if (G(str, paramString1))
      {
        paramString1 = str;
        str = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str = "defaulthost";
        }
        lM(str);
        ahbj.deleteFile(new File(Vz + "/" + aqhs.String2HexString(localAppInterface.getAccount()) + "/" + str));
        callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject1.toString() + "}" });
        return;
      }
      callJs(paramString2, new String[] { "{ret:-5, response:" + localJSONObject1.toString() + "}" });
      return;
    }
  }
  
  public void enableNotCare(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enable share dian dian->paramStr:" + paramString);
    }
    try
    {
      Object localObject = ocp.e(paramString);
      if (localObject != null)
      {
        paramString = (arbt)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("enable"))
        {
          localObject = ((JSONObject)localObject).getString("enable");
          if (paramString != null)
          {
            if ("1".equals(localObject))
            {
              paramString.Tu(true);
              return;
            }
            paramString.Tu(false);
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs", 2, "enable Share dian dian->error:" + paramString);
      }
    }
  }
  
  public void enableScreenshot(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enableScreenshot->enable:" + paramString);
    }
    arbo localarbo = (arbo)super.getBrowserComponent(64);
    if (localarbo != null)
    {
      if ("1".equals(paramString)) {
        localarbo.VZ("");
      }
    }
    else {
      return;
    }
    localarbo.eha();
  }
  
  public void enableShareDianDian(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enable share dian dian->paramStr:" + paramString);
    }
    try
    {
      Object localObject = ocp.e(paramString);
      if (localObject != null)
      {
        paramString = (arbt)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("enable"))
        {
          String str = ((JSONObject)localObject).getString("enable");
          if (paramString != null)
          {
            if (!"1".equals(str)) {
              break label126;
            }
            paramString.Ts(true);
          }
        }
        for (;;)
        {
          if (!((JSONObject)localObject).has("enableShortLink")) {
            return;
          }
          localObject = ((JSONObject)localObject).getString("enableShortLink");
          if (paramString == null) {
            return;
          }
          if (!"1".equals(localObject)) {
            break;
          }
          paramString.Tt(true);
          return;
          label126:
          paramString.Ts(false);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PAjs", 2, "enable Share dian dian->error:" + paramString);
        return;
        paramString.Tt(false);
      }
    }
  }
  
  public void enableShareSinaWeibo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enableShareSinaWeibo->paramStr:" + paramString);
    }
    try
    {
      paramString = ocp.e(paramString);
      if ((paramString != null) && (paramString.has("enable")))
      {
        paramString = paramString.getString("enable");
        arbt localarbt = (arbt)super.getBrowserComponent(4);
        if (localarbt != null)
        {
          if ("1".equals(paramString))
          {
            localarbt.Tr(true);
            return;
          }
          localarbt.Tr(false);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs", 2, "enableShareSinaWeibo->error:" + paramString);
      }
    }
  }
  
  public void getJson(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    callJs("clientCallback", new String[] { jqo.toJsString("{'r': -102, 'msg': 'no such method'}"), jqo.toJsString(paramString4) });
  }
  
  public void getLocation(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("PAjs.location", 2, "getLocation:" + paramString);
    }
    if (this.mRuntime.getWebView() == null) {
      if (QLog.isColorLevel()) {
        QLog.w("PAjs.location", 2, "getWebView()==null, return");
      }
    }
    Object localObject1;
    Object localObject2;
    label331:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((this.context != null) && (!this.context.isFinishing())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("PAjs.location", 2, "context==null || isFinishing, return");
          return;
          if (paramString.charAt(0) == '{') {}
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject(paramString);
              paramString = ((JSONObject)localObject1).getString("callback");
              l = ((JSONObject)localObject1).optLong("allowCacheTime", 0L) * 1000L;
              bool = ((JSONObject)localObject1).optBoolean("is_for_ecshop_map");
              localObject1 = "";
              localObject2 = this.mRuntime.a();
              if (localObject2 != null) {
                localObject1 = ((AppInterface)localObject2).getAccount();
              }
              if ((!bool) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                break label331;
              }
              localObject1 = ((AppInterface)localObject2).getApp().getSharedPreferences((String)localObject1, 0);
              double d1 = ((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F);
              double d2 = ((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F);
              if (QLog.isColorLevel()) {
                QLog.i("EcShopAssistantActivity", 2, String.format("'longitude:%1$1.15f,latitude:%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }));
              }
              callJs(paramString, new String[] { String.format("'%1$1.15f,%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }) });
              return;
            }
            catch (JSONException paramString) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("PAjs.location", 2, "getLocation exception:", paramString);
            return;
            boolean bool = false;
          }
          localObject2 = "";
          if (this.mRuntime.getWebView() != null) {
            localObject2 = jqo.getSpecifiedLevelDomain(this.mRuntime.getWebView().getUrl(), 2);
          }
        } while (TextUtils.isEmpty(paramString));
        if (!(this.context instanceof AppActivity)) {
          break label577;
        }
        if ((this.mDialog != null) && (this.mDialog.isShowing())) {
          this.mDialog.dismiss();
        }
        if (!getLocationPermissionGrant((String)localObject1, (String)localObject2)) {
          break;
        }
        w(paramString, l);
      } while (!QLog.isColorLevel());
      QLog.d("PAjs", 2, "already grant");
      return;
      if (!this.adj) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PAjs", 2, "already ask");
    return;
    this.mDialog = aqha.a(this.context, 0);
    this.mDialog.setMessage(this.context.getString(2131721838, new Object[] { localObject2 }));
    this.mDialog.setPositiveButton(2131721896, new kap(this, paramString, l, (String)localObject1, (String)localObject2));
    this.mDialog.setNegativeButton(this.context.getString(2131721908), new kaq(this, paramString));
    this.mDialog.setOnCancelListener(new kar(this, paramString));
    this.mDialog.show();
    return;
    label577:
    callJs(paramString, new String[] { "-4", "{}" });
  }
  
  public String getNameSpace()
  {
    return "publicAccount";
  }
  
  public int getNetworkState()
  {
    return aqiw.getNetworkType(BaseApplication.getContext());
  }
  
  public String getNetworkType()
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo != null)
    {
      switch (localNetworkInfo.getType())
      {
      default: 
        return "other";
      case 1: 
        return "WiFi";
      }
      String str;
      switch (localNetworkInfo.getSubtype())
      {
      case 7: 
      case 10: 
      case 11: 
      default: 
        str = "other_";
      }
      for (;;)
      {
        return str + localNetworkInfo.getExtraInfo();
        str = "CDMA_";
        continue;
        str = "EDGE_";
        continue;
        str = "GPRS";
        continue;
        str = "EVDO_0_";
        continue;
        str = "EVDO_A_";
        continue;
        str = "EVDO_B_";
        continue;
        str = "UMTS_";
        continue;
        str = "HSUPA_";
        continue;
        str = "HSDPA_";
      }
    }
    return "empty";
  }
  
  public void getPageLoadStamp(String paramString)
  {
    if (this.jdField_a_of_type_Ardm$o != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Ardm$o.getCurrentUrl())) {}
      for (String str = this.jdField_a_of_type_Ardm$o.getCurrentUrl();; str = "")
      {
        if (this.jdField_a_of_type_Ardm$q != null) {
          callJs(paramString, new String[] { "{ret:0, onCreateTime:" + this.jdField_a_of_type_Ardm$q.getmOnCreateMilliTimeStamp() + ", startLoadUrlTime:" + this.jdField_a_of_type_Ardm$q.getmStartLoadUrlMilliTimeStamp() + ", url:'" + str + "'}" });
        }
        return;
      }
    }
    callJs(paramString, new String[] { "{ret: -1}" });
  }
  
  public void getRealLocation(String paramString1, String paramString2)
  {
    e(false, paramString1, paramString2);
  }
  
  public void getRealLocationDes(String paramString1, String paramString2)
  {
    e(true, paramString1, paramString2);
  }
  
  public void getUrlImage(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramString1))
    {
      new PublicAccountJavascriptInterface.12(this, paramString1, localJSONObject, paramString2).start();
      return;
    }
    callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
  }
  
  public void hideLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localObject != null) && ((localObject instanceof ardm.j))) {
      ((ardm.j)localObject).hideLoading();
    }
    do
    {
      return;
      localObject = (arcd)super.getBrowserComponent(2);
    } while ((localObject == null) || (((arcd)localObject).ar == null));
    ((arcd)localObject).ar.setVisibility(8);
  }
  
  public void isFollowUin(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1)) {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
    }
    for (;;)
    {
      return;
      localObject = this.mRuntime.a();
      if (localObject != null) {
        try
        {
          paramString1 = new JSONObject(paramString1).optString("uin");
          if (!TextUtils.isEmpty(paramString1)) {
            if (((localObject instanceof BrowserAppInterface)) || (localObject.getClass().getSimpleName().equalsIgnoreCase("ReadInJoyInterfaceProxy")))
            {
              ThreadManager.executeOnSubThread(new PublicAccountJavascriptInterface.18(this, (AppInterface)localObject, paramString1, localJSONObject, paramString2));
              return;
            }
          }
        }
        catch (JSONException paramString1)
        {
          callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject.toString() + "}" });
          return;
        }
      }
    }
    Object localObject = (acja)((AppInterface)localObject).getManager(56);
    if (localObject != null) {}
    for (boolean bool = ((acja)localObject).f(Long.valueOf(paramString1));; bool = false)
    {
      localJSONObject.put("follow", bool);
      callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject.toString() + "}" });
      return;
    }
  }
  
  public void officalAccountShareRichMsg2QQ(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      String str4 = ((JSONObject)localObject).getString("oaUin");
      String str5 = ((JSONObject)localObject).getString("title");
      String str6 = ((JSONObject)localObject).getString("summary");
      String str7 = ((JSONObject)localObject).getString("targetUrl");
      paramString = "";
      if (((JSONObject)localObject).has("imageUrl")) {
        paramString = ((JSONObject)localObject).getString("imageUrl");
      }
      String str1 = "";
      if (((JSONObject)localObject).has("sourceName")) {
        str1 = ((JSONObject)localObject).getString("sourceName");
      }
      String str2 = "false";
      if (((JSONObject)localObject).has("needback")) {
        str2 = ((JSONObject)localObject).getString("needback");
      }
      String str3 = "";
      if (((JSONObject)localObject).has("callback")) {
        str3 = ((JSONObject)localObject).getString("callback");
      }
      localObject = this.mRuntime.a(this.mRuntime.getActivity());
      if ((localObject != null) && ((localObject instanceof ardm.i))) {
        ((ardm.i)localObject).a(str4, str5, str6, str7, paramString, str1, str2, str3);
      }
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_30", "share_click", 0, 0, str4, "", "", "");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(getClass().getSimpleName(), 2, paramString.getMessage());
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this.mRuntime.getActivity();
    this.fT = new ArrayList();
    if (rh == 0L) {
      ThreadManager.executeOnNetWorkThread(new PublicAccountJavascriptInterface.1(this));
    }
    aqzv localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.o))) {
      this.jdField_a_of_type_Ardm$o = ((ardm.o)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.q))) {
      this.jdField_a_of_type_Ardm$q = ((ardm.q)localaqzv);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.fT.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (!localb.isCancelled()) {
        localb.cancel(true);
      }
    }
    this.fT.clear();
    this.fT = null;
    if (this.adk) {
      this.context.unregisterReceiver(this.mBroadcastReceiver);
    }
    if ((this.mDialog != null) && (this.mDialog.isShowing())) {
      this.mDialog.dismiss();
    }
    super.onDestroy();
  }
  
  public void open(String paramString)
  {
    if ("com.tencent.mobileqq.activity.ChatBubbleSettingActivity".equals(paramString))
    {
      VasWebviewUtil.openQQBrowserWithoutAD(this.context, aqqj.o(this.context, "bubble", ""), 64L, null, false, -1);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this.context, paramString));
    this.context.startActivity(localIntent);
  }
  
  public void openAccountPageMore(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "openAccountPageMore->paramStr:" + paramString);
    }
    try
    {
      paramString = ocp.e(paramString);
      if (paramString != null)
      {
        long l = paramString.getLong("puin");
        if (this.context != null)
        {
          paramString = new Intent(this.context, AccountDetailActivity.class);
          paramString.putExtra("uin", "" + l);
          paramString.putExtra("from_js", true);
          this.context.startActivity(paramString);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PAjs", 2, "openAccountPageMore->error:" + paramString);
    }
  }
  
  public void openEmoji()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null) {
      return;
    }
    EmojiHomeUiPlugin.openEmojiHomePage(this.context, localAppInterface.getAccount(), 2);
  }
  
  public void openInExternalBrowser(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PAjs", 2, "openInExternalBrowser:" + paramString);
    }
    if (paramString != null) {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    }
    try
    {
      Thread.sleep(200L);
      this.context.startActivity(paramString);
      return;
    }
    catch (Exception paramString) {}catch (ActivityNotFoundException paramString) {}
  }
  
  public void openUrl(String paramString)
  {
    Object localObject;
    Intent localIntent;
    if (paramString != null)
    {
      localObject = this.context.getIntent();
      localIntent = new Intent(this.context, this.context.getClass());
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        break label80;
      }
      localObject = new Bundle();
    }
    for (;;)
    {
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("url", paramString);
      localIntent.setFlags(0);
      this.context.startActivityForResult(localIntent, 100);
      return;
      label80:
      ((Bundle)localObject).remove("title");
      ((Bundle)localObject).remove("leftViewText");
      ((Bundle)localObject).remove("post_data");
      ((Bundle)localObject).remove("options");
    }
  }
  
  public void readH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1)) {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
    }
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.getWebView();
    } while (localCustomWebView == null);
    new Thread(new PublicAccountJavascriptInterface.17(this, paramString1, paramString2, localJSONObject, localCustomWebView.getUrl())).start();
  }
  
  public void setNavigationBarStyle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    WebViewFragment localWebViewFragment;
    do
    {
      return;
      localWebViewFragment = this.mRuntime.b();
    } while (localWebViewFragment == null);
    try
    {
      switch (new JSONObject(paramString).optInt("style"))
      {
      case 0: 
        localWebViewFragment.a.Tv(false);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    localWebViewFragment.a.Tv(true);
    return;
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3)
  {
    ((AbsBaseWebViewActivity)this.context).a(paramString3, paramString1, paramString2, false, 0, 0, null, null);
  }
  
  public void setScreenshotAttr(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "setScreenshotAttr->paramStr:" + paramString);
    }
    try
    {
      arbo localarbo = (arbo)super.getBrowserComponent(64);
      paramString = ocp.e(paramString);
      String str;
      if ((paramString != null) && (paramString.has("title")))
      {
        str = paramString.getString("title");
        if (localarbo != null) {
          localarbo.ol(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareUrl")))
      {
        str = paramString.getString("shareUrl");
        if (localarbo != null) {
          localarbo.on(str);
        }
      }
      if ((paramString != null) && (paramString.has("sinaShareTitle")))
      {
        str = paramString.getString("sinaShareTitle");
        if (localarbo != null) {
          localarbo.ok(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareActionSheetTitle")))
      {
        paramString = paramString.optJSONArray("shareActionSheetTitle");
        if (localarbo != null) {
          localarbo.y(paramString);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PAjs", 2, "setScreenshotAttr->error:" + paramString);
    }
  }
  
  @Deprecated
  public void showDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool1 = "true".equals(paramString3);
    boolean bool2 = "true".equals(paramString4);
    paramString3 = aqha.a(this.context, 0);
    paramString3.setTitle(paramString1);
    paramString3.setMessage(paramString2);
    new kan(this, paramString6, paramString5);
    if ((!bool2) || (bool1)) {}
    try
    {
      paramString3.show();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void showLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localObject != null) && ((localObject instanceof ardm.j))) {
      ((ardm.j)localObject).showLoading();
    }
    do
    {
      return;
      localObject = (arcd)super.getBrowserComponent(2);
    } while ((localObject == null) || (((arcd)localObject).ar == null));
    ((arcd)localObject).ar.setVisibility(0);
  }
  
  public void showProfile(String paramString)
  {
    int i = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("PAjs", 2, "showProfile: " + paramString);
    }
    if (paramString == null) {
      return;
    }
    paramString = paramString.trim();
    Object localObject2 = "";
    String str1 = "";
    Object localObject3 = null;
    if (paramString.startsWith("{")) {}
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      int j;
      String str2;
      String str3;
      try
      {
        localObject5 = new JSONObject(paramString);
        localObject4 = ((JSONObject)localObject5).getString("uin");
        int m = ((JSONObject)localObject5).optInt("uinType", 0);
        j = ((JSONObject)localObject5).optInt("isFinish", 0);
        if ("groupSearchOther".equals(((JSONObject)localObject5).optString("jump_from")))
        {
          paramString = "group";
          i = ((JSONObject)localObject5).optInt("subSourceID");
          localObject1 = localObject3;
          localObject2 = str1;
          if (((JSONObject)localObject5).optInt("colorScreen") != 0) {
            localObject2 = "&colorScreen=" + ((JSONObject)localObject5).optInt("colorScreen");
          }
          str2 = ((JSONObject)localObject5).optString("authKey");
          str1 = ((JSONObject)localObject5).optString("authSig");
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramString;
          paramString = (String)localObject4;
          if ((paramString == null) || (paramString.length() < 5)) {
            break;
          }
          if (localObject3 == null) {
            break label576;
          }
          this.context.startActivity((Intent)localObject3);
          if (j != 1) {
            break;
          }
          paramString = new IntentFilter();
          paramString.addAction("start_recomend_page");
          this.context.registerReceiver(this.mBroadcastReceiver, paramString);
          this.adk = true;
          return;
        }
        if (m == 1)
        {
          paramString = "group";
          i = ((JSONObject)localObject5).optInt("wSourceSubID");
          localObject1 = localObject3;
          continue;
        }
        localObject1 = localObject3;
        i = k;
        paramString = (String)localObject2;
        if (m != 0) {
          continue;
        }
        str3 = ((JSONObject)localObject5).optString("from");
        str2 = ((JSONObject)localObject5).optString("troopuin");
        if ((!"groupActivity".equals(str3)) || (TextUtils.isEmpty(str2))) {
          break label467;
        }
        localObject1 = new Intent(this.context, FriendProfileCardActivity.class);
        paramString = new ProfileActivity.AllInOne((String)localObject4, 120);
        paramString.troopcode = str2;
        ((Intent)localObject1).putExtra("AllInOne", paramString);
        paramString = new Bundle();
        paramString.putString("troop_uin", str2);
        ((Intent)localObject1).putExtra("flc_extra_param", paramString);
        i = k;
        paramString = (String)localObject2;
        continue;
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      catch (JSONException paramString) {}
      QLog.d("PAjs", 4, "showProfile param error");
      return;
      label467:
      Object localObject1 = localObject3;
      i = k;
      paramString = (String)localObject2;
      if ("groupMembers".equals(str3))
      {
        localObject1 = localObject3;
        i = k;
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = new Intent(this.context, FriendProfileCardActivity.class);
          ((Intent)localObject1).putExtra("troopUin", str2);
          ((Intent)localObject1).putExtra("memberUin", (String)localObject4);
          i = k;
          paramString = (String)localObject2;
          continue;
          j = 0;
          str2 = "";
          str1 = "";
          localObject1 = "";
          localObject3 = null;
          continue;
          label576:
          localObject4 = this.mRuntime.a();
          localObject5 = new StringBuilder();
          if (!TextUtils.isEmpty(str2))
          {
            localObject3 = "&authKey=" + str2;
            label625:
            ((StringBuilder)localObject5).append((String)localObject3);
            if (TextUtils.isEmpty(str1)) {
              break label763;
            }
          }
          label763:
          for (str1 = "&authSig=" + str1;; str1 = "")
          {
            ((StringBuilder)localObject5).append(str1);
            paramString = "mqq://card/show_pslcard/?uin=" + paramString + "&card_type=" + (String)localObject2 + "&wSourceSubID=" + i + ((StringBuilder)localObject5).toString() + (String)localObject1;
            if (!(localObject4 instanceof QQAppInterface)) {
              break label771;
            }
            aqik.c((QQAppInterface)localObject4, this.context, paramString).ace();
            break;
            localObject3 = "";
            break label625;
          }
          label771:
          this.context.startActivity(new Intent(this.context, JumpActivity.class).setData(Uri.parse(paramString)));
        }
      }
    }
  }
  
  public void startMultiShare(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "startMultiShare->paramStr:" + paramString);
    }
    try
    {
      localObject = ocp.e(paramString);
      if ((localObject == null) || (!((JSONObject)localObject).has("image_url"))) {
        break label151;
      }
      paramString = ((JSONObject)localObject).getString("image_url");
    }
    catch (JSONException paramString)
    {
      Object localObject;
      boolean bool;
      while (QLog.isColorLevel())
      {
        QLog.d("PAjs", 2, "startMultiShare->error:" + paramString);
        return;
        bool = false;
        continue;
        paramString = "";
      }
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((localObject != null) && (((JSONObject)localObject).has("isGif")))
    {
      bool = ((JSONObject)localObject).getBoolean("isGif");
      localObject = (arbo)super.getBrowserComponent(64);
      if (localObject == null) {
        return;
      }
      ((arbo)localObject).jdMethod_do(paramString, bool);
    }
    label151:
  }
  
  public void viewAccount(String paramString)
  {
    viewAccount(paramString, "false");
  }
  
  public void viewAccount(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString1)) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject1 = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject1 == null) {
        break label277;
      }
      localObject1 = (PublicAccountInfo)((EntityManager)localObject1).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Object localObject2 = this.context;
      if ((this.context instanceof BasePluginActivity)) {
        localObject2 = ((BasePluginActivity)this.context).getOutActivity();
      }
      if ((localObject1 != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent((Context)localObject2, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject1).name);
        ((Activity)localObject2).startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject2 = (acja)localAppInterface.getManager(56);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((acja)localObject2).b(paramString1);
        break;
        paramString2 = new Intent((Context)localObject2, AccountDetailActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("report_src_param_type", "");
        paramString2.putExtra("report_src_param_name", "");
        paramString2.putExtra("fromBrowser", true);
        paramString2.setFlags(67108864);
        ((Activity)localObject2).startActivity(paramString2);
      }
      label277:
      localObject1 = null;
    }
  }
  
  public void viewAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "func viewAccount(****), sopType:" + paramString3 + ",sopName:" + paramString4);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject1 = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject1 == null) {
        break label318;
      }
      localObject1 = (PublicAccountInfo)((EntityManager)localObject1).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Object localObject2 = this.context;
      if (this.context.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
        localObject2 = ((PluginBaseActivity)this.context).getOutActivity();
      }
      if ((localObject1 != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent((Context)localObject2, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject1).name);
        ((Activity)localObject2).startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject2 = (acja)localAppInterface.getManager(56);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((acja)localObject2).b(paramString1);
        break;
        paramString2 = new Intent((Context)localObject2, AccountDetailActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("report_src_param_type", paramString3);
        paramString2.putExtra("report_src_param_name", paramString4);
        ((Activity)localObject2).startActivity(paramString2);
      }
      label318:
      localObject1 = null;
    }
  }
  
  public void viewTroopBarAccount(String paramString)
  {
    viewAccount(paramString);
  }
  
  public void writeH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
      return;
    }
    ThreadManager.post(new PublicAccountJavascriptInterface.13(this, paramString1, paramString2, localJSONObject), 5, null, false);
  }
  
  public static class a
  {
    public String VH;
    public String itemName;
    public int itemType;
  }
  
  public class b
    extends AsyncTask<String, Integer, String>
  {
    String token;
    
    protected String doInBackground(String... paramVarArgs)
    {
      if (super.isCancelled()) {
        return null;
      }
      return this.this$0.L(paramVarArgs[0], paramVarArgs[1]);
    }
    
    protected void onCancelled()
    {
      super.onCancelled();
    }
    
    protected void onPostExecute(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "{\"r\" : \"-100\"}";
      }
      this.this$0.callJs("clientCallback", new String[] { jqo.toJsString(str), jqo.toJsString(this.token) });
    }
    
    protected void onPreExecute() {}
    
    protected void onProgressUpdate(Integer... paramVarArgs) {}
  }
  
  public class c
    extends SosoInterface.a
  {
    String VI;
    int aGQ;
    boolean adn;
    boolean ado;
    boolean adp;
    boolean mIsActive;
    long mStartRequestTime;
    long rj;
    long rk;
    
    private c(int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, String paramString) {}
    
    public c(int paramInt, String paramString, long paramLong)
    {
      this(paramInt, -1L, paramLong, false, false, 0, false, paramString);
    }
    
    public c(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, long paramLong)
    {
      this(paramInt1, 10000L, paramLong, true, paramBoolean1, paramInt2, paramBoolean2, paramString);
    }
    
    public void onConsecutiveFailure(int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs.location", 2, "onConsecutiveFailure: errCode=" + paramInt1 + ", failCount=" + paramInt2);
      }
      if ((paramInt2 * 2000 < this.rj) || (!this.mIsActive)) {
        return;
      }
      this.mIsActive = false;
      PublicAccountJavascriptInterface.this.callJs(this.VI, new String[] { "-2", "{type:1, data:null}" });
      String str = Long.toString(System.currentTimeMillis() - this.mStartRequestTime);
      anot.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 3, PublicAccountJavascriptInterface.this.getNetworkType(), str, "", "");
      SosoInterface.c(this);
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs.location", 2, "onLocationFinish: errCode=" + paramInt + ", info=" + paramSosoLbsInfo + ", isActive=" + this.mIsActive + ", reqRawData=" + this.ado);
      }
      if (!this.mIsActive) {
        return;
      }
      if (!this.ado)
      {
        if (paramInt == 0)
        {
          double d1 = paramSosoLbsInfo.a.cd;
          double d2 = paramSosoLbsInfo.a.ce;
          if (this.adn) {
            PublicAccountJavascriptInterface.this.callJs(this.VI, new String[] { "0", "{type:2, lat:" + d1 + ", lon:" + d2 + "}" });
          }
          for (;;)
          {
            paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.mStartRequestTime);
            anot.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 0, PublicAccountJavascriptInterface.this.getNetworkType(), paramSosoLbsInfo, "", "");
            return;
            PublicAccountJavascriptInterface.this.callJs(this.VI, new String[] { String.format("'%1$f,%2$f'", new Object[] { Double.valueOf(d2), Double.valueOf(d1) }) });
          }
        }
        PublicAccountJavascriptInterface.this.callJs(this.VI, new String[] { "-1", "{}" });
        paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.mStartRequestTime);
        anot.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 1, PublicAccountJavascriptInterface.this.getNetworkType(), paramSosoLbsInfo, "", "");
        return;
      }
      if (paramSosoLbsInfo != null) {}
      for (byte[] arrayOfByte = paramSosoLbsInfo.cW;; arrayOfByte = null)
      {
        boolean bool;
        if (arrayOfByte != null)
        {
          if (this.adp) {}
          for (;;)
          {
            try
            {
              paramSosoLbsInfo = auro.encode(PublicAccountJavascriptInterface.a(PublicAccountJavascriptInterface.this, arrayOfByte), "nbyvie");
              if (TextUtils.isEmpty(paramSosoLbsInfo)) {
                break label931;
              }
              bool = true;
              label363:
              if (QLog.isColorLevel()) {
                QLog.d("PAjs.location", 2, "onLocationFinish: success=" + bool + ", mUseFallback=" + this.adn);
              }
              if (!bool) {
                break label691;
              }
              this.mIsActive = false;
              PublicAccountJavascriptInterface.this.callJs(this.VI, new String[] { "0", "{type:1, decrypt_padding:" + this.aGQ + ",data:\"" + paramSosoLbsInfo + "\"}" });
              paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.mStartRequestTime);
              anot.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, PublicAccountJavascriptInterface.this.getNetworkType(), paramSosoLbsInfo, "", "");
              if (arrayOfByte == null) {
                break;
              }
              paramSosoLbsInfo = PublicAccountJavascriptInterface.this.mRuntime.getWebView();
              if (paramSosoLbsInfo == null) {
                break;
              }
              paramSosoLbsInfo = paramSosoLbsInfo.getUrl();
              if ((TextUtils.isEmpty(paramSosoLbsInfo)) || (!paramSosoLbsInfo.contains("_bid=108"))) {
                break;
              }
              jpp.a(null, 81, "", 0, 0, aqgo.encodeToString(arrayOfByte, 2), "", "", "");
              return;
            }
            catch (Exception paramSosoLbsInfo)
            {
              paramSosoLbsInfo.printStackTrace();
              paramSosoLbsInfo = "";
              continue;
            }
            try
            {
              if (this.aGQ == 1) {}
              for (bool = true;; bool = false)
              {
                paramSosoLbsInfo = aqgo.encodeToString(oav.a(bool, oav.compress(arrayOfByte), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB"), 2);
                break;
              }
              paramSosoLbsInfo = PublicAccountJavascriptInterface.this.mRuntime.a();
            }
            catch (Exception localException)
            {
              if (PublicAccountJavascriptInterface.this.mRuntime == null) {}
            }
          }
        }
        for (;;)
        {
          if (paramSosoLbsInfo != null) {
            anot.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, paramSosoLbsInfo.getAccount(), localException.getMessage(), "", "");
          }
          paramSosoLbsInfo = "";
          break;
          label691:
          if ((this.adn) && (paramInt != -10000) && (paramInt != 2))
          {
            this.mIsActive = false;
            long l1 = System.currentTimeMillis() - this.mStartRequestTime;
            long l3 = this.rj - l1;
            if (l3 > 0L)
            {
              long l2 = this.rk - l1;
              l1 = l2;
              if (l2 < 0L) {
                l1 = 0L;
              }
              SosoInterface.a(new c(PublicAccountJavascriptInterface.this, 0, l3, l1, false, false, 0, true, this.VI));
            }
            for (;;)
            {
              paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.mStartRequestTime);
              anot.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 2, PublicAccountJavascriptInterface.this.getNetworkType(), paramSosoLbsInfo, "", "");
              return;
              PublicAccountJavascriptInterface.this.callJs(this.VI, new String[] { "-1", "{}" });
            }
          }
          this.mIsActive = false;
          PublicAccountJavascriptInterface.this.callJs(this.VI, new String[] { "-1", "{}" });
          paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.mStartRequestTime);
          anot.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 1, PublicAccountJavascriptInterface.this.getNetworkType(), paramSosoLbsInfo, "", "");
          return;
          label931:
          bool = false;
          break label363;
          paramSosoLbsInfo = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */