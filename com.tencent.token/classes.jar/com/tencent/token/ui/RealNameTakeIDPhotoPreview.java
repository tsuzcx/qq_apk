package com.tencent.token.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.token.global.g;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RealNameTakeIDPhotoPreview
  extends SurfaceView
  implements Camera.AutoFocusCallback, SurfaceHolder.Callback
{
  public Camera a;
  private SurfaceHolder b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private Timer i;
  private TimerTask j;
  private Handler k;
  
  public RealNameTakeIDPhotoPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.g = paramContext.widthPixels;
    this.h = paramContext.heightPixels;
    if (this.g < this.h)
    {
      this.g = paramContext.heightPixels;
      this.h = paramContext.widthPixels;
    }
    g.b("screenWidth =" + this.g + ",screenHeight=" + this.h);
  }
  
  private static String a(Collection<String> paramCollection, String... paramVarArgs)
  {
    int m;
    String str;
    if (paramCollection != null)
    {
      int n = paramVarArgs.length;
      m = 0;
      if (m < n)
      {
        str = paramVarArgs[m];
        if (!paramCollection.contains(str)) {}
      }
    }
    for (paramCollection = str;; paramCollection = null)
    {
      g.b("resolution Settable value: " + paramCollection);
      return paramCollection;
      m += 1;
      break;
    }
  }
  
  private void a(Camera paramCamera, int paramInt)
  {
    try
    {
      Method localMethod = paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      if (localMethod != null) {
        localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      }
      return;
    }
    catch (Exception paramCamera) {}
  }
  
  private void d()
  {
    Object localObject = new Camera.CameraInfo();
    int n = Camera.getNumberOfCameras();
    int m = 0;
    for (;;)
    {
      if (m < n)
      {
        Camera.getCameraInfo(m, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 0) {}
        try
        {
          this.a = Camera.open(m);
          m += 1;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            g.c("CameraOpen camera=" + this.a);
            localRuntimeException.printStackTrace();
          }
        }
      }
    }
    if (this.a == null)
    {
      g.c("CameraOpen camera=" + this.a);
      localObject = this.k.obtainMessage(0);
      ((Message)localObject).what = 2;
      ((Message)localObject).sendToTarget();
    }
  }
  
  private void e()
  {
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
    if (this.j != null)
    {
      this.j.cancel();
      this.j = null;
    }
  }
  
  private void setBestDisplay(List<Camera.Size> paramList)
  {
    this.c = ((Camera.Size)paramList.get(0)).width;
    this.e = ((Camera.Size)paramList.get(0)).height;
    int m = 1;
    while (m < paramList.size())
    {
      double d1 = Math.abs(this.c / this.e - this.g / this.h);
      double d2 = Math.abs(((Camera.Size)paramList.get(m)).width / ((Camera.Size)paramList.get(m)).height - this.g / this.h);
      if (d1 >= d2)
      {
        this.c = ((Camera.Size)paramList.get(m)).width;
        this.e = ((Camera.Size)paramList.get(m)).height;
        if ((d1 == d2) && (this.c < ((Camera.Size)paramList.get(m)).width))
        {
          this.c = ((Camera.Size)paramList.get(m)).width;
          this.e = ((Camera.Size)paramList.get(m)).height;
        }
      }
      m += 1;
    }
    g.c("debug------------bestPreviewWidth=" + this.c + ",bestPreviewHeight=" + this.e + ", screenWidth=" + this.g + ",screenHeight=" + this.h);
  }
  
  private void setBestResult(List<Camera.Size> paramList)
  {
    this.d = ((Camera.Size)paramList.get(0)).width;
    this.f = ((Camera.Size)paramList.get(0)).height;
    int m = 1;
    while (m < paramList.size())
    {
      double d1 = Math.abs(this.d / this.f - this.g / this.h);
      double d2 = Math.abs(((Camera.Size)paramList.get(m)).width / ((Camera.Size)paramList.get(m)).height - this.g / this.h);
      if (d1 > d2)
      {
        this.d = ((Camera.Size)paramList.get(m)).width;
        this.f = ((Camera.Size)paramList.get(m)).height;
        if ((d1 == d2) && (this.d < ((Camera.Size)paramList.get(m)).width))
        {
          this.d = ((Camera.Size)paramList.get(m)).width;
          this.f = ((Camera.Size)paramList.get(m)).height;
        }
      }
      m += 1;
    }
    g.c("debug------------mPictureWidth=" + this.d + ",mPictureHeight=" + this.f);
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.setPreviewCallback(null);
      this.a.stopPreview();
      this.a.release();
      this.a = null;
    }
    e();
  }
  
  public void a(Context paramContext, Handler paramHandler)
  {
    this.k = paramHandler;
    d();
    this.b = getHolder();
    this.b.addCallback(this);
    this.b.setType(3);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.g = paramContext.widthPixels;
    this.h = paramContext.heightPixels;
    if (this.g < this.h)
    {
      this.g = paramContext.heightPixels;
      this.h = paramContext.widthPixels;
    }
    g.b("screenWidth =" + this.g + ",screenHeight=" + this.h);
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    try
    {
      this.a.autoFocus(this);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      g.d("camera auto focus " + localRuntimeException.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      g.d("camera auto focus " + localException.toString());
    }
  }
  
  public void c()
  {
    this.i = new Timer(false);
    this.j = new TimerTask()
    {
      public void run()
      {
        Message localMessage = RealNameTakeIDPhotoPreview.a(RealNameTakeIDPhotoPreview.this).obtainMessage(0);
        localMessage.what = 3;
        localMessage.sendToTarget();
      }
    };
    this.i.schedule(this.j, 500L, 2000L);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 0;
    if (this.b.getSurface() == null) {}
    for (;;)
    {
      return;
      try
      {
        this.a.stopPreview();
        g.b("width =" + paramInt2 + ",height=" + paramInt3);
        if (this.a == null) {
          continue;
        }
      }
      catch (Exception paramSurfaceHolder)
      {
        try
        {
          Object localObject1;
          for (;;)
          {
            paramSurfaceHolder = this.a.getParameters();
            paramSurfaceHolder.setPictureFormat(256);
            localObject1 = this.a.getParameters().getSupportedPictureSizes();
            if (localObject1 == null) {
              break;
            }
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              localObject2 = (Camera.Size)((List)localObject1).get(paramInt1);
              g.b("picSizes,width: " + ((Camera.Size)localObject2).width + " height" + ((Camera.Size)localObject2).height);
              paramInt1 += 1;
            }
            paramSurfaceHolder = paramSurfaceHolder;
            paramSurfaceHolder.printStackTrace();
          }
          Object localObject2 = this.a.getParameters().getSupportedPreviewSizes();
          if (localObject2 != null)
          {
            paramInt1 = m;
            while (paramInt1 < ((List)localObject2).size())
            {
              Camera.Size localSize = (Camera.Size)((List)localObject2).get(paramInt1);
              g.b("presize,width: " + localSize.width + " height" + localSize.height);
              paramInt1 += 1;
            }
          }
          if (getResources().getConfiguration().orientation != 2)
          {
            a(this.a, 90);
            label294:
            setBestDisplay((List)localObject2);
            setBestResult((List)localObject1);
            paramSurfaceHolder.setPreviewSize(this.c, this.e);
            paramSurfaceHolder.setPictureSize(this.d, this.f);
            g.c("mPreviewWidth!" + this.c);
            g.c("mPreviewHeight!" + this.e);
            g.c("mPictureWidth!" + this.d);
            g.c("mPictureHeight!" + this.f);
            localObject1 = a(paramSurfaceHolder.getSupportedFocusModes(), new String[] { "continuous-video" });
            if (localObject1 == null) {
              break label534;
            }
            paramSurfaceHolder.setFocusMode((String)localObject1);
          }
          for (;;)
          {
            this.a.setParameters(paramSurfaceHolder);
            this.a.startPreview();
            if ((!this.a.getParameters().getFocusMode().equals("auto")) && (!this.a.getParameters().getFocusMode().equals("macro"))) {
              break;
            }
            c();
            return;
            a(this.a, 0);
            break label294;
            label534:
            localObject1 = a(paramSurfaceHolder.getSupportedFocusModes(), new String[] { "auto" });
            if (localObject1 != null) {
              paramSurfaceHolder.setFocusMode((String)localObject1);
            }
          }
          return;
        }
        catch (Exception paramSurfaceHolder) {}
      }
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.a.setPreviewDisplay(this.b);
      this.a.startPreview();
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      do
      {
        paramSurfaceHolder.printStackTrace();
      } while (this.a == null);
      this.a.release();
      this.a = null;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    g.c("surfaceDestroyed!");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameTakeIDPhotoPreview
 * JD-Core Version:    0.7.0.1
 */