import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import mqq.os.MqqHandler;

class tkf
  implements Runnable
{
  tkf(tke paramtke) {}
  
  public void run()
  {
    this.a.a.app.a().e(true);
    this.a.a.app.a().h();
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    MqqHandler localMqqHandler = this.a.a.app.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkf
 * JD-Core Version:    0.7.0.1
 */