import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zgd
  implements ausj.a
{
  public zgd(ChatHistoryEmotionBaseFragment paramChatHistoryEmotionBaseFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new ArrayList();
    if ((ChatHistoryEmotionBaseFragment.a(this.a) != null) && (!ChatHistoryEmotionBaseFragment.a(this.a).isEmpty()))
    {
      Iterator localIterator = ChatHistoryEmotionBaseFragment.a(this.a).iterator();
      while (localIterator.hasNext()) {
        paramView.add((ChatMessage)((afrq)localIterator.next()).h);
      }
    }
    if (paramView.size() > 0) {
      ThreadManager.post(new ChatHistoryEmotionBaseFragment.2.1(this, paramView), 8, null, true);
    }
    if (this.c.isShowing()) {
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zgd
 * JD-Core Version:    0.7.0.1
 */