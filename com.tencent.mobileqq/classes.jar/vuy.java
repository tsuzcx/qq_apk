import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;

class vuy
  implements DialogInterface.OnClickListener
{
  vuy(vux paramvux) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h = new Dialog(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 2131624516);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.setContentView(2130968595);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.setCancelable(true);
    ((TextView)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.findViewById(2131362776)).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131434453));
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.h.show();
    ((HotChatHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.a.jdField_a_of_type_JavaLangString, 1);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuy
 * JD-Core Version:    0.7.0.1
 */