import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;

public class cel
  extends Handler
{
  public cel(NotificationView paramNotificationView) {}
  
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
      } while (NotificationView.a(this.a) == null);
      this.a.k();
      NotificationView.a(this.a).a = GroupSystemMsgController.a().a(this.a.a);
      NotificationView.a(this.a).notifyDataSetChanged();
      return;
    }
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cel
 * JD-Core Version:    0.7.0.1
 */