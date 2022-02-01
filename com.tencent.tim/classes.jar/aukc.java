import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aukc
  implements DialogInterface.OnKeyListener
{
  aukc(aujz paramaujz) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (aujz.a(this.this$0) != null)) {
      aujz.a(this.this$0).dUm();
    }
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukc
 * JD-Core Version:    0.7.0.1
 */