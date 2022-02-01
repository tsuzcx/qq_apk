import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.widget.TabDragAnimationView;

public class arjl
  extends GestureDetector.SimpleOnGestureListener
{
  public arjl(TabDragAnimationView paramTabDragAnimationView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (TabDragAnimationView.a(this.b) != null) {
      return TabDragAnimationView.a(this.b).onDoubleTap(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    if (TabDragAnimationView.a(this.b) != null) {
      TabDragAnimationView.a(this.b).onLongClick(this.b);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (TabDragAnimationView.a(this.b) != null) {
      TabDragAnimationView.a(this.b).onSingleTapConfirmed(paramMotionEvent);
    }
    ViewParent localViewParent = this.b.getParent();
    if (localViewParent != null) {
      ((ViewGroup)localViewParent).performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjl
 * JD-Core Version:    0.7.0.1
 */