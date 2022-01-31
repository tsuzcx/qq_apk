import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;

public class cbm
  implements MessageQueue.IdleHandler
{
  public cbm(AddContactsActivity paramAddContactsActivity) {}
  
  public boolean queueIdle()
  {
    this.a.a.sendEmptyMessage(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbm
 * JD-Core Version:    0.7.0.1
 */