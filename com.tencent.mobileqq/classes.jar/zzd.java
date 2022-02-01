import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class zzd
{
  private static zzd jdField_a_of_type_Zzd;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  
  public static zzd a()
  {
    if (jdField_a_of_type_Zzd == null) {}
    try
    {
      if (jdField_a_of_type_Zzd == null) {
        jdField_a_of_type_Zzd = new zzd();
      }
      return jdField_a_of_type_Zzd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzd
 * JD-Core Version:    0.7.0.1
 */