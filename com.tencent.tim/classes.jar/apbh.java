import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class apbh
  implements DialogInterface.OnDismissListener
{
  apbh(apbc paramapbc) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.c.Z) {
      this.c.Z = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbh
 * JD-Core Version:    0.7.0.1
 */