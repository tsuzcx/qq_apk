import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;

public class usc
  implements View.OnClickListener
{
  public usc(ArkFlashChatItemBubbleBuilder paramArkFlashChatItemBubbleBuilder) {}
  
  public void onClick(View paramView)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramView.getTag();
    if (localMessageRecord != null) {
      ((FlashChatManager)this.a.a.getManager(216)).a(paramView.getContext(), localMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usc
 * JD-Core Version:    0.7.0.1
 */