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
import com.tencent.token.bv;
import com.tencent.token.core.protocolcenter.protocol.ProtoAutoIDCardDetect;
import com.tencent.token.global.g;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class e
  implements Camera.AutoFocusCallback, Camera.PreviewCallback
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  final Object e = new Object();
  private Context f;
  private boolean g = false;
  private Handler h;
  private long i;
  private Camera j;
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
  
  public e(Context paramContext, SurfaceHolder paramSurfaceHolder, Handler paramHandler, FaceDetector.IdCardDirection paramIdCardDirection)
  {
    this.f = paramContext;
    this.h = paramHandler;
    this.k = paramSurfaceHolder;
    this.s = paramIdCardDirection;
    this.o = 0;
  }
  
  private static String a(Collection<String> paramCollection, String... paramVarArgs)
  {
    if (paramCollection != null)
    {
      int i2 = paramVarArgs.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramVarArgs[i1];
        if (paramCollection.contains(str))
        {
          paramCollection = str;
          break label45;
        }
        i1 += 1;
      }
    }
    paramCollection = null;
    label45:
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("resolution Settable value: ");
    paramVarArgs.append(paramCollection);
    g.b(paramVarArgs.toString());
    return paramCollection;
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
  
  private void f()
  {
    if (this.j == null) {
      return;
    }
    Object localObject1 = this.f.getResources().getDisplayMetrics();
    int i5 = ((DisplayMetrics)localObject1).widthPixels;
    int i6 = ((DisplayMetrics)localObject1).heightPixels;
    try
    {
      Object localObject3 = this.j.getParameters().getSupportedPreviewSizes();
      int i4 = ((Camera.Size)((List)localObject3).get(0)).width;
      int i1 = ((Camera.Size)((List)localObject3).get(0)).height;
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
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("debug------------bestPreviewWidth=");
      ((StringBuilder)localObject3).append(i4);
      ((StringBuilder)localObject3).append(",bestPreviewHeight=");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(", screenWidth=");
      ((StringBuilder)localObject3).append(i5);
      ((StringBuilder)localObject3).append(",screenHeight=");
      ((StringBuilder)localObject3).append(i6);
      ((StringBuilder)localObject3).append(",density=");
      ((StringBuilder)localObject3).append(((DisplayMetrics)localObject1).density);
      g.c(((StringBuilder)localObject3).toString());
      localObject1 = this.j.getParameters();
      ((Camera.Parameters)localObject1).setPictureFormat(256);
      ((Camera.Parameters)localObject1).setPreviewFormat(17);
      i3 = this.f.getResources().getConfiguration().orientation;
      int i2 = 90;
      if (i3 != 2)
      {
        this.n = 90;
      }
      else
      {
        this.n = 0;
        i2 = 0;
      }
      if (ProtoAutoIDCardDetect.d != -1) {
        i2 = ProtoAutoIDCardDetect.d;
      }
      if (ProtoAutoIDCardDetect.e != -1) {
        this.n = ProtoAutoIDCardDetect.e;
      }
      a(this.j, i2);
      ((Camera.Parameters)localObject1).setPreviewSize(i4, i1);
      localObject3 = a(((Camera.Parameters)localObject1).getSupportedFocusModes(), new String[] { "auto" });
      if (localObject3 != null) {
        ((Camera.Parameters)localObject1).setFocusMode((String)localObject3);
      }
      this.j.setParameters((Camera.Parameters)localObject1);
      this.j.setPreviewCallback(this);
      try
      {
        this.j.setPreviewDisplay(this.k);
        this.j.startPreview();
        if ((((Camera.Parameters)localObject1).getFocusMode().equals("auto")) || (((Camera.Parameters)localObject1).getFocusMode().equals("macro"))) {
          e();
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        Camera localCamera = this.j;
        if (localCamera != null)
        {
          localCamera.release();
          this.j = null;
        }
      }
      if (this.s == FaceDetector.IdCardDirection.DT_FRONT)
      {
        b = 0;
        a = 0;
        bv.a().a(System.currentTimeMillis(), 130);
        return;
      }
      d = 0;
      c = 0;
      bv.a().a(System.currentTimeMillis(), 132);
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Camera getParameters failed");
      ((StringBuilder)localObject2).append(this.j);
      g.c(((StringBuilder)localObject2).toString());
      localObject2 = this.h.obtainMessage(0);
      ((Message)localObject2).what = 2;
      ((Message)localObject2).sendToTarget();
    }
  }
  
  private void g()
  {
    Object localObject = new Camera.CameraInfo();
    int i2 = Camera.getNumberOfCameras();
    int i1 = 0;
    while (i1 < i2)
    {
      Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject);
      if (((Camera.CameraInfo)localObject).facing == 0) {
        try
        {
          this.j = Camera.open(i1);
        }
        catch (RuntimeException localRuntimeException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("CameraOpen camera=");
          localStringBuilder.append(this.j);
          g.c(localStringBuilder.toString());
          localRuntimeException.printStackTrace();
        }
      }
      i1 += 1;
    }
    if (this.j == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CameraOpen camera=");
      ((StringBuilder)localObject).append(this.j);
      g.c(((StringBuilder)localObject).toString());
      localObject = this.h.obtainMessage(0);
      ((Message)localObject).what = 2;
      ((Message)localObject).sendToTarget();
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 68	com/tencent/token/ui/e:f	Landroid/content/Context;
    //   9: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   12: invokevirtual 368	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   15: ldc_w 370
    //   18: invokevirtual 375	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore 4
    //   23: new 377	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 68	com/tencent/token/ui/e:f	Landroid/content/Context;
    //   31: ldc_w 379
    //   34: iconst_0
    //   35: invokevirtual 383	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   38: ldc_w 370
    //   41: invokespecial 386	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 390	java/io/File:exists	()Z
    //   51: ifeq +29 -> 80
    //   54: aload_0
    //   55: aload 5
    //   57: invokevirtual 393	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: putfield 140	com/tencent/token/ui/e:t	Ljava/lang/String;
    //   63: aload 4
    //   65: ifnull +14 -> 79
    //   68: aload 4
    //   70: invokevirtual 398	java/io/InputStream:close	()V
    //   73: return
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   79: return
    //   80: new 400	java/io/FileOutputStream
    //   83: dup
    //   84: aload 5
    //   86: invokespecial 403	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   89: astore_2
    //   90: sipush 8192
    //   93: newarray byte
    //   95: astore_3
    //   96: aload 4
    //   98: aload_3
    //   99: invokevirtual 407	java/io/InputStream:read	([B)I
    //   102: istore_1
    //   103: iload_1
    //   104: iconst_m1
    //   105: if_icmpeq +13 -> 118
    //   108: aload_2
    //   109: aload_3
    //   110: iconst_0
    //   111: iload_1
    //   112: invokevirtual 411	java/io/FileOutputStream:write	([BII)V
    //   115: goto -19 -> 96
    //   118: aload_0
    //   119: aload 5
    //   121: invokevirtual 393	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: putfield 140	com/tencent/token/ui/e:t	Ljava/lang/String;
    //   127: aload 4
    //   129: ifnull +8 -> 137
    //   132: aload 4
    //   134: invokevirtual 398	java/io/InputStream:close	()V
    //   137: aload_2
    //   138: invokevirtual 412	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore 5
    //   144: aload_2
    //   145: astore_3
    //   146: aload 5
    //   148: astore_2
    //   149: goto +72 -> 221
    //   152: astore_2
    //   153: goto +68 -> 221
    //   156: aconst_null
    //   157: astore_2
    //   158: aload 4
    //   160: astore_3
    //   161: goto +15 -> 176
    //   164: astore_2
    //   165: aconst_null
    //   166: astore 4
    //   168: goto +53 -> 221
    //   171: aconst_null
    //   172: astore_2
    //   173: aload 5
    //   175: astore_3
    //   176: ldc_w 414
    //   179: invokestatic 100	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   182: aload_3
    //   183: ifnull +10 -> 193
    //   186: aload_3
    //   187: invokevirtual 398	java/io/InputStream:close	()V
    //   190: goto +3 -> 193
    //   193: aload_2
    //   194: ifnull +12 -> 206
    //   197: aload_2
    //   198: invokevirtual 412	java/io/FileOutputStream:close	()V
    //   201: return
    //   202: aload_2
    //   203: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   206: return
    //   207: astore 4
    //   209: aload_2
    //   210: astore 5
    //   212: aload 4
    //   214: astore_2
    //   215: aload_3
    //   216: astore 4
    //   218: aload 5
    //   220: astore_3
    //   221: aload 4
    //   223: ifnull +11 -> 234
    //   226: aload 4
    //   228: invokevirtual 398	java/io/InputStream:close	()V
    //   231: goto +3 -> 234
    //   234: aload_3
    //   235: ifnull +14 -> 249
    //   238: aload_3
    //   239: invokevirtual 412	java/io/FileOutputStream:close	()V
    //   242: goto +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   249: aload_2
    //   250: athrow
    //   251: astore_2
    //   252: goto -81 -> 171
    //   255: astore_2
    //   256: goto -100 -> 156
    //   259: astore_3
    //   260: goto -102 -> 158
    //   263: astore_2
    //   264: goto -62 -> 202
    //   267: astore_3
    //   268: goto -23 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	e
    //   102	10	1	i1	int
    //   74	2	2	localException1	Exception
    //   89	60	2	localObject1	Object
    //   152	1	2	localObject2	Object
    //   157	1	2	localObject3	Object
    //   164	1	2	localObject4	Object
    //   172	78	2	localObject5	Object
    //   251	1	2	localIOException1	java.io.IOException
    //   255	1	2	localIOException2	java.io.IOException
    //   263	1	2	localException2	Exception
    //   1	245	3	localObject6	Object
    //   259	1	3	localIOException3	java.io.IOException
    //   267	1	3	localException3	Exception
    //   21	146	4	localInputStream	java.io.InputStream
    //   207	6	4	localObject7	Object
    //   216	11	4	localObject8	Object
    //   3	117	5	localFile	java.io.File
    //   142	32	5	localObject9	Object
    //   210	9	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   68	73	74	java/lang/Exception
    //   90	96	142	finally
    //   96	103	142	finally
    //   108	115	142	finally
    //   118	127	142	finally
    //   23	63	152	finally
    //   80	90	152	finally
    //   5	23	164	finally
    //   176	182	207	finally
    //   5	23	251	java/io/IOException
    //   23	63	255	java/io/IOException
    //   80	90	255	java/io/IOException
    //   90	96	259	java/io/IOException
    //   96	103	259	java/io/IOException
    //   108	115	259	java/io/IOException
    //   118	127	259	java/io/IOException
    //   132	137	263	java/lang/Exception
    //   137	141	263	java/lang/Exception
    //   186	190	263	java/lang/Exception
    //   197	201	263	java/lang/Exception
    //   226	231	267	java/lang/Exception
    //   238	242	267	java/lang/Exception
  }
  
  public void a()
  {
    if (this.j != null) {
      return;
    }
    g();
    f();
    this.i = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      if (this.j != null)
      {
        this.j.setPreviewCallback(null);
        this.j.stopPreview();
        this.j.release();
        this.j = null;
      }
      d();
      FaceDetector.IdCardDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    Camera localCamera = this.j;
    if (localCamera == null) {
      return;
    }
    try
    {
      localCamera.autoFocus(this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("camera auto focus ");
      localStringBuilder.append(localException.toString());
      g.d(localStringBuilder.toString());
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("camera auto focus ");
      localStringBuilder.append(localRuntimeException.toString());
      g.d(localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.l = null;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.m = null;
    }
  }
  
  public void e()
  {
    this.l = new Timer(false);
    this.m = new TimerTask()
    {
      public void run()
      {
        e.this.c();
      }
    };
    this.l.schedule(this.m, 500L, 2000L);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.g) {
      return;
    }
    if ((!this.q) && (!this.p)) {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            synchronized (e.this.e)
            {
              e.a(e.this, true);
              e.a(e.this);
              e.b(e.this, FaceDetector.IdCardDetectInitial(e.b(e.this)));
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("IdCardDetectInitial: ");
              localStringBuilder.append(e.c(e.this));
              localStringBuilder.append(",mIdCardModelPath=");
              localStringBuilder.append(e.b(e.this));
              g.c(localStringBuilder.toString());
              e.c(e.this, true);
              e.a(e.this, false);
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
      a += 1;
    } else {
      c += 1;
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
      StringBuilder localStringBuilder = new StringBuilder();
      l2 = l1;
      l3 = l1;
      localStringBuilder.append("IdCardDetect detect ret: ");
      l2 = l1;
      l3 = l1;
      localStringBuilder.append(l1);
      l2 = l1;
      l3 = l1;
      g.c(localStringBuilder.toString());
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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("id_card ret: ");
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
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.i);
      g.c(((StringBuilder)localObject3).toString());
      if (this.s == FaceDetector.IdCardDirection.DT_FRONT)
      {
        b = (int)(System.currentTimeMillis() - this.i);
        localObject3 = com.tencent.token.utils.e.a(((IdCardInfo)localObject1).data(), "frontdata");
        localObject2 = this.h.obtainMessage(0);
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putByteArray("info", ((IdCardInfo)localObject1).info());
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).arg1 = 1;
        ((Message)localObject2).sendToTarget();
        bv.a().a(System.currentTimeMillis(), 131);
      }
      else if (this.s == FaceDetector.IdCardDirection.DT_BACK)
      {
        d = (int)(System.currentTimeMillis() - this.i);
        localObject3 = com.tencent.token.utils.e.a(((IdCardInfo)localObject1).data(), "backdata");
        localObject2 = this.h.obtainMessage(0);
        ((Message)localObject2).what = 1;
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putByteArray("info", ((IdCardInfo)localObject1).info());
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).arg1 = 2;
        ((Message)localObject2).sendToTarget();
        bv.a().a(System.currentTimeMillis(), 133);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("take id photo data=");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      g.a(((StringBuilder)localObject1).toString());
      paramCamera.stopPreview();
      this.g = true;
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("ret=");
    paramArrayOfByte.append(l1);
    g.a(paramArrayOfByte.toString());
    if ((l1 != 3L) && (l1 != 5L))
    {
      if ((l1 == 2L) || (l1 == 4L)) {
        this.h.obtainMessage(7).sendToTarget();
      }
    }
    else {
      this.h.obtainMessage(6).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.e
 * JD-Core Version:    0.7.0.1
 */