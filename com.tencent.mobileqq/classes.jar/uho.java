import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class uho
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private final ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private uhr jdField_a_of_type_Uhr;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final float c;
  private final float d;
  
  public uho(Context paramContext, uhr paramuhr)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.d = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = localViewConfiguration.getScaledTouchSlop();
    this.jdField_a_of_type_Uhr = paramuhr;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new uhp(this));
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getX(this.jdField_b_of_type_Int);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getX();
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getY(this.jdField_b_of_type_Int);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getY();
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int j = 0;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    label259:
    do
    {
      for (;;)
      {
        i = j;
        if (this.jdField_a_of_type_Int != -1) {
          i = this.jdField_a_of_type_Int;
        }
        this.jdField_b_of_type_Int = paramMotionEvent.findPointerIndex(i);
        return true;
        this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        }
        this.jdField_a_of_type_Float = a(paramMotionEvent);
        this.jdField_b_of_type_Float = b(paramMotionEvent);
        this.jdField_a_of_type_Boolean = false;
        continue;
        float f1 = a(paramMotionEvent);
        float f2 = b(paramMotionEvent);
        i = paramMotionEvent.getPointerCount();
        float f3 = f1 - this.jdField_a_of_type_Float;
        float f4 = f2 - this.jdField_b_of_type_Float;
        if (!this.jdField_a_of_type_Boolean) {
          if (Math.sqrt(f3 * f3 + f4 * f4) < this.c) {
            break label259;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          this.jdField_a_of_type_Boolean = bool;
          if (i > 1) {
            this.jdField_a_of_type_Boolean = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
          if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
            break;
          }
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          break;
        }
        this.jdField_a_of_type_Int = -1;
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
          continue;
          this.jdField_a_of_type_Int = -1;
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewVelocityTracker != null))
          {
            this.jdField_a_of_type_Float = a(paramMotionEvent);
            this.jdField_b_of_type_Float = b(paramMotionEvent);
            this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
            this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
            f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
            f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
            if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.d) {
              this.jdField_a_of_type_Uhr.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, -f1, -f2);
            }
          }
          if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
          {
            this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
            this.jdField_a_of_type_AndroidViewVelocityTracker = null;
          }
        }
      }
      i = uid.a(paramMotionEvent.getAction());
    } while (paramMotionEvent.getPointerId(i) != this.jdField_a_of_type_Int);
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(i);
      this.jdField_a_of_type_Float = paramMotionEvent.getX(i);
      this.jdField_b_of_type_Float = paramMotionEvent.getY(i);
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    try
    {
      boolean bool3 = this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      boolean bool4 = b(paramMotionEvent);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uho
 * JD-Core Version:    0.7.0.1
 */