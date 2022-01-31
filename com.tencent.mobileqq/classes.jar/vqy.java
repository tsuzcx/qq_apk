import android.text.Editable;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class vqy
  implements Runnable
{
  public vqy(BaseTroopChatPie paramBaseTroopChatPie, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().delete(i - 1, i);
    }
    SpannableString localSpannableString = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.y(), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {}
    do
    {
      return;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, localSpannableString);
      BaseTroopChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie).a(1);
      if (this.jdField_a_of_type_Int == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Press_AIOhead_sendatmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("0")))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqy
 * JD-Core Version:    0.7.0.1
 */