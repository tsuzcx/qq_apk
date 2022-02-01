package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.sdk.statics.TraceStatistics;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport;", "", "()V", "BEACON_MAX_EVENT_NAME_LENGTH", "", "JANK_TRACE_TOP_RECORDS_COUNT", "getTaskName", "", "stack", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "report", "", "eventCode", "params", "", "reportJankTraceRecords", "statistics", "Lcom/tencent/mobileqq/triton/sdk/statics/TraceStatistics;", "appid", "isSdk", "", "isFirstFrame", "reportLaunchStatics", "statics", "ExclusiveVisitor", "ParamConfigVisitor", "ParamVisitor", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniGameBeaconReport
{
  private static final int BEACON_MAX_EVENT_NAME_LENGTH = 59;
  public static final MiniGameBeaconReport INSTANCE = new MiniGameBeaconReport();
  private static final int JANK_TRACE_TOP_RECORDS_COUNT = 20;
  
  private final String getTaskName(List<TaskExecutionStatics> paramList)
  {
    paramList = CollectionsKt.joinToString$default((Iterable)paramList, (CharSequence)"_", null, null, 0, null, (Function1)MiniGameBeaconReport.getTaskName.name.1.INSTANCE, 30, null);
    if (Intrinsics.areEqual(paramList, "root")) {
      paramList = "total";
    }
    int i;
    int j;
    for (;;)
    {
      localObject = paramList;
      if (paramList.length() <= 59) {
        break label127;
      }
      i = paramList.length();
      j = paramList.length();
      if (paramList != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      i = "root_".length();
      if (paramList == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramList = paramList.substring(i);
      Intrinsics.checkExpressionValueIsNotNull(paramList, "(this as java.lang.String).substring(startIndex)");
    }
    Object localObject = paramList.substring(i - 59, j);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    label127:
    return localObject;
  }
  
  @JvmStatic
  public static final void report(@NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null) {
      localChannelProxy.reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, paramString, paramMap);
    }
  }
  
  @JvmStatic
  public static final void reportJankTraceRecords(@NotNull TraceStatistics paramTraceStatistics, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramTraceStatistics, "statistics");
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    ThreadManager.executeOnNetworkIOThreadPool((Runnable)new MiniGameBeaconReport.reportJankTraceRecords.1(paramTraceStatistics, paramBoolean1, paramString, paramBoolean2));
  }
  
  @JvmStatic
  public static final void reportLaunchStatics(@NotNull List<TaskExecutionStatics> paramList, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "statics");
    Intrinsics.checkParameterIsNotNull(paramString, "appid");
    ParamVisitor localParamVisitor = new ParamVisitor();
    new TaskStaticsVisualizer((TaskStaticsVisualizer.TaskVisitor)localParamVisitor).visitTasks(paramList);
    paramList = MapsKt.toMutableMap(localParamVisitor.getParam());
    paramList.put("is_sdk", String.valueOf(paramBoolean));
    paramList.put("appid", paramString);
    paramList.put("is_debug", String.valueOf(false));
    report("game_launch", paramList);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "()V", "excludedTaskNames", "", "", "skipLevel", "", "stack", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getStack", "()Ljava/util/List;", "beginDependencies", "", "beginTask", "statics", "endDependencies", "popTask", "block", "Lkotlin/Function1;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
  static abstract class ExclusiveVisitor
    implements TaskStaticsVisualizer.TaskVisitor
  {
    private final Set<String> excludedTaskNames = SetsKt.setOf(new String[] { "GetInstalledEngine", "DownloadPlugin" });
    private int skipLevel;
    @NotNull
    private final List<TaskExecutionStatics> stack = (List)new ArrayList();
    
    public void beginDependencies() {}
    
    public void beginTask(@NotNull TaskExecutionStatics paramTaskExecutionStatics)
    {
      Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "statics");
      if ((this.skipLevel != 0) || (this.excludedTaskNames.contains(paramTaskExecutionStatics.getName())))
      {
        this.skipLevel += 1;
        return;
      }
      this.stack.add(paramTaskExecutionStatics);
    }
    
    public void endDependencies() {}
    
    @NotNull
    protected final List<TaskExecutionStatics> getStack()
    {
      return this.stack;
    }
    
    protected final void popTask(@NotNull Function1<? super TaskExecutionStatics, Unit> paramFunction1)
    {
      Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
      if (access$getSkipLevel$p(this) != 0)
      {
        access$setSkipLevel$p(this, access$getSkipLevel$p(this) - 1);
        return;
      }
      paramFunction1.invoke(access$getStack$p(this).get(CollectionsKt.getLastIndex(access$getStack$p(this))));
      access$getStack$p(this).remove(CollectionsKt.getLastIndex(access$getStack$p(this)));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ParamConfigVisitor;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "config", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "paramConfig", "", "getParamConfig", "()Ljava/lang/String;", "endTask", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
  static final class ParamConfigVisitor
    extends MiniGameBeaconReport.ExclusiveVisitor
  {
    private final StringBuilder config = new StringBuilder();
    
    public void endTask()
    {
      MiniGameBeaconReport.ExclusiveVisitor localExclusiveVisitor = (MiniGameBeaconReport.ExclusiveVisitor)this;
      if (MiniGameBeaconReport.ExclusiveVisitor.access$getSkipLevel$p(localExclusiveVisitor) != 0)
      {
        MiniGameBeaconReport.ExclusiveVisitor.access$setSkipLevel$p(localExclusiveVisitor, MiniGameBeaconReport.ExclusiveVisitor.access$getSkipLevel$p(localExclusiveVisitor) - 1);
        return;
      }
      TaskExecutionStatics localTaskExecutionStatics = (TaskExecutionStatics)MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).get(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
      String str = MiniGameBeaconReport.access$getTaskName(MiniGameBeaconReport.INSTANCE, getStack());
      StringBuilder localStringBuilder = this.config;
      if (!((Collection)localTaskExecutionStatics.getSubSteps()).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localStringBuilder.append("game_launch 启动步骤 " + str + ' ' + ((TaskExecutionStatics)CollectionsKt.last(getStack())).getName() + "步骤总耗时 bigint");
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("game_launch 启动步骤 " + str + "_self " + ((TaskExecutionStatics)CollectionsKt.last(getStack())).getName() + "步骤自身耗时 bigint");
        localStringBuilder.append("\n");
        MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).remove(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
        return;
      }
    }
    
    @NotNull
    public final String getParamConfig()
    {
      String str = this.config.toString();
      Intrinsics.checkExpressionValueIsNotNull(str, "config.toString()");
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ParamVisitor;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "map", "", "", "param", "", "getParam", "()Ljava/util/Map;", "endTask", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
  static final class ParamVisitor
    extends MiniGameBeaconReport.ExclusiveVisitor
  {
    private final Map<String, String> map = (Map)new LinkedHashMap();
    
    public void endTask()
    {
      MiniGameBeaconReport.ExclusiveVisitor localExclusiveVisitor = (MiniGameBeaconReport.ExclusiveVisitor)this;
      if (MiniGameBeaconReport.ExclusiveVisitor.access$getSkipLevel$p(localExclusiveVisitor) != 0)
      {
        MiniGameBeaconReport.ExclusiveVisitor.access$setSkipLevel$p(localExclusiveVisitor, MiniGameBeaconReport.ExclusiveVisitor.access$getSkipLevel$p(localExclusiveVisitor) - 1);
        return;
      }
      TaskExecutionStatics localTaskExecutionStatics = (TaskExecutionStatics)MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).get(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
      String str = MiniGameBeaconReport.access$getTaskName(MiniGameBeaconReport.INSTANCE, getStack());
      if (!((Collection)localTaskExecutionStatics.getSubSteps()).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.map.put(str, String.valueOf(((TaskExecutionStatics)CollectionsKt.last(getStack())).getTotalRunDurationMs()));
        }
        this.map.put(str + "_self", String.valueOf(((TaskExecutionStatics)CollectionsKt.last(getStack())).getRunDurationMs()));
        MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor).remove(CollectionsKt.getLastIndex(MiniGameBeaconReport.ExclusiveVisitor.access$getStack$p(localExclusiveVisitor)));
        return;
      }
    }
    
    @NotNull
    public final Map<String, String> getParam()
    {
      return this.map;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport
 * JD-Core Version:    0.7.0.1
 */