import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import qqcircle.QQCircleDitto.StItemContainer;

public class ufh
  implements View.OnClickListener
{
  public ufh(QCircleRecommendWidget paramQCircleRecommendWidget) {}
  
  public void onClick(View paramView)
  {
    if (QCircleRecommendWidget.a(this.a) != null)
    {
      tqs.a(this.a.getContext(), tqr.a(QCircleRecommendWidget.a(this.a).urlInfo.get(), "personRecomListUrl"));
      tzs.a(29, 2, QCircleRecommendWidget.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufh
 * JD-Core Version:    0.7.0.1
 */