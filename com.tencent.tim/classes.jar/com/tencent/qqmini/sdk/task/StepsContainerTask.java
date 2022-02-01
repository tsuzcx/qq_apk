package com.tencent.qqmini.sdk.task;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/StepsContainerTask;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "context", "Landroid/content/Context;", "runtimeLoader", "Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;", "subSteps", "", "(Landroid/content/Context;Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;Ljava/util/List;)V", "steps", "Lcom/tencent/qqmini/sdk/task/TaskSteps;", "getSteps", "()Lcom/tencent/qqmini/sdk/task/TaskSteps;", "execute", "", "getSubTaskExecutionStatics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getTotalRunDurationMs", "", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public class StepsContainerTask
  extends BaseTask
{
  @NotNull
  private final TaskSteps steps;
  
  public StepsContainerTask(@NotNull Context paramContext, @Nullable BaseRuntimeLoader paramBaseRuntimeLoader, @NotNull List<? extends BaseTask> paramList)
  {
    super(paramContext, paramBaseRuntimeLoader);
    this.steps = new TaskSteps((BaseTask)this, paramList);
  }
  
  protected void execute()
  {
    this.steps.start();
  }
  
  @NotNull
  protected final TaskSteps getSteps()
  {
    return this.steps;
  }
  
  @NotNull
  protected List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    return this.steps.getStepExecutionStatics();
  }
  
  public long getTotalRunDurationMs()
  {
    return getRunDurationMs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.StepsContainerTask
 * JD-Core Version:    0.7.0.1
 */