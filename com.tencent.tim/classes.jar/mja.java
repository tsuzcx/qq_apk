import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class mja
  implements DialogInterface.OnDismissListener
{
  mja(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.val$dismissListener.onDismiss(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mja
 * JD-Core Version:    0.7.0.1
 */