package cooperation.qzone.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.LruCache;
import awcg;
import awdu;
import awid;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FastAnimationDrawable
  extends Drawable
  implements Animatable
{
  public static byte[] inTempStorage = new byte[24576];
  private a jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable$a;
  private b jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable$b;
  private AtomicInteger cu = new AtomicInteger(-1);
  private long delay = awdu.bpx;
  private volatile BitmapDrawable m;
  private int mClipHeight;
  private int mClipWidth;
  private Context mContext;
  private ExecutorService mExecutor;
  private volatile boolean mIsRunning;
  public LruCache<Integer, BitmapDrawable> mMemoryCache;
  private ArrayList<String> mPhotoList;
  private Set<SoftReference<Bitmap>> mReusableBitmaps;
  private volatile BitmapDrawable n;
  
  public FastAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong, a parama)
  {
    this.mContext = paramContext;
    this.mIsRunning = false;
    this.mExecutor = Executors.newCachedThreadPool();
    this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable$b = new b(this);
    this.mClipWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.mClipHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.delay = paramLong;
    this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable$a = parama;
    if (Build.VERSION.SDK_INT >= 11) {
      this.mReusableBitmaps = Collections.synchronizedSet(new HashSet());
    }
    this.mPhotoList = paramArrayList;
    this.mMemoryCache = new awid(this, paramArrayList.size());
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
  @TargetApi(12)
  private BitmapDrawable b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 7
    //   5: aload 7
    //   7: astore 6
    //   9: new 163	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 179	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 8
    //   18: aload 7
    //   20: astore 6
    //   22: aload 8
    //   24: iconst_1
    //   25: putfield 182	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   28: aload 7
    //   30: astore 6
    //   32: aload 8
    //   34: getstatic 48	cooperation/qzone/widget/FastAnimationDrawable:inTempStorage	[B
    //   37: putfield 183	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   40: aload 7
    //   42: astore 6
    //   44: aload_1
    //   45: aload 8
    //   47: invokestatic 189	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: pop
    //   51: aload 7
    //   53: astore 6
    //   55: aload 8
    //   57: aload_0
    //   58: getfield 103	cooperation/qzone/widget/FastAnimationDrawable:mClipWidth	I
    //   61: aload_0
    //   62: getfield 108	cooperation/qzone/widget/FastAnimationDrawable:mClipHeight	I
    //   65: invokestatic 193	cooperation/qzone/widget/FastAnimationDrawable:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   68: istore_2
    //   69: aload 7
    //   71: astore 6
    //   73: aload 8
    //   75: iconst_0
    //   76: putfield 182	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   79: aload 7
    //   81: astore 6
    //   83: aload 8
    //   85: iload_2
    //   86: putfield 196	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: aload 7
    //   91: astore 6
    //   93: aload 8
    //   95: getstatic 48	cooperation/qzone/widget/FastAnimationDrawable:inTempStorage	[B
    //   98: putfield 183	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   101: aload 7
    //   103: astore 6
    //   105: aload 8
    //   107: getstatic 202	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   110: putfield 205	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   113: aload 7
    //   115: astore 6
    //   117: getstatic 115	android/os/Build$VERSION:SDK_INT	I
    //   120: bipush 11
    //   122: if_icmplt +13 -> 135
    //   125: aload 7
    //   127: astore 6
    //   129: aload_0
    //   130: aload 8
    //   132: invokespecial 207	cooperation/qzone/widget/FastAnimationDrawable:addInBitmapOptions	(Landroid/graphics/BitmapFactory$Options;)V
    //   135: aload 7
    //   137: astore 6
    //   139: aload_1
    //   140: aload 8
    //   142: invokestatic 210	cooperation/qzone/widget/FastAnimationDrawable:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore 8
    //   147: aload 8
    //   149: astore 6
    //   151: aload_1
    //   152: invokestatic 216	aqhu:getExifOrientation	(Ljava/lang/String;)I
    //   155: istore_3
    //   156: aload 8
    //   158: astore 7
    //   160: iload_3
    //   161: ifeq +130 -> 291
    //   164: aload 8
    //   166: astore 7
    //   168: iload_3
    //   169: bipush 90
    //   171: irem
    //   172: ifne +119 -> 291
    //   175: aload 8
    //   177: astore 6
    //   179: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +32 -> 214
    //   185: aload 8
    //   187: astore 6
    //   189: ldc 224
    //   191: iconst_2
    //   192: new 226	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   199: ldc 229
    //   201: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload_3
    //   205: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 8
    //   216: astore 6
    //   218: aload 8
    //   220: invokevirtual 248	android/graphics/Bitmap:getWidth	()I
    //   223: istore 4
    //   225: aload 8
    //   227: astore 6
    //   229: aload 8
    //   231: invokevirtual 251	android/graphics/Bitmap:getHeight	()I
    //   234: istore 5
    //   236: aload 8
    //   238: astore 6
    //   240: new 253	android/graphics/Matrix
    //   243: dup
    //   244: invokespecial 254	android/graphics/Matrix:<init>	()V
    //   247: astore 7
    //   249: aload 8
    //   251: astore 6
    //   253: aload 7
    //   255: iload_3
    //   256: i2f
    //   257: iload 4
    //   259: i2f
    //   260: fconst_2
    //   261: fdiv
    //   262: iload 5
    //   264: i2f
    //   265: fconst_2
    //   266: fdiv
    //   267: invokevirtual 258	android/graphics/Matrix:postRotate	(FFF)Z
    //   270: pop
    //   271: aload 8
    //   273: astore 6
    //   275: aload 8
    //   277: iconst_0
    //   278: iconst_0
    //   279: iload 4
    //   281: iload 5
    //   283: aload 7
    //   285: iconst_1
    //   286: invokestatic 262	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   289: astore 7
    //   291: aload 7
    //   293: astore 8
    //   295: aload 7
    //   297: astore 6
    //   299: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +61 -> 363
    //   305: aload 7
    //   307: astore 6
    //   309: ldc 224
    //   311: iconst_2
    //   312: new 226	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 264
    //   322: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 266
    //   332: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload_2
    //   336: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: ldc_w 268
    //   342: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 7
    //   347: invokevirtual 271	android/graphics/Bitmap:getByteCount	()I
    //   350: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 7
    //   361: astore 8
    //   363: new 273	android/graphics/drawable/BitmapDrawable
    //   366: dup
    //   367: aload 8
    //   369: invokespecial 276	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   372: astore_1
    //   373: aload_0
    //   374: monitorexit
    //   375: aload_1
    //   376: areturn
    //   377: astore_1
    //   378: aload_0
    //   379: monitorexit
    //   380: aload_1
    //   381: athrow
    //   382: astore_1
    //   383: aload 6
    //   385: astore 8
    //   387: goto -24 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	FastAnimationDrawable
    //   0	390	1	paramString	String
    //   68	268	2	i	int
    //   155	101	3	j	int
    //   223	57	4	k	int
    //   234	48	5	i1	int
    //   7	377	6	localObject1	Object
    //   3	357	7	localObject2	Object
    //   16	370	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	377	finally
    //   22	28	377	finally
    //   32	40	377	finally
    //   44	51	377	finally
    //   55	69	377	finally
    //   73	79	377	finally
    //   83	89	377	finally
    //   93	101	377	finally
    //   105	113	377	finally
    //   117	125	377	finally
    //   129	135	377	finally
    //   139	147	377	finally
    //   151	156	377	finally
    //   179	185	377	finally
    //   189	214	377	finally
    //   218	225	377	finally
    //   229	236	377	finally
    //   240	249	377	finally
    //   253	271	377	finally
    //   275	291	377	finally
    //   299	305	377	finally
    //   309	359	377	finally
    //   363	373	377	finally
    //   9	18	382	java/lang/OutOfMemoryError
    //   22	28	382	java/lang/OutOfMemoryError
    //   32	40	382	java/lang/OutOfMemoryError
    //   44	51	382	java/lang/OutOfMemoryError
    //   55	69	382	java/lang/OutOfMemoryError
    //   73	79	382	java/lang/OutOfMemoryError
    //   83	89	382	java/lang/OutOfMemoryError
    //   93	101	382	java/lang/OutOfMemoryError
    //   105	113	382	java/lang/OutOfMemoryError
    //   117	125	382	java/lang/OutOfMemoryError
    //   129	135	382	java/lang/OutOfMemoryError
    //   139	147	382	java/lang/OutOfMemoryError
    //   151	156	382	java/lang/OutOfMemoryError
    //   179	185	382	java/lang/OutOfMemoryError
    //   189	214	382	java/lang/OutOfMemoryError
    //   218	225	382	java/lang/OutOfMemoryError
    //   229	236	382	java/lang/OutOfMemoryError
    //   240	249	382	java/lang/OutOfMemoryError
    //   253	271	382	java/lang/OutOfMemoryError
    //   275	291	382	java/lang/OutOfMemoryError
    //   299	305	382	java/lang/OutOfMemoryError
    //   309	359	382	java/lang/OutOfMemoryError
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int i1 = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (i1 > paramInt1))
    {
      int i = 2;
      for (;;)
      {
        if (k / i <= paramInt2)
        {
          j = i;
          if (i1 / i <= paramInt1) {
            break;
          }
        }
        i *= 2;
      }
    }
    return j;
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
  
  /* Error */
  public static Bitmap d(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +54 -> 57
    //   6: aload_1
    //   7: getfield 182	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   10: ifeq +47 -> 57
    //   13: new 302	java/io/BufferedInputStream
    //   16: dup
    //   17: new 304	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: sipush 2048
    //   28: invokespecial 310	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   31: astore_0
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: aconst_null
    //   36: aload_1
    //   37: invokestatic 314	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokevirtual 319	java/io/InputStream:close	()V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_1
    //   56: areturn
    //   57: new 302	java/io/BufferedInputStream
    //   60: dup
    //   61: new 304	java/io/FileInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   69: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore_0
    //   73: goto -41 -> 32
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: ldc 224
    //   83: iconst_1
    //   84: ldc_w 324
    //   87: aload_1
    //   88: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_3
    //   92: astore_1
    //   93: aload_0
    //   94: ifnull -39 -> 55
    //   97: aload_0
    //   98: invokevirtual 319	java/io/InputStream:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: areturn
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: astore_2
    //   111: ldc 224
    //   113: iconst_1
    //   114: ldc_w 330
    //   117: aload_1
    //   118: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_3
    //   122: astore_1
    //   123: aload_0
    //   124: ifnull -69 -> 55
    //   127: aload_0
    //   128: invokevirtual 319	java/io/InputStream:close	()V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 319	java/io/InputStream:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: aload_2
    //   151: areturn
    //   152: astore_1
    //   153: goto -6 -> 147
    //   156: astore_0
    //   157: goto -18 -> 139
    //   160: astore_1
    //   161: goto -52 -> 109
    //   164: astore_1
    //   165: goto -86 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   0	168	1	paramOptions	BitmapFactory.Options
    //   33	118	2	localObject1	Object
    //   1	121	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	32	76	java/lang/Exception
    //   57	73	76	java/lang/Exception
    //   97	101	103	java/io/IOException
    //   6	32	106	java/lang/OutOfMemoryError
    //   57	73	106	java/lang/OutOfMemoryError
    //   127	131	133	java/io/IOException
    //   6	32	136	finally
    //   57	73	136	finally
    //   49	53	149	java/io/IOException
    //   143	147	152	java/io/IOException
    //   34	41	156	finally
    //   81	91	156	finally
    //   111	121	156	finally
    //   34	41	160	java/lang/OutOfMemoryError
    //   34	41	164	java/lang/Exception
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
  
  private void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastAnimationDrawable", 2, "reset");
    }
    this.mIsRunning = true;
    this.m = null;
    this.n = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      this.m = this.n;
      this.n = null;
    }
    if (this.m != null)
    {
      this.m.setBounds(getBounds());
      this.m.draw(paramCanvas);
    }
  }
  
  public void eDE()
  {
    this.mMemoryCache.evictAll();
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
  
  public long getDuration()
  {
    return this.delay;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  public void lj(int paramInt1, int paramInt2)
  {
    this.mClipWidth = paramInt1;
    this.mClipHeight = paramInt2;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setDuration(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 20L) {
      l = 20L;
    }
    this.delay = l;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FastAnimationDrawable", 2, "setVisible changed:" + bool + " visible:" + paramBoolean1 + " restart:" + paramBoolean2);
    }
    if (paramBoolean1) {
      if (bool)
      {
        start();
        if (!paramBoolean2) {
          break label81;
        }
        reset();
      }
    }
    label81:
    while (!bool)
    {
      return bool;
      start();
      return bool;
    }
    stop();
    return bool;
  }
  
  public void start()
  {
    if (!this.mIsRunning)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "start");
      }
      this.mIsRunning = true;
      this.mExecutor.submit(new LoopReadWriteRunnable());
    }
  }
  
  public void stop()
  {
    if (isRunning())
    {
      this.mIsRunning = false;
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable$a = null;
    }
  }
  
  public class LoopReadWriteRunnable
    implements Runnable
  {
    public LoopReadWriteRunnable() {}
    
    public void run()
    {
      while (FastAnimationDrawable.this.isRunning())
      {
        FastAnimationDrawable.a(FastAnimationDrawable.this).set(FastAnimationDrawable.a(FastAnimationDrawable.this).incrementAndGet() % FastAnimationDrawable.a(FastAnimationDrawable.this).size());
        if (QLog.isColorLevel()) {
          QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable index:" + FastAnimationDrawable.a(FastAnimationDrawable.this).get());
        }
        if ((FastAnimationDrawable.this.mMemoryCache != null) && (FastAnimationDrawable.this.mMemoryCache.get(Integer.valueOf(FastAnimationDrawable.a(FastAnimationDrawable.this).get())) != null))
        {
          FastAnimationDrawable.a(FastAnimationDrawable.this, (BitmapDrawable)FastAnimationDrawable.this.mMemoryCache.get(Integer.valueOf(FastAnimationDrawable.a(FastAnimationDrawable.this).get())));
          try
          {
            Thread.sleep(FastAnimationDrawable.a(FastAnimationDrawable.this));
            FastAnimationDrawable.a(FastAnimationDrawable.this).sendEmptyMessage(0);
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
        else
        {
          long l = System.currentTimeMillis();
          BitmapDrawable localBitmapDrawable = FastAnimationDrawable.a(FastAnimationDrawable.this, (String)FastAnimationDrawable.a(FastAnimationDrawable.this).get(FastAnimationDrawable.a(FastAnimationDrawable.this).get()));
          if (localBitmapDrawable != null)
          {
            l = System.currentTimeMillis() - l;
            FastAnimationDrawable.a(FastAnimationDrawable.this, localBitmapDrawable);
            if (QLog.isColorLevel()) {
              QLog.d("FastAnimationDrawable", 2, "LoopReadWriteRunnable decodeBitmap index:" + FastAnimationDrawable.a(FastAnimationDrawable.this).get() + " cost:" + l + " delay:" + FastAnimationDrawable.a(FastAnimationDrawable.this));
            }
            FastAnimationDrawable.this.mMemoryCache.put(Integer.valueOf(FastAnimationDrawable.a(FastAnimationDrawable.this).get()), localBitmapDrawable);
            if ((FastAnimationDrawable.this.mMemoryCache.size() == FastAnimationDrawable.a(FastAnimationDrawable.this).size()) && (FastAnimationDrawable.a(FastAnimationDrawable.this) != null) && (FastAnimationDrawable.this.mMemoryCache.size() <= awcg.a().PX())) {
              FastAnimationDrawable.a(FastAnimationDrawable.this).b(FastAnimationDrawable.this.mMemoryCache);
            }
            if (!FastAnimationDrawable.a(FastAnimationDrawable.this).hasMessages(0)) {
              if (FastAnimationDrawable.a(FastAnimationDrawable.this) > l) {
                FastAnimationDrawable.a(FastAnimationDrawable.this).sendEmptyMessageDelayed(0, FastAnimationDrawable.a(FastAnimationDrawable.this) - l);
              } else {
                FastAnimationDrawable.a(FastAnimationDrawable.this).sendEmptyMessage(0);
              }
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(LruCache<Integer, BitmapDrawable> paramLruCache);
  }
  
  public class b
    extends Handler
  {
    private final WeakReference<Drawable> mDrawableRef;
    
    public b(Drawable paramDrawable)
    {
      super();
      this.mDrawableRef = new WeakReference(paramDrawable);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (Drawable)this.mDrawableRef.get();
      if (paramMessage != null) {
        paramMessage.invalidateSelf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.FastAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */