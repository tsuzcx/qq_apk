package com.tencent.image;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

public class NativeGifIndex8
  extends AbstractGifImage
{
  public static final int INDEX_EXT_DATA_NEXT_DELAY = 0;
  public static final int INDEX_EXT_DATA_RESULT_CODE = 1;
  public static final String TAG = "NativeGifIndex8";
  private static boolean mIsGIFEngineAvaliable = false;
  private static boolean mIsLibLoaded = false;
  private boolean mCacheFirstFrame = false;
  protected Bitmap mCurrentFrameBitmap;
  protected Bitmap mCurrentFrameBitmapBuffer;
  protected boolean mDecodeNextFrameEnd = true;
  protected int[] mExtData;
  protected Bitmap mFirstFrameBitmap;
  public int mFrameNumber;
  private volatile int mGifHandler = 0;
  private boolean mIsFirstBitmap = true;
  private Bitmap mLastBitmap;
  protected int mReqHeight;
  protected int mReqWidth;
  protected String mSrcGifFile;
  
  public NativeGifIndex8(File paramFile, boolean paramBoolean)
    throws IOException
  {
    this(paramFile, paramBoolean, false, 0, 0, 0.0F);
  }
  
  public NativeGifIndex8(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
    throws IOException
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    loadLibrary();
    this.mSrcGifFile = paramFile.getAbsolutePath();
    this.mCacheFirstFrame = paramBoolean1;
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("NativeGifIndex8", 2, this.mSrcGifFile + " doesn't exist");
      }
      return;
    }
    this.mExtData = new int[2];
    if (mIsGIFEngineAvaliable)
    {
      this.mGifHandler = nativeInit(this.mSrcGifFile, paramBoolean2);
      initSize(paramInt1, paramInt2);
      nativeSetDestSize(this.mGifHandler, this.mReqWidth, this.mReqHeight);
      nativeSetLoopCount(this.mGifHandler, -1);
      this.mFrameNumber = nativeGetFrameNum(this.mGifHandler);
      this.mExtData[0] = 0;
    }
    for (;;)
    {
      this.mDefaultRoundCorner = paramFloat;
      init(paramBoolean1);
      return;
      this.mFrameNumber = 1;
      this.mExtData[0] = 100;
    }
  }
  
  public static Rect getImageSize(File paramFile, boolean paramBoolean)
  {
    if (!paramFile.exists()) {
      return new Rect(0, 0, 0, 0);
    }
    int i;
    if (mIsGIFEngineAvaliable)
    {
      i = nativeInit(paramFile.getPath(), paramBoolean);
      nativeGetWidth(i);
      nativeGetHeight(i);
      nativeUnInit(i);
    }
    for (;;)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
      return new Rect(0, 0, localOptions.outWidth, localOptions.outHeight);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
      i = localOptions.outWidth;
      i = localOptions.outHeight;
    }
  }
  
  public static String getSoLibPath(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = paramContext.getFilesDir();
    } while (paramContext == null);
    return paramContext.getParent() + "/txlib/";
  }
  
  private void init(boolean paramBoolean)
  {
    getNextFrame();
    applyNextFrame();
    if (paramBoolean) {}
    try
    {
      this.mFirstFrameBitmap = this.mCurrentFrameBitmap;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void initSize(int paramInt1, int paramInt2)
  {
    Rect localRect = getImageSize();
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
          break label109;
        }
      }
    }
    for (;;)
    {
      j = k;
      i = m;
      if (f1 < 1.0F)
      {
        i = (int)(m * f1);
        j = (int)(k * f1);
      }
      this.mReqWidth = i;
      this.mReqHeight = j;
      return;
      label109:
      f1 = f2;
    }
  }
  
  public static boolean isGifEngineAvail()
  {
    loadLibrary();
    return mIsGIFEngineAvaliable == true;
  }
  
  private static void loadLibrary()
  {
    boolean bool2 = false;
    Object localObject = null;
    boolean bool1 = bool2;
    if (URLDrawable.mApplicationContext != null)
    {
      SharedPreferences localSharedPreferences = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
      localObject = localSharedPreferences;
      bool1 = bool2;
      if (localSharedPreferences != null)
      {
        bool1 = localSharedPreferences.getBoolean("gif_so_is_update", false);
        localObject = localSharedPreferences;
      }
    }
    if (((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) || (bool1)) {}
    try
    {
      System.load(getSoLibPath(URLDrawable.mApplicationContext) + "libkIndexGif.so");
      mIsGIFEngineAvaliable = true;
      if (localObject != null) {
        localObject.edit().putBoolean("gif_so_is_update", false).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NativeGifIndex8", 2, "libkIndexGif.so is loaded. gifIsUpdate:" + bool1);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NativeGifIndex8", 2, "loadLibrary(): " + localUnsatisfiedLinkError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NativeGifIndex8", 2, "loadLibrary(): " + localException.getMessage());
        }
      }
    }
    mIsLibLoaded = true;
  }
  
  private static native Bitmap nativeDecodeNext(int[] paramArrayOfInt, int paramInt);
  
  private static native int nativeGetFrameNum(int paramInt);
  
  private static native int nativeGetHeight(int paramInt);
  
  private static native int nativeGetWidth(int paramInt);
  
  private static native int nativeInit(String paramString, boolean paramBoolean);
  
  private static native boolean nativeIsEnd(int paramInt);
  
  private static native void nativeSetDestSize(int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeSetLoopCount(int paramInt1, int paramInt2);
  
  private static native int nativeUnInit(int paramInt);
  
  protected void applyNextFrame() {}
  
  protected void doApplyNextFrame()
  {
    this.mDecodeNextFrameEnd = true;
    super.doApplyNextFrame();
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((this.mFrameNumber <= 1) || (!paramBoolean)) {
      if ((this.mCurrentFrameBitmap != null) && (!this.mCurrentFrameBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
      }
    }
    do
    {
      return;
      URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      return;
      if ((this.mCurrentFrameBitmap != null) && (!this.mCurrentFrameBitmap.isRecycled())) {}
      try
      {
        paramCanvas.drawBitmap(this.mCurrentFrameBitmap, null, paramRect, paramPaint);
        if ((this.mLastBitmap != null) && (!this.mLastBitmap.isRecycled()) && (!this.mIsFirstBitmap))
        {
          this.mLastBitmap.recycle();
          this.mIsFirstBitmap = false;
        }
        if ((this.mCurrentFrameBitmap != null) && (!this.mCurrentFrameBitmap.isRecycled())) {
          this.mLastBitmap = this.mCurrentFrameBitmap;
        }
        if (!sPaused)
        {
          executeNewTask();
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("NativeGifIndex8", 2, paramCanvas.getMessage());
          }
          URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
        }
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
      l2 = this.mExtData[0];
    }
    try
    {
      ThreadManagerV2.excute(new NativeDecodeFrameTask(l1 + l2), 64, null, true);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("URLDrawable_", 2, "executeNewTask->" + localRejectedExecutionException.getMessage());
      }
      URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("URLDrawable_", 2, "executeNewTask->" + localException.getMessage());
      }
      URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    int i = this.mGifHandler;
    this.mGifHandler = 0;
    if (mIsGIFEngineAvaliable) {
      nativeUnInit(i);
    }
    super.finalize();
  }
  
  public int getByteSize()
  {
    if (mIsGIFEngineAvaliable) {}
    return (int)(0L + Utils.getBitmapSize(this.mCurrentFrameBitmap) + Utils.getBitmapSize(this.mFirstFrameBitmap));
  }
  
  public NativeGifIOException.NativeGifError getError()
  {
    return NativeGifIOException.NativeGifError.fromCode(this.mExtData[1]);
  }
  
  public int getHeight()
  {
    if (this.mGifHandler != 0) {
      return nativeGetHeight(this.mGifHandler);
    }
    return 0;
  }
  
  public Rect getImageSize()
  {
    int j;
    if (mIsGIFEngineAvaliable) {
      j = nativeGetWidth(this.mGifHandler);
    }
    BitmapFactory.Options localOptions;
    for (int i = nativeGetHeight(this.mGifHandler);; i = localOptions.outHeight)
    {
      return new Rect(0, 0, j, i);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mSrcGifFile, localOptions);
      j = localOptions.outWidth;
    }
  }
  
  /* Error */
  protected void getNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 38	com/tencent/image/NativeGifIndex8:mIsGIFEngineAvaliable	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifeq +117 -> 124
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 104	com/tencent/image/NativeGifIndex8:mExtData	[I
    //   15: aload_0
    //   16: getfield 53	com/tencent/image/NativeGifIndex8:mGifHandler	I
    //   19: invokestatic 377	com/tencent/image/NativeGifIndex8:nativeDecodeNext	([II)Landroid/graphics/Bitmap;
    //   22: putfield 197	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   25: aload_0
    //   26: getfield 197	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   29: ifnull +12 -> 41
    //   32: aload_0
    //   33: getfield 104	com/tencent/image/NativeGifIndex8:mExtData	[I
    //   36: iconst_1
    //   37: iaload
    //   38: ifeq +38 -> 76
    //   41: getstatic 220	com/tencent/image/URLDrawable:mApplicationContext	Landroid/content/Context;
    //   44: ldc 222
    //   46: iconst_4
    //   47: invokevirtual 226	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +24 -> 76
    //   55: aload_3
    //   56: invokeinterface 247 1 0
    //   61: ldc_w 297
    //   64: iconst_0
    //   65: invokeinterface 253 3 0
    //   70: invokeinterface 256 1 0
    //   75: pop
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_3
    //   80: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq -58 -> 25
    //   86: ldc 16
    //   88: iconst_2
    //   89: aload_3
    //   90: invokevirtual 378	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   93: invokestatic 312	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: goto -71 -> 25
    //   99: astore_3
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq -83 -> 25
    //   111: ldc 16
    //   113: iconst_2
    //   114: aload_3
    //   115: invokevirtual 379	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   118: invokestatic 312	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: goto -96 -> 25
    //   124: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +12 -> 139
    //   130: ldc 16
    //   132: iconst_2
    //   133: ldc_w 381
    //   136: invokestatic 312	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_0
    //   140: getfield 116	com/tencent/image/NativeGifIndex8:mReqHeight	I
    //   143: ifle -67 -> 76
    //   146: aload_0
    //   147: getfield 114	com/tencent/image/NativeGifIndex8:mReqWidth	I
    //   150: istore_1
    //   151: iload_1
    //   152: ifle -76 -> 76
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 77	com/tencent/image/NativeGifIndex8:mSrcGifFile	Ljava/lang/String;
    //   160: invokestatic 384	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   163: putfield 197	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 197	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   171: aload_0
    //   172: getfield 114	com/tencent/image/NativeGifIndex8:mReqWidth	I
    //   175: aload_0
    //   176: getfield 116	com/tencent/image/NativeGifIndex8:mReqHeight	I
    //   179: iconst_1
    //   180: invokestatic 388	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   183: putfield 197	com/tencent/image/NativeGifIndex8:mCurrentFrameBitmap	Landroid/graphics/Bitmap;
    //   186: goto -110 -> 76
    //   189: astore_3
    //   190: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq -117 -> 76
    //   196: ldc 16
    //   198: iconst_2
    //   199: new 88	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 390
    //   209: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_3
    //   213: invokevirtual 378	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: goto -149 -> 76
    //   228: astore_3
    //   229: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -156 -> 76
    //   235: ldc 16
    //   237: iconst_2
    //   238: new 88	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 392
    //   248: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_3
    //   252: invokevirtual 309	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: goto -188 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	NativeGifIndex8
    //   150	2	1	i	int
    //   5	2	2	bool	boolean
    //   50	6	3	localSharedPreferences	SharedPreferences
    //   79	11	3	localOutOfMemoryError1	OutOfMemoryError
    //   99	4	3	localObject	Object
    //   104	11	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   189	24	3	localOutOfMemoryError2	OutOfMemoryError
    //   228	24	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	25	79	java/lang/OutOfMemoryError
    //   2	6	99	finally
    //   10	25	99	finally
    //   25	41	99	finally
    //   41	51	99	finally
    //   55	76	99	finally
    //   80	96	99	finally
    //   105	121	99	finally
    //   124	139	99	finally
    //   139	151	99	finally
    //   155	186	99	finally
    //   190	225	99	finally
    //   229	264	99	finally
    //   10	25	104	java/lang/IllegalArgumentException
    //   155	186	189	java/lang/OutOfMemoryError
    //   155	186	228	java/lang/Throwable
  }
  
  public int getWidth()
  {
    if (this.mGifHandler != 0) {
      return nativeGetWidth(this.mGifHandler);
    }
    return 0;
  }
  
  class NativeDecodeFrameTask
    implements Runnable
  {
    final long mNextFrameTime;
    
    public NativeDecodeFrameTask(long paramLong)
    {
      this.mNextFrameTime = paramLong;
    }
    
    public void run()
    {
      NativeGifIndex8.this.getNextFrame();
      NativeGifIndex8.NativeDecodeFrameTask.1 local1;
      if (NativeGifIndex8.this.mFrameNumber > 1)
      {
        long l = SystemClock.uptimeMillis();
        local1 = new NativeGifIndex8.NativeDecodeFrameTask.1(this);
        if (l < this.mNextFrameTime) {
          AbstractGifImage.sUIThreadHandler.postDelayed(local1, this.mNextFrameTime - l);
        }
      }
      else
      {
        return;
      }
      AbstractGifImage.sUIThreadHandler.post(local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifIndex8
 * JD-Core Version:    0.7.0.1
 */