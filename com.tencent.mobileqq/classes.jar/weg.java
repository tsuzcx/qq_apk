import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class weg
{
  private static weg jdField_a_of_type_Weg;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  
  public static weg a()
  {
    if (jdField_a_of_type_Weg == null) {}
    try
    {
      if (jdField_a_of_type_Weg == null) {
        jdField_a_of_type_Weg = new weg();
      }
      return jdField_a_of_type_Weg;
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
 * Qualified Name:     weg
 * JD-Core Version:    0.7.0.1
 */