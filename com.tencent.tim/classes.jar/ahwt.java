import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ahwt
  implements DialogInterface.OnDismissListener
{
  ahwt(ahwp paramahwp) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.this$0.aS)
    {
      this.this$0.aS = false;
      ahwp.a(this.this$0).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwt
 * JD-Core Version:    0.7.0.1
 */