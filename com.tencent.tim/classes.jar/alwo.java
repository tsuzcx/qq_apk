import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

public class alwo
  implements GLGestureListener
{
  private final int DOUBLE_TAP_TIMEOUT;
  private final int TOUCH_SLOP;
  private long ahN;
  int bif;
  private final int dyE;
  private MotionEvent mCurrentDownEvent;
  int mDoubleTapSlopSquare;
  private MotionEvent mPreviousUpEvent;
  
  public alwo(Context paramContext)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    this.dyE = 1000;
    this.bif = paramContext.getScaledDoubleTapSlop();
    this.mDoubleTapSlopSquare = (this.bif * this.bif);
    this.TOUCH_SLOP = paramContext.getScaledTouchSlop();
    this.ahN = 0L;
  }
  
  private boolean f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = (int)paramFloat3 - (int)paramFloat1;
    int j = (int)paramFloat4 - (int)paramFloat2;
    return i * i + j * j > this.TOUCH_SLOP;
  }
  
  private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((Math.abs(System.currentTimeMillis() - this.ahN) < this.dyE) || (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > this.DOUBLE_TAP_TIMEOUT) || (f(paramMotionEvent1.getX(), paramMotionEvent1.getY(), paramMotionEvent2.getX(), paramMotionEvent2.getY())));
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= this.mDoubleTapSlopSquare);
    return true;
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean)) {}
    switch (j & 0xFF)
    {
    default: 
      return false;
    case 0: 
      GLSurfaceView localGLSurfaceView;
      if (isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, paramMotionEvent))
      {
        localGLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
        if (localGLSurfaceView != null)
        {
          this.ahN = System.currentTimeMillis();
          if (!(localGLSurfaceView instanceof CameraCaptureView)) {
            break label168;
          }
          ((CameraCaptureView)localGLSurfaceView).dKT();
        }
      }
      for (;;)
      {
        rar.a("camera_clkdouble", alwx.dyy, 0, new String[0]);
        alwx.dKx();
        if (QLog.isColorLevel()) {
          QLog.d("GLGestureListener", 2, new Object[] { "", "CameraSwitchGesture" });
        }
        if (this.mCurrentDownEvent != null) {
          this.mCurrentDownEvent.recycle();
        }
        this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
        return false;
        label168:
        if ((localGLSurfaceView instanceof AECameraGLSurfaceView)) {
          ((AECameraGLSurfaceView)localGLSurfaceView).dKT();
        }
      }
    }
    if (this.mPreviousUpEvent != null) {
      this.mPreviousUpEvent.recycle();
    }
    this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwo
 * JD-Core Version:    0.7.0.1
 */