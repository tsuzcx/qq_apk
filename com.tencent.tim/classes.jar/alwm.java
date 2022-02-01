import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

public class alwm
  implements GLGestureListener
{
  private ViewStub K;
  private final int TOUCH_SLOP;
  private CameraFocusView b;
  int bif;
  private long currentTime;
  private float currentX;
  private float currentY;
  private final int dyD;
  private long lastDownTime;
  int mDoubleTapSlopSquare;
  private float yY;
  private float yZ;
  
  public alwm(ViewStub paramViewStub)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramViewStub.getContext());
    this.dyD = 300;
    this.TOUCH_SLOP = localViewConfiguration.getScaledTouchSlop();
    this.bif = localViewConfiguration.getScaledDoubleTapSlop();
    this.mDoubleTapSlopSquare = (this.bif * this.bif);
    this.K = paramViewStub;
  }
  
  public alwm(CameraFocusView paramCameraFocusView)
  {
    this.b = paramCameraFocusView;
    paramCameraFocusView = ViewConfiguration.get(paramCameraFocusView.getContext());
    this.dyD = 300;
    this.TOUCH_SLOP = paramCameraFocusView.getScaledTouchSlop();
    this.bif = paramCameraFocusView.getScaledDoubleTapSlop();
    this.mDoubleTapSlopSquare = (this.bif * this.bif);
  }
  
  private boolean B(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 < this.dyD;
  }
  
  private void a(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.lastDownTime = System.currentTimeMillis();
              this.yY = paramMotionEvent.getX();
              this.yZ = paramMotionEvent.getY();
              return;
              this.currentTime = System.currentTimeMillis();
              this.currentX = paramMotionEvent.getX();
              this.currentY = paramMotionEvent.getY();
            } while ((f(this.yY, this.yZ, this.currentX, this.currentY)) || (!B(this.lastDownTime, this.currentTime)));
            dKn();
            if ((!(paramGLSurfaceView instanceof CameraCaptureView)) || (this.b == null)) {
              break;
            }
          } while (((CameraCaptureView)paramGLSurfaceView).Is() == 1);
          this.b.F(paramMotionEvent);
          a((CameraCaptureView)paramGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
        } while (!QLog.isColorLevel());
        QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
        return;
      } while ((!(paramGLSurfaceView instanceof AECameraGLSurfaceView)) || (this.b == null) || (((AECameraGLSurfaceView)paramGLSurfaceView).Is() == 1));
      this.b.F(paramMotionEvent);
      a((AECameraGLSurfaceView)paramGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
    } while (!QLog.isColorLevel());
    QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
  }
  
  private boolean a(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    boolean bool = true;
    int[] arrayOfInt = new int[2];
    paramGLSurfaceView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramGLSurfaceView.getWidth();
    int m = paramGLSurfaceView.getHeight();
    if ((paramMotionEvent.getRawX() < i) || (paramMotionEvent.getRawX() > i + k) || (paramMotionEvent.getRawY() < j) || (paramMotionEvent.getRawY() > j + m)) {
      bool = false;
    }
    return bool;
  }
  
  private void b(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return;
      this.lastDownTime = System.currentTimeMillis();
      this.yY = paramMotionEvent.getX(1);
      this.yZ = paramMotionEvent.getY(1);
      return;
      this.currentTime = System.currentTimeMillis();
      this.currentX = paramMotionEvent.getX(1);
      this.currentY = paramMotionEvent.getY(1);
    } while ((f(this.yY, this.yZ, this.currentX, this.currentY)) || (!B(this.lastDownTime, this.currentTime)));
    paramMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
    dKn();
    if (((paramGLSurfaceView instanceof CameraCaptureView)) && (this.b != null) && (((CameraCaptureView)paramGLSurfaceView).Is() != 1))
    {
      this.b.F(paramMotionEvent);
      a((CameraCaptureView)paramGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == true" });
      }
    }
    paramMotionEvent.recycle();
  }
  
  private void dKn()
  {
    if ((this.b == null) && (this.K != null)) {
      this.b = ((CameraFocusView)this.K.inflate());
    }
  }
  
  private boolean f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = (int)paramFloat3 - (int)paramFloat1;
    int j = (int)paramFloat4 - (int)paramFloat2;
    return i * i + j * j > this.TOUCH_SLOP * this.TOUCH_SLOP;
  }
  
  protected void a(CameraCaptureView paramCameraCaptureView, float paramFloat1, float paramFloat2)
  {
    paramCameraCaptureView.X(paramFloat1, paramFloat2);
  }
  
  protected void a(AECameraGLSurfaceView paramAECameraGLSurfaceView, float paramFloat1, float paramFloat2)
  {
    paramAECameraGLSurfaceView.X(paramFloat1, paramFloat2);
  }
  
  public void dKo()
  {
    if (this.b != null) {
      this.b.brX();
    }
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    GLSurfaceView localGLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
    if (!a(paramMotionEvent, localGLSurfaceView)) {}
    do
    {
      return false;
      if ((!paramBoolean) && (i == 1)) {
        a(paramMotionEvent, localGLSurfaceView);
      }
    } while ((!paramBoolean) || (i != 2));
    b(paramMotionEvent, localGLSurfaceView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwm
 * JD-Core Version:    0.7.0.1
 */