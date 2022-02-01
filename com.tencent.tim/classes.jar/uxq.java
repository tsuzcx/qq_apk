import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxq
  implements View.OnClickListener
{
  public uxq(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.isFinishing()) {
      ForwardRecentActivity.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */