package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class TaskExecutors
{
  private static final TaskExecutors INSTANCE = new TaskExecutors();
  private final ExecutorService mBackground = a.a();
  private final Executor mImmediate = new ImmediateExecutor();
  private final Executor mUiThread = a.b();
  
  static ExecutorService background()
  {
    return INSTANCE.mBackground;
  }
  
  public static Executor immediate()
  {
    return INSTANCE.mImmediate;
  }
  
  public static Executor uiThread()
  {
    return INSTANCE.mUiThread;
  }
  
  static final class ImmediateExecutor
    implements Executor
  {
    public final void execute(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.TaskExecutors
 * JD-Core Version:    0.7.0.1
 */