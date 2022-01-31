package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.x;

public class FaceRecognitionCameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private SurfaceHolder a;
  private int b = -1;
  private Handler c;
  private gx d;
  private Context e;
  private FaceView f;
  private TextView g;
  private int h;
  private ImageView i;
  private View j;
  private View k;
  private int l = 1;
  
  public FaceRecognitionCameraPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
  }
  
  public void a()
  {
    try
    {
      Window localWindow = ((Activity)this.e).getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.screenBrightness = (this.h / 255.0F);
      localWindow.setAttributes(localLayoutParams);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
    }
  }
  
  public void a(Context paramContext, int paramInt, Handler paramHandler, FaceView paramFaceView, TextView paramTextView)
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    setStop(false);
    if (this.d != null)
    {
      this.d.a(0L);
      this.d.a(paramBoolean2, paramInt1, paramInt2, true);
      this.d.b(paramBoolean1);
    }
  }
  
  public void b()
  {
    try
    {
      this.h = Settings.System.getInt(this.e.getContentResolver(), "screen_brightness");
      Window localWindow = ((Activity)this.e).getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.screenBrightness = 1.0F;
      localWindow.setAttributes(localLayoutParams);
      return;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      localSettingNotFoundException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    setStop(false);
    if (this.d != null)
    {
      this.d.a(0L);
      this.d.a(paramBoolean2, paramInt1, paramInt2, false);
      this.d.b(paramBoolean1);
    }
  }
  
  public void c()
  {
    if (this.d != null)
    {
      this.d.d();
      this.d = null;
    }
    this.e = null;
    this.c = null;
  }
  
  public Camera getCamera()
  {
    if (this.d != null) {
      return this.d.a;
    }
    return null;
  }
  
  public void setStop(boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.a(paramBoolean);
    }
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
    h.c("surfaceCreated!");
    try
    {
      b();
      h.a("set brightvalue=" + Settings.System.getInt(this.e.getContentResolver(), "screen_brightness"));
      if (this.b != 5)
      {
        this.i = ((ImageView)((Activity)this.e).findViewById(2131558696));
        this.j = ((Activity)this.e).findViewById(2131558859);
        this.k = ((Activity)this.e).findViewById(2131558860);
        if (!x.v())
        {
          this.k.setVisibility(0);
          this.k.bringToFront();
          x.w();
          this.k.postDelayed(new gv(this), 6000L);
        }
        if ((this.i != null) && (this.j != null)) {
          this.j.setOnClickListener(new gw(this));
        }
      }
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        paramSurfaceHolder.printStackTrace();
      }
    }
    if (this.d == null) {
      this.d = new gx(this.e, this.a, this.c, this.l, this.b, this.f, this.g, this.k);
    }
    this.d.c();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    h.c("surfaceDestroyed!");
    try
    {
      if (this.d != null) {
        this.d.e();
      }
      a();
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        paramSurfaceHolder.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCameraPreview
 * JD-Core Version:    0.7.0.1
 */