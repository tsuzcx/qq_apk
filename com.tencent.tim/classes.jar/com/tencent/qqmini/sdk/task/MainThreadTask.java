package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;

public abstract class MainThreadTask
  extends BaseTask
{
  public MainThreadTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, 3, paramBaseRuntimeLoader);
  }
  
  public void execute()
  {
    executeStartTime();
    this.mainHander.post(new MainThreadTask.1(this));
  }
  
  public abstract void executeInMainThread();
  
  public void executeStartTime() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MainThreadTask
 * JD-Core Version:    0.7.0.1
 */