package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.triton.sdk.statics.EngineInitStatistic;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadResult;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadStatics;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics.Status;
import com.tencent.qqmini.sdk.task.TaskSteps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "launchGameBeginTime", "", "steps", "Lcom/tencent/qqmini/sdk/task/TaskSteps;", "execute", "", "getName", "", "getSubTaskExecutionStatics", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getTotalRunDurationMs", "onFirstFrame", "onGameLaunched", "statics", "Lcom/tencent/mobileqq/triton/sdk/statics/GameLaunchStatistic;", "onRuntimeInitDone", "FirstFrame", "InitEngine", "LaunchGame", "ScriptTask", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class LaunchEngineUISteps
  extends BaseTask
{
  private long launchGameBeginTime;
  private final TaskSteps steps = new TaskSteps((BaseTask)this, CollectionsKt.listOf(new BaseTask[] { (BaseTask)new InitEngine(), (BaseTask)new LaunchGame(), (BaseTask)new FirstFrame() }));
  
  public LaunchEngineUISteps(@NotNull Context paramContext)
  {
    super(paramContext, null);
  }
  
  public void execute()
  {
    this.steps.start();
  }
  
  @NotNull
  public String getName()
  {
    return "LaunchEngine";
  }
  
  @NotNull
  public List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    return this.steps.getStepExecutionStatics();
  }
  
  public long getTotalRunDurationMs()
  {
    return getRunDurationMs();
  }
  
  public final void onFirstFrame()
  {
    this.steps.getCurrentStep().onTaskSucceed();
  }
  
  public final void onGameLaunched(@NotNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchStatistic, "statics");
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.launchGameBeginTime;
    long l3 = paramGameLaunchStatistic.launchTimesMs;
    Object localObject = this.steps.getCurrentStep();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.task.LaunchEngineUISteps.InitEngine");
    }
    localObject = (InitEngine)localObject;
    EngineInitStatistic localEngineInitStatistic = paramGameLaunchStatistic.engineInitStatistic;
    Intrinsics.checkExpressionValueIsNotNull(localEngineInitStatistic, "statics.engineInitStatistic");
    ((InitEngine)localObject).onTaskSucceed(localEngineInitStatistic, l1 - l2 - l3);
    localObject = this.steps.getCurrentStep();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.task.LaunchEngineUISteps.LaunchGame");
    }
    localObject = (LaunchGame)localObject;
    l1 = paramGameLaunchStatistic.launchTimesMs;
    paramGameLaunchStatistic = paramGameLaunchStatistic.gameScriptLoadStatics;
    Intrinsics.checkExpressionValueIsNotNull(paramGameLaunchStatistic, "statics.gameScriptLoadStatics");
    ((LaunchGame)localObject).onTaskSucceed(l1, paramGameLaunchStatistic);
  }
  
  public final void onRuntimeInitDone()
  {
    run();
    this.launchGameBeginTime = SystemClock.uptimeMillis();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$FirstFrame;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "execute", "", "getName", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
  final class FirstFrame
    extends BaseTask
  {
    public FirstFrame()
    {
      super(this$1.getRuntimeLoader());
    }
    
    public void execute() {}
    
    @NotNull
    public String getName()
    {
      return "FirstFrame";
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$InitEngine;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "getName", "", "onTaskSucceed", "", "statics", "Lcom/tencent/mobileqq/triton/sdk/statics/EngineInitStatistic;", "effectivelyInitEngineTime", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
  final class InitEngine
    extends LaunchEngineUISteps.ScriptTask
  {
    public InitEngine()
    {
      super();
    }
    
    @NotNull
    public String getName()
    {
      return "InitEngine";
    }
    
    public final void onTaskSucceed(@NotNull EngineInitStatistic paramEngineInitStatistic, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramEngineInitStatistic, "statics");
      List localList = paramEngineInitStatistic.engineScriptLoadStatics;
      Intrinsics.checkExpressionValueIsNotNull(localList, "statics.engineScriptLoadStatics");
      super.onTaskSucceed(paramLong, localList);
      localList = CollectionsKt.toMutableList((Collection)getSteps());
      localList.add(0, new TaskExecutionStatics("LoadSo", paramEngineInitStatistic.loadNativeLibraryTimeMs, 0L, null, null, null, 60, null));
      localList.add(1, new TaskExecutionStatics("EGL", paramEngineInitStatistic.createEGLContextTimeMs, 0L, TaskExecutionStatics.Status.CACHED, null, null, 52, null));
      setSteps(localList);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$LaunchGame;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "getName", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
  final class LaunchGame
    extends LaunchEngineUISteps.ScriptTask
  {
    public LaunchGame()
    {
      super();
    }
    
    @NotNull
    public String getName()
    {
      return "LaunchGame";
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "scriptDurationMs", "", "steps", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getSteps", "()Ljava/util/List;", "setSteps", "(Ljava/util/List;)V", "wallDurationMs", "execute", "", "getRunDurationMs", "getSubTaskExecutionStatics", "getTotalRunDurationMs", "onTaskSucceed", "timeMs", "list", "Lcom/tencent/mobileqq/triton/sdk/statics/ScriptLoadStatics;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
  class ScriptTask
    extends BaseTask
  {
    private long scriptDurationMs;
    @NotNull
    private List<TaskExecutionStatics> steps = CollectionsKt.emptyList();
    private long wallDurationMs;
    
    public ScriptTask()
    {
      super(this$1.getRuntimeLoader());
    }
    
    public void execute() {}
    
    public long getRunDurationMs()
    {
      return this.scriptDurationMs;
    }
    
    @NotNull
    protected final List<TaskExecutionStatics> getSteps()
    {
      return this.steps;
    }
    
    @NotNull
    public List<TaskExecutionStatics> getSubTaskExecutionStatics()
    {
      return this.steps;
    }
    
    public long getTotalRunDurationMs()
    {
      return this.wallDurationMs;
    }
    
    public final void onTaskSucceed(long paramLong, @NotNull List<? extends ScriptLoadStatics> paramList)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "list");
      this.wallDurationMs = paramLong;
      super.onTaskSucceed();
      paramList = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        ScriptLoadStatics localScriptLoadStatics = (ScriptLoadStatics)localIterator.next();
        this.scriptDurationMs += localScriptLoadStatics.compileTimeMs + localScriptLoadStatics.executeTimeMs;
        String str = localScriptLoadStatics.scriptName;
        Intrinsics.checkExpressionValueIsNotNull(str, "it.scriptName");
        paramLong = localScriptLoadStatics.compileTimeMs;
        long l = localScriptLoadStatics.executeTimeMs;
        if (localScriptLoadStatics.loadResult == ScriptLoadResult.SUCCESS_WITH_CACHE) {}
        for (paramList = "cc";; paramList = "")
        {
          localCollection.add(new TaskExecutionStatics(str, 0L, paramLong + l, null, paramList, CollectionsKt.listOf(new TaskExecutionStatics[] { new TaskExecutionStatics("compile", localScriptLoadStatics.compileTimeMs, 0L, null, null, null, 60, null), new TaskExecutionStatics("execute", localScriptLoadStatics.executeTimeMs, 0L, null, null, null, 60, null) }), 8, null));
          break;
        }
      }
      this.steps = ((List)localCollection);
    }
    
    protected final void setSteps(@NotNull List<TaskExecutionStatics> paramList)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
      this.steps = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.LaunchEngineUISteps
 * JD-Core Version:    0.7.0.1
 */