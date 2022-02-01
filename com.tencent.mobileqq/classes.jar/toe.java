import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.GestureCropImageView;

public class toe
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private toe(GestureCropImageView paramGestureCropImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.a(paramScaleGestureDetector.getScaleFactor(), GestureCropImageView.a(this.a), GestureCropImageView.b(this.a), true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     toe
 * JD-Core Version:    0.7.0.1
 */