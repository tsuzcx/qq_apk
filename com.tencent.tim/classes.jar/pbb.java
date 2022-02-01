import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pbb
  implements View.OnClickListener
{
  public pbb(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView;
    if (QCircleContentOperationView.a(this.this$0) != null)
    {
      localTextView = QCircleContentOperationView.a(this.this$0);
      if (QCircleContentOperationView.a(this.this$0).rZ() != 1) {
        break label53;
      }
    }
    label53:
    for (String str = QCircleContentOperationView.a(this.this$0);; str = QCircleContentOperationView.b(this.this$0))
    {
      localTextView.setText(str);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbb
 * JD-Core Version:    0.7.0.1
 */