import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dzx
  implements DialogInterface.OnClickListener
{
  public dzx(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.b, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    this.a.finish();
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dzx
 * JD-Core Version:    0.7.0.1
 */