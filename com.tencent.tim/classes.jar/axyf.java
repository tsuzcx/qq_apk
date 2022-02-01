import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class axyf
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public axyf(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    CropVideoActivity.a(this.this$0).scale(f, f, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyf
 * JD-Core Version:    0.7.0.1
 */