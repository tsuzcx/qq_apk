import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ved
  implements View.OnClickListener
{
  public ved(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bPT();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ved
 * JD-Core Version:    0.7.0.1
 */