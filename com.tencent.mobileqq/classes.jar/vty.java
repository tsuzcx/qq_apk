import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class vty
  implements View.OnClickListener
{
  public vty(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004EFC", "0X8004EFC", 0, 0, "", "", "" + this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
    }
    this.a.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vty
 * JD-Core Version:    0.7.0.1
 */