import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class tmr
  implements Runnable
{
  private WeakReference a;
  
  public tmr(QQSettingMe paramQQSettingMe)
  {
    this.a = new WeakReference(paramQQSettingMe);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          return;
        }
        QQSettingMe localQQSettingMe = (QQSettingMe)this.a.get();
        if ((localQQSettingMe == null) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        WebProcessManager localWebProcessManager = (WebProcessManager)localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (localWebProcessManager == null) {
          break;
        }
        if (ApolloUtil.a(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView))
        {
          i = 100;
          localWebProcessManager.a(i, new tms(this, localQQSettingMe));
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 1, "WebPreloadTask preloadWebProcess, exception=" + MsfSdkUtils.getStackTraceString(localException));
        return;
      }
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmr
 * JD-Core Version:    0.7.0.1
 */