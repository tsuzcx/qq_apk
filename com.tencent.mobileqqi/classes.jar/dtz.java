import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class dtz
  implements DialogInterface.OnDismissListener
{
  public dtz(UpgradeActivity paramUpgradeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dtz
 * JD-Core Version:    0.7.0.1
 */