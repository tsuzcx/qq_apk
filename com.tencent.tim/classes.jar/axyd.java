import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class axyd
  extends GestureDetector.SimpleOnGestureListener
{
  public axyd(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    paramMotionEvent.getY();
    CropVideoActivity.a(this.this$0).scale(2.0F, 2.0F, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyd
 * JD-Core Version:    0.7.0.1
 */