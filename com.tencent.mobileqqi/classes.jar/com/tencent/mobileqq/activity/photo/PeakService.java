package com.tencent.mobileqq.activity.photo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;

public class PeakService
  extends IntentService
{
  public PeakService()
  {
    super("PeakService");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */