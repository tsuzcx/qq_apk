import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vjc
  implements View.OnClickListener
{
  public vjc(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.CX();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vjc
 * JD-Core Version:    0.7.0.1
 */