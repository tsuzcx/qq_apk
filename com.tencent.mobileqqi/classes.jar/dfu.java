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

public class dfu
  implements DialogInterface.OnClickListener
{
  public dfu(ProfileCardMoreActivity paramProfileCardMoreActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.b, "CliOper", "", "", "P_prof", "Pp_more_delete", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.b.a(1)).c(this.jdField_a_of_type_JavaLangString, (byte)2);
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.b.a(ChatActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
      }
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.b.a(ChatSettingActivity.class);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.a(2131561432, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dfu
 * JD-Core Version:    0.7.0.1
 */