import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.qphone.base.util.QLog;

public class bru
  implements View.OnClickListener
{
  public bru(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (!PhoneNumLoginImpl.a().a(this.a.b, this.a)) {
      return;
    }
    AccountManageActivity.a(this.a, SubAccountAssistantManager.a().a(this.a.b));
    paramView = new Intent();
    paramView.setPackage(this.a.getPackageName());
    paramView.setClass(this.a, LoginActivity.class);
    paramView.putExtra("IS_ADD_ACCOUNT", true);
    paramView.putExtra("login_from_account_change", true);
    this.a.startActivityForResult(paramView, 1000);
    if (QQPlayerService.a())
    {
      paramView = new Intent();
      paramView.setAction("qqplayer_exit_action");
      this.a.sendBroadcast(paramView);
    }
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bru
 * JD-Core Version:    0.7.0.1
 */