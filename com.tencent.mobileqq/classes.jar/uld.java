import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

class uld
  implements Runnable
{
  uld(ulc paramulc, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "ThemeCustomizeStrategy");
      }
      if ((ulc.a(this.jdField_a_of_type_Ulc) == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.templateId)))
      {
        CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
        return;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.templateId + ".png";
      ulc.a(this.jdField_a_of_type_Ulc).b(str, new ule(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uld
 * JD-Core Version:    0.7.0.1
 */