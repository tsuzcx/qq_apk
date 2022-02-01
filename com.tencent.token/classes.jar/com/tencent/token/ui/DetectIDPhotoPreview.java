package com.tencent.token.ui;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.jni.FaceDetector.IdCardDirection;
import com.tencent.token.xv;
import com.tencent.token.ys;

public class DetectIDPhotoPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private Context a;
  private SurfaceHolder b;
  private ys c;
  private Handler d;
  private FaceDetector.IdCardDirection e;
  
  public DetectIDPhotoPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public final void a()
  {
    ys localys = this.c;
    if (localys != null)
    {
      localys.b();
      this.c = null;
    }
  }
  
  public final void a(Context paramContext, Handler paramHandler)
  {
    this.a = paramContext;
    this.d = paramHandler;
    this.b = getHolder();
    this.b.addCallback(this);
    this.b.setType(3);
  }
  
  public void setSide(FaceDetector.IdCardDirection paramIdCardDirection)
  {
    this.e = paramIdCardDirection;
  }
  
  public void setStop(boolean paramBoolean)
  {
    ys localys = this.c;
    if (localys != null) {
      localys.a = paramBoolean;
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b.getSurface() == null) {
      return;
    }
    if (this.c == null)
    {
      this.c = new ys(getContext(), paramSurfaceHolder, this.d, this.e);
      paramSurfaceHolder = this.c;
      if (paramSurfaceHolder.d == null)
      {
        Object localObject = new Camera.CameraInfo();
        paramInt2 = Camera.getNumberOfCameras();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          Camera.getCameraInfo(paramInt1, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing == 0) {
            try
            {
              paramSurfaceHolder.d = Camera.open(paramInt1);
            }
            catch (RuntimeException localRuntimeException)
            {
              StringBuilder localStringBuilder = new StringBuilder("CameraOpen camera=");
              localStringBuilder.append(paramSurfaceHolder.d);
              xv.c(localStringBuilder.toString());
              localRuntimeException.printStackTrace();
            }
          }
          paramInt1 += 1;
        }
        if (paramSurfaceHolder.d == null)
        {
          localObject = new StringBuilder("CameraOpen camera=");
          ((StringBuilder)localObject).append(paramSurfaceHolder.d);
          xv.c(((StringBuilder)localObject).toString());
          localObject = paramSurfaceHolder.b.obtainMessage(0);
          ((Message)localObject).what = 2;
          ((Message)localObject).sendToTarget();
        }
        paramSurfaceHolder.a();
        paramSurfaceHolder.c = System.currentTimeMillis();
      }
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    xv.c("surfaceDestroyed!");
    try
    {
      a();
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DetectIDPhotoPreview
 * JD-Core Version:    0.7.0.1
 */