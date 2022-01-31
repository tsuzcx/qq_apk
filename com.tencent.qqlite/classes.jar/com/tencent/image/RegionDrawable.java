package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class RegionDrawable
  extends Drawable
  implements RegionBitmap.OnUpdateCallback
{
  private static final int CACHED_RECT_SCALE = 5;
  private static final int DEFAULT_PAINT_FLAGS = 6;
  public static final String TAG = "RegionDrawable";
  private boolean mApplyGravity;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private Rect mDrawRect = new Rect();
  private final Rect mDstRect = new Rect();
  private Handler mMainHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (Rect.class.isInstance(paramAnonymousMessage.obj))
      {
        RegionDrawable.this.mDrawRect.set((Rect)paramAnonymousMessage.obj);
        RegionDrawable.this.invalidateSelf();
      }
    }
  };
  private boolean mMutated;
  private RegionBitmap mRegionBitmap;
  private RegionState mRegionState;
  private boolean mShowRegion;
  private int mTargetDensity;
  private Rect mUpdateRect = new Rect();
  
  @Deprecated
  public RegionDrawable()
  {
    this.mRegionState = new RegionState(null, null);
  }
  
  @Deprecated
  public RegionDrawable(Resources paramResources)
  {
    this.mRegionState = new RegionState(null, null);
    this.mRegionState.mTargetDensity = this.mTargetDensity;
  }
  
  public RegionDrawable(Resources paramResources, Bitmap paramBitmap, String paramString)
  {
    this(new RegionState(paramBitmap, paramString), paramResources);
    this.mRegionState.mTargetDensity = this.mTargetDensity;
  }
  
  @Deprecated
  public RegionDrawable(Bitmap paramBitmap)
  {
    this(new RegionState(paramBitmap, null), null);
  }
  
  private RegionDrawable(RegionState paramRegionState, Resources paramResources)
  {
    this.mRegionState = paramRegionState;
    if (paramResources != null)
    {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      if (paramRegionState == null) {
        break label116;
      }
    }
    label116:
    for (paramResources = paramRegionState.mBitmap;; paramResources = null)
    {
      setBitmap(paramResources);
      paramResources = localObject;
      if (paramRegionState != null) {
        paramResources = paramRegionState.mRegionBitmap;
      }
      setRegionBitmap(paramResources);
      return;
      this.mTargetDensity = paramRegionState.mTargetDensity;
      break;
    }
  }
  
  private Rect calcCachedArea(Rect paramRect1, Rect paramRect2)
  {
    int i = paramRect2.width() / 10;
    int j = paramRect2.height() / 10;
    paramRect2 = new Rect(paramRect2.left - i, paramRect2.top - j, paramRect2.right + i, paramRect2.bottom + j);
    paramRect2.intersect(paramRect1);
    return paramRect2;
  }
  
  private void computeBitmapSize()
  {
    this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
    this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
  }
  
  private void setBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != this.mBitmap)
    {
      this.mBitmap = paramBitmap;
      if (paramBitmap == null) {
        break label26;
      }
      computeBitmapSize();
    }
    for (;;)
    {
      invalidateSelf();
      return;
      label26:
      this.mBitmapHeight = -1;
      this.mBitmapWidth = -1;
    }
  }
  
  private void setRegionBitmap(RegionBitmap paramRegionBitmap)
  {
    if (paramRegionBitmap != this.mRegionBitmap)
    {
      this.mRegionBitmap = paramRegionBitmap;
      paramRegionBitmap.setOnUpdateCallback(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    RegionState localRegionState;
    Object localObject2;
    Shader.TileMode localTileMode;
    if (localBitmap != null)
    {
      localRegionState = this.mRegionState;
      if (localRegionState.mRebuildShader)
      {
        localObject2 = localRegionState.mTileModeX;
        localTileMode = localRegionState.mTileModeY;
        if ((localObject2 != null) || (localTileMode != null)) {
          break label166;
        }
        localRegionState.mPaint.setShader(null);
        localRegionState.mRebuildShader = false;
        copyBounds(this.mDstRect);
      }
      if (localRegionState.mPaint.getShader() != null) {
        break label215;
      }
      if (this.mApplyGravity)
      {
        Gravity.apply(localRegionState.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
        this.mApplyGravity = false;
      }
      paramCanvas.drawBitmap(localBitmap, null, this.mDstRect, localRegionState.mPaint);
    }
    for (;;)
    {
      if ((this.mShowRegion) && (this.mRegionBitmap != null)) {
        this.mRegionBitmap.draw(paramCanvas, this.mDrawRect, localRegionState.mPaint);
      }
      return;
      label166:
      Paint localPaint = localRegionState.mPaint;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Shader.TileMode.CLAMP;
      }
      localObject2 = localTileMode;
      if (localTileMode == null) {
        localObject2 = Shader.TileMode.CLAMP;
      }
      localPaint.setShader(new BitmapShader(localBitmap, (Shader.TileMode)localObject1, (Shader.TileMode)localObject2));
      break;
      label215:
      if (this.mApplyGravity)
      {
        copyBounds(this.mDstRect);
        this.mApplyGravity = false;
      }
      paramCanvas.drawRect(this.mDstRect, localRegionState.mPaint);
    }
  }
  
  public int getAlpha()
  {
    return this.mRegionState.mPaint.getAlpha();
  }
  
  public final Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mRegionState.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.mRegionState.mChangingConfigurations = getChangingConfigurations();
    return this.mRegionState;
  }
  
  public int getGravity()
  {
    return this.mRegionState.mGravity;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmapWidth;
  }
  
  public int getOpacity()
  {
    if (this.mRegionState.mGravity != 119) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mRegionState.mPaint.getAlpha() < 255));
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.mRegionState.mPaint;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.mRegionState.mTileModeX;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.mRegionState.mTileModeY;
  }
  
  public boolean hasAntiAlias()
  {
    return this.mRegionState.mPaint.isAntiAlias();
  }
  
  public boolean hasMipMap()
  {
    return (this.mRegionState.mBitmap != null) && (this.mRegionState.mBitmap.hasMipMap());
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {}
  
  public final boolean isAutoMirrored()
  {
    return this.mRegionState.mAutoMirrored;
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mRegionState = new RegionState(this.mRegionState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void recycle()
  {
    if (this.mRegionBitmap == null) {
      return;
    }
    this.mRegionBitmap.recycle();
  }
  
  public void regionRefreshed(Rect paramRect)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.mDrawRect.set(paramRect);
      invalidateSelf();
      return;
    }
    this.mMainHandler.sendMessage(this.mMainHandler.obtainMessage(0, paramRect));
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mRegionState.mPaint.getAlpha())
    {
      this.mRegionState.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.mRegionState.mPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mRegionState.mAutoMirrored != paramBoolean)
    {
      this.mRegionState.mAutoMirrored = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mRegionState.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mRegionState.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mRegionState.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mRegionState.mGravity != paramInt)
    {
      this.mRegionState.mGravity = paramInt;
      this.mApplyGravity = true;
      invalidateSelf();
    }
  }
  
  public void setMipMap(boolean paramBoolean)
  {
    if (this.mRegionState.mBitmap != null)
    {
      this.mRegionState.mBitmap.setHasMipMap(paramBoolean);
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (this.mTargetDensity != paramInt)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      if (this.mBitmap != null) {
        computeBitmapSize();
      }
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    setTileModeXY(paramTileMode, this.mRegionState.mTileModeY);
  }
  
  public void setTileModeXY(Shader.TileMode paramTileMode1, Shader.TileMode paramTileMode2)
  {
    RegionState localRegionState = this.mRegionState;
    if ((localRegionState.mTileModeX != paramTileMode1) || (localRegionState.mTileModeY != paramTileMode2))
    {
      localRegionState.mTileModeX = paramTileMode1;
      localRegionState.mTileModeY = paramTileMode2;
      localRegionState.mRebuildShader = true;
      invalidateSelf();
    }
  }
  
  public final void setTileModeY(Shader.TileMode paramTileMode)
  {
    setTileModeXY(this.mRegionState.mTileModeX, paramTileMode);
  }
  
  public void setXfermode(Xfermode paramXfermode)
  {
    this.mRegionState.mPaint.setXfermode(paramXfermode);
    invalidateSelf();
  }
  
  public void updateRegionRect(Rect paramRect1, Rect paramRect2, boolean paramBoolean, float paramFloat)
  {
    this.mShowRegion = paramBoolean;
    if (!paramBoolean)
    {
      this.mUpdateRect.setEmpty();
      invalidateSelf();
    }
    while ((!this.mUpdateRect.isEmpty()) && (this.mUpdateRect.contains(paramRect2))) {
      return;
    }
    this.mUpdateRect.set(calcCachedArea(paramRect1, paramRect2));
    this.mRegionBitmap.updateRegionBitmap(this.mUpdateRect, getBitmap().getDensity(), this.mTargetDensity, paramFloat);
  }
  
  static final class RegionState
    extends Drawable.ConstantState
  {
    boolean mAutoMirrored;
    Bitmap mBitmap;
    int mChangingConfigurations;
    int mGravity = 119;
    Paint mPaint = new Paint(6);
    boolean mRebuildShader;
    RegionBitmap mRegionBitmap;
    int mTargetDensity = 160;
    Shader.TileMode mTileModeX = null;
    Shader.TileMode mTileModeY = null;
    
    RegionState(Bitmap paramBitmap, String paramString)
    {
      this.mBitmap = paramBitmap;
      this.mRegionBitmap = new RegionBitmap(paramString);
    }
    
    RegionState(RegionState paramRegionState)
    {
      this(paramRegionState.mBitmap, null);
      this.mChangingConfigurations = paramRegionState.mChangingConfigurations;
      this.mGravity = paramRegionState.mGravity;
      this.mTileModeX = paramRegionState.mTileModeX;
      this.mTileModeY = paramRegionState.mTileModeY;
      this.mTargetDensity = paramRegionState.mTargetDensity;
      this.mPaint = new Paint(paramRegionState.mPaint);
      this.mRebuildShader = paramRegionState.mRebuildShader;
      this.mAutoMirrored = paramRegionState.mAutoMirrored;
    }
    
    public Bitmap getBitmap()
    {
      return this.mBitmap;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new RegionDrawable(this, null, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new RegionDrawable(this, paramResources, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.image.RegionDrawable
 * JD-Core Version:    0.7.0.1
 */