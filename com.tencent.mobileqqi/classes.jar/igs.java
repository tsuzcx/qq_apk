import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

public final class igs
  implements DialogInterface.OnDismissListener
{
  public igs(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     igs
 * JD-Core Version:    0.7.0.1
 */