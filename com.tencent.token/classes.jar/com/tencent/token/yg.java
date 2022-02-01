package com.tencent.token;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
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
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class yg
  implements Camera.AutoFocusCallback, Camera.PreviewCallback
{
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public boolean a = false;
  public Handler b;
  public long c;
  public Camera d;
  final Object i = new Object();
  private Context j;
  private SurfaceHolder k;
  private Timer l;
  private TimerTask m;
  private int n;
  private int o;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private FaceDetector.IdCardDirection s = FaceDetector.IdCardDirection.DT_FRONT;
  private String t;
  
  public yg(Context paramContext, SurfaceHolder paramSurfaceHolder, Handler paramHandler, FaceDetector.IdCardDirection paramIdCardDirection)
  {
    this.j = paramContext;
    this.b = paramHandler;
    this.k = paramSurfaceHolder;
    this.s = paramIdCardDirection;
    this.o = 0;
  }
  
  private static String a(Collection<String> paramCollection, String... paramVarArgs)
  {
    if (paramCollection != null)
    {
      int i1 = 0;
      while (i1 <= 0)
      {
        String str = paramVarArgs[0];
        if (paramCollection.contains(str))
        {
          paramCollection = str;
          break label38;
        }
        i1 += 1;
      }
    }
    paramCollection = null;
    label38:
    xj.b("resolution Settable value: ".concat(String.valueOf(paramCollection)));
    return paramCollection;
  }
  
  public final void a()
  {
    if (this.d == null) {
      return;
    }
    Object localObject1 = this.j.getResources().getDisplayMetrics();
    int i5 = ((DisplayMetrics)localObject1).widthPixels;
    int i6 = ((DisplayMetrics)localObject1).heightPixels;
    try
    {
      localObject3 = this.d.getParameters().getSupportedPreviewSizes();
      i4 = ((Camera.Size)((List)localObject3).get(0)).width;
      i1 = ((Camera.Size)((List)localObject3).get(0)).height;
      int i3 = 1;
      while (i3 < ((List)localObject3).size())
      {
        double d1 = i4;
        double d2 = i1;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d2 = d1 / d2;
        d1 = i5;
        double d3 = i6;
        Double.isNaN(d1);
        Double.isNaN(d3);
        d1 /= d3;
        d2 = Math.abs(d2 - d1);
        d3 = ((Camera.Size)((List)localObject3).get(i3)).width;
        double d4 = ((Camera.Size)((List)localObject3).get(i3)).height;
        Double.isNaN(d3);
        Double.isNaN(d4);
        d1 = Math.abs(d3 / d4 - d1);
        if (d2 >= d1)
        {
          i2 = ((Camera.Size)((List)localObject3).get(i3)).width;
          i1 = ((Camera.Size)((List)localObject3).get(i3)).height;
          if ((d2 == d1) && (i2 < ((Camera.Size)((List)localObject3).get(i3)).width))
          {
            i2 = ((Camera.Size)((List)localObject3).get(i3)).width;
            i1 = ((Camera.Size)((List)localObject3).get(i3)).height;
          }
        }
        else
        {
          i2 = i4;
        }
        i3 += 1;
        i4 = i2;
      }
      localObject3 = new StringBuilder("debug------------bestPreviewWidth=");
      ((StringBuilder)localObject3).append(i4);
      ((StringBuilder)localObject3).append(",bestPreviewHeight=");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(", screenWidth=");
      ((StringBuilder)localObject3).append(i5);
      ((StringBuilder)localObject3).append(",screenHeight=");
      ((StringBuilder)localObject3).append(i6);
      ((StringBuilder)localObject3).append(",density=");
      ((StringBuilder)localObject3).append(((DisplayMetrics)localObject1).density);
      xj.c(((StringBuilder)localObject3).toString());
      localObject1 = this.d.getParameters();
      ((Camera.Parameters)localObject1).setPictureFormat(256);
      ((Camera.Parameters)localObject1).setPreviewFormat(17);
      i3 = this.j.getResources().getConfiguration().orientation;
      i2 = 90;
      if (i3 != 2)
      {
        this.n = 90;
      }
      else
      {
        this.n = 0;
        i2 = 0;
      }
      if (tw.d != -1) {
        i2 = tw.d;
      }
      if (tw.e != -1) {
        this.n = tw.e;
      }
      localObject3 = this.d;
    }
    catch (Exception localException2)
    {
      Object localObject3;
      int i4;
      int i1;
      int i2;
      Method localMethod;
      label569:
      localException2.printStackTrace();
      Object localObject2 = new StringBuilder("Camera getParameters failed");
      ((StringBuilder)localObject2).append(this.d);
      xj.c(((StringBuilder)localObject2).toString());
      localObject2 = this.b.obtainMessage(0);
      ((Message)localObject2).what = 2;
      ((Message)localObject2).sendToTarget();
      return;
    }
    try
    {
      localMethod = localObject3.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      if (localMethod != null) {
        localMethod.invoke(localObject3, new Object[] { Integer.valueOf(i2) });
      }
    }
    catch (Exception localException3)
    {
      break label569;
    }
    ((Camera.Parameters)localObject1).setPreviewSize(i4, i1);
    localObject3 = a(((Camera.Parameters)localObject1).getSupportedFocusModes(), new String[] { "auto" });
    if (localObject3 != null) {
      ((Camera.Parameters)localObject1).setFocusMode((String)localObject3);
    }
    this.d.setParameters((Camera.Parameters)localObject1);
    this.d.setPreviewCallback(this);
    try
    {
      this.d.setPreviewDisplay(this.k);
      this.d.startPreview();
      if ((((Camera.Parameters)localObject1).getFocusMode().equals("auto")) || (((Camera.Parameters)localObject1).getFocusMode().equals("macro")))
      {
        this.l = new Timer(false);
        this.m = new TimerTask()
        {
          public final void run()
          {
            yg localyg = yg.this;
            if (localyg.d != null) {
              try
              {
                localyg.d.autoFocus(localyg);
                return;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                localStringBuilder = new StringBuilder("camera auto focus ");
                localStringBuilder.append(localException.toString());
                xj.c(localStringBuilder.toString());
                return;
              }
              catch (RuntimeException localRuntimeException)
              {
                localRuntimeException.printStackTrace();
                StringBuilder localStringBuilder = new StringBuilder("camera auto focus ");
                localStringBuilder.append(localRuntimeException.toString());
                xj.c(localStringBuilder.toString());
                return;
              }
            }
          }
        };
        this.l.schedule(this.m, 500L, 2000L);
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      Camera localCamera = this.d;
      if (localCamera != null)
      {
        localCamera.release();
        this.d = null;
      }
    }
    if (this.s == FaceDetector.IdCardDirection.DT_FRONT)
    {
      f = 0;
      e = 0;
      sb.a().a(System.currentTimeMillis(), 130);
      return;
    }
    h = 0;
    g = 0;
    sb.a().a(System.currentTimeMillis(), 132);
  }
  
  public final void b()
  {
    try
    {
      if (this.d != null)
      {
        this.d.setPreviewCallback(null);
        this.d.stopPreview();
        this.d.release();
        this.d = null;
      }
      if (this.l != null)
      {
        this.l.cancel();
        this.l = null;
      }
      if (this.m != null)
      {
        this.m.cancel();
        this.m = null;
      }
      FaceDetector.IdCardDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.a) {
      return;
    }
    if ((!this.q) && (!this.p)) {
      new Thread(new Runnable()
      {
        public final void run()
        {
          try
          {
            synchronized (yg.this.i)
            {
              yg.a(yg.this, true);
              yg.a(yg.this);
              yg.b(yg.this, FaceDetector.IdCardDetectInitial(yg.b(yg.this)));
              StringBuilder localStringBuilder = new StringBuilder("IdCardDetectInitial: ");
              localStringBuilder.append(yg.c(yg.this));
              localStringBuilder.append(",mIdCardModelPath=");
              localStringBuilder.append(yg.b(yg.this));
              xj.c(localStringBuilder.toString());
              yg.d(yg.this);
              yg.a(yg.this, false);
            }
          }
          catch (Error localError)
          {
            localError.printStackTrace();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }).start();
    }
    if (this.p) {
      return;
    }
    this.o += 1;
    if (this.o % 2 == 0) {
      return;
    }
    if (this.s == FaceDetector.IdCardDirection.DT_FRONT) {
      e += 1;
    } else {
      g += 1;
    }
    Object localObject1 = paramCamera.getParameters();
    int i1 = ((Camera.Parameters)localObject1).getPreviewSize().width;
    int i2 = ((Camera.Parameters)localObject1).getPreviewSize().height;
    localObject1 = new IdCardInfo();
    long l5 = System.currentTimeMillis();
    long l4 = -1L;
    long l1 = l4;
    long l2 = l4;
    long l3 = l4;
    try
    {
      if (this.r)
      {
        l2 = l4;
        l3 = l4;
        l1 = FaceDetector.IdCardDetect((IdCardInfo)localObject1, this.s, paramArrayOfByte, i1, i2, this.n);
      }
      l2 = l1;
      l3 = l1;
      xj.c("IdCardDetect detect ret: ".concat(String.valueOf(l1)));
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      l1 = l2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l1 = l3;
    }
    l2 = System.currentTimeMillis();
    Object localObject2 = new StringBuilder("id_card ret: ");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(" time: ");
    ((StringBuilder)localObject2).append(l2 - l5);
    ((StringBuilder)localObject2).append(" info: ");
    ((StringBuilder)localObject2).append(((IdCardInfo)localObject1).info());
    ((StringBuilder)localObject2).append(", side=");
    ((StringBuilder)localObject2).append(this.s);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (l1 == 0L)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", totaltime=");
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.c);
      xj.c(((StringBuilder)localObject3).toString());
      if (this.s == FaceDetector.IdCardDirection.DT_FRONT)
      {
        f = (int)(System.currentTimeMillis() - this.c);
        localObject3 = aai.a(((IdCardInfo)localObject1).data(), "frontdata");
        localObject2 = this.b.obtainMessage(0);
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putByteArray("info", ((IdCardInfo)localObject1).info());
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).arg1 = 1;
        ((Message)localObject2).sendToTarget();
        sb.a().a(System.currentTimeMillis(), 131);
      }
      else if (this.s == FaceDetector.IdCardDirection.DT_BACK)
      {
        h = (int)(System.currentTimeMillis() - this.c);
        localObject3 = aai.a(((IdCardInfo)localObject1).data(), "backdata");
        localObject2 = this.b.obtainMessage(0);
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putByteArray("info", ((IdCardInfo)localObject1).info());
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).arg1 = 2;
        ((Message)localObject2).sendToTarget();
        sb.a().a(System.currentTimeMillis(), 133);
      }
      localObject1 = new StringBuilder("take id photo data=");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      xj.a(((StringBuilder)localObject1).toString());
      paramCamera.stopPreview();
      this.a = true;
      return;
    }
    xj.a("ret=".concat(String.valueOf(l1)));
    if ((l1 != 3L) && (l1 != 5L))
    {
      if ((l1 == 2L) || (l1 == 4L)) {
        this.b.obtainMessage(7).sendToTarget();
      }
      return;
    }
    this.b.obtainMessage(6).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yg
 * JD-Core Version:    0.7.0.1
 */