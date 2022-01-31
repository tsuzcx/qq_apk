import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class bya
  implements DialogInterface.OnClickListener
{
  public bya(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.activity.SubAccountBaseActivity.a = true;
    com.tencent.mobileqq.activity.SubAccountBaseActivity.b = true;
    paramDialogInterface = new Intent();
    List localList = this.a.getAppRuntime().getApplication().getAllAccounts();
    if ((localList != null) && (localList.size() > 1)) {
      paramDialogInterface.setClass(this.a, SubAccountBindActivity.class);
    }
    for (;;)
    {
      this.a.startActivity(paramDialogInterface);
      ReportController.a(this.a.b, "CliOper", "", "", "0X80040A6", "0X80040A6", 0, 0, "", "", "", "");
      this.a.e();
      return;
      paramDialogInterface.setClass(this.a, SubLoginActivity.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bya
 * JD-Core Version:    0.7.0.1
 */