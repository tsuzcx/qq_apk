import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

class ulg
  implements Runnable
{
  ulg(ulf paramulf, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "VoiceResStrategy");
      }
      if ((this.jdField_a_of_type_Ulf.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager == null) || (this.jdField_a_of_type_Ulf.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager == null))
      {
        CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
        return;
      }
      String str = this.jdField_a_of_type_Ulf.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager.a("voice_pwd", "http://imgcache.qq.com/channel/static/socialpay/voice/", new String[] { "urlPrefix" });
      str = str + "voice_rate_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.templateId + ".zip";
      this.jdField_a_of_type_Ulf.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.a(str, new ulh(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulg
 * JD-Core Version:    0.7.0.1
 */