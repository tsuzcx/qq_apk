import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleFuelTopView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vxh
  implements View.OnClickListener
{
  public vxh(QCircleFuelTopView paramQCircleFuelTopView) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFuelTopView.a(this.a) != null) {
      vrg.a(89, 2, ((vdq)QCircleFuelTopView.a(this.a)).a(), this.a.e());
    }
    if (QCircleFuelTopView.a(this.a) != null) {
      uxo.a(this.a.getContext(), uxn.a(QCircleFuelTopView.a(this.a), "tagFuelRankUrl"));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxh
 * JD-Core Version:    0.7.0.1
 */