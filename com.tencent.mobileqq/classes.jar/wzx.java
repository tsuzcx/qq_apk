import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class wzx
  implements DialogInterface.OnDismissListener
{
  wzx(wzw paramwzw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.deleteObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzx
 * JD-Core Version:    0.7.0.1
 */