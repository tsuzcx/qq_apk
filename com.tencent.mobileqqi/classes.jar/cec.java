import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class cec
  implements Handler.Callback
{
  public cec(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cec
 * JD-Core Version:    0.7.0.1
 */