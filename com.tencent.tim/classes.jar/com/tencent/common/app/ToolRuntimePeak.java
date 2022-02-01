package com.tencent.common.app;

import avpw;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ToolRuntimePeak
  extends ToolRuntimeBase
{
  public static final String TAG = ToolAppRuntime.class.getSimpleName();
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    Object localObject = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if ("peak".equals(paramString)) {
      localObject = new PeakAppInterface(localBaseApplicationImpl, "peak");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "ToolRuntimePeak.onGetSubRuntime() moduleId " + paramString + " appInstance = " + localObject);
      }
      return localObject;
      if ("Photoplus.apk".equals(paramString)) {
        localObject = avpw.c(localBaseApplicationImpl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.ToolRuntimePeak
 * JD-Core Version:    0.7.0.1
 */