import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;

public final class ukb
  implements DialogInterface.OnCancelListener
{
  public ukb(ChatActivityUtils.d paramd, int paramInt, ChatActivityUtils.c paramc) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF)
    {
      if (this.val$netType != 2) {
        break label59;
      }
      anot.a(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c.onCancel();
      }
      return;
      label59:
      if ((this.val$netType == 3) || (this.val$netType == 4)) {
        anot.a(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ukb
 * JD-Core Version:    0.7.0.1
 */