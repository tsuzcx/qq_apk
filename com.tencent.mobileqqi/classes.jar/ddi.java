import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ddi
  implements DialogInterface.OnClickListener
{
  public ddi(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "LeftButton", 0, 0, "", "", "", "");
      this.a.finish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ddi
 * JD-Core Version:    0.7.0.1
 */