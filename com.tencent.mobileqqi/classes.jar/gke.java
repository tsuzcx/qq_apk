import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class gke
  extends Handler
{
  public gke(MainAcitivityReportHelper paramMainAcitivityReportHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    SplashActivity localSplashActivity = (SplashActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSplashActivity == null) {}
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = localSplashActivity.b;
      } while ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()));
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      MainAcitivityReportHelper.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.e("MainActivityReportHandler", 2, "handleMessage count:" + MainAcitivityReportHelper.b(this.a));
      }
      if (!"0".equals(localQQAppInterface.a()))
      {
        long l = System.currentTimeMillis();
        if (l - this.a.jdField_a_of_type_Long > 300000L)
        {
          this.a.jdField_a_of_type_Long = l;
          paramMessage = (FriendListHandler)localQQAppInterface.a(1);
          if (paramMessage != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MainActivityReportHandler", 2, "handleMessage requst online friens");
            }
            paramMessage.d(localQQAppInterface.a(), (byte)0);
          }
        }
      }
    } while ((localSplashActivity == null) || (!localSplashActivity.isResume()) || (MainAcitivityReportHelper.b(this.a) >= 1));
    MainAcitivityReportHelper.c(this.a);
    if (QLog.isColorLevel()) {
      QLog.e("MainActivityReportHandler", 2, "handleMessage sand msg count:" + MainAcitivityReportHelper.b(this.a));
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 300000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gke
 * JD-Core Version:    0.7.0.1
 */