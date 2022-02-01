package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.Intent;

public abstract interface IStatisticsUploader
{
  public abstract void uploadStartupFailure(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void uploadStartupSpeedInfo(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IStatisticsUploader
 * JD-Core Version:    0.7.0.1
 */