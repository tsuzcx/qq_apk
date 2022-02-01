import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.math.BigDecimal;

public class alwr
  implements GLGestureListener
{
  public GLSurfaceView d;
  private float mJ;
  private float mK;
  public float mL;
  
  public alwr(GLSurfaceView paramGLSurfaceView)
  {
    this.d = paramGLSurfaceView;
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    if ((j != 3) || ((i == 1) && (paramBoolean))) {
      switch (j)
      {
      }
    }
    float f4;
    float f2;
    float f3;
    for (;;)
    {
      return false;
      this.mK = this.mL;
      continue;
      if (paramMotionEvent.getY() >= this.mL)
      {
        this.mK = this.mL;
      }
      else
      {
        i = new BigDecimal((this.mK - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
        if ((i != 0) && (this.d != null))
        {
          if ((this.d instanceof CameraCaptureView)) {
            ((CameraCaptureView)this.d).setZoom(i);
          }
          for (;;)
          {
            this.mK = paramMotionEvent.getY();
            break;
            if ((this.d instanceof AECameraGLSurfaceView)) {
              ((AECameraGLSurfaceView)this.d).setZoom(i);
            }
          }
          if ((i == 2) && (!paramBoolean))
          {
            ram.v("CameraZoomGesture", "onTouchEvent %s", new Object[] { paramMotionEvent });
            if (i != 2) {
              break;
            }
            f4 = paramMotionEvent.getX(0);
            f2 = paramMotionEvent.getY(0);
            f3 = paramMotionEvent.getX(1);
            f1 = paramMotionEvent.getY(1);
            label254:
            switch (j)
            {
            }
          }
        }
      }
    }
    float f1 = rex.e(f4, f2, f3, f1);
    i = new BigDecimal((f1 - this.mJ) / 20.0F).setScale(0, 4).intValue();
    if ((i != 0) && (this.d != null))
    {
      if (!(this.d instanceof CameraCaptureView)) {
        break label421;
      }
      ((CameraCaptureView)this.d).setZoom(i);
    }
    for (;;)
    {
      this.mJ = f1;
      return true;
      f4 = paramMotionEvent.getX(1);
      f2 = paramMotionEvent.getY(1);
      f3 = paramMotionEvent.getX(2);
      f1 = paramMotionEvent.getY(2);
      break label254;
      this.mJ = rex.e(f4, f2, f3, f1);
      break;
      label421:
      if ((this.d instanceof AECameraGLSurfaceView)) {
        ((AECameraGLSurfaceView)this.d).setZoom(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwr
 * JD-Core Version:    0.7.0.1
 */