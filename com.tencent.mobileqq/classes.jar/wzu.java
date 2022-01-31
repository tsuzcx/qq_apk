import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class wzu
  implements DialogInterface.OnDismissListener
{
  wzu(wzt paramwzt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.deleteObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzu
 * JD-Core Version:    0.7.0.1
 */