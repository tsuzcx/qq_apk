import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class dzq
  implements DialogInterface.OnDismissListener
{
  public dzq(UpgradeActivity paramUpgradeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dzq
 * JD-Core Version:    0.7.0.1
 */