import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.VideoControlUI;

public class jee
  implements View.OnTouchListener
{
  public jee(VideoControlUI paramVideoControlUI) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.this$0.mGestureDetector != null) {
      return this.this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jee
 * JD-Core Version:    0.7.0.1
 */