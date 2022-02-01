import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

class dgp
  implements DialogInterface.OnKeyListener
{
  dgp(dgo paramdgo) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      RegisterSendUpSms.b(this.a.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgp
 * JD-Core Version:    0.7.0.1
 */