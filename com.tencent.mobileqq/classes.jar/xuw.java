import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import mqq.os.MqqHandler;

public class xuw
  extends MqqHandler
{
  public xuw(ContactsInnerFrame paramContactsInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    ContactsInnerFrame.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuw
 * JD-Core Version:    0.7.0.1
 */