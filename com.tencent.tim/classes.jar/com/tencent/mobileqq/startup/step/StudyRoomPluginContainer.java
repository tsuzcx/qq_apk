package com.tencent.mobileqq.startup.step;

import aibx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.PluginProcessService;

public class StudyRoomPluginContainer
  extends Step
{
  protected boolean doStep()
  {
    try
    {
      LoggerFactory.setILoggerFactory(aibx.a());
      label6:
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(PluginProcessService.getActivityHolder());
      DynamicRuntime.recoveryRuntime(BaseApplicationImpl.getContext());
      new InitMemoryCache().step();
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StudyRoomPluginContainer
 * JD-Core Version:    0.7.0.1
 */