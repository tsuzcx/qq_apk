import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.emoticonview.EmoticonGridViewAdapter;

public class foc
  implements View.OnTouchListener
{
  public foc(EmoticonGridViewAdapter paramEmoticonGridViewAdapter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      this.a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foc
 * JD-Core Version:    0.7.0.1
 */