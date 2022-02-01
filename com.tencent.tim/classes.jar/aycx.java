import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class aycx
  implements DialogInterface.OnCancelListener
{
  aycx(aycm paramaycm) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    aycm.b(this.this$0).eFq();
    aycm.a(this.this$0).setVisibility(0);
    if (aycm.a(this.this$0) != null) {
      aycm.a(this.this$0).startAnimation(aycm.a(this.this$0));
    }
    aycm.c(this.this$0);
    aycm.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycx
 * JD-Core Version:    0.7.0.1
 */