package com.tencent.mobileqq.app;

import acbx;
import acby;
import acek;
import acem;
import acen;
import acfn;
import acfo;
import acgy;
import acgz;
import acin;
import acyn;
import adrh;
import aewh;
import ahyg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import anot;
import anpc;
import anpf;
import anpr;
import aogc;
import aqmj;
import aqmu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class GuardManager
  extends BroadcastReceiver
  implements Handler.Callback
{
  public static GuardManager a;
  public static int cvM = 5;
  public static int cvN = 10;
  public static int cvO = 15;
  private static ConcurrentHashMap<String, Long> dY = new ConcurrentHashMap();
  public static volatile boolean isForeground;
  long PI = 0L;
  long PJ = 0L;
  long PK = 0L;
  private acfo jdField_a_of_type_Acfo;
  acfo[] jdField_a_of_type_ArrayOfAcfo = new acfo[9];
  public long[][] a;
  private volatile BroadcastReceiver aY;
  public volatile String bok = null;
  public int cvJ;
  private int cvL = 0;
  private Application mContext;
  private Handler mHandler;
  public int mLastIndex;
  long mStartTime = 0L;
  Random random;
  
  public GuardManager(Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_Array2dOfLong = ((long[][])Array.newInstance(Long.TYPE, new int[] { 3, 15 }));
    this.mContext = paramApplication;
    this.mHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    x(paramInt, null);
    paramApplication = new IntentFilter("com.tencent.process.stopping");
    paramApplication.addAction("com.tencent.process.starting");
    try
    {
      this.mContext.registerReceiver(this, paramApplication);
      label120:
      Foreground.setReady();
      return;
    }
    catch (Throwable paramApplication)
    {
      break label120;
    }
  }
  
  public static void EU(boolean paramBoolean)
  {
    for (;;)
    {
      long l2;
      try
      {
        if (BaseApplicationImpl.sProcessId != 1) {
          return;
        }
        long l1 = SystemClock.uptimeMillis();
        if ((!paramBoolean) && (l1 - JobReporter.sThreadJobReportLastReportTs.get() < 600000L)) {
          break;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        l2 = JobReporter.sThreadJobReportTotalCount.getAndSet(0L);
        if ((l2 == 0L) || (localQQAppInterface == null) || (!aai())) {
          break;
        }
        String str1 = Long.toString(JobReporter.sThreadJobReportCountLevelOne.getAndSet(0L));
        String str2 = Long.toString(JobReporter.sThreadJobReportCountLevelTwo.getAndSet(0L));
        String str3 = Long.toString(JobReporter.sThreadJobReportCountLevelThree.getAndSet(0L));
        if (l2 > 2147483647L)
        {
          i = 2147483647;
          JobReporter.sThreadJobReportLastReportTs.set(l1);
          HashMap localHashMap = new HashMap();
          localHashMap.put("countLevel_1", str1);
          localHashMap.put("countLevel_2", str2);
          localHashMap.put("countLevel_3", str3);
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(localQQAppInterface.getCurrentUin(), "maxThreadManagerJobWait", true, i, 1L, localHashMap, "", false);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GuardManager", 1, "reportThreadJobWaitTime", localThrowable);
        return;
      }
      int i = (int)l2;
    }
  }
  
  private static boolean aai()
  {
    if (!ThreadSetting.isPublicVersion) {}
    while (ThreadSetting.isGrayVersion) {
      return true;
    }
    return JobReporter.ramdomReport(10000);
  }
  
  public static void q(Context paramContext, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (!dY.containsKey(paramString)) {}
    switch (paramInt)
    {
    default: 
      if (l1 - ((Long)dY.get(paramString)).longValue() >= 86400000L) {
        break;
      }
    }
    for (;;)
    {
      return;
      dY.put(paramString, Long.valueOf(aqmj.u(paramContext)));
      break;
      dY.put(paramString, Long.valueOf(aqmj.v(paramContext, paramString)));
      break;
      long l2 = aqmu.Z(l1);
      dY.put(paramString, Long.valueOf(l2));
      switch (paramInt)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.d("GuardManager", 2, "Daily Report info key=" + paramString + " timeMillisInTodayZero=" + l2 + " nowTime=" + l1);
        return;
        aqmj.t(paramContext, l2);
        anot.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "start_up", "front", "device_cnt", "", 1, "");
        continue;
        aqmj.z(paramContext, paramString, l2);
        anot.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "login", "front", "login", "", 1, "");
        continue;
        aqmj.z(paramContext, paramString, l2);
        anot.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "login", "msf", "login", "", 1, "");
      }
    }
  }
  
  public static void v(Context paramContext, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().isRuntimeReady()) && (BaseApplicationImpl.getApplication().getRuntime().isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "now login uin=" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + " isForeground=" + paramBoolean);
      }
      if (paramBoolean) {
        q(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_Foreground", 1);
      }
      q(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_Background", 2);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GuardManager", 2, "isRuntimeReady=" + BaseApplicationImpl.getApplication().isRuntimeReady() + " now login uin=null");
  }
  
  public void ET(boolean paramBoolean)
  {
    if (this.mStartTime == 0L) {}
    long l1;
    int i;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      long l2 = l1 - this.mStartTime;
      int j = (int)(l2 / 1000L);
      i = j;
      if (l2 % 1000L >= 500L) {
        i = j + 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "reportForeground(" + paramBoolean + "):[" + this.mStartTime + " - " + l1 + " = " + i + "]");
      }
      if (i > 0)
      {
        Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
        localObject = new SimpleDateFormat("yyyyMMdd", Locale.US).format((Date)localObject);
        anot.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "CliOper", "", "", "Online_time", "Fe_time", 0, i, 0, (String)localObject, "", "", "");
      }
      if (!paramBoolean) {
        break;
      }
    } while (i <= 0);
    this.mStartTime = l1;
    return;
    this.mStartTime = 0L;
  }
  
  public void EV(boolean paramBoolean)
  {
    long l = MemoryManager.C(Process.myPid());
    Jd(0);
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < 15)
    {
      k = (int)(k + this.jdField_a_of_type_Array2dOfLong[1][i]);
      j = (int)(j + this.jdField_a_of_type_Array2dOfLong[0][i]);
      i += 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
    localHashMap.put("resumeCount", String.valueOf(k * 1.0D / 15.0D));
    localHashMap.put("msgCount", String.valueOf(j * 1.0D / 15.0D));
    localHashMap.put("activeLevel", String.valueOf(acfn.a().a(this.jdField_a_of_type_Array2dOfLong, this.mLastIndex, this.cvJ)));
    if (paramBoolean) {}
    for (String str = "actLiteActive";; str = "actFullActive")
    {
      report(str, localHashMap);
      return;
    }
  }
  
  public void EW(boolean paramBoolean)
  {
    acfn localacfn = acfn.a();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    int i = localacfn.cvF;
    long l = localacfn.cvG | i << 8;
    int j = acfn.a().cvH;
    if (paramBoolean) {}
    for (i = 1;; i = 0)
    {
      localAppRuntime.onGuardEvent(5, l, i | j << 8);
      return;
    }
  }
  
  void Jd(int paramInt)
  {
    int k = (int)(System.currentTimeMillis() / 60000L);
    if (k == this.cvJ)
    {
      long[] arrayOfLong = this.jdField_a_of_type_Array2dOfLong[paramInt];
      paramInt = this.mLastIndex;
      arrayOfLong[paramInt] += 1L;
      return;
    }
    int j;
    if ((k < this.cvJ) || (k - this.cvJ > 15))
    {
      i = 0;
      while (i < 3)
      {
        j = 0;
        while (j < 15)
        {
          this.jdField_a_of_type_Array2dOfLong[i][j] = 0L;
          j += 1;
        }
        i += 1;
      }
      this.cvJ = (k - 15);
      this.mLastIndex = 0;
    }
    int m = (k - this.cvJ) % 15;
    int i = 1;
    while (i <= m)
    {
      j = 0;
      while (j < 3)
      {
        this.jdField_a_of_type_Array2dOfLong[j][((this.mLastIndex + i) % 15)] = 0L;
        j += 1;
      }
      i += 1;
    }
    this.cvJ = k;
    this.mLastIndex = ((this.mLastIndex + m) % 15);
    this.jdField_a_of_type_Array2dOfLong[paramInt][this.mLastIndex] = 1L;
  }
  
  acfo a(int paramInt)
  {
    acfo localacfo = this.jdField_a_of_type_ArrayOfAcfo[paramInt];
    Object localObject = localacfo;
    if (localacfo == null) {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("WTF");
      case 2: 
        localObject = new acem();
      }
    }
    for (;;)
    {
      ((acfo)localObject).c = this;
      ((acfo)localObject).mId = paramInt;
      this.jdField_a_of_type_ArrayOfAcfo[paramInt] = localObject;
      return localObject;
      localObject = new acen();
      continue;
      localObject = new acbx();
      continue;
      localObject = new acby();
      continue;
      localObject = new acgz();
      continue;
      localObject = new acfo();
      continue;
      localObject = new acgy();
      continue;
      localObject = new acin();
    }
  }
  
  public boolean aaj()
  {
    int i = this.cvL;
    return (i == 6) || (i == 7) || (i == 5);
  }
  
  public boolean aak()
  {
    int i = this.cvL;
    return (i == 4) || (i == 6);
  }
  
  public void av(boolean paramBoolean, String paramString)
  {
    ahyg.exitProcess(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    Intent localIntent = new Intent("com.tencent.process.exit");
    localIntent.putExtra("exit_type", 101);
    localIntent.putExtra("qq_mode_foreground", paramBoolean);
    localIntent.putStringArrayListExtra("procNameList", localArrayList);
    localIntent.putExtra("verify", BaseApplicationImpl.getLocalVerify(localArrayList, false));
    this.mContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + aewh.getVersionCode(BaseApplicationImpl.getContext()) + ", toExitTargetProcess=" + paramString + " isForeground=" + paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean, String... paramVarArgs)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
    try
    {
      localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label319;
          }
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          str1 = localRunningAppProcessInfo.processName;
          i = localRunningAppProcessInfo.pid;
          if ((str1.startsWith("com.tencent.tim")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF"))) {
            if (paramVarArgs != null)
            {
              int k = paramVarArgs.length;
              j = 0;
              i = 0;
              if (j < k)
              {
                String str2 = paramVarArgs[j];
                if ((TextUtils.isEmpty(str2)) || (!str1.endsWith(str2))) {
                  break;
                }
                i = 1;
                if (i == 0) {
                  break label299;
                }
                localArrayList3.add(str1);
              }
              if (i != 0) {}
            }
            else
            {
              if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0)))) {
                break label308;
              }
              localArrayList1.add(str1);
              ahyg.exitProcess(str1);
              if (str1.endsWith(":qzone")) {
                anpf.a().Rg(anpf.getUin());
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        int j;
        if (QLog.isColorLevel()) {
          QLog.e("GuardManager", 2, "exitProcess: Failed.  exception: ", localThrowable);
        }
        Object localObject2 = null;
        continue;
        int i = 0;
        continue;
        label299:
        j += 1;
        continue;
        label308:
        localArrayList2.add(str1);
      }
      label319:
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + aewh.getVersionCode(BaseApplicationImpl.getContext()) + ", toExitProcess=" + localArrayList1 + ", forgroundProcess=" + localArrayList2 + ", exceptions:" + localArrayList3);
      }
      if (localArrayList1.size() > 0)
      {
        paramVarArgs = new Intent("com.tencent.process.exit");
        paramVarArgs.putExtra("exit_type", 101);
        paramVarArgs.putExtra("qq_mode_foreground", paramBoolean);
        paramVarArgs.putStringArrayListExtra("procNameList", localArrayList1);
        paramVarArgs.putExtra("verify", BaseApplicationImpl.getLocalVerify(localArrayList1, false));
        this.mContext.sendBroadcast(paramVarArgs);
      }
    }
  }
  
  public void cq(QQAppInterface paramQQAppInterface)
  {
    if ((this.mStartTime == 0L) && (this.bok != null))
    {
      if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getAccount()))) {
        break label61;
      }
      if (this.PI > 0L)
      {
        this.mStartTime = this.PI;
        this.PI = 0L;
      }
    }
    else
    {
      return;
    }
    this.mStartTime = SystemClock.uptimeMillis();
    return;
    label61:
    this.PI = SystemClock.uptimeMillis();
  }
  
  public void exit()
  {
    x(8, null);
    try
    {
      this.mContext.unregisterReceiver(this);
      if (this.aY == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        label33:
        do
        {
          this.mContext.unregisterReceiver(this.aY);
          this.aY = null;
          this.mHandler.removeMessages(5);
          CoreService.stopCoreService();
          return;
          localThrowable1 = localThrowable1;
        } while (!QLog.isColorLevel());
        QLog.d("GuardManager", 2, "", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        break label33;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.bok == null) {
        continue;
      }
      Object localObject1 = (String)paramMessage.obj;
      if (!TextUtils.equals(this.bok, (CharSequence)localObject1)) {
        continue;
      }
      this.bok = null;
      if (Foreground.sCountActivity > 0)
      {
        this.bok = "com.tencent.tim";
        return true;
      }
      if (this.aY != null) {}
      try
      {
        this.mContext.unregisterReceiver(this.aY);
        label114:
        this.aY = null;
        ET(false);
        y(4, paramMessage.obj);
        paramMessage = new Intent("com.tencent.plugin.state.change");
        paramMessage.putExtra("key_plugin_state", 0);
        BaseApplicationImpl.getApplication().sendBroadcast(paramMessage);
        paramMessage = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (!paramMessage.isRunning()) {
          continue;
        }
        paramMessage.dQ(BaseApplicationImpl.sApplication);
        return true;
        localObject1 = this.bok;
        this.bok = ((String)paramMessage.obj);
        Object localObject2;
        if (localObject1 == null)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          cq((QQAppInterface)localObject1);
          if (this.aY == null)
          {
            this.aY = new a();
            localObject2 = new IntentFilter();
            ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
            ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
          }
        }
        try
        {
          this.mContext.registerReceiver(this.aY, (IntentFilter)localObject2);
          label279:
          localObject2 = new Intent("com.tencent.plugin.state.change");
          ((Intent)localObject2).putExtra("key_plugin_state", 1);
          BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject2);
          if (StartService.cIM) {
            MemoryManager.a().d(BaseApplicationImpl.sApplication, (QQAppInterface)localObject1);
          }
          y(3, paramMessage.obj);
          return true;
          try
          {
            if (((paramMessage.arg2 == 2) || (paramMessage.arg2 == 3)) && ((paramMessage.arg1 == 4) || (paramMessage.arg1 == 5))) {
              BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(7, 0L, 0L);
            }
            if (((paramMessage.arg1 == 2) || (paramMessage.arg1 == 3) || (paramMessage.arg1 == 0)) && ((paramMessage.arg2 == 4) || (paramMessage.arg2 == 6)))
            {
              QQAppInterface.a().onAppBackground();
              acek.a().onAppBackground();
            }
            if (this.random == null) {
              this.random = new Random();
            }
            if (this.random.nextInt(20000) != 0) {
              continue;
            }
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("before", acfo.eg[paramMessage.arg1]);
            ((HashMap)localObject1).put("after", acfo.eg[paramMessage.arg2]);
            report("GM_guardChangeS", (HashMap)localObject1);
            return true;
          }
          catch (Throwable paramMessage)
          {
            return true;
          }
          int i = paramMessage.arg1;
          if (paramMessage.arg1 < 3) {
            Jd(i);
          }
          this.jdField_a_of_type_Acfo.y(i, paramMessage.obj);
          return true;
          this.mHandler.sendEmptyMessageDelayed(5, 12000L);
          this.jdField_a_of_type_Acfo.cHe();
          return true;
          if (!aak()) {
            continue;
          }
          x(this.cvL + 1, "trick_p_msg");
          return true;
          x(paramMessage.arg1, paramMessage.obj);
          return true;
        }
        catch (Throwable localThrowable2)
        {
          break label279;
        }
      }
      catch (Throwable localThrowable1)
      {
        break label114;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = paramIntent.getAction();
      String str = paramIntent.getStringExtra("runningProcessName");
      long l = paramIntent.getLongExtra("runningtime", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, paramContext + " received with " + str + " at " + l + ", when " + this.PK + ", " + this.PJ);
      }
      if ((str != null) && ((str.equals("com.tencent.tim")) || (str.startsWith("com.tencent.tim:")))) {
        if ("com.tencent.process.stopping".equals(paramContext))
        {
          if ((l >= this.PK) || (l < this.PK - 1000000L) || (l < 0L))
          {
            this.PK = l;
            paramContext = this.mHandler.obtainMessage(1, str);
            this.mHandler.sendMessageDelayed(paramContext, 50L);
          }
        }
        else if (("com.tencent.process.starting".equals(paramContext)) && ((l >= this.PJ) || (l < this.PK - 1000000L) || (l < 0L)))
        {
          this.PJ = l;
          paramContext = this.mHandler.obtainMessage(2, str);
          this.mHandler.sendMessage(paramContext);
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.d("GuardManager", 1, "", paramContext);
    }
  }
  
  public void report(String paramString, HashMap<String, String> paramHashMap)
  {
    anpc localanpc = anpc.a(BaseApplication.getContext());
    paramHashMap.put("config", acfn.a().aJT);
    localanpc.collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void startTimer()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "startTimer");
    }
    this.mHandler.removeMessages(5);
    this.mHandler.sendEmptyMessageDelayed(5, 12000L);
  }
  
  public void x(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == ThreadManager.getFileThreadLooper())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "nextState: " + acfo.eg[this.cvL] + ", " + acfo.eg[paramInt] + ", " + paramObject);
      }
      if (this.cvL == 8) {
        return;
      }
      if (this.cvL != paramInt)
      {
        Message localMessage = this.mHandler.obtainMessage(3, this.cvL, paramInt);
        this.mHandler.sendMessageDelayed(localMessage, 1000L);
        this.jdField_a_of_type_Acfo = a(paramInt);
        this.cvL = paramInt;
      }
      for (;;)
      {
        this.jdField_a_of_type_Acfo.y(5, paramObject);
        return;
        if (paramInt == 0) {
          this.jdField_a_of_type_Acfo = a(paramInt);
        }
      }
    }
    this.mHandler.obtainMessage(6, paramInt, 0, paramObject).sendToTarget();
  }
  
  public void y(int paramInt, Object paramObject)
  {
    this.mHandler.obtainMessage(4, paramInt, 0, paramObject).sendToTarget();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "state change:" + paramInt);
      }
      return;
      isForeground = true;
      q(this.mContext, "daily_boot_report", 0);
      v(this.mContext, isForeground);
      aogc.a(null);
      acyn.Kp(1);
      continue;
      isForeground = false;
      q(this.mContext, "daily_boot_report", 0);
      v(this.mContext, isForeground);
      acyn.Kp(2);
    }
  }
  
  public void yR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "cancelTimer");
    }
    this.mHandler.removeMessages(5);
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, paramContext);
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        if (GuardManager.this.mStartTime > 0L) {
          GuardManager.this.ET(false);
        }
        adrh.onBackground();
      }
      while (!"android.intent.action.SCREEN_ON".equals(paramContext)) {
        return;
      }
      if ((GuardManager.this.mStartTime == 0L) && (GuardManager.this.bok != null)) {
        GuardManager.this.mStartTime = SystemClock.uptimeMillis();
      }
      adrh.cTW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardManager
 * JD-Core Version:    0.7.0.1
 */