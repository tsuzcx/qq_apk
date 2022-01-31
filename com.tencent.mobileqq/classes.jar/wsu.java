import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class wsu
{
  private static wsu jdField_a_of_type_Wsu;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  
  public static wsu a()
  {
    if (jdField_a_of_type_Wsu == null) {}
    try
    {
      if (jdField_a_of_type_Wsu == null) {
        jdField_a_of_type_Wsu = new wsu();
      }
      return jdField_a_of_type_Wsu;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsu
 * JD-Core Version:    0.7.0.1
 */