import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class yhm
{
  private static yhm jdField_a_of_type_Yhm;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  
  public static yhm a()
  {
    if (jdField_a_of_type_Yhm == null) {}
    try
    {
      if (jdField_a_of_type_Yhm == null) {
        jdField_a_of_type_Yhm = new yhm();
      }
      return jdField_a_of_type_Yhm;
    }
    finally {}
  }
  
  public qq_ad_get.QQAdGet.DeviceInfo a()
  {
    a();
    return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  }
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new SubscribeAdDeviceInfoHelper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhm
 * JD-Core Version:    0.7.0.1
 */