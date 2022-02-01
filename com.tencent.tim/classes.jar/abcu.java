import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abcu
  implements View.OnClickListener
{
  public abcu(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    SessionClearFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcu
 * JD-Core Version:    0.7.0.1
 */