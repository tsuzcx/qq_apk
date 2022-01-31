package com.tencent.token.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.jni.FaceDetector.IdCardDirection;
import com.tencent.token.global.h;

public class DetectIDPhotoPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private Context a;
  private SurfaceHolder b;
  private di c;
  private Handler d;
  private FaceDetector.IdCardDirection e;
  
  public DetectIDPhotoPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public void a()
  {
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
    }
  }
  
  public void a(Context paramContext, Handler paramHandler)
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
    if (this.c != null) {
      this.c.a(paramBoolean);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b.getSurface() == null) {}
    while (this.c != null) {
      return;
    }
    this.c = new di(getContext(), paramSurfaceHolder, this.d, this.e);
    this.c.a();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    h.c("surfaceDestroyed!");
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