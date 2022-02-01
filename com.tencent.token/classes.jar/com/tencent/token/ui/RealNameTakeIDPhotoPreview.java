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
import com.tencent.token.xj;
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
    paramContext = new StringBuilder("screenWidth =");
    paramContext.append(this.g);
    paramContext.append(",screenHeight=");
    paramContext.append(this.h);
    xj.b(paramContext.toString());
  }
  
  private static String a(Collection<String> paramCollection, String... paramVarArgs)
  {
    if (paramCollection != null)
    {
      int m = 0;
      while (m <= 0)
      {
        String str = paramVarArgs[0];
        if (paramCollection.contains(str))
        {
          paramCollection = str;
          break label38;
        }
        m += 1;
      }
    }
    paramCollection = null;
    label38:
    xj.b("resolution Settable value: ".concat(String.valueOf(paramCollection)));
    return paramCollection;
  }
  
  private static void a(Camera paramCamera, int paramInt)
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
  
  private void b()
  {
    Object localObject = new Camera.CameraInfo();
    int n = Camera.getNumberOfCameras();
    int m = 0;
    while (m < n)
    {
      Camera.getCameraInfo(m, (Camera.CameraInfo)localObject);
      if (((Camera.CameraInfo)localObject).facing == 0) {
        try
        {
          this.a = Camera.open(m);
        }
        catch (RuntimeException localRuntimeException)
        {
          StringBuilder localStringBuilder = new StringBuilder("CameraOpen camera=");
          localStringBuilder.append(this.a);
          xj.c(localStringBuilder.toString());
          localRuntimeException.printStackTrace();
        }
      }
      m += 1;
    }
    if (this.a == null)
    {
      localObject = new StringBuilder("CameraOpen camera=");
      ((StringBuilder)localObject).append(this.a);
      xj.c(((StringBuilder)localObject).toString());
      localObject = this.k.obtainMessage(0);
      ((Message)localObject).what = 2;
      ((Message)localObject).sendToTarget();
    }
  }
  
  private void c()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.i = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
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
      double d1 = this.c;
      double d2 = this.e;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      d2 = this.g;
      double d3 = this.h;
      Double.isNaN(d2);
      Double.isNaN(d3);
      d1 = Math.abs(d1 - d2 / d3);
      d2 = ((Camera.Size)paramList.get(m)).width;
      d3 = ((Camera.Size)paramList.get(m)).height;
      Double.isNaN(d2);
      Double.isNaN(d3);
      d2 /= d3;
      d3 = this.g;
      double d4 = this.h;
      Double.isNaN(d3);
      Double.isNaN(d4);
      d2 = Math.abs(d2 - d3 / d4);
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
    paramList = new StringBuilder("debug------------bestPreviewWidth=");
    paramList.append(this.c);
    paramList.append(",bestPreviewHeight=");
    paramList.append(this.e);
    paramList.append(", screenWidth=");
    paramList.append(this.g);
    paramList.append(",screenHeight=");
    paramList.append(this.h);
    xj.c(paramList.toString());
  }
  
  private void setBestResult(List<Camera.Size> paramList)
  {
    this.d = ((Camera.Size)paramList.get(0)).width;
    this.f = ((Camera.Size)paramList.get(0)).height;
    int m = 1;
    while (m < paramList.size())
    {
      double d1 = this.d;
      double d2 = this.f;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      d2 = this.g;
      double d3 = this.h;
      Double.isNaN(d2);
      Double.isNaN(d3);
      d1 = Math.abs(d1 - d2 / d3);
      d2 = ((Camera.Size)paramList.get(m)).width;
      d3 = ((Camera.Size)paramList.get(m)).height;
      Double.isNaN(d2);
      Double.isNaN(d3);
      d2 /= d3;
      d3 = this.g;
      double d4 = this.h;
      Double.isNaN(d3);
      Double.isNaN(d4);
      d2 = Math.abs(d2 - d3 / d4);
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
    paramList = new StringBuilder("debug------------mPictureWidth=");
    paramList.append(this.d);
    paramList.append(",mPictureHeight=");
    paramList.append(this.f);
    xj.c(paramList.toString());
  }
  
  public final void a()
  {
    Camera localCamera = this.a;
    if (localCamera != null)
    {
      localCamera.setPreviewCallback(null);
      this.a.stopPreview();
      this.a.release();
      this.a = null;
    }
    c();
  }
  
  public final void a(Context paramContext, Handler paramHandler)
  {
    this.k = paramHandler;
    b();
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
    paramContext = new StringBuilder("screenWidth =");
    paramContext.append(this.g);
    paramContext.append(",screenHeight=");
    paramContext.append(this.h);
    xj.b(paramContext.toString());
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b.getSurface() == null) {
      return;
    }
    try
    {
      this.a.stopPreview();
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
    paramSurfaceHolder = new StringBuilder("width =");
    paramSurfaceHolder.append(paramInt2);
    paramSurfaceHolder.append(",height=");
    paramSurfaceHolder.append(paramInt3);
    xj.b(paramSurfaceHolder.toString());
    paramSurfaceHolder = this.a;
    if (paramSurfaceHolder != null) {}
    try
    {
      paramSurfaceHolder = paramSurfaceHolder.getParameters();
      paramSurfaceHolder.setPictureFormat(256);
      Object localObject1 = this.a.getParameters().getSupportedPictureSizes();
      Object localObject3;
      if (localObject1 != null)
      {
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject1).size())
        {
          localObject2 = (Camera.Size)((List)localObject1).get(paramInt1);
          localObject3 = new StringBuilder("picSizes,width: ");
          ((StringBuilder)localObject3).append(((Camera.Size)localObject2).width);
          ((StringBuilder)localObject3).append(" height");
          ((StringBuilder)localObject3).append(((Camera.Size)localObject2).height);
          xj.b(((StringBuilder)localObject3).toString());
          paramInt1 += 1;
        }
      }
      Object localObject2 = this.a.getParameters().getSupportedPreviewSizes();
      if (localObject2 != null)
      {
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject2).size())
        {
          localObject3 = (Camera.Size)((List)localObject2).get(paramInt1);
          StringBuilder localStringBuilder = new StringBuilder("presize,width: ");
          localStringBuilder.append(((Camera.Size)localObject3).width);
          localStringBuilder.append(" height");
          localStringBuilder.append(((Camera.Size)localObject3).height);
          xj.b(localStringBuilder.toString());
          paramInt1 += 1;
        }
      }
      if (getResources().getConfiguration().orientation != 2) {
        a(this.a, 90);
      } else {
        a(this.a, 0);
      }
      setBestDisplay((List)localObject2);
      setBestResult((List)localObject1);
      paramSurfaceHolder.setPreviewSize(this.c, this.e);
      paramSurfaceHolder.setPictureSize(this.d, this.f);
      localObject1 = new StringBuilder("mPreviewWidth!");
      ((StringBuilder)localObject1).append(this.c);
      xj.c(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder("mPreviewHeight!");
      ((StringBuilder)localObject1).append(this.e);
      xj.c(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder("mPictureWidth!");
      ((StringBuilder)localObject1).append(this.d);
      xj.c(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder("mPictureHeight!");
      ((StringBuilder)localObject1).append(this.f);
      xj.c(((StringBuilder)localObject1).toString());
      localObject1 = a(paramSurfaceHolder.getSupportedFocusModes(), new String[] { "continuous-video" });
      if (localObject1 != null)
      {
        paramSurfaceHolder.setFocusMode((String)localObject1);
      }
      else
      {
        localObject1 = a(paramSurfaceHolder.getSupportedFocusModes(), new String[] { "auto" });
        if (localObject1 != null) {
          paramSurfaceHolder.setFocusMode((String)localObject1);
        }
      }
      this.a.setParameters(paramSurfaceHolder);
      this.a.startPreview();
      if ((this.a.getParameters().getFocusMode().equals("auto")) || (this.a.getParameters().getFocusMode().equals("macro")))
      {
        this.i = new Timer(false);
        this.j = new TimerTask()
        {
          public final void run()
          {
            Message localMessage = RealNameTakeIDPhotoPreview.a(RealNameTakeIDPhotoPreview.this).obtainMessage(0);
            localMessage.what = 3;
            localMessage.sendToTarget();
          }
        };
        this.i.schedule(this.j, 500L, 2000L);
      }
      return;
    }
    catch (Exception paramSurfaceHolder) {}
    return;
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
      paramSurfaceHolder.printStackTrace();
      paramSurfaceHolder = this.a;
      if (paramSurfaceHolder != null)
      {
        paramSurfaceHolder.release();
        this.a = null;
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    xj.c("surfaceDestroyed!");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameTakeIDPhotoPreview
 * JD-Core Version:    0.7.0.1
 */