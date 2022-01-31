import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

class uhs
  implements Runnable
{
  uhs(uhr paramuhr, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy");
      }
      if ((this.jdField_a_of_type_Uhr.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager == null) || (this.jdField_a_of_type_Uhr.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.templateId)))
      {
        CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
        return;
      }
      String str = this.jdField_a_of_type_Uhr.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager.a("redPackPanel", "http://i.gtimg.cn/channel/imglib/201803/", new String[] { "themeInfo", "prefix" });
      str = str + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.templateId + ".png";
      this.jdField_a_of_type_Uhr.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.b(str, new uht(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */