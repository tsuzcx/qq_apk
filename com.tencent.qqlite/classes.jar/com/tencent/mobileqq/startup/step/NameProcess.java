package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.uncompress.UncompressSo;
import eef;

public class NameProcess
  extends Step
{
  private static final String b = "unknown";
  private static final int y = 3;
  private Handler a = new eef(this);
  
  protected boolean a()
  {
    int i = 0;
    String str;
    do
    {
      str = MsfSdkUtils.getProcessName(BaseApplicationImpl.a);
      i += 1;
    } while ((i < 3) && ("unknown".equals(str)));
    if ("unknown".equals(str))
    {
      str = "com.tencent.qqlite";
      BaseApplicationImpl.h = 1;
    }
    for (;;)
    {
      BaseApplicationImpl.processName = str;
      UncompressSo.NewInstance(BaseApplicationImpl.a, this.a, false);
      return true;
      if ("com.tencent.qqlite".equals(str)) {
        BaseApplicationImpl.h = 1;
      } else if (str.endsWith("MSF")) {
        BaseApplicationImpl.h = 4;
      } else if (str.endsWith("qzone")) {
        BaseApplicationImpl.h = 2;
      } else if (str.endsWith("web")) {
        BaseApplicationImpl.h = 3;
      } else {
        BaseApplicationImpl.h = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NameProcess
 * JD-Core Version:    0.7.0.1
 */