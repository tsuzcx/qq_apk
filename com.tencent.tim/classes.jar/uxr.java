import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxr
  implements View.OnClickListener
{
  public uxr(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.b != null) && (this.this$0.b.getVisibility() == 0)) {
      this.this$0.b.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxr
 * JD-Core Version:    0.7.0.1
 */