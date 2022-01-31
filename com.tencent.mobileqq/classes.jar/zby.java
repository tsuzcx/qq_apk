import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceRespInfo;

public class zby
  implements Runnable
{
  public zby(ConfigHandler paramConfigHandler, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    if (!ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    while (AioAnimationConfigHelper.a().a() != null) {
      return;
    }
    AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zby
 * JD-Core Version:    0.7.0.1
 */