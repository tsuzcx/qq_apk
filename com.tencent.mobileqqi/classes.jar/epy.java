import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;

public class epy
  implements DialogInterface.OnKeyListener
{
  public epy(DialogBaseActivity paramDialogBaseActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epy
 * JD-Core Version:    0.7.0.1
 */