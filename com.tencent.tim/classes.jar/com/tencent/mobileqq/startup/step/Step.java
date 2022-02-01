package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import anmo;
import auvk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class Step
  implements Runnable
{
  public static final int STEP_BROADCAST_REPORT_REGISTER = 45;
  public static final int STEP_DO_LOAD_DEX = 4;
  public static final int STEP_GDT_INITIALIZE_ON_TOOL_PROCESS = 49;
  public static final int STEP_GROUP = 0;
  public static final int STEP_HACK_ALL_VM = 44;
  public static final int STEP_HACK_AVM = 43;
  public static final int STEP_HACK_DVM = 42;
  public static final int STEP_HUAYANG_PLUGIN_CONTAINER = 38;
  public static final int STEP_INIT_HOOK = 30;
  public static final int STEP_INIT_MAGNIFIERSDK = 16;
  public static final int STEP_INIT_SKIN = 11;
  public static final int STEP_INJECT_BITMAP_PATCH = 33;
  public static final int STEP_INSTALL_OPTIMZIED_PLUGINS = 37;
  public static final int STEP_LOAD_DATA = 7;
  public static final int STEP_LOAD_MODULE = 6;
  public static final int STEP_LOAD_OTHER = 18;
  public static final int STEP_LOAD_UI = 17;
  public static final int STEP_MANAGE_THREAD = 15;
  public static final int STEP_MEMORY_CACHE = 8;
  public static final int STEP_MIGRATE_SUBSCRIBE_DB = 34;
  public static final int STEP_MONITOR_QZONE_STARTUP = 40;
  public static final int STEP_MORE_DATA = 19;
  public static final int STEP_NEW_RUNTIME = 5;
  public static final int STEP_NOW_LIVE_CONTAINER = 47;
  public static final int STEP_OLD_ONCREATE = 9;
  public static final int STEP_OPEN_THRED_CREATE_HOOK = 41;
  public static final int STEP_PRE_INIT_VALUES = 32;
  public static final int STEP_QQLIVE_AND_STUDY_ROOM_PLUGIN = 48;
  public static final int STEP_QZONE_HOOK_THREAD = 39;
  public static final int STEP_QZONE_PERFORMANCE_TRACER = 20;
  public static final int STEP_RDM = 14;
  public static final int STEP_RECORD_REPORT_REGISTER = 46;
  public static final int STEP_SET_PERMISSION = 3;
  public static final int STEP_SET_PLUGIN = 27;
  public static final int STEP_SET_SPLASH = 2;
  public static final int STEP_START_SERVICE = 10;
  public static final int STEP_START_SERVICE_LITE = 21;
  public static final int STEP_START_SERVICE_LITE_CMP = 22;
  public static final int STEP_TRY_LOAD_DEX = 1;
  public static final int STEP_UPDATE = 13;
  public static final int STEP_UPDATE_ARKSO = 25;
  public static final int STEP_UPDATE_AVSO = 24;
  public static final int STEP_UPDATE_BUBBLE = 23;
  public static final int STEP_UPDATE_PATCH_CONFIG = 35;
  public static final int STEP_UPDATE_PLUGIN_VERSION = 28;
  public static final int STEP_UPDATE_RMSO = 26;
  public static final int STEP_UPDATE_SECURE_FILE_STRATEGY = 36;
  public static final int STEP_UPGRAD_DB = 31;
  public static final int STEP_URL_DRAWABLE = 12;
  public static final int STEP_WEBP = 29;
  public anmo mDirector;
  private Handler mHandler;
  protected int mId;
  protected String mName;
  private int mResultMessage;
  private int[] mStepIds;
  
  protected boolean doStep()
  {
    if (this.mId == 0)
    {
      int[] arrayOfInt = this.mStepIds;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (!a.b(arrayOfInt[i], this.mDirector, null).step()) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public void run()
  {
    step();
  }
  
  public void setResultListener(Handler paramHandler, int paramInt)
  {
    this.mHandler = paramHandler;
    this.mResultMessage = paramInt;
  }
  
  public boolean step()
  {
    long l = 0L;
    int i = 5;
    Thread localThread = null;
    if (this.mHandler != null)
    {
      localThread = Thread.currentThread();
      i = localThread.getPriority();
      localThread.setPriority(10);
    }
    if (anmo.TRACE)
    {
      l = SystemClock.uptimeMillis();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label170;
      }
      auvk.traceBegin(this.mName);
    }
    for (;;)
    {
      boolean bool1 = false;
      try
      {
        boolean bool2 = doStep();
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "", localThrowable);
          continue;
          auvk.q(4096L, this.mName, Process.myTid());
        }
      }
      if (anmo.TRACE)
      {
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        auvk.traceEnd();
        Log.i("AutoMonitor", this.mName + ", cost=" + (SystemClock.uptimeMillis() - l) + " results: " + bool1);
      }
      if (this.mHandler != null)
      {
        this.mHandler.obtainMessage(this.mResultMessage, Boolean.valueOf(bool1)).sendToTarget();
        localThread.setPriority(i);
      }
      return bool1;
      label170:
      auvk.p(4096L, this.mName, Process.myTid());
    }
  }
  
  public static class AfterDexStepFactory
    implements Step.b
  {
    public Step a(int paramInt, anmo paramanmo, int[] paramArrayOfInt)
    {
      paramanmo = null;
      switch (paramInt)
      {
      case 8: 
      case 9: 
      case 10: 
      case 13: 
      case 21: 
      default: 
        paramanmo = new Step();
      case 31: 
        return paramanmo;
      case 7: 
      case 19: 
        return new LoadData();
      case 5: 
        return new NewRuntime();
      case 6: 
        return new LoadModule();
      case 11: 
        return new InitSkin();
      case 12: 
        return new InitUrlDrawable();
      case 14: 
        return new Rdm();
      case 15: 
        return new ManageThread();
      case 17: 
        return new LoadUi();
      case 18: 
        return new LoadOtherStuff();
      case 20: 
        return new InitQzoneTracer();
      case 22: 
        return new StartServiceLiteCmp();
      case 23: 
        return new UpdateBubbleZip();
      case 24: 
        return new AVSoUtils();
      case 25: 
        return new UpdateArkSo();
      case 26: 
        return new UpdateRMSo();
      case 27: 
        return new SetPlugin();
      case 28: 
        return new UpdatePluginVersion();
      case 29: 
        return new WebP();
      case 32: 
        return new PreInitValues();
      case 16: 
        return new InitMagnifierSDK();
      case 30: 
        return new InitHook();
      case 33: 
        return new InjectBitmap();
      case 34: 
        return new MigrateSubscribeDB();
      case 35: 
        return new UpdatePatchConfig();
      case 36: 
        return new UpdateSecureFileStrategy();
      case 37: 
        return new InstallPlugins();
      case 38: 
        return new HuayangPluginContainer();
      case 48: 
        return new StudyRoomPluginContainer();
      case 39: 
        return new ThreadHookStep();
      case 40: 
        return new QzoneTracer();
      case 41: 
        return new OpenThreadCreateHook();
      case 42: 
      case 43: 
      case 44: 
        return new HackVm();
      case 45: 
        return new BroadcastReportRegister();
      case 46: 
        return RecordTracer.a();
      case 47: 
        return new NowliveContainer();
      }
      return new GdtInitializeOnToolProcessStep();
    }
  }
  
  public static class a
    implements Step.b
  {
    private static Step.b a;
    
    public static Step b(int paramInt, anmo paramanmo, int[] paramArrayOfInt)
    {
      Object localObject;
      switch (paramInt)
      {
      case 5: 
      case 6: 
      case 7: 
      case 11: 
      case 12: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      default: 
        if (a != null) {
          localObject = a.a(paramInt, paramanmo, paramArrayOfInt);
        }
        break;
      }
      for (;;)
      {
        ((Step)localObject).mId = paramInt;
        ((Step)localObject).mDirector = paramanmo;
        if (paramInt == 0) {
          Step.access$002((Step)localObject, paramArrayOfInt);
        }
        return localObject;
        localObject = new LoadDex();
        continue;
        localObject = new InitMemoryCache();
        continue;
        localObject = new OldApplication();
        continue;
        localObject = new SetSplash();
        continue;
        localObject = new CheckPermission();
        continue;
        localObject = new Update();
        continue;
        localObject = new StartService();
        continue;
        localObject = new Step();
      }
    }
    
    public static void dRW()
      throws Exception
    {
      a = (Step.b)BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.startup.step.Step$AfterDexStepFactory").newInstance();
    }
    
    public Step a(int paramInt, anmo paramanmo, int[] paramArrayOfInt)
    {
      return null;
    }
  }
  
  public static abstract interface b
  {
    public abstract Step a(int paramInt, anmo paramanmo, int[] paramArrayOfInt);
  }
  
  public static class c
  {
    public static void dRX()
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIPCEnvironmentInit", 2, "tryConnect");
      }
      try
      {
        Method localMethod = BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.qipc.QIPCEnvironmentInit").getDeclaredMethod("initEnvironment", new Class[0]);
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QIPCEnvironmentInit", 2, "tryConnect", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step
 * JD-Core Version:    0.7.0.1
 */