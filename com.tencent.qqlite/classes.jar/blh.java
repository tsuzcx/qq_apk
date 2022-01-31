import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;

public class blh
  implements View.OnClickListener
{
  public blh(SplashActivity paramSplashActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297087)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.e = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131363748), "qqsetting_receivemsg_whenexit_key", bool);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().e();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getSharedPreferences("unreadcount", 0).edit();
    paramView.putInt("unread", i);
    paramView.commit();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.f();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.e;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.d = true;
    if (QQPlayerService.a())
    {
      paramView = new Intent();
      paramView.setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.sendBroadcast(paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.finish();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     blh
 * JD-Core Version:    0.7.0.1
 */