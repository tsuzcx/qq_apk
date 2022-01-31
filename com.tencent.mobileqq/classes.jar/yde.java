import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FrameParent;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor.OnMoveListener;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.OnFetchFrameListener;

public class yde
  implements GestureDetector.OnGestureListener
{
  public yde(FramesProcessor paramFramesProcessor) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    FramesProcessor.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      FramesProcessor.a(this.a).fling((int)FramesProcessor.a(this.a), 0, (int)-paramFloat1, 0, (int)FramesProcessor.b(this.a), (int)FramesProcessor.c(this.a), 0, 0);
      FramesProcessor.b(this.a);
      return true;
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    do
    {
      synchronized (this.a)
      {
        FramesProcessor.a(this.a, FramesProcessor.a(this.a) + paramFloat1);
        if (FramesProcessor.a(this.a) < FramesProcessor.b(this.a)) {
          FramesProcessor.a(this.a, FramesProcessor.b(this.a));
        }
        if (FramesProcessor.a(this.a) > FramesProcessor.c(this.a)) {
          FramesProcessor.a(this.a, FramesProcessor.c(this.a));
        }
        paramFloat1 = FramesProcessor.a(this.a);
        paramFloat2 = FramesProcessor.d(this.a);
        FramesProcessor.b(this.a, FramesProcessor.a(this.a));
        if (FramesProcessor.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      FramesProcessor.a(this.a);
      if (FramesProcessor.a(this.a) != null) {
        FramesProcessor.a(this.a).a(FramesProcessor.a(this.a), FramesProcessor.b(this.a));
      }
      if (FramesProcessor.a(this.a) != null) {
        FramesProcessor.a(this.a).invalidate();
      }
    } while (FramesProcessor.a(this.a) == null);
    FramesProcessor.a(this.a).a(FramesProcessor.a(this.a), -FramesProcessor.a(this.a), FramesProcessor.e(this.a) - FramesProcessor.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yde
 * JD-Core Version:    0.7.0.1
 */