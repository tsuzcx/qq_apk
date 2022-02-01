import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher;

public class wfe
  implements GestureDetector.OnDoubleTapListener
{
  public wfe(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.a(this.a) != null) {
      PhotoViewAttacher.a(this.a).a();
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.a.a();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (PhotoViewAttacher.a(this.a) != null) {
      PhotoViewAttacher.a(this.a).a(PhotoViewAttacher.a(this.a), f1, f2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfe
 * JD-Core Version:    0.7.0.1
 */