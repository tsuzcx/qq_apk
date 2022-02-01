import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher;
import com.tencent.qphone.base.util.QLog;

public class pjj
  extends GestureDetector.SimpleOnGestureListener
{
  public pjj(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((PhotoViewAttacher.a(this.this$0) == null) || (this.this$0.getScale() > PhotoViewAttacher.ax())) {}
    while ((paramMotionEvent1.getPointerCount() > PhotoViewAttacher.se()) || (paramMotionEvent2.getPointerCount() > PhotoViewAttacher.se())) {
      return false;
    }
    return PhotoViewAttacher.a(this.this$0).onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.a(this.this$0) != null) {
      PhotoViewAttacher.a(this.this$0).onLongClick(PhotoViewAttacher.a(this.this$0));
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    QLog.d("PhotoViewAttacher", 4, "onScroll distanceX:" + paramFloat1 + " distanceY:" + paramFloat2);
    paramFloat1 = 0.0F - paramFloat1;
    paramFloat2 = 0.0F - paramFloat2;
    if (PhotoViewAttacher.a(this.this$0) != null) {
      PhotoViewAttacher.a(this.this$0).onDrag(paramFloat1, paramFloat2);
    }
    return this.this$0.w(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjj
 * JD-Core Version:    0.7.0.1
 */