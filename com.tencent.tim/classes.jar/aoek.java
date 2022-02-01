import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aoek
  implements DialogInterface.OnKeyListener
{
  aoek(aoeh paramaoeh) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (aoeh.a(this.this$0) != null)) {
      aoeh.a(this.this$0).dUm();
    }
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoek
 * JD-Core Version:    0.7.0.1
 */