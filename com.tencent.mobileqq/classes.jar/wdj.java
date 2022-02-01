import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wdj
  implements View.OnClickListener
{
  wdj(wdg paramwdg) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null)
    {
      this.a.a().a();
      vtn.a(98, 2, this.a.a, this.a.b());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdj
 * JD-Core Version:    0.7.0.1
 */