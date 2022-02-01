import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;

public class epc
  extends Handler
{
  public epc(ContactsInnerFrame paramContactsInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a.setPadding(0, 0, 40, 0);
      return;
    case 2: 
      this.a.a.setPadding(0, 0, 0, 0);
      return;
    }
    ContactsInnerFrame.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epc
 * JD-Core Version:    0.7.0.1
 */