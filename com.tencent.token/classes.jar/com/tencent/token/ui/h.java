package com.tencent.token.ui;

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
import com.tencent.token.bv;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public class h
  implements Camera.PreviewCallback, FaceServiceDelegate
{
  public static int h = 21;
  public static int k = ;
  public static int l = m.u();
  private com.tencent.service.e A;
  private Context B = RqdApplication.n();
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
  public Camera a;
  public int b;
  public int c;
  Object d = new Object();
  Object e = new Object();
  LiveRectInfo f = new LiveRectInfo();
  DirectionInfo g = new DirectionInfo();
  FaceDetector.LiveAction i = FaceDetector.LiveAction.ACT_BLINK;
  FaceDetector.LiveDirection j = FaceDetector.LiveDirection.LD_UP;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  private long p = 0L;
  private long q = 0L;
  private long r = 2000L;
  private boolean s = false;
  private boolean t = true;
  private boolean u = false;
  private long v;
  private Handler w;
  private int[] x = new int[4];
  private float[] y;
  private int z;
  
  public h(Context paramContext, SurfaceHolder paramSurfaceHolder, Handler paramHandler, int paramInt1, int paramInt2, FaceView paramFaceView, TextView paramTextView, View paramView)
  {
    h = m.s();
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
    paramContext = m.h();
    this.y = new float[3];
    this.y[0] = paramContext.mRegRayThres;
    this.y[1] = paramContext.mVerifyRayThres;
    this.y[2] = paramContext.mDisparityThres;
    this.I = paramFaceView;
    this.P = 0;
    this.Q = paramView;
  }
  
  public static void a(Activity paramActivity, int paramInt, Camera paramCamera)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    paramInt = 90;
    if (paramActivity == null)
    {
      if (RqdApplication.n().getResources().getConfiguration().orientation != 2)
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
  
  private void a(FaceThreshold paramFaceThreshold)
  {
    Object localObject1 = m.q();
    Object localObject3 = null;
    if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
      localObject1 = ((String)localObject1).split("\\|");
    } else {
      localObject1 = null;
    }
    String str = m.r();
    Object localObject2 = localObject3;
    if (str != null)
    {
      localObject2 = localObject3;
      if (!str.isEmpty()) {
        localObject2 = str.split("\\|");
      }
    }
    if ((localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (localObject2.length > 0))
    {
      int i1 = 0;
      while (i1 < localObject1.length)
      {
        if (!localObject1[i1].isEmpty()) {
          switch (Integer.parseInt(localObject1[i1]))
          {
          default: 
            break;
          case 5: 
            paramFaceThreshold.setFaceDisparity(Float.parseFloat(localObject2[i1]));
            break;
          case 4: 
            paramFaceThreshold.setValidateLightLow(Float.parseFloat(localObject2[i1]));
            break;
          case 3: 
            paramFaceThreshold.setValidateLightHigh(Float.parseFloat(localObject2[i1]));
            break;
          case 2: 
            paramFaceThreshold.setRegisterLightLow(Float.parseFloat(localObject2[i1]));
            break;
          case 1: 
            paramFaceThreshold.setRegisterLightHigh(Float.parseFloat(localObject2[i1]));
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void a(LiveThreshold paramLiveThreshold)
  {
    Object localObject1 = m.q();
    DetectType localDetectType = null;
    if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
      localObject1 = ((String)localObject1).split("\\|");
    } else {
      localObject1 = null;
    }
    Object localObject3 = m.r();
    Object localObject2 = localDetectType;
    if (localObject3 != null)
    {
      localObject2 = localDetectType;
      if (!((String)localObject3).isEmpty()) {
        localObject2 = ((String)localObject3).split("\\|");
      }
    }
    if ((localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (localObject2.length > 0))
    {
      localDetectType = this.E;
      localObject3 = DetectType.DT_REGISTER;
      int i1 = 0;
      int i2 = 0;
      if (localDetectType == localObject3)
      {
        i1 = i2;
        while (i1 < localObject1.length)
        {
          if (!localObject1[i1].isEmpty()) {
            switch (Integer.parseInt(localObject1[i1]))
            {
            default: 
              break;
            case 10: 
              paramLiveThreshold.setLeftAngle(Double.parseDouble(localObject2[i1]));
              paramLiveThreshold.setRightAngle(Double.parseDouble(localObject2[i1]));
              paramLiveThreshold.setUpAngle(Double.parseDouble(localObject2[i1]));
              paramLiveThreshold.setDownAngle(Double.parseDouble(localObject2[i1]));
              break;
            case 9: 
              paramLiveThreshold.setShakeAngle(Double.parseDouble(localObject2[i1]));
              break;
            case 8: 
              paramLiveThreshold.setNodAngle(Double.parseDouble(localObject2[i1]));
              break;
            case 7: 
              paramLiveThreshold.setMouthOpenScore(Double.parseDouble(localObject2[i1]));
              break;
            case 6: 
              paramLiveThreshold.setBlinkScore(Double.parseDouble(localObject2[i1]));
            }
          }
          i1 += 1;
        }
      }
      while (i1 < localObject1.length)
      {
        if (!localObject1[i1].isEmpty()) {
          switch (Integer.parseInt(localObject1[i1]))
          {
          default: 
            break;
          case 15: 
            paramLiveThreshold.setLeftAngle(Double.parseDouble(localObject2[i1]));
            paramLiveThreshold.setRightAngle(Double.parseDouble(localObject2[i1]));
            paramLiveThreshold.setUpAngle(Double.parseDouble(localObject2[i1]));
            paramLiveThreshold.setDownAngle(Double.parseDouble(localObject2[i1]));
            break;
          case 14: 
            paramLiveThreshold.setShakeAngle(Double.parseDouble(localObject2[i1]));
            break;
          case 13: 
            paramLiveThreshold.setNodAngle(Double.parseDouble(localObject2[i1]));
            break;
          case 12: 
            paramLiveThreshold.setMouthOpenScore(Double.parseDouble(localObject2[i1]));
            break;
          case 11: 
            paramLiveThreshold.setBlinkScore(Double.parseDouble(localObject2[i1]));
          }
        }
        i1 += 1;
      }
    }
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
    //   10: getfield 118	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   13: invokevirtual 221	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   16: invokevirtual 350	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   19: aload_2
    //   20: invokevirtual 355	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 9
    //   25: aload 9
    //   27: arraylength
    //   28: ifle +186 -> 214
    //   31: new 357	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   38: astore 10
    //   40: aload 10
    //   42: aload_1
    //   43: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 10
    //   49: getstatic 367	java/io/File:separator	Ljava/lang/String;
    //   52: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 10
    //   58: aload_2
    //   59: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 10
    //   65: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 10
    //   70: new 364	java/io/File
    //   73: dup
    //   74: aload 10
    //   76: invokespecial 373	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 11
    //   81: aload 11
    //   83: invokevirtual 376	java/io/File:exists	()Z
    //   86: ifeq +4 -> 90
    //   89: return
    //   90: aload 11
    //   92: invokevirtual 379	java/io/File:mkdirs	()Z
    //   95: pop
    //   96: new 357	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   103: astore 11
    //   105: aload 11
    //   107: ldc_w 381
    //   110: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 11
    //   116: aload 10
    //   118: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 11
    //   124: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 385	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   130: aload 9
    //   132: arraylength
    //   133: istore 4
    //   135: iconst_0
    //   136: istore_3
    //   137: iload_3
    //   138: iload 4
    //   140: if_icmpge +430 -> 570
    //   143: aload 9
    //   145: iload_3
    //   146: aaload
    //   147: astore 10
    //   149: new 357	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   156: astore 11
    //   158: aload 11
    //   160: aload_2
    //   161: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 11
    //   167: getstatic 367	java/io/File:separator	Ljava/lang/String;
    //   170: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 11
    //   176: aload 10
    //   178: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 11
    //   184: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore_2
    //   188: aload_0
    //   189: aload_1
    //   190: aload_2
    //   191: invokespecial 387	com/tencent/token/ui/h:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_2
    //   195: iconst_0
    //   196: aload_2
    //   197: getstatic 390	java/io/File:separatorChar	C
    //   200: invokevirtual 394	java/lang/String:lastIndexOf	(I)I
    //   203: invokevirtual 398	java/lang/String:substring	(II)Ljava/lang/String;
    //   206: astore_2
    //   207: iload_3
    //   208: iconst_1
    //   209: iadd
    //   210: istore_3
    //   211: goto -74 -> 137
    //   214: aload_0
    //   215: getfield 118	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   218: invokevirtual 221	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   221: invokevirtual 350	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   224: aload_2
    //   225: invokevirtual 402	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   228: astore 6
    //   230: new 357	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   237: astore 7
    //   239: aload 7
    //   241: aload_1
    //   242: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 7
    //   248: getstatic 367	java/io/File:separator	Ljava/lang/String;
    //   251: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 7
    //   257: aload_2
    //   258: iconst_0
    //   259: aload_2
    //   260: getstatic 367	java/io/File:separator	Ljava/lang/String;
    //   263: invokevirtual 404	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   266: invokevirtual 398	java/lang/String:substring	(II)Ljava/lang/String;
    //   269: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 7
    //   275: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore 7
    //   280: aload_2
    //   281: aload_2
    //   282: getstatic 390	java/io/File:separatorChar	C
    //   285: invokevirtual 394	java/lang/String:lastIndexOf	(I)I
    //   288: iconst_1
    //   289: iadd
    //   290: invokevirtual 407	java/lang/String:substring	(I)Ljava/lang/String;
    //   293: astore_2
    //   294: new 364	java/io/File
    //   297: dup
    //   298: aload 7
    //   300: aload_2
    //   301: invokespecial 409	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 376	java/io/File:exists	()Z
    //   309: istore 5
    //   311: iload 5
    //   313: ifeq +20 -> 333
    //   316: aload 6
    //   318: ifnull +14 -> 332
    //   321: aload 6
    //   323: invokevirtual 414	java/io/InputStream:close	()V
    //   326: return
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   332: return
    //   333: new 419	java/io/FileOutputStream
    //   336: dup
    //   337: aload_1
    //   338: invokespecial 422	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   341: astore_1
    //   342: new 357	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   349: astore 8
    //   351: aload 8
    //   353: ldc_w 424
    //   356: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 8
    //   362: aload 7
    //   364: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 8
    //   370: ldc_w 426
    //   373: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 8
    //   379: aload_2
    //   380: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 8
    //   386: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 385	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   392: sipush 1024
    //   395: newarray byte
    //   397: astore_2
    //   398: aload 6
    //   400: aload_2
    //   401: invokevirtual 430	java/io/InputStream:read	([B)I
    //   404: istore_3
    //   405: iload_3
    //   406: iconst_m1
    //   407: if_icmpne +22 -> 429
    //   410: aload 6
    //   412: ifnull +8 -> 420
    //   415: aload 6
    //   417: invokevirtual 414	java/io/InputStream:close	()V
    //   420: aload_1
    //   421: ifnull +113 -> 534
    //   424: aload_1
    //   425: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   428: return
    //   429: aload_1
    //   430: aload_2
    //   431: iconst_0
    //   432: iload_3
    //   433: invokevirtual 435	java/io/FileOutputStream:write	([BII)V
    //   436: goto -38 -> 398
    //   439: astore_2
    //   440: aload_1
    //   441: astore 7
    //   443: aload_2
    //   444: astore_1
    //   445: goto +14 -> 459
    //   448: astore_2
    //   449: aload_1
    //   450: astore 7
    //   452: goto +24 -> 476
    //   455: astore_1
    //   456: aconst_null
    //   457: astore 7
    //   459: aload 6
    //   461: astore_2
    //   462: aload 7
    //   464: astore 6
    //   466: aload_1
    //   467: astore 7
    //   469: goto +70 -> 539
    //   472: astore_2
    //   473: aconst_null
    //   474: astore 7
    //   476: aload 6
    //   478: astore_1
    //   479: aload 7
    //   481: astore 6
    //   483: goto +21 -> 504
    //   486: astore 7
    //   488: aconst_null
    //   489: astore 6
    //   491: aload 8
    //   493: astore_2
    //   494: goto +45 -> 539
    //   497: astore_2
    //   498: aconst_null
    //   499: astore 6
    //   501: aload 7
    //   503: astore_1
    //   504: aload_2
    //   505: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   508: aload_1
    //   509: ifnull +10 -> 519
    //   512: aload_1
    //   513: invokevirtual 414	java/io/InputStream:close	()V
    //   516: goto +3 -> 519
    //   519: aload 6
    //   521: ifnull +13 -> 534
    //   524: aload 6
    //   526: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   529: return
    //   530: aload_1
    //   531: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   534: return
    //   535: astore 7
    //   537: aload_1
    //   538: astore_2
    //   539: aload_2
    //   540: ifnull +10 -> 550
    //   543: aload_2
    //   544: invokevirtual 414	java/io/InputStream:close	()V
    //   547: goto +3 -> 550
    //   550: aload 6
    //   552: ifnull +15 -> 567
    //   555: aload 6
    //   557: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   560: goto +7 -> 567
    //   563: aload_1
    //   564: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   567: aload 7
    //   569: athrow
    //   570: aconst_null
    //   571: astore_1
    //   572: goto -162 -> 410
    //   575: astore_1
    //   576: goto -46 -> 530
    //   579: astore_1
    //   580: goto -17 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	h
    //   0	583	1	paramString1	String
    //   0	583	2	paramString2	String
    //   136	297	3	i1	int
    //   133	8	4	i2	int
    //   309	3	5	bool	boolean
    //   7	549	6	localObject1	Object
    //   1	479	7	localObject2	Object
    //   486	16	7	localObject3	Object
    //   535	33	7	localObject4	Object
    //   4	488	8	localStringBuilder	StringBuilder
    //   23	121	9	arrayOfString	String[]
    //   38	139	10	localObject5	Object
    //   79	104	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   321	326	327	java/lang/Exception
    //   342	398	439	finally
    //   398	405	439	finally
    //   429	436	439	finally
    //   342	398	448	java/lang/Exception
    //   398	405	448	java/lang/Exception
    //   429	436	448	java/lang/Exception
    //   230	311	455	finally
    //   333	342	455	finally
    //   230	311	472	java/lang/Exception
    //   333	342	472	java/lang/Exception
    //   9	89	486	finally
    //   90	135	486	finally
    //   149	207	486	finally
    //   214	230	486	finally
    //   9	89	497	java/lang/Exception
    //   90	135	497	java/lang/Exception
    //   149	207	497	java/lang/Exception
    //   214	230	497	java/lang/Exception
    //   504	508	535	finally
    //   415	420	575	java/lang/Exception
    //   424	428	575	java/lang/Exception
    //   512	516	575	java/lang/Exception
    //   524	529	575	java/lang/Exception
    //   543	547	579	java/lang/Exception
    //   555	560	579	java/lang/Exception
  }
  
  private void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramCamera != null) {}
    try
    {
      paramCamera = paramCamera.getParameters();
      paramArrayOfByte = new com.tencent.service.h(paramArrayOfByte, paramCamera.getPreviewSize().width, paramCamera.getPreviewSize().height, this.F, this.x, this.y);
      this.A.a(paramArrayOfByte, this.E);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label57:
      break label57;
    }
    g.c("OutOfMemoryError:doFaceDetect");
  }
  
  private void b(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.H == 0) {
      ProtoFaceCommon.l += 1;
    } else {
      ProtoFaceCommon.m += 1;
    }
    paramCamera = paramCamera.getParameters();
    int i1 = paramCamera.getPreviewSize().width;
    int i2 = paramCamera.getPreviewSize().height;
    this.f.reset();
    i1 = FaceDetector.LiveActionDetect(this.f, paramArrayOfByte, i1, i2, this.F, this.i);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("regregret: ");
    paramArrayOfByte.append(i1);
    paramArrayOfByte.append(", x=");
    paramArrayOfByte.append(this.f.x());
    paramArrayOfByte.append(",y=");
    paramArrayOfByte.append(this.f.y());
    paramArrayOfByte.append(",width=");
    paramArrayOfByte.append(this.f.width());
    paramArrayOfByte.append(",height=");
    paramArrayOfByte.append(this.f.height());
    paramArrayOfByte.append(",action=");
    paramArrayOfByte.append(this.i);
    g.a(paramArrayOfByte.toString());
    switch (i1)
    {
    default: 
    case 6: 
      paramArrayOfByte = this.J;
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.getText().toString().equals(this.O)))
      {
        this.J.setText(this.O);
        return;
      }
      break;
    case 5: 
      paramArrayOfByte = this.J;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.setText(2131493149);
        return;
      }
      break;
    case 4: 
      paramArrayOfByte = this.J;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.setText(2131493152);
        return;
      }
      break;
    case 3: 
      paramArrayOfByte = this.J;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.setText(2131493151);
        return;
      }
      break;
    case 2: 
      if ((this.i == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.i == FaceDetector.LiveAction.ACT_BLINK))
      {
        if ((this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
          this.I.a(this.f, this.c, this.b);
        }
        paramArrayOfByte = this.J;
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.getText().toString().equals(this.O)))
        {
          this.J.setText(this.O);
          return;
        }
      }
      break;
    case 1: 
      paramArrayOfByte = this.w.obtainMessage(0);
      paramArrayOfByte.what = 73;
      paramArrayOfByte.sendToTarget();
      this.s = true;
      return;
    case 0: 
      long l1 = System.currentTimeMillis();
      if (this.H == 0)
      {
        ProtoFaceCommon.j = (int)(l1 - this.q);
      }
      else
      {
        bv.a().a(System.currentTimeMillis(), 135);
        ProtoFaceCommon.k = (int)(l1 - this.q);
      }
      switch (this.G)
      {
      default: 
        break;
      case 4: 
        bv.a().a(l1, 137);
        break;
      case 3: 
        bv.a().a(l1, 136);
        break;
      case 2: 
        bv.a().a(l1, 138);
        break;
      case 1: 
        bv.a().a(l1, 139);
      }
      if (((this.i == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.i == FaceDetector.LiveAction.ACT_BLINK)) && (this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
        this.I.a(this.f, this.c, this.b);
      }
      paramArrayOfByte = this.w.obtainMessage(0);
      paramArrayOfByte.what = 71;
      paramArrayOfByte.sendToTarget();
      this.s = true;
    }
  }
  
  private void c(byte[] paramArrayOfByte, Camera paramCamera)
  {
    ProtoFaceCommon.o += 1;
    paramCamera = paramCamera.getParameters();
    int i1 = paramCamera.getPreviewSize().width;
    int i2 = paramCamera.getPreviewSize().height;
    if (this.G <= 4)
    {
      i1 = FaceDetector.LiveDirectionDetect(this.g, paramArrayOfByte, i1, i2, this.F);
    }
    else
    {
      this.f.reset();
      i1 = FaceDetector.LiveActionDetect(this.f, paramArrayOfByte, i1, i2, this.F, this.i);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("ret:");
    paramArrayOfByte.append(i1);
    g.a(paramArrayOfByte.toString());
    switch (i1)
    {
    default: 
      break;
    case 6: 
      paramArrayOfByte = this.J;
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.getText().toString().equals(this.O))) {
        this.J.setText(this.O);
      }
      break;
    case 5: 
      paramArrayOfByte = this.J;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.setText(2131493149);
      }
      break;
    case 4: 
      paramArrayOfByte = this.J;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.setText(2131493152);
      }
      break;
    case 3: 
      paramArrayOfByte = this.J;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.setText(2131493151);
      }
      break;
    case 2: 
      if ((this.i == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.i == FaceDetector.LiveAction.ACT_BLINK))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("regregret: ");
        paramArrayOfByte.append(i1);
        paramArrayOfByte.append(", x=");
        paramArrayOfByte.append(this.f.x());
        paramArrayOfByte.append(",y=");
        paramArrayOfByte.append(this.f.y());
        paramArrayOfByte.append(",width=");
        paramArrayOfByte.append(this.f.width());
        paramArrayOfByte.append(",height=");
        paramArrayOfByte.append(this.f.height());
        paramArrayOfByte.append(",action=");
        paramArrayOfByte.append(this.i);
        g.a(paramArrayOfByte.toString());
        if ((this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
          this.I.a(this.f, this.c, this.b);
        }
        paramArrayOfByte = this.J;
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.getText().toString().equals(this.O))) {
          this.J.setText(this.O);
        }
      }
      break;
    case 1: 
      paramArrayOfByte = this.w.obtainMessage(0);
      paramArrayOfByte.what = 73;
      paramArrayOfByte.sendToTarget();
      this.s = true;
      break;
    case 0: 
      long l1 = System.currentTimeMillis();
      bv.a().a(l1, 140);
      ProtoFaceCommon.n = (int)(l1 - this.q);
      switch (this.G)
      {
      default: 
        break;
      case 6: 
        bv.a().a(l1, 156);
        break;
      case 5: 
        bv.a().a(l1, 155);
        break;
      case 4: 
        bv.a().a(l1, 144);
        break;
      case 3: 
        bv.a().a(l1, 143);
        break;
      case 2: 
        bv.a().a(l1, 142);
        break;
      case 1: 
        bv.a().a(l1, 141);
      }
      if (((this.i == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.i == FaceDetector.LiveAction.ACT_BLINK)) && (this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
        this.I.a(this.f, this.c, this.b);
      }
      paramArrayOfByte = this.w.obtainMessage(0);
      paramArrayOfByte.what = 71;
      paramArrayOfByte.obj = Double.valueOf(this.g.angle());
      paramArrayOfByte.sendToTarget();
      this.s = true;
      this.I.a();
    }
    if (i1 != 0)
    {
      double d1;
      if ((this.j != FaceDetector.LiveDirection.LD_UP) && (this.j != FaceDetector.LiveDirection.LD_LEFT))
      {
        if ((this.j == FaceDetector.LiveDirection.LD_DOWN) || (this.j == FaceDetector.LiveDirection.LD_RIGHT))
        {
          d1 = this.g.angle();
          if ((d1 > 0.0D) && (d1 < h))
          {
            paramArrayOfByte = this.I;
            if (paramArrayOfByte != null) {
              paramArrayOfByte.setVryMoveDistance(new Double(d1).intValue());
            }
          }
        }
      }
      else
      {
        d1 = this.g.angle();
        if ((d1 < 0.0D) && (d1 > -h))
        {
          paramArrayOfByte = this.I;
          if (paramArrayOfByte != null) {
            paramArrayOfByte.setVryMoveDistance(-new Double(d1).intValue());
          }
        }
      }
    }
  }
  
  private void f()
  {
    g();
    h();
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 118	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   9: invokevirtual 221	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   12: invokevirtual 350	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   15: ldc_w 643
    //   18: invokevirtual 402	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore 4
    //   23: new 364	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 118	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   31: ldc_w 645
    //   34: iconst_0
    //   35: invokevirtual 649	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   38: ldc_w 651
    //   41: invokespecial 654	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 376	java/io/File:exists	()Z
    //   51: ifeq +29 -> 80
    //   54: aload_0
    //   55: aload 5
    //   57: invokevirtual 657	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: putfield 635	com/tencent/token/ui/h:K	Ljava/lang/String;
    //   63: aload 4
    //   65: ifnull +14 -> 79
    //   68: aload 4
    //   70: invokevirtual 414	java/io/InputStream:close	()V
    //   73: return
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   79: return
    //   80: new 419	java/io/FileOutputStream
    //   83: dup
    //   84: aload 5
    //   86: invokespecial 422	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   89: astore_2
    //   90: sipush 8192
    //   93: newarray byte
    //   95: astore_3
    //   96: aload 4
    //   98: aload_3
    //   99: invokevirtual 430	java/io/InputStream:read	([B)I
    //   102: istore_1
    //   103: iload_1
    //   104: iconst_m1
    //   105: if_icmpeq +13 -> 118
    //   108: aload_2
    //   109: aload_3
    //   110: iconst_0
    //   111: iload_1
    //   112: invokevirtual 435	java/io/FileOutputStream:write	([BII)V
    //   115: goto -19 -> 96
    //   118: aload_0
    //   119: aload 5
    //   121: invokevirtual 657	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: putfield 635	com/tencent/token/ui/h:K	Ljava/lang/String;
    //   127: aload 4
    //   129: ifnull +8 -> 137
    //   132: aload 4
    //   134: invokevirtual 414	java/io/InputStream:close	()V
    //   137: aload_2
    //   138: invokevirtual 431	java/io/FileOutputStream:close	()V
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
    //   176: ldc_w 659
    //   179: invokestatic 661	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   182: aload_3
    //   183: ifnull +10 -> 193
    //   186: aload_3
    //   187: invokevirtual 414	java/io/InputStream:close	()V
    //   190: goto +3 -> 193
    //   193: aload_2
    //   194: ifnull +12 -> 206
    //   197: aload_2
    //   198: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   201: return
    //   202: aload_2
    //   203: invokevirtual 417	java/lang/Exception:printStackTrace	()V
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
    //   228: invokevirtual 414	java/io/InputStream:close	()V
    //   231: goto +3 -> 234
    //   234: aload_3
    //   235: ifnull +14 -> 249
    //   238: aload_3
    //   239: invokevirtual 431	java/io/FileOutputStream:close	()V
    //   242: goto +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 417	java/lang/Exception:printStackTrace	()V
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
    //   0	271	0	this	h
    //   102	10	1	i1	int
    //   74	2	2	localException1	Exception
    //   89	60	2	localObject1	Object
    //   152	1	2	localObject2	Object
    //   157	1	2	localObject3	Object
    //   164	1	2	localObject4	Object
    //   172	78	2	localObject5	Object
    //   251	1	2	localException2	Exception
    //   255	1	2	localException3	Exception
    //   263	1	2	localException4	Exception
    //   1	245	3	localObject6	Object
    //   259	1	3	localException5	Exception
    //   267	1	3	localException6	Exception
    //   21	146	4	localInputStream	java.io.InputStream
    //   207	6	4	localObject7	Object
    //   216	11	4	localObject8	Object
    //   3	117	5	localFile	File
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
    //   5	23	251	java/lang/Exception
    //   23	63	255	java/lang/Exception
    //   80	90	255	java/lang/Exception
    //   90	96	259	java/lang/Exception
    //   96	103	259	java/lang/Exception
    //   108	115	259	java/lang/Exception
    //   118	127	259	java/lang/Exception
    //   132	137	263	java/lang/Exception
    //   137	141	263	java/lang/Exception
    //   186	190	263	java/lang/Exception
    //   197	201	263	java/lang/Exception
    //   226	231	267	java/lang/Exception
    //   238	242	267	java/lang/Exception
  }
  
  private void h()
  {
    Object localObject = this.B;
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getDir("livemodel", 0).getAbsolutePath();
    a((String)localObject, "model");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("model");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main_ccnf_general.txt");
    this.L = localStringBuilder.toString();
  }
  
  private void i()
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
        this.a = Camera.open(i1);
        this.z = 1;
      }
      catch (RuntimeException localRuntimeException1)
      {
        label48:
        StringBuilder localStringBuilder;
        break label48;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraOpen camera=");
      localStringBuilder.append(this.a);
      g.c(localStringBuilder.toString());
      i1 += 1;
    }
    if (this.a == null)
    {
      i1 = 0;
      while (i1 < i2)
      {
        Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 0) {}
        try
        {
          this.a = Camera.open(i1);
          this.z = 0;
        }
        catch (RuntimeException localRuntimeException2)
        {
          label133:
          break label133;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CameraOpen camera=");
        localStringBuilder.append(this.a);
        g.c(localStringBuilder.toString());
        i1 += 1;
      }
    }
    else
    {
      if (this.a == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CameraOpen camera=");
        ((StringBuilder)localObject).append(this.a);
        g.c(((StringBuilder)localObject).toString());
        localObject = this.w.obtainMessage(0);
        ((Message)localObject).what = 2;
        ((Message)localObject).sendToTarget();
      }
      return;
    }
  }
  
  private void j()
  {
    Object localObject1 = this.a;
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
        a(this.C, this.z, this.a);
        if ((Build.MODEL.equals("Nexus 6")) || (Build.MODEL.toLowerCase().startsWith("nexus 6")) || (Build.MODEL.equals("Moto X Pro")) || ((Build.MODEL.toLowerCase().indexOf("nexus6") != -1) && (Build.BRAND.toLowerCase().indexOf("motorola") != -1))) {
          this.a.setDisplayOrientation(270);
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("S_DISPLAY_ANGLE");
        ((StringBuilder)localObject4).append(k);
        g.a(((StringBuilder)localObject4).toString());
        i1 = k;
        if (i1 != -1) {
          this.a.setDisplayOrientation(i1);
        }
      }
      else
      {
        ((Camera.Parameters)localObject1).set("orientation", "landscape");
        a(this.C, this.z, this.a);
      }
      Object localObject4 = this.B.getResources().getDisplayMetrics();
      int i2 = ((DisplayMetrics)localObject4).heightPixels;
      int i3 = ((DisplayMetrics)localObject4).widthPixels;
      if (localList == null) {
        return;
      }
      this.b = ((Camera.Size)localList.get(0)).width;
      this.c = ((Camera.Size)localList.get(0)).height;
      int i1 = 1;
      while (i1 < localList.size())
      {
        double d1 = this.b;
        double d2 = this.c;
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
          this.b = ((Camera.Size)localList.get(i1)).width;
          this.c = ((Camera.Size)localList.get(i1)).height;
        }
        if ((d2 == d1) && (((Camera.Size)localList.get(i1)).width <= i2) && (((Camera.Size)localList.get(i1)).height <= i3) && (((Camera.Size)localList.get(i1)).width <= 1280) && (((Camera.Size)localList.get(i1)).height <= 768) && (this.b < ((Camera.Size)localList.get(i1)).width))
        {
          this.b = ((Camera.Size)localList.get(i1)).width;
          this.c = ((Camera.Size)localList.get(i1)).height;
        }
        i1 += 1;
      }
      ((Camera.Parameters)localObject1).setPreviewSize(this.b, this.c);
      this.a.setParameters((Camera.Parameters)localObject1);
      this.a.setPreviewCallback(this);
      try
      {
        this.a.setPreviewDisplay(this.D);
        this.a.startPreview();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localObject3 = this.a;
        if (localObject3 != null)
        {
          ((Camera)localObject3).setPreviewCallback(null);
          this.a.release();
          this.a = null;
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append("*");
      ((StringBuilder)localObject3).append(this.b);
      ProtoFaceCommon.d = ((StringBuilder)localObject3).toString();
      localObject3 = this.x;
      localObject3[0] = 0;
      localObject3[1] = ((int)(FaceView.b * this.b));
      this.x[2] = this.c;
      float f1 = FaceView.d;
      i1 = this.b;
      f1 *= i1;
      localObject3 = this.x;
      localObject3[3] = ((int)(1.4F * f1));
      localObject3[1] = ((int)(localObject3[1] - f1 * 0.2F));
      if ((localObject3[3] >= i1) || (localObject3[1] < 0))
      {
        localObject3 = this.x;
        localObject3[1] = 0;
        localObject3[3] = this.b;
      }
      localObject3 = ((Camera.Parameters)localObject1).get("rotation");
      localObject4 = Build.MODEL;
      if ((!((String)localObject4).startsWith("8150")) && (this.z != 0) && (!((String)localObject4).equals("Nexus 6")) && (!((String)localObject4).equals("Nexus 6P")) && ((Build.MODEL.toLowerCase().indexOf("nexus6") == -1) || (Build.BRAND.toLowerCase().indexOf("motorola") == -1)))
      {
        localObject1 = localObject3;
        if (localObject3 != null) {
          if (!((String)localObject4).contains("MI 5"))
          {
            localObject1 = localObject3;
            if (this.b > this.c)
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
      i1 = l;
      if (i1 != -1) {
        this.F = i1;
      }
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Camera getParameters failed");
      ((StringBuilder)localObject2).append(this.a);
      g.c(((StringBuilder)localObject2).toString());
      localObject2 = this.w.obtainMessage(0);
      ((Message)localObject2).what = 2;
      ((Message)localObject2).sendToTarget();
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    this.v = paramLong;
  }
  
  public void a(FaceServiceDelegate.FaceDetectErrorCode paramFaceDetectErrorCode)
  {
    if (this.J != null) {
      switch (3.a[paramFaceDetectErrorCode.ordinal()])
      {
      default: 
      case 7: 
        this.J.setText(2131493154);
        if (this.Q != null)
        {
          paramFaceDetectErrorCode = this.I;
          if ((paramFaceDetectErrorCode != null) && (!paramFaceDetectErrorCode.getBrightMode()))
          {
            this.Q.setVisibility(0);
            this.Q.bringToFront();
            return;
          }
          this.Q.setVisibility(4);
          return;
        }
        break;
      case 6: 
        this.J.setText(2131493153);
        paramFaceDetectErrorCode = this.Q;
        if (paramFaceDetectErrorCode != null)
        {
          paramFaceDetectErrorCode.setVisibility(4);
          return;
        }
        break;
      case 4: 
      case 5: 
        this.J.setText(2131493149);
        paramFaceDetectErrorCode = this.Q;
        if (paramFaceDetectErrorCode != null)
        {
          paramFaceDetectErrorCode.setVisibility(4);
          return;
        }
        break;
      case 2: 
      case 3: 
        this.J.setText(2131493294);
        paramFaceDetectErrorCode = this.Q;
        if (paramFaceDetectErrorCode != null)
        {
          paramFaceDetectErrorCode.setVisibility(4);
          return;
        }
        break;
      case 1: 
        paramFaceDetectErrorCode = this.Q;
        if (paramFaceDetectErrorCode != null) {
          paramFaceDetectErrorCode.setVisibility(4);
        }
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    this.u = paramBoolean1;
    this.G = paramInt1;
    this.H = paramInt2;
    if (paramBoolean1)
    {
      if (this.E == DetectType.DT_REGISTER)
      {
        if ((this.H == 0) && (paramBoolean2)) {
          bv.a().a(System.currentTimeMillis(), 145);
        }
        switch (this.G)
        {
        default: 
          return;
        case 4: 
          bv.a().a(System.currentTimeMillis(), 147);
          this.i = FaceDetector.LiveAction.ACT_HEAD_SHAKE;
          this.O = this.B.getResources().getString(2131493292);
          return;
        case 3: 
          bv.a().a(System.currentTimeMillis(), 146);
          this.i = FaceDetector.LiveAction.ACT_HEAD_NOD;
          this.O = this.B.getResources().getString(2131493291);
          return;
        case 2: 
          bv.a().a(System.currentTimeMillis(), 148);
          this.i = FaceDetector.LiveAction.ACT_BLINK;
          this.O = this.B.getResources().getString(2131493290);
          return;
        }
        bv.a().a(System.currentTimeMillis(), 149);
        this.i = FaceDetector.LiveAction.ACT_MOUTH_OPEN;
        this.O = this.B.getResources().getString(2131493289);
        return;
      }
      bv.a().a(System.currentTimeMillis(), 150);
      switch (this.G)
      {
      default: 
        return;
      case 6: 
        bv.a().a(System.currentTimeMillis(), 157);
        this.i = FaceDetector.LiveAction.ACT_BLINK;
        this.O = this.B.getResources().getString(2131493290);
        return;
      case 5: 
        bv.a().a(System.currentTimeMillis(), 158);
        this.i = FaceDetector.LiveAction.ACT_MOUTH_OPEN;
        this.O = this.B.getResources().getString(2131493289);
        return;
      case 4: 
        bv.a().a(System.currentTimeMillis(), 154);
        this.j = FaceDetector.LiveDirection.LD_RIGHT;
        this.O = this.B.getResources().getString(2131493298);
        this.g.setDirection(this.j.ordinal());
        return;
      case 3: 
        bv.a().a(System.currentTimeMillis(), 153);
        this.j = FaceDetector.LiveDirection.LD_LEFT;
        this.O = this.B.getResources().getString(2131493297);
        this.g.setDirection(this.j.ordinal());
        return;
      case 2: 
        bv.a().a(System.currentTimeMillis(), 152);
        this.j = FaceDetector.LiveDirection.LD_DOWN;
        this.O = this.B.getResources().getString(2131493296);
        this.g.setDirection(this.j.ordinal());
        return;
      }
      bv.a().a(System.currentTimeMillis(), 151);
      this.j = FaceDetector.LiveDirection.LD_UP;
      this.O = this.B.getResources().getString(2131493295);
      this.g.setDirection(this.j.ordinal());
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Object localObject = this.Q;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    ProtoFaceCommon.f = (int)(System.currentTimeMillis() - this.p);
    ProtoFaceCommon.h = paramInt;
    if (this.w == null) {
      return;
    }
    paramArrayOfByte1 = new YuvImage(paramArrayOfByte1, 17, this.b, this.c, null);
    localObject = new ByteArrayOutputStream();
    paramArrayOfByte1.compressToJpeg(new Rect(0, 0, this.b, this.c), 100, (OutputStream)localObject);
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
      localFaceData.mOriginDataPath = com.tencent.token.utils.e.a(paramArrayOfByte1.toByteArray(), "origindata0");
    } else {
      localFaceData.mOriginDataPath = com.tencent.token.utils.e.a(paramArrayOfByte1.toByteArray(), "origindata1");
    }
    localFaceData.mUploadData = paramArrayOfByte2;
    ((Message)localObject).obj = localFaceData;
    ((Message)localObject).sendToTarget();
    this.s = true;
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void c()
  {
    if (this.a != null) {
      return;
    }
    try
    {
      i();
      j();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public void d()
  {
    this.B = null;
    this.C = null;
    this.w = null;
    try
    {
      if (this.a != null)
      {
        this.a.setPreviewCallback(null);
        this.a.stopPreview();
        this.a.release();
        this.a = null;
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
  
  public void e()
  {
    Camera localCamera = this.a;
    if (localCamera != null)
    {
      localCamera.setPreviewCallback(null);
      this.a.stopPreview();
      this.a.release();
      this.a = null;
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.s) {
      return;
    }
    if (this.v == 0L)
    {
      this.v = System.currentTimeMillis();
      return;
    }
    boolean bool = this.M;
    if (bool) {
      return;
    }
    if ((this.A == null) && (!bool)) {
      new Thread(new Runnable()
      {
        public void run()
        {
          synchronized (h.this.d)
          {
            if (h.a(h.this) == null)
            {
              h.a(h.this, true);
              long l = System.currentTimeMillis();
              h.b(h.this);
              ProtoFaceCommon.g = (int)(System.currentTimeMillis() - l);
              h.a(h.this, new com.tencent.service.e(h.c(h.this), h.this, h.d(h.this)));
              FaceThreshold localFaceThreshold = new FaceThreshold();
              h.a(h.this, localFaceThreshold);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("validateLightHigh");
              localStringBuilder.append(localFaceThreshold.validateLightHigh());
              g.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("validateLightLow");
              localStringBuilder.append(localFaceThreshold.validateLightLow());
              g.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("registerLightLow");
              localStringBuilder.append(localFaceThreshold.registerLightLow());
              g.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("registerLightHigh");
              localStringBuilder.append(localFaceThreshold.registerLightHigh());
              g.a(localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("faceDisparity");
              localStringBuilder.append(localFaceThreshold.faceDisparity());
              g.a(localStringBuilder.toString());
              h.a(h.this).a(localFaceThreshold);
              h.a(h.this, false);
            }
            return;
          }
        }
      }).start();
    }
    if (this.M) {
      return;
    }
    if ((this.a != null) && (this.A != null) && (!this.n))
    {
      g.b("onPreviewFramestart");
      this.n = true;
      this.A.a();
    }
    if (this.t)
    {
      if (System.currentTimeMillis() - this.v < this.r) {
        return;
      }
      this.p = System.currentTimeMillis();
      this.P += 1;
      if (this.P % 3 != 0) {
        return;
      }
      a(paramArrayOfByte, paramCamera);
      ProtoFaceCommon.h += 1;
    }
    if (this.u)
    {
      bool = this.N;
      if (bool) {
        return;
      }
      if ((!this.o) && (!bool))
      {
        this.N = true;
        new Thread(new Runnable()
        {
          public void run()
          {
            synchronized (h.this.e)
            {
              if (!h.this.o)
              {
                long l = System.currentTimeMillis();
                Object localObject2 = new LiveThreshold();
                h.a(h.this, (LiveThreshold)localObject2);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("shakeAngle");
                localStringBuilder.append(((LiveThreshold)localObject2).shakeAngle());
                g.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("nodAngle");
                localStringBuilder.append(((LiveThreshold)localObject2).nodAngle());
                g.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("mouthOpenScore");
                localStringBuilder.append(((LiveThreshold)localObject2).mouthOpenScore());
                g.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("blinkScore");
                localStringBuilder.append(((LiveThreshold)localObject2).blinkScore());
                g.a(localStringBuilder.toString());
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("downAngle");
                localStringBuilder.append(((LiveThreshold)localObject2).downAngle());
                g.a(localStringBuilder.toString());
                h.this.m = FaceDetector.LiveDetectInitial(h.e(h.this), (LiveThreshold)localObject2);
                ProtoFaceCommon.i = (int)(System.currentTimeMillis() - l);
                if (h.this.m)
                {
                  h.a(h.this, System.currentTimeMillis());
                  h.b(h.this, false);
                  h.this.o = true;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("LiveDetectInitial,ret=");
                ((StringBuilder)localObject2).append(h.this.m);
                ((StringBuilder)localObject2).append(",livemodelfile=");
                ((StringBuilder)localObject2).append(h.e(h.this));
                g.d(((StringBuilder)localObject2).toString());
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("LiveDetectInitial,ret=");
                ((StringBuilder)localObject2).append(h.this.m);
                ((StringBuilder)localObject2).append(",livemodelfile=");
                ((StringBuilder)localObject2).append(h.e(h.this));
                g.a(((StringBuilder)localObject2).toString());
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
    try
    {
      this.P += 1;
      if (this.P % 2 != 0) {
        return;
      }
      if (this.E == DetectType.DT_REGISTER)
      {
        b(paramArrayOfByte, paramCamera);
        return;
      }
      c(paramArrayOfByte, paramCamera);
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label279:
      break label279;
    }
    g.c("OutOfMemoryError:doLiveDetect");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.h
 * JD-Core Version:    0.7.0.1
 */