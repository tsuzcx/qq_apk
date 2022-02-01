import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

final class ajxh
  implements DialogInterface.OnCancelListener
{
  ajxh(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.val$dismissListener.onDismiss(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxh
 * JD-Core Version:    0.7.0.1
 */