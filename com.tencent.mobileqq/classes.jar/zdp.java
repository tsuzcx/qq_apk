import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class zdp
  implements zdo
{
  private static int jdField_e_of_type_Int = ;
  private static final int jdField_f_of_type_Int = ViewConfiguration.getTapTimeout();
  private static final int jdField_g_of_type_Int = ViewConfiguration.getDoubleTapTimeout();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  GestureDetector.OnDoubleTapListener jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener;
  final GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener;
  MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private boolean h = true;
  
  public zdp(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (this.jdField_a_of_type_AndroidOsHandler = new zdq(this, paramHandler);; this.jdField_a_of_type_AndroidOsHandler = new zdq(this))
    {
      this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        a((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      a(paramContext);
      return;
    }
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    this.jdField_g_of_type_Boolean = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.jdField_c_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_d_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.jdField_a_of_type_Int = (i * i);
    this.jdField_b_of_type_Int = (j * j);
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (!this.jdField_e_of_type_Boolean) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > jdField_g_of_type_Int);
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= this.jdField_b_of_type_Int);
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
    this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onLongPress(this.jdField_a_of_type_AndroidViewMotionEvent);
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener = paramOnDoubleTapListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i;
    int k;
    label53:
    int n;
    int m;
    float f1;
    float f2;
    if ((i1 & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label95;
      }
      k = paramMotionEvent.getActionIndex();
      n = paramMotionEvent.getPointerCount();
      m = 0;
      f1 = 0.0F;
      f2 = 0.0F;
      label66:
      if (m >= n) {
        break label122;
      }
      if (k != m) {
        break label101;
      }
    }
    for (;;)
    {
      m += 1;
      break label66;
      i = 0;
      break;
      label95:
      k = -1;
      break label53;
      label101:
      f2 += paramMotionEvent.getX(m);
      f1 += paramMotionEvent.getY(m);
    }
    label122:
    if (i != 0)
    {
      i = n - 1;
      f2 /= i;
      f1 /= i;
    }
    float f3;
    boolean bool2;
    float f4;
    int j;
    switch (i1 & 0xFF)
    {
    case 4: 
    default: 
    case 5: 
    case 6: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return false;
          i = n;
          break;
          this.jdField_a_of_type_Float = f2;
          this.jdField_c_of_type_Float = f2;
          this.jdField_b_of_type_Float = f1;
          this.jdField_d_of_type_Float = f1;
          c();
          return false;
          this.jdField_a_of_type_Float = f2;
          this.jdField_c_of_type_Float = f2;
          this.jdField_b_of_type_Float = f1;
          this.jdField_d_of_type_Float = f1;
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
          k = paramMotionEvent.getActionIndex();
          i = paramMotionEvent.getPointerId(k);
          f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i);
          f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
          i = 0;
        } while (i >= n);
        if (i == k) {}
        do
        {
          i += 1;
          break;
          m = paramMotionEvent.getPointerId(i);
          f3 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(m);
        } while (this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(m) * f2 + f3 * f1 >= 0.0F);
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
        return false;
        if (this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener != null)
        {
          bool2 = this.jdField_a_of_type_AndroidOsHandler.hasMessages(3);
          if (bool2) {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
          }
          if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (this.jdField_b_of_type_AndroidViewMotionEvent != null) && (bool2) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent))) {
            this.jdField_f_of_type_Boolean = true;
          }
        }
        for (boolean bool1 = this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTap(this.jdField_a_of_type_AndroidViewMotionEvent) | false | this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
        {
          this.jdField_a_of_type_Float = f2;
          this.jdField_c_of_type_Float = f2;
          this.jdField_b_of_type_Float = f1;
          this.jdField_d_of_type_Float = f1;
          if (this.jdField_a_of_type_AndroidViewMotionEvent != null) {
            this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
          }
          this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          this.jdField_d_of_type_Boolean = true;
          this.jdField_e_of_type_Boolean = true;
          this.jdField_a_of_type_Boolean = true;
          this.jdField_c_of_type_Boolean = false;
          this.jdField_b_of_type_Boolean = false;
          if (this.jdField_g_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(2, this.jdField_a_of_type_AndroidViewMotionEvent.getDownTime() + jdField_f_of_type_Int + jdField_e_of_type_Int);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(1, this.jdField_a_of_type_AndroidViewMotionEvent.getDownTime() + jdField_f_of_type_Int);
          return bool1 | this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onDown(paramMotionEvent);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, jdField_g_of_type_Int);
        }
      } while ((this.jdField_c_of_type_Boolean) && (!this.h));
      f3 = this.jdField_a_of_type_Float - f2;
      f4 = this.jdField_b_of_type_Float - f1;
      if (this.jdField_f_of_type_Boolean) {
        return false | this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        j = (int)(f2 - this.jdField_c_of_type_Float);
        k = (int)(f1 - this.jdField_d_of_type_Float);
        j = j * j + k * k;
        if (j <= this.jdField_a_of_type_Int) {
          break label1143;
        }
        bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onScroll(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent, f3, f4);
        this.jdField_a_of_type_Float = f2;
        this.jdField_b_of_type_Float = f1;
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.jdField_a_of_type_Int) {
        this.jdField_e_of_type_Boolean = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onScroll(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent, f3, f4);
      this.jdField_a_of_type_Float = f2;
      this.jdField_b_of_type_Float = f1;
      return bool2;
      this.jdField_a_of_type_Boolean = false;
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.jdField_f_of_type_Boolean) {
        bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_AndroidViewMotionEvent != null) {
          this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
        }
        this.jdField_b_of_type_AndroidViewMotionEvent = localMotionEvent;
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.jdField_f_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        return bool2;
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
          this.jdField_c_of_type_Boolean = false;
          bool2 = false;
        }
        else if (this.jdField_d_of_type_Boolean)
        {
          boolean bool3 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.jdField_b_of_type_Boolean)
          {
            bool2 = bool3;
            if (this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener != null)
            {
              this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          localVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
          f1 = localVelocityTracker.getYVelocity(j);
          f2 = localVelocityTracker.getXVelocity(j);
          if ((Math.abs(f1) > this.jdField_c_of_type_Int) || (Math.abs(f2) > this.jdField_c_of_type_Int))
          {
            bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onFling(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent, f2, f1);
            continue;
            b();
            return false;
          }
          else
          {
            bool2 = false;
          }
        }
      }
      label1143:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdp
 * JD-Core Version:    0.7.0.1
 */