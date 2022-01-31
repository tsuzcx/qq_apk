package com.tencent.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;

public class NativeGifImage
  extends AbstractGifImage
{
  private static int CURRENT_FRAMEINDEX_INDEX = 5;
  private static int CURRENT_LOOP_INDEX = 6;
  public static final Bitmap.Config DEFAULT_CONFIG;
  private static int ERRCODE_INDEX = 0;
  private static int FRAME_COUNT_INDEX = 0;
  private static int HEIGHT_INDEX = 0;
  private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
  private static int POST_INVALIDATION_TIME_INDEX = 0;
  public static final String TAG = "NativeGifImage";
  private static int WIDTH_INDEX;
  private static boolean mIsGIFEngineAvaliable = false;
  private static boolean mIsLibLoaded = false;
  private static int[] sequence;
  protected Bitmap.Config mCurrentConfig = DEFAULT_CONFIG;
  protected Bitmap mCurrentFrameBitmap;
  protected Bitmap mCurrentFrameBitmapBuffer;
  protected int mCurrentFrameIndex;
  protected int mCurrentLoop;
  protected boolean mDecodeNextFrameEnd = true;
  protected Bitmap mFirstFrameBitmap;
  private volatile int mGifFilePtr = 0;
  protected final boolean mIsEmosmFile;
  protected final int[] mMetaData = new int[7];
  protected final int mReqHeight;
  protected final int mReqWidth;
  protected final String mSrcGifFile;
  
  static
  {
    DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    WIDTH_INDEX = 0;
    HEIGHT_INDEX = 1;
    FRAME_COUNT_INDEX = 2;
    ERRCODE_INDEX = 3;
    POST_INVALIDATION_TIME_INDEX = 4;
  }
  
  public NativeGifImage(File paramFile, boolean paramBoolean)
    throws IOException
  {
    this(paramFile, paramBoolean, false, 0, 0, 0.0F);
  }
  
  public NativeGifImage(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
    throws IOException
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    this.mSrcGifFile = paramFile.getAbsolutePath();
    this.mIsEmosmFile = paramBoolean2;
    if ((!paramFile.exists()) && (QLog.isColorLevel())) {
      QLog.e("NativeGifImage", 2, this.mSrcGifFile + " doesn't exist");
    }
    Rect localRect = getImageSize(paramFile, paramBoolean2);
    int m = localRect.width();
    int k = localRect.height();
    int j = k;
    int i = m;
    float f1;
    float f2;
    if (paramInt1 > 0)
    {
      j = k;
      i = m;
      if (paramInt2 > 0)
      {
        f1 = paramInt1 / m;
        f2 = paramInt2 / k;
        if (f1 >= f2) {
          break label257;
        }
        j = k;
        i = m;
        if (f1 < 1.0F)
        {
          i = (int)(m * f1);
          j = (int)(k * f1);
        }
      }
    }
    this.mReqWidth = i;
    this.mReqHeight = j;
    initCurrentFrameBitmap();
    if (mIsGIFEngineAvaliable) {
      this.mGifFilePtr = nativeOpenFile(this.mMetaData, paramFile.getPath(), this.mCurrentFrameBitmap, paramBoolean2);
    }
    for (;;)
    {
      this.mDefaultRoundCorner = paramFloat;
      init(paramBoolean1);
      return;
      label257:
      f1 = f2;
      break;
      this.mMetaData[WIDTH_INDEX] = localRect.width();
      this.mMetaData[HEIGHT_INDEX] = localRect.height();
      this.mMetaData[FRAME_COUNT_INDEX] = 1;
      this.mMetaData[ERRCODE_INDEX] = 0;
      this.mMetaData[POST_INVALIDATION_TIME_INDEX] = 2147483647;
      this.mMetaData[CURRENT_FRAMEINDEX_INDEX] = -1;
      this.mMetaData[CURRENT_LOOP_INDEX] = -1;
    }
  }
  
  public static Rect getImageSize(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    if (!paramFile.exists()) {
      return new Rect(0, 0, 0, 0);
    }
    loadLibrary();
    int[] arrayOfInt = new int[7];
    if (mIsGIFEngineAvaliable) {
      nativeGetFileImageSize(arrayOfInt, paramFile.getPath(), paramBoolean);
    }
    for (;;)
    {
      return new Rect(0, 0, arrayOfInt[WIDTH_INDEX], arrayOfInt[HEIGHT_INDEX]);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
      arrayOfInt[WIDTH_INDEX] = localOptions.outWidth;
      arrayOfInt[HEIGHT_INDEX] = localOptions.outHeight;
    }
  }
  
  private void init(boolean paramBoolean)
  {
    getNextFrame();
    applyNextFrame();
    if (paramBoolean) {}
    try
    {
      this.mFirstFrameBitmap = this.mCurrentFrameBitmap.copy(this.mCurrentFrameBitmap.getConfig(), false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void initCurrentFrameBitmap()
  {
    if (mIsGIFEngineAvaliable) {}
    try
    {
      this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
      if (this.mReqWidth * this.mReqHeight > IMAGE_SIZE_DISABLE_DOUBLE_BUFFER) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.mCurrentFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError3) {}
        localOutOfMemoryError1 = localOutOfMemoryError1;
        if (this.mCurrentConfig == Bitmap.Config.ARGB_8888)
        {
          try
          {
            this.mCurrentConfig = Bitmap.Config.ARGB_4444;
            this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            URLDrawable.clearMemoryCache();
            this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
          }
        }
        else
        {
          URLDrawable.clearMemoryCache();
          this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
        }
      }
    }
  }
  
  public static void loadLibrary()
  {
    if ((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) {}
    try
    {
      Utils.beginPile();
      mIsGIFEngineAvaliable = SoLoadUtilNew.loadSoByName(URLDrawable.mApplicationContext, "GIFEngine");
      i = Color.argb(255, 0, 1, 2);
      localObject = DEFAULT_CONFIG;
      sequence = nativeTestColor(Bitmap.createBitmap(new int[] { i }, 1, 1, (Bitmap.Config)localObject));
      k = 0;
      if (sequence == null) {
        break label279;
      }
      if (sequence.length == 4) {
        break label153;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject;
        int k;
        int m;
        int j;
        if (QLog.isColorLevel()) {
          QLog.e("NativeGifImage", 2, "loadLibrary(): " + localUnsatisfiedLinkError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("NativeGifImage", 2, "loadLibrary(): " + localException.getMessage());
          continue;
          i = 1;
        }
      }
    }
    if (i != 0) {
      sequence = new int[] { 0, 1, 2, 3 };
    }
    mIsLibLoaded = true;
    Utils.endPile("NativeGifImage", "Load libGIFEngine");
    if (QLog.isColorLevel()) {
      QLog.i("NativeGifImage", 2, "libGIFEngine.so loaded " + mIsLibLoaded);
    }
    return;
    label153:
    localObject = sequence;
    m = localObject.length;
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      i = localObject[j];
      if ((i < 0) || (i > 3))
      {
        i = 1;
        break;
      }
      j += 1;
    }
  }
  
  private static native void nativeFree(int paramInt);
  
  private static native long nativeGetAllocationByteCount(int paramInt);
  
  private static native int nativeGetFileImageSize(int[] paramArrayOfInt, String paramString, boolean paramBoolean)
    throws NativeGifIOException;
  
  private static native int nativeOpenFile(int[] paramArrayOfInt, String paramString, Bitmap paramBitmap, boolean paramBoolean)
    throws NativeGifIOException;
  
  private static native boolean nativeReset(int paramInt);
  
  private static native void nativeSeekToNextFrame(Bitmap paramBitmap, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private static native int[] nativeTestColor(Bitmap paramBitmap);
  
  /* Error */
  protected void applyNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 89	com/tencent/image/NativeGifImage:mMetaData	[I
    //   7: getstatic 69	com/tencent/image/NativeGifImage:CURRENT_FRAMEINDEX_INDEX	I
    //   10: iaload
    //   11: putfield 304	com/tencent/image/NativeGifImage:mCurrentFrameIndex	I
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 89	com/tencent/image/NativeGifImage:mMetaData	[I
    //   19: getstatic 71	com/tencent/image/NativeGifImage:CURRENT_LOOP_INDEX	I
    //   22: iaload
    //   23: putfield 306	com/tencent/image/NativeGifImage:mCurrentLoop	I
    //   26: aload_0
    //   27: getfield 228	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   30: ifnull +114 -> 144
    //   33: new 308	android/graphics/Canvas
    //   36: dup
    //   37: aload_0
    //   38: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   41: invokespecial 311	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   44: astore_3
    //   45: aload_0
    //   46: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   49: iconst_0
    //   50: invokevirtual 314	android/graphics/Bitmap:eraseColor	(I)V
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 168	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   59: fconst_0
    //   60: fcmpl
    //   61: ifle +69 -> 130
    //   64: new 316	android/graphics/Paint
    //   67: dup
    //   68: invokespecial 317	android/graphics/Paint:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: iconst_1
    //   74: invokevirtual 320	android/graphics/Paint:setAntiAlias	(Z)V
    //   77: aload_3
    //   78: new 322	android/graphics/RectF
    //   81: dup
    //   82: fconst_0
    //   83: fconst_0
    //   84: aload_0
    //   85: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   88: invokevirtual 325	android/graphics/Bitmap:getWidth	()I
    //   91: i2f
    //   92: aload_0
    //   93: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   96: invokevirtual 328	android/graphics/Bitmap:getHeight	()I
    //   99: i2f
    //   100: invokespecial 331	android/graphics/RectF:<init>	(FFFF)V
    //   103: aload_0
    //   104: getfield 168	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   107: aload_0
    //   108: getfield 168	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   111: aload_2
    //   112: invokevirtual 335	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   115: aload_2
    //   116: new 337	android/graphics/PorterDuffXfermode
    //   119: dup
    //   120: getstatic 343	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   123: invokespecial 346	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   126: invokevirtual 350	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   129: pop
    //   130: aload_3
    //   131: aload_0
    //   132: getfield 228	com/tencent/image/NativeGifImage:mCurrentFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   135: fconst_0
    //   136: fconst_0
    //   137: aload_2
    //   138: invokevirtual 354	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: aload_0
    //   145: getfield 168	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   148: fstore_1
    //   149: fload_1
    //   150: fconst_0
    //   151: fcmpl
    //   152: ifle -11 -> 141
    //   155: aconst_null
    //   156: astore_3
    //   157: aload_0
    //   158: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   161: invokevirtual 325	android/graphics/Bitmap:getWidth	()I
    //   164: aload_0
    //   165: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   168: invokevirtual 328	android/graphics/Bitmap:getHeight	()I
    //   171: aload_0
    //   172: getfield 93	com/tencent/image/NativeGifImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   175: invokestatic 226	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   178: astore_2
    //   179: aload_2
    //   180: ifnull -39 -> 141
    //   183: new 308	android/graphics/Canvas
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 311	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   191: astore_3
    //   192: new 316	android/graphics/Paint
    //   195: dup
    //   196: invokespecial 317	android/graphics/Paint:<init>	()V
    //   199: astore 4
    //   201: aload 4
    //   203: iconst_1
    //   204: invokevirtual 320	android/graphics/Paint:setAntiAlias	(Z)V
    //   207: aload_3
    //   208: new 322	android/graphics/RectF
    //   211: dup
    //   212: fconst_0
    //   213: fconst_0
    //   214: aload_0
    //   215: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   218: invokevirtual 325	android/graphics/Bitmap:getWidth	()I
    //   221: i2f
    //   222: aload_0
    //   223: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   226: invokevirtual 328	android/graphics/Bitmap:getHeight	()I
    //   229: i2f
    //   230: invokespecial 331	android/graphics/RectF:<init>	(FFFF)V
    //   233: aload_0
    //   234: getfield 168	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   237: aload_0
    //   238: getfield 168	com/tencent/image/NativeGifImage:mDefaultRoundCorner	F
    //   241: aload 4
    //   243: invokevirtual 335	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   246: aload 4
    //   248: new 337	android/graphics/PorterDuffXfermode
    //   251: dup
    //   252: getstatic 343	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   255: invokespecial 346	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   258: invokevirtual 350	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   261: pop
    //   262: aload_3
    //   263: aload_0
    //   264: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   267: fconst_0
    //   268: fconst_0
    //   269: aload 4
    //   271: invokevirtual 354	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   274: aload_0
    //   275: aload_2
    //   276: putfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   279: goto -138 -> 141
    //   282: astore_2
    //   283: aload_0
    //   284: monitorexit
    //   285: aload_2
    //   286: athrow
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 93	com/tencent/image/NativeGifImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   292: astore 4
    //   294: getstatic 55	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   297: astore 5
    //   299: aload_3
    //   300: astore_2
    //   301: aload 4
    //   303: aload 5
    //   305: if_acmpne -126 -> 179
    //   308: aload_0
    //   309: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   312: invokevirtual 325	android/graphics/Bitmap:getWidth	()I
    //   315: aload_0
    //   316: getfield 160	com/tencent/image/NativeGifImage:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   319: invokevirtual 328	android/graphics/Bitmap:getHeight	()I
    //   322: getstatic 231	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   325: invokestatic 226	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   328: astore_2
    //   329: goto -150 -> 179
    //   332: astore_2
    //   333: aload_3
    //   334: astore_2
    //   335: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq -159 -> 179
    //   341: ldc 24
    //   343: iconst_2
    //   344: ldc_w 356
    //   347: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload_3
    //   351: astore_2
    //   352: goto -173 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	NativeGifImage
    //   148	2	1	f	float
    //   54	222	2	localObject1	Object
    //   282	4	2	localObject2	Object
    //   287	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   300	29	2	localObject3	Object
    //   332	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   334	18	2	localCanvas1	Canvas
    //   44	307	3	localCanvas2	Canvas
    //   199	103	4	localObject4	Object
    //   297	7	5	localConfig	Bitmap.Config
    // Exception table:
    //   from	to	target	type
    //   2	53	282	finally
    //   55	130	282	finally
    //   130	141	282	finally
    //   144	149	282	finally
    //   157	179	282	finally
    //   183	279	282	finally
    //   288	299	282	finally
    //   308	329	282	finally
    //   335	350	282	finally
    //   157	179	287	java/lang/OutOfMemoryError
    //   308	329	332	java/lang/OutOfMemoryError
  }
  
  protected void doApplyNextFrame()
  {
    this.mDecodeNextFrameEnd = true;
    super.doApplyNextFrame();
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((this.mMetaData[FRAME_COUNT_INDEX] <= 1) || ((!paramBoolean) && (this.mCurrentFrameBitmap != null))) {
      paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
    }
    do
    {
      return;
      if (this.mCurrentFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
  }
  
  protected void executeNewTask()
  {
    long l1;
    long l2;
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      l1 = SystemClock.uptimeMillis();
      l2 = this.mMetaData[POST_INVALIDATION_TIME_INDEX];
    }
    try
    {
      Utils.executeAsyncTaskOnSerialExcuter(new NativeDecodeFrameTask(l1 + l2), (Void[])null);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    int i = this.mGifFilePtr;
    this.mGifFilePtr = 0;
    if (mIsGIFEngineAvaliable) {
      nativeFree(i);
    }
    super.finalize();
  }
  
  @TargetApi(12)
  public int getByteSize()
  {
    l2 = 0L;
    l1 = l2;
    if (mIsGIFEngineAvaliable) {}
    try
    {
      l1 = nativeGetAllocationByteCount(this.mGifFilePtr);
      l1 = 0L + l1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e("NativeGifImage", 2, "getByteSize(): " + localUnsatisfiedLinkError.getMessage());
          l1 = l2;
        }
      }
    }
    return (int)(l1 + Utils.getBitmapSize(this.mCurrentFrameBitmap) + Utils.getBitmapSize(this.mFirstFrameBitmap));
  }
  
  public NativeGifIOException.NativeGifError getError()
  {
    return NativeGifIOException.NativeGifError.fromCode(this.mMetaData[ERRCODE_INDEX]);
  }
  
  public int getHeight()
  {
    if (this.mCurrentFrameBitmap != null) {
      return this.mCurrentFrameBitmap.getHeight();
    }
    return 0;
  }
  
  protected void getNextFrame()
  {
    for (;;)
    {
      try
      {
        if (mIsGIFEngineAvaliable)
        {
          if (this.mCurrentFrameBitmapBuffer != null)
          {
            nativeSeekToNextFrame(this.mCurrentFrameBitmapBuffer, this.mGifFilePtr, this.mMetaData, sequence);
            return;
          }
          nativeSeekToNextFrame(this.mCurrentFrameBitmap, this.mGifFilePtr, this.mMetaData, sequence);
          continue;
        }
        try
        {
          this.mCurrentFrameBitmap = BitmapFactory.decodeFile(this.mSrcGifFile);
          this.mCurrentFrameBitmap = Bitmap.createScaledBitmap(this.mCurrentFrameBitmap, this.mReqWidth, this.mReqHeight, true);
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
      finally {}
    }
  }
  
  public int getWidth()
  {
    if (this.mCurrentFrameBitmap != null) {
      return this.mCurrentFrameBitmap.getWidth();
    }
    return 0;
  }
  
  public void reset()
  {
    this.mCurrentFrameIndex = -1;
    this.mCurrentLoop = -1;
    if (mIsGIFEngineAvaliable) {
      nativeReset(this.mGifFilePtr);
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", new Object[] { Integer.valueOf(this.mMetaData[0]), Integer.valueOf(this.mMetaData[1]), Integer.valueOf(this.mMetaData[2]), Integer.valueOf(this.mMetaData[3]) });
  }
  
  private class NativeDecodeFrameTask
    extends AsyncTask<Void, Void, Void>
  {
    final long mNextFrameTime;
    
    public NativeDecodeFrameTask(long paramLong)
    {
      this.mNextFrameTime = paramLong;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      NativeGifImage.this.getNextFrame();
      if (NativeGifImage.this.mMetaData[NativeGifImage.FRAME_COUNT_INDEX] > 1)
      {
        long l = SystemClock.uptimeMillis();
        paramVarArgs = new Runnable()
        {
          public void run()
          {
            AbstractGifImage.sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(NativeGifImage.this) });
          }
        };
        if (l < this.mNextFrameTime)
        {
          AbstractGifImage.sUIThreadHandler.postDelayed(paramVarArgs, this.mNextFrameTime - l);
          return null;
        }
        AbstractGifImage.sUIThreadHandler.post(paramVarArgs);
        return null;
      }
      NativeGifImage.this.mDecodeNextFrameEnd = true;
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifImage
 * JD-Core Version:    0.7.0.1
 */