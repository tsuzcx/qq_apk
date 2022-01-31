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

public class ddl
  implements View.OnClickListener
{
  public ddl(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    ProgressDialog localProgressDialog = DialogUtil.a(this.a, this.a.getResources().getDrawable(2130839680), 2131562878);
    localProgressDialog.setOnDismissListener(new ddm(this));
    ReportLog.a(this.a.b.getAccount());
    paramView = null;
    if (this.a.b.getSid() != null) {
      paramView = this.a.b.getSid().getBytes();
    }
    ReportLog.a(paramView);
    paramView = this.a.b.a(ServerConfigManager.ConfigType.app, "log_upload");
    if ((!TextUtils.isEmpty(paramView)) && (paramView.equals("1")))
    {
      ReportLog.a(this.a.b.a(), this.a.b.a(), localProgressDialog);
      return;
    }
    ReportLog.a(this.a.b.a(), this.a.b.a(), localProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ddl
 * JD-Core Version:    0.7.0.1
 */