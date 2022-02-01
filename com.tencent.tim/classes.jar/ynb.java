import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;

public class ynb
  extends Handler
{
  public ynb(AddContactsActivity paramAddContactsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.a.cjP();
      this.a.bnD = false;
      return;
    }
    obg.a().uv(300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynb
 * JD-Core Version:    0.7.0.1
 */