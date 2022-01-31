import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class vwk
  implements View.OnClickListener
{
  public vwk(NearbyChatPie paramNearbyChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 10002)) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514F", "0X800514F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
      PlusPanelUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1010) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C6", "0X80049C6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwk
 * JD-Core Version:    0.7.0.1
 */