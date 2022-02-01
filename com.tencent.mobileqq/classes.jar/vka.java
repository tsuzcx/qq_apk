import android.app.Activity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;

public class vka
  implements View.OnLongClickListener
{
  public vka(QCircleContentImage paramQCircleContentImage) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = ((Activity)paramView.getContext()).findViewById(2131369286);
    if (paramView != null) {
      paramView.callOnClick();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vka
 * JD-Core Version:    0.7.0.1
 */