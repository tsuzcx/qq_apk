import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkDialogActivity;

public class ifl
  implements DialogInterface.OnDismissListener
{
  public ifl(QlinkDialogActivity paramQlinkDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ifl
 * JD-Core Version:    0.7.0.1
 */