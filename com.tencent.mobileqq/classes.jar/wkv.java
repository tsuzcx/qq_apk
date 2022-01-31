import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class wkv
  implements DialogInterface.OnDismissListener
{
  wkv(wku paramwku) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.deleteObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wkv
 * JD-Core Version:    0.7.0.1
 */