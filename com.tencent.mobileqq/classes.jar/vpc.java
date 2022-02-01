import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vpc
  implements View.OnClickListener
{
  public vpc(QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView) {}
  
  public void onClick(View paramView)
  {
    QQToast.a(this.a.getContext(), 0, 2131697227, 0).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpc
 * JD-Core Version:    0.7.0.1
 */