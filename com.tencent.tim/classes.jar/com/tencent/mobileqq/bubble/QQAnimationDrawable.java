package com.tencent.mobileqq.bubble;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import aqhu;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@SuppressLint({"NewApi"})
public class QQAnimationDrawable
  extends Drawable
  implements Animatable, Runnable
{
  public static final ExecutorService THREAD_POOL_EXECUTOR = ;
  public static byte[] inTempStorage = new byte[24576];
  private WorkerRunnable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable;
  final a jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$a = new a(this);
  private b jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b;
  private volatile c jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$c = new c(null);
  protected int bIg = -1;
  private boolean bRW = true;
  boolean bRX = true;
  boolean bRY = true;
  private boolean bgP;
  private String bwk;
  private int cLp;
  private int cLq;
  private int cLr;
  private int cLs;
  private int cxD;
  private Object dk = new Object();
  private String[] eA;
  private boolean enableCache = true;
  private Bitmap fa;
  Bitmap fb;
  Bitmap fc;
  private boolean isStart;
  private HashMap<String, SoftReference<Bitmap>> jR = new HashMap();
  private int[] kL;
  private BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
  private boolean mDecodeNextFrameEnd = true;
  private long mDuration;
  private FutureTask<Bitmap> mFuture;
  private Paint mPaint = new Paint(6);
  private int mRepeatCount = 1;
  private Set<SoftReference<Bitmap>> mReusableBitmaps;
  int mTargetDensity = 160;
  private int mType = 2;
  private long py;
  private ArrayList<Bitmap> qB = new ArrayList();
  
  public QQAnimationDrawable()
  {
    this(null);
  }
  
  public QQAnimationDrawable(b paramb)
  {
    if (this.mTargetDensity == 0) {}
    for (;;)
    {
      this.mTargetDensity = i;
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b = paramb;
      if (Build.VERSION.SDK_INT >= 11) {
        this.mReusableBitmaps = Collections.synchronizedSet(new HashSet());
      }
      return;
      i = this.mTargetDensity;
    }
  }
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    long l;
    String str;
    label240:
    label249:
    try
    {
      if (this.eA != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.eA.length)
        {
          l = System.currentTimeMillis();
          str = this.eA[paramInt];
          localObject = paramBitmap;
          if (str != null)
          {
            if (!this.enableCache) {
              break label249;
            }
            localObject = (SoftReference)this.jR.get(str);
            if ((localObject != null) && (((SoftReference)localObject).get() != null))
            {
              paramBitmap = (Bitmap)((SoftReference)localObject).get();
              return paramBitmap;
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inTempStorage = inTempStorage;
      BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      paramInt = EditGifImage.calculateInSampleSize((BitmapFactory.Options)localObject, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        addInBitmapOptions((BitmapFactory.Options)localObject);
      }
      localObject = aqhu.d(str, (BitmapFactory.Options)localObject);
      paramBitmap = (Bitmap)localObject;
      if (localObject != null) {
        paramBitmap = (Bitmap)localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label240;
    }
    try
    {
      if (!((Bitmap)localObject).isRecycled())
      {
        paramBitmap = (Bitmap)localObject;
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.mReusableBitmaps.add(new SoftReference(localObject));
          paramBitmap = (Bitmap)localObject;
        }
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap = localOutOfMemoryError;
      break label240;
    }
    for (localObject = paramBitmap;; localObject = this.fc)
    {
      paramBitmap = (Bitmap)localObject;
      break;
      a(this.fc, l, str);
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong, int paramInt)
  {
    if (paramBitmap == null) {}
    try
    {
      this.mBitmapOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt, this.mBitmapOptions);
      Bitmap.createBitmap(this.mBitmapOptions.outWidth, this.mBitmapOptions.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
    }
    this.mBitmapOptions.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.mBitmapOptions.inBitmap = paramBitmap;
    }
    this.mBitmapOptions.inSampleSize = 1;
    this.mBitmapOptions.inDensity = 320;
    this.mBitmapOptions.inTargetDensity = this.mTargetDensity;
    BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt, this.mBitmapOptions);
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong, String paramString)
  {
    if (paramBitmap == null) {}
    try
    {
      this.mBitmapOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.mBitmapOptions);
      if (QLog.isDevelopLevel()) {
        QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + paramString + " " + this.mBitmapOptions.outWidth + "——" + this.mBitmapOptions.outHeight);
      }
      Bitmap.createBitmap(this.mBitmapOptions.outWidth, this.mBitmapOptions.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
    }
    this.mBitmapOptions.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.mBitmapOptions.inBitmap = paramBitmap;
    }
    this.mBitmapOptions.inSampleSize = 1;
    this.mBitmapOptions.inDensity = 320;
    this.mBitmapOptions.inTargetDensity = this.mTargetDensity;
    BitmapFactory.decodeFile(paramString, this.mBitmapOptions);
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
  }
  
  @TargetApi(11)
  private void addInBitmapOptions(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = getBitmapFromReusableSet(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   7: invokevirtual 361	java/util/ArrayList:size	()I
    //   10: if_icmpge +26 -> 36
    //   13: aload_0
    //   14: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual 364	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 221	android/graphics/Bitmap
    //   24: astore 9
    //   26: aload 9
    //   28: ifnull +8 -> 36
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 9
    //   35: areturn
    //   36: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   45: iconst_1
    //   46: putfield 224	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_0
    //   50: getfield 366	com/tencent/mobileqq/bubble/QQAnimationDrawable:bwk	Ljava/lang/String;
    //   53: aload_0
    //   54: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   57: invokestatic 231	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload_0
    //   62: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   65: getfield 283	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 368	com/tencent/mobileqq/bubble/QQAnimationDrawable:cxD	I
    //   73: i2f
    //   74: fconst_1
    //   75: fmul
    //   76: fdiv
    //   77: f2i
    //   78: istore 5
    //   80: aload_0
    //   81: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   84: getfield 286	android/graphics/BitmapFactory$Options:outHeight	I
    //   87: i2f
    //   88: aload_0
    //   89: getfield 370	com/tencent/mobileqq/bubble/QQAnimationDrawable:cLr	I
    //   92: i2f
    //   93: fconst_1
    //   94: fmul
    //   95: fdiv
    //   96: f2i
    //   97: istore 6
    //   99: aload_0
    //   100: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   103: iconst_0
    //   104: putfield 224	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   107: aload_0
    //   108: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   111: sipush 320
    //   114: putfield 302	android/graphics/BitmapFactory$Options:inDensity	I
    //   117: aload_0
    //   118: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   121: aload_0
    //   122: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:mTargetDensity	I
    //   125: putfield 305	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   128: aload_0
    //   129: getfield 366	com/tencent/mobileqq/bubble/QQAnimationDrawable:bwk	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:mBitmapOptions	Landroid/graphics/BitmapFactory$Options;
    //   136: invokestatic 231	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore 9
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: aload_0
    //   145: getfield 370	com/tencent/mobileqq/bubble/QQAnimationDrawable:cLr	I
    //   148: if_icmpge +94 -> 242
    //   151: iconst_0
    //   152: istore 4
    //   154: iload 4
    //   156: aload_0
    //   157: getfield 368	com/tencent/mobileqq/bubble/QQAnimationDrawable:cxD	I
    //   160: if_icmpge +225 -> 385
    //   163: aload 9
    //   165: iload 4
    //   167: iload 5
    //   169: imul
    //   170: iload_3
    //   171: iload 6
    //   173: imul
    //   174: iload 5
    //   176: iload 6
    //   178: aconst_null
    //   179: iconst_1
    //   180: invokestatic 373	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   183: astore 10
    //   185: aload 10
    //   187: ifnull +189 -> 376
    //   190: invokestatic 310	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +36 -> 229
    //   196: ldc_w 312
    //   199: iconst_4
    //   200: new 314	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 375
    //   210: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload_3
    //   214: bipush 8
    //   216: imul
    //   217: iload 4
    //   219: iadd
    //   220: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   233: aload 10
    //   235: invokevirtual 376	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   238: pop
    //   239: goto +137 -> 376
    //   242: aload 9
    //   244: ifnull +16 -> 260
    //   247: aload 9
    //   249: invokevirtual 258	android/graphics/Bitmap:isRecycled	()Z
    //   252: ifne +8 -> 260
    //   255: aload 9
    //   257: invokevirtual 379	android/graphics/Bitmap:recycle	()V
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   265: invokevirtual 361	java/util/ArrayList:size	()I
    //   268: putfield 381	com/tencent/mobileqq/bubble/QQAnimationDrawable:cLp	I
    //   271: invokestatic 310	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   274: ifeq +35 -> 309
    //   277: ldc_w 312
    //   280: iconst_4
    //   281: new 314	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 383
    //   291: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   297: lload 7
    //   299: lsub
    //   300: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   303: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   313: iload_2
    //   314: invokevirtual 364	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   317: checkcast 221	android/graphics/Bitmap
    //   320: astore 9
    //   322: goto -291 -> 31
    //   325: astore 9
    //   327: invokestatic 310	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   330: ifeq -21 -> 309
    //   333: ldc_w 312
    //   336: iconst_4
    //   337: aload 9
    //   339: invokevirtual 334	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto -36 -> 309
    //   348: astore 9
    //   350: aload_0
    //   351: monitorexit
    //   352: aload 9
    //   354: athrow
    //   355: astore 9
    //   357: invokestatic 310	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   360: ifeq -51 -> 309
    //   363: ldc_w 312
    //   366: iconst_4
    //   367: ldc_w 339
    //   370: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: goto -64 -> 309
    //   376: iload 4
    //   378: iconst_1
    //   379: iadd
    //   380: istore 4
    //   382: goto -228 -> 154
    //   385: iload_3
    //   386: iconst_1
    //   387: iadd
    //   388: istore_3
    //   389: goto -246 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	QQAnimationDrawable
    //   0	392	1	paramBoolean	boolean
    //   0	392	2	paramInt	int
    //   142	247	3	i	int
    //   152	229	4	j	int
    //   78	97	5	k	int
    //   97	80	6	m	int
    //   39	259	7	l	long
    //   24	297	9	localBitmap1	Bitmap
    //   325	13	9	localException	Exception
    //   348	5	9	localObject	Object
    //   355	1	9	localOutOfMemoryError	OutOfMemoryError
    //   183	51	10	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   36	141	325	java/lang/Exception
    //   143	151	325	java/lang/Exception
    //   154	185	325	java/lang/Exception
    //   190	229	325	java/lang/Exception
    //   229	239	325	java/lang/Exception
    //   247	260	325	java/lang/Exception
    //   260	309	325	java/lang/Exception
    //   2	26	348	finally
    //   36	141	348	finally
    //   143	151	348	finally
    //   154	185	348	finally
    //   190	229	348	finally
    //   229	239	348	finally
    //   247	260	348	finally
    //   260	309	348	finally
    //   309	322	348	finally
    //   327	345	348	finally
    //   357	373	348	finally
    //   36	141	355	java/lang/OutOfMemoryError
    //   143	151	355	java/lang/OutOfMemoryError
    //   154	185	355	java/lang/OutOfMemoryError
    //   190	229	355	java/lang/OutOfMemoryError
    //   229	239	355	java/lang/OutOfMemoryError
    //   247	260	355	java/lang/OutOfMemoryError
    //   260	309	355	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 385	com/tencent/mobileqq/bubble/QQAnimationDrawable:kL	[I
    //   9: ifnull +121 -> 130
    //   12: aload_3
    //   13: astore 6
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 385	com/tencent/mobileqq/bubble/QQAnimationDrawable:kL	[I
    //   20: arraylength
    //   21: if_icmpge +109 -> 130
    //   24: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: aload_0
    //   30: getfield 385	com/tencent/mobileqq/bubble/QQAnimationDrawable:kL	[I
    //   33: iload_2
    //   34: iaload
    //   35: istore_2
    //   36: aload_3
    //   37: astore 6
    //   39: iload_2
    //   40: ifle +90 -> 130
    //   43: aload_0
    //   44: getfield 128	com/tencent/mobileqq/bubble/QQAnimationDrawable:enableCache	Z
    //   47: ifeq +89 -> 136
    //   50: aload_0
    //   51: getfield 138	com/tencent/mobileqq/bubble/QQAnimationDrawable:jR	Ljava/util/HashMap;
    //   54: iload_2
    //   55: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 214	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 216	java/lang/ref/SoftReference
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +24 -> 92
    //   71: aload 6
    //   73: invokevirtual 219	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 6
    //   81: invokevirtual 219	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 221	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: invokestatic 163	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   95: invokevirtual 167	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   98: iload_2
    //   99: invokestatic 394	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   102: astore 6
    //   104: aload 6
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 138	com/tencent/mobileqq/bubble/QQAnimationDrawable:jR	Ljava/util/HashMap;
    //   111: iload_2
    //   112: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   115: new 216	java/lang/ref/SoftReference
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 261	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   123: invokevirtual 403	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload_3
    //   128: astore 6
    //   130: aload 6
    //   132: astore_3
    //   133: goto -45 -> 88
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 269	com/tencent/mobileqq/bubble/QQAnimationDrawable:fc	Landroid/graphics/Bitmap;
    //   141: lload 4
    //   143: iload_2
    //   144: invokespecial 405	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JI)V
    //   147: aload_0
    //   148: getfield 269	com/tencent/mobileqq/bubble/QQAnimationDrawable:fc	Landroid/graphics/Bitmap;
    //   151: astore 6
    //   153: goto -23 -> 130
    //   156: astore_3
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_3
    //   160: athrow
    //   161: astore 6
    //   163: goto -36 -> 127
    //   166: astore 6
    //   168: goto -41 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	QQAnimationDrawable
    //   0	171	1	paramBoolean	boolean
    //   0	171	2	paramInt	int
    //   0	171	3	paramBitmap	Bitmap
    //   27	115	4	l	long
    //   3	149	6	localObject	Object
    //   161	1	6	localOutOfMemoryError1	OutOfMemoryError
    //   166	1	6	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   5	12	156	finally
    //   15	36	156	finally
    //   43	66	156	finally
    //   71	88	156	finally
    //   92	104	156	finally
    //   107	127	156	finally
    //   136	153	156	finally
    //   92	104	161	java/lang/OutOfMemoryError
    //   107	127	166	java/lang/OutOfMemoryError
  }
  
  private void cVg()
  {
    long l = 0L;
    if (this.py == 0L) {
      if (this.cLs == 0) {
        this.py = l;
      }
    }
    while (this.mDuration != 0L) {
      for (;;)
      {
        return;
        l = this.mDuration / this.cLs;
      }
    }
    this.mDuration = (this.py * this.cLs);
  }
  
  @TargetApi(19)
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT < 19) {
      if ((paramBitmap.getWidth() != paramOptions.outWidth) || (paramBitmap.getHeight() != paramOptions.outHeight) || (paramOptions.inSampleSize != 1)) {}
    }
    while (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount())
    {
      return true;
      return false;
    }
    return false;
  }
  
  private static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private void s(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = false;
    int i = this.bIg + 1;
    if (i >= this.cLp) {
      i = 0;
    }
    for (;;)
    {
      if (paramBoolean2) {
        unscheduleSelf(this);
      }
      if (((this.bgP) || (this.mRepeatCount <= 0)) && (i >= this.cLp - 1))
      {
        paramBoolean2 = true;
        QLog.d("QQAnimationDrawable", 4, "animation QQAnimationDrawable loadNextBitmap  playEnd:" + paramBoolean2 + ",mDecodeNextFrameEnd:" + this.mDecodeNextFrameEnd + ",animate:" + paramBoolean3);
        if ((!paramBoolean2) && (this.mDecodeNextFrameEnd) && (paramBoolean3))
        {
          this.mDecodeNextFrameEnd = false;
          if (!paramBoolean1) {
            break label276;
          }
        }
      }
      label276:
      for (long l = 0L;; l = SystemClock.uptimeMillis() + this.py)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable = new WorkerRunnable(i, l);
        this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$c.execute(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable);
        if (paramBoolean2)
        {
          QLog.d("QQAnimationDrawable", 1, "playEnd mCountOfFrame" + this.cLp);
          stop();
          StringBuilder localStringBuilder = new StringBuilder().append(hashCode()).append("playEnd listener");
          paramBoolean1 = bool;
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b != null) {
            paramBoolean1 = true;
          }
          QLog.d("QQAnimationDrawable", 1, String.valueOf(paramBoolean1));
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b != null) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b.onStop();
          }
        }
        return;
        paramBoolean2 = false;
        break;
      }
    }
  }
  
  public int Cb()
  {
    return this.cLp;
  }
  
  public void Q(String[] paramArrayOfString)
  {
    setType(0);
    if (!Arrays.equals(this.eA, paramArrayOfString))
    {
      cVj();
      this.eA = paramArrayOfString;
    }
    if (this.eA != null) {}
    for (this.cLp = this.eA.length;; this.cLp = 0)
    {
      this.cLs = paramArrayOfString.length;
      cVg();
      return;
    }
  }
  
  Bitmap a(boolean paramBoolean, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (this.mType == 0) {
      localBitmap1 = a(paramBoolean, paramInt, null);
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = this.fc;
      }
      return localBitmap2;
      if (this.mType == 2) {
        localBitmap1 = b(paramBoolean, paramInt, null);
      } else if (this.mType == 1) {
        localBitmap1 = b(paramBoolean, paramInt);
      }
    }
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b = paramb;
  }
  
  public void cVh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$c.clear();
    }
    if (this.mFuture != null) {
      this.mFuture.cancel(true);
    }
  }
  
  public void cVi() {}
  
  /* Error */
  public void cVj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 525	com/tencent/mobileqq/bubble/QQAnimationDrawable:fb	Landroid/graphics/Bitmap;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 525	com/tencent/mobileqq/bubble/QQAnimationDrawable:fb	Landroid/graphics/Bitmap;
    //   13: invokevirtual 258	android/graphics/Bitmap:isRecycled	()Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: getfield 525	com/tencent/mobileqq/bubble/QQAnimationDrawable:fb	Landroid/graphics/Bitmap;
    //   23: invokevirtual 379	android/graphics/Bitmap:recycle	()V
    //   26: aload_0
    //   27: getfield 527	com/tencent/mobileqq/bubble/QQAnimationDrawable:fa	Landroid/graphics/Bitmap;
    //   30: ifnull +29 -> 59
    //   33: aload_0
    //   34: getfield 527	com/tencent/mobileqq/bubble/QQAnimationDrawable:fa	Landroid/graphics/Bitmap;
    //   37: invokevirtual 258	android/graphics/Bitmap:isRecycled	()Z
    //   40: ifne +19 -> 59
    //   43: aload_0
    //   44: getfield 147	com/tencent/mobileqq/bubble/QQAnimationDrawable:dk	Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 527	com/tencent/mobileqq/bubble/QQAnimationDrawable:fa	Landroid/graphics/Bitmap;
    //   54: invokevirtual 379	android/graphics/Bitmap:recycle	()V
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 269	com/tencent/mobileqq/bubble/QQAnimationDrawable:fc	Landroid/graphics/Bitmap;
    //   63: ifnull +20 -> 83
    //   66: aload_0
    //   67: getfield 269	com/tencent/mobileqq/bubble/QQAnimationDrawable:fc	Landroid/graphics/Bitmap;
    //   70: invokevirtual 258	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +10 -> 83
    //   76: aload_0
    //   77: getfield 269	com/tencent/mobileqq/bubble/QQAnimationDrawable:fc	Landroid/graphics/Bitmap;
    //   80: invokevirtual 379	android/graphics/Bitmap:recycle	()V
    //   83: aload_0
    //   84: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   87: ifnull +65 -> 152
    //   90: aload_0
    //   91: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   94: invokevirtual 531	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   97: astore_1
    //   98: aload_1
    //   99: invokeinterface 536 1 0
    //   104: ifeq +41 -> 145
    //   107: aload_1
    //   108: invokeinterface 539 1 0
    //   113: checkcast 221	android/graphics/Bitmap
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull -20 -> 98
    //   121: aload_2
    //   122: invokevirtual 258	android/graphics/Bitmap:isRecycled	()Z
    //   125: ifne -27 -> 98
    //   128: aload_2
    //   129: invokevirtual 379	android/graphics/Bitmap:recycle	()V
    //   132: goto -34 -> 98
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: aload_0
    //   146: getfield 133	com/tencent/mobileqq/bubble/QQAnimationDrawable:qB	Ljava/util/ArrayList;
    //   149: invokevirtual 540	java/util/ArrayList:clear	()V
    //   152: aload_0
    //   153: getfield 138	com/tencent/mobileqq/bubble/QQAnimationDrawable:jR	Ljava/util/HashMap;
    //   156: ifnull +84 -> 240
    //   159: aload_0
    //   160: getfield 138	com/tencent/mobileqq/bubble/QQAnimationDrawable:jR	Ljava/util/HashMap;
    //   163: invokevirtual 544	java/util/HashMap:keySet	()Ljava/util/Set;
    //   166: invokeinterface 545 1 0
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface 536 1 0
    //   178: ifeq +55 -> 233
    //   181: aload_1
    //   182: invokeinterface 539 1 0
    //   187: checkcast 396	java/lang/String
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 138	com/tencent/mobileqq/bubble/QQAnimationDrawable:jR	Ljava/util/HashMap;
    //   195: aload_2
    //   196: invokevirtual 214	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 216	java/lang/ref/SoftReference
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -32 -> 172
    //   207: aload_2
    //   208: invokevirtual 219	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   211: checkcast 221	android/graphics/Bitmap
    //   214: astore_2
    //   215: aload_2
    //   216: ifnull -44 -> 172
    //   219: aload_2
    //   220: invokevirtual 258	android/graphics/Bitmap:isRecycled	()Z
    //   223: ifne -51 -> 172
    //   226: aload_2
    //   227: invokevirtual 379	android/graphics/Bitmap:recycle	()V
    //   230: goto -58 -> 172
    //   233: aload_0
    //   234: getfield 138	com/tencent/mobileqq/bubble/QQAnimationDrawable:jR	Ljava/util/HashMap;
    //   237: invokevirtual 546	java/util/HashMap:clear	()V
    //   240: aload_0
    //   241: monitorexit
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QQAnimationDrawable
    //   135	7	1	localObject2	Object
    //   171	11	1	localIterator	Iterator
    //   116	13	2	localBitmap	Bitmap
    //   140	4	2	localObject3	Object
    //   190	37	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	135	finally
    //   26	50	135	finally
    //   59	83	135	finally
    //   83	98	135	finally
    //   98	117	135	finally
    //   121	132	135	finally
    //   143	145	135	finally
    //   145	152	135	finally
    //   152	172	135	finally
    //   172	203	135	finally
    //   207	215	135	finally
    //   219	230	135	finally
    //   233	240	135	finally
    //   50	59	140	finally
    //   141	143	140	finally
  }
  
  public void draw(Canvas paramCanvas)
  {
    ??? = new StringBuilder().append("animation QQAnimationDrawable draw  currentBitmap == null ");
    boolean bool;
    if (this.fa == null) {
      bool = true;
    }
    for (;;)
    {
      QLog.d("QQAnimationDrawable", 4, bool);
      synchronized (this.dk)
      {
        if ((this.fa != null) && (!this.fa.isRecycled())) {
          paramCanvas.drawBitmap(this.fa, null, getBounds(), this.mPaint);
        }
        s(false, false, true);
        return;
        bool = false;
      }
    }
  }
  
  protected Bitmap getBitmapFromReusableSet(BitmapFactory.Options paramOptions)
  {
    if ((this.mReusableBitmaps != null) && (!this.mReusableBitmaps.isEmpty())) {
      for (;;)
      {
        synchronized (this.mReusableBitmaps)
        {
          Iterator localIterator = this.mReusableBitmaps.iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              if (!canUseForInBitmap(localBitmap, paramOptions)) {
                continue;
              }
              localIterator.remove();
              paramOptions = localBitmap;
              return paramOptions;
            }
            localIterator.remove();
          }
        }
        paramOptions = null;
      }
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.fb != null) {
      return this.fb.getScaledHeight(this.mTargetDensity);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.fb != null) {
      return this.fb.getScaledWidth(this.mTargetDensity);
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.bIg > -1;
  }
  
  public void reset()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQAnimationDrawable", 4, " reset");
    }
    this.mRepeatCount = 1;
    this.bIg = -1;
    this.cLq = 0;
    this.fc = null;
    this.fa = null;
    cVh();
  }
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(hashCode()).append("animation QQAnimationDrawable run time:").append(SystemClock.uptimeMillis()).append(",mCurFrame:").append(this.bIg).append("nextFrame:").append(this.cLq).append(" main:");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQAnimationDrawable", 4, bool);
      if (this.isStart) {
        break;
      }
      return;
    }
    QLog.d("QQAnimationDrawable", 4, "isParenMethod:" + this.bRW);
    if ((!this.bRW) && (this.bIg == Cb() - 1)) {
      this.mRepeatCount -= 1;
    }
    this.mDecodeNextFrameEnd = true;
    if (this.fc != null) {
      this.fa = this.fc;
    }
    QLog.d("QQAnimationDrawable", 4, "mRepeatCount:" + this.mRepeatCount);
    if ((this.bIg == -1) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b != null)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$b.onStart();
    }
    this.bIg = this.cLq;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
    cVg();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
  }
  
  public void setOneShot(boolean paramBoolean)
  {
    this.bgP = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2)) {
        cVi();
      }
      return bool;
    }
    unscheduleSelf(this);
    return bool;
  }
  
  public void start()
  {
    this.isStart = true;
    if ((this.cLp <= 0) || (this.py <= 0L)) {}
    while (isRunning()) {
      return;
    }
    this.mDecodeNextFrameEnd = true;
    s(true, false, true);
  }
  
  public void start(int paramInt)
  {
    this.bRW = false;
    this.mRepeatCount = paramInt;
    if (this.mRepeatCount > 1) {
      setOneShot(false);
    }
    for (;;)
    {
      start();
      return;
      if (this.mRepeatCount == 1) {
        setOneShot(true);
      }
    }
  }
  
  public void stop()
  {
    this.isStart = false;
    QLog.d("QQAnimationDrawable", 4, " stop");
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.bRW) {
      this.mRepeatCount = 1;
    }
    reset();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.bIg = -1;
    super.unscheduleSelf(paramRunnable);
  }
  
  class WorkerRunnable
    implements Runnable
  {
    private int cLt;
    private long drawTime;
    
    public WorkerRunnable(int paramInt, long paramLong)
    {
      this.cLt = paramInt;
      this.drawTime = paramLong;
    }
    
    public void run()
    {
      Object localObject = new StringBuilder().append("WorkerRunnable run | drawtime:").append(this.drawTime).append(" main:");
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("QQAnimationDrawable", 2, bool);
        Process.setThreadPriority(10);
        long l1 = SystemClock.uptimeMillis();
        QQAnimationDrawable.this.fc = QQAnimationDrawable.this.a(false, this.cLt);
        QQAnimationDrawable.a(QQAnimationDrawable.this, this.cLt);
        if ((QQAnimationDrawable.this.fb == null) && (this.cLt == 0)) {
          QQAnimationDrawable.this.fb = QQAnimationDrawable.this.fc;
        }
        if (QQAnimationDrawable.a(QQAnimationDrawable.this) != null) {
          QQAnimationDrawable.a(QQAnimationDrawable.this).vz(this.cLt);
        }
        localObject = QQAnimationDrawable.this;
        QQAnimationDrawable localQQAnimationDrawable = QQAnimationDrawable.this;
        long l2 = SystemClock.uptimeMillis();
        ((QQAnimationDrawable)localObject).scheduleSelf(localQQAnimationDrawable, Math.max(this.drawTime - l1, 0L) + l2);
        return;
      }
    }
  }
  
  class a
    extends Handler
  {
    private QQAnimationDrawable e;
    
    public a(QQAnimationDrawable paramQQAnimationDrawable)
    {
      this.e = paramQQAnimationDrawable;
    }
    
    public void handleMessage(Message paramMessage)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("InternalHandler handleMessage msg.what:").append(paramMessage.what).append(" main:");
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("QQAnimationDrawable", 2, bool);
        if (!(paramMessage.obj instanceof Long)) {
          break label170;
        }
        QLog.d("QQAnimationDrawable", 2, "InternalHandler handleMessage msg.obj:" + paramMessage.obj + " android.os.SystemClock.uptimeMillis():" + SystemClock.uptimeMillis());
        paramMessage = (Long)paramMessage.obj;
        if (paramMessage.longValue() >= SystemClock.uptimeMillis()) {
          break;
        }
        QLog.d("QQAnimationDrawable", 2, "time < android.os.SystemClock.uptimeMillis()");
        QQAnimationDrawable.this.scheduleSelf(this.e, SystemClock.uptimeMillis());
        return;
      }
      QLog.d("QQAnimationDrawable", 2, "time > android.os.SystemClock.uptimeMillis()");
      QQAnimationDrawable.this.scheduleSelf(this.e, paramMessage.longValue());
      return;
      label170:
      QLog.d("QQAnimationDrawable", 2, "InternalHandler handleMessage msg.obj:" + paramMessage.obj);
    }
  }
  
  public static abstract interface b
  {
    public abstract void onStart();
    
    public abstract void onStop();
    
    public abstract void vz(int paramInt);
  }
  
  static class c
    implements Executor
  {
    final QQAnimationDrawable.d<Runnable> a = new QQAnimationDrawable.d(30);
    Runnable mActive;
    
    protected void clear()
    {
      try
      {
        this.a.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void execute(Runnable paramRunnable)
    {
      try
      {
        QLog.d("QQAnimationDrawable", 2, "SerialExecutor excute");
        this.a.offer(new QQAnimationDrawable.SerialExecutor.1(this, paramRunnable));
        if (this.mActive == null)
        {
          QLog.d("QQAnimationDrawable", 2, "SerialExecutor mActive == null scheduleNext");
          scheduleNext();
        }
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    protected void scheduleNext()
    {
      try
      {
        Runnable localRunnable = (Runnable)this.a.poll();
        this.mActive = localRunnable;
        if (localRunnable != null)
        {
          QLog.d("QQAnimationDrawable", 2, "scheduleNext start");
          QQAnimationDrawable.THREAD_POOL_EXECUTOR.execute(this.mActive);
        }
        return;
      }
      finally {}
    }
  }
  
  static class d<T>
  {
    final AbstractCollection<T> a;
    
    public d(int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.a = new ArrayDeque();
        return;
      }
      this.a = new ArrayBlockingQueue(30);
    }
    
    public void clear()
    {
      this.a.clear();
    }
    
    public void offer(T paramT)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        if ((this.a instanceof ArrayDeque)) {
          ((ArrayDeque)this.a).offer(paramT);
        }
      }
      while (!(this.a instanceof ArrayBlockingQueue)) {
        return;
      }
      ((ArrayBlockingQueue)this.a).offer(paramT);
    }
    
    public T poll()
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        if ((this.a instanceof ArrayDeque)) {
          return ((ArrayDeque)this.a).poll();
        }
      }
      else if ((this.a instanceof ArrayBlockingQueue)) {
        return ((ArrayBlockingQueue)this.a).poll();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */