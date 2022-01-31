import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.open.appcommon.js.AppInterface;

public class hor
  implements DialogInterface.OnDismissListener
{
  public hor(AppInterface paramAppInterface) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.tipDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hor
 * JD-Core Version:    0.7.0.1
 */