import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class whv
  implements View.OnClickListener
{
  public whv(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    ReminderListFragment.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whv
 * JD-Core Version:    0.7.0.1
 */