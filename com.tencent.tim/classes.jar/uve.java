import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uve
  implements View.OnClickListener
{
  public uve(DiscussionMemberActivity paramDiscussionMemberActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.n.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uve
 * JD-Core Version:    0.7.0.1
 */