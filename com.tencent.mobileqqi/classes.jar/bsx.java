import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.activity.SubaccountUgActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;

public class bsx
  implements View.OnClickListener
{
  public bsx(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.b, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.SubAccountBaseActivity.a = true;
    paramView = SubAccountDataControll.a().a(this.a.b);
    if ((paramView != null) && (!TextUtils.isEmpty(paramView.subuin)))
    {
      paramView = new Intent(this.a, SubAccountSettingActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, SubaccountUgActivity.class);
    paramView.putExtra("from_where", true);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bsx
 * JD-Core Version:    0.7.0.1
 */