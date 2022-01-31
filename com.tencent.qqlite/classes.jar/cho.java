import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;

public class cho
  implements DialogInterface.OnKeyListener
{
  public cho(DialogBaseActivity paramDialogBaseActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cho
 * JD-Core Version:    0.7.0.1
 */