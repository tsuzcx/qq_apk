import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class yvw
  implements DialogInterface.OnKeyListener
{
  yvw(yvs paramyvs) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvw
 * JD-Core Version:    0.7.0.1
 */