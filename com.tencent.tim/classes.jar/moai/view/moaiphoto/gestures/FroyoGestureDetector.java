package moai.view.moaiphoto.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class FroyoGestureDetector
  extends EclairGestureDetector
{
  protected final ScaleGestureDetector mDetector = new ScaleGestureDetector(paramContext, new FroyoGestureDetector.1(this));
  
  public FroyoGestureDetector(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean isScaling()
  {
    return this.mDetector.isInProgress();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      this.mDetector.onTouchEvent(paramMotionEvent);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.gestures.FroyoGestureDetector
 * JD-Core Version:    0.7.0.1
 */