import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zgz
  implements View.OnClickListener
{
  public zgz(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ChatHistoryTroopFileFragment.a(this.this$0) != null) {
        ChatHistoryTroopFileFragment.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zgz
 * JD-Core Version:    0.7.0.1
 */