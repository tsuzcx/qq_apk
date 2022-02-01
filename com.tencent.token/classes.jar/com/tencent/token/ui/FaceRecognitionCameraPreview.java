package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.aae;
import com.tencent.token.ru;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.xb;
import com.tencent.token.xx;

public class FaceRecognitionCameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  xx a;
  private SurfaceHolder b;
  private int c = -1;
  private Handler d;
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
  
  public final void a()
  {
    try
    {
      Window localWindow = ((Activity)this.e).getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.screenBrightness = (this.h / 255.0F);
      localWindow.setAttributes(localLayoutParams);
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void a(Context paramContext, int paramInt, Handler paramHandler, FaceView paramFaceView, TextView paramTextView)
  {
    this.e = paramContext;
    this.d = paramHandler;
    this.c = paramInt;
    this.b = getHolder();
    this.b.addCallback(this);
    this.b.setType(3);
    this.f = paramFaceView;
    this.g = paramTextView;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    setStop(false);
    xx localxx = this.a;
    if (localxx != null)
    {
      localxx.c = 0L;
      localxx.a(paramBoolean2, paramInt1, paramInt2, true);
      this.a.b = paramBoolean1;
    }
  }
  
  public final void b()
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
    catch (Error localError)
    {
      localError.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      localSettingNotFoundException.printStackTrace();
    }
  }
  
  public final void c()
  {
    xx localxx = this.a;
    if (localxx != null)
    {
      localxx.a();
      this.a = null;
    }
    this.e = null;
    this.d = null;
  }
  
  public Camera getCamera()
  {
    xx localxx = this.a;
    if (localxx != null) {
      return localxx.d;
    }
    return null;
  }
  
  public void setStop(boolean paramBoolean)
  {
    xx localxx = this.a;
    if (localxx != null) {
      localxx.a = paramBoolean;
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b.getSurface() == null) {
      return;
    }
    paramSurfaceHolder = this.f;
    StringBuilder localStringBuilder = new StringBuilder("changescreenwidth=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", screenheight=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", titleheight=");
    localStringBuilder.append(IndexActivity.S_STATUS_HEIGHT);
    xb.c(localStringBuilder.toString());
    if (paramInt3 != paramSurfaceHolder.c)
    {
      paramSurfaceHolder.b = paramInt2;
      paramSurfaceHolder.c = paramInt3;
      paramSurfaceHolder.f = (paramSurfaceHolder.b / 2);
      paramSurfaceHolder.g = ((int)((paramSurfaceHolder.c - paramSurfaceHolder.a * 40.0F) / 2.0F));
      FaceView.j = (paramSurfaceHolder.f - paramSurfaceHolder.e) / paramSurfaceHolder.b;
      FaceView.k = (paramSurfaceHolder.g - paramSurfaceHolder.e) / paramSurfaceHolder.c;
      FaceView.l = paramSurfaceHolder.e * 2.0F / paramSurfaceHolder.b;
      FaceView.m = paramSurfaceHolder.e * 2.0F / paramSurfaceHolder.c;
      paramInt1 = 1;
      paramSurfaceHolder.h = paramSurfaceHolder.f;
      paramSurfaceHolder.i = paramSurfaceHolder.g;
    }
    else
    {
      paramInt1 = 0;
    }
    if ((paramSurfaceHolder.d == null) || (paramInt1 != 0))
    {
      paramSurfaceHolder.d = new Rect(0, 0, paramSurfaceHolder.b, paramSurfaceHolder.c);
      paramSurfaceHolder.invalidate();
    }
    this.f.invalidate();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    xb.c("surfaceCreated!");
    try
    {
      b();
      paramSurfaceHolder = new StringBuilder("set brightvalue=");
      paramSurfaceHolder.append(Settings.System.getInt(this.e.getContentResolver(), "screen_brightness"));
      xb.a(paramSurfaceHolder.toString());
      if (this.c != 5)
      {
        this.i = ((ImageView)((Activity)this.e).findViewById(2131165295));
        this.j = ((Activity)this.e).findViewById(2131165297);
        this.k = ((Activity)this.e).findViewById(2131165323);
        if (!aae.v())
        {
          this.k.setVisibility(0);
          this.k.bringToFront();
          aae.w();
          this.k.postDelayed(new Runnable()
          {
            public final void run()
            {
              FaceRecognitionCameraPreview.a(FaceRecognitionCameraPreview.this).setVisibility(4);
            }
          }, 6000L);
        }
        if ((this.i != null) && (this.j != null)) {
          this.j.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              for (;;)
              {
                try
                {
                  bool = FaceRecognitionCameraPreview.b(FaceRecognitionCameraPreview.this).getBrightMode();
                  if (bool)
                  {
                    FaceRecognitionCameraPreview.d(FaceRecognitionCameraPreview.this).setImageDrawable(FaceRecognitionCameraPreview.c(FaceRecognitionCameraPreview.this).getResources().getDrawable(2131099845));
                  }
                  else
                  {
                    FaceRecognitionCameraPreview.d(FaceRecognitionCameraPreview.this).setImageDrawable(FaceRecognitionCameraPreview.c(FaceRecognitionCameraPreview.this).getResources().getDrawable(2131099846));
                    ru.a().a(System.currentTimeMillis(), 201);
                  }
                  paramAnonymousView = FaceRecognitionCameraPreview.b(FaceRecognitionCameraPreview.this);
                  if (!bool)
                  {
                    bool = true;
                    paramAnonymousView.setBrightMode(bool);
                    return;
                  }
                }
                catch (Error paramAnonymousView)
                {
                  paramAnonymousView.printStackTrace();
                  return;
                }
                catch (Exception paramAnonymousView)
                {
                  paramAnonymousView.printStackTrace();
                  return;
                }
                boolean bool = false;
              }
            }
          });
        }
      }
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
    if (this.a == null) {
      this.a = new xx(this.e, this.b, this.d, this.l, this.c, this.f, this.g, this.k);
    }
    paramSurfaceHolder = this.a;
    if (paramSurfaceHolder.d == null) {
      try
      {
        paramSurfaceHolder.b();
        paramSurfaceHolder.c();
        return;
      }
      catch (Exception paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    xb.c("surfaceDestroyed!");
    try
    {
      if (this.a != null)
      {
        paramSurfaceHolder = this.a;
        if (paramSurfaceHolder.d != null)
        {
          paramSurfaceHolder.d.setPreviewCallback(null);
          paramSurfaceHolder.d.stopPreview();
          paramSurfaceHolder.d.release();
          paramSurfaceHolder.d = null;
        }
      }
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCameraPreview
 * JD-Core Version:    0.7.0.1
 */