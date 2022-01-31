import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ytc
  implements DialogInterface.OnDismissListener
{
  ytc(ytb paramytb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.deleteObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytc
 * JD-Core Version:    0.7.0.1
 */