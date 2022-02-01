import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;

public class qfe
  implements View.OnTouchListener
{
  public qfe(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.b.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfe
 * JD-Core Version:    0.7.0.1
 */