import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class udb
  implements DialogInterface.OnDismissListener
{
  public udb(UpgradeActivity paramUpgradeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     udb
 * JD-Core Version:    0.7.0.1
 */