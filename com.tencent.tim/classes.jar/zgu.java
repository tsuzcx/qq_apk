import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;

public class zgu
  implements ausj.a
{
  public zgu(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment, ChatMessage paramChatMessage, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      ThreadManager.post(new ChatHistoryTroopAllFragment.6.1(this), 5, null, false);
      this.this$0.b.B(this.a);
      if (this.this$0.b.getCount() == 0) {
        this.this$0.d.setEmptyView(ChatHistoryTroopAllFragment.a(this.this$0));
      }
      this.this$0.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zgu
 * JD-Core Version:    0.7.0.1
 */