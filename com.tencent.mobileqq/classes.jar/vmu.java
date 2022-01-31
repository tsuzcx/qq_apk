import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;

public class vmu
  implements View.OnTouchListener
{
  public vmu(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.a.a.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmu
 * JD-Core Version:    0.7.0.1
 */