import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class msr
  implements DialogInterface.OnDismissListener
{
  msr(mso parammso) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (mso.a(this.this$0) != null) {
      mso.a(this.this$0).c(mso.a(this.this$0), mso.b(this.this$0), false, false);
    }
    mso.a(this.this$0, true);
    mso.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msr
 * JD-Core Version:    0.7.0.1
 */