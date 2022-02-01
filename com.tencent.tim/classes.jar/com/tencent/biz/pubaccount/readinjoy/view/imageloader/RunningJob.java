package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import anpc;
import aokj;
import aoop;
import aqhu;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptBitmapFile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lgj;
import lgl;
import nor;
import nov;
import nox;
import noy;
import noz;
import npd;
import npe;
import obs;

public class RunningJob
  implements Runnable
{
  public static final String tag = "zimage." + RunningJob.class.getSimpleName();
  File E;
  aokj jdField_a_of_type_Aokj;
  public noz a;
  obs jdField_a_of_type_Obs;
  Set<WeakReference<nox>> ap = new HashSet();
  nor jdField_b_of_type_Nor;
  noy jdField_b_of_type_Noy;
  int baT = 0;
  Handler mHandler = new Handler(Looper.getMainLooper());
  long ya;
  
  public RunningJob(noy paramnoy, noz paramnoz)
  {
    this.jdField_b_of_type_Noy = paramnoy;
    this.jdField_a_of_type_Noz = paramnoz;
    this.jdField_b_of_type_Nor = paramnoy.jdField_b_of_type_Nor;
    this.jdField_a_of_type_Aokj = new aokj(aoop.aW);
    this.ya = System.currentTimeMillis();
  }
  
  private boolean FT()
  {
    return this.jdField_a_of_type_Noz.tryCount < noz.baM;
  }
  
  @TargetApi(11)
  private BitmapFactory.Options a(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte1 = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    try
    {
      if (this.jdField_b_of_type_Nor.kx.size() > 0) {
        arrayOfByte1 = (byte[])this.jdField_b_of_type_Nor.kx.remove(0);
      }
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null)
      {
        arrayOfByte1 = new byte[16384];
        arrayOfByte2 = arrayOfByte1;
        if (QLog.isColorLevel())
        {
          npe.log(tag, "allocate temp storage");
          arrayOfByte2 = arrayOfByte1;
        }
      }
      localOptions.inTempStorage = arrayOfByte2;
      localOptions.inJustDecodeBounds = true;
      localOptions.inJustDecodeBounds = false;
    }
    finally
    {
      try
      {
        BitmapFactory.decodeStream(new BufferedInputStream(paramInputStream), null, localOptions);
        if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
          break label182;
        }
        throw new IllegalArgumentException("decode bounds fail");
      }
      catch (OutOfMemoryError paramInputStream)
      {
        this.jdField_b_of_type_Nor.kx.add(localOptions.inTempStorage);
        throw paramInputStream;
      }
      catch (Exception paramInputStream)
      {
        this.jdField_b_of_type_Nor.kx.add(localOptions.inTempStorage);
        throw paramInputStream;
      }
      paramInputStream = finally;
    }
    label182:
    localOptions.inDither = true;
    localOptions.inPreferredConfig = this.jdField_a_of_type_Noz.d;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    localOptions.inSampleSize = calculateInSampleSize(localOptions, this.jdField_a_of_type_Noz.reqWidth, this.jdField_a_of_type_Noz.reqHeight);
    return localOptions;
  }
  
  private Rect a(BitmapFactory.Options paramOptions)
  {
    int i = Math.min(paramOptions.outWidth, 2048);
    int j = Math.min(paramOptions.outHeight, 2048);
    int k = (paramOptions.outWidth - i) / 2;
    int m = (paramOptions.outHeight - j) / 2;
    return new Rect(k, m, i + k, j + m);
  }
  
  private void a(nov paramnov)
  {
    if (this.jdField_a_of_type_Noz.mIsCancel)
    {
      lgl.a(6, this.jdField_a_of_type_Noz);
      paramnov.close();
      return;
    }
    Iterator localIterator = this.ap.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((nox)localWeakReference.get()).a(this.jdField_a_of_type_Noz, paramnov.a());
      }
    }
    paramnov.close();
  }
  
  private static void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("showUseTime", Long.toString(paramLong));
    if (paramBoolean1)
    {
      str = "1";
      localHashMap.put("cached", str);
      if (!paramBoolean2) {
        break label96;
      }
    }
    label96:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("success", str);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actKandianImageShow", paramBoolean2, paramLong, paramInt, localHashMap, "", true);
      return;
      str = "2";
      break;
    }
  }
  
  private void aZT()
  {
    Object localObject = this.jdField_a_of_type_Noz;
    ((noz)localObject).tryCount += 1;
    QLog.d(tag, 1, "try count: " + this.jdField_a_of_type_Noz.tryCount + " " + this.jdField_a_of_type_Noz);
    localObject = this.ap.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if (localWeakReference.get() != null) {
        this.jdField_b_of_type_Noy.a(this.jdField_a_of_type_Noz, (nox)localWeakReference.get());
      }
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label42;
          }
          m = j;
        }
      }
    }
    label42:
    int k;
    label66:
    do
    {
      do
      {
        return m;
        j = Math.min(paramOptions.outHeight, 2048);
        k = Math.min(paramOptions.outWidth, 2048);
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      i <<= 1;
      k >>= 1;
      j >>= 1;
      break label66;
      n = m;
    }
  }
  
  private void g(Throwable paramThrowable)
  {
    QLog.d(tag, 1, "onFail:", paramThrowable);
    Object localObject2 = this.jdField_a_of_type_Noz;
    Object localObject1;
    if (paramThrowable != null)
    {
      localObject1 = paramThrowable.getMessage();
      lgl.a((noz)localObject2, false, (String)localObject1);
      this.jdField_b_of_type_Noy.g(this.jdField_a_of_type_Noz);
      if (!this.jdField_a_of_type_Noz.mIsCancel) {
        break label69;
      }
      lgl.a(6, this.jdField_a_of_type_Noz);
    }
    for (;;)
    {
      return;
      localObject1 = "";
      break;
      label69:
      if (FT())
      {
        aZT();
        return;
      }
      localObject1 = this.ap.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (((WeakReference)localObject2).get() != null) {
          this.mHandler.post(new RunningJob.4(this, (WeakReference)localObject2, paramThrowable));
        }
      }
    }
  }
  
  private void p(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_Noy.g(this.jdField_a_of_type_Noz);
    paramBitmap = new nov(u(paramBitmap), this.jdField_b_of_type_Nor.jdField_a_of_type_Npc);
    this.jdField_b_of_type_Nor.b(this.jdField_a_of_type_Noz, paramBitmap);
    if (this.jdField_a_of_type_Noz.mIsCancel)
    {
      lgl.a(6, this.jdField_a_of_type_Noz);
      paramBitmap.close();
      return;
    }
    lgl.a(5, this.jdField_a_of_type_Noz);
    if (lgj.Ce())
    {
      this.mHandler.postAtFrontOfQueue(new RunningJob.2(this, paramBitmap));
      return;
    }
    this.mHandler.post(new RunningJob.3(this, paramBitmap));
  }
  
  private Bitmap u(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.jdField_a_of_type_Noz.shape == 1) {
      localBitmap = aqhu.r(paramBitmap, this.jdField_a_of_type_Noz.reqWidth, this.jdField_a_of_type_Noz.reqHeight);
    }
    return localBitmap;
  }
  
  public Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
    throws Exception
  {
    if (npe.FU()) {
      return b(paramInputStream1, paramInputStream2, paramLong);
    }
    return c(paramInputStream1, paramInputStream2, paramLong);
  }
  
  public void a(nox paramnox)
  {
    if (paramnox != null) {}
    try
    {
      this.ap.add(new WeakReference(paramnox));
      return;
    }
    finally
    {
      paramnox = finally;
      throw paramnox;
    }
  }
  
  /* Error */
  @TargetApi(21)
  public Bitmap b(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 432	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore_2
    //   6: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +45 -> 54
    //   12: getstatic 50	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:tag	Ljava/lang/String;
    //   15: new 30	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 434
    //   25: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 77	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Noz	Lnoz;
    //   32: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc_w 436
    //   38: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: getfield 220	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   45: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 154	npe:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   58: aload_2
    //   59: invokevirtual 439	nor:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnull +121 -> 187
    //   69: aload_2
    //   70: aload 6
    //   72: putfield 443	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   75: iconst_1
    //   76: istore 5
    //   78: new 163	java/io/BufferedInputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 166	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_1
    //   87: aload_2
    //   88: invokestatic 446	npe:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   91: ifeq +58 -> 149
    //   94: aload_1
    //   95: iconst_0
    //   96: invokestatic 452	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   99: aload_0
    //   100: aload_2
    //   101: invokespecial 454	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   104: aload_2
    //   105: invokevirtual 458	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   113: getfield 129	nor:kx	Ljava/util/List;
    //   116: aload_2
    //   117: getfield 157	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   120: invokeinterface 189 2 0
    //   125: pop
    //   126: iload 5
    //   128: ifeq +57 -> 185
    //   131: aload 6
    //   133: aload_1
    //   134: if_acmpeq +51 -> 185
    //   137: aload_1
    //   138: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   141: new 465	java/lang/IllegalStateException
    //   144: dup
    //   145: invokespecial 466	java/lang/IllegalStateException:<init>	()V
    //   148: athrow
    //   149: aload_1
    //   150: aconst_null
    //   151: aload_2
    //   152: invokestatic 172	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   155: astore_1
    //   156: goto -47 -> 109
    //   159: astore_1
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   167: getfield 129	nor:kx	Ljava/util/List;
    //   170: aload_2
    //   171: getfield 157	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   174: invokeinterface 189 2 0
    //   179: pop
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_1
    //   184: athrow
    //   185: aload_1
    //   186: areturn
    //   187: iconst_0
    //   188: istore 5
    //   190: goto -112 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	RunningJob
    //   0	193	1	paramInputStream1	InputStream
    //   0	193	2	paramInputStream2	InputStream
    //   0	193	3	paramLong	long
    //   76	113	5	i	int
    //   62	70	6	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   78	109	159	java/lang/OutOfMemoryError
    //   149	156	159	java/lang/OutOfMemoryError
    //   78	109	162	finally
    //   149	156	162	finally
    //   160	162	162	finally
    //   183	185	162	finally
    //   78	109	182	java/lang/RuntimeException
    //   149	156	182	java/lang/RuntimeException
  }
  
  /* Error */
  public Bitmap c(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 9
    //   18: aload_0
    //   19: aload_2
    //   20: invokespecial 432	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   23: astore 13
    //   25: aload 13
    //   27: getstatic 473	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:atK	Z
    //   30: putfield 476	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   33: lload_3
    //   34: l2i
    //   35: istore 5
    //   37: new 163	java/io/BufferedInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 166	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 6
    //   47: aload 6
    //   49: astore_2
    //   50: aload 12
    //   52: astore_1
    //   53: aload 11
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   61: getfield 479	nor:jdField_a_of_type_Not	Lnot;
    //   64: iload 5
    //   66: invokevirtual 485	not:getBuf	(I)[B
    //   69: astore 9
    //   71: aload 6
    //   73: astore_2
    //   74: aload 9
    //   76: astore_1
    //   77: aload 9
    //   79: astore 7
    //   81: aload 9
    //   83: astore 8
    //   85: aload 6
    //   87: aload 9
    //   89: iconst_0
    //   90: iload 5
    //   92: invokevirtual 491	java/io/InputStream:read	([BII)I
    //   95: pop
    //   96: aload 6
    //   98: astore_2
    //   99: aload 9
    //   101: astore_1
    //   102: aload 9
    //   104: astore 7
    //   106: aload 9
    //   108: astore 8
    //   110: aload 13
    //   112: invokestatic 446	npe:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   115: ifeq +126 -> 241
    //   118: aload 6
    //   120: astore_2
    //   121: aload 9
    //   123: astore_1
    //   124: aload 9
    //   126: astore 7
    //   128: aload 9
    //   130: astore 8
    //   132: aload 9
    //   134: iconst_0
    //   135: iload 5
    //   137: iconst_0
    //   138: invokestatic 494	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   141: aload_0
    //   142: aload 13
    //   144: invokespecial 454	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   147: aload 13
    //   149: invokevirtual 458	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   152: astore 10
    //   154: aload 6
    //   156: astore_2
    //   157: aload 9
    //   159: astore_1
    //   160: aload 9
    //   162: astore 7
    //   164: aload 9
    //   166: astore 8
    //   168: getstatic 473	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:atK	Z
    //   171: ifeq +22 -> 193
    //   174: aload 6
    //   176: astore_2
    //   177: aload 9
    //   179: astore_1
    //   180: aload 9
    //   182: astore 7
    //   184: aload 9
    //   186: astore 8
    //   188: aload 10
    //   190: invokestatic 497	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:nativePinBitmap	(Landroid/graphics/Bitmap;)V
    //   193: aload 9
    //   195: ifnull +15 -> 210
    //   198: aload_0
    //   199: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   202: getfield 479	nor:jdField_a_of_type_Not	Lnot;
    //   205: aload 9
    //   207: invokevirtual 501	not:returnBuf	([B)V
    //   210: aload_0
    //   211: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   214: getfield 129	nor:kx	Ljava/util/List;
    //   217: aload 13
    //   219: getfield 157	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   222: invokeinterface 189 2 0
    //   227: pop
    //   228: aload 6
    //   230: ifnull +8 -> 238
    //   233: aload 6
    //   235: invokevirtual 502	java/io/InputStream:close	()V
    //   238: aload 10
    //   240: areturn
    //   241: aload 6
    //   243: astore_2
    //   244: aload 9
    //   246: astore_1
    //   247: aload 9
    //   249: astore 7
    //   251: aload 9
    //   253: astore 8
    //   255: aload 9
    //   257: iconst_0
    //   258: iload 5
    //   260: aload 13
    //   262: invokestatic 506	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   265: astore 10
    //   267: goto -113 -> 154
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   275: aload 10
    //   277: areturn
    //   278: astore 7
    //   280: aconst_null
    //   281: astore_2
    //   282: aload 9
    //   284: astore_1
    //   285: aload 7
    //   287: athrow
    //   288: astore 7
    //   290: aload_1
    //   291: astore 6
    //   293: aload 7
    //   295: astore_1
    //   296: aload 6
    //   298: ifnull +15 -> 313
    //   301: aload_0
    //   302: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   305: getfield 479	nor:jdField_a_of_type_Not	Lnot;
    //   308: aload 6
    //   310: invokevirtual 501	not:returnBuf	([B)V
    //   313: aload_0
    //   314: getfield 82	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_b_of_type_Nor	Lnor;
    //   317: getfield 129	nor:kx	Ljava/util/List;
    //   320: aload 13
    //   322: getfield 157	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   325: invokeinterface 189 2 0
    //   330: pop
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 502	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: athrow
    //   341: astore 8
    //   343: aconst_null
    //   344: astore_2
    //   345: aload 10
    //   347: astore_1
    //   348: aload 8
    //   350: athrow
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   356: goto -17 -> 339
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_2
    //   362: aload 7
    //   364: astore 6
    //   366: goto -70 -> 296
    //   369: astore 8
    //   371: aload 6
    //   373: astore_2
    //   374: aload 7
    //   376: astore_1
    //   377: goto -29 -> 348
    //   380: astore 7
    //   382: aload 6
    //   384: astore_2
    //   385: aload 8
    //   387: astore_1
    //   388: goto -103 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	RunningJob
    //   0	391	1	paramInputStream1	InputStream
    //   0	391	2	paramInputStream2	InputStream
    //   0	391	3	paramLong	long
    //   35	224	5	i	int
    //   45	338	6	localObject1	Object
    //   4	246	7	localObject2	Object
    //   278	8	7	localOutOfMemoryError1	OutOfMemoryError
    //   288	87	7	localObject3	Object
    //   380	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   13	241	8	localObject4	Object
    //   341	8	8	localException1	Exception
    //   369	17	8	localException2	Exception
    //   16	267	9	arrayOfByte	byte[]
    //   7	339	10	localBitmap	Bitmap
    //   10	44	11	localObject5	Object
    //   1	50	12	localObject6	Object
    //   23	298	13	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   233	238	270	java/io/IOException
    //   37	47	278	java/lang/OutOfMemoryError
    //   57	71	288	finally
    //   85	96	288	finally
    //   110	118	288	finally
    //   132	154	288	finally
    //   168	174	288	finally
    //   188	193	288	finally
    //   255	267	288	finally
    //   285	288	288	finally
    //   348	351	288	finally
    //   37	47	341	java/lang/Exception
    //   335	339	351	java/io/IOException
    //   37	47	359	finally
    //   57	71	369	java/lang/Exception
    //   85	96	369	java/lang/Exception
    //   110	118	369	java/lang/Exception
    //   132	154	369	java/lang/Exception
    //   168	174	369	java/lang/Exception
    //   188	193	369	java/lang/Exception
    //   255	267	369	java/lang/Exception
    //   57	71	380	java/lang/OutOfMemoryError
    //   85	96	380	java/lang/OutOfMemoryError
    //   110	118	380	java/lang/OutOfMemoryError
    //   132	154	380	java/lang/OutOfMemoryError
    //   168	174	380	java/lang/OutOfMemoryError
    //   188	193	380	java/lang/OutOfMemoryError
    //   255	267	380	java/lang/OutOfMemoryError
  }
  
  public void cancel()
  {
    if (QLog.isColorLevel()) {
      npe.log(tag, "[cancel request]" + this.jdField_a_of_type_Noz);
    }
    this.jdField_a_of_type_Noz.mIsCancel = true;
    if (this.jdField_a_of_type_Obs != null) {
      this.jdField_a_of_type_Obs.cancel();
    }
  }
  
  @TargetApi(12)
  public void run()
  {
    lgl.a(4, this.jdField_a_of_type_Noz);
    noy.a().h(this.jdField_a_of_type_Noz);
    if (QLog.isColorLevel()) {
      npe.log(tag, "[start request](" + (System.currentTimeMillis() - this.ya) + ")" + this.jdField_a_of_type_Noz + " createTs:" + this.ya);
    }
    Object localObject2;
    boolean bool2;
    long l1;
    try
    {
      if (this.jdField_a_of_type_Noz.mIsCancel)
      {
        lgl.a(6, this.jdField_a_of_type_Noz);
        noy.a().i(this.jdField_a_of_type_Noz);
        return;
      }
      obs localobs = new obs(BaseApplicationImpl.getApplication());
      localObject2 = new DownloadParams();
      ((DownloadParams)localObject2).url = this.jdField_a_of_type_Noz.url;
      ((DownloadParams)localObject2).urlStr = this.jdField_a_of_type_Noz.url.toString();
      this.jdField_a_of_type_Obs = localobs;
      bool2 = localobs.hasDiskFile((DownloadParams)localObject2);
      l1 = System.currentTimeMillis();
      this.E = localobs.loadImageFile((DownloadParams)localObject2, new npd(this, new StringBuilder()));
      if (this.E == null) {
        throw new IOException("downloader fail");
      }
    }
    catch (Throwable localThrowable) {}
    try
    {
      if (localThrowable.getMessage() != null)
      {
        if (((localThrowable instanceof RuntimeException)) && (localThrowable.getMessage().contains("cancel"))) {
          lgl.a(6, this.jdField_a_of_type_Noz);
        }
        for (;;)
        {
          noy.a().i(this.jdField_a_of_type_Noz);
          return;
          long l2 = System.currentTimeMillis();
          long l3 = l2 - l1;
          if (this.jdField_a_of_type_Noz != null) {
            this.jdField_a_of_type_Noz.xW = l3;
          }
          Object localObject1;
          if (QLog.isColorLevel())
          {
            localObject1 = tag;
            localObject2 = new StringBuilder().append("[download success](").append(l3).append(")").append(this.jdField_a_of_type_Noz).append(" fileSize:");
            if (this.E == null) {
              break label1139;
            }
            l1 = this.E.length();
            npe.log((String)localObject1, l1);
          }
          if (this.jdField_a_of_type_Noz.mIsCancel) {
            throw new RuntimeException("cancel");
          }
          if ((this.jdField_a_of_type_Noz.isPreload) && (this.ap.isEmpty()))
          {
            this.jdField_b_of_type_Noy.g(this.jdField_a_of_type_Noz);
            if (QLog.isColorLevel()) {
              npe.log(tag, "[preload request]" + this.jdField_a_of_type_Noz + " no callback, give up decode");
            }
            noy.a().i(this.jdField_a_of_type_Noz);
            return;
          }
          try
          {
            if ((this.E instanceof RIJImageOptBitmapFile))
            {
              localObject2 = new ByteArrayInputStream(((RIJImageOptBitmapFile)this.E).getBytes());
              localObject1 = new ByteArrayInputStream(((RIJImageOptBitmapFile)this.E).getBytes());
            }
            for (l1 = ((RIJImageOptBitmapFile)this.E).getLength();; l1 = this.E.length())
            {
              localObject1 = a((InputStream)localObject2, (InputStream)localObject1, l1);
              l1 = System.currentTimeMillis();
              l2 = l1 - l2;
              if (this.jdField_a_of_type_Noz != null)
              {
                this.jdField_a_of_type_Noz.xX = l2;
                QLog.d(tag, 1, "[decode success](" + l2 + ") total(" + (l1 - this.ya) + ")" + this.jdField_a_of_type_Noz + "; size =" + ((Bitmap)localObject1).getByteCount());
              }
              if (!QLog.isColorLevel()) {
                break label1145;
              }
              npe.log(tag, "[decode success](" + l2 + ") total(" + (l1 - this.ya) + ")" + this.jdField_a_of_type_Noz + "; size =" + ((Bitmap)localObject1).getByteCount());
              break label1145;
              if (!bool1) {
                break label1160;
              }
              i = ((Bitmap)localObject1).getByteCount();
              a(bool2, l2 + l3, i, bool1);
              if (!bool1) {
                break label847;
              }
              p((Bitmap)localObject1);
              break;
              localObject2 = new FileInputStream(this.E);
              localObject1 = new FileInputStream(this.E);
            }
            g(new RuntimeException("bitmap null"));
          }
          catch (Exception localException1)
          {
            throw new RuntimeException("[decode fail]" + localException1.toString());
          }
          label847:
          continue;
          if ((!(localException1 instanceof IOException)) || (!localException1.getMessage().contains("cancel"))) {
            break;
          }
          lgl.a(6, this.jdField_a_of_type_Noz);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        boolean bool1;
        int i;
        localException2.printStackTrace();
        g(localException2);
        continue;
        label1160:
        if ((((localException2 instanceof RuntimeException)) && (localException2.getMessage().contains("decode fail"))) || (((localException2 instanceof IOException)) && (localException2.getMessage().contains("write 0 length file or null File"))))
        {
          if (QLog.isColorLevel()) {
            npe.log(tag, localException2.getMessage() + " " + this.jdField_a_of_type_Noz + " retryCount:" + this.baT);
          }
          if (this.baT == 0)
          {
            this.baT += 1;
            if (this.E != null) {
              this.E.delete();
            }
            run();
          }
          else
          {
            g(localException2);
          }
        }
        else
        {
          g(localException2);
          continue;
          if (QLog.isColorLevel()) {
            npe.log(tag, "[job fail]" + this.jdField_a_of_type_Noz + " " + localException2 + " retryCount:" + this.baT);
          }
          g(localException2);
          continue;
          label1139:
          l1 = 0L;
          continue;
          label1145:
          if (localException2 != null)
          {
            bool1 = true;
          }
          else
          {
            bool1 = false;
            continue;
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob
 * JD-Core Version:    0.7.0.1
 */