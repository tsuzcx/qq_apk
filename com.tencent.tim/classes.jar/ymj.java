import android.view.View;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;

public class ymj
  implements ausj.a
{
  public ymj(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment, ChatMessage paramChatMessage, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.6.1(this), 5, null, false);
      this.this$0.b.B(this.a);
      this.this$0.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymj
 * JD-Core Version:    0.7.0.1
 */