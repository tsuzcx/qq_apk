package com.tencent.token.ui;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.TextView;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceView;

public class FaceRecognitionCameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private SurfaceHolder a;
  private int b = -1;
  private Handler c;
  private hx d;
  private Context e;
  private FaceView f;
  private TextView g;
  private int h = 1;
  
  public FaceRecognitionCameraPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
  }
  
  public void a()
  {
    if (this.d != null)
    {
      this.d.b();
      this.d = null;
    }
    this.e = null;
    this.c = null;
  }
  
  public final void a(int paramInt)
  {
    a(false);
    if (this.d != null)
    {
      this.d.c();
      this.d.a(false, 0, paramInt, false);
      this.d.b(true);
    }
  }
  
  public final void a(Context paramContext, int paramInt, Handler paramHandler, FaceView paramFaceView, TextView paramTextView)
  {
    this.e = paramContext;
    this.c = paramHandler;
    this.b = paramInt;
    this.a = getHolder();
    this.a.addCallback(this);
    this.a.setType(3);
    this.f = paramFaceView;
    this.g = paramTextView;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.a(paramBoolean);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    a(false);
    if (this.d != null)
    {
      this.d.c();
      this.d.a(paramBoolean2, paramInt1, paramInt2, true);
      this.d.b(paramBoolean1);
    }
  }
  
  public final Camera b()
  {
    if (this.d != null) {
      return this.d.a;
    }
    return null;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.getSurface() == null) {
      return;
    }
    this.f.a(paramInt2, paramInt3);
    this.f.invalidate();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    e.c("surfaceCreated!");
    if (this.d == null) {
      this.d = new hx(this.a, this.c, this.h, this.b, this.f, this.g);
    }
    this.d.a();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    e.c("surfaceDestroyed!");
    try
    {
      if (this.d != null)
      {
        paramSurfaceHolder = this.d;
        if (paramSurfaceHolder.a != null)
        {
          paramSurfaceHolder.a.setPreviewCallback(null);
          paramSurfaceHolder.a.stopPreview();
          paramSurfaceHolder.a.release();
          paramSurfaceHolder.a = null;
        }
      }
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCameraPreview
 * JD-Core Version:    0.7.0.1
 */