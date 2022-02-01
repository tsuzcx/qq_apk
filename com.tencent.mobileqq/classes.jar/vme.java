import android.app.Activity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;

public class vme
  implements View.OnLongClickListener
{
  public vme(QCircleContentImage paramQCircleContentImage) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = ((Activity)paramView.getContext()).findViewById(2131369376);
    if (paramView != null) {
      paramView.callOnClick();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vme
 * JD-Core Version:    0.7.0.1
 */