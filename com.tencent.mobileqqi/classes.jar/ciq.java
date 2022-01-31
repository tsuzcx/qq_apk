import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;

public class ciq
  implements View.OnClickListener
{
  public ciq(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    new cir(this, paramView.getTag(), localView).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ciq
 * JD-Core Version:    0.7.0.1
 */