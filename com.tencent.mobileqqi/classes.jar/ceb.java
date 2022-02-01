import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class ceb
  implements Handler.Callback
{
  public ceb(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ceb
 * JD-Core Version:    0.7.0.1
 */