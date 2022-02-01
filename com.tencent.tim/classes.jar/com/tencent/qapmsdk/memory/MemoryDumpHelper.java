package com.tencent.qapmsdk.memory;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MemoryDumpHelper
{
  private static final int MAX_THRESHOLD = 100;
  private static final String TAG = "QAPM_memory_MemoryDumpHelper";
  @NonNull
  private static HashMap<String, String> extraInfoMap = new HashMap();
  @Nullable
  private static volatile MemoryDumpHelper sInstance = null;
  
  private boolean canDumpMemory()
  {
    if (!NetworkWatcher.INSTANCE.isWifiAvailable())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "network is not wifi, don't dump" });
      return false;
    }
    if ((BaseInfo.sharePreference != null) && (BaseInfo.editor != null))
    {
      int i = BaseInfo.sharePreference.getInt(BaseInfo.userMeta.version, 0);
      if ((i < 1) || (MemoryCeilingMonitor.debug))
      {
        BaseInfo.editor.putInt(BaseInfo.userMeta.version, i + 1).apply();
        Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "this user don't have dumped" });
        return true;
      }
    }
    Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "this user have dumped." });
    return false;
  }
  
  public static DumpResult dump(String paramString, IMemoryDumpListener paramIMemoryDumpListener)
  {
    DumpResult localDumpResult = new DumpResult();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramIMemoryDumpListener.onPrepareDump(paramString);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      ((List)localObject1).addAll((Collection)localObject2);
      localObject2 = DumpMemInfoHandler.generateHprof(paramString);
      localDumpResult.success = ((Boolean)localObject2[0]).booleanValue();
      if ((!localDumpResult.success) || (localObject2[1] == null)) {
        break label191;
      }
      String str = (String)localObject2[1];
      ((List)localObject1).add((String)localObject2[1]);
      localDumpResult.hprofFileSize = new File(str).length();
    }
    for (;;)
    {
      localObject1 = DumpMemInfoHandler.zipFiles((List)localObject1, paramString);
      localDumpResult.zipFilePath = ((String)localObject1[1]);
      localDumpResult.success = ((Boolean)localObject1[0]).booleanValue();
      paramIMemoryDumpListener.onFinishDump(localDumpResult.success, paramString, localDumpResult.zipFilePath);
      return localDumpResult;
      Logger.INSTANCE.e(new String[] { "QAPM_memory_MemoryDumpHelper", "prepareFiles is none" });
      break;
      label191:
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "failed dump memory" });
    }
  }
  
  @Nullable
  public static MemoryDumpHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MemoryDumpHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void report(DumpResult paramDumpResult)
  {
    String str = ActivityInfo.getCurrentActivityName();
    if (!paramDumpResult.success)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_MemoryDumpHelper", "dump other file failed!" });
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fileObj", paramDumpResult.zipFilePath);
      localJSONObject.put("stage", str);
      localJSONObject.put("Activity", str);
      localJSONObject.put("UIN", BaseInfo.userMeta.uin);
      localJSONObject.put("Model", Build.MODEL);
      localJSONObject.put("OS", Build.VERSION.RELEASE);
      localJSONObject.put("Threshold", PluginCombination.ceilingHprofPlugin.threshold * Runtime.getRuntime().maxMemory() / 100L);
      localJSONObject.put("plugin", PluginCombination.ceilingHprofPlugin.plugin);
      paramDumpResult = new ResultObject(0, "MemoryCelling single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
      ReporterMachine.INSTANCE.addResultObj(paramDumpResult);
      return;
    }
    catch (JSONException paramDumpResult)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramDumpResult);
    }
  }
  
  public void onReport(long paramLong1, long paramLong2, String paramString)
  {
    if (!PluginController.INSTANCE.canCollect(PluginCombination.ceilingValuePlugin.plugin)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("vcname", paramString);
      ((JSONObject)localObject).put("singleMemory", paramLong1);
      ((JSONObject)localObject).put("threshold", paramLong2);
      paramString = new JSONObject();
      paramString.put("processname", AppInfo.obtainProcessName(BaseInfo.app));
      paramString.put("minidumpdata", localObject);
      paramString.put("plugin", PluginCombination.ceilingValuePlugin.plugin);
      if ((extraInfoMap != null) && (!extraInfoMap.isEmpty()))
      {
        localObject = extraInfoMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramString.put(str, extraInfoMap.get(str));
        }
      }
      paramString = new ResultObject(0, "MemoryCelling target", true, 1L, 1L, paramString, true, true, BaseInfo.userMeta.uin);
    }
    catch (JSONException paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramString);
      return;
    }
    ReporterMachine.INSTANCE.addResultObj(paramString);
  }
  
  public void setExtraInfo(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (extraInfoMap == null)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "extraInfoMap need init" });
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryDumpHelper", "field and content must be not null" });
      return;
    }
    extraInfoMap.put(paramString1, paramString2);
  }
  
  public void startDumpingMemory(String paramString)
  {
    try
    {
      if (!canDumpMemory()) {
        return;
      }
      if (PluginController.INSTANCE.canCollect(PluginCombination.ceilingHprofPlugin.plugin))
      {
        report(dump(paramString, MemoryCeilingMonitor.getInstance().memoryCellingListener));
        return;
      }
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryDumpHelper", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryDumpHelper
 * JD-Core Version:    0.7.0.1
 */