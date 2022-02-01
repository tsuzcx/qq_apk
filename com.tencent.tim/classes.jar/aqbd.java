import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class aqbd
  implements DialogInterface.OnDismissListener
{
  public aqbd(UpgradeActivity paramUpgradeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqbd
 * JD-Core Version:    0.7.0.1
 */