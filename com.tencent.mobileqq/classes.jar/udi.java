import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.statistics.ReportController;

public class udi
  implements DialogInterface.OnClickListener
{
  public udi(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800714C", "0X800714C", 0, 0, "", "", "", "");
    }
    UpgradeActivity.a(this.a, false);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     udi
 * JD-Core Version:    0.7.0.1
 */