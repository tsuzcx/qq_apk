import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aft
  implements DialogInterface.OnClickListener
{
  public aft(ChatSettingForTroop paramChatSettingForTroop, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aft
 * JD-Core Version:    0.7.0.1
 */