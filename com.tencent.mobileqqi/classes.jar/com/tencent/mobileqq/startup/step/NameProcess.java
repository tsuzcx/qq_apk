package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class NameProcess
  extends Step
{
  private static final String b = "unknown";
  private static final int x = 3;
  
  protected boolean a()
  {
    int i = 0;
    String str;
    do
    {
      str = MsfSdkUtils.getProcessName(BaseApplicationImpl.a);
      i += 1;
    } while ((i < 3) && ("unknown".equals(str)));
    if ("unknown".equals(str)) {
      str = "com.tencent.mobileqqi";
    }
    for (;;)
    {
      BaseApplicationImpl.processName = str;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NameProcess
 * JD-Core Version:    0.7.0.1
 */