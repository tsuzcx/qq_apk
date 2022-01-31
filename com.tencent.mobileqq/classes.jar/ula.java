import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

class ula
  implements Runnable
{
  ula(ukz paramukz, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "ThemeAnimStrategy");
    }
    if ((ukz.a(this.jdField_a_of_type_Ukz) == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.templateId)))
    {
      CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.templateId + ".zip";
    ukz.a(this.jdField_a_of_type_Ukz).a(str, "", new ulb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ula
 * JD-Core Version:    0.7.0.1
 */