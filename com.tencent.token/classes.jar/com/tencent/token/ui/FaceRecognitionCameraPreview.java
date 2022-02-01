package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.token.bu;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.m;

public class FaceRecognitionCameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private SurfaceHolder a;
  private int b = -1;
  private Handler c;
  private h d;
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
    h localh = this.d;
    if (localh != null)
    {
      localh.a(0L);
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
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    setStop(false);
    h localh = this.d;
    if (localh != null)
    {
      localh.a(0L);
      this.d.a(paramBoolean2, paramInt1, paramInt2, false);
      this.d.b(paramBoolean1);
    }
  }
  
  public void c()
  {
    h localh = this.d;
    if (localh != null)
    {
      localh.d();
      this.d = null;
    }
    this.e = null;
    this.c = null;
  }
  
  public Camera getCamera()
  {
    h localh = this.d;
    if (localh != null) {
      return localh.a;
    }
    return null;
  }
  
  public void setStop(boolean paramBoolean)
  {
    h localh = this.d;
    if (localh != null) {
      localh.a(paramBoolean);
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
    g.c("surfaceCreated!");
    try
    {
      b();
      paramSurfaceHolder = new StringBuilder();
      paramSurfaceHolder.append("set brightvalue=");
      paramSurfaceHolder.append(Settings.System.getInt(this.e.getContentResolver(), "screen_brightness"));
      g.a(paramSurfaceHolder.toString());
      if (this.b != 5)
      {
        this.i = ((ImageView)((Activity)this.e).findViewById(2131165293));
        this.j = ((Activity)this.e).findViewById(2131165295);
        this.k = ((Activity)this.e).findViewById(2131165320);
        if (!m.v())
        {
          this.k.setVisibility(0);
          this.k.bringToFront();
          m.w();
          this.k.postDelayed(new Runnable()
          {
            public void run()
            {
              FaceRecognitionCameraPreview.a(FaceRecognitionCameraPreview.this).setVisibility(4);
            }
          }, 6000L);
        }
        if ((this.i != null) && (this.j != null)) {
          this.j.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              for (;;)
              {
                try
                {
                  bool = FaceRecognitionCameraPreview.b(FaceRecognitionCameraPreview.this).getBrightMode();
                  if (bool)
                  {
                    FaceRecognitionCameraPreview.d(FaceRecognitionCameraPreview.this).setImageDrawable(FaceRecognitionCameraPreview.c(FaceRecognitionCameraPreview.this).getResources().getDrawable(2131099844));
                  }
                  else
                  {
                    FaceRecognitionCameraPreview.d(FaceRecognitionCameraPreview.this).setImageDrawable(FaceRecognitionCameraPreview.c(FaceRecognitionCameraPreview.this).getResources().getDrawable(2131099845));
                    bu.a().a(System.currentTimeMillis(), 201);
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
    if (this.d == null) {
      this.d = new h(this.e, this.a, this.c, this.l, this.b, this.f, this.g, this.k);
    }
    this.d.c();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    g.c("surfaceDestroyed!");
    try
    {
      if (this.d != null) {
        this.d.e();
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