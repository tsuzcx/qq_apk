import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import mqq.os.MqqHandler;

public class ywc
  extends MqqHandler
{
  public ywc(NotificationView paramNotificationView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (this.this$0.b == null);
      this.this$0.clB();
      this.this$0.b.unreadMsgNum = anze.a().af(this.this$0.app);
      this.this$0.b.notifyDataSetChanged();
      return;
    }
    this.this$0.cmu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywc
 * JD-Core Version:    0.7.0.1
 */