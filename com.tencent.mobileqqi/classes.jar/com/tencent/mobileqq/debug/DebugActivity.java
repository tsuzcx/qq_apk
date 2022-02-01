package com.tencent.mobileqq.debug;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode.VmPolicy.Builder;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.pic.BaseStrategy;
import com.tencent.mobileqq.pic.CircleCounter;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.vip.DownloaderFactory;
import fnl;
import fnn;
import fno;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppActivity;

@SuppressLint({"SdCardPath"})
public class DebugActivity
  extends AppActivity
{
  private static final int jdField_a_of_type_Int = 0;
  private static StrictMode.ThreadPolicy jdField_a_of_type_AndroidOsStrictMode$ThreadPolicy;
  private static StrictMode.VmPolicy jdField_a_of_type_AndroidOsStrictMode$VmPolicy;
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/mobileqq/log/memoryinfo.txt";
  public static boolean a = false;
  public static String[] a;
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/mobileqq/log/cursor.html";
  private static final int jdField_c_of_type_Int = 2;
  private static final String jdField_c_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/mobileqq/log/thread.html";
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private static final int h = 7;
  private static final int i = 8;
  private static final int j = 9;
  private static final int k = 10;
  private static final int l = 11;
  private static final int m = 12;
  private static final int n = 13;
  private static final int o = 14;
  private static final int p = 15;
  private static final int q = 16;
  private static final int r = 17;
  private static final int s = 18;
  private static final int t = 19;
  private AlertDialog.Builder jdField_a_of_type_AndroidAppAlertDialog$Builder;
  private AlertDialog jdField_a_of_type_AndroidAppAlertDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[19];
    jdField_a_of_type_Boolean = false;
  }
  
  private String a(DecimalFormat paramDecimalFormat, long paramLong)
  {
    float f1;
    if (paramLong > 1048576L)
    {
      f1 = (float)paramLong / 1024.0F / 1024.0F;
      return paramDecimalFormat.format(f1) + "M";
    }
    if (paramLong > 1024L)
    {
      f1 = (float)paramLong / 1024.0F;
      return paramDecimalFormat.format(f1) + "K";
    }
    return paramLong + "B";
  }
  
  private String a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    String str1 = "";
    String str2 = str1;
    if (paramArrayOfStackTraceElement != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= paramArrayOfStackTraceElement.length) {
          break;
        }
        str2 = paramArrayOfStackTraceElement[i1].getMethodName() + "(" + paramArrayOfStackTraceElement[i1].getFileName() + " line:" + paramArrayOfStackTraceElement[i1].getLineNumber() + ")  <--";
        str1 = str1 + str2;
        i1 += 1;
      }
    }
    return str2;
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return;
    }
    paramString1 = Uri.parse(paramString1.toURI().toString());
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramString1, paramString2);
    startActivity(localIntent);
  }
  
  private void e()
  {
    jdField_a_of_type_ArrayOfJavaLangString[0] = "查看内存信息";
    jdField_a_of_type_ArrayOfJavaLangString[1] = "导出进程内存";
    jdField_a_of_type_ArrayOfJavaLangString[2] = "监控内存[OFF]";
    jdField_a_of_type_ArrayOfJavaLangString[3] = "当前运行线程";
    jdField_a_of_type_ArrayOfJavaLangString[4] = "所有线程";
    jdField_a_of_type_ArrayOfJavaLangString[5] = "StrictMode[OFF]";
    jdField_a_of_type_ArrayOfJavaLangString[6] = "写日志文件[ON]";
    jdField_a_of_type_ArrayOfJavaLangString[7] = "C2C删除消息可用";
    jdField_a_of_type_ArrayOfJavaLangString[8] = "打印数据库操作日志[OFF]";
    jdField_a_of_type_ArrayOfJavaLangString[9] = "打开后台线程优先级控制优化[OFF]";
    jdField_a_of_type_ArrayOfJavaLangString[10] = "正式环境";
    jdField_a_of_type_ArrayOfJavaLangString[11] = "查看图片预下载信息";
    jdField_a_of_type_ArrayOfJavaLangString[12] = "试用轻启动逻辑";
    Object localObject = jdField_a_of_type_ArrayOfJavaLangString;
    if (DownloaderFactory.jdField_a_of_type_Boolean)
    {
      str = "imgcache ip直连[ON]";
      localObject[15] = str;
      jdField_a_of_type_ArrayOfJavaLangString[17] = "快速切换帐号";
      if (!new File(AppConstants.al + "/Tencent/com/tencent/mobileqq/testserver").exists()) {
        break label409;
      }
      jdField_a_of_type_ArrayOfJavaLangString[10] = "测试环境";
      label166:
      localObject = BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0);
      DebugMemoryMgr.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("monitoringMemory", true);
      if (!DebugMemoryMgr.jdField_a_of_type_Boolean) {
        break label420;
      }
      jdField_a_of_type_ArrayOfJavaLangString[2] = "监控内存[ON]";
      label204:
      if (!jdField_a_of_type_Boolean) {
        break label430;
      }
      jdField_a_of_type_ArrayOfJavaLangString[5] = "StrictMode[ON]";
      label218:
      if (!((SharedPreferences)localObject).getBoolean("writeLogFile", true)) {
        break label440;
      }
      jdField_a_of_type_ArrayOfJavaLangString[6] = "写日志文件[ON]";
      label239:
      SQLiteDatabase.a();
      if (!SQLiteDatabase.jdField_a_of_type_Boolean) {
        break label452;
      }
      jdField_a_of_type_ArrayOfJavaLangString[8] = "打印数据库操作日志[ON]";
      label257:
      if (!AppSetting.n) {
        break label463;
      }
      jdField_a_of_type_ArrayOfJavaLangString[9] = "后台线程优先级控制优化[ON]";
      label272:
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      if (!AppSetting.m) {
        break label475;
      }
      str = "C2C删除消息可用";
      label285:
      arrayOfString[7] = str;
      AppSetting.j = ((SharedPreferences)localObject).getBoolean("releaseLargeMemory", false);
      if (!AppSetting.j) {
        break label482;
      }
      jdField_a_of_type_ArrayOfJavaLangString[13] = "大内存及时释放[ON]";
      label318:
      this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("isActionLoginBTraceView", false);
      arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label494;
      }
      str = "旗鱼TraceView[ON]";
      label347:
      arrayOfString[14] = str;
      this.jdField_c_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("isOpenAIOTraceView", false);
      localObject = jdField_a_of_type_ArrayOfJavaLangString;
      if (!this.jdField_c_of_type_Boolean) {
        break label501;
      }
    }
    label409:
    label420:
    label430:
    label440:
    label452:
    label463:
    label475:
    label482:
    label494:
    label501:
    for (String str = "AIOTraceView[ON]";; str = "AIOTraceView[OFF]")
    {
      localObject[16] = str;
      if (QQSettingMe.a != 0) {
        break label508;
      }
      jdField_a_of_type_ArrayOfJavaLangString[18] = "抽屉返回模式--返回抽屉";
      return;
      str = "imgcache ip直连[OFF]";
      break;
      jdField_a_of_type_ArrayOfJavaLangString[10] = "正式环境";
      break label166;
      jdField_a_of_type_ArrayOfJavaLangString[2] = "监控内存[OFF]";
      break label204;
      jdField_a_of_type_ArrayOfJavaLangString[5] = "StrictMode[OFF]";
      break label218;
      jdField_a_of_type_ArrayOfJavaLangString[6] = "写日志文件[OFF]";
      break label239;
      jdField_a_of_type_ArrayOfJavaLangString[8] = "打印数据库操作日志[OFF]";
      break label257;
      jdField_a_of_type_ArrayOfJavaLangString[9] = "后台线程优先级控制优化[OFF]";
      break label272;
      str = "C2C删除消息不可用";
      break label285;
      jdField_a_of_type_ArrayOfJavaLangString[13] = "大内存及时释放[OFF]";
      break label318;
      str = "旗鱼TraceView[OFF]";
      break label347;
    }
    label508:
    jdField_a_of_type_ArrayOfJavaLangString[18] = "抽屉返回模式--返回tab界面";
  }
  
  private void f()
  {
    System.gc();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new fnn(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void g()
  {
    try
    {
      ReportLog.a(this, "mobileqq");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 73	java/io/File
    //   6: dup
    //   7: getstatic 96	com/tencent/mobileqq/debug/DebugActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 178	java/io/File:exists	()Z
    //   18: ifne +54 -> 72
    //   21: aload_3
    //   22: invokevirtual 368	java/io/File:createNewFile	()Z
    //   25: pop
    //   26: new 370	java/io/BufferedWriter
    //   29: dup
    //   30: new 372	java/io/FileWriter
    //   33: dup
    //   34: getstatic 96	com/tencent/mobileqq/debug/DebugActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokespecial 373	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   40: invokespecial 376	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   43: astore_3
    //   44: aload_3
    //   45: ldc_w 378
    //   48: invokevirtual 381	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   51: invokestatic 386	java/lang/Thread:activeCount	()I
    //   54: istore_2
    //   55: iload_2
    //   56: ifne +39 -> 95
    //   59: aload_3
    //   60: invokevirtual 389	java/io/BufferedWriter:close	()V
    //   63: aload_3
    //   64: ifnull +7 -> 71
    //   67: aload_3
    //   68: invokevirtual 389	java/io/BufferedWriter:close	()V
    //   71: return
    //   72: aload_3
    //   73: invokevirtual 392	java/io/File:delete	()Z
    //   76: pop
    //   77: goto -51 -> 26
    //   80: astore_3
    //   81: aload 4
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull -14 -> 71
    //   88: aload_3
    //   89: invokevirtual 389	java/io/BufferedWriter:close	()V
    //   92: return
    //   93: astore_3
    //   94: return
    //   95: iload_2
    //   96: anewarray 383	java/lang/Thread
    //   99: astore 4
    //   101: aload 4
    //   103: invokestatic 396	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   106: pop
    //   107: iconst_0
    //   108: istore_1
    //   109: goto +161 -> 270
    //   112: aload 5
    //   114: invokevirtual 399	java/lang/Thread:isAlive	()Z
    //   117: ifeq +169 -> 286
    //   120: aload_3
    //   121: new 62	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 401
    //   131: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 5
    //   136: invokevirtual 404	java/lang/Thread:getName	()Ljava/lang/String;
    //   139: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 406
    //   145: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 381	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   154: aload_3
    //   155: new 62	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 408
    //   165: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: aload 5
    //   171: invokevirtual 412	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   174: invokespecial 414	com/tencent/mobileqq/debug/DebugActivity:a	([Ljava/lang/StackTraceElement;)Ljava/lang/String;
    //   177: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 416
    //   183: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokevirtual 381	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   192: goto +94 -> 286
    //   195: astore 4
    //   197: goto -113 -> 84
    //   200: aload_3
    //   201: ldc_w 418
    //   204: invokevirtual 381	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   207: aload_3
    //   208: invokevirtual 421	java/io/BufferedWriter:flush	()V
    //   211: aload_3
    //   212: invokevirtual 389	java/io/BufferedWriter:close	()V
    //   215: aload_3
    //   216: ifnull -145 -> 71
    //   219: aload_3
    //   220: invokevirtual 389	java/io/BufferedWriter:close	()V
    //   223: return
    //   224: astore_3
    //   225: return
    //   226: astore 4
    //   228: aload 4
    //   230: invokevirtual 422	java/io/IOException:printStackTrace	()V
    //   233: goto -26 -> 207
    //   236: astore 5
    //   238: aload_3
    //   239: astore 4
    //   241: aload 5
    //   243: astore_3
    //   244: aload 4
    //   246: ifnull +8 -> 254
    //   249: aload 4
    //   251: invokevirtual 389	java/io/BufferedWriter:close	()V
    //   254: aload_3
    //   255: athrow
    //   256: astore_3
    //   257: return
    //   258: astore 4
    //   260: goto -6 -> 254
    //   263: astore_3
    //   264: aconst_null
    //   265: astore 4
    //   267: goto -23 -> 244
    //   270: iload_1
    //   271: iload_2
    //   272: if_icmpge -72 -> 200
    //   275: aload 4
    //   277: iload_1
    //   278: aaload
    //   279: astore 5
    //   281: aload 5
    //   283: ifnonnull -171 -> 112
    //   286: iload_1
    //   287: iconst_1
    //   288: iadd
    //   289: istore_1
    //   290: goto -20 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	DebugActivity
    //   108	182	1	i1	int
    //   54	219	2	i2	int
    //   13	60	3	localObject1	Object
    //   80	1	3	localException1	Exception
    //   83	6	3	arrayOfThread1	java.lang.Thread[]
    //   93	127	3	localException2	Exception
    //   224	15	3	localException3	Exception
    //   243	12	3	localObject2	Object
    //   256	1	3	localException4	Exception
    //   263	1	3	localObject3	Object
    //   1	101	4	arrayOfThread2	java.lang.Thread[]
    //   195	1	4	localException5	Exception
    //   226	3	4	localIOException	IOException
    //   239	11	4	localObject4	Object
    //   258	1	4	localException6	Exception
    //   265	11	4	localObject5	Object
    //   112	58	5	localObject6	Object
    //   236	6	5	localObject7	Object
    //   279	3	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   3	26	80	java/lang/Exception
    //   26	44	80	java/lang/Exception
    //   72	77	80	java/lang/Exception
    //   88	92	93	java/lang/Exception
    //   44	55	195	java/lang/Exception
    //   59	63	195	java/lang/Exception
    //   95	107	195	java/lang/Exception
    //   112	192	195	java/lang/Exception
    //   200	207	195	java/lang/Exception
    //   207	215	195	java/lang/Exception
    //   228	233	195	java/lang/Exception
    //   219	223	224	java/lang/Exception
    //   200	207	226	java/io/IOException
    //   44	55	236	finally
    //   59	63	236	finally
    //   95	107	236	finally
    //   112	192	236	finally
    //   200	207	236	finally
    //   207	215	236	finally
    //   228	233	236	finally
    //   67	71	256	java/lang/Exception
    //   249	254	258	java/lang/Exception
    //   3	26	263	finally
    //   26	44	263	finally
    //   72	77	263	finally
  }
  
  public void a()
  {
    Object localObject1 = getAppRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject2 = ((QQAppInterface)localObject1).a().a.a();
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          String str1 = (String)((HashMap)localObject2).get(str2);
          str2 = PicPreDownloadUtils.a(str2);
          ((ArrayList)localObject1).add(str2 + ":" + str1);
        }
      }
      ((ArrayList)localObject1).addAll(CircleCounter.a());
      if (this.jdField_a_of_type_AndroidAppAlertDialog$Builder == null) {
        this.jdField_a_of_type_AndroidAppAlertDialog$Builder = new AlertDialog.Builder(this);
      }
      if (this.jdField_a_of_type_AndroidAppAlertDialog != null) {
        this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
      }
      localObject2 = (String[])((ArrayList)localObject1).toArray(new String[0]);
      Arrays.sort((Object[])localObject2, 0, ((ArrayList)localObject1).size());
      this.jdField_a_of_type_AndroidAppAlertDialog = this.jdField_a_of_type_AndroidAppAlertDialog$Builder.setTitle("图片预下载信息").setItems((CharSequence[])localObject2, new fno(this, null)).create();
      this.jdField_a_of_type_AndroidAppAlertDialog.show();
    }
  }
  
  public void b()
  {
    try
    {
      h();
      a(jdField_c_of_type_JavaLangString, "text/html");
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void c()
  {
    int i1 = Build.VERSION.SDK_INT;
    if (i1 >= 11)
    {
      jdField_a_of_type_AndroidOsStrictMode$ThreadPolicy = StrictMode.getThreadPolicy();
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().detectDiskReads().detectDiskWrites().detectCustomSlowCalls().penaltyLog().build());
      jdField_a_of_type_AndroidOsStrictMode$VmPolicy = StrictMode.getVmPolicy();
      if (i1 >= 16) {
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectActivityLeaks().detectLeakedRegistrationObjects().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().build());
      }
      for (;;)
      {
        jdField_a_of_type_ArrayOfJavaLangString[5] = "StrictMode[ON]";
        jdField_a_of_type_Boolean = true;
        return;
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectActivityLeaks().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().build());
      }
    }
    Toast.makeText(this, "Failed:SDK Vertion too old", 0).show();
  }
  
  @SuppressLint({"NewApi"})
  public void d()
  {
    StrictMode.setThreadPolicy(jdField_a_of_type_AndroidOsStrictMode$ThreadPolicy);
    StrictMode.setVmPolicy(jdField_a_of_type_AndroidOsStrictMode$VmPolicy);
    jdField_a_of_type_ArrayOfJavaLangString[5] = "StrictMode[OFF]";
    jdField_a_of_type_Boolean = false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    e();
    setTitle("DEBUG");
    this.jdField_a_of_type_AndroidWidgetListView = new ListView(this);
    setContentView(this.jdField_a_of_type_AndroidWidgetListView);
    paramBundle = new ArrayAdapter(this, 17367043, 16908308, jdField_a_of_type_ArrayOfJavaLangString);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(paramBundle);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new fnl(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.debug.DebugActivity
 * JD-Core Version:    0.7.0.1
 */