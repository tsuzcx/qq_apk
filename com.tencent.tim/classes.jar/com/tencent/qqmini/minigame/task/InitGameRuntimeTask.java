package com.tencent.qqmini.minigame.task;

import android.content.Context;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.task.MainThreadTask;

@ClassTag(tag="InitGameRuntimeTask")
public class InitGameRuntimeTask
  extends MainThreadTask
{
  private static final String TAG = "InitGameRuntimeTask";
  
  public InitGameRuntimeTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeInMainThread()
  {
    ITTEngine localITTEngine = null;
    GameRuntime localGameRuntime;
    if (getDependTasks() != null)
    {
      localGameRuntime = ((GameRuntimeCreateTask)getRuntimeLoader().getTask(GameRuntimeCreateTask.class)).getGameRuntime();
      localITTEngine = ((TritonEngineInitTask)getRuntimeLoader().getTask(TritonEngineInitTask.class)).getGameEngine();
    }
    for (;;)
    {
      MiniAppInfo localMiniAppInfo = getRuntimeLoader().getMiniAppInfo();
      if ((localGameRuntime == null) || (localITTEngine == null) || (localMiniAppInfo == null))
      {
        onTaskFailed();
        return;
      }
      try
      {
        localGameRuntime.init(localITTEngine);
        localGameRuntime.loadMiniApp(localMiniAppInfo);
        onTaskSucceed();
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("InitGameRuntimeTask", localThrowable.getMessage(), localThrowable);
        onTaskFailed();
        return;
      }
      localGameRuntime = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.InitGameRuntimeTask
 * JD-Core Version:    0.7.0.1
 */