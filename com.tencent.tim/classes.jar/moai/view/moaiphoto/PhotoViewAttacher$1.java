package moai.view.moaiphoto;

import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class PhotoViewAttacher$1
  extends GestureDetector.SimpleOnGestureListener
{
  PhotoViewAttacher$1(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((PhotoViewAttacher.access$100(this.this$0) == null) || (this.this$0.getScale() > 0.6F)) {}
    while ((MotionEventCompat.getPointerCount(paramMotionEvent1) > PhotoViewAttacher.SINGLE_TOUCH) || (MotionEventCompat.getPointerCount(paramMotionEvent2) > PhotoViewAttacher.SINGLE_TOUCH)) {
      return false;
    }
    return PhotoViewAttacher.access$100(this.this$0).onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.access$000(this.this$0) != null) {
      PhotoViewAttacher.access$000(this.this$0).onLongClick(this.this$0.getImageView());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.PhotoViewAttacher.1
 * JD-Core Version:    0.7.0.1
 */