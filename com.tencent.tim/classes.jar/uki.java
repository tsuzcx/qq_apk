import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ChatActivityUtils.d;

public final class uki
  implements DialogInterface.OnClickListener
{
  public uki(ChatActivityUtils.c paramc, ChatActivityUtils.d paramd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$c.onCancel();
    }
    jjk.S(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    jjk.kX(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$d.aTF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uki
 * JD-Core Version:    0.7.0.1
 */