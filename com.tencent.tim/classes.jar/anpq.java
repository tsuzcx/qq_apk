import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MainService;

public class anpq
  implements Handler.Callback
{
  private static anpq jdField_a_of_type_Anpq;
  private static final String bvQ = aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.tim".replace(".", File.separator) + File.separator);
  private static final String cgj = bvQ + File.separator + "bg_cpu_" + "temp.trace";
  private static final String cgk = bvQ + File.separator + "bg_cpu_" + "baseInfo.txt";
  anpq.a jdField_a_of_type_Anpq$a = new anpq.a();
  private long anF;
  private long anG;
  private long anH;
  private long anI;
  private long anJ;
  private long anK;
  private long anL;
  private boolean cJn;
  private int dLr;
  private int dLs = 10;
  private int dLt = 15;
  private boolean hasCleanLog;
  private boolean isBackground;
  private boolean isEnable;
  private SharedPreferences mPref;
  private Handler subHandler;
  
  private static String Ao()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(bvQ).append("bg_cpu_").append(System.currentTimeMillis()).append(".trace.zip");
    return localStringBuilder.toString();
  }
  
  public static anpq a()
  {
    if (jdField_a_of_type_Anpq == null) {}
    try
    {
      if (jdField_a_of_type_Anpq == null) {
        jdField_a_of_type_Anpq = new anpq();
      }
      return jdField_a_of_type_Anpq;
    }
    finally {}
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, Map<String, Long> paramMap)
  {
    Object[] arrayOfObject = acix.collectProcessStats("-2");
    long l2 = -1L;
    long l1 = -1L;
    long l3 = -1L;
    if (arrayOfObject != null)
    {
      l2 = ((Long)arrayOfObject[1]).longValue() + ((Long)arrayOfObject[2]).longValue();
      l1 = ((Long)arrayOfObject[1]).longValue();
    }
    long l4 = acix.collectCpuUsage("-1");
    if (BaseApplicationImpl.sProcessId != 4) {
      l3 = acix.collectCpuUsage(String.valueOf(MainService.sNativeTidOfReceiver));
    }
    long l5 = MainService.sReceiverCpuTime;
    long l6 = acyc.RA;
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "cpuInfo: ", Long.valueOf(l2), ", ", Long.valueOf(l1), ", ", Long.valueOf(l4), ", ", Long.valueOf(l3), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", Long.valueOf(l5), ", ", Long.valueOf(l6) });
    if ((l2 <= 0L) || (l1 <= 0L) || (l4 <= 0L) || ((BaseApplicationImpl.sProcessId != 4) && (l3 <= 0L)))
    {
      QLog.e("BatteryStats.BgCpu", 2, "bad cpu value");
      return false;
    }
    int i;
    int k;
    if (paramBoolean2)
    {
      i = -1;
      long l7 = l2 - this.anF;
      if ((l7 <= 0L) || (l1 <= this.anG) || (l4 <= this.anH))
      {
        paramMap = new StringBuilder(256);
        paramMap.append("bad cpu value2.").append(l2).append(",").append(this.anF).append(",").append(l1).append(",").append(this.anG).append(",").append(l4).append(",").append(this.anH);
        QLog.d("BatteryStats.BgCpu", 1, paramMap.toString());
        return false;
      }
      long l8 = l4 - this.anH;
      k = (int)(100L * l8 / l7);
      if (paramMap != null)
      {
        paramMap.put("elapse", Long.valueOf(l7));
        paramMap.put("qqConsume", Long.valueOf(l8));
        paramMap.put("qqRatio", Long.valueOf(k));
      }
      if (BaseApplicationImpl.sProcessId == 4) {
        break label706;
      }
      if (l3 < this.anI)
      {
        QLog.e("BatteryStats.BgCpu", 1, new Object[] { "bad msf-receiver cpu.", Long.valueOf(l3), ", ", Long.valueOf(this.anI) });
        return false;
      }
      l8 = l3 - this.anI;
      int j = (int)(100L * l8 / l7);
      i = j;
      if (paramMap != null)
      {
        paramMap.put("msfConsume", Long.valueOf(l8));
        paramMap.put("msfRatio", Long.valueOf(j));
        i = j;
      }
    }
    for (;;)
    {
      paramMap.put("msfTime", Long.valueOf(l5 - this.anJ));
      paramMap.put("ftsTime", Long.valueOf(l6 - this.anK));
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "qqCpuRatio = ", Integer.valueOf(k), ", msf-receiver cpuRatio = ", Integer.valueOf(i), ", remainRptCount = ", Integer.valueOf(this.dLr) });
      if (paramBoolean1)
      {
        this.anF = l2;
        this.anG = l1;
        this.anH = l4;
        this.anI = l3;
        this.anJ = l5;
        this.anK = l6;
      }
      return true;
      label706:
      paramMap.put("msfConsume", Long.valueOf(0L));
      paramMap.put("msfRatio", Long.valueOf(0L));
    }
  }
  
  public static String aR(long paramLong)
  {
    String str1 = aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = aqmu.getFormatTime(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(BaseApplicationImpl.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
  }
  
  private static void dSV()
  {
    Object localObject1 = new File(bvQ);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        int i = 0;
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("bg_cpu_"))) {}
          for (int j = 1;; j = 0)
          {
            if ((j != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
              localObject2.delete();
            }
            i += 1;
            break;
          }
        }
      }
    }
  }
  
  void Ri(String paramString)
  {
    if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 4)) {
      break label14;
    }
    label14:
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    QLog.d("BatteryStats.BgCpu", 2, "config = " + paramString);
    for (;;)
    {
      try
      {
        if (this.mPref == null) {
          this.mPref = BaseApplicationImpl.getApplication().getSharedPreferences("bgCpu", 4);
        }
        long l = this.mPref.getLong("rand_time", 0L);
        bool1 = this.mPref.getBoolean("rand_rs", false);
        paramString = paramString.split(";");
        if (Math.abs(System.currentTimeMillis() - l) > 86400000L)
        {
          float f2 = Float.valueOf(paramString[1]).floatValue();
          float f1 = f2;
          if (QLog.isColorLevel())
          {
            f1 = f2;
            if (paramString.length >= 9) {
              f1 = f2 * Integer.valueOf(paramString[8]).intValue();
            }
          }
          if (Math.random() >= f1) {
            break label438;
          }
          bool1 = true;
          this.mPref.edit().putLong("rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("times", 0).commit();
        }
        boolean bool2 = bool1;
        if (bool1)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            break label444;
          }
          i = 1;
          break label462;
          this.dLs = Integer.valueOf(paramString[j]).intValue();
          if (i == 0) {
            break label456;
          }
          i = 3;
          label267:
          this.dLt = Integer.valueOf(paramString[i]).intValue();
          this.dLr = (Integer.valueOf(paramString[6]).intValue() - this.mPref.getInt("times", 0));
          if (this.dLr <= 0) {
            bool1 = false;
          }
          this.cJn = "1".equals(paramString[7]);
          bool2 = bool1;
        }
        this.isEnable = bool2;
        if ((this.isEnable) && (BaseApplicationImpl.sProcessId == 4) && (this.subHandler == null)) {
          this.subHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
        }
        if (paramString.length < 10) {
          break label14;
        }
        this.mPref.edit().putBoolean("enable_nor_sensor", "1".equals(paramString[9])).commit();
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BatteryStats.BgCpu", 2, "", paramString);
      return;
      label438:
      boolean bool1 = false;
      continue;
      label444:
      int i = 0;
      label456:
      label462:
      while (i == 0)
      {
        j = 4;
        break;
        i = 5;
        break label267;
      }
      int j = 2;
    }
  }
  
  public boolean ayH()
  {
    if (this.mPref == null) {
      this.mPref = BaseApplicationImpl.getApplication().getSharedPreferences("bgCpu", 4);
    }
    return this.mPref.getBoolean("enable_nor_sensor", true);
  }
  
  /* Error */
  @android.annotation.TargetApi(21)
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 474	android/os/Message:what	I
    //   4: bipush 10
    //   6: if_icmpne +25 -> 31
    //   9: aload_0
    //   10: getfield 104	anpq:jdField_a_of_type_Anpq$a	Lanpq$a;
    //   13: invokevirtual 477	anpq$a:dSW	()V
    //   16: aload_0
    //   17: getfield 443	anpq:subHandler	Landroid/os/Handler;
    //   20: bipush 10
    //   22: ldc2_w 478
    //   25: invokevirtual 483	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   28: pop
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_1
    //   32: getfield 474	android/os/Message:what	I
    //   35: bipush 11
    //   37: if_icmpne +13 -> 50
    //   40: aload_0
    //   41: getfield 104	anpq:jdField_a_of_type_Anpq$a	Lanpq$a;
    //   44: invokevirtual 486	anpq$a:dSX	()V
    //   47: goto -18 -> 29
    //   50: aload_1
    //   51: getfield 474	android/os/Message:what	I
    //   54: iconst_2
    //   55: if_icmpne +10 -> 65
    //   58: aload_0
    //   59: invokevirtual 489	anpq:onAppBackground	()V
    //   62: goto -33 -> 29
    //   65: aload_1
    //   66: getfield 474	android/os/Message:what	I
    //   69: ifne +623 -> 692
    //   72: new 491	java/util/HashMap
    //   75: dup
    //   76: iconst_5
    //   77: invokespecial 492	java/util/HashMap:<init>	(I)V
    //   80: astore 17
    //   82: aload_0
    //   83: iconst_1
    //   84: iconst_1
    //   85: aload 17
    //   87: invokespecial 494	anpq:a	(ZZLjava/util/Map;)Z
    //   90: ifeq -61 -> 29
    //   93: aload 17
    //   95: ldc 223
    //   97: invokevirtual 497	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   100: ifeq -71 -> 29
    //   103: aload 17
    //   105: ldc 233
    //   107: invokevirtual 497	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   110: ifeq -81 -> 29
    //   113: aload 17
    //   115: ldc 223
    //   117: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 133	java/lang/Long
    //   123: invokevirtual 136	java/lang/Long:longValue	()J
    //   126: lstore 4
    //   128: aload 17
    //   130: ldc 233
    //   132: invokevirtual 497	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   135: ifeq +552 -> 687
    //   138: aload 17
    //   140: ldc 233
    //   142: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 133	java/lang/Long
    //   148: invokevirtual 136	java/lang/Long:longValue	()J
    //   151: lstore_2
    //   152: ldc 166
    //   154: iconst_1
    //   155: bipush 6
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: ldc_w 503
    //   165: aastore
    //   166: dup
    //   167: iconst_1
    //   168: lload 4
    //   170: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   173: aastore
    //   174: dup
    //   175: iconst_2
    //   176: ldc 207
    //   178: aastore
    //   179: dup
    //   180: iconst_3
    //   181: lload_2
    //   182: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: dup
    //   187: iconst_4
    //   188: ldc 173
    //   190: aastore
    //   191: dup
    //   192: iconst_5
    //   193: iconst_0
    //   194: invokestatic 508	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   197: aastore
    //   198: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   201: lload 4
    //   203: lload_2
    //   204: lsub
    //   205: aload_0
    //   206: getfield 99	anpq:dLs	I
    //   209: i2l
    //   210: lcmp
    //   211: ifgt +13 -> 224
    //   214: lload_2
    //   215: aload_0
    //   216: getfield 101	anpq:dLt	I
    //   219: i2l
    //   220: lcmp
    //   221: ifle -192 -> 29
    //   224: new 491	java/util/HashMap
    //   227: dup
    //   228: iconst_2
    //   229: invokespecial 492	java/util/HashMap:<init>	(I)V
    //   232: astore_1
    //   233: aload_1
    //   234: new 40	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   241: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   244: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 513
    //   250: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: new 40	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   263: aload 17
    //   265: ldc 223
    //   267: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   270: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   273: ldc_w 458
    //   276: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: pop
    //   286: aload_1
    //   287: new 40	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   294: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   297: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 519
    //   303: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: new 40	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   316: aload 17
    //   318: ldc 233
    //   320: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   323: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   326: ldc_w 458
    //   329: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: pop
    //   339: aload_1
    //   340: new 40	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   347: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   350: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: ldc_w 521
    //   356: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: new 40	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   369: aload 17
    //   371: ldc 213
    //   373: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   376: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   379: ldc_w 458
    //   382: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_1
    //   393: new 40	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   400: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   403: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc_w 523
    //   409: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: new 40	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   422: aload 17
    //   424: ldc 221
    //   426: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   429: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: ldc_w 458
    //   435: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   444: pop
    //   445: aload_1
    //   446: new 40	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   453: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   456: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: ldc_w 525
    //   462: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: new 40	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   475: aload 17
    //   477: ldc 231
    //   479: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   482: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   485: ldc_w 458
    //   488: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   497: pop
    //   498: aload_1
    //   499: ldc_w 527
    //   502: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   505: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   508: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   511: pop
    //   512: aload_1
    //   513: ldc_w 529
    //   516: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   519: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   522: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   525: pop
    //   526: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   529: invokestatic 534	anpc:a	(Landroid/content/Context;)Lanpc;
    //   532: aconst_null
    //   533: ldc_w 536
    //   536: iconst_1
    //   537: lconst_0
    //   538: lconst_0
    //   539: aload_1
    //   540: aconst_null
    //   541: invokevirtual 540	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   544: new 51	java/io/File
    //   547: dup
    //   548: getstatic 91	anpq:cgj	Ljava/lang/String;
    //   551: invokespecial 301	java/io/File:<init>	(Ljava/lang/String;)V
    //   554: astore 17
    //   556: aload 17
    //   558: invokevirtual 543	java/io/File:getParentFile	()Ljava/io/File;
    //   561: ifnull +23 -> 584
    //   564: aload 17
    //   566: invokevirtual 543	java/io/File:getParentFile	()Ljava/io/File;
    //   569: invokevirtual 305	java/io/File:exists	()Z
    //   572: ifeq +12 -> 584
    //   575: aload 17
    //   577: invokevirtual 543	java/io/File:getParentFile	()Ljava/io/File;
    //   580: invokevirtual 546	java/io/File:mkdirs	()Z
    //   583: pop
    //   584: aload 17
    //   586: invokevirtual 305	java/io/File:exists	()Z
    //   589: ifeq +9 -> 598
    //   592: aload 17
    //   594: invokevirtual 339	java/io/File:delete	()Z
    //   597: pop
    //   598: aload_0
    //   599: getfield 439	anpq:cJn	Z
    //   602: ifeq +7 -> 609
    //   605: iconst_2
    //   606: invokestatic 549	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   609: getstatic 91	anpq:cgj	Ljava/lang/String;
    //   612: ldc_w 550
    //   615: sipush 1000
    //   618: invokestatic 556	android/os/Debug:startMethodTracingSampling	(Ljava/lang/String;II)V
    //   621: aload_0
    //   622: invokestatic 561	android/os/SystemClock:uptimeMillis	()J
    //   625: putfield 563	anpq:anL	J
    //   628: aload_0
    //   629: getfield 443	anpq:subHandler	Landroid/os/Handler;
    //   632: aload_0
    //   633: getfield 443	anpq:subHandler	Landroid/os/Handler;
    //   636: iconst_1
    //   637: aload_1
    //   638: invokestatic 567	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   641: ldc2_w 478
    //   644: invokevirtual 571	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   647: pop
    //   648: goto -619 -> 29
    //   651: astore_1
    //   652: aload_0
    //   653: iconst_0
    //   654: putfield 441	anpq:isEnable	Z
    //   657: ldc 166
    //   659: iconst_1
    //   660: ldc_w 573
    //   663: aload_1
    //   664: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   667: invokestatic 578	android/os/Debug:stopMethodTracing	()V
    //   670: goto -641 -> 29
    //   673: astore_1
    //   674: ldc 166
    //   676: iconst_1
    //   677: ldc_w 458
    //   680: aload_1
    //   681: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   684: goto -655 -> 29
    //   687: lconst_0
    //   688: lstore_2
    //   689: goto -537 -> 152
    //   692: aload_1
    //   693: getfield 474	android/os/Message:what	I
    //   696: iconst_3
    //   697: if_icmpne +13 -> 710
    //   700: aload_1
    //   701: getfield 581	android/os/Message:arg1	I
    //   704: invokestatic 549	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   707: goto -678 -> 29
    //   710: aload_1
    //   711: getfield 474	android/os/Message:what	I
    //   714: iconst_1
    //   715: if_icmpne -686 -> 29
    //   718: invokestatic 578	android/os/Debug:stopMethodTracing	()V
    //   721: aload_0
    //   722: lconst_0
    //   723: putfield 563	anpq:anL	J
    //   726: new 491	java/util/HashMap
    //   729: dup
    //   730: iconst_5
    //   731: invokespecial 492	java/util/HashMap:<init>	(I)V
    //   734: astore 17
    //   736: aload_0
    //   737: iconst_1
    //   738: iconst_1
    //   739: aload 17
    //   741: invokespecial 494	anpq:a	(ZZLjava/util/Map;)Z
    //   744: ifeq -715 -> 29
    //   747: aload 17
    //   749: ldc 223
    //   751: invokevirtual 497	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   754: ifeq -725 -> 29
    //   757: aload 17
    //   759: ldc 233
    //   761: invokevirtual 497	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   764: ifeq -735 -> 29
    //   767: aload 17
    //   769: ldc 223
    //   771: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   774: checkcast 133	java/lang/Long
    //   777: invokevirtual 136	java/lang/Long:longValue	()J
    //   780: lstore 8
    //   782: aload 17
    //   784: ldc 233
    //   786: invokevirtual 497	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   789: ifeq +1460 -> 2249
    //   792: aload 17
    //   794: ldc 233
    //   796: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   799: checkcast 133	java/lang/Long
    //   802: invokevirtual 136	java/lang/Long:longValue	()J
    //   805: lstore_2
    //   806: ldc 166
    //   808: iconst_1
    //   809: bipush 6
    //   811: anewarray 4	java/lang/Object
    //   814: dup
    //   815: iconst_0
    //   816: ldc_w 583
    //   819: aastore
    //   820: dup
    //   821: iconst_1
    //   822: lload 8
    //   824: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   827: aastore
    //   828: dup
    //   829: iconst_2
    //   830: ldc 207
    //   832: aastore
    //   833: dup
    //   834: iconst_3
    //   835: lload_2
    //   836: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   839: aastore
    //   840: dup
    //   841: iconst_4
    //   842: ldc 207
    //   844: aastore
    //   845: dup
    //   846: iconst_5
    //   847: iconst_0
    //   848: invokestatic 508	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   851: aastore
    //   852: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   855: lload 8
    //   857: lload_2
    //   858: lsub
    //   859: aload_0
    //   860: getfield 99	anpq:dLs	I
    //   863: i2l
    //   864: lcmp
    //   865: ifgt +13 -> 878
    //   868: lload_2
    //   869: aload_0
    //   870: getfield 101	anpq:dLt	I
    //   873: i2l
    //   874: lcmp
    //   875: ifle +1471 -> 2346
    //   878: aload 17
    //   880: ldc 213
    //   882: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   885: checkcast 133	java/lang/Long
    //   888: invokevirtual 136	java/lang/Long:longValue	()J
    //   891: lstore 10
    //   893: aload 17
    //   895: ldc 221
    //   897: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   900: checkcast 133	java/lang/Long
    //   903: invokevirtual 136	java/lang/Long:longValue	()J
    //   906: lstore 12
    //   908: aload 17
    //   910: ldc 231
    //   912: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   915: checkcast 133	java/lang/Long
    //   918: invokevirtual 136	java/lang/Long:longValue	()J
    //   921: lstore 14
    //   923: new 51	java/io/File
    //   926: dup
    //   927: getstatic 91	anpq:cgj	Ljava/lang/String;
    //   930: invokespecial 301	java/io/File:<init>	(Ljava/lang/String;)V
    //   933: astore_1
    //   934: new 585	java/util/ArrayList
    //   937: dup
    //   938: iconst_4
    //   939: invokespecial 586	java/util/ArrayList:<init>	(I)V
    //   942: astore 22
    //   944: aload 22
    //   946: aload_1
    //   947: invokevirtual 589	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   950: invokeinterface 594 2 0
    //   955: pop
    //   956: new 51	java/io/File
    //   959: dup
    //   960: getstatic 95	anpq:cgk	Ljava/lang/String;
    //   963: invokespecial 301	java/io/File:<init>	(Ljava/lang/String;)V
    //   966: astore 18
    //   968: aload 18
    //   970: invokevirtual 305	java/io/File:exists	()Z
    //   973: ifeq +9 -> 982
    //   976: aload 18
    //   978: invokevirtual 339	java/io/File:delete	()Z
    //   981: pop
    //   982: aload 22
    //   984: aload 18
    //   986: invokevirtual 589	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   989: invokeinterface 594 2 0
    //   994: pop
    //   995: aconst_null
    //   996: astore_1
    //   997: new 596	java/io/BufferedOutputStream
    //   1000: dup
    //   1001: new 598	java/io/FileOutputStream
    //   1004: dup
    //   1005: aload 18
    //   1007: invokespecial 601	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1010: invokespecial 604	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1013: astore 19
    //   1015: aload 19
    //   1017: ldc_w 606
    //   1020: invokevirtual 610	java/lang/String:getBytes	()[B
    //   1023: invokevirtual 614	java/io/BufferedOutputStream:write	([B)V
    //   1026: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1029: iconst_1
    //   1030: if_icmpne +1224 -> 2254
    //   1033: ldc_w 616
    //   1036: astore_1
    //   1037: aload 19
    //   1039: aload_1
    //   1040: invokevirtual 610	java/lang/String:getBytes	()[B
    //   1043: invokevirtual 614	java/io/BufferedOutputStream:write	([B)V
    //   1046: new 40	java/lang/StringBuilder
    //   1049: dup
    //   1050: sipush 200
    //   1053: invokespecial 203	java/lang/StringBuilder:<init>	(I)V
    //   1056: astore 23
    //   1058: aload 23
    //   1060: ldc_w 618
    //   1063: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   1069: ldc2_w 619
    //   1072: lsub
    //   1073: ldc_w 622
    //   1076: invokestatic 285	aqmu:getFormatTime	(JLjava/lang/String;)Ljava/lang/String;
    //   1079: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: ldc_w 624
    //   1085: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   1091: ldc_w 622
    //   1094: invokestatic 285	aqmu:getFormatTime	(JLjava/lang/String;)Ljava/lang/String;
    //   1097: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: ldc_w 626
    //   1103: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: ldc_w 628
    //   1109: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: lload 8
    //   1114: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1117: ldc_w 630
    //   1120: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: lload_2
    //   1124: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1127: ldc_w 632
    //   1130: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: lload 10
    //   1135: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1138: ldc_w 634
    //   1141: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: lload 12
    //   1146: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1149: ldc_w 636
    //   1152: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: lload 14
    //   1157: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1160: ldc_w 638
    //   1163: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: aload 17
    //   1168: ldc 235
    //   1170: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1173: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1176: ldc_w 640
    //   1179: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: aload 17
    //   1184: ldc 239
    //   1186: invokevirtual 501	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1189: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1192: ldc_w 626
    //   1195: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1202: aconst_null
    //   1203: invokevirtual 644	com/tencent/common/app/BaseApplicationImpl:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   1206: checkcast 646	com/tencent/mobileqq/app/QQAppInterface
    //   1209: astore 24
    //   1211: aload 24
    //   1213: ifnull +144 -> 1357
    //   1216: aload 23
    //   1218: ldc_w 648
    //   1221: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: aload 24
    //   1226: invokevirtual 651	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   1229: invokevirtual 656	acxu:fc	()J
    //   1232: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1235: ldc_w 626
    //   1238: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: pop
    //   1242: aload 24
    //   1244: invokevirtual 651	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   1247: iconst_2
    //   1248: invokevirtual 659	acxu:a	(I)Lacxy;
    //   1251: checkcast 661	acyd
    //   1254: astore_1
    //   1255: aload 23
    //   1257: ldc_w 663
    //   1260: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload_1
    //   1264: invokevirtual 666	acyd:Bm	()I
    //   1267: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1270: ldc_w 626
    //   1273: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: aload 23
    //   1279: ldc_w 668
    //   1282: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload_1
    //   1286: invokevirtual 671	acyd:Bl	()I
    //   1289: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1292: ldc_w 626
    //   1295: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload 24
    //   1301: invokevirtual 651	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   1304: iconst_1
    //   1305: invokevirtual 659	acxu:a	(I)Lacxy;
    //   1308: checkcast 673	acxz
    //   1311: astore_1
    //   1312: aload 23
    //   1314: ldc_w 675
    //   1317: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: aload_1
    //   1321: iconst_0
    //   1322: invokevirtual 679	acxz:y	(Z)I
    //   1325: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1328: ldc_w 626
    //   1331: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: aload 23
    //   1337: ldc_w 681
    //   1340: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: aload_1
    //   1344: invokevirtual 682	acxz:Bl	()I
    //   1347: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1350: ldc_w 626
    //   1353: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: aload 19
    //   1359: aload 23
    //   1361: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: invokevirtual 610	java/lang/String:getBytes	()[B
    //   1367: invokevirtual 614	java/io/BufferedOutputStream:write	([B)V
    //   1370: aconst_null
    //   1371: astore 21
    //   1373: aconst_null
    //   1374: astore_1
    //   1375: aconst_null
    //   1376: astore 20
    //   1378: lconst_0
    //   1379: lstore 4
    //   1381: aload 20
    //   1383: astore 18
    //   1385: aload 21
    //   1387: astore 17
    //   1389: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1392: invokevirtual 686	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1395: astore 25
    //   1397: iconst_0
    //   1398: ifne +60 -> 1458
    //   1401: aload 20
    //   1403: astore 18
    //   1405: aload 21
    //   1407: astore 17
    //   1409: aload 25
    //   1411: ldc 63
    //   1413: sipush 128
    //   1416: invokevirtual 692	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1419: astore_1
    //   1420: aload 20
    //   1422: astore 18
    //   1424: aload 21
    //   1426: astore 17
    //   1428: new 40	java/lang/StringBuilder
    //   1431: dup
    //   1432: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1435: aload_1
    //   1436: getfield 697	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1439: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: ldc 65
    //   1444: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: aload_1
    //   1448: getfield 700	android/content/pm/PackageInfo:versionCode	I
    //   1451: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1454: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1457: astore_1
    //   1458: aload 20
    //   1460: astore 18
    //   1462: aload_1
    //   1463: astore 17
    //   1465: aload 25
    //   1467: ldc 63
    //   1469: sipush 128
    //   1472: invokevirtual 704	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   1475: getfield 710	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   1478: ldc_w 712
    //   1481: invokevirtual 717	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1484: invokevirtual 718	java/lang/Object:toString	()Ljava/lang/String;
    //   1487: astore 20
    //   1489: aload 20
    //   1491: astore 18
    //   1493: aload_1
    //   1494: astore 17
    //   1496: aload 24
    //   1498: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1501: invokestatic 724	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1504: lstore 6
    //   1506: ldc_w 726
    //   1509: astore 21
    //   1511: aload_1
    //   1512: astore 17
    //   1514: lload 6
    //   1516: lstore 4
    //   1518: aload 20
    //   1520: astore 18
    //   1522: aload 21
    //   1524: astore_1
    //   1525: aload 23
    //   1527: iconst_0
    //   1528: aload 23
    //   1530: invokevirtual 729	java/lang/StringBuilder:length	()I
    //   1533: invokevirtual 732	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1536: pop
    //   1537: aload 23
    //   1539: ldc_w 734
    //   1542: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: lload 4
    //   1547: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1550: ldc_w 736
    //   1553: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: aload 17
    //   1558: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: ldc_w 738
    //   1564: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: aload 18
    //   1569: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: ldc_w 740
    //   1575: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: aload_1
    //   1579: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: ldc_w 742
    //   1585: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   1591: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1594: ldc_w 744
    //   1597: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: invokestatic 393	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1603: invokevirtual 747	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1606: pop
    //   1607: aload 19
    //   1609: aload 23
    //   1611: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1614: invokevirtual 610	java/lang/String:getBytes	()[B
    //   1617: invokevirtual 614	java/io/BufferedOutputStream:write	([B)V
    //   1620: aload 19
    //   1622: invokevirtual 750	java/io/BufferedOutputStream:flush	()V
    //   1625: aload 19
    //   1627: ifnull +8 -> 1635
    //   1630: aload 19
    //   1632: invokevirtual 753	java/io/BufferedOutputStream:close	()V
    //   1635: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   1638: invokestatic 755	anpq:aR	(J)Ljava/lang/String;
    //   1641: astore_1
    //   1642: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   1645: ldc2_w 756
    //   1648: lsub
    //   1649: invokestatic 755	anpq:aR	(J)Ljava/lang/String;
    //   1652: astore 17
    //   1654: aload 22
    //   1656: aload_1
    //   1657: invokeinterface 594 2 0
    //   1662: pop
    //   1663: aload_1
    //   1664: aload 17
    //   1666: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1669: ifne +13 -> 1682
    //   1672: aload 22
    //   1674: aload 17
    //   1676: invokeinterface 594 2 0
    //   1681: pop
    //   1682: invokestatic 759	anpq:Ao	()Ljava/lang/String;
    //   1685: astore 18
    //   1687: iconst_0
    //   1688: istore 16
    //   1690: aload 22
    //   1692: aload 18
    //   1694: invokestatic 765	aqhq:zipFiles	(Ljava/util/List;Ljava/lang/String;)Z
    //   1697: ifeq +165 -> 1862
    //   1700: aload_0
    //   1701: aload_0
    //   1702: getfield 249	anpq:dLr	I
    //   1705: iconst_1
    //   1706: isub
    //   1707: putfield 249	anpq:dLr	I
    //   1710: aload_0
    //   1711: getfield 351	anpq:mPref	Landroid/content/SharedPreferences;
    //   1714: invokeinterface 408 1 0
    //   1719: ldc_w 420
    //   1722: aload_0
    //   1723: getfield 351	anpq:mPref	Landroid/content/SharedPreferences;
    //   1726: ldc_w 420
    //   1729: iconst_0
    //   1730: invokeinterface 431 3 0
    //   1735: iconst_1
    //   1736: iadd
    //   1737: invokeinterface 424 3 0
    //   1742: invokeinterface 427 1 0
    //   1747: pop
    //   1748: new 767	org/json/JSONObject
    //   1751: dup
    //   1752: invokespecial 768	org/json/JSONObject:<init>	()V
    //   1755: astore_1
    //   1756: new 767	org/json/JSONObject
    //   1759: dup
    //   1760: invokespecial 768	org/json/JSONObject:<init>	()V
    //   1763: astore 17
    //   1765: aload 17
    //   1767: ldc_w 770
    //   1770: aload 18
    //   1772: invokevirtual 773	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1775: pop
    //   1776: new 767	org/json/JSONObject
    //   1779: dup
    //   1780: invokespecial 768	org/json/JSONObject:<init>	()V
    //   1783: astore 18
    //   1785: aload 18
    //   1787: ldc_w 775
    //   1790: ldc_w 433
    //   1793: invokevirtual 773	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1796: pop
    //   1797: aload_1
    //   1798: ldc_w 777
    //   1801: aload 17
    //   1803: invokevirtual 773	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1806: pop
    //   1807: aload_1
    //   1808: ldc_w 779
    //   1811: aload 18
    //   1813: invokevirtual 773	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1816: pop
    //   1817: aload_1
    //   1818: ldc_w 781
    //   1821: bipush 126
    //   1823: invokevirtual 784	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1826: pop
    //   1827: new 786	com/tencent/mfsdk/collector/ResultObject
    //   1830: dup
    //   1831: iconst_0
    //   1832: ldc_w 788
    //   1835: iconst_1
    //   1836: lconst_1
    //   1837: lconst_1
    //   1838: aload_1
    //   1839: iconst_1
    //   1840: iconst_1
    //   1841: getstatic 793	com/tencent/mfsdk/MagnifierSDK:uin	J
    //   1844: invokespecial 796	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   1847: invokestatic 802	com/tencent/mfsdk/reporter/ReporterMachine:b	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   1850: ldc 166
    //   1852: iconst_2
    //   1853: ldc_w 804
    //   1856: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1859: iconst_1
    //   1860: istore 16
    //   1862: new 491	java/util/HashMap
    //   1865: dup
    //   1866: iconst_2
    //   1867: invokespecial 492	java/util/HashMap:<init>	(I)V
    //   1870: astore_1
    //   1871: aload_1
    //   1872: new 40	java/lang/StringBuilder
    //   1875: dup
    //   1876: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1879: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1882: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1885: ldc_w 513
    //   1888: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1891: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1894: new 40	java/lang/StringBuilder
    //   1897: dup
    //   1898: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1901: lload 8
    //   1903: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1906: ldc_w 458
    //   1909: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1915: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1918: pop
    //   1919: aload_1
    //   1920: new 40	java/lang/StringBuilder
    //   1923: dup
    //   1924: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1927: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1930: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1933: ldc_w 519
    //   1936: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1942: new 40	java/lang/StringBuilder
    //   1945: dup
    //   1946: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1949: lload_2
    //   1950: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1953: ldc_w 458
    //   1956: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1962: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1965: pop
    //   1966: aload_1
    //   1967: new 40	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1974: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1977: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1980: ldc_w 521
    //   1983: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1989: new 40	java/lang/StringBuilder
    //   1992: dup
    //   1993: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1996: lload 10
    //   1998: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2001: ldc_w 458
    //   2004: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2007: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2010: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2013: pop
    //   2014: aload_1
    //   2015: new 40	java/lang/StringBuilder
    //   2018: dup
    //   2019: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   2022: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   2025: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2028: ldc_w 523
    //   2031: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2037: new 40	java/lang/StringBuilder
    //   2040: dup
    //   2041: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   2044: lload 12
    //   2046: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2049: ldc_w 458
    //   2052: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2058: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2061: pop
    //   2062: aload_1
    //   2063: new 40	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   2070: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   2073: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2076: ldc_w 525
    //   2079: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2085: new 40	java/lang/StringBuilder
    //   2088: dup
    //   2089: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   2092: lload 14
    //   2094: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2097: ldc_w 458
    //   2100: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2106: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2109: pop
    //   2110: aload_1
    //   2111: ldc_w 527
    //   2114: getstatic 147	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   2117: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2120: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2123: pop
    //   2124: aload_1
    //   2125: ldc_w 529
    //   2128: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   2131: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2134: invokevirtual 517	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2137: pop
    //   2138: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2141: invokestatic 534	anpc:a	(Landroid/content/Context;)Lanpc;
    //   2144: aconst_null
    //   2145: ldc_w 806
    //   2148: iload 16
    //   2150: lconst_0
    //   2151: lconst_0
    //   2152: aload_1
    //   2153: aconst_null
    //   2154: invokevirtual 540	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2157: aload 22
    //   2159: invokeinterface 810 1 0
    //   2164: astore_1
    //   2165: aload_1
    //   2166: invokeinterface 815 1 0
    //   2171: ifeq -2142 -> 29
    //   2174: aload_1
    //   2175: invokeinterface 819 1 0
    //   2180: checkcast 70	java/lang/String
    //   2183: astore 17
    //   2185: aload 17
    //   2187: ldc_w 297
    //   2190: invokevirtual 822	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2193: ifne -28 -> 2165
    //   2196: aload 17
    //   2198: ldc_w 824
    //   2201: invokevirtual 822	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2204: ifne -39 -> 2165
    //   2207: new 51	java/io/File
    //   2210: dup
    //   2211: aload 17
    //   2213: invokespecial 301	java/io/File:<init>	(Ljava/lang/String;)V
    //   2216: astore 17
    //   2218: aload 17
    //   2220: invokevirtual 305	java/io/File:exists	()Z
    //   2223: ifeq -58 -> 2165
    //   2226: aload 17
    //   2228: invokevirtual 339	java/io/File:delete	()Z
    //   2231: pop
    //   2232: goto -67 -> 2165
    //   2235: astore_1
    //   2236: ldc 166
    //   2238: iconst_1
    //   2239: ldc_w 458
    //   2242: aload_1
    //   2243: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2246: goto -1525 -> 721
    //   2249: lconst_0
    //   2250: lstore_2
    //   2251: goto -1445 -> 806
    //   2254: ldc_w 826
    //   2257: astore_1
    //   2258: goto -1221 -> 1037
    //   2261: astore_1
    //   2262: ldc 166
    //   2264: iconst_1
    //   2265: ldc_w 458
    //   2268: aload_1
    //   2269: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2272: ldc_w 828
    //   2275: astore_1
    //   2276: goto -751 -> 1525
    //   2279: astore 17
    //   2281: invokestatic 393	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2284: ifeq +14 -> 2298
    //   2287: ldc 166
    //   2289: iconst_2
    //   2290: ldc_w 458
    //   2293: aload 17
    //   2295: invokestatic 461	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2298: aload_1
    //   2299: ifnull -664 -> 1635
    //   2302: aload_1
    //   2303: invokevirtual 753	java/io/BufferedOutputStream:close	()V
    //   2306: goto -671 -> 1635
    //   2309: astore_1
    //   2310: goto -675 -> 1635
    //   2313: astore_1
    //   2314: aconst_null
    //   2315: astore 17
    //   2317: aload 17
    //   2319: ifnull +8 -> 2327
    //   2322: aload 17
    //   2324: invokevirtual 753	java/io/BufferedOutputStream:close	()V
    //   2327: aload_1
    //   2328: athrow
    //   2329: astore_1
    //   2330: ldc 166
    //   2332: iconst_1
    //   2333: ldc_w 830
    //   2336: aload_1
    //   2337: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2340: iconst_1
    //   2341: istore 16
    //   2343: goto -481 -> 1862
    //   2346: ldc 166
    //   2348: iconst_1
    //   2349: iconst_4
    //   2350: anewarray 4	java/lang/Object
    //   2353: dup
    //   2354: iconst_0
    //   2355: ldc_w 832
    //   2358: aastore
    //   2359: dup
    //   2360: iconst_1
    //   2361: lload 8
    //   2363: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2366: aastore
    //   2367: dup
    //   2368: iconst_2
    //   2369: ldc_w 458
    //   2372: aastore
    //   2373: dup
    //   2374: iconst_3
    //   2375: lload_2
    //   2376: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2379: aastore
    //   2380: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2383: goto -2354 -> 29
    //   2386: astore_1
    //   2387: goto -752 -> 1635
    //   2390: astore 17
    //   2392: goto -65 -> 2327
    //   2395: astore_1
    //   2396: aload 19
    //   2398: astore 17
    //   2400: goto -83 -> 2317
    //   2403: astore 18
    //   2405: aload_1
    //   2406: astore 17
    //   2408: aload 18
    //   2410: astore_1
    //   2411: goto -94 -> 2317
    //   2414: astore 17
    //   2416: aload 19
    //   2418: astore_1
    //   2419: goto -138 -> 2281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2422	0	this	anpq
    //   0	2422	1	paramMessage	android.os.Message
    //   151	2225	2	l1	long
    //   126	1420	4	l2	long
    //   1504	11	6	l3	long
    //   780	1582	8	l4	long
    //   891	1106	10	l5	long
    //   906	1139	12	l6	long
    //   921	1172	14	l7	long
    //   1688	654	16	bool	boolean
    //   80	2147	17	localObject1	Object
    //   2279	15	17	localException1	Exception
    //   2315	8	17	localObject2	Object
    //   2390	1	17	localException2	Exception
    //   2398	9	17	localObject3	Object
    //   2414	1	17	localException3	Exception
    //   966	846	18	localObject4	Object
    //   2403	6	18	localObject5	Object
    //   1013	1404	19	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1376	143	20	str1	String
    //   1371	152	21	str2	String
    //   942	1216	22	localArrayList	java.util.ArrayList
    //   1056	554	23	localStringBuilder	StringBuilder
    //   1209	288	24	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1395	71	25	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   609	648	651	java/lang/Throwable
    //   667	670	673	java/lang/Throwable
    //   718	721	2235	java/lang/Throwable
    //   1389	1397	2261	java/lang/Exception
    //   1409	1420	2261	java/lang/Exception
    //   1428	1458	2261	java/lang/Exception
    //   1465	1489	2261	java/lang/Exception
    //   1496	1506	2261	java/lang/Exception
    //   997	1015	2279	java/lang/Exception
    //   2302	2306	2309	java/lang/Exception
    //   997	1015	2313	finally
    //   1748	1859	2329	java/lang/Exception
    //   1630	1635	2386	java/lang/Exception
    //   2322	2327	2390	java/lang/Exception
    //   1015	1033	2395	finally
    //   1037	1211	2395	finally
    //   1216	1357	2395	finally
    //   1357	1370	2395	finally
    //   1389	1397	2395	finally
    //   1409	1420	2395	finally
    //   1428	1458	2395	finally
    //   1465	1489	2395	finally
    //   1496	1506	2395	finally
    //   1525	1625	2395	finally
    //   2262	2272	2395	finally
    //   2281	2298	2403	finally
    //   1015	1033	2414	java/lang/Exception
    //   1037	1211	2414	java/lang/Exception
    //   1216	1357	2414	java/lang/Exception
    //   1357	1370	2414	java/lang/Exception
    //   1525	1625	2414	java/lang/Exception
    //   2262	2272	2414	java/lang/Exception
  }
  
  void onAppBackground()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppBackground,sCountActivity = ", Integer.valueOf(Foreground.sCountActivity) });
    if (this.isBackground) {}
    do
    {
      return;
      if (this.subHandler == null) {
        this.subHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
      }
      this.subHandler.sendEmptyMessage(10);
      this.isBackground = true;
    } while ((!this.isEnable) || (Looper.myLooper() != ThreadManager.getFileThreadLooper()) || (!a(true, false, null)));
    this.subHandler.sendEmptyMessageDelayed(0, 300000L);
  }
  
  void onAppForeground()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppForeground,sCountActivity = ", Integer.valueOf(Foreground.sCountActivity) });
    this.isBackground = false;
    if (this.subHandler == null) {}
    for (;;)
    {
      return;
      this.subHandler.sendEmptyMessage(11);
      this.subHandler.removeMessages(10);
      this.subHandler.removeMessages(0);
      this.subHandler.removeMessages(1);
      if (this.anL > 0L) {
        QLog.d("BatteryStats.BgCpu", 1, "stop trace bg cpu");
      }
      try
      {
        Debug.stopMethodTracing();
        this.anL = 0L;
        if (this.hasCleanLog) {
          continue;
        }
        dSV();
        this.hasCleanLog = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("BatteryStats.BgCpu", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  public static class a
  {
    long anM = 0L;
    long anN = 0L;
    
    public void dSW()
    {
      long l1 = MainService.sReceiverCpuTime;
      long l2 = acyc.RA;
      if (this.anM == 0L)
      {
        QLog.d("BatteryStats.BgCpu", 1, new Object[] { "bgPrintCpuStart msfrecv=", Long.valueOf(l1), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", "  fts=", Long.valueOf(l2), "[", Integer.valueOf(acyc.cAy), "]" });
        this.anM = l1;
        this.anN = l2;
        return;
      }
      dSY();
    }
    
    public void dSX()
    {
      dSY();
      this.anM = 0L;
      this.anN = 0L;
    }
    
    void dSY()
    {
      long l1 = MainService.sReceiverCpuTime;
      long l2 = acyc.RA;
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "bgPrintCpuCostSofar msfrecv=", Long.valueOf(l1 - this.anM), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", "  fts=", Long.valueOf(l2 - this.anN), "[", Integer.valueOf(acyc.cAy), "]" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpq
 * JD-Core Version:    0.7.0.1
 */