package com.tencent.qapmsdk.looper;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Printer;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Field;
import java.util.HashMap;

public class LooperMonitor
  extends QAPMMonitorPlugin
{
  private static final String TAG = "QAPM_looper_LooperMonitor";
  @NonNull
  static HashMap<String, MonitorInfo> monitorMap = new HashMap();
  @NonNull
  private static IMonitorCallback sMonitorCallback = new LooperMonitor.1();
  
  private static Printer getMainPrinter()
  {
    try
    {
      Object localObject = Looper.class.getDeclaredField("mLogging");
      ((Field)localObject).setAccessible(true);
      localObject = (Printer)((Field)localObject).get(Looper.getMainLooper());
      Logger.INSTANCE.i(new String[] { "QAPM_looper_LooperMonitor", "getMainPrinter: originalLogging:" + localObject });
      if (localObject != null) {
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_looper_LooperMonitor", "getMainPrinter error:", localException);
    }
    return null;
  }
  
  public static boolean setMonitoredThread(@Nullable Thread paramThread, IMonitorCallback paramIMonitorCallback)
  {
    if (paramThread == null) {
      return false;
    }
    String str = paramThread.getName();
    try
    {
      MonitorInfo localMonitorInfo = (MonitorInfo)monitorMap.get(str);
      if (localMonitorInfo != null)
      {
        if (localMonitorInfo.stackGetter == null)
        {
          localMonitorInfo.stackGetter = new GetStackRunnable(paramThread);
          new Thread(localMonitorInfo.stackGetter, "get-stack-" + str).start();
          localMonitorInfo.stackGetterInited = true;
          localMonitorInfo.callback = paramIMonitorCallback;
          return true;
        }
        return false;
      }
      localMonitorInfo = new MonitorInfo();
      localMonitorInfo.stackGetter = new GetStackRunnable(paramThread);
      localMonitorInfo.stackGetterInited = true;
      localMonitorInfo.callback = paramIMonitorCallback;
      monitorMap.put(str, localMonitorInfo);
      new Thread(localMonitorInfo.stackGetter, "get-stack-" + str).start();
      return true;
    }
    finally {}
  }
  
  public void start()
  {
    if (!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin)) {
      return;
    }
    Object localObject = Looper.getMainLooper().getThread();
    setMonitoredThread((Thread)localObject, sMonitorCallback);
    localObject = new LooperPrinter(((Thread)localObject).getName());
    LooperPrinter.looperThreshold = PluginCombination.loopStackPlugin.threshold;
    Printer localPrinter = getMainPrinter();
    if (localPrinter != null) {
      ((LooperPrinter)localObject).setOriginalPrinter(localPrinter);
    }
    Looper.getMainLooper().setMessageLogging((Printer)localObject);
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.LooperMonitor
 * JD-Core Version:    0.7.0.1
 */