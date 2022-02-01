import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class due
  implements DialogInterface.OnClickListener
{
  public due(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.b, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    UpgradeActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     due
 * JD-Core Version:    0.7.0.1
 */