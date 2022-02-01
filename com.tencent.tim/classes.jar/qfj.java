import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView;

public class qfj
  implements View.OnTouchListener
{
  public qfj(MyVideoVisibleTroopPageView paramMyVideoVisibleTroopPageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.b.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfj
 * JD-Core Version:    0.7.0.1
 */