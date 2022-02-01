import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar.a;

public class aype
  implements View.OnClickListener
{
  public aype(RateWidgetRatingBar paramRateWidgetRatingBar) {}
  
  public void onClick(View paramView)
  {
    if (RateWidgetRatingBar.a(this.b))
    {
      this.b.setStar(this.b.indexOfChild(paramView) + 1.0F);
      if (RateWidgetRatingBar.a(this.b) != null) {
        RateWidgetRatingBar.a(this.b).aj(this.b.indexOfChild(paramView) + 1.0F);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aype
 * JD-Core Version:    0.7.0.1
 */