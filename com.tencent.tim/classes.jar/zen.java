import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zen
  implements ausj.a
{
  public zen(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryBaseTenDocFragment.a(this.this$0);
    if (paramView.size() > 0)
    {
      ThreadManager.post(new ChatHistoryBaseTenDocFragment.1.1(this, paramView), 8, null, true);
      this.this$0.coI();
    }
    if (this.c.isShowing()) {
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zen
 * JD-Core Version:    0.7.0.1
 */