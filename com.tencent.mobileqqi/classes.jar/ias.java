import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

public final class ias
  implements DialogInterface.OnDismissListener
{
  public ias(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ias
 * JD-Core Version:    0.7.0.1
 */