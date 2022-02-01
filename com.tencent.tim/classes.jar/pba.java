import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.b;

public class pba
  implements QCircleExpandableTextView.b
{
  public pba(QCircleContentOperationView paramQCircleContentOperationView, View.OnClickListener paramOnClickListener) {}
  
  public void ro(boolean paramBoolean)
  {
    Object localObject = this.this$0;
    int i;
    QCircleContentOperationView localQCircleContentOperationView;
    if (paramBoolean)
    {
      i = 2130844865;
      ((QCircleContentOperationView)localObject).setBackgroundResource(i);
      localQCircleContentOperationView = this.this$0;
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (localObject = this.cE;; localObject = null)
    {
      localQCircleContentOperationView.setOnClickListener((View.OnClickListener)localObject);
      this.this$0.setClickable(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pba
 * JD-Core Version:    0.7.0.1
 */