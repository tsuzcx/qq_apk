import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxo
  implements View.OnClickListener
{
  public uxo(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D97", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxo
 * JD-Core Version:    0.7.0.1
 */