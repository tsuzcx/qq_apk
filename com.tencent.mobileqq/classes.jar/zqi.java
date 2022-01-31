import com.tencent.mobileqq.app.PhoneUnityBannerData;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.qphone.base.util.QLog;

public class zqi
  implements Runnable
{
  public zqi(PhoneUnityManager paramPhoneUnityManager) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    PhoneUnityBannerData localPhoneUnityBannerData = this.a.a();
    ((SecSvcHandler)this.a.a.a(34)).a(9, true, localPhoneUnityBannerData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqi
 * JD-Core Version:    0.7.0.1
 */