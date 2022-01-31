import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.maproam.Utils;

public final class gfu
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == Utils.a) {
      Utils.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfu
 * JD-Core Version:    0.7.0.1
 */