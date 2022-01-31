package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;

public class Step$AmStepFactory
{
  public static Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 17: 
    default: 
      localObject = new Step();
    }
    for (;;)
    {
      ((Step)localObject).x = paramInt;
      ((Step)localObject).a = paramStartupDirector;
      if (paramInt == 0) {
        Step.a((Step)localObject, paramArrayOfInt);
      }
      return localObject;
      localObject = new LoadDex();
      continue;
      localObject = new NameProcess();
      continue;
      localObject = new InitMemoryCache();
      continue;
      localObject = new OldApplication();
      continue;
      localObject = new SetSplash();
      continue;
      localObject = new LoadData();
      continue;
      localObject = new NewRuntime();
      continue;
      localObject = new StartService();
      continue;
      localObject = new InitSkin();
      continue;
      localObject = new InitUrlDrawable();
      continue;
      localObject = new Update();
      continue;
      localObject = new Rdm();
      continue;
      localObject = new ManageThread();
      continue;
      localObject = new LoadUi();
      continue;
      localObject = new StartServiceLiteCmp();
      continue;
      localObject = new UpdateBubbleZip();
      continue;
      localObject = new SetPlugin();
      continue;
      localObject = new UpdatePluginVersion();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AmStepFactory
 * JD-Core Version:    0.7.0.1
 */