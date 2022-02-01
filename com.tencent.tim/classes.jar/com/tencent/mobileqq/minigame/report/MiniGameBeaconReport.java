package com.tencent.mobileqq.minigame.report;

import avpq;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import com.tencent.mobileqq.mini.tfs.TaskStaticsVisualizer;
import com.tencent.mobileqq.mini.tfs.TaskStaticsVisualizer.TaskVisitor;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport;", "", "()V", "MINI_GAME_BEACON_KEY", "", "getTaskName", "stack", "", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "init", "", "report", "eventCode", "params", "", "reportLaunchStatics", "statics", "appid", "isSdk", "", "ExclusiveVisitor", "ParamConfigVisitor", "ParamVisitor", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MiniGameBeaconReport
{
  public static final MiniGameBeaconReport INSTANCE = new MiniGameBeaconReport();
  private static final String MINI_GAME_BEACON_KEY = "00000ARN3S3S9UE8";
  
  static
  {
    init();
  }
  
  private final String getTaskName(List<TaskExecutionStatics> paramList)
  {
    paramList = CollectionsKt.joinToString$default((Iterable)paramList, (CharSequence)"_", null, null, 0, null, (Function1)MiniGameBeaconReport.getTaskName.name.1.INSTANCE, 30, null);
    if (Intrinsics.areEqual(paramList, "root")) {
      return "total";
    }
    int i = "root_".length();
    if (paramList == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    paramList = paramList.substring(i);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "(this as java.lang.String).substring(startIndex)");
    return paramList;
  }
  
  @JvmStatic
  public static final void init()
  {
    UserAction.registerTunnel(new TunnelInfo("00000ARN3S3S9UE8", AppSetting.getVersion(), "1000"));
  }
  
  @JvmStatic
  public static final void report(@NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    UserAction.onUserActionToTunnel("00000ARN3S3S9UE8", paramString, paramMap, false, false);
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
    paramString = avpq.getQUA3();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "QUA.getQUA3()");
    paramList.put("qua", paramString);
    report("game_launch", paramList);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "Lcom/tencent/mobileqq/mini/tfs/TaskStaticsVisualizer$TaskVisitor;", "()V", "excludedTaskNames", "", "", "skipLevel", "", "stack", "", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "getStack", "()Ljava/util/List;", "beginDependencies", "", "beginTask", "statics", "endDependencies", "popTask", "block", "Lkotlin/Function1;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport$ParamConfigVisitor;", "Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "config", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "paramConfig", "", "getParamConfig", "()Ljava/lang/String;", "endTask", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport$ParamVisitor;", "Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "map", "", "", "param", "", "getParam", "()Ljava/util/Map;", "endTask", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.report.MiniGameBeaconReport
 * JD-Core Version:    0.7.0.1
 */