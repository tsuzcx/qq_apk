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
import com.tencent.service.f;
import com.tencent.token.bu;
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
  public static int k = m.t();
  public static int l = m.u();
  private com.tencent.service.e A;
  private Context B = RqdApplication.l();
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
    int i1 = 0;
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    if (paramActivity == null)
    {
      if (RqdApplication.l().getResources().getConfiguration().orientation != 2)
      {
        paramCamera.setDisplayOrientation(90);
        return;
      }
      paramCamera.setDisplayOrientation(0);
      return;
    }
    paramInt = i1;
    switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = i1;
    case 0: 
      if (localCameraInfo.facing != 1) {
        break;
      }
    }
    for (paramInt = (360 - (paramInt + localCameraInfo.orientation) % 360) % 360;; paramInt = (localCameraInfo.orientation - paramInt + 360) % 360)
    {
      paramCamera.setDisplayOrientation(paramInt);
      return;
      paramInt = 90;
      break;
      paramInt = 180;
      break;
      paramInt = 270;
      break;
    }
  }
  
  private void a(FaceThreshold paramFaceThreshold)
  {
    Object localObject1 = m.q();
    if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {}
    for (localObject1 = ((String)localObject1).split("\\|");; localObject1 = null)
    {
      Object localObject2 = m.r();
      if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {}
      for (localObject2 = ((String)localObject2).split("\\|");; localObject2 = null)
      {
        if ((localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (localObject2.length > 0))
        {
          int i1 = 0;
          if (i1 < localObject1.length)
          {
            if (localObject1[i1].isEmpty()) {}
            for (;;)
            {
              i1 += 1;
              break;
              switch (Integer.parseInt(localObject1[i1]))
              {
              default: 
                break;
              case 1: 
                paramFaceThreshold.setRegisterLightHigh(Float.parseFloat(localObject2[i1]));
                break;
              case 2: 
                paramFaceThreshold.setRegisterLightLow(Float.parseFloat(localObject2[i1]));
                break;
              case 3: 
                paramFaceThreshold.setValidateLightHigh(Float.parseFloat(localObject2[i1]));
                break;
              case 4: 
                paramFaceThreshold.setValidateLightLow(Float.parseFloat(localObject2[i1]));
                break;
              case 5: 
                paramFaceThreshold.setFaceDisparity(Float.parseFloat(localObject2[i1]));
              }
            }
          }
        }
        return;
      }
    }
  }
  
  private void a(LiveThreshold paramLiveThreshold)
  {
    int i1 = 0;
    Object localObject1 = m.q();
    if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {}
    for (localObject1 = ((String)localObject1).split("\\|");; localObject1 = null)
    {
      Object localObject2 = m.r();
      if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {}
      for (localObject2 = ((String)localObject2).split("\\|");; localObject2 = null)
      {
        if ((localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (localObject2.length > 0)) {
          if (this.E == DetectType.DT_REGISTER)
          {
            i1 = 0;
            if (i1 < localObject1.length)
            {
              if (localObject1[i1].isEmpty()) {}
              for (;;)
              {
                i1 += 1;
                break;
                switch (Integer.parseInt(localObject1[i1]))
                {
                default: 
                  break;
                case 6: 
                  paramLiveThreshold.setBlinkScore(Double.parseDouble(localObject2[i1]));
                  break;
                case 7: 
                  paramLiveThreshold.setMouthOpenScore(Double.parseDouble(localObject2[i1]));
                  break;
                case 8: 
                  paramLiveThreshold.setNodAngle(Double.parseDouble(localObject2[i1]));
                  break;
                case 9: 
                  paramLiveThreshold.setShakeAngle(Double.parseDouble(localObject2[i1]));
                  break;
                case 10: 
                  paramLiveThreshold.setLeftAngle(Double.parseDouble(localObject2[i1]));
                  paramLiveThreshold.setRightAngle(Double.parseDouble(localObject2[i1]));
                  paramLiveThreshold.setUpAngle(Double.parseDouble(localObject2[i1]));
                  paramLiveThreshold.setDownAngle(Double.parseDouble(localObject2[i1]));
                }
              }
            }
          }
          else if (i1 < localObject1.length)
          {
            if (localObject1[i1].isEmpty()) {}
            for (;;)
            {
              i1 += 1;
              break;
              switch (Integer.parseInt(localObject1[i1]))
              {
              default: 
                break;
              case 11: 
                paramLiveThreshold.setBlinkScore(Double.parseDouble(localObject2[i1]));
                break;
              case 12: 
                paramLiveThreshold.setMouthOpenScore(Double.parseDouble(localObject2[i1]));
                break;
              case 13: 
                paramLiveThreshold.setNodAngle(Double.parseDouble(localObject2[i1]));
                break;
              case 14: 
                paramLiveThreshold.setShakeAngle(Double.parseDouble(localObject2[i1]));
                break;
              case 15: 
                paramLiveThreshold.setLeftAngle(Double.parseDouble(localObject2[i1]));
                paramLiveThreshold.setRightAngle(Double.parseDouble(localObject2[i1]));
                paramLiveThreshold.setUpAngle(Double.parseDouble(localObject2[i1]));
                paramLiveThreshold.setDownAngle(Double.parseDouble(localObject2[i1]));
              }
            }
          }
        }
        return;
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
    //   7: astore 9
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_0
    //   12: getfield 119	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   15: invokevirtual 220	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   18: invokevirtual 349	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   21: aload_2
    //   22: invokevirtual 354	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   25: astore 6
    //   27: aload 6
    //   29: arraylength
    //   30: ifle +213 -> 243
    //   33: new 356	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   40: aload_1
    //   41: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 366	java/io/File:separator	Ljava/lang/String;
    //   47: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 11
    //   59: new 363	java/io/File
    //   62: dup
    //   63: aload 11
    //   65: invokespecial 372	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 10
    //   70: aload 10
    //   72: invokevirtual 375	java/io/File:exists	()Z
    //   75: istore 5
    //   77: iload 5
    //   79: ifeq +34 -> 113
    //   82: iconst_0
    //   83: ifeq +11 -> 94
    //   86: new 377	java/lang/NullPointerException
    //   89: dup
    //   90: invokespecial 378	java/lang/NullPointerException:<init>	()V
    //   93: athrow
    //   94: iconst_0
    //   95: ifeq +11 -> 106
    //   98: new 377	java/lang/NullPointerException
    //   101: dup
    //   102: invokespecial 378	java/lang/NullPointerException:<init>	()V
    //   105: athrow
    //   106: return
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   112: return
    //   113: aload 10
    //   115: invokevirtual 384	java/io/File:mkdirs	()Z
    //   118: pop
    //   119: new 356	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 386
    //   129: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 11
    //   134: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 390	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   143: aload 6
    //   145: arraylength
    //   146: istore 4
    //   148: iload_3
    //   149: iload 4
    //   151: if_icmpge +61 -> 212
    //   154: aload 6
    //   156: iload_3
    //   157: aaload
    //   158: astore 10
    //   160: new 356	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   167: aload_2
    //   168: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: getstatic 366	java/io/File:separator	Ljava/lang/String;
    //   174: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 10
    //   179: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore_2
    //   186: aload_0
    //   187: aload_1
    //   188: aload_2
    //   189: invokespecial 392	com/tencent/token/ui/h:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_2
    //   193: iconst_0
    //   194: aload_2
    //   195: getstatic 395	java/io/File:separatorChar	C
    //   198: invokevirtual 399	java/lang/String:lastIndexOf	(I)I
    //   201: invokevirtual 403	java/lang/String:substring	(II)Ljava/lang/String;
    //   204: astore_2
    //   205: iload_3
    //   206: iconst_1
    //   207: iadd
    //   208: istore_3
    //   209: goto -61 -> 148
    //   212: aconst_null
    //   213: astore 6
    //   215: aload 9
    //   217: astore_1
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 408	java/io/InputStream:close	()V
    //   228: aload_1
    //   229: ifnull -123 -> 106
    //   232: aload_1
    //   233: invokevirtual 411	java/io/FileOutputStream:close	()V
    //   236: return
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   242: return
    //   243: aload_0
    //   244: getfield 119	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   247: invokevirtual 220	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   250: invokevirtual 349	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   253: aload_2
    //   254: invokevirtual 415	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   257: astore 6
    //   259: new 356	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   266: aload_1
    //   267: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: getstatic 366	java/io/File:separator	Ljava/lang/String;
    //   273: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_2
    //   277: iconst_0
    //   278: aload_2
    //   279: getstatic 366	java/io/File:separator	Ljava/lang/String;
    //   282: invokevirtual 417	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   285: invokevirtual 403	java/lang/String:substring	(II)Ljava/lang/String;
    //   288: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: astore 9
    //   296: aload_2
    //   297: aload_2
    //   298: getstatic 395	java/io/File:separatorChar	C
    //   301: invokevirtual 399	java/lang/String:lastIndexOf	(I)I
    //   304: iconst_1
    //   305: iadd
    //   306: invokevirtual 420	java/lang/String:substring	(I)Ljava/lang/String;
    //   309: astore_2
    //   310: new 363	java/io/File
    //   313: dup
    //   314: aload 9
    //   316: aload_2
    //   317: invokespecial 422	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 375	java/io/File:exists	()Z
    //   325: istore 5
    //   327: iload 5
    //   329: ifeq +31 -> 360
    //   332: aload 6
    //   334: ifnull +8 -> 342
    //   337: aload 6
    //   339: invokevirtual 408	java/io/InputStream:close	()V
    //   342: iconst_0
    //   343: ifeq -237 -> 106
    //   346: new 377	java/lang/NullPointerException
    //   349: dup
    //   350: invokespecial 378	java/lang/NullPointerException:<init>	()V
    //   353: athrow
    //   354: astore_1
    //   355: aload_1
    //   356: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   359: return
    //   360: new 410	java/io/FileOutputStream
    //   363: dup
    //   364: aload_1
    //   365: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   368: astore_1
    //   369: new 356	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 427
    //   379: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 9
    //   384: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 429
    //   390: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 390	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   403: sipush 1024
    //   406: newarray byte
    //   408: astore_2
    //   409: aload 6
    //   411: aload_2
    //   412: invokevirtual 433	java/io/InputStream:read	([B)I
    //   415: istore_3
    //   416: iload_3
    //   417: iconst_m1
    //   418: if_icmpne +6 -> 424
    //   421: goto -203 -> 218
    //   424: aload_1
    //   425: aload_2
    //   426: iconst_0
    //   427: iload_3
    //   428: invokevirtual 437	java/io/FileOutputStream:write	([BII)V
    //   431: goto -22 -> 409
    //   434: astore 7
    //   436: aload_1
    //   437: astore_2
    //   438: aload 6
    //   440: astore_1
    //   441: aload 7
    //   443: astore 6
    //   445: aload 6
    //   447: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   450: aload_1
    //   451: ifnull +7 -> 458
    //   454: aload_1
    //   455: invokevirtual 408	java/io/InputStream:close	()V
    //   458: aload_2
    //   459: ifnull -353 -> 106
    //   462: aload_2
    //   463: invokevirtual 411	java/io/FileOutputStream:close	()V
    //   466: return
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   472: return
    //   473: astore_1
    //   474: aconst_null
    //   475: astore 6
    //   477: aload 8
    //   479: astore_2
    //   480: aload 6
    //   482: ifnull +8 -> 490
    //   485: aload 6
    //   487: invokevirtual 408	java/io/InputStream:close	()V
    //   490: aload_2
    //   491: ifnull +7 -> 498
    //   494: aload_2
    //   495: invokevirtual 411	java/io/FileOutputStream:close	()V
    //   498: aload_1
    //   499: athrow
    //   500: astore_2
    //   501: aload_2
    //   502: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   505: goto -7 -> 498
    //   508: astore_1
    //   509: aload 8
    //   511: astore_2
    //   512: goto -32 -> 480
    //   515: astore 7
    //   517: aload_1
    //   518: astore_2
    //   519: aload 7
    //   521: astore_1
    //   522: goto -42 -> 480
    //   525: astore 7
    //   527: aload_1
    //   528: astore 6
    //   530: aload 7
    //   532: astore_1
    //   533: goto -53 -> 480
    //   536: astore 6
    //   538: aconst_null
    //   539: astore_1
    //   540: aload 7
    //   542: astore_2
    //   543: goto -98 -> 445
    //   546: astore_2
    //   547: aload 6
    //   549: astore_1
    //   550: aload_2
    //   551: astore 6
    //   553: aload 7
    //   555: astore_2
    //   556: goto -111 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	h
    //   0	559	1	paramString1	String
    //   0	559	2	paramString2	String
    //   10	418	3	i1	int
    //   146	6	4	i2	int
    //   75	253	5	bool	boolean
    //   25	504	6	localObject1	Object
    //   536	12	6	localException1	Exception
    //   551	1	6	str1	String
    //   1	1	7	localObject2	Object
    //   434	8	7	localException2	Exception
    //   515	5	7	localObject3	Object
    //   525	29	7	localObject4	Object
    //   4	506	8	localObject5	Object
    //   7	376	9	str2	String
    //   68	110	10	localFile	File
    //   57	76	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   86	94	107	java/lang/Exception
    //   98	106	107	java/lang/Exception
    //   223	228	237	java/lang/Exception
    //   232	236	237	java/lang/Exception
    //   337	342	354	java/lang/Exception
    //   346	354	354	java/lang/Exception
    //   369	409	434	java/lang/Exception
    //   409	416	434	java/lang/Exception
    //   424	431	434	java/lang/Exception
    //   454	458	467	java/lang/Exception
    //   462	466	467	java/lang/Exception
    //   11	77	473	finally
    //   113	148	473	finally
    //   160	205	473	finally
    //   243	259	473	finally
    //   485	490	500	java/lang/Exception
    //   494	498	500	java/lang/Exception
    //   259	327	508	finally
    //   360	369	508	finally
    //   369	409	515	finally
    //   409	416	515	finally
    //   424	431	515	finally
    //   445	450	525	finally
    //   11	77	536	java/lang/Exception
    //   113	148	536	java/lang/Exception
    //   160	205	536	java/lang/Exception
    //   243	259	536	java/lang/Exception
    //   259	327	546	java/lang/Exception
    //   360	369	546	java/lang/Exception
  }
  
  private void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramCamera != null) {}
    try
    {
      paramCamera = paramCamera.getParameters();
      paramArrayOfByte = new f(paramArrayOfByte, paramCamera.getPreviewSize().width, paramCamera.getPreviewSize().height, this.F, this.x, this.y);
      this.A.a(paramArrayOfByte, this.E);
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      g.c("OutOfMemoryError:doFaceDetect");
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private void b(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.H == 0)
    {
      ProtoFaceCommon.l += 1;
      paramCamera = paramCamera.getParameters();
      int i1 = paramCamera.getPreviewSize().width;
      int i2 = paramCamera.getPreviewSize().height;
      this.f.reset();
      i1 = FaceDetector.LiveActionDetect(this.f, paramArrayOfByte, i1, i2, this.F, this.i);
      g.a("regregret: " + i1 + ", x=" + this.f.x() + ",y=" + this.f.y() + ",width=" + this.f.width() + ",height=" + this.f.height() + ",action=" + this.i);
      switch (i1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                ProtoFaceCommon.m += 1;
                break;
                long l1 = System.currentTimeMillis();
                if (this.H == 0)
                {
                  ProtoFaceCommon.j = (int)(l1 - this.q);
                  switch (this.G)
                  {
                  }
                }
                for (;;)
                {
                  if (((this.i == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.i == FaceDetector.LiveAction.ACT_BLINK)) && (this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
                    this.I.a(this.f, this.c, this.b);
                  }
                  paramArrayOfByte = this.w.obtainMessage(0);
                  paramArrayOfByte.what = 71;
                  paramArrayOfByte.sendToTarget();
                  this.s = true;
                  return;
                  bu.a().a(System.currentTimeMillis(), 135);
                  ProtoFaceCommon.k = (int)(l1 - this.q);
                  break;
                  bu.a().a(l1, 139);
                  continue;
                  bu.a().a(l1, 138);
                  continue;
                  bu.a().a(l1, 136);
                  continue;
                  bu.a().a(l1, 137);
                }
                paramArrayOfByte = this.w.obtainMessage(0);
                paramArrayOfByte.what = 73;
                paramArrayOfByte.sendToTarget();
                this.s = true;
                return;
              } while ((this.i != FaceDetector.LiveAction.ACT_MOUTH_OPEN) && (this.i != FaceDetector.LiveAction.ACT_BLINK));
              if ((this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
                this.I.a(this.f, this.c, this.b);
              }
            } while ((this.J == null) || (this.J.getText().toString().equals(this.O)));
            this.J.setText(this.O);
            return;
          } while (this.J == null);
          this.J.setText(2131231008);
          return;
        } while (this.J == null);
        this.J.setText(2131231009);
        return;
      } while (this.J == null);
      this.J.setText(2131231006);
      return;
    } while ((this.J == null) || (this.J.getText().toString().equals(this.O)));
    this.J.setText(this.O);
  }
  
  private void c(byte[] paramArrayOfByte, Camera paramCamera)
  {
    ProtoFaceCommon.o += 1;
    paramCamera = paramCamera.getParameters();
    int i1 = paramCamera.getPreviewSize().width;
    int i2 = paramCamera.getPreviewSize().height;
    label124:
    double d1;
    if (this.G <= 4)
    {
      i1 = FaceDetector.LiveDirectionDetect(this.g, paramArrayOfByte, i1, i2, this.F);
      g.a("ret:" + i1);
      switch (i1)
      {
      default: 
        if (i1 != 0)
        {
          if ((this.j != FaceDetector.LiveDirection.LD_UP) && (this.j != FaceDetector.LiveDirection.LD_LEFT)) {
            break label878;
          }
          d1 = this.g.angle();
          if ((d1 < 0.0D) && (d1 > -h) && (this.I != null)) {
            this.I.setVryMoveDistance(-new Double(d1).intValue());
          }
        }
        break;
      }
    }
    label878:
    do
    {
      do
      {
        return;
        this.f.reset();
        i1 = FaceDetector.LiveActionDetect(this.f, paramArrayOfByte, i1, i2, this.F, this.i);
        break;
        long l1 = System.currentTimeMillis();
        bu.a().a(l1, 140);
        ProtoFaceCommon.n = (int)(l1 - this.q);
        switch (this.G)
        {
        }
        for (;;)
        {
          if (((this.i == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.i == FaceDetector.LiveAction.ACT_BLINK)) && (this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
            this.I.a(this.f, this.c, this.b);
          }
          paramArrayOfByte = this.w.obtainMessage(0);
          paramArrayOfByte.what = 71;
          paramArrayOfByte.obj = Double.valueOf(this.g.angle());
          paramArrayOfByte.sendToTarget();
          this.s = true;
          this.I.a();
          break;
          bu.a().a(l1, 141);
          continue;
          bu.a().a(l1, 142);
          continue;
          bu.a().a(l1, 143);
          continue;
          bu.a().a(l1, 144);
          continue;
          bu.a().a(l1, 155);
          continue;
          bu.a().a(l1, 156);
        }
        paramArrayOfByte = this.w.obtainMessage(0);
        paramArrayOfByte.what = 73;
        paramArrayOfByte.sendToTarget();
        this.s = true;
        break label124;
        if ((this.i != FaceDetector.LiveAction.ACT_MOUTH_OPEN) && (this.i != FaceDetector.LiveAction.ACT_BLINK)) {
          break label124;
        }
        g.a("regregret: " + i1 + ", x=" + this.f.x() + ",y=" + this.f.y() + ",width=" + this.f.width() + ",height=" + this.f.height() + ",action=" + this.i);
        if ((this.I != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
          this.I.a(this.f, this.c, this.b);
        }
        if ((this.J == null) || (this.J.getText().toString().equals(this.O))) {
          break label124;
        }
        this.J.setText(this.O);
        break label124;
        if ((this.J == null) || (this.J.getText().toString().equals(this.O))) {
          break label124;
        }
        this.J.setText(this.O);
        break label124;
        if (this.J == null) {
          break label124;
        }
        this.J.setText(2131231008);
        break label124;
        if (this.J == null) {
          break label124;
        }
        this.J.setText(2131231009);
        break label124;
        if (this.J == null) {
          break label124;
        }
        this.J.setText(2131231006);
        break label124;
      } while ((this.j != FaceDetector.LiveDirection.LD_DOWN) && (this.j != FaceDetector.LiveDirection.LD_RIGHT));
      d1 = this.g.angle();
    } while ((d1 <= 0.0D) || (d1 >= h) || (this.I == null));
    this.I.setVryMoveDistance(new Double(d1).intValue());
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
    //   2: aload_0
    //   3: getfield 119	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   6: invokevirtual 220	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: invokevirtual 349	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   12: ldc_w 645
    //   15: invokevirtual 415	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: new 363	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: getfield 119	com/tencent/token/ui/h:B	Landroid/content/Context;
    //   27: ldc_w 647
    //   30: iconst_0
    //   31: invokevirtual 651	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   34: ldc_w 653
    //   37: invokespecial 656	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 5
    //   42: aload 5
    //   44: invokevirtual 375	java/io/File:exists	()Z
    //   47: ifeq +39 -> 86
    //   50: aload_0
    //   51: aload 5
    //   53: invokevirtual 659	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: putfield 637	com/tencent/token/ui/h:K	Ljava/lang/String;
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 408	java/io/InputStream:close	()V
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 377	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 378	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: return
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   85: return
    //   86: new 410	java/io/FileOutputStream
    //   89: dup
    //   90: aload 5
    //   92: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore 4
    //   97: sipush 8192
    //   100: newarray byte
    //   102: astore_3
    //   103: aload_2
    //   104: aload_3
    //   105: invokevirtual 433	java/io/InputStream:read	([B)I
    //   108: istore_1
    //   109: iload_1
    //   110: iconst_m1
    //   111: if_icmpeq +47 -> 158
    //   114: aload 4
    //   116: aload_3
    //   117: iconst_0
    //   118: iload_1
    //   119: invokevirtual 437	java/io/FileOutputStream:write	([BII)V
    //   122: goto -19 -> 103
    //   125: astore_3
    //   126: aload 4
    //   128: astore_3
    //   129: ldc_w 661
    //   132: invokestatic 663	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 408	java/io/InputStream:close	()V
    //   143: aload_3
    //   144: ifnull -65 -> 79
    //   147: aload_3
    //   148: invokevirtual 411	java/io/FileOutputStream:close	()V
    //   151: return
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   157: return
    //   158: aload_0
    //   159: aload 5
    //   161: invokevirtual 659	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   164: putfield 637	com/tencent/token/ui/h:K	Ljava/lang/String;
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 408	java/io/InputStream:close	()V
    //   175: aload 4
    //   177: ifnull -98 -> 79
    //   180: aload 4
    //   182: invokevirtual 411	java/io/FileOutputStream:close	()V
    //   185: return
    //   186: astore_2
    //   187: aload_2
    //   188: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   191: return
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: aconst_null
    //   196: astore 4
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 408	java/io/InputStream:close	()V
    //   206: aload 4
    //   208: ifnull +8 -> 216
    //   211: aload 4
    //   213: invokevirtual 411	java/io/FileOutputStream:close	()V
    //   216: aload_3
    //   217: athrow
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 381	java/lang/Exception:printStackTrace	()V
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
    //   0	259	0	this	h
    //   108	11	1	i1	int
    //   18	46	2	localInputStream	java.io.InputStream
    //   80	60	2	localException1	Exception
    //   152	20	2	localException2	Exception
    //   186	2	2	localException3	Exception
    //   194	9	2	localObject1	Object
    //   218	2	2	localException4	Exception
    //   248	1	2	localException5	Exception
    //   250	1	2	localObject2	Object
    //   1	116	3	arrayOfByte	byte[]
    //   125	1	3	localException6	Exception
    //   128	20	3	localObject3	Object
    //   192	25	3	localObject4	Object
    //   226	1	3	localObject5	Object
    //   233	7	3	localObject6	Object
    //   244	1	3	localObject7	Object
    //   95	146	4	localObject8	Object
    //   254	1	4	localException7	Exception
    //   40	120	5	localFile	File
    //   237	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	80	java/lang/Exception
    //   71	79	80	java/lang/Exception
    //   97	103	125	java/lang/Exception
    //   103	109	125	java/lang/Exception
    //   114	122	125	java/lang/Exception
    //   158	167	125	java/lang/Exception
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
    //   2	19	248	java/lang/Exception
    //   19	59	254	java/lang/Exception
    //   86	97	254	java/lang/Exception
  }
  
  private void h()
  {
    if (this.B == null) {
      return;
    }
    String str = this.B.getDir("livemodel", 0).getAbsolutePath();
    a(str, "model");
    this.L = (str + File.separator + "model" + File.separator + "main_ccnf_general.txt");
  }
  
  private void i()
  {
    Object localObject = new Camera.CameraInfo();
    int i2 = Camera.getNumberOfCameras();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 1) {}
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
            g.c("CameraOpen camera=" + this.a);
          }
        }
      }
    }
    if (this.a == null)
    {
      i1 = 0;
      for (;;)
      {
        if (i1 < i2)
        {
          Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing == 0) {}
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
              g.c("CameraOpen camera=" + this.a);
            }
          }
        }
      }
    }
    if (this.a == null)
    {
      g.c("CameraOpen camera=" + this.a);
      localObject = this.w.obtainMessage(0);
      ((Message)localObject).what = 2;
      ((Message)localObject).sendToTarget();
    }
  }
  
  private void j()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      Object localObject3;
      Object localObject1;
      for (;;)
      {
        try
        {
          Camera.Parameters localParameters = this.a.getParameters();
          localParameters.setPictureFormat(256);
          localParameters.setPreviewFormat(17);
          localObject2 = localParameters.getSupportedPreviewSizes();
          if (this.B.getResources().getConfiguration().orientation != 2)
          {
            localParameters.set("orientation", "portrait");
            localParameters.set("rotation", 90);
            a(this.C, this.z, this.a);
            if ((Build.MODEL.equals("Nexus 6")) || (Build.MODEL.toLowerCase().startsWith("nexus 6")) || (Build.MODEL.equals("Moto X Pro")) || ((Build.MODEL.toLowerCase().indexOf("nexus6") != -1) && (Build.BRAND.toLowerCase().indexOf("motorola") != -1))) {
              this.a.setDisplayOrientation(270);
            }
            g.a("S_DISPLAY_ANGLE" + k);
            if (k != -1) {
              this.a.setDisplayOrientation(k);
            }
            localObject3 = this.B.getResources().getDisplayMetrics();
            int i2 = ((DisplayMetrics)localObject3).heightPixels;
            int i3 = ((DisplayMetrics)localObject3).widthPixels;
            if (localObject2 == null) {
              break;
            }
            this.b = ((Camera.Size)((List)localObject2).get(0)).width;
            this.c = ((Camera.Size)((List)localObject2).get(0)).height;
            int i1 = 1;
            if (i1 >= ((List)localObject2).size()) {
              break label732;
            }
            double d1 = Math.abs(this.b / this.c - i2 / i3);
            double d2 = Math.abs(((Camera.Size)((List)localObject2).get(i1)).width / ((Camera.Size)((List)localObject2).get(i1)).height - i2 / i3);
            if ((d1 > d2) && (((Camera.Size)((List)localObject2).get(i1)).width <= i2) && (((Camera.Size)((List)localObject2).get(i1)).height <= i3) && (((Camera.Size)((List)localObject2).get(i1)).width <= 1280) && (((Camera.Size)((List)localObject2).get(i1)).height <= 768))
            {
              this.b = ((Camera.Size)((List)localObject2).get(i1)).width;
              this.c = ((Camera.Size)((List)localObject2).get(i1)).height;
            }
            if ((d1 == d2) && (((Camera.Size)((List)localObject2).get(i1)).width <= i2) && (((Camera.Size)((List)localObject2).get(i1)).height <= i3) && (((Camera.Size)((List)localObject2).get(i1)).width <= 1280) && (((Camera.Size)((List)localObject2).get(i1)).height <= 768) && (this.b < ((Camera.Size)((List)localObject2).get(i1)).width))
            {
              this.b = ((Camera.Size)((List)localObject2).get(i1)).width;
              this.c = ((Camera.Size)((List)localObject2).get(i1)).height;
            }
            i1 += 1;
            continue;
          }
          ((Camera.Parameters)localObject1).set("orientation", "landscape");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          g.c("Camera getParameters failed" + this.a);
          localObject1 = this.w.obtainMessage(0);
          ((Message)localObject1).what = 2;
          ((Message)localObject1).sendToTarget();
          return;
        }
        a(this.C, this.z, this.a);
      }
      label732:
      ((Camera.Parameters)localObject1).setPreviewSize(this.b, this.c);
      this.a.setParameters((Camera.Parameters)localObject1);
      this.a.setPreviewCallback(this);
      try
      {
        this.a.setPreviewDisplay(this.D);
        this.a.startPreview();
        ProtoFaceCommon.d = this.c + "*" + this.b;
        this.x[0] = 0;
        this.x[1] = ((int)(FaceView.b * this.b));
        this.x[2] = this.c;
        float f1 = FaceView.d * this.b;
        this.x[3] = ((int)(1.4F * f1));
        this.x[1] = ((int)(this.x[1] - f1 * 0.2F));
        if ((this.x[3] >= this.b) || (this.x[1] < 0))
        {
          this.x[1] = 0;
          this.x[3] = this.b;
        }
        localObject2 = ((Camera.Parameters)localObject1).get("rotation");
        localObject3 = Build.MODEL;
        if ((((String)localObject3).startsWith("8150")) || (this.z == 0) || (((String)localObject3).equals("Nexus 6")) || (((String)localObject3).equals("Nexus 6P")) || ((Build.MODEL.toLowerCase().indexOf("nexus6") != -1) && (Build.BRAND.toLowerCase().indexOf("motorola") != -1)))
        {
          localObject1 = "270";
          this.F = Integer.parseInt((String)localObject1);
          if (l == -1) {
            continue;
          }
          this.F = l;
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          if (this.a != null)
          {
            this.a.setPreviewCallback(null);
            this.a.release();
            this.a = null;
            continue;
            localObject1 = localException2;
            if (localException2 != null) {
              if (!((String)localObject3).contains("MI 5"))
              {
                localObject1 = localException2;
                if (this.b > this.c)
                {
                  localObject1 = localException2;
                  if (Integer.valueOf(localException2).intValue() >= 90) {}
                }
              }
              else
              {
                localObject1 = "90";
              }
            }
          }
        }
      }
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
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.Q == null);
            this.Q.setVisibility(4);
            return;
            this.J.setText(2131231151);
          } while (this.Q == null);
          this.Q.setVisibility(4);
          return;
          this.J.setText(2131231006);
        } while (this.Q == null);
        this.Q.setVisibility(4);
        return;
        this.J.setText(2131231010);
      } while (this.Q == null);
      this.Q.setVisibility(4);
      return;
      this.J.setText(2131231011);
    } while (this.Q == null);
    if ((this.I != null) && (!this.I.getBrightMode()))
    {
      this.Q.setVisibility(0);
      this.Q.bringToFront();
      return;
    }
    this.Q.setVisibility(4);
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
      if (this.E != DetectType.DT_REGISTER) {
        break label237;
      }
      if ((this.H == 0) && (paramBoolean2)) {
        bu.a().a(System.currentTimeMillis(), 145);
      }
    }
    switch (this.G)
    {
    default: 
      return;
    case 1: 
      bu.a().a(System.currentTimeMillis(), 149);
      this.i = FaceDetector.LiveAction.ACT_MOUTH_OPEN;
      this.O = this.B.getResources().getString(2131231146);
      return;
    case 2: 
      bu.a().a(System.currentTimeMillis(), 148);
      this.i = FaceDetector.LiveAction.ACT_BLINK;
      this.O = this.B.getResources().getString(2131231147);
      return;
    case 3: 
      bu.a().a(System.currentTimeMillis(), 146);
      this.i = FaceDetector.LiveAction.ACT_HEAD_NOD;
      this.O = this.B.getResources().getString(2131231148);
      return;
    }
    bu.a().a(System.currentTimeMillis(), 147);
    this.i = FaceDetector.LiveAction.ACT_HEAD_SHAKE;
    this.O = this.B.getResources().getString(2131231149);
    return;
    label237:
    bu.a().a(System.currentTimeMillis(), 150);
    switch (this.G)
    {
    default: 
      return;
    case 1: 
      bu.a().a(System.currentTimeMillis(), 151);
      this.j = FaceDetector.LiveDirection.LD_UP;
      this.O = this.B.getResources().getString(2131231152);
      this.g.setDirection(this.j.ordinal());
      return;
    case 2: 
      bu.a().a(System.currentTimeMillis(), 152);
      this.j = FaceDetector.LiveDirection.LD_DOWN;
      this.O = this.B.getResources().getString(2131231153);
      this.g.setDirection(this.j.ordinal());
      return;
    case 3: 
      bu.a().a(System.currentTimeMillis(), 153);
      this.j = FaceDetector.LiveDirection.LD_LEFT;
      this.O = this.B.getResources().getString(2131231154);
      this.g.setDirection(this.j.ordinal());
      return;
    case 4: 
      bu.a().a(System.currentTimeMillis(), 154);
      this.j = FaceDetector.LiveDirection.LD_RIGHT;
      this.O = this.B.getResources().getString(2131231155);
      this.g.setDirection(this.j.ordinal());
      return;
    case 6: 
      bu.a().a(System.currentTimeMillis(), 157);
      this.i = FaceDetector.LiveAction.ACT_BLINK;
      this.O = this.B.getResources().getString(2131231147);
      return;
    }
    bu.a().a(System.currentTimeMillis(), 158);
    this.i = FaceDetector.LiveAction.ACT_MOUTH_OPEN;
    this.O = this.B.getResources().getString(2131231146);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (this.Q != null) {
      this.Q.setVisibility(4);
    }
    ProtoFaceCommon.f = (int)(System.currentTimeMillis() - this.p);
    ProtoFaceCommon.h = paramInt;
    if (this.w == null) {
      return;
    }
    paramArrayOfByte1 = new YuvImage(paramArrayOfByte1, 17, this.b, this.c, null);
    Object localObject = new ByteArrayOutputStream();
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
    if (this.H == 0) {}
    for (localFaceData.mOriginDataPath = com.tencent.token.utils.e.a(paramArrayOfByte1.toByteArray(), "origindata0");; localFaceData.mOriginDataPath = com.tencent.token.utils.e.a(paramArrayOfByte1.toByteArray(), "origindata1"))
    {
      localFaceData.mUploadData = paramArrayOfByte2;
      ((Message)localObject).obj = localFaceData;
      ((Message)localObject).sendToTarget();
      this.s = true;
      return;
    }
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
      for (;;)
      {
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
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public void e()
  {
    if (this.a != null)
    {
      this.a.setPreviewCallback(null);
      this.a.stopPreview();
      this.a.release();
      this.a = null;
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.s) {}
    for (;;)
    {
      return;
      if (this.v == 0L)
      {
        this.v = System.currentTimeMillis();
        return;
      }
      if (!this.M)
      {
        if ((this.A == null) && (!this.M)) {
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
                  g.a("validateLightHigh" + localFaceThreshold.validateLightHigh());
                  g.a("validateLightLow" + localFaceThreshold.validateLightLow());
                  g.a("registerLightLow" + localFaceThreshold.registerLightLow());
                  g.a("registerLightHigh" + localFaceThreshold.registerLightHigh());
                  g.a("faceDisparity" + localFaceThreshold.faceDisparity());
                  h.a(h.this).a(localFaceThreshold);
                  h.a(h.this, false);
                }
                return;
              }
            }
          }).start();
        }
        if (!this.M)
        {
          if ((this.a != null) && (this.A != null) && (!this.n))
          {
            g.b("onPreviewFramestart");
            this.n = true;
            this.A.a();
          }
          if (this.t)
          {
            if (System.currentTimeMillis() - this.v >= this.r)
            {
              this.p = System.currentTimeMillis();
              this.P += 1;
              if (this.P % 3 == 0)
              {
                a(paramArrayOfByte, paramCamera);
                ProtoFaceCommon.h += 1;
              }
            }
          }
          else if ((this.u) && (!this.N))
          {
            if ((!this.o) && (!this.N))
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
                      LiveThreshold localLiveThreshold = new LiveThreshold();
                      h.a(h.this, localLiveThreshold);
                      g.a("shakeAngle" + localLiveThreshold.shakeAngle());
                      g.a("nodAngle" + localLiveThreshold.nodAngle());
                      g.a("mouthOpenScore" + localLiveThreshold.mouthOpenScore());
                      g.a("blinkScore" + localLiveThreshold.blinkScore());
                      g.a("downAngle" + localLiveThreshold.downAngle());
                      h.this.m = FaceDetector.LiveDetectInitial(h.e(h.this), localLiveThreshold);
                      ProtoFaceCommon.i = (int)(System.currentTimeMillis() - l);
                      if (h.this.m)
                      {
                        h.a(h.this, System.currentTimeMillis());
                        h.b(h.this, false);
                        h.this.o = true;
                      }
                      g.d("LiveDetectInitial,ret=" + h.this.m + ",livemodelfile=" + h.e(h.this));
                      g.a("LiveDetectInitial,ret=" + h.this.m + ",livemodelfile=" + h.e(h.this));
                    }
                    return;
                  }
                }
              }).start();
            }
            if (!this.N) {
              try
              {
                this.P += 1;
                if (this.P % 2 == 0) {
                  if (this.E == DetectType.DT_REGISTER)
                  {
                    b(paramArrayOfByte, paramCamera);
                    return;
                  }
                }
              }
              catch (OutOfMemoryError paramArrayOfByte)
              {
                g.c("OutOfMemoryError:doLiveDetect");
                return;
              }
            }
          }
        }
      }
    }
    c(paramArrayOfByte, paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.h
 * JD-Core Version:    0.7.0.1
 */