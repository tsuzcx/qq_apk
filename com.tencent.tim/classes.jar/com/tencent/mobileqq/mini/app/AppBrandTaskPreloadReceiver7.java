package com.tencent.mobileqq.mini.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver;
import common.config.service.QzoneConfig;

public class AppBrandTaskPreloadReceiver7
  extends AppBrandMainReceiver
{
  public static final String ACTION_KILL = "mini_process_kill";
  public static final String LOG_TAG = "AppBrandReceiver";
  private static int killOtherGamesOnStartFlag = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillOtherGamesOnStart", 0);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.i("minisdk-start", 1, "AppBrandTaskPreloadReceiver onReceive action: " + paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7
 * JD-Core Version:    0.7.0.1
 */