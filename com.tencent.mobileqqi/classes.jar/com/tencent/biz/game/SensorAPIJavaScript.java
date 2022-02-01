package com.tencent.biz.game;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;
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
import bja;
import bjb;
import bjc;
import bjd;
import bje;
import bjf;
import bjg;
import bjh;
import bji;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.webviewplugin.JsWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class SensorAPIJavaScript
  extends JsWebViewPlugin
{
  public static final int a = 1;
  public static MSFToWebViewConnector a;
  public static final String a = "qbizApi";
  public static final int b = 0;
  protected final byte a;
  protected SensorManager a;
  public AudioRecord a;
  public SoundPool a;
  public Handler a;
  protected SensorAPIJavaScript.QQSensorEventListener a;
  public QQBrowserActivity a;
  public Object a;
  public WeakReference a;
  protected HashMap a;
  public boolean a;
  protected final byte b;
  protected SensorAPIJavaScript.QQSensorEventListener b;
  public String b;
  public boolean b;
  protected final byte c;
  protected final int c;
  protected SensorAPIJavaScript.QQSensorEventListener c;
  protected String c;
  protected final int d = 0;
  protected final int e = 5;
  
  public SensorAPIJavaScript()
  {
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 1;
    this.jdField_c_of_type_Byte = 2;
    this.jdField_c_of_type_Int = 8000;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bjc(this);
  }
  
  private void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start checkWifiStatus");
    }
    new bjb(this, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), paramString).start();
  }
  
  public static MSFToWebViewConnector getMsfToWebViewConnector()
  {
    return jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector;
  }
  
  protected String a()
  {
    return "qbizApi";
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    HtmlOffline.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramString1, this.jdField_c_of_type_JavaLangString, new bjh(this, paramString2));
  }
  
  /* Error */
  public void connectToWiFi(String paramString)
  {
    // Byte code:
    //   0: ldc 45
    //   2: astore_3
    //   3: new 120	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: ldc 124
    //   17: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: aload 7
    //   24: ldc 130
    //   26: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 5
    //   31: aload 7
    //   33: ldc 132
    //   35: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 6
    //   40: aload 7
    //   42: ldc 134
    //   44: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_1
    //   48: aload 7
    //   50: ldc 136
    //   52: invokevirtual 140	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   55: istore_2
    //   56: aload_0
    //   57: getfield 54	com/tencent/biz/game/SensorAPIJavaScript:jdField_b_of_type_Boolean	Z
    //   60: ifeq +51 -> 111
    //   63: aload_0
    //   64: aload 6
    //   66: iconst_1
    //   67: anewarray 142	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: ldc 144
    //   74: aastore
    //   75: invokevirtual 148	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   78: return
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 151	org/json/JSONException:printStackTrace	()V
    //   84: return
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 151	org/json/JSONException:printStackTrace	()V
    //   90: return
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 151	org/json/JSONException:printStackTrace	()V
    //   96: aload_3
    //   97: astore_1
    //   98: goto -50 -> 48
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 151	org/json/JSONException:printStackTrace	()V
    //   106: iconst_0
    //   107: istore_2
    //   108: goto -52 -> 56
    //   111: aload 6
    //   113: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifne -38 -> 78
    //   119: aload_0
    //   120: getfield 85	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   123: ifnull -45 -> 78
    //   126: aload 4
    //   128: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +11 -> 142
    //   134: aload 5
    //   136: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifeq +19 -> 158
    //   142: aload_0
    //   143: aload 6
    //   145: iconst_1
    //   146: anewarray 142	java/lang/String
    //   149: dup
    //   150: iconst_0
    //   151: ldc 159
    //   153: aastore
    //   154: invokevirtual 148	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   157: return
    //   158: aload_0
    //   159: getfield 85	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   162: invokevirtual 91	com/tencent/mobileqq/activity/QQBrowserActivity:getApplicationContext	()Landroid/content/Context;
    //   165: ldc 161
    //   167: invokevirtual 167	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   170: checkcast 169	android/net/wifi/WifiManager
    //   173: astore_3
    //   174: aload_3
    //   175: ifnonnull +33 -> 208
    //   178: invokestatic 74	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   181: ifeq +11 -> 192
    //   184: ldc 76
    //   186: iconst_4
    //   187: ldc 171
    //   189: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_0
    //   193: aload 6
    //   195: iconst_1
    //   196: anewarray 142	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: ldc 173
    //   203: aastore
    //   204: invokevirtual 148	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   207: return
    //   208: aload_0
    //   209: iconst_1
    //   210: putfield 54	com/tencent/biz/game/SensorAPIJavaScript:jdField_b_of_type_Boolean	Z
    //   213: new 175	bjk
    //   216: dup
    //   217: aload_0
    //   218: aload 5
    //   220: aload 4
    //   222: aload_1
    //   223: iload_2
    //   224: aload_3
    //   225: aload 6
    //   227: invokespecial 178	bjk:<init>	(Lcom/tencent/biz/game/SensorAPIJavaScript;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/wifi/WifiManager;Ljava/lang/String;)V
    //   230: invokevirtual 99	java/lang/Thread:start	()V
    //   233: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	SensorAPIJavaScript
    //   0	234	1	paramString	String
    //   55	169	2	bool	boolean
    //   2	95	3	str1	String
    //   101	2	3	localJSONException	org.json.JSONException
    //   173	52	3	localWifiManager	android.net.wifi.WifiManager
    //   20	201	4	str2	String
    //   29	190	5	str3	String
    //   38	188	6	str4	String
    //   11	38	7	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   3	13	79	org/json/JSONException
    //   13	40	85	org/json/JSONException
    //   40	48	91	org/json/JSONException
    //   48	56	101	org/json/JSONException
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
    int i;
    label24:
    do
    {
      return;
      i = 0;
      try
      {
        int j = Integer.valueOf(paramString3).intValue();
        i = j;
      }
      catch (NumberFormatException paramString3)
      {
        break label24;
      }
      paramString3 = Uri.parse(paramString2);
    } while ((paramString3 == null) || (!paramString3.isHierarchical()) || (!"pub.idqqimg.com".equals(paramString3.getHost())));
    HtmlOffline.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramString1, paramString2, i, new bjg(this, paramString4));
  }
  
  public final String getClientInfo()
  {
    return "{\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "6604" + "\"}";
  }
  
  public final String getDeviceInfo()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.RELEASE;
    return "{\"model\":\"" + str1 + "\",\"systemName\":\"android\",\"systemVersion\":\"" + str2 + "\",\"isMobileQQ\":\"true\",\"identifier\":" + Util.b(MobileInfoUtil.c()) + "}";
  }
  
  public int getNetworkType()
  {
    Object localObject = (ConnectivityManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        switch (((NetworkInfo)localObject).getType())
        {
        default: 
          return 4;
        case 1: 
          return 1;
        }
        switch (((NetworkInfo)localObject).getSubtype())
        {
        case 7: 
        case 10: 
        case 11: 
        default: 
          return 4;
        case 1: 
        case 2: 
        case 4: 
          return 2;
        }
        return 3;
      }
    }
    return 0;
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
    paramString1 = HtmlOffline.a(paramString1);
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
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.mRuntime.a());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.mRuntime.a());
    if (this.mRuntime.a() != null) {
      this.jdField_c_of_type_JavaLangString = this.mRuntime.a().a();
    }
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
      localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getIntent().getExtras();
      if (localBundle != null) {
        break label132;
      }
      localBundle = new Bundle();
    }
    try
    {
      for (;;)
      {
        i = Integer.valueOf(paramString2).intValue();
        switch (i)
        {
        default: 
          paramString2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getClass());
          paramString2.putExtras(localBundle);
          paramString2.putExtra("url", paramString1);
          paramString2.setFlags(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivityForResult(paramString2, 100);
          return;
          label132:
          localBundle.remove("title");
          localBundle.remove("leftViewText");
          localBundle.remove("post_data");
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i = 0;
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
    }
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
        paramString = (Vibrator)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("vibrator");
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
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new bjd(this, paramString2));
      }
      int i;
      do
      {
        for (;;)
        {
          return true;
          i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bje(this, i, paramString2), 200L);
          }
        }
        i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
      } while (this.jdField_a_of_type_AndroidMediaSoundPool.play(i, 1.0F, 1.0F, 0, 0, 1.0F) != 0);
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
    paramString3.append("tencent/MobileQQ/qbiz/html5/");
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
    int i = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString1.getAbsolutePath(), 1);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "load failure url=" + paramString2);
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Integer.valueOf(i));
    return true;
  }
  
  public final String qqVersion()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getPackageManager().getPackageInfo(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getPackageName(), 0).versionName;
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
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector != null)
    {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a();
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = null;
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
  
  public void returnToAIO()
  {
    if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
      }
      new Handler().postDelayed(new bjf(this), 400L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.setResult(4660);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.finish();
  }
  
  public void sendFunnyFace(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      int i = Integer.parseInt(paramString5);
      paramString1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, ChatActivity.class);
      paramString1.putExtra("indexOfFunnyFaceClickedInWebview", i);
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getIntent();
      if (paramString2 != null)
      {
        paramString2 = (SessionInfo)paramString2.getParcelableExtra("sessionInfo");
        if (paramString2 != null)
        {
          ChatActivity.a(paramString2, paramString1);
          paramString1.putExtra("sessionInfo", paramString2);
          paramString1.addFlags(67108864);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivity(paramString1);
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public final void startAccelerometer(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("sensor"));
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
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("sensor"));
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
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("sensor"));
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
    if (this.jdField_a_of_type_Boolean)
    {
      callJs(paramString, new String[] { "false" });
      return;
    }
    int i = AudioRecord.getMinBufferSize(8000, 16, 2);
    this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, 8000, 2, 2, i);
    this.jdField_a_of_type_Boolean = true;
    new Thread(new bja(this, i, paramString)).start();
  }
  
  public void startSyncData(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector == null) {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = new MSFToWebViewConnector();
    }
    AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getAppRuntime();
    if (localAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "appRuntime is null");
      }
      return;
    }
    jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a(paramString1, paramString2, localAppRuntime, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, new bji(this));
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
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void stopSyncData()
  {
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector != null) {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a();
    }
    jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */