package com.tencent.token.ui;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.jni.Face;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.global.e;
import com.tencent.token.utils.t;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FaceRecognitionCameraPreviewOld
  extends FaceRecognitionCameraPreview
  implements SurfaceHolder.Callback
{
  public static boolean i = false;
  public Camera a;
  public Face b;
  final long c = 0L;
  Handler d;
  long e = 0L;
  int f;
  int g;
  float[] h;
  Object j = new Object();
  private SurfaceHolder k;
  private int l;
  private int m;
  private int n = -1;
  private long o = 2000L;
  private long p;
  private int q;
  private boolean r;
  private int[] s;
  private float t;
  private float u;
  private ExecutorService v = Executors.newSingleThreadExecutor();
  private volatile boolean w = false;
  private boolean x;
  private boolean y = true;
  private int z = 1;
  
  public FaceRecognitionCameraPreviewOld(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = t.k();
    this.h = new float[3];
    this.h[0] = paramContext.mRegRayThres;
    this.h[1] = paramContext.mVerifyRayThres;
    this.h[2] = paramContext.mDisparityThres;
  }
  
  private void a(List paramList)
  {
    this.l = ((Camera.Size)paramList.get(0)).width;
    this.m = ((Camera.Size)paramList.get(0)).height;
    int i1 = 1;
    while (i1 < paramList.size())
    {
      if (Math.abs(this.l / this.m - this.f / this.g) > Math.abs(((Camera.Size)paramList.get(i1)).width / ((Camera.Size)paramList.get(i1)).height - this.f / this.g))
      {
        this.l = ((Camera.Size)paramList.get(i1)).width;
        this.m = ((Camera.Size)paramList.get(i1)).height;
      }
      i1 += 1;
    }
    e.c("debug------------mPreviewWidth=" + this.l + ",mPreviewHeight=" + this.m);
  }
  
  public final void a()
  {
    if (this.v != null) {
      this.v.shutdownNow();
    }
    if (this.b != null)
    {
      this.r = true;
      new Thread(new hw(this)).start();
    }
    this.d = null;
    i = true;
  }
  
  public final void a(Context paramContext, int paramInt, Handler paramHandler)
  {
    this.d = paramHandler;
    this.n = paramInt;
    this.k = getHolder();
    this.k.addCallback(this);
    this.k.setType(3);
    this.t = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.f = paramContext.heightPixels;
    this.g = paramContext.widthPixels;
    this.u = (this.g / this.f);
    e.b("screenWidth =" + this.f + ",screenHeight=" + this.g + ",range=" + this.u);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.r = true;
      return;
    }
    this.v = Executors.newSingleThreadExecutor();
    this.q = 0;
    this.r = false;
  }
  
  public final void b(int paramInt)
  {
    this.r = false;
    this.e = 0L;
    this.p = 0L;
    com.tencent.token.cv.c = "";
    com.tencent.token.cv.d = 0;
    com.tencent.token.cv.e = 0;
    com.tencent.token.cv.g = 0;
    com.tencent.token.cv.f = 0;
    com.tencent.token.cv.h = 0;
    this.v = Executors.newSingleThreadExecutor();
    this.q = paramInt;
    this.r = false;
  }
  
  public final void c()
  {
    this.v = Executors.newSingleThreadExecutor();
    this.q = 0;
    this.r = false;
  }
  
  public final void d()
  {
    this.r = true;
  }
  
  /* Error */
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 203	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:k	Landroid/view/SurfaceHolder;
    //   4: invokeinterface 277 1 0
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   17: invokevirtual 284	android/hardware/Camera:stopPreview	()V
    //   20: new 139	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 286
    //   30: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_3
    //   34: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 288
    //   40: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 251	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   58: ifnonnull +118 -> 176
    //   61: aload_0
    //   62: iconst_4
    //   63: newarray int
    //   65: putfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   68: aload_0
    //   69: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   72: iconst_0
    //   73: bipush 60
    //   75: iastore
    //   76: aload_0
    //   77: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   80: iconst_1
    //   81: sipush 140
    //   84: iastore
    //   85: aload_0
    //   86: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   89: iconst_2
    //   90: sipush 360
    //   93: iastore
    //   94: aload_0
    //   95: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   98: iconst_3
    //   99: sipush 460
    //   102: iastore
    //   103: new 139	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 290
    //   113: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   120: iconst_0
    //   121: iaload
    //   122: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc_w 292
    //   128: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   135: iconst_1
    //   136: iaload
    //   137: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: ldc_w 292
    //   143: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   150: iconst_2
    //   151: iaload
    //   152: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc_w 292
    //   158: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   165: iconst_3
    //   166: iaload
    //   167: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 294	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   176: aload_0
    //   177: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   180: ifnull -168 -> 12
    //   183: aload_0
    //   184: getfield 196	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:d	Landroid/os/Handler;
    //   187: iconst_0
    //   188: invokevirtual 300	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   191: astore_1
    //   192: aload_1
    //   193: bipush 10
    //   195: putfield 305	android/os/Message:what	I
    //   198: aload_1
    //   199: iload_3
    //   200: putfield 308	android/os/Message:arg1	I
    //   203: aload_1
    //   204: iload 4
    //   206: putfield 311	android/os/Message:arg2	I
    //   209: aload_1
    //   210: invokevirtual 314	android/os/Message:sendToTarget	()V
    //   213: aload_0
    //   214: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   217: invokevirtual 318	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   220: astore_1
    //   221: aload_1
    //   222: sipush 256
    //   225: invokevirtual 323	android/hardware/Camera$Parameters:setPictureFormat	(I)V
    //   228: aload_1
    //   229: bipush 17
    //   231: invokevirtual 326	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   234: aload_0
    //   235: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   238: invokevirtual 318	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   241: invokevirtual 329	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   244: astore 5
    //   246: iconst_0
    //   247: istore_2
    //   248: iload_2
    //   249: aload 5
    //   251: invokeinterface 127 1 0
    //   256: if_icmpge +72 -> 328
    //   259: aload 5
    //   261: iload_2
    //   262: invokeinterface 111 2 0
    //   267: checkcast 113	android/hardware/Camera$Size
    //   270: astore 6
    //   272: new 139	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 331
    //   282: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 6
    //   287: getfield 116	android/hardware/Camera$Size:width	I
    //   290: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 333
    //   296: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 6
    //   301: getfield 121	android/hardware/Camera$Size:height	I
    //   304: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 251	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   313: iload_2
    //   314: iconst_1
    //   315: iadd
    //   316: istore_2
    //   317: goto -69 -> 248
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 336	java/lang/Exception:printStackTrace	()V
    //   325: goto -305 -> 20
    //   328: aload_0
    //   329: invokevirtual 337	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:getResources	()Landroid/content/res/Resources;
    //   332: invokevirtual 341	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   335: getfield 346	android/content/res/Configuration:orientation	I
    //   338: iconst_2
    //   339: if_icmpeq +296 -> 635
    //   342: aload_1
    //   343: ldc_w 347
    //   346: ldc_w 349
    //   349: invokevirtual 353	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_1
    //   353: ldc_w 355
    //   356: bipush 90
    //   358: invokevirtual 358	android/hardware/Camera$Parameters:set	(Ljava/lang/String;I)V
    //   361: aload_0
    //   362: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   365: bipush 90
    //   367: invokevirtual 361	android/hardware/Camera:setDisplayOrientation	(I)V
    //   370: getstatic 366	android/os/Build:MODEL	Ljava/lang/String;
    //   373: ldc_w 368
    //   376: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   379: ifeq +13 -> 392
    //   382: aload_0
    //   383: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   386: sipush 270
    //   389: invokevirtual 361	android/hardware/Camera:setDisplayOrientation	(I)V
    //   392: invokestatic 376	com/tencent/token/utils/t:o	()I
    //   395: istore_2
    //   396: iload_2
    //   397: ifeq +11 -> 408
    //   400: aload_0
    //   401: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   404: iload_2
    //   405: invokevirtual 361	android/hardware/Camera:setDisplayOrientation	(I)V
    //   408: aload_0
    //   409: aload 5
    //   411: invokespecial 378	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	(Ljava/util/List;)V
    //   414: aload_0
    //   415: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   418: iconst_0
    //   419: aload_0
    //   420: getfield 123	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:m	I
    //   423: bipush 60
    //   425: imul
    //   426: sipush 480
    //   429: idiv
    //   430: iastore
    //   431: aload_0
    //   432: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   435: iconst_1
    //   436: aload_0
    //   437: getfield 118	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:l	I
    //   440: sipush 140
    //   443: imul
    //   444: sipush 720
    //   447: idiv
    //   448: iastore
    //   449: aload_0
    //   450: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   453: iconst_2
    //   454: aload_0
    //   455: getfield 123	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:m	I
    //   458: sipush 360
    //   461: imul
    //   462: sipush 480
    //   465: idiv
    //   466: iastore
    //   467: aload_0
    //   468: getfield 169	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:s	[I
    //   471: iconst_3
    //   472: aload_0
    //   473: getfield 118	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:l	I
    //   476: sipush 460
    //   479: imul
    //   480: sipush 720
    //   483: idiv
    //   484: iastore
    //   485: aload_1
    //   486: aload_0
    //   487: getfield 118	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:l	I
    //   490: aload_0
    //   491: getfield 123	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:m	I
    //   494: invokevirtual 382	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   497: new 139	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   504: aload_0
    //   505: getfield 123	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:m	I
    //   508: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: ldc_w 384
    //   514: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_0
    //   518: getfield 118	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:l	I
    //   521: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: putstatic 261	com/tencent/token/cv:c	Ljava/lang/String;
    //   530: aload_0
    //   531: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   534: new 386	com/tencent/token/ui/hu
    //   537: dup
    //   538: aload_0
    //   539: invokespecial 387	com/tencent/token/ui/hu:<init>	(Lcom/tencent/token/ui/FaceRecognitionCameraPreviewOld;)V
    //   542: invokevirtual 391	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   545: aload_0
    //   546: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   549: aload_1
    //   550: invokevirtual 395	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   553: aload_0
    //   554: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   557: invokevirtual 398	android/hardware/Camera:startPreview	()V
    //   560: aload_0
    //   561: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   564: invokevirtual 318	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   567: invokevirtual 402	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   570: astore_1
    //   571: new 139	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   578: ldc_w 404
    //   581: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload_1
    //   585: getfield 116	android/hardware/Camera$Size:width	I
    //   588: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: ldc_w 406
    //   594: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload_1
    //   598: getfield 121	android/hardware/Camera$Size:height	I
    //   601: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   604: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 251	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   610: return
    //   611: astore_1
    //   612: aload_1
    //   613: invokevirtual 336	java/lang/Exception:printStackTrace	()V
    //   616: aload_0
    //   617: getfield 196	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:d	Landroid/os/Handler;
    //   620: iconst_0
    //   621: invokevirtual 300	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   624: astore_1
    //   625: aload_1
    //   626: iconst_2
    //   627: putfield 305	android/os/Message:what	I
    //   630: aload_1
    //   631: invokevirtual 314	android/os/Message:sendToTarget	()V
    //   634: return
    //   635: aload_1
    //   636: ldc_w 347
    //   639: ldc_w 408
    //   642: invokevirtual 353	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   645: aload_0
    //   646: getfield 279	com/tencent/token/ui/FaceRecognitionCameraPreviewOld:a	Landroid/hardware/Camera;
    //   649: iconst_0
    //   650: invokevirtual 361	android/hardware/Camera:setDisplayOrientation	(I)V
    //   653: goto -245 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	this	FaceRecognitionCameraPreviewOld
    //   0	656	1	paramSurfaceHolder	SurfaceHolder
    //   0	656	2	paramInt1	int
    //   0	656	3	paramInt2	int
    //   0	656	4	paramInt3	int
    //   244	166	5	localList	List
    //   270	30	6	localSize	Camera.Size
    // Exception table:
    //   from	to	target	type
    //   13	20	320	java/lang/Exception
    //   183	246	611	java/lang/Exception
    //   248	313	611	java/lang/Exception
    //   328	392	611	java/lang/Exception
    //   392	396	611	java/lang/Exception
    //   400	408	611	java/lang/Exception
    //   408	610	611	java/lang/Exception
    //   635	653	611	java/lang/Exception
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i2 = 0;
    e.c("surfaceCreated!");
    int i3;
    try
    {
      if (this.a != null) {
        break label260;
      }
      paramSurfaceHolder = new Camera.CameraInfo();
      i3 = Camera.getNumberOfCameras();
      i1 = 0;
      for (;;)
      {
        if (i1 < i3)
        {
          Camera.getCameraInfo(i1, paramSurfaceHolder);
          int i4 = paramSurfaceHolder.facing;
          if (i4 == 1) {}
          try
          {
            this.a = Camera.open(i1);
            this.z = 1;
            i1 += 1;
          }
          catch (RuntimeException localRuntimeException1)
          {
            for (;;)
            {
              e.c("CameraOpen camera=" + this.a);
            }
          }
        }
      }
      if (this.a != null) {
        break label209;
      }
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      if (this.a != null)
      {
        this.a.release();
        this.a = null;
      }
      return;
    }
    int i1 = i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Camera.getCameraInfo(i1, paramSurfaceHolder);
        i2 = paramSurfaceHolder.facing;
        if (i2 == 0) {}
        try
        {
          this.a = Camera.open(i1);
          this.z = 0;
          i1 += 1;
        }
        catch (RuntimeException localRuntimeException2)
        {
          for (;;)
          {
            e.c("CameraOpen camera=" + this.a);
          }
        }
      }
    }
    label209:
    if (this.a == null)
    {
      e.c("CameraOpen camera=" + this.a);
      paramSurfaceHolder = this.d.obtainMessage(0);
      paramSurfaceHolder.what = 2;
      paramSurfaceHolder.sendToTarget();
    }
    label260:
    i = false;
    this.a.setPreviewDisplay(this.k);
    this.a.startPreview();
    e.c("surfaceCreated!------isReleased: " + i);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    e.c("surfaceDestroyed!");
    if (this.a != null)
    {
      this.a.setPreviewCallback(null);
      this.a.stopPreview();
      this.a.release();
      this.a = null;
      i = true;
    }
    e.c("surfaceDestroyed!------isReleased: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCameraPreviewOld
 * JD-Core Version:    0.7.0.1
 */