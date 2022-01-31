import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vyj
  implements Runnable
{
  public vyj(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(700L);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.aa) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) == 3) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a())))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.aa = true;
        TroopChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).post(new vyk(this));
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(localInterruptedException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyj
 * JD-Core Version:    0.7.0.1
 */