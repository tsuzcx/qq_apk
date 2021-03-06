package com.tencent.biz.game;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.webviewplugin.JsWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mv;
import mw;
import mx;
import my;
import mz;
import na;
import nb;
import nc;
import ne;
import nf;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorAPIJavaScript
  extends JsWebViewPlugin
{
  static final byte jdField_a_of_type_Byte = 1;
  public static final int a = 1;
  public static final String a = "qbizApi";
  public static final int b = 0;
  public static final String d = "sessionInfo";
  public static final int e = 600000;
  public static final String e = "indexOfFunnyFaceClickedInWebview";
  public Activity a;
  protected SensorManager a;
  protected AudioRecord a;
  protected MediaRecorder a;
  public SoundPool a;
  public Handler a;
  protected SensorAPIJavaScript.QQSensorEventListener a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  protected Object a;
  public WeakReference a;
  protected HashMap a;
  protected boolean a;
  protected final byte b;
  protected SensorAPIJavaScript.QQSensorEventListener b;
  public String b;
  protected boolean b;
  protected final byte c;
  protected final int c;
  protected SensorAPIJavaScript.QQSensorEventListener c;
  protected String c;
  public boolean c;
  protected final byte d;
  protected final int d;
  protected final int f = 5;
  protected final int g = 291;
  protected final int h = 0;
  protected final int i = 1;
  protected final int j = 2;
  protected final int k = 3;
  protected final int l = 4;
  protected final int m = 0;
  protected final int n = 1;
  protected int o = 100;
  
  public SensorAPIJavaScript()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Byte = 0;
    this.jdField_c_of_type_Byte = 1;
    this.jdField_d_of_type_Byte = 2;
    this.jdField_c_of_type_Int = 8000;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new mv(this);
  }
  
  private void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start checkWifiStatus");
    }
    new ne(this, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), paramString).start();
  }
  
  /* Error */
  public final int a()
  {
    // Byte code:
    //   0: invokestatic 148	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 150	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   10: ldc 153
    //   12: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 159
    //   17: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokevirtual 167	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 173	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   33: astore_2
    //   34: new 175	java/io/BufferedReader
    //   37: dup
    //   38: new 177	java/io/InputStreamReader
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 180	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_3
    //   50: new 185	java/lang/StringBuffer
    //   53: dup
    //   54: invokespecial 186	java/lang/StringBuffer:<init>	()V
    //   57: astore 5
    //   59: aload_3
    //   60: invokevirtual 189	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 6
    //   65: aload 6
    //   67: ifnull +76 -> 143
    //   70: aload 5
    //   72: aload 6
    //   74: invokevirtual 192	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: goto -19 -> 59
    //   81: astore 4
    //   83: aload_3
    //   84: astore 4
    //   86: aload_2
    //   87: astore_3
    //   88: aload 4
    //   90: astore_2
    //   91: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   94: ifeq +29 -> 123
    //   97: ldc 114
    //   99: iconst_4
    //   100: new 150	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   107: ldc 194
    //   109: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 196
    //   114: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 201	java/io/BufferedReader:close	()V
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 204	java/io/InputStream:close	()V
    //   139: iconst_1
    //   140: istore_1
    //   141: iload_1
    //   142: ireturn
    //   143: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   146: ifeq +32 -> 178
    //   149: ldc 114
    //   151: iconst_4
    //   152: new 150	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   159: ldc 206
    //   161: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 5
    //   166: invokevirtual 207	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   169: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload 4
    //   180: invokevirtual 210	java/lang/Process:waitFor	()I
    //   183: ifne +70 -> 253
    //   186: iconst_0
    //   187: istore_1
    //   188: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   191: ifeq +29 -> 220
    //   194: ldc 114
    //   196: iconst_4
    //   197: new 150	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   204: ldc 194
    //   206: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 212
    //   211: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 201	java/io/BufferedReader:close	()V
    //   228: aload_2
    //   229: ifnull -88 -> 141
    //   232: aload_2
    //   233: invokevirtual 204	java/io/InputStream:close	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_2
    //   239: aload_2
    //   240: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_3
    //   246: aload_3
    //   247: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   250: goto -22 -> 228
    //   253: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   256: ifeq +29 -> 285
    //   259: ldc 114
    //   261: iconst_4
    //   262: new 150	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   269: ldc 194
    //   271: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 217
    //   276: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 201	java/io/BufferedReader:close	()V
    //   293: aload_2
    //   294: ifnull -155 -> 139
    //   297: aload_2
    //   298: invokevirtual 204	java/io/InputStream:close	()V
    //   301: goto -162 -> 139
    //   304: astore_2
    //   305: aload_2
    //   306: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   309: goto -170 -> 139
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   317: goto -24 -> 293
    //   320: astore_2
    //   321: aload_2
    //   322: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   325: goto -194 -> 131
    //   328: astore_2
    //   329: aload_2
    //   330: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   333: goto -194 -> 139
    //   336: astore_2
    //   337: aconst_null
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_2
    //   341: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   344: ifeq +29 -> 373
    //   347: ldc 114
    //   349: iconst_4
    //   350: new 150	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   357: ldc 194
    //   359: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 219
    //   364: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload_3
    //   374: ifnull +7 -> 381
    //   377: aload_3
    //   378: invokevirtual 201	java/io/BufferedReader:close	()V
    //   381: aload_2
    //   382: ifnull -243 -> 139
    //   385: aload_2
    //   386: invokevirtual 204	java/io/InputStream:close	()V
    //   389: goto -250 -> 139
    //   392: astore_2
    //   393: aload_2
    //   394: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   397: goto -258 -> 139
    //   400: astore_3
    //   401: aload_3
    //   402: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   405: goto -24 -> 381
    //   408: astore 4
    //   410: aconst_null
    //   411: astore_3
    //   412: aconst_null
    //   413: astore_2
    //   414: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   417: ifeq +28 -> 445
    //   420: ldc 114
    //   422: iconst_4
    //   423: new 150	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   430: ldc 194
    //   432: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aconst_null
    //   436: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_3
    //   446: ifnull +7 -> 453
    //   449: aload_3
    //   450: invokevirtual 201	java/io/BufferedReader:close	()V
    //   453: aload_2
    //   454: ifnull +7 -> 461
    //   457: aload_2
    //   458: invokevirtual 204	java/io/InputStream:close	()V
    //   461: aload 4
    //   463: athrow
    //   464: astore_3
    //   465: aload_3
    //   466: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   469: goto -16 -> 453
    //   472: astore_2
    //   473: aload_2
    //   474: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   477: goto -16 -> 461
    //   480: astore 4
    //   482: aconst_null
    //   483: astore_3
    //   484: goto -70 -> 414
    //   487: astore 4
    //   489: goto -75 -> 414
    //   492: astore_3
    //   493: aconst_null
    //   494: astore_3
    //   495: goto -154 -> 341
    //   498: astore 4
    //   500: goto -159 -> 341
    //   503: astore_2
    //   504: aconst_null
    //   505: astore_2
    //   506: aconst_null
    //   507: astore_3
    //   508: goto -417 -> 91
    //   511: astore_3
    //   512: aconst_null
    //   513: astore 4
    //   515: aload_2
    //   516: astore_3
    //   517: aload 4
    //   519: astore_2
    //   520: goto -429 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	SensorAPIJavaScript
    //   140	48	1	i1	int
    //   33	200	2	localObject1	Object
    //   238	60	2	localIOException1	java.io.IOException
    //   304	2	2	localIOException2	java.io.IOException
    //   320	2	2	localIOException3	java.io.IOException
    //   328	2	2	localIOException4	java.io.IOException
    //   336	1	2	localInterruptedException1	java.lang.InterruptedException
    //   340	46	2	localObject2	Object
    //   392	2	2	localIOException5	java.io.IOException
    //   413	45	2	localObject3	Object
    //   472	2	2	localIOException6	java.io.IOException
    //   503	1	2	localIOException7	java.io.IOException
    //   505	15	2	localObject4	Object
    //   49	176	3	localObject5	Object
    //   245	45	3	localIOException8	java.io.IOException
    //   312	2	3	localIOException9	java.io.IOException
    //   338	40	3	localObject6	Object
    //   400	2	3	localIOException10	java.io.IOException
    //   411	39	3	localObject7	Object
    //   464	2	3	localIOException11	java.io.IOException
    //   483	1	3	localObject8	Object
    //   492	1	3	localInterruptedException2	java.lang.InterruptedException
    //   494	14	3	localObject9	Object
    //   511	1	3	localIOException12	java.io.IOException
    //   516	1	3	localObject10	Object
    //   26	3	4	localProcess	java.lang.Process
    //   81	1	4	localIOException13	java.io.IOException
    //   84	95	4	localObject11	Object
    //   408	54	4	localObject12	Object
    //   480	1	4	localObject13	Object
    //   487	1	4	localObject14	Object
    //   498	1	4	localInterruptedException3	java.lang.InterruptedException
    //   513	5	4	localObject15	Object
    //   57	108	5	localStringBuffer	java.lang.StringBuffer
    //   63	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   50	59	81	java/io/IOException
    //   59	65	81	java/io/IOException
    //   70	78	81	java/io/IOException
    //   143	178	81	java/io/IOException
    //   178	186	81	java/io/IOException
    //   232	236	238	java/io/IOException
    //   224	228	245	java/io/IOException
    //   297	301	304	java/io/IOException
    //   289	293	312	java/io/IOException
    //   127	131	320	java/io/IOException
    //   135	139	328	java/io/IOException
    //   0	34	336	java/lang/InterruptedException
    //   385	389	392	java/io/IOException
    //   377	381	400	java/io/IOException
    //   0	34	408	finally
    //   449	453	464	java/io/IOException
    //   457	461	472	java/io/IOException
    //   34	50	480	finally
    //   50	59	487	finally
    //   59	65	487	finally
    //   70	78	487	finally
    //   143	178	487	finally
    //   178	186	487	finally
    //   34	50	492	java/lang/InterruptedException
    //   50	59	498	java/lang/InterruptedException
    //   59	65	498	java/lang/InterruptedException
    //   70	78	498	java/lang/InterruptedException
    //   143	178	498	java/lang/InterruptedException
    //   178	186	498	java/lang/InterruptedException
    //   0	34	503	java/io/IOException
    //   34	50	511	java/io/IOException
  }
  
  protected String a()
  {
    return "qbizApi";
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      int i1 = (int)(20.0D * Math.log10(this.jdField_a_of_type_AndroidMediaMediaRecorder.getMaxAmplitude()));
      if (!TextUtils.isEmpty(paramString))
      {
        Message localMessage = new Message();
        localMessage.what = 0;
        localMessage.obj = ("javascript: " + paramString + "(" + true + "," + i1 + ")");
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        localMessage = new Message();
        localMessage.what = 291;
        localMessage.obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.o);
      }
    }
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    HtmlOffline.b(this.jdField_a_of_type_AndroidAppActivity, paramString1, this.jdField_c_of_type_JavaLangString, new nc(this, paramString2));
  }
  
  /* Error */
  public void connectToWiFi(String paramString)
  {
    // Byte code:
    //   0: ldc 63
    //   2: astore_3
    //   3: new 289	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 291	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: ldc_w 293
    //   18: invokevirtual 297	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 4
    //   23: aload 7
    //   25: ldc_w 299
    //   28: invokevirtual 297	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload 7
    //   35: ldc_w 301
    //   38: invokevirtual 297	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 6
    //   43: aload 7
    //   45: ldc_w 303
    //   48: invokevirtual 297	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload 7
    //   54: ldc_w 305
    //   57: invokevirtual 309	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: aload_0
    //   62: getfield 72	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   65: ifeq +52 -> 117
    //   68: aload_0
    //   69: aload 6
    //   71: iconst_1
    //   72: anewarray 311	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc_w 313
    //   80: aastore
    //   81: invokevirtual 317	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   84: return
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   90: return
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   96: return
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   102: aload_3
    //   103: astore_1
    //   104: goto -52 -> 52
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   112: iconst_0
    //   113: istore_2
    //   114: goto -53 -> 61
    //   117: aload 6
    //   119: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne -38 -> 84
    //   125: aload_0
    //   126: getfield 123	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   129: ifnull -45 -> 84
    //   132: aload 4
    //   134: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +11 -> 148
    //   140: aload 5
    //   142: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifeq +20 -> 165
    //   148: aload_0
    //   149: aload 6
    //   151: iconst_1
    //   152: anewarray 311	java/lang/String
    //   155: dup
    //   156: iconst_0
    //   157: ldc_w 320
    //   160: aastore
    //   161: invokevirtual 317	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   164: return
    //   165: aload_0
    //   166: getfield 123	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   169: invokevirtual 129	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   172: ldc_w 322
    //   175: invokevirtual 328	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   178: checkcast 330	android/net/wifi/WifiManager
    //   181: astore_3
    //   182: aload_3
    //   183: ifnonnull +35 -> 218
    //   186: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 114
    //   194: iconst_4
    //   195: ldc_w 332
    //   198: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_0
    //   202: aload 6
    //   204: iconst_1
    //   205: anewarray 311	java/lang/String
    //   208: dup
    //   209: iconst_0
    //   210: ldc_w 334
    //   213: aastore
    //   214: invokevirtual 317	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   217: return
    //   218: aload_0
    //   219: iconst_1
    //   220: putfield 72	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   223: new 336	nd
    //   226: dup
    //   227: aload_0
    //   228: aload 5
    //   230: aload 4
    //   232: aload_1
    //   233: iload_2
    //   234: aload_3
    //   235: aload 6
    //   237: invokespecial 339	nd:<init>	(Lcom/tencent/biz/game/SensorAPIJavaScript;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/wifi/WifiManager;Ljava/lang/String;)V
    //   240: invokevirtual 137	java/lang/Thread:start	()V
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	SensorAPIJavaScript
    //   0	244	1	paramString	String
    //   60	174	2	bool	boolean
    //   2	101	3	str1	String
    //   107	2	3	localJSONException	JSONException
    //   181	54	3	localWifiManager	android.net.wifi.WifiManager
    //   21	210	4	str2	String
    //   31	198	5	str3	String
    //   41	195	6	str4	String
    //   11	42	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   3	13	85	org/json/JSONException
    //   13	43	91	org/json/JSONException
    //   43	52	97	org/json/JSONException
    //   52	61	107	org/json/JSONException
  }
  
  public void forceUpdate(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    forceUpdate(paramString1, paramString2, "0", paramString3);
  }
  
  public void forceUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    int i1;
    label24:
    do
    {
      return;
      i1 = 0;
      try
      {
        int i2 = Integer.valueOf(paramString3).intValue();
        i1 = i2;
      }
      catch (NumberFormatException paramString3)
      {
        break label24;
      }
      paramString3 = Uri.parse(paramString2);
    } while ((paramString3 == null) || (!paramString3.isHierarchical()) || (!"pub.idqqimg.com".equals(paramString3.getHost())));
    HtmlOffline.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2, i1, new nb(this, paramString4));
  }
  
  public final String getClientInfo()
  {
    return "{\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "660" + "\"}";
  }
  
  public boolean getCurrentSong(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c(new mx(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getCurrentSong json err");
    return true;
  }
  
  public final String getDeviceInfo()
  {
    String str = Build.MODEL;
    return "{\"model\":\"" + str + "\",\"systemName\":\"" + systemVersion() + "\",\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "660" + "\",\"isMobileQQ\":\"true\",\"identifier\":" + Util.b(MobileInfoUtil.c()) + "}";
  }
  
  public JSONObject getNetworkInfo()
  {
    Object localObject = (ConnectivityManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("connectivity");
    int i1;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
        switch (((NetworkInfo)localObject).getType())
        {
        default: 
          i1 = -1;
          localObject = "NETWORK_TYPE_UNKNOWN";
        }
      }
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", i1);
        localJSONObject.put("radio", localObject);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject;
      }
      i1 = 1;
      localObject = "NETWORK_TYPE_WIFI";
      continue;
      switch (((NetworkInfo)localObject).getSubtype())
      {
      default: 
        break;
      case 1: 
        break;
      case 2: 
        break;
      case 4: 
        break;
      case 7: 
        break;
      case 11: 
        break;
      case 3: 
        break;
      case 5: 
        break;
      case 6: 
        break;
      case 8: 
        break;
      case 9: 
        break;
      case 10: 
        break;
      case 12: 
        break;
      case 14: 
        break;
      case 15: 
        break;
      case 13: 
        break;
        String str = "NETWORK_TYPE_NO";
        i1 = 0;
      }
    }
  }
  
  public int getNetworkType()
  {
    return HttpUtil.a();
  }
  
  public boolean getPlayMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().b(new mw(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getPlayMode json err");
    return true;
  }
  
  public boolean getPlayState(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(new nf(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getPlayState json err");
    return true;
  }
  
  public final void getUserInfo(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = ("javascript: " + paramString + "(" + "{\"uin\":\"" + this.jdField_c_of_type_JavaLangString + "\",\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "660" + "\",\"isMobileQQ\":\"true\"}" + ")");
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 10)
    {
      if (paramMap != null) {
        notifyCacheReady(((Integer)paramMap.get("code")).intValue());
      }
      return true;
    }
    return false;
  }
  
  public void isCached(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = HtmlOffline.c(paramString1);
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "-1" });
      return;
    }
    callJs(paramString2, new String[] { paramString1 });
  }
  
  public final String modelVersion()
  {
    return Build.MODEL;
  }
  
  public boolean notifyCacheReady(int paramInt)
  {
    String str;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      str = "";
      if (paramInt == 0) {
        str = "success";
      }
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = ("javascript: " + this.jdField_b_of_type_JavaLangString + "(" + paramInt + ",'" + str + "')");
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return true;
      if (paramInt == 1)
      {
        str = "param error";
        continue;
        if (paramInt == 5)
        {
          str = "had update ";
          continue;
          return false;
        }
      }
      else if (paramInt == 2)
      {
        str = "download error";
      }
      else if (paramInt == 3)
      {
        str = "no sdcard";
      }
      else
      {
        if (paramInt != 4) {
          break;
        }
        str = "other ";
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt != -1) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while ((paramByte != 1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("closeSpecialLogic", false)) || (!this.jdField_a_of_type_Boolean));
      localActivity = this.mRuntime.a();
    } while (localActivity == null);
    localActivity.setResult(-1, paramIntent);
    localActivity.finish();
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.mRuntime.a());
    if (this.mRuntime.a() != null) {
      this.jdField_c_of_type_JavaLangString = this.mRuntime.a().a();
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  public void onDestroy()
  {
    release();
  }
  
  public final void openLinkInNewWebView(String paramString1, String paramString2)
  {
    Bundle localBundle;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      if (localBundle != null) {
        break label192;
      }
      localBundle = new Bundle();
    }
    try
    {
      for (;;)
      {
        i1 = Integer.valueOf(paramString2).intValue();
        switch (i1)
        {
        default: 
          paramString2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass());
          paramString2.putExtras(localBundle);
          paramString2.putExtra("url", paramString1);
          paramString2.setFlags(0);
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))
          {
            paramString1 = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).K;
            if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("closeSpecialLogic")) && (URLUtil.a(URLUtil.a(paramString1), "closeSpecialLogic", 0) != 0)) {
              this.jdField_a_of_type_Boolean = true;
            }
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label337;
          }
          startActivityForResult(paramString2, (byte)1);
          return;
          label192:
          localBundle.remove("title");
          localBundle.remove("leftViewText");
          localBundle.remove("post_data");
          localBundle.remove("options");
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i1 = 0;
        continue;
        localBundle.putBoolean("hide_more_button", false);
        localBundle.putBoolean("hide_operation_bar", true);
        continue;
        localBundle.putBoolean("hide_more_button", true);
        localBundle.putBoolean("hide_operation_bar", true);
        continue;
        localBundle.putBoolean("hide_more_button", false);
        localBundle.putBoolean("hide_operation_bar", false);
        localBundle.putString("webStyle", "");
        continue;
        localBundle.putBoolean("hide_more_button", true);
        localBundle.putBoolean("hide_operation_bar", false);
        localBundle.putString("webStyle", "");
      }
      label337:
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString2, 100);
    }
  }
  
  public boolean pausePlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a();
    return true;
  }
  
  public final void phoneVibrate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString).longValue();
        paramString = (Vibrator)this.jdField_a_of_type_AndroidAppActivity.getSystemService("vibrator");
        if (paramString == null) {
          continue;
        }
        paramString.vibrate(l1);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          long l1 = 0L;
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  public boolean playVoice(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
          this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) {
          break;
        }
      } while (!preloadVoice(paramString1, paramString2, null));
      if (Build.VERSION.SDK_INT >= 8) {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new my(this, paramString2));
      }
      int i1;
      do
      {
        for (;;)
        {
          return true;
          i1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new mz(this, i1, paramString2), 200L);
          }
        }
        i1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
      } while (this.jdField_a_of_type_AndroidMediaSoundPool.play(i1, 1.0F, 1.0F, 0, 0, 1.0F) != 0);
    } while (!QLog.isColorLevel());
    QLog.d("SensorApi", 2, "play failure url=" + paramString2);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  public boolean preloadVoice(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)))) {
      return false;
    }
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    paramString3 = new StringBuilder();
    paramString3.append(str);
    paramString3.append("tencent/QQLite/qbiz/html5/");
    paramString3.append(paramString1);
    paramString3.append('/');
    str = Uri.parse(paramString2).getScheme();
    paramString1 = "";
    if (str != null) {
      paramString1 = str + "://";
    }
    if (paramString2.length() >= paramString1.length()) {
      paramString3.append(paramString2.substring(paramString1.length()));
    }
    paramString1 = new File(paramString3.toString());
    if (!paramString1.exists()) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (Build.VERSION.SDK_INT >= 8) {
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(null);
    }
    int i1 = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString1.getAbsolutePath(), 1);
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "load failure url=" + paramString2);
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Integer.valueOf(i1));
    return true;
  }
  
  public final String qqVersion()
  {
    try
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidAppActivity.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public void refreshOfflineCache()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localWebView != null) {
        localWebView.loadUrl(localWebView.getUrl());
      }
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    stopAccelerometer();
    stopCompass();
    stopListen();
    stopLight();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public boolean resumePlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().b();
    return true;
  }
  
  public void returnToAIO()
  {
    if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
      }
      new Handler().postDelayed(new na(this), 400L);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(4660);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void sendFunnyFace(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      int i1 = Integer.parseInt(paramString5);
      paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      paramString1.putExtra("indexOfFunnyFaceClickedInWebview", i1);
      paramString2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if (paramString2 != null)
      {
        paramString2 = (SessionInfo)paramString2.getParcelableExtra("sessionInfo");
        if (paramString2 != null)
        {
          ChatActivityUtils.a(paramString2, paramString1);
          paramString1.putExtra("sessionInfo", paramString2);
          paramString1.addFlags(67108864);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public boolean setPlayMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          int i1 = paramString.optInt("mode", -1);
          if (i1 != -1)
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(i1);
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "setPlayMode json err");
    return true;
  }
  
  public final void startAccelerometer(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(1);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopAccelerometer();
      }
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)0, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startCompass(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(3);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopCompass();
      }
      this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)2, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startLight(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(5);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopLight();
      }
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)1, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startListen(String paramString)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      callJs(paramString, new String[] { "false" });
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder == null) {
      this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(3);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(0);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile("/dev/null");
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxDuration(600000);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
      a(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      callJs(paramString, new String[] { "false" });
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean startPlayMusic(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(paramString);
      return true;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "playQQMusic err:" + paramString);
      }
      localJSONException.printStackTrace();
    }
    return true;
  }
  
  public final void stopAccelerometer()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public void stopCompass()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public final void stopLight()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public final void stopListen()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(291);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean stopPlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c();
    return true;
  }
  
  public final String systemName()
  {
    return "android";
  }
  
  public final String systemVersion()
  {
    return Build.VERSION.RELEASE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */