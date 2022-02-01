import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.activity.weather.SessionClearFragment.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abcq
  implements View.OnClickListener
{
  public abcq(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(acfp.m(2131714315));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).selectAll();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SessionClearFragment.a(this.a).setText(acfp.m(2131714313));
      SessionClearFragment.a(this.a, 0);
      SessionClearFragment.a(this.a).cBd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcq
 * JD-Core Version:    0.7.0.1
 */