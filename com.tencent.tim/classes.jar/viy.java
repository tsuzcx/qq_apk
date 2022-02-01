import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.AlertReport.ButtonAction;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class viy
  implements DialogInterface.OnClickListener
{
  public viy(NotificationActivity paramNotificationActivity, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new AlertReport.ButtonAction();
      paramDialogInterface.uint32_cmd.set(1);
      paramDialogInterface.uint32_button_id.set(this.bIS);
      paramDialogInterface.str_package_name.set(asxv.getAppPackageName());
      paramDialogInterface.uint32_app_id.set(AppSetting.getAppId());
      jnm.a(this.this$0.app, paramDialogInterface.toByteArray(), 34, "SecuritySvc.AlertReport");
      anot.a(null, "P_CliOper", "Safe_AlertReport", "", "0X8007535", "0X8007535", this.bIS, 0, this.aOx, "", "", "");
      this.this$0.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     viy
 * JD-Core Version:    0.7.0.1
 */