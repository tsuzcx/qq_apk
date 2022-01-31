import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy;
import com.tencent.qphone.base.util.QLog;

public class zmu
  implements Runnable
{
  public zmu(IndividualRedPacketManager.VIPHBStrategy paramVIPHBStrategy, IndividualRedPacketManager paramIndividualRedPacketManager, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      IndividualRedPacketManager.a(IndividualRedPacketManager.VIPHBStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$VIPHBStrategy), this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(IndividualRedPacketManager.b(), 1, "dealRedPacketToShow failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmu
 * JD-Core Version:    0.7.0.1
 */