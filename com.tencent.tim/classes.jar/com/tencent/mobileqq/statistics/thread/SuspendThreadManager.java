package com.tencent.mobileqq.statistics.thread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import anmo;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;

public class SuspendThreadManager
{
  private static ArrayList<Thread> AP = new ArrayList();
  private static ArrayList<Thread> AQ = new ArrayList();
  private static ArrayList<Thread> AR = new ArrayList();
  private static ArrayList<Thread> AS = new ArrayList();
  private static a jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a;
  private static volatile SuspendThreadManager jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager;
  private static HandlerThread ab;
  private static long anU = 20L;
  private static boolean cJr;
  private static boolean cJs;
  private static boolean cJu;
  private static int dLJ;
  private static int dLK;
  private static int dLL;
  private static int dLM = 3;
  private static int dLN = 3;
  private static int dLO;
  public static int dLP;
  private static Map<Integer, Thread> no = new HashMap();
  private static Map<Thread, Integer> np = new HashMap();
  private boolean cJt;
  
  private SuspendThreadManager(String paramString)
  {
    ab = new HandlerThread(paramString);
    ab.start();
    jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a = new a(ab.getLooper());
  }
  
  private void Qo(boolean paramBoolean)
  {
    int j;
    int i;
    Object localObject3;
    try
    {
      if (!AS.isEmpty()) {
        break label194;
      }
      Thread[] arrayOfThread = a();
      j = arrayOfThread.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      Vn(dLJ);
    }
    if ((!AQ.contains(localObject3)) && (!AR.contains(localObject3)) && (!localObject3.getName().contains("Binder")) && (!localObject3.getName().contains("RenderThread")) && (!localObject3.getName().contains("Automator")) && (!localObject3.getName().contains("thread_sp")) && (!localObject3.getName().contains("logWriteThread")) && (!localObject3.getName().contains("Bugly"))) {
      if ((localObject3.isAlive()) && (paramBoolean) && (AP.contains(localObject3)))
      {
        a().e(localObject3);
        synchronized (AS)
        {
          AS.add(localObject3);
        }
      }
    }
    label267:
    for (;;)
    {
      label194:
      return;
      if ((!paramBoolean) && (localObject3.isAlive()))
      {
        a().e(localObject3);
        synchronized (AS)
        {
          AS.add(localObject3);
        }
      }
      for (;;)
      {
        if (i >= j) {
          break label267;
        }
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void Vn(int paramInt)
  {
    cJu = false;
    synchronized (AS)
    {
      if (AS.isEmpty()) {
        break label71;
      }
      Iterator localIterator = AS.iterator();
      while (localIterator.hasNext()) {
        if (a((Thread)localIterator.next(), paramInt) == 2) {
          cJu = true;
        }
      }
    }
    AS.clear();
    label71:
  }
  
  private static int a(Thread paramThread)
  {
    int i;
    try
    {
      localObject = (Integer)np.get(paramThread);
      if ((localObject != null) && (((Integer)localObject).intValue() != 0)) {
        return ((Integer)localObject).intValue();
      }
      if (!cJs)
      {
        localObject = (Long)c(paramThread, "nativePeer");
        if (localObject != null)
        {
          i = ((Long)localObject).intValue();
          np.put(paramThread, Integer.valueOf(i));
          return i;
        }
      }
    }
    catch (Throwable paramThread)
    {
      QLog.e("TSManager", 1, "getNativeThreadAddr", paramThread);
    }
    while (!cJs) {
      return -1;
    }
    Object localObject = c(paramThread, "vmThread");
    if (localObject != null)
    {
      localObject = (Integer)e(localObject, "vmData");
      if (localObject != null)
      {
        i = ((Integer)localObject).intValue();
        np.put(paramThread, Integer.valueOf(i));
        return i;
      }
    }
    return 0;
  }
  
  private int a(Thread paramThread, int paramInt)
  {
    if (!cJs) {}
    for (paramInt = resumeThreadArt(a(paramThread), paramInt);; paramInt = resumeThreadDalvik(a(paramThread)))
    {
      if (-1 == paramInt) {
        QLog.i("TSManager", 1, "resumeThread Fail,thread = " + paramThread);
      }
      return paramInt;
    }
  }
  
  public static SuspendThreadManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager = new SuspendThreadManager("SuspendGuardThread");
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager;
    }
    finally {}
  }
  
  private String a(Thread paramThread, String paramString)
  {
    if (paramThread != null)
    {
      paramThread = paramThread.getStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reason:" + paramString + "\n");
      int i = 0;
      while ((i < paramThread.length) && (i < 30))
      {
        localStringBuilder.append(paramThread[i].toString());
        localStringBuilder.append("\n");
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static Thread[] a()
  {
    try
    {
      ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      return arrayOfThread;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("TSManager", 1, "getThreads", localThrowable);
    }
    return new Thread[0];
  }
  
  private static Object c(Object paramObject, String paramString)
  {
    try
    {
      paramString = Thread.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QLog.d("TSManager", 1, "getPrivateField", paramObject);
    }
    return null;
  }
  
  private static Object e(Object paramObject, String paramString)
  {
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QLog.e("TSManager", 1, "getDalvikPrivateField", paramObject);
    }
    return null;
  }
  
  private void e(Thread paramThread)
  {
    int j;
    if (!cJs)
    {
      j = suspendThreadArt(a(paramThread), dLJ);
      i = j;
      if (j != 0) {
        no.put(Integer.valueOf(j), paramThread);
      }
    }
    for (int i = j;; i = suspendThreadDalvik(a(paramThread)))
    {
      if (-1 == i) {
        QLog.i("TSManager", 1, "suspendThread Fail,thread = " + paramThread);
      }
      return;
    }
  }
  
  private native int getContentThreadIdArt(int paramInt);
  
  private static boolean isDalvikVm()
  {
    if ((Long)c(Thread.currentThread(), "nativePeer") != null)
    {
      QLog.i("TSManager", 1, "ART Mode");
      return false;
    }
    Object localObject = c(Thread.currentThread(), "vmThread");
    if (localObject != null)
    {
      localObject = (Integer)e(localObject, "vmData");
      if (localObject == null) {
        break label83;
      }
    }
    label83:
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      if (i != 0)
      {
        QLog.i("TSManager", 1, "Dalvik Mode");
        return true;
      }
      QLog.i("TSManager", 1, "default ART Mode");
      return false;
    }
  }
  
  private native int nativeInit(boolean paramBoolean, int paramInt);
  
  private native int resumeThreadArt(int paramInt1, int paramInt2);
  
  private native int resumeThreadDalvik(int paramInt);
  
  private native int suspendThreadArt(int paramInt1, int paramInt2);
  
  private native int suspendThreadDalvik(int paramInt);
  
  public void Qn(boolean paramBoolean)
  {
    if (!cJr)
    {
      QLog.i("TSManager", 1, "suspendThreads faild");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Boolean.valueOf(paramBoolean);
    jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a.sendMessage(localMessage);
  }
  
  public void d(Thread paramThread)
  {
    AP.add(paramThread);
  }
  
  public void dTe()
  {
    Object localObject = anmo.getLowDeviceSp();
    int i = ((SharedPreferences)localObject).getInt("suspendCrashCount", 0);
    localObject = ((SharedPreferences)localObject).edit();
    i += 1;
    QLog.d("TSManager", 1, "SuspendThreadManager has crashed " + i + " times");
    ((SharedPreferences.Editor)localObject).putInt("suspendCrashCount", i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void dTf()
  {
    if (!cJr)
    {
      QLog.i("TSManager", 1, "resumeThreads faild");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a.sendMessage(localMessage);
  }
  
  public void init()
  {
    if ((!this.cJt) && (jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a != null) && (ab != null))
    {
      jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a.obtainMessage(1).sendToTarget();
      this.cJt = true;
    }
  }
  
  class a
    extends Handler
  {
    private SuspendThreadManager.b a;
    private final File aO = new File(BaseApplicationImpl.getApplication().getFilesDir().getPath() + File.separator + "suspend_check_file");
    private HandlerThread ac;
    private boolean cJv;
    private boolean cJw;
    private boolean cJx;
    private boolean cJy;
    private int dLQ;
    private int dLR;
    private int dLS;
    private int dLT;
    private SharedPreferences k;
    private SharedPreferences.Editor mEditor;
    private Thread mMainThread;
    private Thread w;
    private final float zT = 0.1F;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private void Qp(boolean paramBoolean)
    {
      SuspendThreadManager.access$202(0);
      try
      {
        if (SuspendThreadManager.AS.isEmpty())
        {
          dTi();
          SuspendThreadManager.a(SuspendThreadManager.this, paramBoolean);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        k(localThrowable);
      }
    }
    
    private boolean ayM()
    {
      return this.aO.exists();
    }
    
    private void cT(String paramString, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        QLog.d("TSManager", 1, paramString + ",createCheckFile");
        if (!paramBoolean) {
          break label80;
        }
      }
      for (;;)
      {
        try
        {
          if (!this.aO.exists()) {
            this.aO.createNewFile();
          }
          return;
        }
        catch (IOException paramString)
        {
          label80:
          QLog.e("TSManager", 1, "createOrDelSuspendCheckFile failed", paramString);
        }
        QLog.d("TSManager", 1, paramString + ",deleteCheckFile");
        break;
        if (this.aO.exists())
        {
          this.aO.delete();
          return;
        }
      }
    }
    
    private void dTg()
    {
      if (this.aO.exists()) {
        this.aO.delete();
      }
    }
    
    private void dTh()
    {
      SuspendThreadManager.a().d(ThreadManager.getSubThread());
      SuspendThreadManager.a().d(ThreadManager.getRecentThread());
      Thread[] arrayOfThread = SuspendThreadManager.b();
      int j = arrayOfThread.length;
      int i = 0;
      while (i < j)
      {
        Thread localThread = arrayOfThread[i];
        if (localThread.getName().equals("MSF-Receiver")) {
          SuspendThreadManager.a().d(localThread);
        }
        i += 1;
      }
    }
    
    private void dTi()
    {
      synchronized (SuspendThreadManager.AS)
      {
        SuspendThreadManager.AS.clear();
        SuspendThreadManager.ay().clear();
        SuspendThreadManager.az().clear();
        cT("preSuspendThread", true);
        this.dLS = 0;
        dTl();
        this.a.dTr();
        return;
      }
    }
    
    private void dTj()
    {
      SuspendThreadManager.access$202(0);
      if (SuspendThreadManager.AS.size() > 0)
      {
        SuspendThreadManager.a(SuspendThreadManager.this, SuspendThreadManager.dLJ);
        Vo(1);
      }
    }
    
    private void dTk()
    {
      if (SuspendThreadManager.AS.size() > 0)
      {
        SuspendThreadManager.a(SuspendThreadManager.this, SuspendThreadManager.dLJ);
        Vo(2);
      }
    }
    
    private void dTl()
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      sendMessageDelayed(localMessage, SuspendThreadManager.hc());
    }
    
    private void dTm()
    {
      SuspendThreadManager.access$202(0);
      if (SuspendThreadManager.AS.size() > 0)
      {
        ??? = this.mMainThread.getState();
        this.dLS += 1;
        if (??? != Thread.State.BLOCKED) {
          break label224;
        }
        if ((!this.cJw) && (!SuspendThreadManager.cJs) && (!SuspendThreadManager.ay().isEmpty())) {
          break label134;
        }
        if (this.cJx)
        {
          ??? = SuspendThreadManager.a(SuspendThreadManager.this, this.mMainThread, "Blocked");
          if (this.mEditor != null)
          {
            this.mEditor.putString("main_thread_stack", (String)???);
            this.mEditor.commit();
          }
        }
        dTk();
      }
      label134:
      label320:
      for (;;)
      {
        if (!SuspendThreadManager.AS.isEmpty()) {
          dTl();
        }
        return;
        int i = SuspendThreadManager.a(SuspendThreadManager.a(), SuspendThreadManager.dLK);
        Thread localThread1 = (Thread)SuspendThreadManager.ay().get(Integer.valueOf(i));
        if ((localThread1 != null) && (SuspendThreadManager.AS.contains(localThread1)))
        {
          i = SuspendThreadManager.a(SuspendThreadManager.a(), localThread1, SuspendThreadManager.dLJ);
          if ((1 != i) && (2 != i)) {}
        }
        synchronized (SuspendThreadManager.AS)
        {
          SuspendThreadManager.AS.remove(localThread1);
          this.cJw = true;
        }
        label224:
        if ((??? == Thread.State.WAITING) || (??? == Thread.State.TIMED_WAITING))
        {
          if (this.cJv)
          {
            SuspendThreadManager localSuspendThreadManager;
            Thread localThread2;
            if (this.cJx)
            {
              localSuspendThreadManager = SuspendThreadManager.this;
              localThread2 = this.mMainThread;
              if (??? != Thread.State.WAITING) {
                break label320;
              }
            }
            for (??? = "Waiting";; ??? = "TimedWaiting")
            {
              ??? = SuspendThreadManager.a(localSuspendThreadManager, localThread2, (String)???);
              if (this.mEditor != null)
              {
                this.mEditor.putString("main_thread_stack", (String)???);
                this.mEditor.commit();
              }
              dTk();
              break;
            }
          }
          this.cJv = true;
        }
        else
        {
          this.cJv = false;
          this.cJw = false;
          if (this.dLS * SuspendThreadManager.hc() > 1000L)
          {
            dTk();
            this.dLS = 0;
          }
        }
      }
    }
    
    private void dTo()
    {
      Vo(3);
    }
    
    private void dTp()
    {
      long l = System.currentTimeMillis();
      HashMap localHashMap;
      if (l - this.k.getLong("last_report_time", 0L) > 86400000L)
      {
        localHashMap = new HashMap(10);
        localHashMap.put("api_support_cond", String.valueOf(this.dLT));
        localHashMap.put("resume_count", String.valueOf(this.k.getInt("normal_resume_count", 0)));
        localHashMap.put("timeout_count", String.valueOf(this.k.getInt("timeout_resume_count", 0)));
        localHashMap.put("watchdog_count", String.valueOf(this.k.getInt("watchdog_resume_count", 0)));
        localHashMap.put("main_thread_stack", this.k.getString("main_thread_stack", ""));
        localHashMap.put("not_resume_count", String.valueOf(this.dLQ));
        localHashMap.put("crash_count", String.valueOf(this.dLR));
        localHashMap.put("report_time", String.valueOf(System.currentTimeMillis()));
        localHashMap.put("suspend_error_count", String.valueOf(this.k.getInt("suspend_error_count", 0)));
        localHashMap.put("resume_error_count", String.valueOf(this.k.getInt("resume_error_count", 0)));
        if (!this.cJy) {
          break label402;
        }
      }
      label402:
      for (Object localObject = "1";; localObject = "-1")
      {
        localHashMap.put("fake_suspend", localObject);
        localObject = "";
        try
        {
          String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          localObject = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("TSManager", 1, "getAccount faild ！！！");
          }
        }
        localHashMap.put("qq_num", localObject);
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject, "suspendThreadMonitor", true, this.dLT, 0L, localHashMap, null);
        this.mEditor.putLong("last_report_time", l);
        this.mEditor.putInt("normal_resume_count", 0);
        this.mEditor.putInt("timeout_resume_count", 0);
        this.mEditor.putInt("suspend_error_count", 0);
        this.mEditor.putInt("resume_error_count", 0);
        this.mEditor.commit();
        return;
      }
    }
    
    private void dTq()
    {
      HashMap localHashMap = new HashMap(10);
      localHashMap.put("not_resume_count", String.valueOf(this.dLQ));
      localHashMap.put("not_resume_time", String.valueOf(System.currentTimeMillis()));
      if (this.cJy) {}
      for (Object localObject = "1";; localObject = "-1")
      {
        localHashMap.put("fake_suspend", localObject);
        localObject = "";
        try
        {
          String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          localObject = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("TSManager", 1, "getAccount faild ！！！");
          }
        }
        localHashMap.put("qq_num", localObject);
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject, "suspendThreadNotResume", true, 0L, 0L, localHashMap, null);
        return;
      }
    }
    
    private void init()
    {
      try
      {
        System.loadLibrary("threadsuspend");
        this.k = BaseApplicationImpl.sApplication.getSharedPreferences("suspend_thread_pref_file", 0);
        this.mEditor = this.k.edit();
        this.cJy = anmo.cID;
        boolean bool1;
        if ((Build.VERSION.SDK_INT <= 23) && (anmo.cIC))
        {
          SuspendThreadManager.dLP |= 0x1;
          bool1 = true;
          this.dLR = this.k.getInt("suspendCrashCount", 0);
          if (this.dLR > SuspendThreadManager.dLM)
          {
            SuspendThreadManager.dLP |= 0x8;
            bool1 = false;
          }
          this.dLQ = this.k.getInt("notResumeCountNew", 0);
          if (ayM())
          {
            this.dLQ += 1;
            this.mEditor.putInt("notResumeCountNew", this.dLQ);
            this.mEditor.commit();
            dTq();
          }
          dTg();
          if (this.dLQ <= SuspendThreadManager.dLN) {
            break label598;
          }
          SuspendThreadManager.dLP |= 0x10;
          bool1 = false;
        }
        for (;;)
        {
          QLog.d("TSManager", 1, "mCurrentNotResumeCount = " + this.dLQ + ",mCurrentCrashCount = " + this.dLR + ",tempInitedSuccessful = " + bool1);
          if (bool1)
          {
            Process.setThreadPriority(-2);
            if (Math.random() >= 0.1000000014901161D) {
              break label567;
            }
          }
          label567:
          for (boolean bool2 = true;; bool2 = false)
          {
            this.cJx = bool2;
            SuspendThreadManager.access$702(SuspendThreadManager.access$800());
            this.mMainThread = Looper.getMainLooper().getThread();
            this.w = SuspendThreadManager.f().getLooper().getThread();
            this.ac = new HandlerThread("suspendWatchdogThread");
            this.ac.start();
            this.a = new SuspendThreadManager.b(SuspendThreadManager.this, this.ac.getLooper(), Thread.currentThread(), this);
            SuspendThreadManager.access$002(SuspendThreadManager.b(this.ac));
            SuspendThreadManager.gL(SuspendThreadManager.b(SuspendThreadManager.f()));
            SuspendThreadManager.ft(SuspendThreadManager.b(this.mMainThread));
            this.dLT = SuspendThreadManager.a(SuspendThreadManager.this, SuspendThreadManager.cJs, SuspendThreadManager.dLJ);
            dTp();
            SuspendThreadManager.AR.add(this.mMainThread);
            SuspendThreadManager.AR.add(this.w);
            SuspendThreadManager.AR.add(this.ac);
            dTh();
            SuspendThreadManager.bq(bool1);
            QLog.i("TSManager", 1, "init finished:mNativeApiSupportValue = " + this.dLT + ",sGuardThreadNativeAddr = " + SuspendThreadManager.dLJ + ",sMainThreadNativeAddr = " + SuspendThreadManager.dLK + ",mFetchMainStackThisTime = " + this.cJx + ",bDalvikVm = " + SuspendThreadManager.cJs + ",sInitedSuccessful = " + SuspendThreadManager.adT() + ",bIsFakeSuspendUser = " + this.cJy);
            return;
            if (Build.VERSION.SDK_INT >= 24) {
              SuspendThreadManager.dLP |= 0x2;
            }
            bool1 = false;
            break;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TSManager", 1, "libthreadsuspend load failed !!!", localThrowable);
        SuspendThreadManager.bq(false);
        SuspendThreadManager.dLP |= 0x20;
        return;
      }
    }
    
    private void k(Throwable paramThrowable)
    {
      int i = this.k.getInt("suspend_error_count", 0);
      this.mEditor.putInt("suspend_error_count", i + 1);
      this.mEditor.commit();
      SuspendThreadManager.a(SuspendThreadManager.this, SuspendThreadManager.dLJ);
    }
    
    public void Vo(int paramInt)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (SuspendThreadManager.ri())
        {
          paramInt = this.k.getInt("resume_error_count", 0);
          this.mEditor.putInt("resume_error_count", paramInt + 1);
          SuspendThreadManager.br(false);
        }
        this.mEditor.commit();
        return;
        paramInt = this.k.getInt("normal_resume_count", 0);
        this.mEditor.putInt("normal_resume_count", paramInt + 1);
        this.a.dTs();
        cT("afterResumeThread Normal", false);
        continue;
        paramInt = this.k.getInt("timeout_resume_count", 0);
        this.mEditor.putInt("timeout_resume_count", paramInt + 1);
        this.a.dTs();
        cT("afterResumeThread Timeout", false);
        continue;
        paramInt = this.k.getInt("watchdog_resume_count", 0);
        this.mEditor.putInt("watchdog_resume_count", paramInt + 1);
        this.a.dTs();
        if (SuspendThreadManager.dLO == 1)
        {
          cT("afterResumeThread Watchdog", false);
          SuspendThreadManager.access$202(0);
        }
      }
    }
    
    public void dTn()
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      sendMessage(localMessage);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.obj != null) {}
      for (boolean bool = ((Boolean)paramMessage.obj).booleanValue();; bool = false)
      {
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          init();
          return;
        case 2: 
          if (!this.cJy)
          {
            Qp(bool);
            return;
          }
          cT("fake preSuspendThread", true);
          return;
        case 3: 
          if (!this.cJy)
          {
            dTj();
            return;
          }
          cT("fake afterResumeThread Normal", false);
          return;
        case 4: 
          if (!this.cJy)
          {
            dTm();
            return;
          }
          cT("fake afterResumeThread Timeout", false);
          return;
        }
        if (!this.cJy)
        {
          dTo();
          return;
        }
        cT("fake afterResumeThread Watchdog", false);
        return;
      }
    }
  }
  
  class b
    extends Handler
  {
    private SuspendThreadManager.a jdField_b_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a;
    private boolean cJz;
    private Thread x;
    
    public b(Looper paramLooper, Thread paramThread, SuspendThreadManager.a parama)
    {
      super();
      this.x = paramThread;
      this.jdField_b_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a = parama;
    }
    
    public void dTr()
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      sendMessageDelayed(localMessage, 200L);
    }
    
    public void dTs()
    {
      removeMessages(1);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        if (this.x.getState() == Thread.State.BLOCKED)
        {
          if (this.cJz == true)
          {
            SuspendThreadManager.a(SuspendThreadManager.this, SuspendThreadManager.dLL);
            SuspendThreadManager.access$202(1);
            dTs();
            this.jdField_b_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager$a.dTn();
            return;
          }
          this.cJz = true;
          dTr();
          return;
        }
      } while (SuspendThreadManager.AS.isEmpty());
      this.cJz = false;
      dTr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.thread.SuspendThreadManager
 * JD-Core Version:    0.7.0.1
 */