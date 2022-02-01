import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;

public class vmk
  implements View.OnTouchListener
{
  public vmk(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      return this.a.a.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmk
 * JD-Core Version:    0.7.0.1
 */