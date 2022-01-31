package com.tencent.token.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.widget.TextView;
import com.tencent.jni.DirectionInfo;
import com.tencent.jni.FaceData;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceDetector.LiveAction;
import com.tencent.jni.FaceDetector.LiveDirection;
import com.tencent.jni.LiveRectInfo;
import com.tencent.service.DetectType;
import com.tencent.service.FaceServiceDelegate;
import com.tencent.service.FaceServiceDelegate.FaceDetectErrorCode;
import com.tencent.service.h;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.cv;
import com.tencent.token.ei;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.p;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.t;
import java.util.List;

public final class hx
  implements Camera.PreviewCallback, FaceServiceDelegate
{
  private DetectType A;
  private int B;
  private int C;
  private int D;
  private FaceView E;
  private TextView F;
  private String G;
  private String H;
  private boolean I;
  private boolean J;
  private String K;
  private int L;
  public Camera a;
  public int b;
  public int c;
  Object d = new Object();
  Object e = new Object();
  LiveRectInfo f = new LiveRectInfo();
  DirectionInfo g = new DirectionInfo();
  FaceDetector.LiveAction h = FaceDetector.LiveAction.ACT_BLINK;
  FaceDetector.LiveDirection i = FaceDetector.LiveDirection.LD_UP;
  boolean j = false;
  boolean k = false;
  boolean l = false;
  private long m = 0L;
  private long n = 0L;
  private long o = 2000L;
  private boolean p = false;
  private boolean q = true;
  private boolean r = false;
  private long s;
  private Handler t;
  private int[] u = new int[4];
  private float[] v;
  private int w;
  private com.tencent.service.e x;
  private Context y = RqdApplication.i();
  private SurfaceHolder z;
  
  public hx(SurfaceHolder paramSurfaceHolder, Handler paramHandler, int paramInt1, int paramInt2, FaceView paramFaceView, TextView paramTextView)
  {
    this.E = paramFaceView;
    this.F = paramTextView;
    this.z = paramSurfaceHolder;
    this.t = paramHandler;
    this.w = paramInt1;
    this.A = DetectType.DT_VALIDATE;
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.A = DetectType.DT_REGISTER;
    }
    paramSurfaceHolder = t.k();
    this.v = new float[3];
    this.v[0] = paramSurfaceHolder.mRegRayThres;
    this.v[1] = paramSurfaceHolder.mVerifyRayThres;
    this.v[2] = paramSurfaceHolder.mDisparityThres;
    this.E = paramFaceView;
    this.L = 0;
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
    //   12: getfield 91	com/tencent/token/ui/hx:y	Landroid/content/Context;
    //   15: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   18: invokevirtual 186	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   21: aload_2
    //   22: invokevirtual 192	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   25: astore 6
    //   27: aload 6
    //   29: arraylength
    //   30: ifle +178 -> 208
    //   33: new 194	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   40: aload_1
    //   41: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 204	java/io/File:separator	Ljava/lang/String;
    //   47: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 10
    //   59: new 201	java/io/File
    //   62: dup
    //   63: aload 10
    //   65: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 11
    //   70: aload 11
    //   72: invokevirtual 215	java/io/File:exists	()Z
    //   75: ifeq +4 -> 79
    //   78: return
    //   79: aload 11
    //   81: invokevirtual 218	java/io/File:mkdirs	()Z
    //   84: pop
    //   85: new 194	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   92: ldc 220
    //   94: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 10
    //   99: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 224	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   108: aload 6
    //   110: arraylength
    //   111: istore 4
    //   113: iload_3
    //   114: iload 4
    //   116: if_icmpge +61 -> 177
    //   119: aload 6
    //   121: iload_3
    //   122: aaload
    //   123: astore 10
    //   125: new 194	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   132: aload_2
    //   133: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: getstatic 204	java/io/File:separator	Ljava/lang/String;
    //   139: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 10
    //   144: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore_2
    //   151: aload_0
    //   152: aload_1
    //   153: aload_2
    //   154: invokespecial 226	com/tencent/token/ui/hx:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_2
    //   158: iconst_0
    //   159: aload_2
    //   160: getstatic 229	java/io/File:separatorChar	C
    //   163: invokevirtual 235	java/lang/String:lastIndexOf	(I)I
    //   166: invokevirtual 239	java/lang/String:substring	(II)Ljava/lang/String;
    //   169: astore_2
    //   170: iload_3
    //   171: iconst_1
    //   172: iadd
    //   173: istore_3
    //   174: goto -61 -> 113
    //   177: aconst_null
    //   178: astore 6
    //   180: aload 9
    //   182: astore_1
    //   183: aload 6
    //   185: ifnull +8 -> 193
    //   188: aload 6
    //   190: invokevirtual 244	java/io/InputStream:close	()V
    //   193: aload_1
    //   194: ifnull +319 -> 513
    //   197: aload_1
    //   198: invokevirtual 247	java/io/FileOutputStream:close	()V
    //   201: return
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   207: return
    //   208: aload_0
    //   209: getfield 91	com/tencent/token/ui/hx:y	Landroid/content/Context;
    //   212: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   215: invokevirtual 186	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   218: aload_2
    //   219: invokevirtual 254	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   222: astore 6
    //   224: new 194	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   231: aload_1
    //   232: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: getstatic 204	java/io/File:separator	Ljava/lang/String;
    //   238: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_2
    //   242: iconst_0
    //   243: aload_2
    //   244: getstatic 204	java/io/File:separator	Ljava/lang/String;
    //   247: invokevirtual 257	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   250: invokevirtual 239	java/lang/String:substring	(II)Ljava/lang/String;
    //   253: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore 9
    //   261: aload_2
    //   262: aload_2
    //   263: getstatic 229	java/io/File:separatorChar	C
    //   266: invokevirtual 235	java/lang/String:lastIndexOf	(I)I
    //   269: iconst_1
    //   270: iadd
    //   271: invokevirtual 260	java/lang/String:substring	(I)Ljava/lang/String;
    //   274: astore_2
    //   275: new 201	java/io/File
    //   278: dup
    //   279: aload 9
    //   281: aload_2
    //   282: invokespecial 262	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 215	java/io/File:exists	()Z
    //   290: istore 5
    //   292: iload 5
    //   294: ifeq +20 -> 314
    //   297: aload 6
    //   299: ifnull +214 -> 513
    //   302: aload 6
    //   304: invokevirtual 244	java/io/InputStream:close	()V
    //   307: return
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   313: return
    //   314: new 246	java/io/FileOutputStream
    //   317: dup
    //   318: aload_1
    //   319: invokespecial 265	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   322: astore_1
    //   323: new 194	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 267
    //   333: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 9
    //   338: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 269
    //   344: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_2
    //   348: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 224	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   357: sipush 1024
    //   360: newarray byte
    //   362: astore_2
    //   363: aload 6
    //   365: aload_2
    //   366: invokevirtual 273	java/io/InputStream:read	([B)I
    //   369: istore_3
    //   370: iload_3
    //   371: iconst_m1
    //   372: if_icmpeq +138 -> 510
    //   375: aload_1
    //   376: aload_2
    //   377: iconst_0
    //   378: iload_3
    //   379: invokevirtual 277	java/io/FileOutputStream:write	([BII)V
    //   382: goto -19 -> 363
    //   385: astore 7
    //   387: aload_1
    //   388: astore_2
    //   389: aload 6
    //   391: astore_1
    //   392: aload 7
    //   394: astore 6
    //   396: aload 6
    //   398: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   401: aload_1
    //   402: ifnull +7 -> 409
    //   405: aload_1
    //   406: invokevirtual 244	java/io/InputStream:close	()V
    //   409: aload_2
    //   410: ifnull +103 -> 513
    //   413: aload_2
    //   414: invokevirtual 247	java/io/FileOutputStream:close	()V
    //   417: return
    //   418: astore_1
    //   419: aload_1
    //   420: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   423: return
    //   424: astore_1
    //   425: aconst_null
    //   426: astore 6
    //   428: aload 8
    //   430: astore_2
    //   431: aload 6
    //   433: ifnull +8 -> 441
    //   436: aload 6
    //   438: invokevirtual 244	java/io/InputStream:close	()V
    //   441: aload_2
    //   442: ifnull +7 -> 449
    //   445: aload_2
    //   446: invokevirtual 247	java/io/FileOutputStream:close	()V
    //   449: aload_1
    //   450: athrow
    //   451: astore_2
    //   452: aload_2
    //   453: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   456: goto -7 -> 449
    //   459: astore_1
    //   460: aload 8
    //   462: astore_2
    //   463: goto -32 -> 431
    //   466: astore 7
    //   468: aload_1
    //   469: astore_2
    //   470: aload 7
    //   472: astore_1
    //   473: goto -42 -> 431
    //   476: astore 7
    //   478: aload_1
    //   479: astore 6
    //   481: aload 7
    //   483: astore_1
    //   484: goto -53 -> 431
    //   487: astore 6
    //   489: aconst_null
    //   490: astore_1
    //   491: aload 7
    //   493: astore_2
    //   494: goto -98 -> 396
    //   497: astore_2
    //   498: aload 6
    //   500: astore_1
    //   501: aload_2
    //   502: astore 6
    //   504: aload 7
    //   506: astore_2
    //   507: goto -111 -> 396
    //   510: goto -327 -> 183
    //   513: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	hx
    //   0	514	1	paramString1	String
    //   0	514	2	paramString2	String
    //   10	369	3	i1	int
    //   111	6	4	i2	int
    //   290	3	5	bool	boolean
    //   25	455	6	localObject1	Object
    //   487	12	6	localException1	Exception
    //   502	1	6	str1	String
    //   1	1	7	localObject2	Object
    //   385	8	7	localException2	Exception
    //   466	5	7	localObject3	Object
    //   476	29	7	localObject4	Object
    //   4	457	8	localObject5	Object
    //   7	330	9	str2	String
    //   57	86	10	str3	String
    //   68	12	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   188	193	202	java/lang/Exception
    //   197	201	202	java/lang/Exception
    //   302	307	308	java/lang/Exception
    //   323	363	385	java/lang/Exception
    //   363	370	385	java/lang/Exception
    //   375	382	385	java/lang/Exception
    //   405	409	418	java/lang/Exception
    //   413	417	418	java/lang/Exception
    //   11	78	424	finally
    //   79	113	424	finally
    //   125	170	424	finally
    //   208	224	424	finally
    //   436	441	451	java/lang/Exception
    //   445	449	451	java/lang/Exception
    //   224	292	459	finally
    //   314	323	459	finally
    //   323	363	466	finally
    //   363	370	466	finally
    //   375	382	466	finally
    //   396	401	476	finally
    //   11	78	487	java/lang/Exception
    //   79	113	487	java/lang/Exception
    //   125	170	487	java/lang/Exception
    //   208	224	487	java/lang/Exception
    //   224	292	497	java/lang/Exception
    //   314	323	497	java/lang/Exception
  }
  
  private void d()
  {
    if (this.a == null) {
      return;
    }
    Camera.Parameters localParameters;
    DisplayMetrics localDisplayMetrics;
    int i2;
    int i3;
    Object localObject1;
    for (;;)
    {
      try
      {
        localParameters = this.a.getParameters();
        localParameters.setPictureFormat(256);
        localParameters.setPreviewFormat(17);
        List localList = localParameters.getSupportedPreviewSizes();
        if (this.y.getResources().getConfiguration().orientation != 2)
        {
          localParameters.set("orientation", "portrait");
          localParameters.set("rotation", 90);
          this.a.setDisplayOrientation(90);
          if ((Build.MODEL.equals("Nexus 6")) || (Build.MODEL.toLowerCase().startsWith("nexus 6")) || (Build.MODEL.equals("Moto X Pro"))) {
            this.a.setDisplayOrientation(270);
          }
          if (ei.f != -1) {
            this.a.setDisplayOrientation(ei.f);
          }
          localDisplayMetrics = this.y.getResources().getDisplayMetrics();
          i2 = localDisplayMetrics.heightPixels;
          i3 = localDisplayMetrics.widthPixels;
          if (localList == null) {
            break;
          }
          this.b = ((Camera.Size)localList.get(0)).width;
          this.c = ((Camera.Size)localList.get(0)).height;
          int i1 = 1;
          if (i1 >= localList.size()) {
            break label417;
          }
          if (Math.abs(this.b / this.c - i2 / i3) > Math.abs(((Camera.Size)localList.get(i1)).width / ((Camera.Size)localList.get(i1)).height - i2 / i3))
          {
            this.b = ((Camera.Size)localList.get(i1)).width;
            this.c = ((Camera.Size)localList.get(i1)).height;
          }
          i1 += 1;
          continue;
        }
        localParameters.set("orientation", "landscape");
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        com.tencent.token.global.e.c("Camera getParameters failed" + this.a);
        localObject1 = this.t.obtainMessage(0);
        ((Message)localObject1).what = 2;
        ((Message)localObject1).sendToTarget();
        return;
      }
      this.a.setDisplayOrientation(0);
    }
    label417:
    localParameters.setPreviewSize(this.b, this.c);
    this.a.setParameters(localParameters);
    this.a.setPreviewCallback(this);
    try
    {
      this.a.setPreviewDisplay(this.z);
      this.a.startPreview();
      cv.c = this.c + "*" + this.b;
      this.u[0] = 0;
      this.u[1] = ((int)(FaceView.b * this.b));
      this.u[2] = this.c;
      float f1 = FaceView.d * this.b;
      this.u[3] = ((int)(1.4F * f1));
      this.u[1] = ((int)(this.u[1] - f1 * 0.2F));
      if ((this.u[3] >= this.b) || (this.u[1] < 0))
      {
        this.u[1] = 0;
        this.u[3] = this.b;
      }
      str1 = localParameters.get("rotation");
      str2 = Build.MODEL;
      if ((str2.startsWith("8150")) || (this.w == 0) || (str2.equals("Nexus 6")))
      {
        localObject1 = "270";
        this.B = Integer.parseInt((String)localObject1);
        if (ei.g != -1) {
          this.B = ei.g;
        }
        com.tencent.token.global.e.c("debugjsonjson------------mPreviewWidth=" + this.b + ",mPreviewHeight=" + this.c + ", screenWidth=" + i2 + ",screenHeight=" + i3 + ",density=" + localDisplayMetrics.density + ", faceposition" + this.u[0] + ", " + this.u[1] + ", " + this.u[2] + "," + this.u[3] + ", rotation=" + localParameters.get("rotation") + ",angleangle=" + this.B);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str1;
        String str2;
        localException2.printStackTrace();
        if (this.a != null)
        {
          this.a.setPreviewCallback(null);
          this.a.release();
          this.a = null;
          continue;
          Object localObject2 = str1;
          if (str1 != null) {
            if (!str2.contains("MI 5"))
            {
              localObject2 = str1;
              if (this.b > this.c)
              {
                localObject2 = str1;
                if (Integer.valueOf(str1).intValue() >= 90) {}
              }
            }
            else
            {
              localObject2 = "90";
            }
          }
        }
      }
    }
  }
  
  public final void a()
  {
    int i2 = 0;
    if (this.a != null) {
      return;
    }
    int i3;
    try
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      i3 = Camera.getNumberOfCameras();
      i1 = 0;
      for (;;)
      {
        if (i1 < i3)
        {
          Camera.getCameraInfo(i1, localCameraInfo);
          int i4 = localCameraInfo.facing;
          if (i4 == 1) {}
          try
          {
            this.a = Camera.open(i1);
            this.w = 1;
            i1 += 1;
          }
          catch (RuntimeException localRuntimeException1)
          {
            for (;;)
            {
              com.tencent.token.global.e.c("CameraOpen camera=" + this.a);
            }
          }
        }
      }
      if (this.a != null) {
        break label189;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    int i1 = i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Camera.getCameraInfo(i1, localException);
        i2 = localException.facing;
        if (i2 == 0) {}
        try
        {
          this.a = Camera.open(i1);
          this.w = 0;
          i1 += 1;
        }
        catch (RuntimeException localRuntimeException2)
        {
          for (;;)
          {
            com.tencent.token.global.e.c("CameraOpen camera=" + this.a);
          }
        }
      }
    }
    label189:
    if (this.a == null)
    {
      com.tencent.token.global.e.c("CameraOpen camera=" + this.a);
      Message localMessage = this.t.obtainMessage(0);
      localMessage.what = 2;
      localMessage.sendToTarget();
    }
    d();
  }
  
  public final void a(FaceServiceDelegate.FaceDetectErrorCode paramFaceDetectErrorCode)
  {
    if (this.F != null) {}
    switch (ia.a[paramFaceDetectErrorCode.ordinal()])
    {
    case 1: 
    default: 
      return;
    case 2: 
    case 3: 
      this.F.setText(2131362782);
      return;
    case 4: 
    case 5: 
      this.F.setText(2131362796);
      return;
    case 6: 
      this.F.setText(2131362793);
      return;
    }
    this.F.setText(2131362792);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    this.r = paramBoolean1;
    this.C = paramInt1;
    this.D = paramInt2;
    if (paramBoolean1)
    {
      if (this.A != DetectType.DT_REGISTER) {
        break label237;
      }
      if ((this.D == 0) && (paramBoolean2)) {
        p.a().a(System.currentTimeMillis(), 145);
      }
    }
    switch (this.C)
    {
    default: 
      return;
    case 1: 
      p.a().a(System.currentTimeMillis(), 149);
      this.h = FaceDetector.LiveAction.ACT_MOUTH_OPEN;
      this.K = this.y.getResources().getString(2131362783);
      return;
    case 2: 
      p.a().a(System.currentTimeMillis(), 148);
      this.h = FaceDetector.LiveAction.ACT_BLINK;
      this.K = this.y.getResources().getString(2131362784);
      return;
    case 3: 
      p.a().a(System.currentTimeMillis(), 146);
      this.h = FaceDetector.LiveAction.ACT_HEAD_NOD;
      this.K = this.y.getResources().getString(2131362785);
      return;
    }
    p.a().a(System.currentTimeMillis(), 147);
    this.h = FaceDetector.LiveAction.ACT_HEAD_SHAKE;
    this.K = this.y.getResources().getString(2131362786);
    return;
    label237:
    p.a().a(System.currentTimeMillis(), 150);
    switch (this.C)
    {
    }
    for (;;)
    {
      this.g.setDirection(this.i.ordinal());
      return;
      p.a().a(System.currentTimeMillis(), 151);
      this.i = FaceDetector.LiveDirection.LD_UP;
      this.K = this.y.getResources().getString(2131362787);
      continue;
      p.a().a(System.currentTimeMillis(), 152);
      this.i = FaceDetector.LiveDirection.LD_DOWN;
      this.K = this.y.getResources().getString(2131362788);
      continue;
      p.a().a(System.currentTimeMillis(), 153);
      this.i = FaceDetector.LiveDirection.LD_LEFT;
      this.K = this.y.getResources().getString(2131362789);
      continue;
      p.a().a(System.currentTimeMillis(), 154);
      this.i = FaceDetector.LiveDirection.LD_RIGHT;
      this.K = this.y.getResources().getString(2131362790);
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt)
  {
    cv.e = (int)(System.currentTimeMillis() - this.m);
    cv.g = paramInt;
    if (this.t == null) {
      return;
    }
    Message localMessage = this.t.obtainMessage(0);
    localMessage.what = 11;
    FaceData localFaceData = new FaceData();
    localFaceData.mOriginDataPath = null;
    localFaceData.mUploadData = paramArrayOfByte;
    localMessage.obj = localFaceData;
    localMessage.sendToTarget();
    this.p = true;
  }
  
  public final void b()
  {
    this.y = null;
    this.t = null;
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
          if (this.x != null)
          {
            this.x.b();
            this.x = null;
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
  
  public final void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public final void c()
  {
    this.s = 0L;
  }
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.p) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.s == 0L)
            {
              this.s = System.currentTimeMillis();
              return;
            }
          } while (this.I);
          if ((this.x == null) && (!this.I)) {
            new Thread(new hy(this)).start();
          }
        } while (this.I);
        if ((this.a != null) && (this.x != null) && (!this.k))
        {
          com.tencent.token.global.e.b("onPreviewFramestart");
          this.k = true;
          this.x.a();
        }
        if (!this.q) {
          break;
        }
      } while (System.currentTimeMillis() - this.s < this.o);
      this.m = System.currentTimeMillis();
      this.L += 1;
    } while (this.L % 3 != 0);
    if (paramCamera != null) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          Object localObject = paramCamera.getParameters();
          localObject = new h(paramArrayOfByte, ((Camera.Parameters)localObject).getPreviewSize().width, ((Camera.Parameters)localObject).getPreviewSize().height, this.B, this.u, this.v);
          this.x.a((h)localObject, this.A);
          cv.g += 1;
          if ((!this.r) || (this.J)) {
            break;
          }
          if ((!this.l) && (!this.J))
          {
            this.J = true;
            new Thread(new hz(this)).start();
          }
          if (this.J) {
            break;
          }
          try
          {
            this.L += 1;
            if (this.L % 2 != 0) {
              break;
            }
            if (this.A == DetectType.DT_REGISTER) {
              if (this.D == 0)
              {
                cv.k += 1;
                paramCamera = paramCamera.getParameters();
                i1 = paramCamera.getPreviewSize().width;
                i2 = paramCamera.getPreviewSize().height;
                this.f.reset();
                i1 = FaceDetector.LiveActionDetect(this.f, paramArrayOfByte, i1, i2, this.B, this.h);
                com.tencent.token.global.e.a("regregret: " + i1 + ", x=" + this.f.x() + ",y=" + this.f.y() + ",width=" + this.f.width() + ",height=" + this.f.height() + ",action=" + this.h);
                switch (i1)
                {
                case 0: 
                  l1 = System.currentTimeMillis();
                  if (this.D == 0)
                  {
                    cv.i = (int)(l1 - this.n);
                    switch (this.C)
                    {
                    case 1: 
                      if (((this.h == FaceDetector.LiveAction.ACT_MOUTH_OPEN) || (this.h == FaceDetector.LiveAction.ACT_BLINK)) && (this.E != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
                        this.E.a(this.f, this.c, this.b);
                      }
                      paramArrayOfByte = this.t.obtainMessage(0);
                      paramArrayOfByte.what = 71;
                      paramArrayOfByte.sendToTarget();
                      this.p = true;
                      return;
                    }
                  }
                  break;
                }
              }
            }
          }
          catch (OutOfMemoryError paramArrayOfByte)
          {
            com.tencent.token.global.e.c("OutOfMemoryError:doLiveDetect");
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        long l1;
        com.tencent.token.global.e.c("OutOfMemoryError:doFaceDetect");
        continue;
        cv.l += 1;
        continue;
        p.a().a(System.currentTimeMillis(), 135);
        cv.j = (int)(l1 - this.n);
        continue;
        p.a().a(l1, 139);
        continue;
        p.a().a(l1, 138);
        continue;
        p.a().a(l1, 136);
        continue;
        p.a().a(l1, 137);
        continue;
        paramArrayOfByte = this.t.obtainMessage(0);
        paramArrayOfByte.what = 73;
        paramArrayOfByte.sendToTarget();
        this.p = true;
        return;
        if ((this.h != FaceDetector.LiveAction.ACT_MOUTH_OPEN) && (this.h != FaceDetector.LiveAction.ACT_BLINK)) {
          break;
        }
        if ((this.E != null) && (this.f.x() > 0) && (this.f.y() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
          this.E.a(this.f, this.c, this.b);
        }
        if ((this.F == null) || (this.F.getText().toString().equals(this.K))) {
          break;
        }
        this.F.setText(this.K);
        return;
        if (this.F == null) {
          break;
        }
        this.F.setText(2131362795);
        return;
        if (this.F == null) {
          break;
        }
        this.F.setText(2131362794);
        return;
        if (this.F == null) {
          break;
        }
        this.F.setText(2131362796);
        return;
        if ((this.F == null) || (this.F.getText().toString().equals(this.K))) {
          break;
        }
        this.F.setText(this.K);
        return;
        cv.n += 1;
        paramCamera = paramCamera.getParameters();
        int i1 = paramCamera.getPreviewSize().width;
        int i2 = paramCamera.getPreviewSize().height;
        i1 = FaceDetector.LiveDirectionDetect(this.g, paramArrayOfByte, i1, i2, this.B);
        double d1 = this.g.angle();
        switch (i1)
        {
        case 0: 
          if (i1 == 0) {
            break;
          }
          if ((this.i == FaceDetector.LiveDirection.LD_UP) || (this.i == FaceDetector.LiveDirection.LD_LEFT))
          {
            if ((d1 >= 0.0D) || (d1 <= -21.0D) || (this.E == null)) {
              break;
            }
            this.E.b(-new Double(d1).intValue());
            return;
            l1 = System.currentTimeMillis();
            p.a().a(l1, 140);
            cv.m = (int)(l1 - this.n);
            switch (this.C)
            {
            case 1: 
              paramArrayOfByte = this.t.obtainMessage(0);
              paramArrayOfByte.what = 71;
              paramArrayOfByte.obj = Double.valueOf(this.g.angle());
              paramArrayOfByte.sendToTarget();
              this.p = true;
              this.E.c();
              continue;
              p.a().a(l1, 141);
              break;
            case 2: 
              p.a().a(l1, 142);
              break;
            case 3: 
              p.a().a(l1, 143);
              break;
            case 4: 
              p.a().a(l1, 144);
            }
          }
          break;
        case 1: 
        case 2: 
        case 6: 
          if ((this.F == null) || (this.F.getText().toString().equals(this.K))) {
            continue;
          }
          this.F.setText(this.K);
          break;
        case 3: 
          if (this.F == null) {
            continue;
          }
          this.F.setText(2131362795);
          break;
        case 4: 
          if (this.F == null) {
            continue;
          }
          this.F.setText(2131362794);
          break;
        case 5: 
          if (this.F == null) {
            continue;
          }
          this.F.setText(2131362796);
          continue;
          if ((d1 <= 0.0D) || (d1 >= 21.0D) || (this.E == null)) {
            break;
          }
          this.E.b(new Double(d1).intValue());
          return;
        }
      }
      catch (Exception localException)
      {
        continue;
        return;
      }
      continue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hx
 * JD-Core Version:    0.7.0.1
 */