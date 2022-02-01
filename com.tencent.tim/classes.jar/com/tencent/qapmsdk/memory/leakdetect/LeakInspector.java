package com.tencent.qapmsdk.memory.leakdetect;

import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.logcat.ILogcat;
import com.tencent.qapmsdk.common.logcat.LogcatManager;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qapmsdk.common.util.RecyclablePool;
import com.tencent.qapmsdk.memory.DumpMemInfoHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LeakInspector
{
  private static final int CHECK_PIVOT = 5000;
  private static final String TAG = "QAPM_memory_LeakInspector";
  private static final int TIME_UNIT = 1000;
  private static boolean autoDump = false;
  private static long lastTimeGC = 0L;
  private static LeakInspector leakInspector;
  private static int loopMaxCount = 100;
  private static RecyclablePool sPool;
  private IInspectorListener inspectorListener;
  private Handler leakHandler;
  
  private LeakInspector(Handler paramHandler, IInspectorListener paramIInspectorListener)
  {
    this.leakHandler = paramHandler;
    this.inspectorListener = paramIInspectorListener;
  }
  
  private static void addLogcat(List<String> paramList)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      if (!AppInfo.hasPermissions(BaseInfo.app, new String[] { "android.permission.READ_LOGS" })) {}
    }
    else
    {
      Object localObject = LogcatManager.initLogcat(1);
      ((ILogcat)localObject).setArgs(new String[] { "-t", "100", "-v", "threadtime" });
      localObject = ((ILogcat)localObject).getLogcatFile();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramList.add(localObject);
      }
    }
  }
  
  private static void doGc()
  {
    long l = System.currentTimeMillis();
    if (l - lastTimeGC >= 5000L)
    {
      System.runFinalization();
      Runtime.getRuntime().gc();
      lastTimeGC = l;
    }
  }
  
  public static DumpResult dumpMemory(String paramString, boolean paramBoolean, IMemoryDumpListener paramIMemoryDumpListener)
    throws Exception
  {
    int i = 0;
    DumpResult localDumpResult = new DumpResult();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramIMemoryDumpListener.onPrepareDump(paramString);
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      localArrayList.addAll((Collection)localObject1);
    }
    localObject1 = paramString + "_leak";
    if (paramBoolean)
    {
      Object localObject2 = DumpMemInfoHandler.generateHprof(paramString);
      paramBoolean = ((Boolean)localObject2[0]).booleanValue();
      localDumpResult.success = paramBoolean;
      if (paramBoolean)
      {
        localObject2 = (String)localObject2[1];
        localDumpResult.hprofFileSize = new File((String)localObject2).length();
        localArrayList.add(localObject2);
      }
    }
    else
    {
      addLogcat(localArrayList);
      localObject1 = DumpMemInfoHandler.zipFiles(localArrayList, (String)localObject1);
      localDumpResult.success = ((Boolean)localObject1[0]).booleanValue();
      localObject1 = (String)localObject1[1];
      localDumpResult.zipFilePath = ((String)localObject1);
      Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "leakFlag=true", ",ZipFile=", String.valueOf(localDumpResult.success), ",leakName=", paramString, ",dumpPath=", localObject1 });
      paramIMemoryDumpListener.onFinishDump(localDumpResult.success, paramString, (String)localObject1);
      while (i < localArrayList.size())
      {
        paramString = new File((String)localArrayList.get(i));
        if ((paramString != null) && (paramString.isFile()) && (paramString.exists())) {
          paramString.delete();
        }
        i += 1;
      }
    }
    paramIMemoryDumpListener.onFinishDump(false, paramString, "");
    Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "generateHprof error ", paramString });
    return localDumpResult;
    return localDumpResult;
  }
  
  public static void enableAutoDump(boolean paramBoolean)
  {
    autoDump = paramBoolean;
  }
  
  @Nullable
  private InspectUUID generateInspectUuid(@NonNull Object paramObject, String paramString)
  {
    try
    {
      InspectUUID localInspectUUID = (InspectUUID)sPool.obtain(InspectUUID.class);
      if (localInspectUUID == null) {
        return null;
      }
      localInspectUUID.weakObj = new WeakReference(paramObject);
      localInspectUUID.uuid = UUID.randomUUID().toString().toCharArray();
      localInspectUUID.digest = paramString;
      localInspectUUID.className = paramObject.getClass().getSimpleName();
      return localInspectUUID;
    }
    catch (Exception paramObject) {}
    return null;
  }
  
  public static void initInspector(Handler paramHandler, IInspectorListener paramIInspectorListener)
  {
    if (leakInspector != null) {
      return;
    }
    leakInspector = new LeakInspector(paramHandler, paramIInspectorListener);
    sPool = new RecyclablePool(InspectUUID.class, 20);
  }
  
  private void newInspect(@NonNull Object paramObject, String paramString)
  {
    if (leakInspector.inspectorListener.onFilter(paramObject)) {}
    do
    {
      return;
      paramObject = generateInspectUuid(paramObject, paramString);
    } while (paramObject == null);
    paramObject = new InspectorRunner(paramObject, 0);
    this.leakHandler.post(paramObject);
  }
  
  public static void report(long paramLong, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("processname", AppInfo.obtainProcessName(BaseInfo.app));
    localJSONObject.put("event_time", paramLong);
    localJSONObject.put("fileObj", paramString);
    localJSONObject.put("plugin", PluginCombination.leakPlugin.plugin);
    paramString = new ResultObject(0, "MemoryLeak single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
    ReporterMachine.INSTANCE.addResultObj(paramString);
  }
  
  public static void setLooperMaxCount(int paramInt)
  {
    loopMaxCount = paramInt;
  }
  
  public static void startInspect(@NonNull Object paramObject, String paramString)
  {
    if (leakInspector == null)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "Please call initInspector before this" });
      return;
    }
    if (leakInspector.inspectorListener == null)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "Please init a listener first!" });
      return;
    }
    if (!PluginController.INSTANCE.whetherPluginSampling(PluginCombination.leakPlugin.plugin))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_memory_LeakInspector", "leakSampleLost" });
      return;
    }
    leakInspector.newInspect(paramObject, paramString);
  }
  
  class InspectorRunner
    implements Runnable
  {
    private long occurTime = System.currentTimeMillis();
    private int retryCount = 0;
    private InspectUUID uuid;
    
    InspectorRunner(InspectUUID paramInspectUUID, int paramInt)
    {
      this.retryCount = paramInt;
      this.uuid = paramInspectUUID;
    }
    
    public void run()
    {
      if (this.uuid == null) {
        Logger.INSTANCE.w(new String[] { "QAPM_memory_LeakInspector", "uuid is null" });
      }
      String str;
      DumpResult localDumpResult;
      do
      {
        do
        {
          return;
          str = this.uuid.toString();
          try
          {
            Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "Inspecting ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount) });
            if (this.uuid.weakObj.get() == null) {
              break;
            }
            int i = this.retryCount + 1;
            this.retryCount = i;
            if (i < LeakInspector.loopMaxCount)
            {
              LeakInspector.access$100();
              LeakInspector.this.inspectorListener.onCheckingLeaked((this.retryCount - 1) * 5000 / 1000, str);
              LeakInspector.this.leakHandler.postDelayed(this, 5000L);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "error, ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount), " Throwable: ", Logger.INSTANCE.getThrowableMessage(localThrowable) });
            LeakInspector.sPool.recycle(this.uuid);
            return;
          }
        } while (!LeakInspector.this.inspectorListener.onLeaked(this.uuid));
        localDumpResult = LeakInspector.dumpMemory(str, LeakInspector.autoDump, LeakInspector.this.inspectorListener);
      } while (!localDumpResult.success);
      LeakInspector.report(this.occurTime, localDumpResult.zipFilePath);
      return;
      Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "inspect ", str, " finished no leak" });
      LeakInspector.sPool.recycle(this.uuid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.LeakInspector
 * JD-Core Version:    0.7.0.1
 */