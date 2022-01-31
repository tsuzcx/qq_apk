import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class bbb
  implements DialogInterface.OnClickListener
{
  public bbb(ProfileCardMoreActivity paramProfileCardMoreActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app, "CliOper", "", "", "P_prof", "Pp_more_delete", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app.a(1)).c(this.jdField_a_of_type_JavaLangString, (byte)2);
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app.a(ChatActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
      }
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app.a(ChatSettingActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.a(2131362937, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbb
 * JD-Core Version:    0.7.0.1
 */