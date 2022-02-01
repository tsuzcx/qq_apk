import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abcr
  implements View.OnClickListener
{
  public abcr(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = acfp.m(2131714316);
    localObject = aqha.a(SessionClearFragment.a(this.a), 230, acfp.m(2131714318), (String)localObject, 2131696322, 2131721952, new abcs(this), new abct(this));
    SessionClearFragment.a(this.a, (Dialog)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcr
 * JD-Core Version:    0.7.0.1
 */