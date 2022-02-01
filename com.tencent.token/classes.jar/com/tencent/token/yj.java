package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.jni.DirectionInfo;
import com.tencent.jni.FaceData;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceDetector.LiveAction;
import com.tencent.jni.FaceDetector.LiveDirection;
import com.tencent.jni.FaceThreshold;
import com.tencent.jni.LiveRectInfo;
import com.tencent.jni.LiveThreshold;
import com.tencent.service.DetectType;
import com.tencent.service.FaceServiceDelegate;
import com.tencent.service.FaceServiceDelegate.FaceDetectErrorCode;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.FaceView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class yj
  implements Camera.PreviewCallback, FaceServiceDelegate
{
  public static int k = 21;
  public static int n = ;
  public static int o = aap.u();
  private rn A;
  private Context B = RqdApplication.p();
  private Activity C;
  private SurfaceHolder D;
  private DetectType E;
  private int F;
  private int G;
  private int H;
  private FaceView I;
  private TextView J;
  private String K;
  private String L;
  private boolean M;
  private boolean N;
  private String O;
  private int P;
  private View Q;
  public boolean a = false;
  public boolean b = true;
  public long c;
  public Camera d;
  public int e;
  public int f;
  Object g = new Object();
  Object h = new Object();
  LiveRectInfo i = new LiveRectInfo();
  DirectionInfo j = new DirectionInfo();
  FaceDetector.LiveAction l = FaceDetector.LiveAction.ACT_BLINK;
  FaceDetector.LiveDirection m = FaceDetector.LiveDirection.LD_UP;
  boolean p = false;
  boolean q = false;
  boolean r = false;
  private long s = 0L;
  private long t = 0L;
  private long u = 2000L;
  private boolean v = false;
  private Handler w;
  private int[] x = new int[4];
  private float[] y;
  private int z;
  
  public yj(Context paramContext, SurfaceHolder paramSurfaceHolder, Handler paramHandler, int paramInt1, int paramInt2, FaceView paramFaceView, TextView paramTextView, View paramView)
  {
    k = aap.s();
    this.I = paramFaceView;
    this.J = paramTextView;
    this.C = ((Activity)paramContext);
    this.D = paramSurfaceHolder;
    this.w = paramHandler;
    this.z = paramInt1;
    this.E = DetectType.DT_VALIDATE;
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.E = DetectType.DT_REGISTER;
    }
    paramContext = aap.h();
    this.y = new float[3];
    this.y[0] = paramContext.mRegRayThres;
    this.y[1] = paramContext.mVerifyRayThres;
    this.y[2] = paramContext.mDisparityThres;
    this.I = paramFaceView;
    this.P = 0;
    this.Q = paramView;
  }
  
  private static void a(Activity paramActivity, int paramInt, Camera paramCamera)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    paramInt = 90;
    if (paramActivity == null)
    {
      if (RqdApplication.p().getResources().getConfiguration().orientation != 2)
      {
        paramCamera.setDisplayOrientation(90);
        return;
      }
      paramCamera.setDisplayOrientation(0);
      return;
    }
    switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      break;
    case 3: 
      paramInt = 270;
      break;
    case 2: 
      paramInt = 180;
      break;
    case 0: 
      paramInt = 0;
    }
    if (localCameraInfo.facing == 1) {
      paramInt = (360 - (localCameraInfo.orientation + paramInt) % 360) % 360;
    } else {
      paramInt = (localCameraInfo.orientation - paramInt + 360) % 360;
    }
    paramCamera.setDisplayOrientation(paramInt);
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 118	com/tencent/token/yj:B	Landroid/content/Context;
    //   13: invokevirtual 221	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   16: invokevirtual 344	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   19: aload_2
    //   20: invokevirtual 349	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 9
    //   25: aload 9
    //   27: arraylength
    //   28: ifle +166 -> 194
    //   31: new 351	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   38: astore 10
    //   40: aload 10
    //   42: aload_1
    //   43: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 10
    //   49: getstatic 361	java/io/File:separator	Ljava/lang/String;
    //   52: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 10
    //   58: aload_2
    //   59: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 10
    //   65: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 10
    //   70: new 358	java/io/File
    //   73: dup
    //   74: aload 10
    //   76: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 11
    //   81: aload 11
    //   83: invokevirtual 370	java/io/File:exists	()Z
    //   86: ifeq +4 -> 90
    //   89: return
    //   90: aload 11
    //   92: invokevirtual 373	java/io/File:mkdirs	()Z
    //   95: pop
    //   96: ldc_w 375
    //   99: aload 10
    //   101: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokevirtual 383	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 387	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   110: aload 9
    //   112: arraylength
    //   113: istore 4
    //   115: iconst_0
    //   116: istore_3
    //   117: iload_3
    //   118: iload 4
    //   120: if_icmpge +435 -> 555
    //   123: aload 9
    //   125: iload_3
    //   126: aaload
    //   127: astore 10
    //   129: new 351	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   136: astore 11
    //   138: aload 11
    //   140: aload_2
    //   141: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 11
    //   147: getstatic 361	java/io/File:separator	Ljava/lang/String;
    //   150: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 11
    //   156: aload 10
    //   158: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 11
    //   164: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore_2
    //   168: aload_0
    //   169: aload_1
    //   170: aload_2
    //   171: invokespecial 389	com/tencent/token/yj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_2
    //   175: iconst_0
    //   176: aload_2
    //   177: getstatic 392	java/io/File:separatorChar	C
    //   180: invokevirtual 396	java/lang/String:lastIndexOf	(I)I
    //   183: invokevirtual 400	java/lang/String:substring	(II)Ljava/lang/String;
    //   186: astore_2
    //   187: iload_3
    //   188: iconst_1
    //   189: iadd
    //   190: istore_3
    //   191: goto -74 -> 117
    //   194: aload_0
    //   195: getfield 118	com/tencent/token/yj:B	Landroid/content/Context;
    //   198: invokevirtual 221	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   201: invokevirtual 344	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   204: aload_2
    //   205: invokevirtual 404	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   208: astore 6
    //   210: new 351	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   217: astore 7
    //   219: aload 7
    //   221: aload_1
    //   222: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 7
    //   228: getstatic 361	java/io/File:separator	Ljava/lang/String;
    //   231: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 7
    //   237: aload_2
    //   238: iconst_0
    //   239: aload_2
    //   240: getstatic 361	java/io/File:separator	Ljava/lang/String;
    //   243: invokevirtual 406	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   246: invokevirtual 400	java/lang/String:substring	(II)Ljava/lang/String;
    //   249: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 7
    //   255: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore 7
    //   260: aload_2
    //   261: aload_2
    //   262: getstatic 392	java/io/File:separatorChar	C
    //   265: invokevirtual 396	java/lang/String:lastIndexOf	(I)I
    //   268: iconst_1
    //   269: iadd
    //   270: invokevirtual 409	java/lang/String:substring	(I)Ljava/lang/String;
    //   273: astore_2
    //   274: new 358	java/io/File
    //   277: dup
    //   278: aload 7
    //   280: aload_2
    //   281: invokespecial 411	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 370	java/io/File:exists	()Z
    //   289: istore 5
    //   291: iload 5
    //   293: ifeq +21 -> 314
    //   296: aload 6
    //   298: ifnull +15 -> 313
    //   301: aload 6
    //   303: invokevirtual 416	java/io/InputStream:close	()V
    //   306: return
    //   307: astore_1
    //   308: aload_1
    //   309: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   312: return
    //   313: return
    //   314: new 421	java/io/FileOutputStream
    //   317: dup
    //   318: aload_1
    //   319: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   322: astore_1
    //   323: new 351	java/lang/StringBuilder
    //   326: dup
    //   327: ldc_w 426
    //   330: invokespecial 427	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: astore 8
    //   335: aload 8
    //   337: aload 7
    //   339: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 8
    //   345: ldc_w 429
    //   348: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 8
    //   354: aload_2
    //   355: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 8
    //   361: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 387	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   367: sipush 1024
    //   370: newarray byte
    //   372: astore_2
    //   373: aload 6
    //   375: aload_2
    //   376: invokevirtual 433	java/io/InputStream:read	([B)I
    //   379: istore_3
    //   380: iload_3
    //   381: iconst_m1
    //   382: if_icmpeq +13 -> 395
    //   385: aload_1
    //   386: aload_2
    //   387: iconst_0
    //   388: iload_3
    //   389: invokevirtual 437	java/io/FileOutputStream:write	([BII)V
    //   392: goto -19 -> 373
    //   395: aload 6
    //   397: ifnull +11 -> 408
    //   400: aload 6
    //   402: invokevirtual 416	java/io/InputStream:close	()V
    //   405: goto +3 -> 408
    //   408: aload_1
    //   409: ifnull +13 -> 422
    //   412: aload_1
    //   413: invokevirtual 438	java/io/FileOutputStream:close	()V
    //   416: return
    //   417: aload_1
    //   418: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   421: return
    //   422: return
    //   423: astore_2
    //   424: aload_1
    //   425: astore 7
    //   427: aload_2
    //   428: astore_1
    //   429: goto +14 -> 443
    //   432: astore_2
    //   433: aload_1
    //   434: astore 7
    //   436: goto +24 -> 460
    //   439: astore_1
    //   440: aconst_null
    //   441: astore 7
    //   443: aload 6
    //   445: astore_2
    //   446: aload 7
    //   448: astore 6
    //   450: aload_1
    //   451: astore 7
    //   453: goto +71 -> 524
    //   456: astore_2
    //   457: aconst_null
    //   458: astore 7
    //   460: aload 6
    //   462: astore_1
    //   463: aload 7
    //   465: astore 6
    //   467: goto +21 -> 488
    //   470: astore 7
    //   472: aconst_null
    //   473: astore 6
    //   475: aload 8
    //   477: astore_2
    //   478: goto +46 -> 524
    //   481: astore_2
    //   482: aconst_null
    //   483: astore 6
    //   485: aload 7
    //   487: astore_1
    //   488: aload_2
    //   489: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   492: aload_1
    //   493: ifnull +10 -> 503
    //   496: aload_1
    //   497: invokevirtual 416	java/io/InputStream:close	()V
    //   500: goto +3 -> 503
    //   503: aload 6
    //   505: ifnull +14 -> 519
    //   508: aload 6
    //   510: invokevirtual 438	java/io/FileOutputStream:close	()V
    //   513: return
    //   514: aload_1
    //   515: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   518: return
    //   519: return
    //   520: astore 7
    //   522: aload_1
    //   523: astore_2
    //   524: aload_2
    //   525: ifnull +10 -> 535
    //   528: aload_2
    //   529: invokevirtual 416	java/io/InputStream:close	()V
    //   532: goto +3 -> 535
    //   535: aload 6
    //   537: ifnull +15 -> 552
    //   540: aload 6
    //   542: invokevirtual 438	java/io/FileOutputStream:close	()V
    //   545: goto +7 -> 552
    //   548: aload_1
    //   549: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   552: aload 7
    //   554: athrow
    //   555: aconst_null
    //   556: astore_1
    //   557: goto -162 -> 395
    //   560: astore_1
    //   561: goto -144 -> 417
    //   564: astore_1
    //   565: goto -51 -> 514
    //   568: astore_1
    //   569: goto -21 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	yj
    //   0	572	1	paramString1	String
    //   0	572	2	paramString2	String
    //   116	273	3	i1	int
    //   113	8	4	i2	int
    //   289	3	5	bool	boolean
    //   7	534	6	localObject1	Object
    //   1	463	7	localObject2	Object
    //   470	16	7	localObject3	Object
    //   520	33	7	localObject4	Object
    //   4	472	8	localStringBuilder	StringBuilder
    //   23	101	9	arrayOfString	String[]
    //   38	119	10	localObject5	Object
    //   79	84	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   301	306	307	java/lang/Exception
    //   323	373	423	finally
    //   373	380	423	finally
    //   385	392	423	finally
    //   323	373	432	java/lang/Exception
    //   373	380	432	java/lang/Exception
    //   385	392	432	java/lang/Exception
    //   210	291	439	finally
    //   314	323	439	finally
    //   210	291	456	java/lang/Exception
    //   314	323	456	java/lang/Exception
    //   9	89	470	finally
    //   90	115	470	finally
    //   129	187	470	finally
    //   194	210	470	finally
    //   9	89	481	java/lang/Exception
    //   90	115	481	java/lang/Exception
    //   129	187	481	java/lang/Exception
    //   194	210	481	java/lang/Exception
    //   488	492	520	finally
    //   400	405	560	java/lang/Exception
    //   412	416	560	java/lang/Exception
    //   496	500	564	java/lang/Exception
    //   508	513	564	java/lang/Exception
    //   528	532	568	java/lang/Exception
    //   540	545	568	java/lang/Exception
  }
  
  public final void a()
  {
    this.B = null;
    this.C = null;
    this.w = null;
    try
    {
      if (this.d != null)
      {
        this.d.setPreviewCallback(null);
        this.d.stopPreview();
        this.d.release();
        this.d = null;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      if (this.A != null)
      {
        this.A.b();
        this.A = null;
      }
      FaceDetector.LiveDestroy();
      FaceDetector.IdCardDestroy();
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public final void a(FaceServiceDelegate.FaceDetectErrorCode paramFaceDetectErrorCode)
  {
    if (this.J != null)
    {
      switch (3.a[paramFaceDetectErrorCode.ordinal()])
      {
      default: 
        return;
      case 7: 
        this.J.setText(2131493154);
        if (this.Q == null) {
          return;
        }
        paramFaceDetectErrorCode = this.I;
        if ((paramFaceDetectErrorCode != null) && (!paramFaceDetectErrorCode.getBrightMode()))
        {
          this.Q.setVisibility(0);
          this.Q.bringToFront();
          return;
        }
        break;
      case 6: 
        this.J.setText(2131493153);
        if (this.Q == null) {
          return;
        }
        break;
      case 4: 
      case 5: 
        this.J.setText(2131493149);
        if (this.Q == null) {
          return;
        }
        break;
      case 2: 
      case 3: 
        this.J.setText(2131493294);
      case 1: 
        if ((this.Q == null) || ((goto 173) && (this.Q == null))) {
          return;
        }
        break;
      }
      this.Q.setVisibility(4);
    }
  }
  
  public final void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    this.v = paramBoolean1;
    this.G = paramInt1;
    this.H = paramInt2;
    if (paramBoolean1)
    {
      if (this.E == DetectType.DT_REGISTER)
      {
        if ((this.H == 0) && (paramBoolean2)) {
          sb.a().a(System.currentTimeMillis(), 145);
        }
        switch (this.G)
        {
        default: 
          return;
        case 4: 
          sb.a().a(System.currentTimeMillis(), 147);
          this.l = FaceDetector.LiveAction.ACT_HEAD_SHAKE;
          this.O = this.B.getResources().getString(2131493292);
          return;
        case 3: 
          sb.a().a(System.currentTimeMillis(), 146);
          this.l = FaceDetector.LiveAction.ACT_HEAD_NOD;
          this.O = this.B.getResources().getString(2131493291);
          return;
        case 2: 
          sb.a().a(System.currentTimeMillis(), 148);
          this.l = FaceDetector.LiveAction.ACT_BLINK;
          this.O = this.B.getResources().getString(2131493290);
          return;
        }
        sb.a().a(System.currentTimeMillis(), 149);
        this.l = FaceDetector.LiveAction.ACT_MOUTH_OPEN;
        this.O = this.B.getResources().getString(2131493289);
        return;
      }
      sb.a().a(System.currentTimeMillis(), 150);
      switch (this.G)
      {
      default: 
        return;
      case 6: 
        sb.a().a(System.currentTimeMillis(), 157);
        this.l = FaceDetector.LiveAction.ACT_BLINK;
        this.O = this.B.getResources().getString(2131493290);
        return;
      case 5: 
        sb.a().a(System.currentTimeMillis(), 158);
        this.l = FaceDetector.LiveAction.ACT_MOUTH_OPEN;
        this.O = this.B.getResources().getString(2131493289);
        return;
      case 4: 
        sb.a().a(System.currentTimeMillis(), 154);
        this.m = FaceDetector.LiveDirection.LD_RIGHT;
        this.O = this.B.getResources().getString(2131493298);
        this.j.setDirection(this.m.ordinal());
        return;
      case 3: 
        sb.a().a(System.currentTimeMillis(), 153);
        this.m = FaceDetector.LiveDirection.LD_LEFT;
        this.O = this.B.getResources().getString(2131493297);
        this.j.setDirection(this.m.ordinal());
        return;
      case 2: 
        sb.a().a(System.currentTimeMillis(), 152);
        this.m = FaceDetector.LiveDirection.LD_DOWN;
        this.O = this.B.getResources().getString(2131493296);
        this.j.setDirection(this.m.ordinal());
        return;
      }
      sb.a().a(System.currentTimeMillis(), 151);
      this.m = FaceDetector.LiveDirection.LD_UP;
      this.O = this.B.getResources().getString(2131493295);
      this.j.setDirection(this.m.ordinal());
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Object localObject = this.Q;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    uu.f = (int)(System.currentTimeMillis() - this.s);
    uu.h = paramInt;
    if (this.w == null) {
      return;
    }
    paramArrayOfByte1 = new YuvImage(paramArrayOfByte1, 17, this.e, this.f, null);
    localObject = new ByteArrayOutputStream();
    paramArrayOfByte1.compressToJpeg(new Rect(0, 0, this.e, this.f), 100, (OutputStream)localObject);
    paramArrayOfByte1 = ((ByteArrayOutputStream)localObject).toByteArray();
    paramArrayOfByte1 = BitmapFactory.decodeByteArray(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    localObject = new Matrix();
    ((Matrix)localObject).postRotate(-this.F);
    localObject = Bitmap.createBitmap(paramArrayOfByte1, (int)(paramArrayOfByte1.getWidth() * 0.1F), 0, (int)(paramArrayOfByte1.getWidth() * 0.8F), paramArrayOfByte1.getHeight(), (Matrix)localObject, true);
    paramArrayOfByte1 = new ByteArrayOutputStream();
    ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 100, paramArrayOfByte1);
    localObject = this.w.obtainMessage(0);
    ((Message)localObject).what = 11;
    FaceData localFaceData = new FaceData();
    if (this.H == 0) {
      localFaceData.mOriginDataPath = aai.a(paramArrayOfByte1.toByteArray(), "origindata0");
    } else {
      localFaceData.mOriginDataPath = aai.a(paramArrayOfByte1.toByteArray(), "origindata1");
    }
    localFaceData.mUploadData = paramArrayOfByte2;
    ((Message)localObject).obj = localFaceData;
    ((Message)localObject).sendToTarget();
    this.a = true;
  }
  
  public final void b()
  {
    Object localObject = new Camera.CameraInfo();
    int i2 = Camera.getNumberOfCameras();
    int i1 = 0;
    while (i1 < i2)
    {
      Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject);
      if (((Camera.CameraInfo)localObject).facing == 1) {}
      try
      {
        this.d = Camera.open(i1);
        this.z = 1;
      }
      catch (RuntimeException localRuntimeException1)
      {
        label48:
        StringBuilder localStringBuilder;
        break label48;
      }
      localStringBuilder = new StringBuilder("CameraOpen camera=");
      localStringBuilder.append(this.d);
      xj.c(localStringBuilder.toString());
      i1 += 1;
    }
    if (this.d == null)
    {
      i1 = 0;
      while (i1 < i2)
      {
        Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 0) {}
        try
        {
          this.d = Camera.open(i1);
          this.z = 0;
        }
        catch (RuntimeException localRuntimeException2)
        {
          label127:
          break label127;
        }
        localStringBuilder = new StringBuilder("CameraOpen camera=");
        localStringBuilder.append(this.d);
        xj.c(localStringBuilder.toString());
        i1 += 1;
      }
    }
    else
    {
      if (this.d == null)
      {
        localObject = new StringBuilder("CameraOpen camera=");
        ((StringBuilder)localObject).append(this.d);
        xj.c(((StringBuilder)localObject).toString());
        localObject = this.w.obtainMessage(0);
        ((Message)localObject).what = 2;
        ((Message)localObject).sendToTarget();
      }
      return;
    }
  }
  
  public final void c()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    try
    {
      localObject1 = ((Camera)localObject1).getParameters();
      ((Camera.Parameters)localObject1).setPictureFormat(256);
      ((Camera.Parameters)localObject1).setPreviewFormat(17);
      List localList = ((Camera.Parameters)localObject1).getSupportedPreviewSizes();
      if (this.B.getResources().getConfiguration().orientation != 2)
      {
        ((Camera.Parameters)localObject1).set("orientation", "portrait");
        ((Camera.Parameters)localObject1).set("rotation", 90);
        a(this.C, this.z, this.d);
        if ((xr.a.equals("Nexus 6")) || (xr.a.toLowerCase().startsWith("nexus 6")) || (xr.a.equals("Moto X Pro")) || ((xr.a.toLowerCase().indexOf("nexus6") != -1) && (Build.BRAND.toLowerCase().indexOf("motorola") != -1))) {
          this.d.setDisplayOrientation(270);
        }
        localObject4 = new StringBuilder("S_DISPLAY_ANGLE");
        ((StringBuilder)localObject4).append(n);
        xj.a(((StringBuilder)localObject4).toString());
        i1 = n;
        if (i1 != -1) {
          this.d.setDisplayOrientation(i1);
        }
      }
      else
      {
        ((Camera.Parameters)localObject1).set("orientation", "landscape");
        a(this.C, this.z, this.d);
      }
      Object localObject4 = this.B.getResources().getDisplayMetrics();
      int i2 = ((DisplayMetrics)localObject4).heightPixels;
      int i3 = ((DisplayMetrics)localObject4).widthPixels;
      if (localList == null) {
        return;
      }
      this.e = ((Camera.Size)localList.get(0)).width;
      this.f = ((Camera.Size)localList.get(0)).height;
      int i1 = 1;
      while (i1 < localList.size())
      {
        double d1 = this.e;
        double d2 = this.f;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d2 = d1 / d2;
        d1 = i2;
        double d3 = i3;
        Double.isNaN(d1);
        Double.isNaN(d3);
        d1 /= d3;
        d2 = Math.abs(d2 - d1);
        d3 = ((Camera.Size)localList.get(i1)).width;
        double d4 = ((Camera.Size)localList.get(i1)).height;
        Double.isNaN(d3);
        Double.isNaN(d4);
        d1 = Math.abs(d3 / d4 - d1);
        if ((d2 > d1) && (((Camera.Size)localList.get(i1)).width <= i2) && (((Camera.Size)localList.get(i1)).height <= i3) && (((Camera.Size)localList.get(i1)).width <= 1280) && (((Camera.Size)localList.get(i1)).height <= 768))
        {
          this.e = ((Camera.Size)localList.get(i1)).width;
          this.f = ((Camera.Size)localList.get(i1)).height;
        }
        if ((d2 == d1) && (((Camera.Size)localList.get(i1)).width <= i2) && (((Camera.Size)localList.get(i1)).height <= i3) && (((Camera.Size)localList.get(i1)).width <= 1280) && (((Camera.Size)localList.get(i1)).height <= 768) && (this.e < ((Camera.Size)localList.get(i1)).width))
        {
          this.e = ((Camera.Size)localList.get(i1)).width;
          this.f = ((Camera.Size)localList.get(i1)).height;
        }
        i1 += 1;
      }
      ((Camera.Parameters)localObject1).setPreviewSize(this.e, this.f);
      this.d.setParameters((Camera.Parameters)localObject1);
      this.d.setPreviewCallback(this);
      try
      {
        this.d.setPreviewDisplay(this.D);
        this.d.startPreview();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localObject3 = this.d;
        if (localObject3 != null)
        {
          ((Camera)localObject3).setPreviewCallback(null);
          this.d.release();
          this.d = null;
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.f);
      ((StringBuilder)localObject3).append("*");
      ((StringBuilder)localObject3).append(this.e);
      uu.d = ((StringBuilder)localObject3).toString();
      localObject3 = this.x;
      localObject3[0] = 0;
      localObject3[1] = ((int)(FaceView.k * this.e));
      this.x[2] = this.f;
      float f1 = FaceView.m;
      i1 = this.e;
      f1 *= i1;
      localObject3 = this.x;
      localObject3[3] = ((int)(1.4F * f1));
      localObject3[1] = ((int)(localObject3[1] - f1 * 0.2F));
      if ((localObject3[3] >= i1) || (localObject3[1] < 0))
      {
        localObject3 = this.x;
        localObject3[1] = 0;
        localObject3[3] = this.e;
      }
      localObject3 = ((Camera.Parameters)localObject1).get("rotation");
      localObject4 = xr.a;
      if ((!((String)localObject4).startsWith("8150")) && (this.z != 0) && (!((String)localObject4).equals("Nexus 6")) && (!((String)localObject4).equals("Nexus 6P")) && ((xr.a.toLowerCase().indexOf("nexus6") == -1) || (Build.BRAND.toLowerCase().indexOf("motorola") == -1)))
      {
        localObject1 = localObject3;
        if (localObject3 != null) {
          if (!((String)localObject4).contains("MI 5"))
          {
            localObject1 = localObject3;
            if (this.e > this.f)
            {
              localObject1 = localObject3;
              if (Integer.valueOf((String)localObject3).intValue() >= 90) {}
            }
          }
          else
          {
            localObject1 = "90";
          }
        }
      }
      else
      {
        localObject1 = "270";
      }
      this.F = Integer.parseInt((String)localObject1);
      i1 = o;
      if (i1 != -1) {
        this.F = i1;
      }
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      Object localObject2 = new StringBuilder("Camera getParameters failed");
      ((StringBuilder)localObject2).append(this.d);
      xj.c(((StringBuilder)localObject2).toString());
      localObject2 = this.w.obtainMessage(0);
      ((Message)localObject2).what = 2;
      ((Message)localObject2).sendToTarget();
    }
  }
  
  protected final Object clone()
  {
    return super.clone();
  }
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.a) {
      return;
    }
    if (this.c == 0L)
    {
      this.c = System.currentTimeMillis();
      return;
    }
    boolean bool = this.M;
    if (bool) {
      return;
    }
    if ((this.A == null) && (!bool)) {
      new Thread(new Runnable()
      {
        public final void run()
        {
          synchronized (yj.this.g)
          {
            if (yj.a(yj.this) == null)
            {
              yj.a(yj.this, true);
              long l = System.currentTimeMillis();
              yj.b(yj.this);
              uu.g = (int)(System.currentTimeMillis() - l);
              yj.a(yj.this, new rn(yj.c(yj.this), yj.this, yj.d(yj.this)));
              FaceThreshold localFaceThreshold = new FaceThreshold();
              yj.a(localFaceThreshold);
              StringBuilder localStringBuilder = new StringBuilder("validateLightHigh");
              localStringBuilder.append(localFaceThreshold.validateLightHigh());
              xj.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder("validateLightLow");
              localStringBuilder.append(localFaceThreshold.validateLightLow());
              xj.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder("registerLightLow");
              localStringBuilder.append(localFaceThreshold.registerLightLow());
              xj.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder("registerLightHigh");
              localStringBuilder.append(localFaceThreshold.registerLightHigh());
              xj.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder("faceDisparity");
              localStringBuilder.append(localFaceThreshold.faceDisparity());
              xj.a(localStringBuilder.toString());
              yj.a(yj.this).a = localFaceThreshold;
              yj.a(yj.this, false);
            }
            return;
          }
        }
      }).start();
    }
    if (this.M) {
      return;
    }
    if ((this.d != null) && (this.A != null) && (!this.q))
    {
      xj.b("onPreviewFramestart");
      this.q = true;
      this.A.a();
    }
    if (this.b)
    {
      if (System.currentTimeMillis() - this.c < this.u) {
        return;
      }
      this.s = System.currentTimeMillis();
      this.P += 1;
      if (this.P % 3 != 0) {
        return;
      }
      if (paramCamera == null) {}
    }
    try
    {
      Object localObject = paramCamera.getParameters();
      localObject = new rq(paramArrayOfByte, ((Camera.Parameters)localObject).getPreviewSize().width, ((Camera.Parameters)localObject).getPreviewSize().height, this.F, this.x, this.y);
      this.A.a((rq)localObject, this.E);
    }
    catch (Exception localException)
    {
      break label235;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label229:
      break label229;
    }
    xj.c("OutOfMemoryError:doFaceDetect");
    label235:
    uu.h += 1;
    if (this.v)
    {
      bool = this.N;
      if (bool) {
        return;
      }
      if ((!this.r) && (!bool))
      {
        this.N = true;
        new Thread(new Runnable()
        {
          public final void run()
          {
            synchronized (yj.this.h)
            {
              if (!yj.this.r)
              {
                long l = System.currentTimeMillis();
                Object localObject2 = new LiveThreshold();
                yj.a(yj.this, (LiveThreshold)localObject2);
                StringBuilder localStringBuilder = new StringBuilder("shakeAngle");
                localStringBuilder.append(((LiveThreshold)localObject2).shakeAngle());
                xj.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder("nodAngle");
                localStringBuilder.append(((LiveThreshold)localObject2).nodAngle());
                xj.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder("mouthOpenScore");
                localStringBuilder.append(((LiveThreshold)localObject2).mouthOpenScore());
                xj.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder("blinkScore");
                localStringBuilder.append(((LiveThreshold)localObject2).blinkScore());
                xj.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder("downAngle");
                localStringBuilder.append(((LiveThreshold)localObject2).downAngle());
                xj.a(localStringBuilder.toString());
                yj.this.p = FaceDetector.LiveDetectInitial(yj.e(yj.this), (LiveThreshold)localObject2);
                uu.i = (int)(System.currentTimeMillis() - l);
                if (yj.this.p)
                {
                  yj.a(yj.this, System.currentTimeMillis());
                  yj.f(yj.this);
                  yj.this.r = true;
                }
                localObject2 = new StringBuilder("LiveDetectInitial,ret=");
                ((StringBuilder)localObject2).append(yj.this.p);
                ((StringBuilder)localObject2).append(",livemodelfile=");
                ((StringBuilder)localObject2).append(yj.e(yj.this));
                xj.c(((StringBuilder)localObject2).toString());
                localObject2 = new StringBuilder("LiveDetectInitial,ret=");
                ((StringBuilder)localObject2).append(yj.this.p);
                ((StringBuilder)localObject2).append(",livemodelfile=");
                ((StringBuilder)localObject2).append(yj.e(yj.this));
                xj.a(((StringBuilder)localObject2).toString());
              }
              return;
            }
          }
        }).start();
      }
      if (this.N) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        this.P += 1;
        if (this.P % 2 != 0) {
          return;
        }
        int i1;
        int i2;
        if (this.E == DetectType.DT_REGISTER)
        {
          if (this.H == 0) {
            uu.l += 1;
          } else {
            uu.m += 1;
          }
          paramCamera = paramCamera.getParameters();
          i1 = paramCamera.getPreviewSize().width;
          i2 = paramCamera.getPreviewSize().height;
          this.i.reset();
          i1 = FaceDetector.LiveActionDetect(this.i, paramArrayOfByte, i1, i2, this.F, this.l);
          paramArrayOfByte = new StringBuilder("regregret: ");
          paramArrayOfByte.append(i1);
          paramArrayOfByte.append(", x=");
          paramArrayOfByte.append(this.i.x());
          paramArrayOfByte.append(",y=");
          paramArrayOfByte.append(this.i.y());
          paramArrayOfByte.append(",width=");
          paramArrayOfByte.append(this.i.width());
          paramArrayOfByte.append(",height=");
          paramArrayOfByte.append(this.i.height());
          paramArrayOfByte.append(",action=");
          paramArrayOfByte.append(this.l);
          xj.a(paramArrayOfByte.toString());
        }
        switch (i1)
        {
        case 6: 
          if ((this.J == null) || (this.J.getText().toString().equals(this.O))) {
            break;
          }
          this.J.setText(this.O);
          return;
        case 5: 
          if (this.J == null) {
            break;
          }
          this.J.setText(2131493149);
          return;
        case 4: 
          if (this.J == null) {
            break;
          }
          this.J.setText(2131493152);
          return;
        case 3: 
          if (this.J == null) {
            break;
          }
          this.J.setText(2131493151);
          return;
        case 2: 
          if ((this.l != FaceDetector.LiveAction.ACT_MOUTH_OPEN) && (this.l != FaceDetector.LiveAction.ACT_BLINK)) {
            break;
          }
          if ((this.I != null) && (this.i.x() > 0) && (this.i.y() > 0) && (this.i.width() > 0) && (this.i.height() > 0)) {
            this.I.a(this.i, this.f, this.e);
          }
          if ((this.J == null) || (this.J.getText().toString().equals(this.O))) {
            break;
          }
          this.J.setText(this.O);
          return;
        case 1: 
          paramArrayOfByte = this.w.obtainMessage(0);
          paramArrayOfByte.what = 73;
          paramArrayOfByte.sendToTarget();
          this.a = true;
          return;
        case 0: 
          long l1 = System.currentTimeMillis();
          if (this.H == 0)
          {
            uu.j = (int)(l1 - this.t);
          }
          else
          {
            sb.a().a(System.currentTimeMillis(), 135);
            uu.k = (int)(l1 - this.t);
          }
          switch (this.G)
          {
          case 4: 
            sb.a().a(l1, 137);
            break;
          case 3: 
            sb.a().a(l1, 136);
            break;
          case 2: 
            sb.a().a(l1, 138);
            break;
          case 1: 
            sb.a().a(l1, 139);
            if (((this.l == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.l == FaceDetector.LiveAction.ACT_BLINK)) && (this.I != null) && (this.i.x() > 0) && (this.i.y() > 0) && (this.i.width() > 0) && (this.i.height() > 0)) {
              this.I.a(this.i, this.f, this.e);
            }
            paramArrayOfByte = this.w.obtainMessage(0);
            paramArrayOfByte.what = 71;
            paramArrayOfByte.sendToTarget();
            this.a = true;
            return;
            uu.o += 1;
            paramCamera = paramCamera.getParameters();
            i1 = paramCamera.getPreviewSize().width;
            i2 = paramCamera.getPreviewSize().height;
            if (this.G <= 4)
            {
              i1 = FaceDetector.LiveDirectionDetect(this.j, paramArrayOfByte, i1, i2, this.F);
            }
            else
            {
              this.i.reset();
              i1 = FaceDetector.LiveActionDetect(this.i, paramArrayOfByte, i1, i2, this.F, this.l);
            }
            xj.a("ret:".concat(String.valueOf(i1)));
            switch (i1)
            {
            case 6: 
              if ((this.J != null) && (!this.J.getText().toString().equals(this.O))) {
                this.J.setText(this.O);
              }
              break;
            case 5: 
              if (this.J != null) {
                this.J.setText(2131493149);
              }
              break;
            case 4: 
              if (this.J != null) {
                this.J.setText(2131493152);
              }
              break;
            case 3: 
              if (this.J != null) {
                this.J.setText(2131493151);
              }
              break;
            case 2: 
              if ((this.l == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.l == FaceDetector.LiveAction.ACT_BLINK))
              {
                paramArrayOfByte = new StringBuilder("regregret: ");
                paramArrayOfByte.append(i1);
                paramArrayOfByte.append(", x=");
                paramArrayOfByte.append(this.i.x());
                paramArrayOfByte.append(",y=");
                paramArrayOfByte.append(this.i.y());
                paramArrayOfByte.append(",width=");
                paramArrayOfByte.append(this.i.width());
                paramArrayOfByte.append(",height=");
                paramArrayOfByte.append(this.i.height());
                paramArrayOfByte.append(",action=");
                paramArrayOfByte.append(this.l);
                xj.a(paramArrayOfByte.toString());
                if ((this.I != null) && (this.i.x() > 0) && (this.i.y() > 0) && (this.i.width() > 0) && (this.i.height() > 0)) {
                  this.I.a(this.i, this.f, this.e);
                }
                if ((this.J != null) && (!this.J.getText().toString().equals(this.O))) {
                  this.J.setText(this.O);
                }
              }
              break;
            case 1: 
              paramArrayOfByte = this.w.obtainMessage(0);
              paramArrayOfByte.what = 73;
              paramArrayOfByte.sendToTarget();
              this.a = true;
              break;
            case 0: 
              l1 = System.currentTimeMillis();
              sb.a().a(l1, 140);
              uu.n = (int)(l1 - this.t);
              switch (this.G)
              {
              case 6: 
                sb.a().a(l1, 156);
                break;
              case 5: 
                sb.a().a(l1, 155);
                break;
              case 4: 
                sb.a().a(l1, 144);
                break;
              case 3: 
                sb.a().a(l1, 143);
                break;
              case 2: 
                sb.a().a(l1, 142);
                break;
              case 1: 
                sb.a().a(l1, 141);
                if (((this.l == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.l == FaceDetector.LiveAction.ACT_BLINK)) && (this.I != null) && (this.i.x() > 0) && (this.i.y() > 0) && (this.i.width() > 0) && (this.i.height() > 0)) {
                  this.I.a(this.i, this.f, this.e);
                }
                paramArrayOfByte = this.w.obtainMessage(0);
                paramArrayOfByte.what = 71;
                paramArrayOfByte.obj = Double.valueOf(this.j.angle());
                paramArrayOfByte.sendToTarget();
                this.a = true;
                paramArrayOfByte = this.I;
                paramArrayOfByte.h = paramArrayOfByte.f;
                paramArrayOfByte.i = paramArrayOfByte.g;
                if (i1 != 0)
                {
                  double d1;
                  if ((this.m != FaceDetector.LiveDirection.LD_UP) && (this.m != FaceDetector.LiveDirection.LD_LEFT))
                  {
                    if ((this.m == FaceDetector.LiveDirection.LD_DOWN) || (this.m == FaceDetector.LiveDirection.LD_RIGHT))
                    {
                      d1 = this.j.angle();
                      if ((d1 > 0.0D) && (d1 < k) && (this.I != null)) {
                        this.I.setVryMoveDistance(Double.valueOf(d1).intValue());
                      }
                    }
                  }
                  else
                  {
                    d1 = this.j.angle();
                    if ((d1 < 0.0D) && (d1 > -k) && (this.I != null)) {
                      this.I.setVryMoveDistance(-Double.valueOf(d1).intValue());
                    }
                    return;
                  }
                }
                return;
              }
            }
          }
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        continue;
        return;
      }
      xj.c("OutOfMemoryError:doLiveDetect");
      return;
      continue;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yj
 * JD-Core Version:    0.7.0.1
 */