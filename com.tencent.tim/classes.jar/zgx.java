import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.widget.XListView;

public class zgx
  extends Handler
{
  public zgx(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != 1) || (ChatHistoryTroopFileFragment.a(this.this$0) == null)) {}
    for (;;)
    {
      return;
      int i = ChatHistoryTroopFileFragment.a(this.this$0).getFirstVisiblePosition();
      while (i <= ChatHistoryTroopFileFragment.a(this.this$0).getLastVisiblePosition())
      {
        paramMessage = ChatHistoryTroopFileFragment.a(this.this$0).getChildAt(i);
        if (paramMessage != null)
        {
          paramMessage = paramMessage.getTag();
          if ((paramMessage != null) && ((paramMessage instanceof apei))) {
            ((apei)paramMessage).y(this.this$0.mApp, ChatHistoryTroopFileFragment.a(this.this$0));
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zgx
 * JD-Core Version:    0.7.0.1
 */