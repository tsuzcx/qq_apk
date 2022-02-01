package com.tencent.mobileqq.activity.bless;

import acbn;
import aclr;
import ahav;
import anbb;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import apaz;
import apaz.a;
import apaz.b;
import aqgo;
import aqhq;
import aqhs;
import aurf;
import avqq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import ylm;
import ylp;
import yls;

public class BlessResultActivity
  extends BlessTypeActivity
  implements Handler.Callback, View.OnClickListener, WXShareHelper.a
{
  String Qt;
  apaz.b jdField_a_of_type_Apaz$b = new yls(this);
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask;
  public a a;
  String aYJ;
  String aYK;
  public String aYL;
  String aYM;
  String aYN;
  public String aYO;
  String aYP;
  String aYQ;
  private aclr b;
  public aurf b;
  int bZM;
  int bZN = 0;
  public boolean bno = false;
  private boolean bnp = true;
  private boolean bnq;
  private boolean bnr;
  ProgressDialog f;
  private int mCount;
  private int mType;
  String zc;
  
  public static apaz.a a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramString1, paramString2, paramString3, paramBoolean, "https://c.v.qq.com/openfvupready?g_tk=");
  }
  
  public static apaz.a a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    long l = System.currentTimeMillis();
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("tags");
    String str3 = paramBundle.getString("cat");
    String str4 = paramBundle.getString("file_path");
    paramBundle = paramBundle.getString("vid");
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "applyUpload title = " + str1 + ", tags = " + str2 + ", cat = " + str3 + ", filePath = " + str4 + ", size = " + aqhq.getFileSizes(str4));
    }
    if ((TextUtils.isEmpty(str4)) || (!aqhq.fileExists(str4)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessResultActivity", 2, "!!!!!!!applyUpload filePath = " + str4);
      }
      paramString1 = null;
    }
    do
    {
      return paramString1;
      if (paramBoolean) {
        paramString4.replaceFirst("http", "https");
      }
      paramString4 = new HttpPost(paramString4 + String.valueOf(apaz.eK(paramString2)));
      paramString4.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      paramString4.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");
      paramString4.setHeader("Accept-Encoding", "gzip, deflate");
      paramString4.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
      paramString4.setHeader("Connection", "close");
      paramString4.setHeader("Cookie", "skey=" + paramString2 + ";uin=" + paramString1);
      paramString4.setHeader("Referer", "https://c.v.qq.com");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("bid", paramString3));
      localArrayList.add(new BasicNameValuePair("title", str1));
      localArrayList.add(new BasicNameValuePair("tags", str2));
      localArrayList.add(new BasicNameValuePair("cat", str3));
      localArrayList.add(new BasicNameValuePair("size", String.valueOf(aqhq.getFileSizes(str4))));
      localArrayList.add(new BasicNameValuePair("sha", aqhs.bytes2HexStr(ahav.x(str4))));
      localArrayList.add(new BasicNameValuePair("md5", aqhs.bytes2HexStr(ahav.t(str4))));
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "applyUpload() getMessageDigest time = " + (System.currentTimeMillis() - l));
      }
      localArrayList.add(new BasicNameValuePair("platform", "android"));
      localArrayList.add(new BasicNameValuePair("g_tk", String.valueOf(apaz.eK(paramString2))));
      localArrayList.add(new BasicNameValuePair("otype", "json"));
      if (!TextUtils.isEmpty(paramBundle))
      {
        localArrayList.add(new BasicNameValuePair("vid", paramBundle));
        localArrayList.add(new BasicNameValuePair("continue", "1"));
      }
      paramString1 = null;
      try
      {
        paramString4.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        paramBundle = new DefaultHttpClient().execute(paramString4);
        if (paramBundle.getStatusLine().getStatusCode() != 200) {
          break;
        }
        paramBundle = EntityUtils.toString(paramBundle.getEntity());
        paramBundle = paramBundle.substring(paramBundle.indexOf("{"), paramBundle.lastIndexOf("}") + 1);
        if (QLog.isColorLevel()) {
          QLog.d("BlessResultActivity", 2, "applyUpload result = " + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (!paramBundle.optString("s", "f").equals("o")) {
          break;
        }
        paramBundle = new apaz.a(paramBundle);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramBundle = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.d("BlessResultActivity", 2, QLog.getStackTraceString(paramString2));
            paramBundle = paramString1;
            continue;
            paramBundle = null;
          }
        }
      }
      paramString1 = paramBundle;
    } while (!QLog.isColorLevel());
    QLog.d("BlessResultActivity", 2, "applyUpload time: " + (System.currentTimeMillis() - l));
    return paramBundle;
  }
  
  /* Error */
  public static boolean b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_0
    //   6: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: invokestatic 145	aqhq:fileExists	(Ljava/lang/String;)Z
    //   16: ifne +37 -> 53
    //   19: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 101
    //   27: iconst_2
    //   28: new 103	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 349
    //   38: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_1
    //   54: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +10 -> 67
    //   60: aload_1
    //   61: invokestatic 145	aqhq:fileExists	(Ljava/lang/String;)Z
    //   64: ifne +37 -> 101
    //   67: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq -19 -> 51
    //   73: ldc 101
    //   75: iconst_2
    //   76: new 103	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 351
    //   86: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_0
    //   100: ireturn
    //   101: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +94 -> 198
    //   107: ldc 101
    //   109: iconst_2
    //   110: new 103	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 353
    //   120: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc_w 355
    //   130: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 357
    //   140: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokestatic 124	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   147: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: ldc_w 359
    //   153: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_2
    //   157: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 361
    //   163: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_3
    //   167: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 363
    //   173: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 4
    //   178: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 365
    //   184: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: invokestatic 371	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   201: invokevirtual 372	java/util/UUID:toString	()Ljava/lang/String;
    //   204: astore 12
    //   206: new 162	org/apache/http/client/methods/HttpPost
    //   209: dup
    //   210: new 103	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 374
    //   220: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_3
    //   224: invokestatic 168	apaz:eK	(Ljava/lang/String;)I
    //   227: invokestatic 172	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   230: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 175	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   239: astore 11
    //   241: aload 11
    //   243: ldc 177
    //   245: ldc 179
    //   247: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 11
    //   252: ldc 185
    //   254: ldc 187
    //   256: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 11
    //   261: ldc 189
    //   263: ldc 191
    //   265: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 11
    //   270: ldc 193
    //   272: ldc 195
    //   274: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 11
    //   279: ldc 197
    //   281: ldc 199
    //   283: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload 11
    //   288: ldc 201
    //   290: new 103	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   297: ldc 203
    //   299: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_3
    //   303: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 205
    //   308: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_2
    //   312: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 11
    //   323: ldc 207
    //   325: ldc 209
    //   327: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload 11
    //   332: ldc_w 376
    //   335: new 103	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 378
    //   342: invokespecial 379	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload 12
    //   347: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokevirtual 183	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: new 81	android/os/Bundle
    //   359: dup
    //   360: invokespecial 380	android/os/Bundle:<init>	()V
    //   363: astore 13
    //   365: aload 13
    //   367: ldc 216
    //   369: aload 6
    //   371: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 13
    //   376: ldc 93
    //   378: aload 4
    //   380: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 13
    //   385: ldc_w 385
    //   388: aload 5
    //   390: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload 13
    //   395: ldc 226
    //   397: aload_0
    //   398: invokestatic 124	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   401: invokestatic 229	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   404: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload 13
    //   409: ldc 231
    //   411: aload_0
    //   412: invokestatic 237	ahav:x	(Ljava/lang/String;)[B
    //   415: invokestatic 243	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   418: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: aload 13
    //   423: ldc 245
    //   425: aload_0
    //   426: invokestatic 248	ahav:t	(Ljava/lang/String;)[B
    //   429: invokestatic 243	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   432: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +34 -> 472
    //   441: ldc 101
    //   443: iconst_2
    //   444: new 103	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   451: ldc_w 387
    //   454: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   460: lload 7
    //   462: lsub
    //   463: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   466: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload 13
    //   474: ldc 252
    //   476: ldc 254
    //   478: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 13
    //   483: ldc_w 256
    //   486: aload_3
    //   487: invokestatic 168	apaz:eK	(Ljava/lang/String;)I
    //   490: invokestatic 172	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   493: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload 13
    //   498: ldc_w 258
    //   501: ldc_w 260
    //   504: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aload 13
    //   509: ldc_w 389
    //   512: ldc_w 391
    //   515: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload 13
    //   520: ldc_w 393
    //   523: ldc_w 395
    //   526: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload 13
    //   531: ldc_w 397
    //   534: ldc_w 399
    //   537: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: aload 13
    //   542: ldc_w 401
    //   545: ldc_w 403
    //   548: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload 13
    //   553: ldc_w 405
    //   556: ldc_w 407
    //   559: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: aload 13
    //   564: ldc_w 409
    //   567: ldc_w 411
    //   570: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: aload 13
    //   575: ldc_w 413
    //   578: ldc_w 415
    //   581: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: aload 13
    //   586: ldc_w 417
    //   589: ldc_w 419
    //   592: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload 13
    //   597: ldc_w 421
    //   600: ldc_w 423
    //   603: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: aload 13
    //   608: ldc_w 425
    //   611: ldc_w 427
    //   614: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: aload 13
    //   619: ldc_w 429
    //   622: ldc_w 427
    //   625: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 13
    //   630: ldc_w 431
    //   633: ldc_w 433
    //   636: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 13
    //   641: ldc_w 435
    //   644: ldc_w 437
    //   647: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   650: aload 13
    //   652: ldc_w 439
    //   655: ldc_w 264
    //   658: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   661: aload 13
    //   663: ldc_w 441
    //   666: ldc_w 443
    //   669: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: aload 13
    //   674: ldc_w 445
    //   677: ldc_w 447
    //   680: invokevirtual 383	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: new 449	java/io/ByteArrayOutputStream
    //   686: dup
    //   687: invokespecial 450	java/io/ByteArrayOutputStream:<init>	()V
    //   690: astore 4
    //   692: aconst_null
    //   693: astore_3
    //   694: aconst_null
    //   695: astore_2
    //   696: new 452	java/io/File
    //   699: dup
    //   700: aload_1
    //   701: invokespecial 453	java/io/File:<init>	(Ljava/lang/String;)V
    //   704: astore 5
    //   706: aload_3
    //   707: astore_0
    //   708: aload 13
    //   710: invokevirtual 457	android/os/Bundle:keySet	()Ljava/util/Set;
    //   713: invokeinterface 463 1 0
    //   718: astore 6
    //   720: aload_3
    //   721: astore_0
    //   722: aload 6
    //   724: invokeinterface 468 1 0
    //   729: ifeq +460 -> 1189
    //   732: aload_3
    //   733: astore_0
    //   734: aload 6
    //   736: invokeinterface 472 1 0
    //   741: checkcast 156	java/lang/String
    //   744: astore 14
    //   746: aload_3
    //   747: astore_0
    //   748: aload 13
    //   750: aload 14
    //   752: invokevirtual 85	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   755: astore 15
    //   757: aload 15
    //   759: ifnull -39 -> 720
    //   762: aload_3
    //   763: astore_0
    //   764: aload 4
    //   766: new 103	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   773: ldc_w 474
    //   776: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: ldc_w 476
    //   782: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: aload 12
    //   787: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 474
    //   793: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokevirtual 480	java/lang/String:getBytes	()[B
    //   802: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   805: aload_3
    //   806: astore_0
    //   807: aload 4
    //   809: new 103	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   816: ldc_w 486
    //   819: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 14
    //   824: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 488
    //   830: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: ldc_w 474
    //   836: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: ldc_w 474
    //   842: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokevirtual 480	java/lang/String:getBytes	()[B
    //   851: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   854: aload_3
    //   855: astore_0
    //   856: aload 4
    //   858: aload 15
    //   860: invokevirtual 480	java/lang/String:getBytes	()[B
    //   863: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   866: goto -146 -> 720
    //   869: astore_0
    //   870: aload_2
    //   871: astore_1
    //   872: aload_0
    //   873: astore_2
    //   874: aload_1
    //   875: astore_0
    //   876: aload_2
    //   877: invokevirtual 491	java/io/IOException:printStackTrace	()V
    //   880: aload 4
    //   882: ifnull +8 -> 890
    //   885: aload 4
    //   887: invokevirtual 493	java/io/ByteArrayOutputStream:close	()V
    //   890: aload_1
    //   891: ifnull +654 -> 1545
    //   894: aload_1
    //   895: invokevirtual 496	java/io/FileInputStream:close	()V
    //   898: aconst_null
    //   899: astore_0
    //   900: new 498	org/apache/http/entity/ByteArrayEntity
    //   903: dup
    //   904: aload_0
    //   905: invokespecial 500	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   908: astore_0
    //   909: aload 11
    //   911: aload_0
    //   912: invokevirtual 275	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   915: new 502	org/apache/http/params/BasicHttpParams
    //   918: dup
    //   919: invokespecial 503	org/apache/http/params/BasicHttpParams:<init>	()V
    //   922: astore_0
    //   923: aload_0
    //   924: sipush 10000
    //   927: invokestatic 509	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   930: aload_0
    //   931: sipush 10000
    //   934: invokestatic 512	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   937: new 277	org/apache/http/impl/client/DefaultHttpClient
    //   940: dup
    //   941: aload_0
    //   942: invokespecial 515	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   945: aload 11
    //   947: invokevirtual 282	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   950: astore_0
    //   951: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   954: ifeq +39 -> 993
    //   957: ldc 101
    //   959: iconst_2
    //   960: new 103	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   967: ldc_w 517
    //   970: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload_0
    //   974: invokeinterface 288 1 0
    //   979: invokeinterface 294 1 0
    //   984: invokevirtual 520	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   987: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   993: aload_0
    //   994: invokeinterface 288 1 0
    //   999: invokeinterface 294 1 0
    //   1004: sipush 200
    //   1007: if_icmpne +532 -> 1539
    //   1010: aload_0
    //   1011: invokeinterface 298 1 0
    //   1016: invokestatic 303	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1019: astore_0
    //   1020: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1023: ifeq +29 -> 1052
    //   1026: ldc 101
    //   1028: iconst_2
    //   1029: new 103	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1036: ldc_w 522
    //   1039: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: aload_0
    //   1043: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1052: aload_0
    //   1053: aload_0
    //   1054: ldc_w 305
    //   1057: invokevirtual 308	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1060: aload_0
    //   1061: ldc_w 310
    //   1064: invokevirtual 313	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1067: iconst_1
    //   1068: iadd
    //   1069: invokevirtual 317	java/lang/String:substring	(II)Ljava/lang/String;
    //   1072: astore_0
    //   1073: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1076: ifeq +29 -> 1105
    //   1079: ldc 101
    //   1081: iconst_2
    //   1082: new 103	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1089: ldc_w 524
    //   1092: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload_0
    //   1096: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1105: new 321	org/json/JSONObject
    //   1108: dup
    //   1109: aload_0
    //   1110: invokespecial 322	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1113: ldc_w 324
    //   1116: ldc_w 325
    //   1119: invokevirtual 328	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1122: ldc_w 330
    //   1125: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1128: istore 9
    //   1130: iload 9
    //   1132: ifeq +407 -> 1539
    //   1135: iconst_1
    //   1136: istore 9
    //   1138: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1141: ifeq +45 -> 1186
    //   1144: ldc 101
    //   1146: iconst_2
    //   1147: new 103	java/lang/StringBuilder
    //   1150: dup
    //   1151: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1154: ldc_w 526
    //   1157: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   1163: lload 7
    //   1165: lsub
    //   1166: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1169: ldc_w 528
    //   1172: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: iload 9
    //   1177: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1180: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1183: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1186: iload 9
    //   1188: ireturn
    //   1189: aload_3
    //   1190: astore_0
    //   1191: aload 4
    //   1193: new 103	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 474
    //   1203: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: ldc_w 476
    //   1209: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload 12
    //   1214: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: ldc_w 474
    //   1220: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokevirtual 480	java/lang/String:getBytes	()[B
    //   1229: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   1232: aload_3
    //   1233: astore_0
    //   1234: aload 4
    //   1236: new 103	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1243: ldc_w 533
    //   1246: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: aload 5
    //   1251: invokevirtual 536	java/io/File:getName	()Ljava/lang/String;
    //   1254: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: ldc_w 488
    //   1260: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: ldc_w 474
    //   1266: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokevirtual 480	java/lang/String:getBytes	()[B
    //   1275: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   1278: aload_3
    //   1279: astore_0
    //   1280: aload 4
    //   1282: new 103	java/lang/StringBuilder
    //   1285: dup
    //   1286: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1289: ldc_w 538
    //   1292: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: ldc_w 474
    //   1298: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: ldc_w 474
    //   1304: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokevirtual 480	java/lang/String:getBytes	()[B
    //   1313: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   1316: aload_3
    //   1317: astore_0
    //   1318: new 495	java/io/FileInputStream
    //   1321: dup
    //   1322: aload_1
    //   1323: invokespecial 539	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1326: astore_1
    //   1327: aload_1
    //   1328: invokevirtual 543	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   1331: invokevirtual 547	java/nio/channels/FileChannel:size	()J
    //   1334: l2i
    //   1335: newarray byte
    //   1337: astore_0
    //   1338: aload_1
    //   1339: aload_0
    //   1340: invokevirtual 551	java/io/FileInputStream:read	([B)I
    //   1343: pop
    //   1344: aload 4
    //   1346: aload_0
    //   1347: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   1350: aload 4
    //   1352: new 103	java/lang/StringBuilder
    //   1355: dup
    //   1356: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1359: ldc_w 474
    //   1362: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: ldc_w 476
    //   1368: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: aload 12
    //   1373: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: ldc_w 476
    //   1379: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: ldc_w 474
    //   1385: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: invokevirtual 480	java/lang/String:getBytes	()[B
    //   1394: invokevirtual 484	java/io/ByteArrayOutputStream:write	([B)V
    //   1397: aload 4
    //   1399: invokevirtual 554	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1402: astore_2
    //   1403: aload 4
    //   1405: ifnull +8 -> 1413
    //   1408: aload 4
    //   1410: invokevirtual 493	java/io/ByteArrayOutputStream:close	()V
    //   1413: aload_2
    //   1414: astore_0
    //   1415: aload_1
    //   1416: ifnull -516 -> 900
    //   1419: aload_1
    //   1420: invokevirtual 496	java/io/FileInputStream:close	()V
    //   1423: aload_2
    //   1424: astore_0
    //   1425: goto -525 -> 900
    //   1428: astore_0
    //   1429: aload_2
    //   1430: astore_0
    //   1431: goto -531 -> 900
    //   1434: astore_0
    //   1435: aconst_null
    //   1436: astore_0
    //   1437: goto -537 -> 900
    //   1440: astore_2
    //   1441: aload_0
    //   1442: astore_1
    //   1443: aload_2
    //   1444: astore_0
    //   1445: aload 4
    //   1447: ifnull +8 -> 1455
    //   1450: aload 4
    //   1452: invokevirtual 493	java/io/ByteArrayOutputStream:close	()V
    //   1455: aload_1
    //   1456: ifnull +7 -> 1463
    //   1459: aload_1
    //   1460: invokevirtual 496	java/io/FileInputStream:close	()V
    //   1463: aload_0
    //   1464: athrow
    //   1465: astore_0
    //   1466: iconst_0
    //   1467: istore 10
    //   1469: iload 10
    //   1471: istore 9
    //   1473: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1476: ifeq -338 -> 1138
    //   1479: ldc 101
    //   1481: iconst_2
    //   1482: new 103	java/lang/StringBuilder
    //   1485: dup
    //   1486: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1489: ldc_w 556
    //   1492: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: aload_0
    //   1496: invokestatic 344	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1499: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1508: iload 10
    //   1510: istore 9
    //   1512: goto -374 -> 1138
    //   1515: astore_0
    //   1516: goto -103 -> 1413
    //   1519: astore_0
    //   1520: goto -630 -> 890
    //   1523: astore_2
    //   1524: goto -69 -> 1455
    //   1527: astore_1
    //   1528: goto -65 -> 1463
    //   1531: astore_0
    //   1532: goto -87 -> 1445
    //   1535: astore_2
    //   1536: goto -662 -> 874
    //   1539: iconst_0
    //   1540: istore 9
    //   1542: goto -404 -> 1138
    //   1545: aconst_null
    //   1546: astore_0
    //   1547: goto -647 -> 900
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1550	0	paramString1	String
    //   0	1550	1	paramString2	String
    //   0	1550	2	paramString3	String
    //   0	1550	3	paramString4	String
    //   0	1550	4	paramString5	String
    //   0	1550	5	paramString6	String
    //   0	1550	6	paramString7	String
    //   3	1161	7	l	long
    //   1128	413	9	bool1	boolean
    //   1467	42	10	bool2	boolean
    //   239	707	11	localHttpPost	HttpPost
    //   204	1168	12	str1	String
    //   363	386	13	localBundle	Bundle
    //   744	79	14	str2	String
    //   755	104	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   708	720	869	java/io/IOException
    //   722	732	869	java/io/IOException
    //   734	746	869	java/io/IOException
    //   748	757	869	java/io/IOException
    //   764	805	869	java/io/IOException
    //   807	854	869	java/io/IOException
    //   856	866	869	java/io/IOException
    //   1191	1232	869	java/io/IOException
    //   1234	1278	869	java/io/IOException
    //   1280	1316	869	java/io/IOException
    //   1318	1327	869	java/io/IOException
    //   1419	1423	1428	java/io/IOException
    //   894	898	1434	java/io/IOException
    //   708	720	1440	finally
    //   722	732	1440	finally
    //   734	746	1440	finally
    //   748	757	1440	finally
    //   764	805	1440	finally
    //   807	854	1440	finally
    //   856	866	1440	finally
    //   876	880	1440	finally
    //   1191	1232	1440	finally
    //   1234	1278	1440	finally
    //   1280	1316	1440	finally
    //   1318	1327	1440	finally
    //   909	993	1465	java/lang/Exception
    //   993	1052	1465	java/lang/Exception
    //   1052	1105	1465	java/lang/Exception
    //   1105	1130	1465	java/lang/Exception
    //   1408	1413	1515	java/io/IOException
    //   885	890	1519	java/io/IOException
    //   1450	1455	1523	java/io/IOException
    //   1459	1463	1527	java/io/IOException
    //   1327	1403	1531	finally
    //   1327	1403	1535	java/io/IOException
  }
  
  private void cjp()
  {
    this.bnq = getIntent().getBooleanExtra(anbb.ccQ, false);
    if (!this.bnq) {
      return;
    }
    this.jdField_b_of_type_Aclr = new ylp(this);
    this.app.addObserver(this.jdField_b_of_type_Aclr);
  }
  
  public static String hL(String paramString)
  {
    String str = acbn.SDCARD_PATH + "bless/thumb/";
    Object localObject = new File(str);
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).listFiles().length > 0))
    {
      localObject = ((File)localObject).listFiles();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    return str + paramString.substring(paramString.lastIndexOf("/"));
  }
  
  private void initUI()
  {
    ((ImmersiveTitleBar2)findViewById(2131379866)).setVisibility(4);
    findViewById(2131369612).setVisibility(8);
    findViewById(2131369579).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131380633);
    String str = "";
    switch (this.mType)
    {
    }
    for (;;)
    {
      localTextView.setText(String.format(getString(2131690927), new Object[] { Integer.valueOf(this.mCount) }));
      if (this.mCount > 10) {
        ((TextView)findViewById(2131363567)).setText(String.format(getString(2131690919), new Object[] { Integer.valueOf(10) }));
      }
      if (this.mType == 2)
      {
        findViewById(2131377482).setVisibility(0);
        ((TextView)findViewById(2131380930)).setText(String.format(getString(2131690924), new Object[] { str }));
        findViewById(2131380866).setOnClickListener(this);
        findViewById(2131380723).setOnClickListener(this);
      }
      return;
      str = getString(2131690929);
      continue;
      str = getString(2131690910);
    }
  }
  
  void Eg(int paramInt)
  {
    showProgressDialog();
    this.bZN = paramInt;
    if ((this.aYK == null) || (this.aYJ == null) || (this.aYM == null) || (this.aYN == null))
    {
      QQToast.a(this, 2131693681, 0).show();
      go();
      return;
    }
    File localFile1 = new File(this.aYK);
    File localFile2 = new File(this.aYJ);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQToast.a(this, 2131693681, 0).show();
      go();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      QQToast.a(this, 2131693683, 0).show();
      go();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "share last uploaded ptv. mPtvPath=" + this.aYJ + " ,mSnapImagePath=" + this.aYK + " ,mPtvUuid=" + this.aYM + " ,mPtvMd5=" + this.aYN);
    }
    this.aYO = this.jdField_a_of_type_Ylm.ay(this.aYM, this.aYN);
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "share url :" + this.aYO);
    }
    if (this.bZN == 1)
    {
      cjr();
      return;
    }
    ThreadManager.post(new BlessResultActivity.3(this, this.aYK), 8, null, false);
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.Qt == null) || (!this.Qt.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this, 1, getString(2131720152), 0).show();
      return;
    }
    QQToast.a(this, 2, getString(2131720175), 0).show();
  }
  
  void cjq()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask == null) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.isRunning()) && (!this.bno)))
    {
      String str = this.app.getCurrentUin();
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask = new VideoUploadTask(str, ((TicketManager)this.app.getManager(2)).getSkey(str), this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$a, this.jdField_a_of_type_Apaz$b);
      this.jdField_b_of_type_Aurf.sendEmptyMessageDelayed(1003, 120000L);
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask, 8, null, false);
      return;
    }
    cjr();
  }
  
  void cjr()
  {
    go();
    if (this.bZN == 1)
    {
      cjs();
      return;
    }
    cjt();
  }
  
  void cjs()
  {
    Object localObject = this.aYK;
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localArrayList.add(localObject);
    }
    String str = this.zc;
    localObject = str;
    if (TextUtils.isEmpty(str))
    {
      str = this.jdField_a_of_type_Ylm.m(true);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = getString(2131690923);
      }
    }
    str = String.format(getString(2131690922), new Object[] { this.app.getCurrentNickname() });
    Bundle localBundle = new Bundle();
    localBundle.putString("title", (String)localObject);
    localBundle.putString("desc", str);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.aYO);
    localBundle.putString("url", this.aYO);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", (String)localObject);
    localBundle.putString("bizname", "StarBlessLink");
    avqq.a(this.app, this, localBundle, null);
    if (QLog.isColorLevel()) {
      QLog.i("BlessResultActivity", 2, "shareToQzone: shareLink:" + this.aYO);
    }
  }
  
  void cjt()
  {
    int i;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    for (;;)
    {
      if (i != -1) {
        QQToast.a(this, getString(i), 0).show();
      }
      for (;;)
      {
        return;
        if (!WXShareHelper.a().isWXsupportApi())
        {
          i = 2131721936;
          break;
          this.Qt = String.valueOf(System.currentTimeMillis());
          Object localObject1 = null;
          try
          {
            localObject2 = BitmapFactory.decodeFile(this.aYK);
            String str = this.zc;
            localObject1 = str;
            if (TextUtils.isEmpty(str))
            {
              str = this.jdField_a_of_type_Ylm.m(false);
              localObject1 = str;
              if (TextUtils.isEmpty(str)) {
                localObject1 = getString(2131690923);
              }
            }
            str = String.format(getString(2131690922), new Object[] { this.app.getCurrentNickname() });
            WXShareHelper.a().c(this.Qt, (String)localObject1, (Bitmap)localObject2, str, this.aYO);
            if (QLog.isColorLevel())
            {
              QLog.i("BlessResultActivity", 2, "shareToFriendCircle.transaction: " + this.Qt + ", shareLink:" + this.aYO);
              return;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Object localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.e("BlessResultActivity", 2, "getBitmapByPath OOM, fileName: " + this.aYK, localOutOfMemoryError);
                localObject2 = localObject1;
              }
            }
          }
        }
      }
      i = -1;
    }
  }
  
  public void doOnBackPressed()
  {
    onBackEvent();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558768);
    this.jdField_a_of_type_Ylm.cjh();
    this.jdField_a_of_type_Ylm.Ai(false);
    paramBundle = getIntent();
    this.mType = paramBundle.getIntExtra("param_method", 1);
    this.mCount = paramBundle.getIntExtra("param_count", 0);
    if (this.mType == 2)
    {
      this.jdField_b_of_type_Aurf = new aurf(this);
      this.aYJ = paramBundle.getStringExtra("param_ptv_path");
      this.aYK = paramBundle.getStringExtra("param_snap_path");
      this.bZM = paramBundle.getIntExtra("param_ptv_id", -1);
      this.zc = paramBundle.getStringExtra("param_share_title");
      this.aYM = paramBundle.getStringExtra("param_ptv_uuid");
      this.aYN = paramBundle.getStringExtra("param_ptv_md5");
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "mp4: " + this.aYJ + ", image:" + this.aYK);
      }
      WXShareHelper.a().a(this);
    }
    this.qJ = 0.48F;
    this.bannerType = 2;
    initUI();
    cjp();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mType == 2)
    {
      WXShareHelper.a().b(this);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.isRunning())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.stop();
      }
    }
    if (this.jdField_b_of_type_Aclr != null) {
      this.app.removeObserver(this.jdField_b_of_type_Aclr);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.bnq) && (!this.bnr))
    {
      this.bnr = true;
      ThreadManager.post(new BlessResultActivity.2(this), 8, null, false);
    }
  }
  
  public String eC(String paramString)
  {
    paramString = this.jdField_a_of_type_Ylm.getShareUrl() + "&vid=" + paramString + "&nickname=";
    String str = paramString + aqgo.encodeToString(this.app.getCurrentNickname().getBytes(), 2);
    paramString = str;
    if (this.bZM > 0) {
      paramString = str + "&template=" + this.bZM;
    }
    return paramString;
  }
  
  void go()
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessResultActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.f != null) {
        this.f.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bool = false;
      return bool;
      cjq();
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.isRunning())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoUploadTask.stop();
      }
      go();
      QQToast.a(this, 1, 2131720152, 0).show();
      return true;
      this.aYP = this.aYJ;
      this.aYQ = this.aYL;
      paramMessage = getSharedPreferences("bless_ptv_upload", 0).edit();
      String str = getCurrentAccountUin();
      paramMessage.putString("bless_ptv_path" + str, this.aYP);
      paramMessage.putString("bless_vid" + str, this.aYQ);
      paramMessage.commit();
      cjr();
      return true;
      if (((paramMessage.obj instanceof String)) && (!TextUtils.isEmpty((String)paramMessage.obj))) {
        this.aYK = ((String)paramMessage.obj);
      }
      cjr();
    }
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent(this, BlessActivity.class);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Intent localIntent = new Intent(this, SplashActivity.class);
        localIntent.setFlags(67108864);
        startActivity(localIntent);
      }
      Eg(1);
      continue;
      Eg(2);
    }
  }
  
  void showProgressDialog()
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessResultActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.f != null) {
        go();
      }
      while (!this.f.isShowing())
      {
        this.f.show();
        return;
        this.f = new ReportProgressDialog(this, 2131756467);
        this.f.setCancelable(false);
        this.f.show();
        this.f.setContentView(2131559761);
        ((TextView)this.f.findViewById(2131373180)).setText(2131717151);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessResultActivity", 2, "showProgressDialog", localThrowable);
      }
    }
  }
  
  class VideoUploadTask
    implements Runnable
  {
    private String aYR;
    private String aYS;
    private apaz.b b;
    public BlessResultActivity.a b;
    private AtomicBoolean bN = new AtomicBoolean(true);
    private String fT;
    private long mOffset = -1L;
    private String mUin;
    
    public VideoUploadTask(String paramString1, String paramString2, BlessResultActivity.a parama, apaz.b paramb)
    {
      this.mUin = paramString1;
      this.fT = paramString2;
      this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$a = parama;
      this.jdField_b_of_type_Apaz$b = paramb;
      if (this.aYR == null) {
        this.aYR = BlessResultActivity.this.getString(2131698106);
      }
      if (this.aYS == null) {
        this.aYS = BlessResultActivity.this.getString(2131690938);
      }
    }
    
    public boolean isRunning()
    {
      if (!isStopped()) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessResultActivity", 2, "VideoUploadTask isRunning(),result = " + bool);
        }
        return bool;
      }
    }
    
    public boolean isStopped()
    {
      return this.bN.get();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 106	java/lang/System:currentTimeMillis	()J
      //   3: lstore 8
      //   5: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   8: ifeq +11 -> 19
      //   11: ldc 72
      //   13: iconst_2
      //   14: ldc 108
      //   16: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   19: aload_0
      //   20: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   23: iconst_0
      //   24: invokevirtual 111	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   27: aload_0
      //   28: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   31: ifnonnull +26 -> 57
      //   34: aload_0
      //   35: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   38: iconst_1
      //   39: invokevirtual 111	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   42: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   45: ifeq +11 -> 56
      //   48: ldc 113
      //   50: iconst_2
      //   51: ldc 115
      //   53: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   56: return
      //   57: aload_0
      //   58: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$a;
      //   61: ifnull +23 -> 84
      //   64: aload_0
      //   65: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mUin	Ljava/lang/String;
      //   68: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   71: ifne +13 -> 84
      //   74: aload_0
      //   75: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:fT	Ljava/lang/String;
      //   78: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   81: ifeq +96 -> 177
      //   84: aload_0
      //   85: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   88: iconst_1
      //   89: invokevirtual 111	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   92: aload_0
      //   93: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   96: ldc2_w 38
      //   99: invokeinterface 127 3 0
      //   104: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   107: ifeq -51 -> 56
      //   110: aload_0
      //   111: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$a;
      //   114: ifnonnull +39 -> 153
      //   117: ldc 129
      //   119: astore 12
      //   121: ldc 113
      //   123: iconst_2
      //   124: new 74	java/lang/StringBuilder
      //   127: dup
      //   128: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   131: ldc 131
      //   133: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   136: aload 12
      //   138: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   141: ldc 133
      //   143: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   146: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   149: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   152: return
      //   153: aload_0
      //   154: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mUin	Ljava/lang/String;
      //   157: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   160: ifeq +10 -> 170
      //   163: ldc 135
      //   165: astore 12
      //   167: goto -46 -> 121
      //   170: ldc 137
      //   172: astore 12
      //   174: goto -53 -> 121
      //   177: iconst_0
      //   178: istore 10
      //   180: aload_0
      //   181: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$a;
      //   184: getfield 142	com/tencent/mobileqq/activity/bless/BlessResultActivity$a:path	Ljava/lang/String;
      //   187: astore 15
      //   189: new 144	java/io/File
      //   192: dup
      //   193: aload_0
      //   194: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$a;
      //   197: getfield 142	com/tencent/mobileqq/activity/bless/BlessResultActivity$a:path	Ljava/lang/String;
      //   200: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
      //   203: invokevirtual 150	java/io/File:getName	()Ljava/lang/String;
      //   206: astore 12
      //   208: new 152	android/os/Bundle
      //   211: dup
      //   212: invokespecial 153	android/os/Bundle:<init>	()V
      //   215: astore 13
      //   217: aload 13
      //   219: ldc 155
      //   221: aload_0
      //   222: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:aYR	Ljava/lang/String;
      //   225: invokevirtual 159	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   228: aload 13
      //   230: ldc 161
      //   232: aload 15
      //   234: invokevirtual 159	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   237: aload 13
      //   239: ldc 163
      //   241: aload_0
      //   242: getfield 58	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:aYS	Ljava/lang/String;
      //   245: invokevirtual 159	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   248: aload 13
      //   250: ldc 165
      //   252: aload 12
      //   254: invokevirtual 159	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   257: aload 13
      //   259: ldc 167
      //   261: aload_0
      //   262: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$a;
      //   265: getfield 169	com/tencent/mobileqq/activity/bless/BlessResultActivity$a:vid	Ljava/lang/String;
      //   268: invokevirtual 159	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   271: invokestatic 175	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   274: invokestatic 181	jqc:ak	(Landroid/content/Context;)Z
      //   277: ifeq +1121 -> 1398
      //   280: aload_0
      //   281: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   284: invokevirtual 95	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   287: ifne +1111 -> 1398
      //   290: aload 13
      //   292: aload_0
      //   293: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mUin	Ljava/lang/String;
      //   296: aload_0
      //   297: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:fT	Ljava/lang/String;
      //   300: ldc 183
      //   302: iconst_0
      //   303: invokestatic 187	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lapaz$a;
      //   306: astore 14
      //   308: aload 14
      //   310: ifnull +1076 -> 1386
      //   313: aload 15
      //   315: invokestatic 193	aqhq:getFileSizes	(Ljava/lang/String;)J
      //   318: lstore 6
      //   320: lload 6
      //   322: ldc2_w 194
      //   325: lcmp
      //   326: ifle +229 -> 555
      //   329: ldc2_w 194
      //   332: lstore_2
      //   333: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   336: ifeq +45 -> 381
      //   339: ldc 72
      //   341: iconst_2
      //   342: new 74	java/lang/StringBuilder
      //   345: dup
      //   346: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   349: ldc 197
      //   351: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   354: aload 14
      //   356: getfield 202	apaz$a:cnL	Ljava/lang/String;
      //   359: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   362: ldc 204
      //   364: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   367: aload 14
      //   369: getfield 207	apaz$a:cnK	Ljava/lang/String;
      //   372: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   375: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   378: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   381: ldc 209
      //   383: aload 14
      //   385: getfield 202	apaz$a:cnL	Ljava/lang/String;
      //   388: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   391: ifeq +170 -> 561
      //   394: aload_0
      //   395: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   398: lload_2
      //   399: l2d
      //   400: ldc2_w 216
      //   403: dmul
      //   404: d2l
      //   405: invokeinterface 220 3 0
      //   410: aload_0
      //   411: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   414: invokevirtual 95	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   417: ifne +975 -> 1392
      //   420: aload 15
      //   422: aload_0
      //   423: getfield 27	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
      //   426: getfield 223	com/tencent/mobileqq/activity/bless/BlessResultActivity:aYK	Ljava/lang/String;
      //   429: aload_0
      //   430: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mUin	Ljava/lang/String;
      //   433: aload_0
      //   434: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:fT	Ljava/lang/String;
      //   437: aload 14
      //   439: getfield 224	apaz$a:vid	Ljava/lang/String;
      //   442: aload 14
      //   444: getfield 227	apaz$a:fid	Ljava/lang/String;
      //   447: ldc 183
      //   449: invokestatic 230	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
      //   452: istore 11
      //   454: iload 11
      //   456: istore 10
      //   458: lload_2
      //   459: ldc2_w 38
      //   462: lcmp
      //   463: ifeq +17 -> 480
      //   466: aload_0
      //   467: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   470: lload_2
      //   471: invokeinterface 220 3 0
      //   476: iload 11
      //   478: istore 10
      //   480: aload_0
      //   481: getfield 27	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
      //   484: aload 14
      //   486: getfield 224	apaz$a:vid	Ljava/lang/String;
      //   489: putfield 233	com/tencent/mobileqq/activity/bless/BlessResultActivity:aYL	Ljava/lang/String;
      //   492: aload_0
      //   493: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   496: iconst_0
      //   497: iconst_1
      //   498: invokevirtual 237	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   501: ifeq +805 -> 1306
      //   504: iload 10
      //   506: ifeq +749 -> 1255
      //   509: aload_0
      //   510: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   513: invokeinterface 240 1 0
      //   518: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   521: ifeq -465 -> 56
      //   524: ldc 72
      //   526: iconst_2
      //   527: new 74	java/lang/StringBuilder
      //   530: dup
      //   531: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   534: ldc 242
      //   536: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   539: invokestatic 106	java/lang/System:currentTimeMillis	()J
      //   542: lload 8
      //   544: lsub
      //   545: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   548: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   551: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   554: return
      //   555: lload 6
      //   557: lstore_2
      //   558: goto -225 -> 333
      //   561: aload 14
      //   563: getfield 224	apaz$a:vid	Ljava/lang/String;
      //   566: ifnull +820 -> 1386
      //   569: aload 14
      //   571: getfield 248	apaz$a:cnJ	Ljava/lang/String;
      //   574: invokestatic 254	aqhs:hexStr2Bytes	(Ljava/lang/String;)[B
      //   577: astore 16
      //   579: aload 15
      //   581: invokestatic 259	ahav:x	(Ljava/lang/String;)[B
      //   584: astore 17
      //   586: new 74	java/lang/StringBuilder
      //   589: dup
      //   590: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   593: ldc_w 261
      //   596: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   599: aload 14
      //   601: getfield 264	apaz$a:cnH	Ljava/lang/String;
      //   604: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   607: ldc_w 266
      //   610: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   613: aload 14
      //   615: getfield 269	apaz$a:cnI	Ljava/lang/String;
      //   618: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   621: ldc_w 271
      //   624: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   627: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   630: astore 18
      //   632: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   635: ifeq +44 -> 679
      //   638: ldc 72
      //   640: iconst_2
      //   641: new 74	java/lang/StringBuilder
      //   644: dup
      //   645: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   648: ldc_w 273
      //   651: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   654: aload 18
      //   656: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   659: ldc_w 275
      //   662: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   665: aload 14
      //   667: getfield 224	apaz$a:vid	Ljava/lang/String;
      //   670: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   673: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   676: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   679: aload_0
      //   680: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   683: invokeinterface 278 1 0
      //   688: new 280	java/io/RandomAccessFile
      //   691: dup
      //   692: aload 15
      //   694: ldc_w 282
      //   697: invokespecial 284	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   700: astore 13
      //   702: lconst_0
      //   703: lstore 4
      //   705: lload_2
      //   706: lload 4
      //   708: lsub
      //   709: l2i
      //   710: istore_1
      //   711: aload 13
      //   713: astore 12
      //   715: invokestatic 175	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   718: invokestatic 181	jqc:ak	(Landroid/content/Context;)Z
      //   721: ifeq +341 -> 1062
      //   724: aload 13
      //   726: astore 12
      //   728: aload_0
      //   729: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   732: invokevirtual 95	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   735: ifne +327 -> 1062
      //   738: aload 13
      //   740: astore 12
      //   742: aload 16
      //   744: aload 17
      //   746: aload 18
      //   748: lload 6
      //   750: aload 13
      //   752: lload 4
      //   754: iload_1
      //   755: invokestatic 289	apaz:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
      //   758: lstore 4
      //   760: aload 13
      //   762: astore 12
      //   764: aload_0
      //   765: lload 4
      //   767: putfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mOffset	J
      //   770: lload 4
      //   772: ldc2_w 38
      //   775: lcmp
      //   776: ifeq +233 -> 1009
      //   779: aload 13
      //   781: astore 12
      //   783: aload_0
      //   784: invokevirtual 65	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:isStopped	()Z
      //   787: ifne +617 -> 1404
      //   790: aload 13
      //   792: astore 12
      //   794: aload_0
      //   795: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   798: lload 4
      //   800: l2d
      //   801: ldc2_w 216
      //   804: dmul
      //   805: d2l
      //   806: invokeinterface 220 3 0
      //   811: goto +593 -> 1404
      //   814: aload 13
      //   816: astore 12
      //   818: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   821: ifeq +34 -> 855
      //   824: aload 13
      //   826: astore 12
      //   828: ldc 72
      //   830: iconst_2
      //   831: new 74	java/lang/StringBuilder
      //   834: dup
      //   835: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   838: ldc_w 291
      //   841: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   844: iload 10
      //   846: invokevirtual 84	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   849: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   852: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   855: iload 10
      //   857: ifeq +510 -> 1367
      //   860: aload 13
      //   862: astore 12
      //   864: aload_0
      //   865: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   868: invokevirtual 95	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   871: ifne +496 -> 1367
      //   874: aload 13
      //   876: astore 12
      //   878: aload 15
      //   880: aload_0
      //   881: getfield 27	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
      //   884: getfield 223	com/tencent/mobileqq/activity/bless/BlessResultActivity:aYK	Ljava/lang/String;
      //   887: aload_0
      //   888: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mUin	Ljava/lang/String;
      //   891: aload_0
      //   892: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:fT	Ljava/lang/String;
      //   895: aload 14
      //   897: getfield 224	apaz$a:vid	Ljava/lang/String;
      //   900: aload 14
      //   902: getfield 227	apaz$a:fid	Ljava/lang/String;
      //   905: ldc 183
      //   907: invokestatic 230	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
      //   910: istore 10
      //   912: iload 10
      //   914: istore 11
      //   916: lload_2
      //   917: ldc2_w 38
      //   920: lcmp
      //   921: ifeq +21 -> 942
      //   924: aload 13
      //   926: astore 12
      //   928: aload_0
      //   929: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   932: lload_2
      //   933: invokeinterface 220 3 0
      //   938: iload 10
      //   940: istore 11
      //   942: aload 13
      //   944: astore 12
      //   946: aload_0
      //   947: getfield 27	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
      //   950: aload 14
      //   952: getfield 224	apaz$a:vid	Ljava/lang/String;
      //   955: putfield 233	com/tencent/mobileqq/activity/bless/BlessResultActivity:aYL	Ljava/lang/String;
      //   958: iload 11
      //   960: istore 10
      //   962: aload 13
      //   964: ifnull -472 -> 492
      //   967: aload 13
      //   969: invokevirtual 294	java/io/RandomAccessFile:close	()V
      //   972: iload 11
      //   974: istore 10
      //   976: goto -484 -> 492
      //   979: astore 12
      //   981: iload 11
      //   983: istore 10
      //   985: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   988: ifeq -496 -> 492
      //   991: ldc 72
      //   993: iconst_2
      //   994: aload 12
      //   996: invokestatic 298	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   999: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1002: iload 11
      //   1004: istore 10
      //   1006: goto -514 -> 492
      //   1009: iconst_1
      //   1010: istore_1
      //   1011: aload 13
      //   1013: astore 12
      //   1015: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1018: ifeq +362 -> 1380
      //   1021: aload 13
      //   1023: astore 12
      //   1025: ldc 72
      //   1027: iconst_2
      //   1028: new 74	java/lang/StringBuilder
      //   1031: dup
      //   1032: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   1035: ldc_w 300
      //   1038: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1041: invokestatic 106	java/lang/System:currentTimeMillis	()J
      //   1044: lload 8
      //   1046: lsub
      //   1047: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1050: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1053: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1056: lload 4
      //   1058: lstore_2
      //   1059: goto +370 -> 1429
      //   1062: iconst_1
      //   1063: istore_1
      //   1064: aload 13
      //   1066: astore 12
      //   1068: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1071: ifeq +306 -> 1377
      //   1074: aload 13
      //   1076: astore 12
      //   1078: ldc 72
      //   1080: iconst_2
      //   1081: new 74	java/lang/StringBuilder
      //   1084: dup
      //   1085: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   1088: ldc_w 302
      //   1091: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1094: invokestatic 106	java/lang/System:currentTimeMillis	()J
      //   1097: lload 8
      //   1099: lsub
      //   1100: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1103: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1106: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1109: goto +320 -> 1429
      //   1112: astore 14
      //   1114: aconst_null
      //   1115: astore 13
      //   1117: iconst_0
      //   1118: istore 11
      //   1120: aload 13
      //   1122: astore 12
      //   1124: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1127: ifeq +37 -> 1164
      //   1130: aload 13
      //   1132: astore 12
      //   1134: ldc 72
      //   1136: iconst_2
      //   1137: new 74	java/lang/StringBuilder
      //   1140: dup
      //   1141: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   1144: ldc_w 304
      //   1147: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1150: aload 14
      //   1152: invokestatic 298	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1155: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1158: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1161: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1164: iload 11
      //   1166: istore 10
      //   1168: aload 13
      //   1170: ifnull -678 -> 492
      //   1173: aload 13
      //   1175: invokevirtual 294	java/io/RandomAccessFile:close	()V
      //   1178: iload 11
      //   1180: istore 10
      //   1182: goto -690 -> 492
      //   1185: astore 12
      //   1187: iload 11
      //   1189: istore 10
      //   1191: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1194: ifeq -702 -> 492
      //   1197: ldc 72
      //   1199: iconst_2
      //   1200: aload 12
      //   1202: invokestatic 298	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1205: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1208: iload 11
      //   1210: istore 10
      //   1212: goto -720 -> 492
      //   1215: astore 13
      //   1217: aconst_null
      //   1218: astore 12
      //   1220: aload 12
      //   1222: ifnull +8 -> 1230
      //   1225: aload 12
      //   1227: invokevirtual 294	java/io/RandomAccessFile:close	()V
      //   1230: aload 13
      //   1232: athrow
      //   1233: astore 12
      //   1235: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1238: ifeq -8 -> 1230
      //   1241: ldc 72
      //   1243: iconst_2
      //   1244: aload 12
      //   1246: invokestatic 298	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1249: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1252: goto -22 -> 1230
      //   1255: aload_0
      //   1256: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   1259: aload_0
      //   1260: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mOffset	J
      //   1263: invokeinterface 127 3 0
      //   1268: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1271: ifeq -1215 -> 56
      //   1274: ldc 72
      //   1276: iconst_2
      //   1277: new 74	java/lang/StringBuilder
      //   1280: dup
      //   1281: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   1284: ldc_w 306
      //   1287: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1290: invokestatic 106	java/lang/System:currentTimeMillis	()J
      //   1293: lload 8
      //   1295: lsub
      //   1296: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1299: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1302: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1305: return
      //   1306: aload_0
      //   1307: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_b_of_type_Apaz$b	Lapaz$b;
      //   1310: aload_0
      //   1311: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:mOffset	J
      //   1314: invokeinterface 309 3 0
      //   1319: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1322: ifeq -1266 -> 56
      //   1325: ldc 72
      //   1327: iconst_2
      //   1328: new 74	java/lang/StringBuilder
      //   1331: dup
      //   1332: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   1335: ldc_w 311
      //   1338: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1341: invokestatic 106	java/lang/System:currentTimeMillis	()J
      //   1344: lload 8
      //   1346: lsub
      //   1347: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1350: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1353: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1356: return
      //   1357: astore 13
      //   1359: goto -139 -> 1220
      //   1362: astore 14
      //   1364: goto -247 -> 1117
      //   1367: iload 10
      //   1369: istore 11
      //   1371: goto -429 -> 942
      //   1374: goto -669 -> 705
      //   1377: goto +52 -> 1429
      //   1380: lload 4
      //   1382: lstore_2
      //   1383: goto +46 -> 1429
      //   1386: iconst_0
      //   1387: istore 10
      //   1389: goto -897 -> 492
      //   1392: iconst_1
      //   1393: istore 10
      //   1395: goto -915 -> 480
      //   1398: aconst_null
      //   1399: astore 14
      //   1401: goto -1093 -> 308
      //   1404: ldc2_w 194
      //   1407: lload 4
      //   1409: ladd
      //   1410: lload 6
      //   1412: lcmp
      //   1413: ifle +26 -> 1439
      //   1416: lload 6
      //   1418: lstore_2
      //   1419: lload 4
      //   1421: lload 6
      //   1423: lcmp
      //   1424: iflt -50 -> 1374
      //   1427: iconst_0
      //   1428: istore_1
      //   1429: iload_1
      //   1430: ifne -616 -> 814
      //   1433: iconst_1
      //   1434: istore 10
      //   1436: goto -622 -> 814
      //   1439: ldc2_w 194
      //   1442: lload 4
      //   1444: ladd
      //   1445: lstore_2
      //   1446: goto -27 -> 1419
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1449	0	this	VideoUploadTask
      //   710	720	1	i	int
      //   332	1114	2	l1	long
      //   703	740	4	l2	long
      //   318	1104	6	l3	long
      //   3	1342	8	l4	long
      //   178	1257	10	bool1	boolean
      //   452	918	11	bool2	boolean
      //   119	826	12	localObject1	Object
      //   979	16	12	localIOException1	java.io.IOException
      //   1013	120	12	localObject2	Object
      //   1185	16	12	localIOException2	java.io.IOException
      //   1218	8	12	localObject3	Object
      //   1233	12	12	localIOException3	java.io.IOException
      //   215	959	13	localObject4	Object
      //   1215	16	13	localObject5	Object
      //   1357	1	13	localObject6	Object
      //   306	645	14	locala	apaz.a
      //   1112	39	14	localException1	Exception
      //   1362	1	14	localException2	Exception
      //   1399	1	14	localObject7	Object
      //   187	692	15	str1	String
      //   577	166	16	arrayOfByte1	byte[]
      //   584	161	17	arrayOfByte2	byte[]
      //   630	117	18	str2	String
      // Exception table:
      //   from	to	target	type
      //   967	972	979	java/io/IOException
      //   679	702	1112	java/lang/Exception
      //   1173	1178	1185	java/io/IOException
      //   679	702	1215	finally
      //   1225	1230	1233	java/io/IOException
      //   715	724	1357	finally
      //   728	738	1357	finally
      //   742	760	1357	finally
      //   764	770	1357	finally
      //   783	790	1357	finally
      //   794	811	1357	finally
      //   818	824	1357	finally
      //   828	855	1357	finally
      //   864	874	1357	finally
      //   878	912	1357	finally
      //   928	938	1357	finally
      //   946	958	1357	finally
      //   1015	1021	1357	finally
      //   1025	1056	1357	finally
      //   1068	1074	1357	finally
      //   1078	1109	1357	finally
      //   1124	1130	1357	finally
      //   1134	1164	1357	finally
      //   715	724	1362	java/lang/Exception
      //   728	738	1362	java/lang/Exception
      //   742	760	1362	java/lang/Exception
      //   764	770	1362	java/lang/Exception
      //   783	790	1362	java/lang/Exception
      //   794	811	1362	java/lang/Exception
      //   818	824	1362	java/lang/Exception
      //   828	855	1362	java/lang/Exception
      //   864	874	1362	java/lang/Exception
      //   878	912	1362	java/lang/Exception
      //   928	938	1362	java/lang/Exception
      //   946	958	1362	java/lang/Exception
      //   1015	1021	1362	java/lang/Exception
      //   1025	1056	1362	java/lang/Exception
      //   1068	1074	1362	java/lang/Exception
      //   1078	1109	1362	java/lang/Exception
    }
    
    public void stop()
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "VideoUploadTask stop()");
      }
      this.bN.set(true);
    }
  }
  
  public static class a
    implements Cloneable
  {
    public String path;
    public String vid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity
 * JD-Core Version:    0.7.0.1
 */