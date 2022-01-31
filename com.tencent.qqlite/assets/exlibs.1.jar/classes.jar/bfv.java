import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

class bfv
  implements Runnable
{
  bfv(bfu parambfu) {}
  
  public void run()
  {
    this.a.a.app.a().k();
    this.a.a.app.a().g();
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    Handler localHandler = this.a.a.app.a(Conversation.class);
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bfv
 * JD-Core Version:    0.7.0.1
 */