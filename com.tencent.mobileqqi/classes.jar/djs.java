import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class djs
  implements DialogInterface.OnClickListener
{
  public djs(SplashActivity paramSplashActivity, CheckBox paramCheckBox) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.e()) {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a();
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity).edit();
    localEditor.putBoolean("notToastPushMsg" + paramDialogInterface, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    localEditor.putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563456) + paramDialogInterface, true);
    localEditor.putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563457) + paramDialogInterface, true);
    localEditor.putBoolean("discussion_msg_notify" + paramDialogInterface, true);
    localEditor.putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563459) + paramDialogInterface, true);
    localEditor.commit();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     djs
 * JD-Core Version:    0.7.0.1
 */