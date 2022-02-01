import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tys
  implements View.OnClickListener
{
  tys(tyr paramtyr) {}
  
  public void onClick(View paramView)
  {
    twr.a(tyr.a(this.a), 1000, null);
    uhs.a((Activity)tyr.a(this.a), tyr.a(this.a), tyr.a(this.a).a(), tyr.a(this.a).e(), false, twq.b(tyr.a(this.a)), new trj());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tys
 * JD-Core Version:    0.7.0.1
 */