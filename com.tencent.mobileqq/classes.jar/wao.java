import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleFuelTopView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wao
  implements View.OnClickListener
{
  public wao(QCircleFuelTopView paramQCircleFuelTopView) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFuelTopView.a(this.a) != null) {
      vtr.a(89, 2, ((vfu)QCircleFuelTopView.a(this.a)).a(), this.a.e());
    }
    if (QCircleFuelTopView.a(this.a) != null) {
      uyx.a(this.a.getContext(), uyw.a(QCircleFuelTopView.a(this.a), "tagFuelRankUrl"), null, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wao
 * JD-Core Version:    0.7.0.1
 */