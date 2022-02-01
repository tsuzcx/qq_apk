import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class umq
  implements View.OnClickListener
{
  public umq(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.this$0.az(12, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umq
 * JD-Core Version:    0.7.0.1
 */