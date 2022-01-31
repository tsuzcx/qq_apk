import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.statistics.ReportController;

public class ugh
  implements DialogInterface.OnClickListener
{
  public ugh(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800714D", "0X800714D", 0, 0, "", "", "", "");
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.a(), "0");
    UpgradeController.a().a(this.a.app);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ugh
 * JD-Core Version:    0.7.0.1
 */