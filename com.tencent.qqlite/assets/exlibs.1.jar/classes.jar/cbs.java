import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;

public class cbs
  implements MessageQueue.IdleHandler
{
  public cbs(AddContactsActivity paramAddContactsActivity) {}
  
  public boolean queueIdle()
  {
    this.a.a.sendEmptyMessage(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbs
 * JD-Core Version:    0.7.0.1
 */