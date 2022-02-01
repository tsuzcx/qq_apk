import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.a;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView.a;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView.b;
import mqq.os.MqqHandler;

public class aheo
  implements ArkAppView.a
{
  public aheo(FlashChatTextEffectView.a parama, FlashChatTextEffectView.b paramb, int paramInt) {}
  
  public void bCR() {}
  
  public void loadSucc()
  {
    FlashChatTextEffectView.c(this.a);
    Message localMessage = Message.obtain();
    localMessage.obj = this.a;
    localMessage.what = this.val$position;
    if (this.val$position < FlashChatTextEffectView.access$100().length)
    {
      FlashChatTextEffectView.a.a(this.b).sendMessageDelayed(localMessage, FlashChatTextEffectView.access$100()[this.val$position]);
      return;
    }
    FlashChatTextEffectView.a.a(this.b).sendMessageDelayed(localMessage, 7000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aheo
 * JD-Core Version:    0.7.0.1
 */