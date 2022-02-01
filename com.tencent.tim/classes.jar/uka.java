import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;

public final class uka
  implements DialogInterface.OnClickListener
{
  public uka(ChatActivityUtils.d paramd, int paramInt, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF)
    {
      if (this.val$netType != 2) {
        break label59;
      }
      anot.a(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c.onCancel();
      }
      return;
      label59:
      if ((this.val$netType == 3) || (this.val$netType == 4)) {
        anot.a(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uka
 * JD-Core Version:    0.7.0.1
 */