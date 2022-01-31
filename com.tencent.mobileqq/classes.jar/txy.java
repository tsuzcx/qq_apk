import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;

public class txy
  implements View.OnClickListener
{
  public txy(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView;
    if (QCircleContentOperationView.a(this.a) != null)
    {
      localTextView = QCircleContentOperationView.a(this.a);
      if (QCircleContentOperationView.a(this.a).a() != 1) {
        break label46;
      }
    }
    label46:
    for (paramView = QCircleContentOperationView.a(this.a);; paramView = QCircleContentOperationView.b(this.a))
    {
      localTextView.setText(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txy
 * JD-Core Version:    0.7.0.1
 */