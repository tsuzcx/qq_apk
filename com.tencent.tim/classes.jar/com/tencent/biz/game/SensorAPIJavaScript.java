package com.tencent.biz.game;

import alla;
import allc;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import aqgz;
import aqzd;
import ardm.g;
import ardm.o;
import aroi;
import arxr;
import aurr;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import joi;
import jpa;
import jpe;
import jqc;
import jqo;
import jrd;
import jrf;
import jrg;
import jrh;
import jri;
import jrj;
import jrk;
import jrl;
import jrm;
import jrn;
import jro;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;
import skj;
import wja;

public class SensorAPIJavaScript
  extends aqzd
{
  public static jrd b;
  protected final int SAMPLE_RATE_IN_HZ = 8000;
  protected final int SENSOR_DELAY = 0;
  protected int SPACE = 100;
  public String Ud;
  protected MediaRecorder a;
  protected a a;
  protected final int aCH = 5;
  protected final int aCI = 291;
  protected final int aCJ = 0;
  protected final int aCK = 1;
  protected final int aCL = 2;
  protected final int aCM = 3;
  protected final int aCN = 4;
  protected final int aCO = 0;
  protected final int aCP = 1;
  protected final byte aE = 0;
  protected final byte aF = 1;
  protected final byte aG = 2;
  protected boolean abl;
  protected boolean abm;
  protected boolean abn;
  protected a b;
  protected a c;
  protected HashMap<String, Integer> cS;
  skj mClient = null;
  public Handler mHandler;
  protected Object mLock = new Object();
  protected SensorManager mSensorManager;
  public SoundPool mSoundPool;
  protected String mUin = "";
  protected WeakReference<WebView> mWebView;
  public Activity v;
  
  private void aze()
  {
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    this.mHandler = new jrj(this);
  }
  
  public static final String getDeviceInfoEx(String paramString)
  {
    String str4 = Build.MODEL;
    String str5 = Build.VERSION.RELEASE;
    String str6 = Build.FINGERPRINT;
    String str7 = Build.VERSION.INCREMENTAL;
    String str3 = "";
    try
    {
      str1 = UserAction.getQIMEI();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          String str1;
          paramString = new JSONObject();
          paramString.put("model", str4);
          paramString.put("systemName", "android");
          paramString.put("systemVersion", str5);
          paramString.put("isMobileQQ", true);
          paramString.put("identifier", arxr.getImei());
          paramString.put("fingerprint", str6);
          paramString.put("incremental", str7);
          paramString.put("macAddress", arxr.Dy());
          paramString.put("androidID", alla.getString(aroi.a().getContext().getContentResolver(), "android_id"));
          paramString.put("imsi", arxr.getImsi());
          paramString.put("qimei", str1);
          paramString.put("totalMemory", String.valueOf(aqgz.getSystemTotalMemory()));
          paramString.put("availableMemory", String.valueOf(aqgz.getSystemAvaialbeMemory()));
          paramString.put("cpuType", aqgz.getCpuType());
          paramString.put("cpuNum", aqgz.getCpuNumber());
          paramString.put("cpuFreq", aqgz.getCpuFrequency());
          paramString.put("msfImei", MsfSdkUtils.getIMEIForMain("bussiness_id_customize_online_status"));
          paramString = paramString.toString();
          return paramString;
        }
        catch (JSONException paramString) {}
        localException = localException;
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e(paramString, 2, "get QIMEI fail");
          str2 = str3;
        }
      }
    }
    return "{}";
  }
  
  public static jrd getMsfToWebViewConnector()
  {
    return jdField_b_of_type_Jrd;
  }
  
  private void lj(String paramString)
  {
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
      allc.a(this.jdField_a_of_type_AndroidMediaMediaRecorder);
      updateMicStatus(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      callJs(paramString, new String[] { "false" });
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      this.abm = false;
    }
  }
  
  public static void returnToAio(skj paramskj, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramskj == null) {
      return;
    }
    paramskj.j(new jrl(paramActivity, paramBoolean, paramString));
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    jpa.a(paramString1, this.mRuntime.a(), new jrn(this, paramString2), false);
  }
  
  /* Error */
  public void connectToWiFi(String paramString)
  {
    // Byte code:
    //   0: ldc 70
    //   2: astore_3
    //   3: new 152	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 372	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: ldc_w 374
    //   18: invokevirtual 376	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 4
    //   23: aload 7
    //   25: ldc_w 378
    //   28: invokevirtual 376	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload 7
    //   35: ldc_w 380
    //   38: invokevirtual 376	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 6
    //   43: aload 7
    //   45: ldc_w 382
    //   48: invokevirtual 376	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload 7
    //   54: ldc_w 384
    //   57: invokevirtual 388	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: aload_0
    //   62: getfield 390	com/tencent/biz/game/SensorAPIJavaScript:abn	Z
    //   65: ifeq +52 -> 117
    //   68: aload_0
    //   69: aload 6
    //   71: iconst_1
    //   72: anewarray 228	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc_w 392
    //   80: aastore
    //   81: invokevirtual 331	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   84: return
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 393	org/json/JSONException:printStackTrace	()V
    //   90: return
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 393	org/json/JSONException:printStackTrace	()V
    //   96: return
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 393	org/json/JSONException:printStackTrace	()V
    //   102: aload_3
    //   103: astore_1
    //   104: goto -52 -> 52
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 393	org/json/JSONException:printStackTrace	()V
    //   112: iconst_0
    //   113: istore_2
    //   114: goto -53 -> 61
    //   117: aload 6
    //   119: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne -38 -> 84
    //   125: aload_0
    //   126: getfield 401	com/tencent/biz/game/SensorAPIJavaScript:v	Landroid/app/Activity;
    //   129: ifnull -45 -> 84
    //   132: aload 4
    //   134: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +11 -> 148
    //   140: aload 5
    //   142: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifeq +20 -> 165
    //   148: aload_0
    //   149: aload 6
    //   151: iconst_1
    //   152: anewarray 228	java/lang/String
    //   155: dup
    //   156: iconst_0
    //   157: ldc_w 403
    //   160: aastore
    //   161: invokevirtual 331	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   164: return
    //   165: aload_0
    //   166: getfield 401	com/tencent/biz/game/SensorAPIJavaScript:v	Landroid/app/Activity;
    //   169: invokevirtual 408	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   172: ldc_w 410
    //   175: invokevirtual 414	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   178: checkcast 416	android/net/wifi/WifiManager
    //   181: astore_3
    //   182: aload_3
    //   183: ifnonnull +36 -> 219
    //   186: invokestatic 419	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   189: ifeq +13 -> 202
    //   192: ldc_w 421
    //   195: iconst_4
    //   196: ldc_w 423
    //   199: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_0
    //   203: aload 6
    //   205: iconst_1
    //   206: anewarray 228	java/lang/String
    //   209: dup
    //   210: iconst_0
    //   211: ldc_w 428
    //   214: aastore
    //   215: invokevirtual 331	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   218: return
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 390	com/tencent/biz/game/SensorAPIJavaScript:abn	Z
    //   224: new 430	com/tencent/biz/game/SensorAPIJavaScript$10
    //   227: dup
    //   228: aload_0
    //   229: aload 5
    //   231: aload 4
    //   233: aload_1
    //   234: iload_2
    //   235: aload_3
    //   236: aload 6
    //   238: invokespecial 433	com/tencent/biz/game/SensorAPIJavaScript$10:<init>	(Lcom/tencent/biz/game/SensorAPIJavaScript;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/wifi/WifiManager;Ljava/lang/String;)V
    //   241: invokevirtual 438	java/lang/Thread:start	()V
    //   244: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	SensorAPIJavaScript
    //   0	245	1	paramString	String
    //   60	175	2	bool	boolean
    //   2	101	3	str1	String
    //   107	2	3	localJSONException	JSONException
    //   181	55	3	localWifiManager	android.net.wifi.WifiManager
    //   21	211	4	str2	String
    //   31	199	5	str3	String
    //   41	196	6	str4	String
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
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.length() > 10)) {
      return;
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    paramString2 = new HashMap(paramString2.size());
    paramString2.put(paramString1, "0");
    jpa.a(this.mRuntime.a(), paramString2, new jrm(this, paramString4), true, true, false);
  }
  
  public final String getClientInfo()
  {
    return "{\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "3058" + "\"}";
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
            this.mClient.a().c(new jri(this, paramString));
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
    return getDeviceInfoEx(this.TAG);
  }
  
  public String getNameSpace()
  {
    return "qbizApi";
  }
  
  public JSONObject getNetworkInfo()
  {
    int k = jqc.getNetWorkType();
    String str = jqc.hS();
    int j = 0;
    Object localObject = aqgz.getIMSI();
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = j;
      if (((String)localObject).length() > 5)
      {
        i = j;
        if (((String)localObject).startsWith("460"))
        {
          localObject = ((String)localObject).substring(3, 5);
          if ((!((String)localObject).equals("00")) && (!((String)localObject).equals("02")) && (!((String)localObject).equals("04")) && (!((String)localObject).equals("07"))) {
            break label148;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("type", k);
        ((JSONObject)localObject).put("radio", str);
        ((JSONObject)localObject).put("carriertype", i);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        label148:
        localJSONException.printStackTrace();
      }
      if ((((String)localObject).equals("01")) || (((String)localObject).equals("06")) || (((String)localObject).equals("09")))
      {
        i = 2;
      }
      else if ((((String)localObject).equals("03")) || (((String)localObject).equals("05")))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (((String)localObject).equals("20")) {
          i = 4;
        }
      }
    }
    return localObject;
  }
  
  public int getNetworkType()
  {
    return jqc.getNetWorkType();
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
            this.mClient.a().b(new jrh(this, paramString));
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
            this.mClient.a().a(new jrg(this, paramString));
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
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 4L)
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
    paramString1 = jpa.dL(paramString1);
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "-1" });
      return;
    }
    callJs(paramString2, new String[] { paramString1 });
  }
  
  public void lk(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start checkWifiStatus");
    }
    new SensorAPIJavaScript.11(this, this.v.getApplicationContext(), paramString).start();
  }
  
  /* Error */
  protected final int mU()
  {
    // Byte code:
    //   0: invokestatic 630	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 474	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 632
    //   13: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 634
    //   19: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 638	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 644	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   35: astore_2
    //   36: new 646	java/io/BufferedReader
    //   39: dup
    //   40: new 648	java/io/InputStreamReader
    //   43: dup
    //   44: aload_2
    //   45: invokespecial 651	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: invokespecial 654	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_3
    //   52: new 656	java/lang/StringBuffer
    //   55: dup
    //   56: invokespecial 657	java/lang/StringBuffer:<init>	()V
    //   59: astore 5
    //   61: aload_3
    //   62: invokevirtual 660	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 6
    //   67: aload 6
    //   69: ifnull +79 -> 148
    //   72: aload 5
    //   74: aload 6
    //   76: invokevirtual 663	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   79: pop
    //   80: goto -19 -> 61
    //   83: astore 4
    //   85: aload_3
    //   86: astore 4
    //   88: aload_2
    //   89: astore_3
    //   90: aload 4
    //   92: astore_2
    //   93: invokestatic 419	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   96: ifeq +32 -> 128
    //   99: ldc_w 421
    //   102: iconst_4
    //   103: new 474	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 665
    //   113: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 667
    //   119: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 670	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 673	java/io/BufferedReader:close	()V
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 676	java/io/InputStream:close	()V
    //   144: iconst_1
    //   145: istore_1
    //   146: iload_1
    //   147: ireturn
    //   148: invokestatic 419	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   151: ifeq +34 -> 185
    //   154: ldc_w 421
    //   157: iconst_4
    //   158: new 474	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 678
    //   168: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 5
    //   173: invokevirtual 679	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   176: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 670	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload 4
    //   187: invokevirtual 682	java/lang/Process:waitFor	()I
    //   190: ifne +73 -> 263
    //   193: iconst_0
    //   194: istore_1
    //   195: invokestatic 419	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   198: ifeq +32 -> 230
    //   201: ldc_w 421
    //   204: iconst_4
    //   205: new 474	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 665
    //   215: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 684
    //   221: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 670	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 673	java/io/BufferedReader:close	()V
    //   238: aload_2
    //   239: ifnull -93 -> 146
    //   242: aload_2
    //   243: invokevirtual 676	java/io/InputStream:close	()V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_3
    //   256: aload_3
    //   257: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   260: goto -22 -> 238
    //   263: invokestatic 419	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   266: ifeq +32 -> 298
    //   269: ldc_w 421
    //   272: iconst_4
    //   273: new 474	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 665
    //   283: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 687
    //   289: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 670	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_3
    //   299: ifnull +7 -> 306
    //   302: aload_3
    //   303: invokevirtual 673	java/io/BufferedReader:close	()V
    //   306: aload_2
    //   307: ifnull -163 -> 144
    //   310: aload_2
    //   311: invokevirtual 676	java/io/InputStream:close	()V
    //   314: goto -170 -> 144
    //   317: astore_2
    //   318: aload_2
    //   319: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   322: goto -178 -> 144
    //   325: astore_3
    //   326: aload_3
    //   327: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   330: goto -24 -> 306
    //   333: astore_2
    //   334: aload_2
    //   335: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   338: goto -202 -> 136
    //   341: astore_2
    //   342: aload_2
    //   343: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   346: goto -202 -> 144
    //   349: astore_2
    //   350: aconst_null
    //   351: astore_3
    //   352: aconst_null
    //   353: astore_2
    //   354: invokestatic 419	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   357: ifeq +32 -> 389
    //   360: ldc_w 421
    //   363: iconst_4
    //   364: new 474	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 665
    //   374: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc_w 689
    //   380: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 670	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: aload_3
    //   390: ifnull +7 -> 397
    //   393: aload_3
    //   394: invokevirtual 673	java/io/BufferedReader:close	()V
    //   397: aload_2
    //   398: ifnull -254 -> 144
    //   401: aload_2
    //   402: invokevirtual 676	java/io/InputStream:close	()V
    //   405: goto -261 -> 144
    //   408: astore_2
    //   409: aload_2
    //   410: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   413: goto -269 -> 144
    //   416: astore_3
    //   417: aload_3
    //   418: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   421: goto -24 -> 397
    //   424: astore 4
    //   426: aconst_null
    //   427: astore_3
    //   428: aconst_null
    //   429: astore_2
    //   430: invokestatic 419	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   433: ifeq +30 -> 463
    //   436: ldc_w 421
    //   439: iconst_4
    //   440: new 474	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 665
    //   450: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aconst_null
    //   454: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 670	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aload_3
    //   464: ifnull +7 -> 471
    //   467: aload_3
    //   468: invokevirtual 673	java/io/BufferedReader:close	()V
    //   471: aload_2
    //   472: ifnull +7 -> 479
    //   475: aload_2
    //   476: invokevirtual 676	java/io/InputStream:close	()V
    //   479: aload 4
    //   481: athrow
    //   482: astore_3
    //   483: aload_3
    //   484: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   487: goto -16 -> 471
    //   490: astore_2
    //   491: aload_2
    //   492: invokevirtual 685	java/io/IOException:printStackTrace	()V
    //   495: goto -16 -> 479
    //   498: astore 4
    //   500: aconst_null
    //   501: astore_3
    //   502: goto -72 -> 430
    //   505: astore 4
    //   507: goto -77 -> 430
    //   510: astore_3
    //   511: aconst_null
    //   512: astore_3
    //   513: goto -159 -> 354
    //   516: astore 4
    //   518: goto -164 -> 354
    //   521: astore_2
    //   522: aconst_null
    //   523: astore_2
    //   524: aconst_null
    //   525: astore_3
    //   526: goto -433 -> 93
    //   529: astore_3
    //   530: aconst_null
    //   531: astore 4
    //   533: aload_2
    //   534: astore_3
    //   535: aload 4
    //   537: astore_2
    //   538: goto -445 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	SensorAPIJavaScript
    //   145	50	1	i	int
    //   35	208	2	localObject1	Object
    //   248	63	2	localIOException1	java.io.IOException
    //   317	2	2	localIOException2	java.io.IOException
    //   333	2	2	localIOException3	java.io.IOException
    //   341	2	2	localIOException4	java.io.IOException
    //   349	1	2	localInterruptedException1	java.lang.InterruptedException
    //   353	49	2	localObject2	Object
    //   408	2	2	localIOException5	java.io.IOException
    //   429	47	2	localObject3	Object
    //   490	2	2	localIOException6	java.io.IOException
    //   521	1	2	localIOException7	java.io.IOException
    //   523	15	2	localObject4	Object
    //   51	184	3	localObject5	Object
    //   255	48	3	localIOException8	java.io.IOException
    //   325	2	3	localIOException9	java.io.IOException
    //   351	43	3	localObject6	Object
    //   416	2	3	localIOException10	java.io.IOException
    //   427	41	3	localObject7	Object
    //   482	2	3	localIOException11	java.io.IOException
    //   501	1	3	localObject8	Object
    //   510	1	3	localInterruptedException2	java.lang.InterruptedException
    //   512	14	3	localObject9	Object
    //   529	1	3	localIOException12	java.io.IOException
    //   534	1	3	localObject10	Object
    //   28	3	4	localProcess	java.lang.Process
    //   83	1	4	localIOException13	java.io.IOException
    //   86	100	4	localObject11	Object
    //   424	56	4	localObject12	Object
    //   498	1	4	localObject13	Object
    //   505	1	4	localObject14	Object
    //   516	1	4	localInterruptedException3	java.lang.InterruptedException
    //   531	5	4	localObject15	Object
    //   59	113	5	localStringBuffer	java.lang.StringBuffer
    //   65	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   52	61	83	java/io/IOException
    //   61	67	83	java/io/IOException
    //   72	80	83	java/io/IOException
    //   148	185	83	java/io/IOException
    //   185	193	83	java/io/IOException
    //   242	246	248	java/io/IOException
    //   234	238	255	java/io/IOException
    //   310	314	317	java/io/IOException
    //   302	306	325	java/io/IOException
    //   132	136	333	java/io/IOException
    //   140	144	341	java/io/IOException
    //   0	36	349	java/lang/InterruptedException
    //   401	405	408	java/io/IOException
    //   393	397	416	java/io/IOException
    //   0	36	424	finally
    //   467	471	482	java/io/IOException
    //   475	479	490	java/io/IOException
    //   36	52	498	finally
    //   52	61	505	finally
    //   61	67	505	finally
    //   72	80	505	finally
    //   148	185	505	finally
    //   185	193	505	finally
    //   36	52	510	java/lang/InterruptedException
    //   52	61	516	java/lang/InterruptedException
    //   61	67	516	java/lang/InterruptedException
    //   72	80	516	java/lang/InterruptedException
    //   148	185	516	java/lang/InterruptedException
    //   185	193	516	java/lang/InterruptedException
    //   0	36	521	java/io/IOException
    //   36	52	529	java/io/IOException
  }
  
  public final String modelVersion()
  {
    return Build.MODEL;
  }
  
  public boolean notifyCacheReady(int paramInt)
  {
    String str;
    if (!TextUtils.isEmpty(this.Ud))
    {
      str = "";
      if (paramInt == 0) {
        str = "success";
      }
    }
    for (;;)
    {
      callJs(this.Ud, new String[] { Integer.toString(paramInt), jqo.toJsString(str) });
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
      } while ((paramByte != 1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("closeSpecialLogic", false)) || (!this.abl));
      localActivity = this.mRuntime.getActivity();
    } while (localActivity == null);
    localActivity.setResult(-1, paramIntent);
    localActivity.finish();
  }
  
  public void onCreate()
  {
    super.onCreate();
    aze();
    this.v = this.mRuntime.getActivity();
    if (this.mRuntime.a() != null) {
      this.mUin = this.mRuntime.a().getCurrentAccountUin();
    }
    this.mClient = skj.a();
    this.mClient.bzj();
  }
  
  public void onDestroy()
  {
    release();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.mWebView = new WeakReference(this.mRuntime.getWebView());
  }
  
  public final void openLinkInNewWebView(String paramString1, String paramString2)
  {
    PluginJumpManager.getInstance().updateConfig(((BaseActivity)this.v).getAppRuntime());
    PluginJumpManager.getInstance().loadConfig();
    if (PluginJumpManager.getInstance().openView((BaseActivity)this.v, paramString1, paramString2)) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Bundle localBundle2 = this.v.getIntent().getExtras();
    Bundle localBundle1;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    try
    {
      for (;;)
      {
        i = Integer.valueOf(paramString2).intValue();
        switch (i)
        {
        default: 
          paramString2 = new Intent(this.v, this.v.getClass());
          paramString2.putExtras(localBundle1);
          paramString2.putExtra("url", paramString1);
          paramString2.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramString2.setFlags(0);
          paramString1 = this.mRuntime.a(this.mRuntime.getActivity());
          if ((paramString1 != null) && ((paramString1 instanceof ardm.o)))
          {
            paramString1 = ((ardm.o)paramString1).getCurrentUrl();
            if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("closeSpecialLogic")) && (aurr.getInt(aurr.getArgumentsFromURL(paramString1), "closeSpecialLogic", 0) != 0)) {
              this.abl = true;
            }
          }
          if (!this.abl) {
            break label433;
          }
          startActivityForResult(paramString2, (byte)1);
          return;
          localBundle2.remove("title");
          localBundle2.remove("leftViewText");
          localBundle2.remove("post_data");
          localBundle2.remove("options");
          localBundle1 = localBundle2;
          if (localBundle2.containsKey("startOpenPageTime"))
          {
            localBundle2.putLong("startOpenPageTime", System.currentTimeMillis());
            localBundle1 = localBundle2;
          }
          break;
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i = 0;
        continue;
        localBundle1.putBoolean("hide_more_button", false);
        localBundle1.putBoolean("hide_operation_bar", true);
        continue;
        localBundle1.putBoolean("hide_more_button", true);
        localBundle1.putBoolean("hide_operation_bar", true);
        continue;
        localBundle1.putBoolean("hide_more_button", false);
        localBundle1.putBoolean("hide_operation_bar", false);
        localBundle1.putString("webStyle", "");
        continue;
        localBundle1.putBoolean("hide_more_button", true);
        localBundle1.putBoolean("hide_operation_bar", false);
        localBundle1.putString("webStyle", "");
      }
      label433:
      this.v.startActivityForResult(paramString2, 100);
    }
  }
  
  public boolean pausePlayMusic()
  {
    this.mClient.a().ayH();
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
        l = Long.valueOf(paramString).longValue();
        paramString = (Vibrator)this.v.getSystemService("vibrator");
        if (paramString == null) {
          continue;
        }
        paramString.vibrate(l);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          long l = 0L;
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
        if (this.mSoundPool == null) {
          this.mSoundPool = new SoundPool(10, 3, 0);
        }
        if (this.cS == null) {
          this.cS = new HashMap();
        }
        if (this.cS.containsKey(paramString2)) {
          break;
        }
      } while (!preloadVoice(paramString1, paramString2, null));
      if (Build.VERSION.SDK_INT >= 8) {
        this.mSoundPool.setOnLoadCompleteListener(new jrk(this, paramString2));
      }
      int i;
      do
      {
        for (;;)
        {
          return true;
          i = ((Integer)this.cS.get(paramString2)).intValue();
          if (this.mHandler != null) {
            this.mHandler.postDelayed(new SensorAPIJavaScript.4(this, i, paramString2), 200L);
          }
        }
        i = ((Integer)this.cS.get(paramString2)).intValue();
      } while (this.mSoundPool.play(i, 1.0F, 1.0F, 0, 0, 1.0F) != 0);
    } while (!QLog.isColorLevel());
    QLog.d("SensorApi", 2, "play failure url=" + paramString2);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  public boolean preloadVoice(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || ((this.cS != null) && (this.cS.containsKey(paramString2)))) {
      return false;
    }
    new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator).toString();
    paramString3 = new StringBuilder();
    paramString3.append(jpe.hP());
    paramString3.append(paramString1);
    paramString3.append('/');
    String str = Uri.parse(paramString2).getScheme();
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
    if (this.mSoundPool == null) {
      this.mSoundPool = new SoundPool(10, 3, 0);
    }
    if (this.cS == null) {
      this.cS = new HashMap();
    }
    if (Build.VERSION.SDK_INT >= 8) {
      this.mSoundPool.setOnLoadCompleteListener(null);
    }
    int i = this.mSoundPool.load(paramString1.getAbsolutePath(), 1);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "load failure url=" + paramString2);
      }
      return false;
    }
    this.cS.put(paramString2, Integer.valueOf(i));
    return true;
  }
  
  public final String qqVersion()
  {
    try
    {
      Object localObject = this.mRuntime.a(this.mRuntime.getActivity());
      if ((localObject != null) && ((localObject instanceof ardm.g))) {
        return this.v.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      }
      localObject = this.v.getPackageManager().getPackageInfo(this.v.getPackageName(), 0).versionName;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public void refreshOfflineCache()
  {
    if (this.mWebView != null)
    {
      WebView localWebView = (WebView)this.mWebView.get();
      if (localWebView != null) {
        localWebView.loadUrl(localWebView.getUrl());
      }
    }
  }
  
  public void release()
  {
    if (this.mSoundPool != null)
    {
      this.mSoundPool.release();
      this.mSoundPool = null;
    }
    if (jdField_b_of_type_Jrd != null)
    {
      jdField_b_of_type_Jrd.exit();
      jdField_b_of_type_Jrd = null;
    }
    stopAccelerometer();
    stopCompass();
    stopListen();
    stopLight();
    if (this.mWebView != null) {
      this.mWebView.clear();
    }
    if (this.mClient != null) {
      this.mClient.bzk();
    }
    this.mWebView = null;
  }
  
  public boolean resumePlayMusic()
  {
    this.mClient.a().ayI();
    return true;
  }
  
  public void returnToAIO()
  {
    if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
      }
      new Handler().postDelayed(new SensorAPIJavaScript.5(this), 400L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SensorAPIJavaScript", 2, String.format("returnToAIO mBrowserActivity=[%s]", new Object[] { this.v }));
      }
      return;
      returnToAio(this.mClient, this.v, "", false);
    }
  }
  
  public void sendFunnyFace(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      int i = Integer.parseInt(paramString5);
      paramString1 = wja.a(new Intent(this.v, SplashActivity.class), null);
      paramString1.putExtra("indexOfFunnyFaceClickedInWebview", i);
      paramString2 = this.v.getIntent();
      if (paramString2 != null)
      {
        paramString2 = (SessionInfo)paramString2.getParcelableExtra("sessionInfo");
        if (paramString2 != null)
        {
          ChatActivityUtils.a(paramString2, paramString1);
          paramString1.putExtra("sessionInfo", paramString2);
          this.v.startActivity(paramString1);
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
          int i = paramString.optInt("mode", -1);
          if (i != -1)
          {
            this.mClient.a().setPlayMode(i);
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
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)this.v.getSystemService("sensor"));
    }
    Object localObject = this.mSensorManager.getSensorList(1);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$a != null) {
        stopAccelerometer();
      }
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$a = new a((byte)0, paramString);
      this.mSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$a, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startCompass(String paramString)
  {
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)this.v.getSystemService("sensor"));
    }
    Object localObject = this.mSensorManager.getSensorList(3);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.c != null) {
        stopCompass();
      }
      this.c = new a((byte)2, paramString);
      this.mSensorManager.registerListener(this.c, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startLight(String paramString)
  {
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)this.v.getSystemService("sensor"));
    }
    Object localObject = this.mSensorManager.getSensorList(5);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$a != null) {
        stopLight();
      }
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$a = new a((byte)1, paramString);
      this.mSensorManager.registerListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$a, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startListen(String paramString)
  {
    if (this.abm)
    {
      callJs(paramString, new String[] { "false" });
      return;
    }
    if ((this.v instanceof AppActivity))
    {
      ((AppActivity)this.v).requestPermissions(new jrf(this, paramString), 1, new String[] { "android.permission.RECORD_AUDIO" });
      return;
    }
    callJs(paramString, new String[] { "false", "{result: -1, msg: 'no record activity'}" });
  }
  
  public boolean startPlayMusic(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      new JSONObject(paramString);
      this.mClient.a().kT(paramString);
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
  
  public void startSyncData(String paramString1, String paramString2)
  {
    if (jdField_b_of_type_Jrd == null) {
      jdField_b_of_type_Jrd = new jrd();
    }
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "appRuntime is null");
      }
      return;
    }
    jdField_b_of_type_Jrd.a(paramString1, paramString2, localAppInterface, this.v, new jro(this));
  }
  
  public final void stopAccelerometer()
  {
    if ((this.mSensorManager != null) && (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$a != null))
    {
      this.mSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$a);
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$a = null;
    }
  }
  
  public void stopCompass()
  {
    if ((this.mSensorManager != null) && (this.c != null))
    {
      this.mSensorManager.unregisterListener(this.c);
      this.c = null;
    }
  }
  
  public final void stopLight()
  {
    if ((this.mSensorManager != null) && (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$a != null))
    {
      this.mSensorManager.unregisterListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$a);
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$a = null;
    }
  }
  
  public final void stopListen()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
    }
    this.mHandler.removeMessages(291);
    this.abm = false;
  }
  
  public boolean stopPlayMusic()
  {
    this.mClient.a().ayJ();
    return true;
  }
  
  public void stopSyncData()
  {
    if (jdField_b_of_type_Jrd != null) {
      jdField_b_of_type_Jrd.exit();
    }
    jdField_b_of_type_Jrd = null;
  }
  
  public final String systemName()
  {
    return "android";
  }
  
  public final String systemVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public void updateMicStatus(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      int i = (int)(Math.log10(this.jdField_a_of_type_AndroidMediaMediaRecorder.getMaxAmplitude()) * 20.0D);
      if (!TextUtils.isEmpty(paramString))
      {
        callJs(paramString, new String[] { "true", Integer.toString(i) });
        Message localMessage = new Message();
        localMessage.what = 291;
        localMessage.obj = paramString;
        this.mHandler.sendMessageDelayed(localMessage, this.SPACE);
      }
    }
  }
  
  public class a
    implements SensorEventListener
  {
    protected byte aH;
    protected String mCallBack;
    
    public a(byte paramByte, String paramString)
    {
      this.aH = paramByte;
      this.mCallBack = paramString;
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      switch (this.aH)
      {
      default: 
        return;
      case 0: 
        f1 = paramSensorEvent.values[0];
        float f2 = paramSensorEvent.values[1];
        float f3 = paramSensorEvent.values[2];
        SensorAPIJavaScript.this.callJs(this.mCallBack, new String[] { String.valueOf(true), String.valueOf(f1), String.valueOf(f2), String.valueOf(f3) });
        return;
      case 1: 
        f1 = paramSensorEvent.values[0];
        SensorAPIJavaScript.this.callJs(this.mCallBack, new String[] { String.valueOf(true), String.valueOf(f1) });
        return;
      }
      float f1 = paramSensorEvent.values[0];
      SensorAPIJavaScript.this.callJs(this.mCallBack, new String[] { String.valueOf(true), String.valueOf(f1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */