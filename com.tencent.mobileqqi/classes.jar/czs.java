import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.PortraitImageview.SimpleOnScaleGestureListener;

public class czs
  extends PortraitImageview.SimpleOnScaleGestureListener
{
  public czs(PortraitImageview paramPortraitImageview) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.isInProgress())) {
      try
      {
        float f1 = this.a.a();
        float f2 = paramScaleGestureDetector.getScaleFactor();
        f1 = Math.min(this.a.e(), Math.max(f1 * f2, 0.1F));
        this.a.a(f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        this.a.invalidate();
        return true;
      }
      catch (IllegalArgumentException paramScaleGestureDetector)
      {
        paramScaleGestureDetector.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czs
 * JD-Core Version:    0.7.0.1
 */