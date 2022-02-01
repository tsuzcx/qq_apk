import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector.1;
import com.tencent.mobileqq.startup.director.StartupDirector.2;
import com.tencent.mobileqq.startup.director.StartupDirector.3;
import com.tencent.mobileqq.startup.director.StartupDirector.5;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.a;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class anmo
  implements Handler.Callback
{
  public static boolean TRACE;
  public static long aml;
  public static long amm;
  public static long amn;
  public static long amo;
  private static long amq;
  public static boolean cIA;
  public static boolean cIB;
  public static boolean cIC;
  public static boolean cID;
  public static boolean cIE;
  public static boolean cIF;
  public static boolean cIv;
  public static boolean cIx;
  public static boolean cIy;
  public static boolean cIz;
  public static Set<Integer> cY = new HashSet();
  public static int dKd;
  public static int dKe;
  public static int dKf;
  public static int dKh;
  private static final int[] nK = { 1, 6, 9, 15 };
  private static final int[] nL = { 5, 7 };
  private static final int[] nM = { 11, 12, 17, 18 };
  private static final int[] nN = { 13, 11, 12, 17 };
  private static final int[] nO = { 7, 19 };
  private static final int[] nP = { 13, 11, 17 };
  private static final int[] nQ = nO;
  private static final int[] nR = { 32, 5, 10 };
  private static final int[] nS = { 14, 5, 11, 10 };
  public static final int[] nT = { 14, 5, 11, 10 };
  private static final int[] nU = { 14 };
  private static final int[] nV = { 5, 10, 8, 20 };
  private static final int[] nW = { 13, 5 };
  private static final int[] nX = { 13, 5, 14, 12, 10 };
  private static final int[] nY = { 13, 5, 14, 12, 21 };
  private static final int[] nZ = { 13, 5, 14, 12 };
  private static final int[] oa = { 30, 33 };
  private static final int[] ob = { 5, 14, 8, 12, 10 };
  private ArrayList<WeakReference<AppActivity>> AJ;
  anmo.a jdField_a_of_type_Anmo$a;
  private CheckPermission jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission;
  public long ami;
  public long amj;
  public long amk;
  private long amp;
  private int bLP;
  private boolean cIw;
  public AppActivity d;
  private int dKg;
  private int dKi = -1;
  private ConcurrentHashMap<Integer, Long> ir = new ConcurrentHashMap(8);
  private long kq;
  private Handler mBackgroundHandler;
  private int mCurState = -1;
  private Handler mUiHandler;
  
  static
  {
    TRACE = false;
    dKd = 0;
  }
  
  private void Qi(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onEndStep with " + paramBoolean + ", when " + this.mCurState);
    }
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().postAtFrontOfQueue(Step.a.b(10, this, null));
      if (dKd == 1) {
        ThreadManager.getSubThreadHandler().post(Step.a.b(22, this, null));
      }
    }
    this.mBackgroundHandler = null;
    if (this.mUiHandler != null) {
      this.mUiHandler.removeCallbacksAndMessages(null);
    }
    Vi(1000);
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    if (paramBoolean)
    {
      l1 = SystemClock.uptimeMillis();
      l2 = this.amj;
      l3 = this.amj;
      l4 = BaseApplicationImpl.sShowTime;
      l5 = l1 - BaseApplicationImpl.sShowTime;
      if ((BaseApplicationImpl.sShowTime <= 0L) || (!aqiw.isNetworkAvailable(BaseApplicationImpl.sApplication))) {
        break label311;
      }
    }
    label311:
    for (BaseApplicationImpl.sShowTime = -l1;; BaseApplicationImpl.sShowTime = 0L)
    {
      long l6 = this.ami;
      long l7 = this.amk;
      if ((l4 > 0L) && (l5 < 30000L)) {
        QLog.d("AutoMonitor", 1, "ActionLoginS, cost=" + l5);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.1(this, l7, l6, l2, l1 - l3, l4, l5), 10000L);
      ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.2(this), 3000L);
      if (this.jdField_a_of_type_Anmo$a != null)
      {
        SplashADView localSplashADView = SplashADView.a(null, null);
        if (localSplashADView != null) {
          ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.3(this, localSplashADView), 4000L);
        }
      }
      BaseApplicationImpl.sDirector = null;
      return;
    }
  }
  
  private void Vi(int paramInt)
  {
    QLog.i("AutoMonitor", 1, "nextState " + this.mCurState + ", " + paramInt);
    if ((TRACE) || (BaseApplicationImpl.sProcessId == 1))
    {
      long l1 = 0L;
      if (this.mCurState != -1)
      {
        long l2 = SystemClock.uptimeMillis();
        if (TRACE) {
          Log.i("AutoMonitor", "STATE_" + this.mCurState + ", cost=" + (l2 - amq) + " then " + paramInt);
        }
        l1 = l2;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          this.ir.put(Integer.valueOf(this.mCurState), Long.valueOf(l2 - amq));
          l1 = l2;
        }
      }
      if (paramInt != 1000)
      {
        if (this.mCurState == -1) {
          l1 = SystemClock.uptimeMillis();
        }
        if (l1 != 0L) {
          amq = l1;
        }
      }
    }
    this.mCurState = paramInt;
    if ((this.mCurState == 2) || (this.mCurState == 1000))
    {
      if (this.mCurState != 2) {
        break label251;
      }
      this.dKi = ThreadManager.getSubThread().getPriority();
      ThreadManager.getSubThread().setPriority(10);
      ThreadManager.getRecentThread().setPriority(10);
    }
    label251:
    while ((this.mCurState != 1000) || (this.dKi == -1)) {
      return;
    }
    ThreadManager.getSubThread().setPriority(this.dKi);
    ThreadManager.getRecentThread().setPriority(this.dKi);
  }
  
  public static anmo a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onApplicationCreate ");
    }
    anmo localanmo = new anmo();
    localanmo.Vi(0);
    Step.a.b(0, localanmo, nK).step();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localanmo.Vi(1);
      return localanmo;
    }
    if (BaseApplicationImpl.sProcessId == 6)
    {
      TRACE = false;
      return localanmo;
    }
    TRACE = false;
    Step.a.b(13, localanmo, null).step();
    if (BaseApplicationImpl.sProcessId == 2)
    {
      Step.a.b(11, localanmo, null).step();
      Step.a.b(40, localanmo, null).step();
      ThreadManager.post(Step.a.b(0, localanmo, nV), 10, null, false);
      Step.a.b(0, localanmo, nU).step();
    }
    for (;;)
    {
      return null;
      if (BaseApplicationImpl.sProcessId == 10)
      {
        Step.a.b(0, localanmo, ob).step();
      }
      else if ((BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7))
      {
        Step.a.b(11, localanmo, null).step();
        Step.a.b(8, localanmo, null).step();
        Step.a.b(0, localanmo, nR).step();
        Step.a.b(12, localanmo, null).step();
        Step.a.b(47, localanmo, null).step();
        if (BaseApplicationImpl.sProcessId == 7) {
          Step.a.b(49, localanmo, null).step();
        }
      }
      else if (BaseApplicationImpl.processName.endsWith(":secmsg"))
      {
        Step.a.b(12, localanmo, null).step();
      }
      else if (!BaseApplicationImpl.processName.endsWith(":qqfav"))
      {
        if (BaseApplicationImpl.processName.endsWith(":peak"))
        {
          ThreadManager.excute(Step.a.b(0, localanmo, nT), 16, null, false);
        }
        else
        {
          if (!BaseApplicationImpl.processName.endsWith(":picture")) {
            break;
          }
          Step.a.b(11, localanmo, null).step();
        }
      }
    }
    if (BaseApplicationImpl.processName.endsWith(":troopbar"))
    {
      Step.a.b(12, localanmo, null).step();
      Step.a.b(11, localanmo, null).step();
      Step.a.b(14, localanmo, null).step();
    }
    for (;;)
    {
      if (BaseApplicationImpl.processName.endsWith(":troophomework")) {
        Step.a.b(38, localanmo, null).step();
      }
      if (!BaseApplicationImpl.processName.endsWith(":live")) {
        break;
      }
      Step.a.b(48, localanmo, null).step();
      break;
      Step.a.b(0, localanmo, nS).step();
    }
  }
  
  private void a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (paramAppActivity == null) {
      return;
    }
    TextView localTextView = new TextView(paramAppActivity);
    paramAppActivity.getWindow().setBackgroundDrawableResource(17170446);
    localTextView.setGravity(17);
    localTextView.setBackgroundColor(-16777216);
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (!paramBoolean) {
      localTextView.setText(2131694972);
    }
    for (;;)
    {
      paramAppActivity.setContentView(localTextView);
      QLog.flushLog();
      this.mUiHandler.postDelayed(new StartupDirector.5(this, paramAppActivity), 8000L);
      return;
      localTextView.setText(acfp.m(2131714772));
    }
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    this.bLP = 1;
    paramArrayOfInt1 = Step.a.b(0, this, paramArrayOfInt1);
    if (paramArrayOfInt2 != null)
    {
      this.bLP = 2;
      this.dKg = paramInt;
      paramArrayOfInt1.setResultListener(this.mUiHandler, 10);
      paramArrayOfInt2 = Step.a.b(0, this, paramArrayOfInt2);
      paramArrayOfInt2.setResultListener(this.mUiHandler, 10);
      new Handler(ThreadManager.getRecentThreadLooper()).post(paramArrayOfInt2);
    }
    for (;;)
    {
      paramArrayOfInt1.step();
      return;
      paramArrayOfInt1.setResultListener(this.mUiHandler, paramInt);
    }
  }
  
  /* Error */
  private final int aF(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: new 462	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 468	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc_w 470
    //   25: invokespecial 473	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore 9
    //   30: iload 4
    //   32: istore_3
    //   33: aload 9
    //   35: invokevirtual 476	java/io/File:exists	()Z
    //   38: ifeq +49 -> 87
    //   41: new 478	java/io/BufferedInputStream
    //   44: dup
    //   45: new 480	java/io/FileInputStream
    //   48: dup
    //   49: aload 9
    //   51: invokespecial 483	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 486	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 5
    //   59: aload 5
    //   61: astore_1
    //   62: aload 5
    //   64: invokevirtual 489	java/io/BufferedInputStream:read	()I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpne +228 -> 298
    //   73: iload_2
    //   74: istore_3
    //   75: aload 5
    //   77: ifnull +10 -> 87
    //   80: aload 5
    //   82: invokevirtual 492	java/io/BufferedInputStream:close	()V
    //   85: iload_2
    //   86: istore_3
    //   87: iload_3
    //   88: iconst_1
    //   89: iadd
    //   90: istore_2
    //   91: aload 8
    //   93: astore_1
    //   94: new 494	java/io/FileOutputStream
    //   97: dup
    //   98: aload 9
    //   100: invokespecial 495	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore 5
    //   105: aload 5
    //   107: iload_2
    //   108: invokevirtual 498	java/io/FileOutputStream:write	(I)V
    //   111: aload 5
    //   113: ifnull +8 -> 121
    //   116: aload 5
    //   118: invokevirtual 499	java/io/FileOutputStream:close	()V
    //   121: iload_2
    //   122: ireturn
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 502	java/io/IOException:printStackTrace	()V
    //   128: iload_2
    //   129: istore_3
    //   130: goto -43 -> 87
    //   133: astore 6
    //   135: aconst_null
    //   136: astore 5
    //   138: aload 5
    //   140: astore_1
    //   141: aload 6
    //   143: invokevirtual 503	java/lang/Exception:printStackTrace	()V
    //   146: iload 4
    //   148: istore_3
    //   149: aload 5
    //   151: ifnull -64 -> 87
    //   154: aload 5
    //   156: invokevirtual 492	java/io/BufferedInputStream:close	()V
    //   159: iload 4
    //   161: istore_3
    //   162: goto -75 -> 87
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 502	java/io/IOException:printStackTrace	()V
    //   170: iload 4
    //   172: istore_3
    //   173: goto -86 -> 87
    //   176: astore_1
    //   177: aload 6
    //   179: astore 5
    //   181: aload 5
    //   183: ifnull +8 -> 191
    //   186: aload 5
    //   188: invokevirtual 492	java/io/BufferedInputStream:close	()V
    //   191: aload_1
    //   192: athrow
    //   193: astore 5
    //   195: aload 5
    //   197: invokevirtual 502	java/io/IOException:printStackTrace	()V
    //   200: goto -9 -> 191
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 502	java/io/IOException:printStackTrace	()V
    //   208: iload_2
    //   209: ireturn
    //   210: astore 6
    //   212: aload 7
    //   214: astore 5
    //   216: aload 5
    //   218: astore_1
    //   219: aload 6
    //   221: invokevirtual 502	java/io/IOException:printStackTrace	()V
    //   224: aload 5
    //   226: ifnull -105 -> 121
    //   229: aload 5
    //   231: invokevirtual 499	java/io/FileOutputStream:close	()V
    //   234: iload_2
    //   235: ireturn
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 502	java/io/IOException:printStackTrace	()V
    //   241: iload_2
    //   242: ireturn
    //   243: astore 6
    //   245: aload_1
    //   246: astore 5
    //   248: aload 6
    //   250: astore_1
    //   251: aload 5
    //   253: ifnull +8 -> 261
    //   256: aload 5
    //   258: invokevirtual 499	java/io/FileOutputStream:close	()V
    //   261: aload_1
    //   262: athrow
    //   263: astore 5
    //   265: aload 5
    //   267: invokevirtual 502	java/io/IOException:printStackTrace	()V
    //   270: goto -9 -> 261
    //   273: astore_1
    //   274: goto -23 -> 251
    //   277: astore 6
    //   279: goto -63 -> 216
    //   282: astore 6
    //   284: aload_1
    //   285: astore 5
    //   287: aload 6
    //   289: astore_1
    //   290: goto -109 -> 181
    //   293: astore 6
    //   295: goto -157 -> 138
    //   298: iload_3
    //   299: istore_2
    //   300: goto -227 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	anmo
    //   0	303	1	paramContext	android.content.Context
    //   13	287	2	i	int
    //   32	267	3	j	int
    //   10	161	4	k	int
    //   57	130	5	localObject1	Object
    //   193	3	5	localIOException1	java.io.IOException
    //   214	43	5	localObject2	Object
    //   263	3	5	localIOException2	java.io.IOException
    //   285	1	5	localContext	android.content.Context
    //   7	1	6	localObject3	Object
    //   133	45	6	localException1	Exception
    //   210	10	6	localIOException3	java.io.IOException
    //   243	6	6	localObject4	Object
    //   277	1	6	localIOException4	java.io.IOException
    //   282	6	6	localObject5	Object
    //   293	1	6	localException2	Exception
    //   1	212	7	localObject6	Object
    //   4	88	8	localObject7	Object
    //   28	71	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   80	85	123	java/io/IOException
    //   41	59	133	java/lang/Exception
    //   154	159	165	java/io/IOException
    //   41	59	176	finally
    //   186	191	193	java/io/IOException
    //   116	121	203	java/io/IOException
    //   94	105	210	java/io/IOException
    //   229	234	236	java/io/IOException
    //   94	105	243	finally
    //   219	224	243	finally
    //   256	261	263	java/io/IOException
    //   105	111	273	finally
    //   105	111	277	java/io/IOException
    //   62	68	282	finally
    //   141	146	282	finally
    //   62	68	293	java/lang/Exception
  }
  
  private void dRC()
  {
    QLog.i("AutoMonitor", 1, "realCreateActivity " + this.mCurState + ", " + this.AJ);
    if (this.mCurState == 3) {
      Vi(4);
    }
    if (this.AJ != null)
    {
      int i = this.AJ.size() - 1;
      if (i >= 0)
      {
        Object localObject = (WeakReference)this.AJ.get(i);
        if (localObject != null) {}
        for (localObject = (AppActivity)((WeakReference)localObject).get();; localObject = null)
        {
          if (localObject != null) {
            ((AppActivity)localObject).realOnCreate();
          }
          i -= 1;
          break;
        }
      }
    }
    long l;
    if (BaseApplicationImpl.sLaunchTime > 0L)
    {
      l = SystemClock.uptimeMillis();
      this.amk = (l - BaseApplicationImpl.sLaunchTime);
      Log.d("AutoMonitor", "ActionLoginA, cost=" + this.amk);
      if (!aqiw.isNetSupport(BaseApplicationImpl.sApplication)) {
        break label223;
      }
    }
    label223:
    for (BaseApplicationImpl.sLaunchTime = -l;; BaseApplicationImpl.sLaunchTime = 0L)
    {
      Vi(5);
      i(2, 0, 3000L);
      if (BaseApplicationImpl.sProcessId == 1) {
        h(12, 0, 10000L);
      }
      return;
    }
  }
  
  public static void dRD()
  {
    int j = 0;
    if ((!cIE) && (BaseApplicationImpl.sProcessId == 1)) {}
    for (;;)
    {
      try
      {
        localObject = getLowDeviceSp();
        bool = aqgz.aCI();
        cIC = ((SharedPreferences)localObject).getBoolean("enable_thread_suspend", false);
        cID = ((SharedPreferences)localObject).getBoolean("fake_enable_thread_suspend", false);
        SuspendThreadManager.a().init();
        if (!bool) {
          return;
        }
        if (bool) {
          cIF = true;
        }
        cIy = ((SharedPreferences)localObject).getBoolean("disablepreloadproc_new", false);
        cIx = ((SharedPreferences)localObject).getBoolean("disablegettrooplist_new", false);
        cIz = ((SharedPreferences)localObject).getBoolean("disablepredownload_new", false);
        cIA = ((SharedPreferences)localObject).getBoolean("enableautoperf_new", false);
        if ((cIy) || (cIx) || (cIz)) {
          break label522;
        }
        if (!cIA) {
          break label527;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        boolean bool;
        String str1;
        String[] arrayOfString;
        int k;
        String str2;
        QLog.e("Perf", 1, "enablePerfConfig has Exception:", localThrowable);
      }
      if ((i != 0) && (bool))
      {
        str1 = ((SharedPreferences)localObject).getString("extralsteps_new", "");
        if (!str1.isEmpty())
        {
          arrayOfString = str1.split("\\|");
          if (arrayOfString.length > 0)
          {
            k = arrayOfString.length;
            i = 0;
            if (i < k)
            {
              str2 = arrayOfString[i];
              acoo.bV.add(Integer.valueOf(Integer.parseInt(str2)));
              i += 1;
              continue;
            }
          }
        }
        cY.clear();
        localObject = ((SharedPreferences)localObject).getString("predownloadwhitelist_new", "");
        if (!((String)localObject).isEmpty())
        {
          arrayOfString = ((String)localObject).split("\\|");
          if (arrayOfString.length > 0)
          {
            k = arrayOfString.length;
            i = j;
            if (i < k)
            {
              str2 = arrayOfString[i];
              cY.add(Integer.valueOf(Integer.parseInt(str2)));
              i += 1;
              continue;
            }
          }
        }
        dKf = 0;
        if (cIy) {
          dKf |= 0x1;
        }
        if (cIx) {
          dKf |= 0x2;
        }
        if (cIz) {
          dKf |= 0x4;
        }
        if (cIA) {
          dKf |= 0x8;
        }
        cIE = true;
        QLog.d("Perf", 1, "sDisablePreloadProcess:" + cIy + ",sDisableGetTroopList:" + cIx + ",sDisablePreDownload:" + cIz + ",sEnableAutoMatorPerf:" + cIA + ",sEnableCpuTimePrint:" + cIB + ",extra_imp_steps:" + str1 + ",sPerfConfigReportValue:" + dKf + ",predownload_white_list:" + (String)localObject);
        return;
      }
      return;
      label522:
      int i = 1;
      continue;
      label527:
      i = 0;
    }
  }
  
  public static SharedPreferences getLowDeviceSp()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("perf_config", 4);
  }
  
  private void h(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mBackgroundHandler == null) {
      this.mBackgroundHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    }
    this.mBackgroundHandler.removeMessages(paramInt1);
    Message localMessage = this.mUiHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.mBackgroundHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public boolean ayt()
  {
    return this.cIw;
  }
  
  public void dRE()
  {
    i(2, 0, 0L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    QLog.i("AutoMonitor", 1, this.mCurState + "handleMessage" + paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      for (;;)
      {
        return true;
        i(4, 0, 300L);
        bool1 = Step.a.b(13, this, null).step();
        if ((bool1) && (dKe <= 3))
        {
          i(5, 0, 0L);
          a(nL, nM, 6);
          h(9, 0, 300L);
          return true;
        }
        if (bool1) {
          i = 1;
        }
        i(3, i, 0L);
        return true;
        h(9, 0, 300L);
        a(nN, nO, 6);
        return true;
        a(nP, nQ, 6);
        return true;
        a(nP, nQ, 116);
        return true;
        onActivityFocusChanged(this.d, true);
        return true;
        if (this.d != null)
        {
          AppActivity localAppActivity = this.d;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          a(localAppActivity, bool1);
          return true;
          if (this.d != null)
          {
            aqml.P(this.d, "com.tencent.mobileqq.activity.MainActivity");
            aqml.P(this.d, SplashActivity.class.getName());
            return true;
            if (!this.mUiHandler.hasMessages(4)) {}
            this.mUiHandler.removeMessages(4);
            return true;
            QLog.d("AutoMonitor", 1, "qqBackStartReady");
            this.cIw = true;
            return true;
            if (paramMessage.arg1 == 0)
            {
              if (this.ami > 0L) {
                this.kq = (this.amp + this.ami - SystemClock.uptimeMillis());
              }
              if (BaseApplicationImpl.isCurrentVersionFirstLaunch)
              {
                System.gc();
                this.kq = 2000L;
              }
              if ((this.kq > 0L) && (this.kq < 6000L))
              {
                if (this.jdField_a_of_type_Anmo$a != null)
                {
                  i(6, 2, this.kq);
                  return true;
                }
                i(6, 1, this.kq);
                return true;
              }
              dRC();
              return true;
            }
            if (paramMessage.arg1 == 1)
            {
              dRC();
              return true;
            }
            this.jdField_a_of_type_Anmo$a.a(this);
            if (this.ami > 0L) {
              this.kq = this.ami;
            }
            QLog.i("SplashAD", 1, "mDelay" + this.kq);
            if ((this.kq > 0L) && (this.kq < 11000L))
            {
              i(15, 1, this.kq);
              return true;
            }
            dRC();
            return true;
            Step.a.b(14, this, null).step();
            if (BaseApplicationImpl.sProcessId == 7)
            {
              i(13, 0, 0L);
              return true;
              QLog.d("AutoMonitor", 1, "MSG_REAL_CREATE MSG_JOB_FINISHED");
              i = this.bLP - 1;
              this.bLP = i;
              if (i == 0)
              {
                i(this.dKg, 0, 0L);
                return true;
                if (this.ami > 0L) {
                  this.amp = SystemClock.uptimeMillis();
                }
                h(paramMessage.arg1, 0, 0L);
                return true;
                try
                {
                  if (GuardManager.a != null)
                  {
                    paramMessage = GuardManager.a;
                    bool1 = bool2;
                    if (dKd == 2) {
                      bool1 = true;
                    }
                    paramMessage.EW(bool1);
                    return true;
                  }
                }
                catch (Throwable paramMessage)
                {
                  return true;
                }
              }
            }
          }
        }
      }
      Step.a.b(29, this, null).step();
      return true;
    } while (this.jdField_a_of_type_Anmo$a.cIG);
    this.jdField_a_of_type_Anmo$a.end();
    QLog.d("AutoMonitor", 1, "MSG_REAL_CREATE1 MSG_SPLASHAD_END");
    i(6, 1, 0L);
    return true;
  }
  
  public void i(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mUiHandler == null) {
      this.mUiHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.mUiHandler.removeMessages(paramInt1);
    Message localMessage = this.mUiHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.mUiHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    QLog.i("AutoMonitor", 1, "onActivityCreate" + paramObject);
    if ((paramObject instanceof AppActivity)) {}
    for (paramObject = (AppActivity)paramObject;; paramObject = null)
    {
      long l = SystemClock.uptimeMillis();
      if ((this.mCurState == 1) && (Math.abs(l - BaseApplicationImpl.appStartTime) > 4000L))
      {
        BaseApplicationImpl.sShowTime = 0L;
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.appStartTime = 0L;
      }
      label203:
      boolean bool2;
      if (paramObject == null)
      {
        int i;
        if (this.mCurState == 1)
        {
          BaseApplicationImpl.sIsBgStartup = true;
          BaseApplicationImpl.sShowTime = 0L;
          BaseApplicationImpl.sLaunchTime = 0L;
          if (paramIntent != null) {
            dKd = paramIntent.getIntExtra("k_start_mode", 0);
          }
          QLog.i("AutoMonitor", 1, "onActivityCreate" + this.mCurState + ", " + dKd);
          paramObject = nX;
          if (dKd == 1)
          {
            paramObject = nY;
            Step.a.b(0, this, paramObject).step();
            if (GuardManager.a != null)
            {
              paramObject = GuardManager.a;
              if (dKd != 2) {
                break label253;
              }
              i = 1;
              paramObject.x(i, null);
            }
            Vi(201);
          }
        }
        for (;;)
        {
          bool2 = false;
          return bool2;
          if (dKd == 2)
          {
            paramObject = nZ;
            BaseApplicationImpl.appStartTime = 0L;
            break;
          }
          if (dKd != 0) {
            break;
          }
          paramObject = nX;
          break;
          label253:
          i = 6;
          break label203;
          if (this.mCurState == 2)
          {
            Step.a.b(0, this, nW).step();
            Vi(101);
          }
          else if ((this.mCurState == 201) && (dKd == 2) && (paramIntent != null))
          {
            i = paramIntent.getIntExtra("k_start_mode", 0);
            QLog.i("AutoMonitor", 1, "onActivityCreate" + this.mCurState + ", " + i);
            if ((i == 3) || (i == 0) || (i == 1)) {
              Step.a.b(10, this, null).step();
            }
          }
        }
      }
      if ((this.mCurState == 1) || (this.mCurState == 2) || (this.mCurState == 101) || (this.mCurState == 201))
      {
        if ((Build.VERSION.SDK_INT < 21) && (!"Success".equals(BaseApplicationImpl.sInjectResult)) && (!(paramObject instanceof InstallActivity)))
        {
          paramIntent = new Intent(paramObject, InstallActivity.class);
          paramIntent.addFlags(603979776);
          Intent localIntent = paramObject.getIntent();
          localIntent.addFlags(67108864);
          paramIntent.putExtra("NT_AY", localIntent);
          try
          {
            paramObject.superStartActivityForResult(paramIntent, -1, null);
          }
          catch (Exception paramIntent)
          {
            try
            {
              for (;;)
              {
                paramObject.superFinish();
                dKe = aF(BaseApplicationImpl.sApplication);
                if (dKe <= 3) {
                  System.exit(-1);
                }
                return true;
                paramIntent = paramIntent;
                QLog.e("AutoMonitor", 1, "", paramIntent);
              }
            }
            catch (Exception paramObject)
            {
              for (;;)
              {
                QLog.e("AutoMonitor", 1, "", paramObject);
              }
            }
          }
        }
        this.d = paramObject;
        if (!(paramObject instanceof InstallActivity)) {}
      }
      for (;;)
      {
        boolean bool1;
        try
        {
          new File(this.d.getFilesDir(), "suicide_count").delete();
          if (!(paramObject instanceof SplashActivity))
          {
            BaseApplicationImpl.sLaunchTime = 0L;
            BaseApplicationImpl.sShowTime = 0L;
          }
          paramIntent = (SetSplash)Step.a.b(2, this, null);
          paramIntent.step();
          if (paramIntent.cIL)
          {
            bool2 = true;
            i(2, 0, 1000L);
            if ((this.mCurState == 201) || ((this.mCurState == 1) && (dKd == 2))) {
              this.amj = l;
            }
            bool1 = bool2;
            if (this.mCurState == 1)
            {
              Vi(2);
              bool1 = bool2;
            }
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            if (this.AJ == null) {
              this.AJ = new ArrayList(2);
            }
            this.AJ.add(new WeakReference(paramObject));
            return bool1;
          }
        }
        catch (Throwable paramIntent)
        {
          QLog.e("AutoMonitor", 1, "", paramIntent);
          continue;
          Step.a.b(7, this, null).step();
          bool2 = false;
          i(2, 0, 0L);
          continue;
        }
        if ((this.mCurState == 5) || (this.mCurState == 6))
        {
          BaseApplicationImpl.sLaunchTime = 0L;
          BaseApplicationImpl.sShowTime = 0L;
          this.d = paramObject;
          Vi(6);
          i(2, 0, 1000L);
          bool1 = false;
        }
        else if (this.mCurState == 3)
        {
          bool1 = true;
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean)
  {
    QLog.i("AutoMonitor", 1, "onActivityFocusChanged when " + this.mCurState + ", " + paramAppActivity + ", " + paramBoolean);
    if (!paramBoolean) {
      return;
    }
    this.mUiHandler.removeMessages(2);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission == null) {
        this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission = ((CheckPermission)Step.a.b(3, this, null));
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission.checkPermission(paramAppActivity))
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        return;
      }
    }
    auri.ewu();
    if (this.mCurState == 2)
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        ThreadManager.getFileThreadHandler().postDelayed(Step.a.b(14, this, null), 1000L);
      }
      i(11, 1, 5L);
      Vi(3);
    }
    for (;;)
    {
      paramAppActivity = SplashADView.a(null, null);
      if ((paramAppActivity == null) || (!paramAppActivity.hasInit) || (!paramAppActivity.cIs)) {
        break;
      }
      QLog.i("SplashAD", 1, "adView resume Video");
      paramAppActivity.resumeVideo();
      return;
      if (this.mCurState == 101)
      {
        i(11, 7, 5L);
        Vi(3);
      }
      else if (this.mCurState == 201)
      {
        i(11, 8, 5L);
        Vi(3);
      }
      else if ((this.mCurState == 5) || (this.mCurState == 6))
      {
        Qi(true);
      }
      else if (this.mCurState == 3) {}
    }
  }
  
  public static abstract class a
  {
    public boolean cIG;
    
    protected abstract void a(anmo paramanmo);
    
    protected abstract void end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anmo
 * JD-Core Version:    0.7.0.1
 */