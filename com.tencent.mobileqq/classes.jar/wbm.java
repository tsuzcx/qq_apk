import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher;
import com.tencent.qphone.base.util.QLog;

public class wbm
  extends GestureDetector.SimpleOnGestureListener
{
  public wbm(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((PhotoViewAttacher.a(this.a) == null) || (this.a.a() > PhotoViewAttacher.d())) {}
    while ((paramMotionEvent1.getPointerCount() > PhotoViewAttacher.a()) || (paramMotionEvent2.getPointerCount() > PhotoViewAttacher.a())) {
      return false;
    }
    return PhotoViewAttacher.a(this.a).a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.a(this.a) != null) {
      PhotoViewAttacher.a(this.a).onLongClick(PhotoViewAttacher.a(this.a));
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    QLog.d("PhotoViewAttacher", 4, "onScroll distanceX:" + paramFloat1 + " distanceY:" + paramFloat2);
    paramFloat1 = 0.0F - paramFloat1;
    paramFloat2 = 0.0F - paramFloat2;
    if (PhotoViewAttacher.a(this.a) != null) {
      PhotoViewAttacher.a(this.a).a(paramFloat1, paramFloat2);
    }
    return this.a.a(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbm
 * JD-Core Version:    0.7.0.1
 */