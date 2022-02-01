import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class awjc
  implements DialogInterface.OnDismissListener
{
  awjc(awjb paramawjb, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$dismissListener != null) {
      this.val$dismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjc
 * JD-Core Version:    0.7.0.1
 */