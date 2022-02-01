import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ajao
  implements DialogInterface.OnDismissListener
{
  ajao(ajam paramajam, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.i != null) {
      this.i.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajao
 * JD-Core Version:    0.7.0.1
 */