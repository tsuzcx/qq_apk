import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.RegisterActivity;

public class dey
  implements DialogInterface.OnKeyListener
{
  public dey(RegisterActivity paramRegisterActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      RegisterActivity.b(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dey
 * JD-Core Version:    0.7.0.1
 */