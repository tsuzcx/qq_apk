import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;

public final class umh
  implements DialogInterface.OnCancelListener
{
  public umh(ChatActivityUtils.d paramd, ChatActivityUtils.c paramc) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF) {
      anot.a(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c.onCancel();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umh
 * JD-Core Version:    0.7.0.1
 */