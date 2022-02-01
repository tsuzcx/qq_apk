import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher;

public class pjk
  implements GestureDetector.OnDoubleTapListener
{
  public pjk(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.a(this.this$0) != null) {
      PhotoViewAttacher.a(this.this$0).aWq();
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjk
 * JD-Core Version:    0.7.0.1
 */