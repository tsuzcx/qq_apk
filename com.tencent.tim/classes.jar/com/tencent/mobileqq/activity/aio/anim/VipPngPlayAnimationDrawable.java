package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import aqft;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import wnv;

public class VipPngPlayAnimationDrawable
  extends Drawable
  implements Runnable
{
  public a a;
  public wnv a;
  public Object bN;
  private Rect ba = new Rect();
  private int bgJ = -1;
  public Bitmap dC;
  public int mCurFrameIndex = -1;
  public boolean mDecodeNextFrameEnd = true;
  public boolean mFinished;
  private int mFrameCount;
  public int mFrameDelay = 50;
  public int mHeight;
  public int mLayoutHeight;
  public int mLayoutWidth;
  private Paint mPaint = new Paint(6);
  public boolean mPaused;
  public int mRepeatCount;
  public Resources mResources;
  public boolean mReverse;
  public int mType = -1;
  public int mWidth;
  public Handler sHandler = new Handler(Looper.getMainLooper());
  
  public VipPngPlayAnimationDrawable(Resources paramResources)
  {
    this.jdField_a_of_type_Wnv = new wnv();
    this.mResources = paramResources;
  }
  
  public void B(String[] paramArrayOfString)
    throws IOException
  {
    if ((this.mType == 0) && (Arrays.equals((String[])this.bN, paramArrayOfString))) {
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    String str = paramArrayOfString[0];
    if (str.startsWith("file:///android_assets/bubbles/"))
    {
      paramArrayOfString = str.substring("file:///android_assets/".length());
      paramArrayOfString = this.mResources.getAssets().open(paramArrayOfString);
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      if (paramArrayOfString == null) {}
    }
    for (;;)
    {
      try
      {
        paramArrayOfString.close();
        this.mWidth = aqft.scaleFromDensity(localOptions.outWidth, 320, this.mResources.getDisplayMetrics().densityDpi);
        this.mHeight = aqft.scaleFromDensity(localOptions.outHeight, 320, this.mResources.getDisplayMetrics().densityDpi);
        this.mLayoutWidth = this.mWidth;
        this.mLayoutHeight = this.mHeight;
        return;
      }
      catch (IOException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        continue;
      }
      paramArrayOfString = new BufferedInputStream(new FileInputStream(paramArrayOfString[0]));
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      paramArrayOfString.close();
    }
  }
  
  @TargetApi(11)
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    Object localObject = new BitmapFactory.Options();
    switch (paramInt1)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      paramObject = (int[])paramObject;
      paramInt1 = paramObject[((paramInt2 + 1) % paramObject.length)];
      return BitmapFactory.decodeResource(this.mResources, paramInt1, (BitmapFactory.Options)localObject);
    }
    paramObject = (String[])paramObject;
    paramObject = paramObject[((paramInt2 + 1) % paramObject.length)];
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = this.mResources.getDisplayMetrics().densityDpi;
    if (paramObject.startsWith("file:///android_assets/bubbles/"))
    {
      paramObject = paramObject.substring("file:///android_assets/".length());
      paramObject = new BufferedInputStream(this.mResources.getAssets().open(paramObject));
    }
    for (;;)
    {
      localObject = BitmapFactory.decodeStream(paramObject, null, (BitmapFactory.Options)localObject);
      if (paramObject != null) {}
      try
      {
        paramObject.close();
        return localObject;
        paramObject = new BufferedInputStream(new FileInputStream(paramObject));
      }
      catch (IOException paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
      }
    }
  }
  
  protected void bZN()
  {
    if ((this.mType == 1) && (this.mCurFrameIndex >= 0)) {
      this.sHandler.postDelayed(this, this.mFrameDelay);
    }
    while ((!this.mDecodeNextFrameEnd) || (this.mPaused)) {
      return;
    }
    this.mDecodeNextFrameEnd = false;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mFrameDelay;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$a = new a(this.bN);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$a.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.mCurFrameIndex), Long.valueOf(this.mType) });
  }
  
  public void c(String[] paramArrayOfString, int paramInt)
  {
    if ((this.mType == 0) && (Arrays.equals((String[])this.bN, paramArrayOfString))) {
      return;
    }
    recycle();
    this.mType = 0;
    this.bN = paramArrayOfString;
    this.mFrameCount = paramArrayOfString.length;
    this.mFrameDelay = paramInt;
    this.mFinished = false;
  }
  
  protected int ce(int paramInt)
  {
    if (paramInt == this.mFrameCount - 1)
    {
      this.mRepeatCount -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mType == -1) {
      return;
    }
    Rect localRect2;
    int i;
    if (this.mCurFrameIndex != -1)
    {
      localRect2 = super.getBounds();
      if (!this.mReverse) {
        break label192;
      }
      i = paramCanvas.save();
      paramCanvas.scale(-1.0F, 1.0F, localRect2.centerX(), localRect2.centerY());
    }
    for (;;)
    {
      if (this.mType == 1) {}
      label100:
      while (((this.mType != 0) && (this.mType != 2)) || (this.jdField_a_of_type_Wnv == null))
      {
        if (this.mReverse) {
          paramCanvas.restoreToCount(i);
        }
        if (this.mRepeatCount != 0) {
          break label182;
        }
        if ((102 != this.bgJ) && (103 != this.bgJ)) {
          break;
        }
        super.invalidateSelf();
        this.mFinished = true;
        return;
      }
      if (this.mLayoutWidth > 0) {}
      for (Rect localRect1 = new Rect(0, 0, this.mLayoutWidth, getIntrinsicHeight());; localRect1 = null)
      {
        this.jdField_a_of_type_Wnv.a(paramCanvas, localRect1, localRect2, this.mPaint);
        break;
        recycle();
        break label100;
        label182:
        bZN();
        return;
      }
      label192:
      i = 0;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStarted()
  {
    return (!this.mFinished) && (this.mCurFrameIndex >= 0);
  }
  
  public void recycle()
  {
    if (this.jdField_a_of_type_Wnv != null) {
      this.jdField_a_of_type_Wnv.recycle();
    }
    if (this.dC != null)
    {
      this.dC.recycle();
      this.dC = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$a.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$a = null;
    }
    this.mType = -1;
    this.mDecodeNextFrameEnd = true;
    this.mCurFrameIndex = -1;
    this.mFrameDelay = 50;
    this.mRepeatCount = -1;
    this.mFinished = true;
  }
  
  public void run()
  {
    if (this.dC == null) {}
    do
    {
      return;
      this.mDecodeNextFrameEnd = true;
      this.mCurFrameIndex = ce(this.mCurFrameIndex);
    } while ((this.mType == -1) || (this.dC == null) || (this.jdField_a_of_type_Wnv.mBitmap == this.dC));
    this.jdField_a_of_type_Wnv.recycle();
    this.jdField_a_of_type_Wnv.D(this.dC);
    this.dC = null;
    super.invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setCurrentType(int paramInt)
  {
    this.bgJ = paramInt;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
  
  public void setPaused(boolean paramBoolean)
  {
    this.mPaused = paramBoolean;
    if (!paramBoolean) {
      super.invalidateSelf();
    }
  }
  
  public class a
    extends AsyncTask<Long, Void, Void>
  {
    private Object source;
    
    public a(Object paramObject)
    {
      this.source = paramObject;
    }
    
    protected Void a(Long... paramVarArgs)
    {
      try
      {
        long l1 = paramVarArgs[0].longValue();
        long l2 = paramVarArgs[1].longValue();
        long l3 = paramVarArgs[2].longValue();
        paramVarArgs = VipPngPlayAnimationDrawable.this.a((int)l3, this.source, (int)l2);
        if ((paramVarArgs != null) && (!isCancelled()))
        {
          VipPngPlayAnimationDrawable.this.dC = paramVarArgs;
          l2 = SystemClock.uptimeMillis();
          if (l2 < l1)
          {
            VipPngPlayAnimationDrawable.this.sHandler.postDelayed(VipPngPlayAnimationDrawable.this, l1 - l2);
            return null;
          }
          VipPngPlayAnimationDrawable.this.sHandler.post(VipPngPlayAnimationDrawable.this);
          return null;
        }
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("VipPngPlayAnimationDrawable", 4, "", paramVarArgs);
        }
        VipPngPlayAnimationDrawable.this.dC = null;
        VipPngPlayAnimationDrawable.this.mDecodeNextFrameEnd = true;
        return null;
      }
      catch (Throwable paramVarArgs)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("VipPngPlayAnimationDrawable", 4, "", paramVarArgs);
        }
        VipPngPlayAnimationDrawable.this.dC = null;
        VipPngPlayAnimationDrawable.this.mDecodeNextFrameEnd = true;
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      VipPngPlayAnimationDrawable.this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */