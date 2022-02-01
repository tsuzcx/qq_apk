import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class alls
{
  public allp a;
  protected QQAppInterface app;
  protected Handler handler;
  Runnable hp = new QzonePhotoGuideNotifyService.1(this);
  private BroadcastReceiver receiver = new allt(this);
  
  public alls(QQAppInterface paramQQAppInterface, allp paramallp)
  {
    this.app = paramQQAppInterface;
    this.a = paramallp;
    if (paramQQAppInterface != null) {}
    try
    {
      paramallp = new IntentFilter("com.qzonex.localalbum.new_photo_notification_feedback_action");
      paramQQAppInterface.getApp().registerReceiver(this.receiver, paramallp);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QzonePhotoGuideNotifyServlet", 1, "registerreceiver fail:" + paramQQAppInterface);
    }
  }
  
  public static boolean d(Context paramContext, int paramInt)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.qzone", 128);
      if ((paramContext == null) || (paramContext.metaData == null)) {
        break label50;
      }
      i = paramContext.metaData.getInt("com.qzone.versioncode");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = 0;
      }
    }
    if (i >= paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public void startService()
  {
    try
    {
      Intent localIntent = new Intent("com.qzonex.localalbum.new_photo_notification_action");
      localIntent.setComponent(new ComponentName("com.qzone", "com.qzonex.proxy.localalbum.business.NewPhotoNotificationService"));
      this.app.getApp().startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QzonePhotoGuideNotifyServlet", 2, "calling qzone");
      }
      this.handler = new Handler(ThreadManager.getSubThreadLooper());
      this.handler.postDelayed(this.hp, 10000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzonePhotoGuideNotifyServlet", 1, "startService fail:" + localException);
      }
    }
  }
  
  public void stopService()
  {
    if (this.app != null) {}
    try
    {
      this.app.getApp().unregisterReceiver(this.receiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePhotoGuideNotifyServlet", 1, "stopService fail:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alls
 * JD-Core Version:    0.7.0.1
 */