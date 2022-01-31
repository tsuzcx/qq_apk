import android.content.res.Resources;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.battery.BatteryStats;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class wne
  implements Runnable
{
  public wne(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    Object localObject = this.a.a;
    if (localObject != null) {}
    for (QQAppInterface localQQAppInterface = ((SplashActivity)localObject).app; (localObject == null) || (localQQAppInterface == null); localQQAppInterface = null) {
      return;
    }
    try
    {
      AIOPanelUtiles.a(localQQAppInterface);
      MultiMsgManager.a().a(localQQAppInterface);
      localObject = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = BaseApplicationImpl.sImageCache;
      float f = MemoryConfigs.a().a;
      ((MQLruCache)localObject).setLargeSize((int)(j * i * 4 * f));
      localQQAppInterface.D();
      QQToast.a(true);
      QQAppInterface.a().a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MainAssistObserver", 4, "notifyWindowShowed e=" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wne
 * JD-Core Version:    0.7.0.1
 */