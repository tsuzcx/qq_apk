import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.5.1;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uno
  implements View.OnClickListener
{
  public uno(ChatHistory.a parama, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    new ChatHistory.ChatHistoryAdapter.5.1(this, paramView.getTag(), localView).run();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uno
 * JD-Core Version:    0.7.0.1
 */