import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class aqbj
  implements DialogInterface.OnClickListener
{
  public aqbj(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anot.a(this.a.app, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      anot.a(this.a.app, "CliOper", "", "", "0X800714D", "0X800714D", 0, 0, "", "", "", "");
    }
    anot.a(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, aqao.BH(), String.valueOf(2), aqap.BI(), "0");
    aqap.a().es(this.a.app);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqbj
 * JD-Core Version:    0.7.0.1
 */