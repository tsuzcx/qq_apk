import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;

public class adz
  implements View.OnClickListener
{
  public adz(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    new aea(this, paramView.getTag(), localView).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adz
 * JD-Core Version:    0.7.0.1
 */