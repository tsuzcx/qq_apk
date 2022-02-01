import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class zsn
  implements DialogInterface.OnKeyListener
{
  zsn(zsi paramzsi) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.this$0.a.dismiss();
      zsi.a(this.this$0, zsi.a(this.this$0), true, Long.valueOf(zsi.b(this.this$0)).longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsn
 * JD-Core Version:    0.7.0.1
 */