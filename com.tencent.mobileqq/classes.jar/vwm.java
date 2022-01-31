import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class vwm
  implements Runnable
{
  public vwm(NearbyChatPie paramNearbyChatPie, String paramString) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.f, 4, "0X80052C5, " + this.jdField_a_of_type_JavaLangString);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052C5", "0X80052C5", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
    for (String str = "0";; str = "1")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_send", 0, 0, str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwm
 * JD-Core Version:    0.7.0.1
 */