import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vmp
  implements View.OnClickListener
{
  public vmp(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(View paramView)
  {
    QCircleContentOperationView.a(this.a, 4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmp
 * JD-Core Version:    0.7.0.1
 */