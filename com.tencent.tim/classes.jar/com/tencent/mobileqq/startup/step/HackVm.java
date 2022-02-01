package com.tencent.mobileqq.startup.step;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dalvik.DalvikReplacer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import mqq.os.MqqHandler;

public class HackVm
  extends Step
{
  public static long amw = Runtime.getRuntime().maxMemory();
  public static long amx;
  public static int dKj;
  public static int dKk;
  public static int sHeapResult;
  public static int sVerifyResult;
  
  @SuppressLint({"InlinedApi"})
  public boolean ayx()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_hack_dvm", 4);
    int j = localSharedPreferences.getInt("key_continuous_crash_count", 0);
    int i = j;
    if (j < 4)
    {
      i = j;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        i = j;
        if (localSharedPreferences.getLong("key_last_hack_time", 0L) > 0L)
        {
          i = j + 1;
          localSharedPreferences.edit().putInt("key_continuous_crash_count", i).commit();
        }
      }
    }
    boolean bool1;
    if (i < 4) {
      bool1 = true;
    }
    try
    {
      String str = System.getProperty("java.vm.version");
      bool2 = bool1;
      if (str != null)
      {
        boolean bool3 = str.startsWith("2");
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
      if ((bool2) && (BaseApplicationImpl.sProcessId == 1)) {
        localSharedPreferences.edit().putLong("key_last_hack_time", System.currentTimeMillis()).commit();
      }
      if (bool2)
      {
        long l = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
        amx = Math.min(Runtime.getRuntime().maxMemory() * 2L, l);
        amx = Math.min(amx, 201326592L);
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        for (;;)
        {
          DalvikReplacer.dvmHack(BaseApplicationImpl.sApplication, 26214400, bool2, amx);
          QLog.e("QQAppInterface", 1, new Object[] { "laResult: ", Integer.valueOf(DalvikReplacer.sLaResult), ", verifyResult: ", Integer.valueOf(DalvikReplacer.sVerifyResult), ", heapResult = ", Integer.valueOf(DalvikReplacer.sHeapResult), ", modHeap = " + amx });
          dKj = DalvikReplacer.sLaResult;
          if (bool2)
          {
            sVerifyResult = DalvikReplacer.sVerifyResult;
            sHeapResult = DalvikReplacer.sHeapResult;
          }
          if ((bool2) && (BaseApplicationImpl.sProcessId == 1)) {
            ThreadManager.getSubThreadHandler().postDelayed(new HackVm.1(this), 5000L);
          }
          return true;
          bool1 = false;
        }
        localThrowable2 = localThrowable2;
        boolean bool2 = bool1;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "dvmHack error", localThrowable1);
        }
      }
    }
  }
  
  public void dRK()
  {
    if (Build.VERSION.SDK_INT <= 20) {}
    try
    {
      String str = System.getProperty("java.vm.version");
      if ((str != null) && (str.startsWith("2"))) {
        ly(134217728L);
      }
      return;
    }
    catch (Throwable localThrowable) {}
    if (Build.VERSION.SDK_INT < 23)
    {
      ly(134217728L);
      return;
    }
    dRL();
    return;
  }
  
  public void dRL()
  {
    if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 2)) {}
    for (;;)
    {
      return;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_hack_dvm", 4);
      int j = localSharedPreferences.getInt("key_art_continuous_crash_count", 0);
      int i = j;
      if (j < 4)
      {
        i = j;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          i = j;
          if (localSharedPreferences.getLong("key_last_hack_art_time", 0L) > 0L)
          {
            i = j + 1;
            localSharedPreferences.edit().putInt("key_art_continuous_crash_count", i).commit();
          }
        }
      }
      if (i < 4)
      {
        i = 1;
        if ((i == 0) || (amw >= 201326592L)) {
          continue;
        }
        long l = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
        amx = Math.min(amw * 2L, l);
        if (amx <= amw) {
          continue;
        }
        if (BaseApplicationImpl.sProcessId == 1) {
          localSharedPreferences.edit().putLong("key_last_hack_art_time", System.currentTimeMillis()).commit();
        }
      }
      try
      {
        DalvikReplacer.artHack(BaseApplicationImpl.sApplication, amw, amx);
        QLog.e("HACK_ART_MEM", 1, new Object[] { "hackArtResult = ", Integer.valueOf(DalvikReplacer.sArtHackResult), ", modHeap = " + amx });
        dKk = DalvikReplacer.sArtHackResult;
        if (BaseApplicationImpl.sProcessId != 1) {
          continue;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new HackVm.2(this), 5000L);
        return;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("HACK_ART_MEM", 1, "ArtHack error", localThrowable);
        }
      }
    }
  }
  
  protected boolean doStep()
  {
    if ((Build.VERSION.SDK_INT <= 20) && ((this.mId == 42) || (this.mId == 44))) {
      ayx();
    }
    if ((Build.VERSION.SDK_INT < 24) && ((this.mId == 43) || (this.mId == 44))) {
      dRK();
    }
    return true;
  }
  
  public void ly(long paramLong)
  {
    long l = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
    if (amw <= paramLong) {
      if (QLog.isColorLevel()) {
        QLog.d("HACK_ART_MEM", 2, "openLargeHeap|curMaxSize= " + amw + ",largeHeapSize=" + l);
      }
    }
    try
    {
      Object localObject2 = Class.forName("dalvik.system.VMRuntime");
      Object localObject1 = ((Class)localObject2).getMethod("getRuntime", new Class[0]).invoke(null, (Object[])null);
      localObject2 = ((Class)localObject2).getDeclaredMethod("clearGrowthLimit", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      ((Method)localObject2).invoke(localObject1, new Object[0]);
      amx = Runtime.getRuntime().maxMemory();
      dKk = 21;
      paramLong = Runtime.getRuntime().maxMemory();
      if (QLog.isColorLevel()) {
        QLog.d("HACK_ART_MEM", 2, "openLargeHeap|newMaxMemory= " + paramLong);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        dKk = -1;
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HackVm
 * JD-Core Version:    0.7.0.1
 */