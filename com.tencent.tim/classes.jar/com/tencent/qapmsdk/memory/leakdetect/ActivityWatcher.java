package com.tencent.qapmsdk.memory.leakdetect;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Instrumentation;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActivityWatcher
{
  private static final String TAG = "QAPM_memory_ActivityWatcher";
  @Nullable
  private static Object sCurrentActivityThread = null;
  private static boolean sMonitoring = false;
  @Nullable
  private static Instrumentation sOldInstr = null;
  
  private static void afterOnDestroy(@NonNull Activity paramActivity)
  {
    ActivityLeakSolution.fixInputMethodManagerLeak(paramActivity);
    ActivityLeakSolution.fixAudioManagerLeak(paramActivity);
    try
    {
      if (!PluginController.INSTANCE.canCollect(PluginCombination.leakPlugin.plugin)) {
        return;
      }
      LeakInspector.startInspect(paramActivity, "");
      return;
    }
    catch (Exception paramActivity)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", paramActivity);
    }
  }
  
  private static boolean replaceInstrumentation()
  {
    if (sMonitoring) {
      return false;
    }
    try
    {
      Method localMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
      localMethod.setAccessible(true);
      sCurrentActivityThread = localMethod.invoke(null, new Object[] { null });
      if (sCurrentActivityThread == null) {
        throw new IllegalStateException("Failed to invoke currentActivityThread");
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localClassNotFoundException);
      bool = false;
      return bool;
      Object localObject = sCurrentActivityThread.getClass().getDeclaredField("mInstrumentation");
      ((Field)localObject).setAccessible(true);
      localObject = (Instrumentation)((Field)localObject).get(sCurrentActivityThread);
      if (localObject == null) {
        throw new IllegalStateException("Failed to get mInstrumentation.");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localNoSuchMethodException);
        bool = false;
      }
      if (!localNoSuchMethodException.getClass().equals(Instrumentation.class)) {
        throw new IllegalStateException("Not an Instrumentation instance. Maybe something is modified in this system.");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localIllegalArgumentException);
        bool = false;
      }
      if (localIllegalArgumentException.getClass().equals(MonitorInstrumentation.class)) {
        throw new RuntimeException("Buddy you already hacked the system.");
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localIllegalAccessException);
        bool = false;
        continue;
        sOldInstr = localIllegalAccessException;
        Field localField = sCurrentActivityThread.getClass().getDeclaredField("mInstrumentation");
        localField.setAccessible(true);
        localField.set(sCurrentActivityThread, new MonitorInstrumentation(null));
        sMonitoring = true;
        bool = true;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localInvocationTargetException);
        bool = false;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localNoSuchFieldException);
        bool = false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localException);
        boolean bool = false;
      }
    }
  }
  
  @TargetApi(14)
  public static boolean startActivityInspect()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      LifecycleCallback.INSTANCE.register(new ActivityWatcher.1());
      return true;
    }
    return replaceInstrumentation();
  }
  
  static class MonitorInstrumentation
    extends Instrumentation
  {
    public void callActivityOnDestroy(@NonNull Activity paramActivity)
    {
      ActivityWatcher.sOldInstr.callActivityOnDestroy(paramActivity);
      ActivityWatcher.afterOnDestroy(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.ActivityWatcher
 * JD-Core Version:    0.7.0.1
 */