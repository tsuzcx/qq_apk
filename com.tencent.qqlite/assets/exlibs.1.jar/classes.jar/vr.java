import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.AppRuntime.Status;

public class vr
  implements View.OnClickListener
{
  public vr(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.online;
    int i = paramView.getId();
    if (i == 2131296459)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800403A", "0X800403A", 0, 0, "", "", "", "");
      paramView = AppRuntime.Status.online;
    }
    for (;;)
    {
      this.a.a(paramView);
      if (((paramView == AppRuntime.Status.online) || (paramView == AppRuntime.Status.invisiable) || (paramView == AppRuntime.Status.away)) && (paramView != this.a.app.getOnlineStatus()))
      {
        if (!NetworkUtil.e(this.a.getApplication())) {
          break;
        }
        this.a.app.a(this.a.a(paramView), true);
      }
      return;
      if (i == 2131296460)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800403B", "0X800403B", 0, 0, "", "", "", "");
        paramView = AppRuntime.Status.invisiable;
      }
      else
      {
        paramView = localStatus;
        if (i == 2131296461) {
          paramView = AppRuntime.Status.away;
        }
      }
    }
    Toast.makeText(this.a, 2131362935, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vr
 * JD-Core Version:    0.7.0.1
 */