import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.h;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.h.c;

public class xuy
  implements View.OnTouchListener
{
  public xuy(PhotoListPanel.h.c paramc, PhotoListPanel.h paramh) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuy
 * JD-Core Version:    0.7.0.1
 */