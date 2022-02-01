package com.tencent.mobileqq.ar.arengine;

import adii;
import adii.a;
import adii.b;
import adii.c;
import alab;
import android.graphics.PointF;
import android.os.Environment;
import anjg;
import atao;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class ARLocalGestureCircleRecog
{
  private static boolean bNr;
  private static boolean loadSoSuccess;
  private long Tm;
  private long Tn;
  private long To;
  private long Tp;
  private long Tq;
  private long Tr;
  PointF Y = new PointF(-1.0F, -1.0F);
  private AVGestureWrapper jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper;
  private ProcessWorker jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker;
  private a jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$a;
  private adii b = new adii();
  private boolean bNq;
  String bsR = Environment.getExternalStorageDirectory().getPath() + File.separator + "ar_cloud_img/";
  PointF[] c = new PointF[100];
  private int cGs = 480;
  private int cGt = 640;
  int cGu = 0;
  private Object cZ = new Object();
  private Object da = new Object();
  private boolean mIsInited;
  private boolean mIsPause;
  private boolean mIsStarted;
  
  public static PointF a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF)
  {
    return new PointF(paramInt3 - paramPointF.y / paramInt2 * paramInt3, paramPointF.x / paramInt1 * paramInt4);
  }
  
  /* Error */
  public static boolean aex()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 61	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   12: invokestatic 133	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   15: invokevirtual 137	com/tencent/sveffects/SdkContext:getResources	()Lcom/tencent/mobileqq/shortvideo/resource/Resources;
    //   18: invokeinterface 143 1 0
    //   23: invokeinterface 148 1 0
    //   28: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 81	java/io/File:separator	Ljava/lang/String;
    //   34: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 70	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 154	java/io/File:exists	()Z
    //   54: ifne +33 -> 87
    //   57: ldc 156
    //   59: iconst_2
    //   60: new 61	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   67: ldc 158
    //   69: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: ldc 2
    //   84: monitorexit
    //   85: iload_0
    //   86: ireturn
    //   87: ldc 156
    //   89: iconst_2
    //   90: new 61	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   97: ldc 169
    //   99: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_1
    //   113: aload_1
    //   114: aload_1
    //   115: invokestatic 175	com/tencent/av/avgesture/AVGestureWrapper:setFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_1
    //   120: invokestatic 179	com/tencent/av/avgesture/AVGestureWrapper:setGlobalConfigFile	(Ljava/lang/String;)Z
    //   123: pop
    //   124: new 181	adih
    //   127: dup
    //   128: invokespecial 182	adih:<init>	()V
    //   131: invokestatic 186	com/tencent/av/avgesture/AVGestureWrapper:setAVGestureReport	(Lcom/tencent/av/avgesture/AVGestureWrapper$AVUploadReport;)V
    //   134: iconst_0
    //   135: invokestatic 190	com/tencent/av/avgesture/AVGestureWrapper:setShouldUpload	(Z)V
    //   138: iconst_1
    //   139: putstatic 192	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:bNr	Z
    //   142: ldc 156
    //   144: iconst_2
    //   145: ldc 194
    //   147: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: getstatic 192	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:bNr	Z
    //   153: istore_0
    //   154: goto -72 -> 82
    //   157: astore_1
    //   158: iconst_0
    //   159: putstatic 192	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:bNr	Z
    //   162: ldc 156
    //   164: iconst_2
    //   165: new 61	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   172: ldc 196
    //   174: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 199	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: goto -40 -> 150
    //   193: astore_1
    //   194: ldc 2
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: iconst_0
    //   201: putstatic 192	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:bNr	Z
    //   204: ldc 156
    //   206: iconst_2
    //   207: new 61	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   214: ldc 201
    //   216: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_1
    //   220: invokevirtual 202	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: goto -82 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	153	0	bool	boolean
    //   40	80	1	str	String
    //   157	21	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   193	5	1	localObject	Object
    //   199	21	1	localException	Exception
    //   49	54	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	82	157	java/lang/UnsatisfiedLinkError
    //   87	150	157	java/lang/UnsatisfiedLinkError
    //   5	82	193	finally
    //   87	150	193	finally
    //   150	154	193	finally
    //   158	190	193	finally
    //   200	232	193	finally
    //   5	82	199	java/lang/Exception
    //   87	150	199	java/lang/Exception
  }
  
  private void cRO()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "delete backup file.");
    Object localObject1 = new File(this.bsR);
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int i = 0;
        while (i < localObject1.length)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.exists()) {
            localObject2.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean loadSo()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        boolean bool2 = anjg.axx();
        boolean bool3 = SdkContext.getInstance().getResources().getGestureResource().isGestureEnable();
        if ((!bool2) || (!bool3))
        {
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. isGestureResourceReady = " + bool2 + ", isGestureEnable = " + bool3);
          return bool1;
        }
        String str1 = SdkContext.getInstance().getResources().getGestureResource().getSoPathDir();
        str1 = str1 + "libAVGesture4Android" + ".so";
        if (!new File(str1).exists())
        {
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. so not exist. soFilename = " + str1);
          continue;
        }
        str3 = alab.getFileMD5String(str2);
      }
      finally {}
      String str3;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so... md5FromCalc = " + str3);
      try
      {
        System.load(str2);
        loadSoSuccess = true;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so ok. soFilename = " + str2 + ", SDKVersion = " + AVGestureWrapper.getVersionInfo());
        bool1 = loadSoSuccess;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          loadSoSuccess = false;
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. err = " + localThrowable.getMessage());
        }
      }
    }
  }
  
  float a(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    float f1 = Math.abs(paramPointF1.x - paramPointF2.x);
    float f2 = Math.abs(paramPointF1.y - paramPointF2.y);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  int a(PointF[] paramArrayOfPointF, int paramInt1, int[] paramArrayOfInt, int paramInt2, adii.a parama)
  {
    int i = 1;
    if (!parama.bNu) {
      i = -1;
    }
    float f2 = i * 360.0F / paramInt2;
    float f3 = (float)(f2 / 180.0F * 3.141592653589793D);
    float f1 = (float)Math.abs(180.0F * f3 / 3.141592653589793D);
    if (i == -1) {}
    for (i = 0;; i = 360)
    {
      PointF localPointF2 = new PointF(parama.x - parama.r, parama.y);
      new PointF(parama.x, parama.y);
      f1 = i;
      int k = 0;
      int j = paramInt1;
      paramInt1 = k;
      if (paramInt1 < paramInt2)
      {
        if (paramInt1 == 0) {}
        for (PointF localPointF1 = new PointF(localPointF2.x - parama.x, localPointF2.y - parama.y);; localPointF1 = new PointF(paramArrayOfPointF[(j - 1)].x - parama.x, paramArrayOfPointF[(j - 1)].y - parama.y))
        {
          PointF localPointF3 = new PointF(0.0F, 0.0F);
          localPointF3.x = ((float)(Math.cos(f3) * localPointF1.x - Math.sin(f3) * localPointF1.y) + parama.x);
          localPointF3.y = ((float)(Math.sin(f3) * localPointF1.x + Math.cos(f3) * localPointF1.y) + parama.y);
          paramArrayOfPointF[j] = localPointF3;
          k = (int)(Math.random() * 210.0D + 30.0D);
          paramArrayOfInt[j] = (((int)f1 - k + 360) % 360);
          j += 1;
          paramInt1 += 1;
          f1 -= f2;
          break;
        }
      }
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "genCirclePoints4. pointCnt = " + j + ", newCnt = " + paramInt1 + ", radianInc = " + f3 + ", startDegree = " + i + ", startP.x = " + localPointF2.x + ", startP.y = " + localPointF2.y + ", circle.x = " + parama.x + ", circle.y = " + parama.y);
      return j;
    }
  }
  
  adii.a a(PointF[] paramArrayOfPointF, int paramInt)
  {
    if (paramInt < 3) {
      return null;
    }
    return a(paramArrayOfPointF, paramInt - 1, paramArrayOfPointF[(paramInt - 1)]);
  }
  
  adii.a a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF)
  {
    int j = paramInt + 1;
    if (j < 3) {
      return null;
    }
    adii.a locala = new adii.a();
    double d9 = 0.0D;
    double d8 = 0.0D;
    double d7 = 0.0D;
    double d6 = 0.0D;
    double d4 = 0.0D;
    double d2 = 0.0D;
    double d5 = 0.0D;
    double d3 = 0.0D;
    double d1 = 0.0D;
    int i = 0;
    while (i < paramInt)
    {
      d12 = paramArrayOfPointF[i].x;
      d10 = paramArrayOfPointF[i].y;
      d11 = d12 * d12;
      d13 = d10 * d10;
      d9 += d12;
      d8 += d10;
      d7 += d11;
      d6 += d13;
      d4 += d11 * d12;
      d2 += d13 * d10;
      d5 += d12 * d10;
      d3 += d12 * d13;
      d1 += d11 * d10;
      i += 1;
    }
    double d13 = paramPointF.x;
    double d10 = paramPointF.y;
    double d11 = d13 * d13;
    double d12 = d10 * d10;
    d9 += d13;
    d8 += d10;
    d7 += d11;
    d6 += d12;
    double d14 = j * d7 - d9 * d9;
    d5 = (d5 + d13 * d10) * j - d9 * d8;
    double d15 = j;
    d3 = (d3 + d13 * d12) * j + (d4 + d11 * d13) * d15 - (d7 + d6) * d9;
    d4 = j * d6 - d8 * d8;
    d2 = (d1 + d11 * d10) * j + (d2 + d12 * d10) * j - (d7 + d6) * d8;
    d1 = (d2 * d5 - d3 * d4) / (d14 * d4 - d5 * d5);
    d2 = (d2 * d14 - d3 * d5) / (d5 * d5 - d4 * d14);
    d3 = -(d1 * d9 + d2 * d8 + d7 + d6) / j;
    locala.x = ((float)d1 / -2.0F);
    locala.y = ((float)d2 / -2.0F);
    locala.r = ((float)Math.sqrt(d2 * d2 + d1 * d1 - d3 * 4.0D) / 2.0F);
    j = 0;
    int m = 0;
    i = 0;
    PointF localPointF1;
    PointF localPointF2;
    float f2;
    float f1;
    label587:
    int k;
    if (m < paramInt - 1 + 1)
    {
      localPointF1 = new PointF(locala.x, locala.y);
      localPointF2 = new PointF(locala.x + locala.r, locala.y);
      f2 = b(localPointF1, localPointF2, paramArrayOfPointF[m]);
      if (m != paramInt - 1)
      {
        f1 = b(localPointF1, localPointF2, paramArrayOfPointF[(m + 1)]);
        if ((270.0F <= f2) && (f2 <= 360.0F) && (0.0F <= f1) && (f1 <= 90.0F)) {
          break label879;
        }
        if ((270.0F > f1) || (f1 > 360.0F) || (0.0F > f2) || (f2 > 90.0F)) {
          break label702;
        }
        k = j;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      m += 1;
      k = i;
      i = j;
      j = k;
      break;
      f1 = b(localPointF1, localPointF2, paramPointF);
      break label587;
      label702:
      k = i;
      if (f1 > f2) {
        k = i + 1;
      }
      i = j + 1;
      j = k;
      continue;
      boolean bool;
      if (j > 0) {
        if (i > j / 2.0F) {
          bool = true;
        }
      }
      for (;;)
      {
        locala.bNu = bool;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "fitCircle. centerX = " + locala.x + ", centerY = " + locala.y + ", r = " + locala.r + ", isClockwise = " + locala.bNu + ", clockWiseCnt = " + i + ", usedPointCnt = " + j + ", pointCnt = " + paramInt);
        return locala;
        bool = false;
        continue;
        bool = true;
      }
      label879:
      k = i;
      i = j;
      j = k;
    }
  }
  
  adii.c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    adii.c localc = new adii.c(1);
    boolean bool = false;
    PointF[] arrayOfPointF = new PointF[1];
    arrayOfPointF[0] = new PointF(-1.0F, -1.0F);
    for (;;)
    {
      synchronized (this.da)
      {
        if (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper != null)
        {
          bool = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.doCalc(paramArrayOfByte, paramInt1, paramInt2, 2, 270, paramBoolean);
          localc.bNv = bool;
          localc.type = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getGestureType();
          arrayOfPointF[0] = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getKeyPointByName("finger");
          if ((bool) && (arrayOfPointF[0].x > 0.0F) && (arrayOfPointF[0].y > 0.0F))
          {
            if (!paramBoolean) {
              break label434;
            }
            if (localc.type.equalsIgnoreCase("finger1")) {
              break label439;
            }
            break label434;
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. doCalc. isSuccess = " + paramBoolean + ", res = " + bool + ", type = " + localc.type + ", x = " + arrayOfPointF[0].x + ", y = " + arrayOfPointF[0].y);
            bool = paramBoolean;
          }
        }
        else
        {
          if (!bool) {
            break label377;
          }
          paramArrayOfByte = localc.b;
          paramInt1 = localc.cGv;
          localc.cGv = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = new PointF(arrayOfPointF[0].x, arrayOfPointF[0].y);
          localc.mode = 0;
          localc.state = 0;
          localc.cFS = ((int)(System.currentTimeMillis() - l));
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. gestureResult = " + localc + ", TotalTime = " + localc.cFS);
          return localc;
        }
        paramBoolean = false;
      }
      label377:
      localc.type = "";
      paramArrayOfByte = localc.b;
      paramInt1 = localc.cGv;
      localc.cGv = (paramInt1 + 1);
      paramArrayOfByte[paramInt1] = new PointF(-1.0F, -1.0F);
      localc.mode = -1;
      localc.state = -1;
      continue;
      label434:
      if (!paramBoolean) {
        label439:
        paramBoolean = true;
      }
    }
  }
  
  adii a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.jdField_a_of_type_Adii$b.lastState = this.b.jdField_a_of_type_Adii$b.state;
    this.b.jdField_a_of_type_Adii$b.cGw = this.b.jdField_a_of_type_Adii$b.cGv;
    if ((!this.mIsStarted) || (this.b.jdField_a_of_type_Adii$b.cGv >= 999))
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. mRecogResult.circleResult.pointCnt >= ARLocalGestureCircleRecogResult.MAX_POINT_CNT - 1.");
      return this.b;
    }
    if (this.b.jdField_a_of_type_Adii$c.cGv >= 999)
    {
      this.b.jdField_a_of_type_Adii$c.cGv = 0;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. reset gesture result point cnt.");
    }
    if (this.b.jdField_a_of_type_Adii$b.state == 0)
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. state == ARCircleResult.CIRCLE_STATE_SUCCESS.");
      return this.b;
    }
    boolean bool;
    Object localObject1;
    float f1;
    float f3;
    if ((this.b.jdField_a_of_type_Adii$b.cGv == 0) || (!this.b.jdField_a_of_type_Adii$c.bNv))
    {
      bool = true;
      localObject1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, bool);
      if (((adii.c)localObject1).state == 0) {}
      this.b.jdField_a_of_type_Adii$c.bNv = ((adii.c)localObject1).bNv;
      if (this.b.jdField_a_of_type_Adii$b.cGv != 0) {
        break label936;
      }
      f1 = -1.0F;
      f3 = -1.0F;
      if (((adii.c)localObject1).state != 0) {
        break label1418;
      }
      this.cGu = 0;
      if (this.Y.x >= 0.0F) {
        break label470;
      }
      this.Y.x = localObject1.b[0].x;
    }
    for (this.Y.y = localObject1.b[0].y;; this.Y.y = localObject1.b[0].y)
    {
      if (this.b.jdField_a_of_type_Adii$b.cGA >= 4) {
        break label524;
      }
      if (f1 > 30)
      {
        paramArrayOfByte = this.b.jdField_a_of_type_Adii$b;
        paramArrayOfByte.cGA += 1;
      }
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + localObject1.b[0].x + ", py = " + localObject1.b[0].y + ", d1 = " + f1 + ", d2 = " + -1.0F + ", gesturePointCnt = " + this.b.jdField_a_of_type_Adii$b.cGA + ", stillPointCnt = " + this.b.jdField_a_of_type_Adii$b.cGB + ", goodPointCnt = " + this.b.jdField_a_of_type_Adii$b.cGC);
      return this.b;
      bool = false;
      break;
      label470:
      f1 = a(this.Y, localObject1.b[0]);
      this.Y.x = localObject1.b[0].x;
    }
    label524:
    if (this.b.jdField_a_of_type_Adii$b.cGB < 4)
    {
      if ((f1 < 0.0F) || (f1 >= 30)) {
        break label1404;
      }
      paramArrayOfByte = this.b.jdField_a_of_type_Adii$b;
      paramArrayOfByte.cGB += 1;
      if (this.b.jdField_a_of_type_Adii$b.cGB >= 4) {
        this.b.jdField_a_of_type_Adii$b.cGC = 0;
      }
    }
    float f4 = f1;
    float f2 = f3;
    if (this.b.jdField_a_of_type_Adii$b.cGC < 6)
    {
      f2 = f3;
      if (this.b.jdField_a_of_type_Adii$b.cGC != 0)
      {
        f4 = f1;
        f2 = f3;
        if (this.b.jdField_a_of_type_Adii$b.cGC >= 1)
        {
          f4 = f1;
          f2 = f3;
          if (f1 > 30)
          {
            f3 = a(this.c[(this.b.jdField_a_of_type_Adii$b.cGC - 1)], localObject1.b[0]);
            f4 = f1;
            f2 = f3;
            if (f3 > 120) {
              f2 = f3;
            }
          }
        }
      }
      else
      {
        paramArrayOfByte = this.b.jdField_a_of_type_Adii$b;
        paramArrayOfByte.cGC += 1;
        this.c[(this.b.jdField_a_of_type_Adii$b.cGC - 1)] = new PointF(localObject1.b[0].x, localObject1.b[0].y);
        f4 = f1;
      }
    }
    label793:
    label936:
    Object localObject2;
    if ((this.b.jdField_a_of_type_Adii$b.cGA >= 4) && (((this.b.jdField_a_of_type_Adii$b.cGB >= 4) && (this.b.jdField_a_of_type_Adii$b.cGC >= 4)) || (this.b.jdField_a_of_type_Adii$b.cGC >= 6)))
    {
      paramArrayOfByte = a(this.c, this.b.jdField_a_of_type_Adii$b.cGC);
      if (paramArrayOfByte != null)
      {
        this.b.jdField_a_of_type_Adii$b.a.bNu = paramArrayOfByte.bNu;
        a(this.b.jdField_a_of_type_Adii$b.d, 0, this.b.jdField_a_of_type_Adii$b.kw, this.b.jdField_a_of_type_Adii$b.cGx, this.b.jdField_a_of_type_Adii$b.a);
        if ((this.b.jdField_a_of_type_Adii$b.cGv == 0) && (localObject1.b[(localObject1.cGv - 1)].x > 0.0F) && (localObject1.b[(localObject1.cGv - 1)].y > 0.0F) && (!((adii.c)localObject1).type.equalsIgnoreCase("finger1")))
        {
          ((adii.c)localObject1).type = "";
          localObject1.b[(localObject1.cGv - 1)].x = -1.0F;
          localObject1.b[(localObject1.cGv - 1)].y = -1.0F;
          ((adii.c)localObject1).mode = -1;
          ((adii.c)localObject1).state = -1;
        }
        this.b.jdField_a_of_type_Adii$c.cFS = ((adii.c)localObject1).cFS;
        this.b.jdField_a_of_type_Adii$c.type = ((adii.c)localObject1).type;
        paramArrayOfByte = localObject1.b[(localObject1.cGv - 1)];
        if ((paramArrayOfByte.x <= 0.0F) || (paramArrayOfByte.y <= 0.0F)) {
          break label2220;
        }
        this.b.jdField_a_of_type_Adii$c.mode = ((adii.c)localObject1).mode;
        this.b.jdField_a_of_type_Adii$c.state = 0;
        localObject1 = this.b.jdField_a_of_type_Adii$c.b;
        localObject2 = this.b.jdField_a_of_type_Adii$c;
        paramInt1 = ((adii.c)localObject2).cGv;
        ((adii.c)localObject2).cGv = (paramInt1 + 1);
        localObject1[paramInt1] = paramArrayOfByte;
        if (this.b.jdField_a_of_type_Adii$b.cGv != 0) {
          break label1779;
        }
        if ((150.0F >= paramArrayOfByte.x) || (paramArrayOfByte.x >= this.cGs - 150) || (50.0F >= paramArrayOfByte.y) || (paramArrayOfByte.y >= this.cGt - 50)) {
          break label1734;
        }
        localObject1 = this.b.jdField_a_of_type_Adii$b.b;
        localObject2 = this.b.jdField_a_of_type_Adii$b;
        paramInt1 = ((adii.b)localObject2).cGv;
        ((adii.b)localObject2).cGv = (paramInt1 + 1);
        localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
        this.b.jdField_a_of_type_Adii$b.state = 1;
        this.b.jdField_a_of_type_Adii$b.cGC = 0;
        this.Tm = 0L;
        this.Tn = 0L;
        this.Tq = System.currentTimeMillis();
        this.Tr = 0L;
      }
    }
    label1404:
    do
    {
      for (;;)
      {
        paramInt1 = 0;
        if (this.b.jdField_a_of_type_Adii$b.cGz >= this.b.jdField_a_of_type_Adii$b.cGx - 1) {
          paramInt1 = 1;
        }
        if (paramInt1 != 0) {
          this.b.jdField_a_of_type_Adii$b.state = 0;
        }
        return this.b;
        this.b.jdField_a_of_type_Adii$b.cGB = 0;
        break;
        this.cGu += 1;
        if (this.cGu > 13)
        {
          this.b.jdField_a_of_type_Adii$b.cGA = 0;
          this.b.jdField_a_of_type_Adii$b.cGB = 0;
          this.b.jdField_a_of_type_Adii$b.cGC = 0;
          f4 = f1;
          f2 = f3;
          break label793;
        }
        f4 = f1;
        f2 = f3;
        if (this.cGu <= 5) {
          break label793;
        }
        if (this.b.jdField_a_of_type_Adii$b.cGA < 4) {
          this.b.jdField_a_of_type_Adii$b.cGA = 0;
        }
        if (this.b.jdField_a_of_type_Adii$b.cGB < 4) {
          this.b.jdField_a_of_type_Adii$b.cGB = 0;
        }
        f4 = f1;
        f2 = f3;
        if (this.b.jdField_a_of_type_Adii$b.cGC >= 4) {
          break label793;
        }
        this.b.jdField_a_of_type_Adii$b.cGC = 0;
        f4 = f1;
        f2 = f3;
        break label793;
        return this.b;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + localObject1.b[0].x + ", py = " + localObject1.b[0].y + ", d1 = " + f4 + ", d2 = " + f2 + ", gesturePointCnt = " + this.b.jdField_a_of_type_Adii$b.cGA + ", stillPointCnt = " + this.b.jdField_a_of_type_Adii$b.cGB + ", goodPointCnt = " + this.b.jdField_a_of_type_Adii$b.cGC);
        return this.b;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. firstPoint. x = " + paramArrayOfByte.x + ", y = " + paramArrayOfByte.y);
        continue;
        bool = a(this.b.jdField_a_of_type_Adii$b.b, this.b.jdField_a_of_type_Adii$b.cGv, paramArrayOfByte, 20.0F);
        if ((!bool) && ((!bool) && (0 == 0))) {
          break label1863;
        }
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. isRepeat = " + bool + ", isException = " + false);
      }
      if (this.b.jdField_a_of_type_Adii$c.cGv >= 2)
      {
        f1 = a(this.b.jdField_a_of_type_Adii$c.b[(this.b.jdField_a_of_type_Adii$c.cGv - 2)], this.b.jdField_a_of_type_Adii$c.b[(this.b.jdField_a_of_type_Adii$c.cGv - 1)]);
        paramInt1 = 0;
        if (f1 > 50.0F)
        {
          localObject1 = this.b.jdField_a_of_type_Adii$b;
          ((adii.b)localObject1).cGC += 1;
          if (this.Tq != 0L) {
            break label2205;
          }
          this.Tq = System.currentTimeMillis();
          if ((this.Tq == 0L) || (this.Tr == 0L)) {
            break label2215;
          }
        }
      }
      for (paramInt1 = (int)(this.Tr - this.Tq);; paramInt1 = 0)
      {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture dist. dist = " + f1 + ", goodPointCnt = " + this.b.jdField_a_of_type_Adii$b.cGC + ", timeLen = " + paramInt1);
        if ((this.b.jdField_a_of_type_Adii$b.cGC >= 1) && (paramInt1 > 30))
        {
          localObject1 = this.b.jdField_a_of_type_Adii$b.b;
          localObject2 = this.b.jdField_a_of_type_Adii$b;
          paramInt1 = ((adii.b)localObject2).cGv;
          ((adii.b)localObject2).cGv = (paramInt1 + 1);
          localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
          this.b.jdField_a_of_type_Adii$b.cGC = 0;
          this.Tq = System.currentTimeMillis();
          this.Tr = 0L;
        }
        this.Tm = 0L;
        this.Tn = 0L;
        break;
        f1 = a(this.b.jdField_a_of_type_Adii$b.b[(this.b.jdField_a_of_type_Adii$b.cGv - 1)], paramArrayOfByte);
        break label1929;
        this.Tr = System.currentTimeMillis();
        break label1977;
      }
      this.b.jdField_a_of_type_Adii$c.state = -1;
    } while (this.b.jdField_a_of_type_Adii$b.cGv <= 0);
    label1418:
    label1734:
    label1779:
    if (this.Tm == 0L)
    {
      this.Tm = System.currentTimeMillis();
      if ((this.Tm == 0L) || (this.Tn == 0L)) {
        break label2370;
      }
      paramInt1 = (int)(this.Tn - this.Tm);
      if (paramInt1 <= 2000) {
        break label2373;
      }
      paramInt1 = 0;
      if (this.b.jdField_a_of_type_Adii$b.cGz >= this.b.jdField_a_of_type_Adii$b.cGx * 0.8D) {
        paramInt1 = 1;
      }
      if (paramInt1 == 0) {
        break label2375;
      }
    }
    label1863:
    label2260:
    label2289:
    for (this.b.jdField_a_of_type_Adii$b.state = 0;; this.b.jdField_a_of_type_Adii$b.state = -1)
    {
      this.Tm = 0L;
      this.Tn = 0L;
      return this.b;
      this.Tn = System.currentTimeMillis();
      break label2260;
      paramInt1 = 0;
      break label2289;
      break;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, a parama)
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "init. imgW = " + paramInt1 + ", imgH = " + paramInt2);
    if (this.mIsInited) {
      return true;
    }
    this.mIsInited = false;
    this.mIsStarted = false;
    this.bNq = false;
    synchronized (this.da)
    {
      atao.init();
      if ((loadSo()) && (aex()) && (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper == null)) {
        this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper = new AVGestureWrapper();
      }
      this.cGs = paramInt1;
      this.cGt = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$a = parama;
      reset();
      this.mIsInited = true;
      return this.mIsInited;
    }
  }
  
  boolean a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF, float paramFloat)
  {
    if ((paramArrayOfPointF == null) || (paramInt == 0) || (paramPointF == null)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramInt)
      {
        if (a(paramArrayOfPointF[i], paramPointF) < paramFloat) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  float b(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    double d1 = Math.sqrt((paramPointF2.x - paramPointF3.x) * (paramPointF2.x - paramPointF3.x) + (paramPointF2.y - paramPointF3.y) * (paramPointF2.y - paramPointF3.y));
    double d2 = Math.sqrt((paramPointF1.x - paramPointF3.x) * (paramPointF1.x - paramPointF3.x) + (paramPointF1.y - paramPointF3.y) * (paramPointF1.y - paramPointF3.y));
    double d3 = Math.sqrt((paramPointF2.x - paramPointF1.x) * (paramPointF2.x - paramPointF1.x) + (paramPointF2.y - paramPointF1.y) * (paramPointF2.y - paramPointF1.y));
    d1 = Math.acos((d2 * d2 + d3 * d3 - d1 * d1) / (d2 * 2.0D * d3)) * 180.0D / 3.141592653589793D;
    if (paramPointF3.y > paramPointF1.y) {
      return (float)d1;
    }
    return (float)(360.0D - d1);
  }
  
  public boolean isPause()
  {
    return this.mIsPause;
  }
  
  public void k(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.mIsStarted) || (this.mIsPause)) {}
    while (this.b.jdField_a_of_type_Adii$c.mode == 1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker.l(paramLong, paramArrayOfByte);
    }
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. onPreviewFrame");
  }
  
  public void pause()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "pause. mIsPause = " + this.mIsPause);
    if (this.mIsPause) {
      return;
    }
    this.mIsPause = true;
  }
  
  public void reset()
  {
    this.b.reset();
    adii.a locala = new adii.a();
    locala.r = (this.cGt / 4.0F * 1.05F);
    locala.x = (this.cGs / 2 - 100);
    locala.y = (this.cGt / 2);
    locala.bNu = true;
    this.b.jdField_a_of_type_Adii$b.a = locala;
    a(this.b.jdField_a_of_type_Adii$b.d, 0, this.b.jdField_a_of_type_Adii$b.kw, this.b.jdField_a_of_type_Adii$b.cGx, this.b.jdField_a_of_type_Adii$b.a);
    this.Tm = 0L;
    this.Tn = 0L;
    this.To = 0L;
    this.Tp = 0L;
    this.Tq = 0L;
    this.Tr = 0L;
  }
  
  public void resume()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "resume. mIsPause = " + this.mIsPause);
    if (!this.mIsPause) {
      return;
    }
    this.mIsPause = false;
  }
  
  public boolean start()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "start start.");
    if (this.mIsStarted) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker == null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker = new ProcessWorker();
    }
    reset();
    cRO();
    this.mIsStarted = true;
    this.mIsPause = false;
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "start end. mIsStarted = " + this.mIsStarted);
    return true;
  }
  
  public void stop()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "stop start.");
    if (!this.mIsStarted) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker.free();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker = null;
    }
    this.mIsStarted = false;
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "stop end. mIsStarted = " + this.mIsStarted);
  }
  
  public void uninit()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "uninit start.");
    if (!this.mIsInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$a = null;
    synchronized (this.da)
    {
      if (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper != null)
      {
        this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.destroyRecognizor();
        this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper = null;
      }
      this.mIsInited = false;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "uninit end. mIsInited = " + this.mIsInited);
      return;
    }
  }
  
  class ProcessWorker
    extends Thread
  {
    private long Ts;
    private boolean bNs;
    private boolean bNt = true;
    byte[] data = new byte[ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this) * ARLocalGestureCircleRecog.b(ARLocalGestureCircleRecog.this) * 3 / 2];
    
    public ProcessWorker()
    {
      setDaemon(true);
      start();
    }
    
    public void free()
    {
      this.bNt = false;
      if (getState() == Thread.State.WAITING) {
        try
        {
          notify();
          return;
        }
        finally {}
      }
    }
    
    void l(long paramLong, byte[] paramArrayOfByte)
    {
      if (getState() == Thread.State.WAITING)
      {
        System.arraycopy(paramArrayOfByte, 0, this.data, 0, this.data.length);
        this.Ts = paramLong;
        this.bNs = true;
        try
        {
          notify();
          return;
        }
        finally {}
      }
    }
    
    public void run()
    {
      for (;;)
      {
        boolean bool;
        try
        {
          setName("ARLocalGestureCircleRecogProcessWorker");
          if (!this.bNt) {
            break label60;
          }
          if (!this.bNs)
          {
            bool = this.bNt;
            if (bool)
            {
              try
              {
                wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
              continue;
            }
          }
          bool = this.bNt;
        }
        finally {}
        if (!bool) {
          label60:
          return;
        }
        this.bNs = false;
        synchronized (ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this))
        {
          ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this, true);
          try
          {
            adii localadii = ARLocalGestureCircleRecog.this.a(this.data, ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this), ARLocalGestureCircleRecog.b(ARLocalGestureCircleRecog.this), 17);
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. recogResult = " + localadii + ",mRecogResult.gestureResult.mode = " + ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this).a.mode);
            if ((ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this)) && (!ARLocalGestureCircleRecog.b(ARLocalGestureCircleRecog.this)) && (ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this) != null) && (ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this).a.mode == 0)) {
              ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this).a(localadii);
            }
            ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this, false);
            yield();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalGestureCircleRecog", 2, "Exception", localException);
              }
              ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this, false);
            }
          }
          finally
          {
            ARLocalGestureCircleRecog.a(ARLocalGestureCircleRecog.this, false);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(adii paramadii);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog
 * JD-Core Version:    0.7.0.1
 */