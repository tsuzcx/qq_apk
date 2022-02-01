import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vmv
  implements View.OnClickListener
{
  public vmv(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(View paramView)
  {
    if (((QCircleContentOperationView.a(this.a) instanceof vlx)) && (((vlx)QCircleContentOperationView.a(this.a)).a != null)) {
      ((vlx)QCircleContentOperationView.a(this.a)).a.M_();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmv
 * JD-Core Version:    0.7.0.1
 */