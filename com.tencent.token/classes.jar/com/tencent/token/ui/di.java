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
import com.tencent.token.ch;
import com.tencent.token.core.protocolcenter.protocol.ProtoAutoIDCardDetect;
import com.tencent.token.global.h;
import com.tencent.token.utils.i;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class di
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
  
  public di(Context paramContext, SurfaceHolder paramSurfaceHolder, Handler paramHandler, FaceDetector.IdCardDirection paramIdCardDirection)
  {
    this.f = paramContext;
    this.h = paramHandler;
    this.k = paramSurfaceHolder;
    this.s = paramIdCardDirection;
    this.o = 0;
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
      h.b("resolution Settable value: " + paramCollection);
      return paramCollection;
      i1 += 1;
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
  
  private void f()
  {
    if (this.j == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = this.f.getResources().getDisplayMetrics();
    int i6 = localDisplayMetrics.widthPixels;
    int i7 = localDisplayMetrics.heightPixels;
    Object localObject2;
    int i3;
    int i2;
    int i1;
    try
    {
      localObject2 = this.j.getParameters().getSupportedPreviewSizes();
      i3 = ((Camera.Size)((List)localObject2).get(0)).width;
      i2 = ((Camera.Size)((List)localObject2).get(0)).height;
      int i4 = 1;
      while (i4 < ((List)localObject2).size())
      {
        double d1 = Math.abs(i3 / i2 - i6 / i7);
        double d2 = Math.abs(((Camera.Size)((List)localObject2).get(i4)).width / ((Camera.Size)((List)localObject2).get(i4)).height - i6 / i7);
        i1 = i3;
        if (d1 >= d2)
        {
          i3 = ((Camera.Size)((List)localObject2).get(i4)).width;
          int i5 = ((Camera.Size)((List)localObject2).get(i4)).height;
          i2 = i5;
          i1 = i3;
          if (d1 == d2)
          {
            i2 = i5;
            i1 = i3;
            if (i3 < ((Camera.Size)((List)localObject2).get(i4)).width)
            {
              i1 = ((Camera.Size)((List)localObject2).get(i4)).width;
              i2 = ((Camera.Size)((List)localObject2).get(i4)).height;
            }
          }
        }
        i4 += 1;
        i3 = i1;
      }
      h.c("debug------------bestPreviewWidth=" + i3 + ",bestPreviewHeight=" + i2 + ", screenWidth=" + i6 + ",screenHeight=" + i7 + ",density=" + ((DisplayMetrics)localObject1).density);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      h.c("Camera getParameters failed" + this.j);
      localObject1 = this.h.obtainMessage(0);
      ((Message)localObject1).what = 2;
      ((Message)localObject1).sendToTarget();
      return;
    }
    Object localObject1 = this.j.getParameters();
    ((Camera.Parameters)localObject1).setPictureFormat(256);
    ((Camera.Parameters)localObject1).setPreviewFormat(17);
    if (this.f.getResources().getConfiguration().orientation != 2) {
      i1 = 90;
    }
    for (this.n = 90;; this.n = 0)
    {
      if (ProtoAutoIDCardDetect.d != -1) {
        i1 = ProtoAutoIDCardDetect.d;
      }
      if (ProtoAutoIDCardDetect.e != -1) {
        this.n = ProtoAutoIDCardDetect.e;
      }
      a(this.j, i1);
      ((Camera.Parameters)localObject1).setPreviewSize(i3, i2);
      localObject2 = a(((Camera.Parameters)localObject1).getSupportedFocusModes(), new String[] { "auto" });
      if (localObject2 != null) {
        ((Camera.Parameters)localObject1).setFocusMode((String)localObject2);
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
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          if (this.j != null)
          {
            this.j.release();
            this.j = null;
          }
        }
        d = 0;
        c = 0;
        ch.a().a(System.currentTimeMillis(), 132);
      }
      if (this.s != FaceDetector.IdCardDirection.DT_FRONT) {
        break;
      }
      b = 0;
      a = 0;
      ch.a().a(System.currentTimeMillis(), 130);
      return;
      i1 = 0;
    }
  }
  
  private void g()
  {
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
          this.j = Camera.open(i1);
          i1 += 1;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            h.c("CameraOpen camera=" + this.j);
            localRuntimeException.printStackTrace();
          }
        }
      }
    }
    if (this.j == null)
    {
      h.c("CameraOpen camera=" + this.j);
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
    //   2: aload_0
    //   3: getfield 64	com/tencent/token/ui/di:f	Landroid/content/Context;
    //   6: invokevirtual 143	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: invokevirtual 356	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   12: ldc_w 358
    //   15: invokevirtual 363	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: new 365	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: getfield 64	com/tencent/token/ui/di:f	Landroid/content/Context;
    //   27: ldc_w 367
    //   30: iconst_0
    //   31: invokevirtual 371	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   34: ldc_w 358
    //   37: invokespecial 374	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 5
    //   42: aload 5
    //   44: invokevirtual 378	java/io/File:exists	()Z
    //   47: ifeq +39 -> 86
    //   50: aload_0
    //   51: aload 5
    //   53: invokevirtual 381	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: putfield 134	com/tencent/token/ui/di:t	Ljava/lang/String;
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 386	java/io/InputStream:close	()V
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 388	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 389	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: return
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   85: return
    //   86: new 391	java/io/FileOutputStream
    //   89: dup
    //   90: aload 5
    //   92: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore 4
    //   97: sipush 8192
    //   100: newarray byte
    //   102: astore_3
    //   103: aload_2
    //   104: aload_3
    //   105: invokevirtual 398	java/io/InputStream:read	([B)I
    //   108: istore_1
    //   109: iload_1
    //   110: iconst_m1
    //   111: if_icmpeq +47 -> 158
    //   114: aload 4
    //   116: aload_3
    //   117: iconst_0
    //   118: iload_1
    //   119: invokevirtual 402	java/io/FileOutputStream:write	([BII)V
    //   122: goto -19 -> 103
    //   125: astore_3
    //   126: aload 4
    //   128: astore_3
    //   129: ldc_w 404
    //   132: invokestatic 96	com/tencent/token/global/h:b	(Ljava/lang/String;)V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 386	java/io/InputStream:close	()V
    //   143: aload_3
    //   144: ifnull -65 -> 79
    //   147: aload_3
    //   148: invokevirtual 405	java/io/FileOutputStream:close	()V
    //   151: return
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   157: return
    //   158: aload_0
    //   159: aload 5
    //   161: invokevirtual 381	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   164: putfield 134	com/tencent/token/ui/di:t	Ljava/lang/String;
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 386	java/io/InputStream:close	()V
    //   175: aload 4
    //   177: ifnull -98 -> 79
    //   180: aload 4
    //   182: invokevirtual 405	java/io/FileOutputStream:close	()V
    //   185: return
    //   186: astore_2
    //   187: aload_2
    //   188: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   191: return
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: aconst_null
    //   196: astore 4
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 386	java/io/InputStream:close	()V
    //   206: aload 4
    //   208: ifnull +8 -> 216
    //   211: aload 4
    //   213: invokevirtual 405	java/io/FileOutputStream:close	()V
    //   216: aload_3
    //   217: athrow
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   223: goto -7 -> 216
    //   226: astore_3
    //   227: aconst_null
    //   228: astore 4
    //   230: goto -32 -> 198
    //   233: astore_3
    //   234: goto -36 -> 198
    //   237: astore 5
    //   239: aload_3
    //   240: astore 4
    //   242: aload 5
    //   244: astore_3
    //   245: goto -47 -> 198
    //   248: astore_2
    //   249: aconst_null
    //   250: astore_2
    //   251: goto -122 -> 129
    //   254: astore 4
    //   256: goto -127 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	di
    //   108	11	1	i1	int
    //   18	46	2	localInputStream	java.io.InputStream
    //   80	60	2	localException1	Exception
    //   152	20	2	localException2	Exception
    //   186	2	2	localException3	Exception
    //   194	9	2	localObject1	Object
    //   218	2	2	localException4	Exception
    //   248	1	2	localIOException1	java.io.IOException
    //   250	1	2	localObject2	Object
    //   1	116	3	arrayOfByte	byte[]
    //   125	1	3	localIOException2	java.io.IOException
    //   128	20	3	localObject3	Object
    //   192	25	3	localObject4	Object
    //   226	1	3	localObject5	Object
    //   233	7	3	localObject6	Object
    //   244	1	3	localObject7	Object
    //   95	146	4	localObject8	Object
    //   254	1	4	localIOException3	java.io.IOException
    //   40	120	5	localFile	java.io.File
    //   237	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	80	java/lang/Exception
    //   71	79	80	java/lang/Exception
    //   97	103	125	java/io/IOException
    //   103	109	125	java/io/IOException
    //   114	122	125	java/io/IOException
    //   158	167	125	java/io/IOException
    //   139	143	152	java/lang/Exception
    //   147	151	152	java/lang/Exception
    //   171	175	186	java/lang/Exception
    //   180	185	186	java/lang/Exception
    //   2	19	192	finally
    //   202	206	218	java/lang/Exception
    //   211	216	218	java/lang/Exception
    //   19	59	226	finally
    //   86	97	226	finally
    //   97	103	233	finally
    //   103	109	233	finally
    //   114	122	233	finally
    //   158	167	233	finally
    //   129	135	237	finally
    //   2	19	248	java/io/IOException
    //   19	59	254	java/io/IOException
    //   86	97	254	java/io/IOException
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
    if (this.j == null) {
      return;
    }
    try
    {
      this.j.autoFocus(this);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      h.d("camera auto focus " + localRuntimeException.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      h.d("camera auto focus " + localException.toString());
    }
  }
  
  public void d()
  {
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
  }
  
  public void e()
  {
    this.l = new Timer(false);
    this.m = new dk(this);
    this.l.schedule(this.m, 500L, 2000L);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.g) {}
    do
    {
      do
      {
        return;
        if ((!this.q) && (!this.p)) {
          new Thread(new dj(this)).start();
        }
      } while (this.p);
      this.o += 1;
    } while (this.o % 2 == 0);
    label84:
    Object localObject1;
    int i1;
    int i2;
    IdCardInfo localIdCardInfo;
    long l2;
    if (this.s == FaceDetector.IdCardDirection.DT_FRONT)
    {
      a += 1;
      localObject1 = paramCamera.getParameters();
      i1 = ((Camera.Parameters)localObject1).getPreviewSize().width;
      i2 = ((Camera.Parameters)localObject1).getPreviewSize().height;
      localIdCardInfo = new IdCardInfo();
      l2 = System.currentTimeMillis();
    }
    for (;;)
    {
      try
      {
        if (!this.r) {
          break label681;
        }
        i1 = FaceDetector.IdCardDetect(localIdCardInfo, this.s, paramArrayOfByte, i1, i2, this.n);
        l1 = i1;
      }
      catch (Exception localException1)
      {
        long l3;
        l1 = -1L;
        localException1.printStackTrace();
        continue;
      }
      catch (Error localError1)
      {
        l1 = -1L;
        localError1.printStackTrace();
        continue;
        if (this.s != FaceDetector.IdCardDirection.DT_BACK) {
          continue;
        }
        d = (int)(System.currentTimeMillis() - this.i);
        Object localObject2 = i.a(localIdCardInfo.data(), "backdata");
        Message localMessage = this.h.obtainMessage(0);
        localMessage.what = 1;
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putByteArray("info", localIdCardInfo.info());
        localMessage.setData((Bundle)localObject2);
        localMessage.arg1 = 2;
        localMessage.sendToTarget();
        ch.a().a(System.currentTimeMillis(), 133);
        continue;
        h.a("ret=" + l1);
        if ((l1 == 3L) || (l1 == 5L))
        {
          this.h.obtainMessage(6).sendToTarget();
          return;
        }
      }
      try
      {
        h.c("IdCardDetect detect ret: " + l1);
        l3 = System.currentTimeMillis();
        localObject1 = "id_card ret: " + l1 + " time: " + (l3 - l2) + " info: " + localIdCardInfo.info() + ", side=" + this.s;
        if (l1 != 0L) {
          continue;
        }
        h.c((String)localObject1 + ", totaltime=" + (System.currentTimeMillis() - this.i));
        if (this.s != FaceDetector.IdCardDirection.DT_FRONT) {
          continue;
        }
        b = (int)(System.currentTimeMillis() - this.i);
        localObject2 = i.a(localIdCardInfo.data(), "frontdata");
        localObject1 = this.h.obtainMessage(0);
        ((Message)localObject1).what = 1;
        ((Message)localObject1).obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putByteArray("info", localIdCardInfo.info());
        ((Message)localObject1).setData((Bundle)localObject2);
        ((Message)localObject1).arg1 = 1;
        ((Message)localObject1).sendToTarget();
        ch.a().a(System.currentTimeMillis(), 131);
        h.a("take id photo data=" + paramArrayOfByte.length);
        paramCamera.stopPreview();
        this.g = true;
        return;
      }
      catch (Error localError2)
      {
        continue;
      }
      catch (Exception localException2)
      {
        continue;
      }
      c += 1;
      break label84;
      if ((l1 != 2L) && (l1 != 4L)) {
        break;
      }
      this.h.obtainMessage(7).sendToTarget();
      return;
      label681:
      long l1 = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.di
 * JD-Core Version:    0.7.0.1
 */