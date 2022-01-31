import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class yln
  implements View.OnClickListener
{
  public yln(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "finish all setings");
    }
    if (NetworkUtil.g(this.a))
    {
      boolean bool1 = QQSpecialFriendSettingActivity.a(this.a).a();
      boolean bool2 = QQSpecialFriendSettingActivity.b(this.a).a();
      paramView = QQSpecialFriendSettingActivity.a(this.a);
      String str = QQSpecialFriendSettingActivity.a(this.a);
      int i = QQSpecialFriendSettingActivity.a(this.a);
      paramView.a(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
      paramView = this.a.a.obtainMessage(8193);
      paramView.obj = this.a.getString(2131436919);
      this.a.a.sendMessage(paramView);
      if ((bool1) && (bool2)) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, paramView, "", "", "");
        return;
      }
    }
    paramView = this.a.a.obtainMessage(8195);
    paramView.arg1 = 0;
    paramView.arg2 = 2131433023;
    this.a.a.sendMessage(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yln
 * JD-Core Version:    0.7.0.1
 */