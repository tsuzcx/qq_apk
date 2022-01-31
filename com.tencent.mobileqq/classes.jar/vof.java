import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class vof
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float d;
  
  public vof(Context paramContext, String paramString)
  {
    this.jdField_c_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    int i = 3;
    int j = paramMotionEvent.getAction() & 0xFF;
    if ((j == 3) || (j == 1))
    {
      Log.v(this.jdField_a_of_type_JavaLangString, "Intercept done!");
      i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Int = -1;
      return i;
    }
    if (j != 0)
    {
      if (this.jdField_a_of_type_Int != 0)
      {
        Log.v(this.jdField_a_of_type_JavaLangString, "Intercept returning true! " + this.jdField_a_of_type_Int);
        return this.jdField_a_of_type_Int;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        Log.v(this.jdField_a_of_type_JavaLangString, "Intercept returning false!");
        return 0;
      }
    }
    switch (j)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Int;
      j = this.jdField_b_of_type_Int;
      if (j != -1)
      {
        j = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
        float f1 = MotionEventCompat.getX(paramMotionEvent, j);
        float f3 = f1 - this.jdField_a_of_type_Float;
        float f4 = Math.abs(f3);
        float f2 = MotionEventCompat.getY(paramMotionEvent, j);
        float f5 = f2 - this.jdField_b_of_type_Float;
        float f6 = Math.abs(f5);
        Log.v(this.jdField_a_of_type_JavaLangString, "Moved x to " + f1 + "," + f2 + " diff=" + f4 + "," + f6 + ", mTouchSlop=" + this.jdField_c_of_type_Int);
        if ((f4 > this.jdField_c_of_type_Int) && (f4 > f6))
        {
          Log.v(this.jdField_a_of_type_JavaLangString, "Starting drag horizontal !");
          if (f3 > 0.0F)
          {
            label325:
            this.jdField_a_of_type_Int = i;
            if (f3 <= 0.0F) {
              break label368;
            }
          }
          label368:
          for (f1 = this.jdField_c_of_type_Float + this.jdField_c_of_type_Int;; f1 = this.jdField_c_of_type_Float - this.jdField_c_of_type_Int)
          {
            this.jdField_a_of_type_Float = f1;
            this.jdField_b_of_type_Float = f2;
            break;
            i = 1;
            break label325;
          }
        }
        if ((f6 > this.jdField_c_of_type_Int) && (f6 > f4))
        {
          Log.v(this.jdField_a_of_type_JavaLangString, "Starting drag vertical !");
          if (f5 > 0.0F)
          {
            i = 4;
            label421:
            this.jdField_a_of_type_Int = i;
            this.jdField_a_of_type_Float = f1;
            if (f5 <= 0.0F) {
              break label464;
            }
          }
          label464:
          for (f1 = this.d + this.jdField_c_of_type_Int;; f1 = this.d - this.jdField_c_of_type_Int)
          {
            this.jdField_b_of_type_Float = f1;
            break;
            i = 2;
            break label421;
          }
          f1 = paramMotionEvent.getX();
          this.jdField_c_of_type_Float = f1;
          this.jdField_a_of_type_Float = f1;
          f1 = paramMotionEvent.getY();
          this.d = f1;
          this.jdField_b_of_type_Float = f1;
          this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Int = 0;
          if (this.jdField_a_of_type_AndroidViewMotionEvent != null) {
            this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
          }
          this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          Log.v(this.jdField_a_of_type_JavaLangString, "Down at " + this.jdField_a_of_type_Float + "," + this.jdField_b_of_type_Float + " mIsBeingDragged=" + this.jdField_a_of_type_Int + "mIsUnableToDrag=" + this.jdField_a_of_type_Boolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vof
 * JD-Core Version:    0.7.0.1
 */