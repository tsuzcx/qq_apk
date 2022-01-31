import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class ufo
  implements DialogInterface.OnClickListener
{
  public ufo(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.a(1)).c(this.jdField_a_of_type_JavaLangString, (byte)2);
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getHandler(ChatActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
      }
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getHandler(ChatSettingActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(2131437758, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufo
 * JD-Core Version:    0.7.0.1
 */