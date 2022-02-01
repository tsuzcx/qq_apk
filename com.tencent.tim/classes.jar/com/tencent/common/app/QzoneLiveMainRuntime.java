package com.tencent.common.app;

import android.os.Bundle;
import avpw;
import avyo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QzoneLiveMainRuntime
  extends ToolRuntimeBase
{
  private static String TAG = "QzoneLiveMainRuntime";
  
  public String getModuleId()
  {
    return "qzonelive";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i(TAG, 1, "QzoneLiveMainRuntime onCreate");
    super.onCreate(paramBundle);
  }
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    AppRuntime localAppRuntime = null;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "QzoneLiveMainRuntime.onGetSubRuntime() moduleId " + paramString);
    }
    if (paramString.equals(avyo.GF())) {
      localAppRuntime = avpw.d(BaseApplicationImpl.getApplication());
    }
    while (!paramString.equals("qzone_weishi_feeds_plugin.apk")) {
      return localAppRuntime;
    }
    return avpw.f(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.QzoneLiveMainRuntime
 * JD-Core Version:    0.7.0.1
 */