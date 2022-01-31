import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

class djo
  implements Runnable
{
  djo(djn paramdjn) {}
  
  public void run()
  {
    this.a.a.b.a().k();
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    Handler localHandler = this.a.a.b.a(Conversation.class);
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     djo
 * JD-Core Version:    0.7.0.1
 */