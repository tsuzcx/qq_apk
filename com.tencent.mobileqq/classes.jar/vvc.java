import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vvc
  implements View.OnClickListener
{
  public vvc(QCircleCommentListView paramQCircleCommentListView) {}
  
  public void onClick(View paramView)
  {
    if (QCircleCommentListView.a(this.a) != null) {
      QCircleCommentListView.a(this.a).setClickable(false);
    }
    QCircleCommentListView.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvc
 * JD-Core Version:    0.7.0.1
 */