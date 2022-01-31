import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher;

public class uib
  implements GestureDetector.OnDoubleTapListener
{
  public uib(PhotoViewAttacher paramPhotoViewAttacher) {}
  
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uib
 * JD-Core Version:    0.7.0.1
 */