import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;

public class cit
  implements View.OnClickListener
{
  public cit(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    new ciu(this, paramView.getTag(), localView).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cit
 * JD-Core Version:    0.7.0.1
 */