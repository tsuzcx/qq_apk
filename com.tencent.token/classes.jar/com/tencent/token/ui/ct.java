package com.tencent.token.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceDetector.IdCardDirection;
import com.tencent.jni.IdCardInfo;
import com.tencent.token.ca;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.utils.i;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class ct
  implements Camera.AutoFocusCallback, Camera.PreviewCallback
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private Context e;
  private boolean f = false;
  private Handler g;
  private long h;
  private Camera i;
  private SurfaceHolder j;
  private Timer k;
  private TimerTask l;
  private int m;
  private int n;
  private FaceDetector.IdCardDirection o = FaceDetector.IdCardDirection.DT_FRONT;
  
  public ct(Context paramContext, SurfaceHolder paramSurfaceHolder, Handler paramHandler, String paramString, FaceDetector.IdCardDirection paramIdCardDirection)
  {
    this.e = paramContext;
    this.g = paramHandler;
    this.j = paramSurfaceHolder;
    this.o = paramIdCardDirection;
    boolean bool = FaceDetector.IdCardDetectInitial(paramString);
    e.a("IdCardDetectInitial: " + bool);
    this.n = 0;
  }
  
  private static String a(Collection paramCollection, String... paramVarArgs)
  {
    int i1;
    String str;
    if (paramCollection != null)
    {
      int i2 = paramVarArgs.length;
      i1 = 0;
      if (i1 < i2)
      {
        str = paramVarArgs[i1];
        if (!paramCollection.contains(str)) {}
      }
    }
    for (paramCollection = str;; paramCollection = null)
    {
      e.b("resolution Settable value: " + paramCollection);
      return paramCollection;
      i1 += 1;
      break;
    }
  }
  
  private void d()
  {
    if (this.i == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = this.e.getResources().getDisplayMetrics();
    int i6 = localDisplayMetrics.widthPixels;
    int i7 = localDisplayMetrics.heightPixels;
    Object localObject2;
    int i2;
    int i3;
    int i1;
    try
    {
      localObject2 = this.i.getParameters().getSupportedPreviewSizes();
      i2 = ((Camera.Size)((List)localObject2).get(0)).width;
      i3 = ((Camera.Size)((List)localObject2).get(0)).height;
      i1 = 1;
      while (i1 < ((List)localObject2).size())
      {
        int i5 = i3;
        int i4 = i2;
        if (Math.abs(i2 / i3 - i6 / i7) > Math.abs(((Camera.Size)((List)localObject2).get(i1)).width / ((Camera.Size)((List)localObject2).get(i1)).height - i6 / i7))
        {
          i4 = ((Camera.Size)((List)localObject2).get(i1)).width;
          i5 = ((Camera.Size)((List)localObject2).get(i1)).height;
        }
        i1 += 1;
        i3 = i5;
        i2 = i4;
      }
      e.c("debug------------bestPreviewWidth=" + i2 + ",bestPreviewHeight=" + i3 + ", screenWidth=" + i6 + ",screenHeight=" + i7 + ",density=" + ((DisplayMetrics)localObject1).density);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      e.c("Camera getParameters failed" + this.i);
      localObject1 = this.g.obtainMessage(0);
      ((Message)localObject1).what = 2;
      ((Message)localObject1).sendToTarget();
      return;
    }
    Object localObject1 = this.i.getParameters();
    ((Camera.Parameters)localObject1).setPictureFormat(256);
    ((Camera.Parameters)localObject1).setPreviewFormat(17);
    if (this.e.getResources().getConfiguration().orientation != 2) {
      i1 = 90;
    }
    for (this.m = 90;; this.m = 0)
    {
      if (ca.c != -1) {
        i1 = ca.c;
      }
      if (ca.d != -1) {
        this.m = ca.d;
      }
      localObject2 = this.i;
      try
      {
        Method localMethod = localObject2.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
        if (localMethod != null) {
          localMethod.invoke(localObject2, new Object[] { Integer.valueOf(i1) });
        }
      }
      catch (Exception localException3)
      {
        label447:
        break label447;
      }
      ((Camera.Parameters)localObject1).setPreviewSize(i2, i3);
      a(((Camera.Parameters)localObject1).getSupportedFocusModes(), new String[] { "continuous-video" });
      localObject2 = a(((Camera.Parameters)localObject1).getSupportedFocusModes(), new String[] { "auto" });
      if (localObject2 != null) {
        ((Camera.Parameters)localObject1).setFocusMode((String)localObject2);
      }
      this.i.setParameters((Camera.Parameters)localObject1);
      this.i.setPreviewCallback(this);
      try
      {
        this.i.setPreviewDisplay(this.j);
        this.i.startPreview();
        if ((((Camera.Parameters)localObject1).getFocusMode().equals("auto")) || (((Camera.Parameters)localObject1).getFocusMode().equals("macro")))
        {
          this.k = new Timer(false);
          this.l = new cu(this);
          this.k.schedule(this.l, 500L, 2000L);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          if (this.i != null)
          {
            this.i.release();
            this.i = null;
          }
        }
        d = 0;
        c = 0;
        p.a().a(System.currentTimeMillis(), 132);
        return;
      }
      if (this.o != FaceDetector.IdCardDirection.DT_FRONT) {
        break;
      }
      b = 0;
      a = 0;
      p.a().a(System.currentTimeMillis(), 130);
      return;
      i1 = 0;
    }
  }
  
  public final void a()
  {
    if (this.i != null) {
      return;
    }
    Object localObject = new Camera.CameraInfo();
    int i2 = Camera.getNumberOfCameras();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 0) {}
        try
        {
          this.i = Camera.open(i1);
          i1 += 1;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            e.c("CameraOpen camera=" + this.i);
            localRuntimeException.printStackTrace();
          }
        }
      }
    }
    if (this.i == null)
    {
      e.c("CameraOpen camera=" + this.i);
      localObject = this.g.obtainMessage(0);
      ((Message)localObject).what = 2;
      ((Message)localObject).sendToTarget();
    }
    d();
    this.h = System.currentTimeMillis();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void b()
  {
    try
    {
      if (this.i != null)
      {
        this.i.setPreviewCallback(null);
        this.i.stopPreview();
        this.i.release();
        this.i = null;
      }
      if (this.k != null)
      {
        this.k.cancel();
        this.k = null;
      }
      if (this.l != null)
      {
        this.l.cancel();
        this.l = null;
      }
      FaceDetector.IdCardDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void c()
  {
    if (this.i == null) {
      return;
    }
    try
    {
      this.i.autoFocus(this);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      e.d("camera auto focus " + localRuntimeException.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      e.d("camera auto focus " + localException.toString());
    }
  }
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.f) {}
    long l2;
    label370:
    do
    {
      do
      {
        return;
        this.n += 1;
      } while (this.n % 2 == 0);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (this.o == FaceDetector.IdCardDirection.DT_FRONT)
      {
        a += 1;
        localObject1 = paramCamera.getParameters();
        int i1 = ((Camera.Parameters)localObject1).getPreviewSize().width;
        int i2 = ((Camera.Parameters)localObject1).getPreviewSize().height;
        localObject1 = new IdCardInfo();
        long l1 = System.currentTimeMillis();
        l2 = FaceDetector.IdCardDetect((IdCardInfo)localObject1, this.o, paramArrayOfByte, i1, i2, this.m);
        long l3 = System.currentTimeMillis();
        localObject2 = "id_card ret: " + l2 + " time: " + (l3 - l1) + " info: " + ((IdCardInfo)localObject1).info() + ", side=" + this.o;
        if (l2 != 0L) {
          break label483;
        }
        e.c((String)localObject2 + ", totaltime=" + (System.currentTimeMillis() - this.h));
        if (this.o != FaceDetector.IdCardDirection.DT_FRONT) {
          break label370;
        }
        b = (int)(System.currentTimeMillis() - this.h);
        localObject3 = i.a(((IdCardInfo)localObject1).data(), "frontdata");
        localObject2 = this.g.obtainMessage(0);
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putByteArray("info", ((IdCardInfo)localObject1).info());
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).arg1 = 1;
        ((Message)localObject2).sendToTarget();
        p.a().a(System.currentTimeMillis(), 131);
      }
      for (;;)
      {
        e.a("take id photo data=" + paramArrayOfByte.length);
        paramCamera.stopPreview();
        this.f = true;
        return;
        c += 1;
        break;
        if (this.o == FaceDetector.IdCardDirection.DT_BACK)
        {
          d = (int)(System.currentTimeMillis() - this.h);
          localObject3 = i.a(((IdCardInfo)localObject1).data(), "backdata");
          localObject2 = this.g.obtainMessage(0);
          ((Message)localObject2).what = 1;
          ((Message)localObject2).obj = localObject3;
          localObject3 = new Bundle();
          ((Bundle)localObject3).putByteArray("info", ((IdCardInfo)localObject1).info());
          ((Message)localObject2).setData((Bundle)localObject3);
          ((Message)localObject2).arg1 = 2;
          ((Message)localObject2).sendToTarget();
          p.a().a(System.currentTimeMillis(), 133);
        }
      }
      e.a("ret=" + l2);
      if ((l2 == 3L) || (l2 == 5L))
      {
        this.g.obtainMessage(6).sendToTarget();
        return;
      }
    } while ((l2 != 2L) && (l2 != 4L));
    label483:
    this.g.obtainMessage(7).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ct
 * JD-Core Version:    0.7.0.1
 */