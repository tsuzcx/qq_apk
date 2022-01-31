import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import java.lang.ref.WeakReference;

public class epz
  extends Handler
{
  private WeakReference a;
  
  public epz(DialogBaseActivity paramDialogBaseActivity)
  {
    this.a = new WeakReference(paramDialogBaseActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    DialogBaseActivity localDialogBaseActivity = (DialogBaseActivity)this.a.get();
    if (localDialogBaseActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      localDialogBaseActivity.a(paramMessage.arg1);
      return;
    }
    localDialogBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epz
 * JD-Core Version:    0.7.0.1
 */