import android.app.ProgressDialog;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.manager.ServerConfigManager.ConfigType;

public class azn
  implements View.OnClickListener
{
  public azn(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    ProgressDialog localProgressDialog = DialogUtil.a(this.a, this.a.getResources().getDrawable(2130839101), 2131363556);
    localProgressDialog.setOnDismissListener(new azo(this));
    ReportLog.a(this.a.app.getAccount());
    paramView = null;
    if (this.a.app.getSid() != null) {
      paramView = this.a.app.getSid().getBytes();
    }
    ReportLog.a(paramView);
    paramView = this.a.app.a(ServerConfigManager.ConfigType.app, "log_upload");
    if ((!TextUtils.isEmpty(paramView)) && (paramView.equals("1")))
    {
      ReportLog.a(this.a.app.a(), this.a.app.a(), localProgressDialog);
      return;
    }
    ReportLog.a(this.a.app.a(), this.a.app.a(), localProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azn
 * JD-Core Version:    0.7.0.1
 */