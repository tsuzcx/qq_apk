import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class brh
  implements DialogInterface.OnClickListener
{
  public brh(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    this.a.finish();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     brh
 * JD-Core Version:    0.7.0.1
 */