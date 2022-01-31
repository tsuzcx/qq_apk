import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class ckj
  implements Handler.Callback
{
  public ckj(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ckj
 * JD-Core Version:    0.7.0.1
 */