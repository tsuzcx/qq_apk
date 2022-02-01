import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class akpg
  extends ScaleGestureDetector
{
  private float xW;
  private float xX;
  
  public akpg(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    super(paramContext, paramOnScaleGestureListener);
    dCF();
  }
  
  @TargetApi(19)
  private boolean asx()
  {
    return (Build.VERSION.SDK_INT >= 19) && (isQuickScaleEnabled()) && (getCurrentSpan() == getCurrentSpanY());
  }
  
  private void dCF()
  {
    long l = System.currentTimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public float getScaleFactor()
  {
    float f2 = 1.0F;
    float f3 = super.getScaleFactor();
    if (asx())
    {
      float f1;
      if ((this.xW <= this.xX) || (f3 <= 1.0F))
      {
        f1 = f2;
        if (this.xW < this.xX)
        {
          f1 = f2;
          if (f3 >= 1.0F) {}
        }
      }
      else
      {
        f1 = Math.max(0.8F, Math.min(f3, 1.25F));
      }
      return f1;
    }
    return f3;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.xX = this.xW;
    this.xW = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 0) {
      this.xX = paramMotionEvent.getY();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpg
 * JD-Core Version:    0.7.0.1
 */