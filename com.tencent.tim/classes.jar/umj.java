import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;

public final class umj
  implements DialogInterface.OnClickListener
{
  public umj(ChatActivityUtils.d paramd, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF) {
      anot.a(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c.onCancel();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umj
 * JD-Core Version:    0.7.0.1
 */