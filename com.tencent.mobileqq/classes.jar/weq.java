import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class weq
  implements ScaleGestureDetector.OnScaleGestureListener
{
  weq(wep paramwep) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f))) {
      return false;
    }
    if (f >= 0.0F) {
      wep.a(this.a).a(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if (wep.a(this.a) != null) {
      wep.a(this.a).a(f);
    }
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if (wep.a(this.a) != null) {
      wep.a(this.a).a(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     weq
 * JD-Core Version:    0.7.0.1
 */