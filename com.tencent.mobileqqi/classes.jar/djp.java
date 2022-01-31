import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;

public class djp
  implements View.OnClickListener
{
  public djp(SplashActivity paramSplashActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231667)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.e = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(), this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131561654), "qqsetting_receivemsg_whenexit_key", bool);
    int j = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a().f();
    paramView = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.getManager(32);
    if (paramView != null) {}
    for (int i = paramView.a(1);; i = 0)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getSharedPreferences("unreadcount", 0).edit();
      paramView.putInt("unread", i + j);
      paramView.commit();
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.g();
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.e;
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.d = true;
      if (QQPlayerService.a())
      {
        paramView = new Intent();
        paramView.setAction("qqplayer_exit_action");
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.sendBroadcast(paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.finish();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     djp
 * JD-Core Version:    0.7.0.1
 */