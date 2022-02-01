import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.AlertReport.ButtonAction;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class vix
  implements DialogInterface.OnClickListener
{
  public vix(NotificationActivity paramNotificationActivity, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      Object localObject;
      String str;
      if (!TextUtils.isEmpty(this.aOw))
      {
        paramDialogInterface = this.this$0.app.getCurrentAccountUin();
        localObject = new Intent(this.this$0, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", paramDialogInterface);
        str = this.aOw;
        if (str.indexOf("?") != -1) {
          break label203;
        }
        paramDialogInterface = str + "?uin=" + paramDialogInterface;
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("url", paramDialogInterface);
        this.this$0.startActivity((Intent)localObject);
        try
        {
          paramDialogInterface = new AlertReport.ButtonAction();
          paramDialogInterface.uint32_cmd.set(1);
          paramDialogInterface.uint32_button_id.set(this.bIR);
          paramDialogInterface.str_package_name.set(asxv.getAppPackageName());
          paramDialogInterface.uint32_app_id.set(AppSetting.getAppId());
          jnm.a(this.this$0.app, paramDialogInterface.toByteArray(), 34, "SecuritySvc.AlertReport");
          anot.a(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.bIR, 0, this.aOx, "", "", "");
          this.this$0.finish();
          return;
          label203:
          paramDialogInterface = str + "&uin=" + paramDialogInterface;
        }
        catch (Exception paramDialogInterface)
        {
          for (;;)
          {
            paramDialogInterface.printStackTrace();
          }
        }
      }
      try
      {
        localObject = new AlertReport.ButtonAction();
        ((AlertReport.ButtonAction)localObject).uint32_cmd.set(1);
        ((AlertReport.ButtonAction)localObject).uint32_button_id.set(this.bIR);
        ((AlertReport.ButtonAction)localObject).str_package_name.set(asxv.getAppPackageName());
        ((AlertReport.ButtonAction)localObject).uint32_app_id.set(AppSetting.getAppId());
        jnm.a(this.this$0.app, ((AlertReport.ButtonAction)localObject).toByteArray(), 34, "SecuritySvc.AlertReport");
        anot.a(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.bIR, 0, this.aOx, "", "", "");
        this.this$0.finish();
        throw paramDialogInterface;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface = paramDialogInterface;
      paramDialogInterface.printStackTrace();
      try
      {
        paramDialogInterface = new AlertReport.ButtonAction();
        paramDialogInterface.uint32_cmd.set(1);
        paramDialogInterface.uint32_button_id.set(this.bIR);
        paramDialogInterface.str_package_name.set(asxv.getAppPackageName());
        paramDialogInterface.uint32_app_id.set(AppSetting.getAppId());
        jnm.a(this.this$0.app, paramDialogInterface.toByteArray(), 34, "SecuritySvc.AlertReport");
        anot.a(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.bIR, 0, this.aOx, "", "", "");
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
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vix
 * JD-Core Version:    0.7.0.1
 */