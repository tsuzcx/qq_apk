import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class dpj
  implements DialogInterface.OnClickListener
{
  public dpj(SplashActivity paramSplashActivity, CheckBox paramCheckBox) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.d()) {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a();
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity).edit();
    localEditor.putBoolean("notToastPushMsg" + paramDialogInterface, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    localEditor.putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563428) + paramDialogInterface, false);
    localEditor.putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563429) + paramDialogInterface, false);
    localEditor.putBoolean("discussion_msg_notify" + paramDialogInterface, false);
    localEditor.putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563431) + paramDialogInterface, false);
    localEditor.commit();
    paramDialogInterface = new Intent("tencent.notify.activity.setting");
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.sendBroadcast(paramDialogInterface, "com.tencent.msg.permission.pushnotify");
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dpj
 * JD-Core Version:    0.7.0.1
 */