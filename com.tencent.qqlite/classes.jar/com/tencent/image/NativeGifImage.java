package com.tencent.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
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
    loadLibrary();
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
          break label260;
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
      label260:
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
  
  private static void loadLibrary()
  {
    int j = 0;
    if ((!mIsLibLoaded) && (URLDrawable.mApplicationContext != null)) {}
    try
    {
      mIsGIFEngineAvaliable = SoLoadUtilNew.loadSoByName(URLDrawable.mApplicationContext, "GIFEngine");
      i = Color.argb(255, 0, 1, 2);
      localObject = DEFAULT_CONFIG;
      sequence = nativeTestColor(Bitmap.createBitmap(new int[] { i }, 1, 1, (Bitmap.Config)localObject));
      k = 0;
      if (sequence == null) {
        break label231;
      }
      if (sequence.length == 4) {
        break label113;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject;
        int k;
        int m;
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
    if (i != 0)
    {
      localObject = new int[4];
      localObject[1] = 1;
      localObject[2] = 2;
      localObject[3] = 3;
      sequence = (int[])localObject;
    }
    mIsLibLoaded = true;
    return;
    label113:
    localObject = sequence;
    m = localObject.length;
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
  
  protected void applyNextFrame()
  {
    for (;;)
    {
      Object localObject3;
      Object localObject1;
      try
      {
        this.mCurrentFrameIndex = this.mMetaData[CURRENT_FRAMEINDEX_INDEX];
        this.mCurrentLoop = this.mMetaData[CURRENT_LOOP_INDEX];
        if (this.mCurrentFrameBitmapBuffer != null)
        {
          localObject3 = new Canvas(this.mCurrentFrameBitmap);
          this.mCurrentFrameBitmap.eraseColor(0);
          localObject1 = null;
          if (this.mDefaultRoundCorner > 0.0F)
          {
            localObject1 = new Paint();
            ((Paint)localObject1).setAntiAlias(true);
            ((Canvas)localObject3).drawRoundRect(new RectF(0.0F, 0.0F, this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight()), this.mDefaultRoundCorner, this.mDefaultRoundCorner, (Paint)localObject1);
            ((Paint)localObject1).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          }
          ((Canvas)localObject3).drawBitmap(this.mCurrentFrameBitmapBuffer, 0.0F, 0.0F, (Paint)localObject1);
          return;
        }
        float f = this.mDefaultRoundCorner;
        if (f <= 0.0F) {
          continue;
        }
        localObject1 = null;
      }
      finally {}
      try
      {
        localObject3 = Bitmap.createBitmap(this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight(), this.mCurrentConfig);
        localObject1 = localObject3;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (this.mCurrentConfig != Bitmap.Config.ARGB_8888) {
          continue;
        }
        Bitmap localBitmap = Bitmap.createBitmap(this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight(), Bitmap.Config.ARGB_4444);
        continue;
      }
      if (localObject1 != null)
      {
        localObject3 = new Canvas((Bitmap)localObject1);
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        ((Canvas)localObject3).drawRoundRect(new RectF(0.0F, 0.0F, this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight()), this.mDefaultRoundCorner, this.mDefaultRoundCorner, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        ((Canvas)localObject3).drawBitmap(this.mCurrentFrameBitmap, 0.0F, 0.0F, localPaint);
        this.mCurrentFrameBitmap = ((Bitmap)localObject1);
      }
    }
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
      Utils.executeAsyncTaskOnSerialExcuter(new NativeDecodeFrameTask(l1 + l2), null);
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
            NativeGifImage.sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(NativeGifImage.this) });
          }
        };
        if (l < this.mNextFrameTime)
        {
          NativeGifImage.sUIThreadHandler.postDelayed(paramVarArgs, this.mNextFrameTime - l);
          return null;
        }
        NativeGifImage.sUIThreadHandler.post(paramVarArgs);
        return null;
      }
      NativeGifImage.this.mDecodeNextFrameEnd = true;
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifImage
 * JD-Core Version:    0.7.0.1
 */