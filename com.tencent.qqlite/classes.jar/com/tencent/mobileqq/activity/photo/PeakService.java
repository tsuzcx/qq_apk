package com.tencent.mobileqq.activity.photo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class PeakService
  extends IntentService
{
  private static final String a = "PeakService";
  
  public PeakService()
  {
    super("PeakService");
    if (QLog.isColorLevel()) {
      QLog.i("PeakService", 2, "PeakService");
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    paramIntent = ThreadManager.a();
    if (paramIntent != null)
    {
      paramIntent.removeCallbacks(FileUtils.a);
      paramIntent.postDelayed(FileUtils.a, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */