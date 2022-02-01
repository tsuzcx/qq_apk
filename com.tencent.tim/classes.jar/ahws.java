import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ahws
  implements DialogInterface.OnClickListener
{
  ahws(ahwp paramahwp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.aS = false;
    ahwp.a(this.this$0).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahws
 * JD-Core Version:    0.7.0.1
 */