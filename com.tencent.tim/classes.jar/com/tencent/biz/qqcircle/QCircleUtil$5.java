package com.tencent.biz.qqcircle;

import android.content.Context;
import android.content.Intent;
import awsw;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.photo.PeakService;
import ovd;

public final class QCircleUtil$5
  implements Runnable
{
  public QCircleUtil$5(Context paramContext) {}
  
  public void run()
  {
    if (awsw.O(this.val$context)) {}
    do
    {
      return;
      Intent localIntent = new Intent(this.val$context, PeakService.class);
      localIntent.putExtra("ServiceAction", 5);
      localIntent.putExtra("key_alive", false);
      try
      {
        this.val$context.startService(localIntent);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(ovd.access$000(), 0, "preload peak fail ", localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleUtil.5
 * JD-Core Version:    0.7.0.1
 */