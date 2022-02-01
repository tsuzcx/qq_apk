package com.tencent.mobileqq.minigame.manager;

import android.os.Handler;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.qphone.base.util.QLog;

public class GameReportManager
{
  private final String TAG = toString();
  private boolean firstFrame = false;
  private boolean jsError = false;
  private volatile MiniAppConfig mAppConfig;
  
  public void onFirstFrame()
  {
    try
    {
      MiniProgramReporter.getInstance().getReportHandler().post(new GameReportManager.2(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(this.TAG, 1, "onFirstFrame", localThrowable);
    }
  }
  
  public void onJsError()
  {
    try
    {
      if (!this.jsError)
      {
        this.jsError = true;
        MiniProgramReporter.getInstance().getReportHandler().post(new GameReportManager.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(this.TAG, 1, "onJsError", localThrowable);
    }
  }
  
  public void setAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.mAppConfig = paramMiniAppConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameReportManager
 * JD-Core Version:    0.7.0.1
 */