import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.data.ChatBackgroundInfo;

class act
  implements DialogInterface.OnClickListener
{
  act(acr paramacr, ChatBackgroundInfo paramChatBackgroundInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Acr.a.a.jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo = this.jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo;
    ChatBackgroundSettingActivity.a(this.jdField_a_of_type_Acr.a.a, "OPENVIP_DOWN", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     act
 * JD-Core Version:    0.7.0.1
 */