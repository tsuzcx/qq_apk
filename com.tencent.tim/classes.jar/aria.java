import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aria
  implements DialogInterface.OnKeyListener
{
  aria(arhz paramarhz, boolean paramBoolean) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 84) || (paramInt == 4)) {
      return this.val$isBlock;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aria
 * JD-Core Version:    0.7.0.1
 */