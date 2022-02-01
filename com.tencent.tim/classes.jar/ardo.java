import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ardo
  implements View.OnClickListener
{
  public ardo(HalfScreenBrowserActivity paramHalfScreenBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    this.this$0.overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardo
 * JD-Core Version:    0.7.0.1
 */